(ns client-portal-web-api.api.portfolio
  (:require [client-portal-web-api.core :refer [call-api check-required-params with-collection-format *api-context*]]
            [clojure.spec.alpha :as s]
            [spec-tools.core :as st]
            [orchestra.core :refer [defn-spec]]
            [client-portal-web-api.specs.history-result-bars :refer :all]
            [client-portal-web-api.specs.inline-response-200-21-equity :refer :all]
            [client-portal-web-api.specs.inline-response-200-30-fraq-types :refer :all]
            [client-portal-web-api.specs.inline-response-200-12-e :refer :all]
            [client-portal-web-api.specs.inline-response-200-30-can-trade-acct-ids :refer :all]
            [client-portal-web-api.specs.history-data :refer :all]
            [client-portal-web-api.specs.position-data :refer :all]
            [client-portal-web-api.specs.inline-response-200-schedules :refer :all]
            [client-portal-web-api.specs.order :refer :all]
            [client-portal-web-api.specs.inline-response-200-30-string :refer :all]
            [client-portal-web-api.specs.inline-object-10 :refer :all]
            [client-portal-web-api.specs.inline-object-11 :refer :all]
            [client-portal-web-api.specs.inline-object-12 :refer :all]
            [client-portal-web-api.specs.alert-request-conditions :refer :all]
            [client-portal-web-api.specs.inline-object-13 :refer :all]
            [client-portal-web-api.specs.inline-response-200-32-instrument-list :refer :all]
            [client-portal-web-api.specs.inline-object-14 :refer :all]
            [client-portal-web-api.specs.inline-response-200-30-rules :refer :all]
            [client-portal-web-api.specs.inline-object-15 :refer :all]
            [client-portal-web-api.specs.contract :refer :all]
            [client-portal-web-api.specs.transactions :refer :all]
            [client-portal-web-api.specs.scanner-result-contracts :refer :all]
            [client-portal-web-api.specs.inline-response-200-4-subaccounts :refer :all]
            [client-portal-web-api.specs.inline-response-200-9 :refer :all]
            [client-portal-web-api.specs.inline-response-200-8 :refer :all]
            [client-portal-web-api.specs.inline-response-200-7 :refer :all]
            [client-portal-web-api.specs.inline-response-200-6 :refer :all]
            [client-portal-web-api.specs.inline-response-200-5 :refer :all]
            [client-portal-web-api.specs.inline-response-200-4 :refer :all]
            [client-portal-web-api.specs.inline-response-200-3 :refer :all]
            [client-portal-web-api.specs.order-status :refer :all]
            [client-portal-web-api.specs.auth-status :refer :all]
            [client-portal-web-api.specs.inline-response-200-30-order-types :refer :all]
            [client-portal-web-api.specs.modify-order :refer :all]
            [client-portal-web-api.specs.inline-response-200 :refer :all]
            [client-portal-web-api.specs.inline-response-200-30-ibalgo-types :refer :all]
            [client-portal-web-api.specs.-iserver-contract-conid-algos-parameters :refer :all]
            [client-portal-web-api.specs.inline-response-200-4-metadata :refer :all]
            [client-portal-web-api.specs.inline-response-200-19 :refer :all]
            [client-portal-web-api.specs.inline-response-200-18 :refer :all]
            [client-portal-web-api.specs.inline-response-200-17 :refer :all]
            [client-portal-web-api.specs.inline-response-200-16 :refer :all]
            [client-portal-web-api.specs.inline-response-200-15 :refer :all]
            [client-portal-web-api.specs.inline-response-200-14 :refer :all]
            [client-portal-web-api.specs.inline-response-200-13 :refer :all]
            [client-portal-web-api.specs.inline-response-200-12 :refer :all]
            [client-portal-web-api.specs.inline-response-200-11 :refer :all]
            [client-portal-web-api.specs.inline-response-200-10 :refer :all]
            [client-portal-web-api.specs.performance-cps-data :refer :all]
            [client-portal-web-api.specs.ledger :refer :all]
            [client-portal-web-api.specs.inline-response-400-1 :refer :all]
            [client-portal-web-api.specs.alert-request :refer :all]
            [client-portal-web-api.specs.performance-nav :refer :all]
            [client-portal-web-api.specs.secdef-info :refer :all]
            [client-portal-web-api.specs.inline-response-200-30-cqt-types :refer :all]
            [client-portal-web-api.specs.inline-response-200-31-rules :refer :all]
            [client-portal-web-api.specs.inline-response-200-sessions :refer :all]
            [client-portal-web-api.specs.-iserver-secdef-search-sections :refer :all]
            [client-portal-web-api.specs.inline-response-200-32-locations :refer :all]
            [client-portal-web-api.specs.order-data :refer :all]
            [client-portal-web-api.specs.order-request :refer :all]
            [client-portal-web-api.specs.inline-response-500 :refer :all]
            [client-portal-web-api.specs.inline-response-200-30-order-types-outside :refer :all]
            [client-portal-web-api.specs.inline-response-200-32-location-tree :refer :all]
            [client-portal-web-api.specs.stats-data :refer :all]
            [client-portal-web-api.specs.inline-response-200-32-filter-list :refer :all]
            [client-portal-web-api.specs.inline-response-200-39 :refer :all]
            [client-portal-web-api.specs.history-data-data :refer :all]
            [client-portal-web-api.specs.inline-object :refer :all]
            [client-portal-web-api.specs.inline-response-200-38 :refer :all]
            [client-portal-web-api.specs.inline-response-200-37 :refer :all]
            [client-portal-web-api.specs.inline-response-200-36 :refer :all]
            [client-portal-web-api.specs.inline-response-200-35 :refer :all]
            [client-portal-web-api.specs.inline-response-200-34 :refer :all]
            [client-portal-web-api.specs.inline-response-200-33 :refer :all]
            [client-portal-web-api.specs.inline-response-200-32 :refer :all]
            [client-portal-web-api.specs.inline-response-200-31 :refer :all]
            [client-portal-web-api.specs.inline-response-200-30 :refer :all]
            [client-portal-web-api.specs.market-data :refer :all]
            [client-portal-web-api.specs.inline-response-200-21-amount :refer :all]
            [client-portal-web-api.specs.inline-response-200-32-scan-type-list :refer :all]
            [client-portal-web-api.specs.contract-rules :refer :all]
            [client-portal-web-api.specs.calendar-request :refer :all]
            [client-portal-web-api.specs.-hmds-scanner-filters :refer :all]
            [client-portal-web-api.specs.history-result-bars-data :refer :all]
            [client-portal-web-api.specs.inline-response-200-30-order-defaults :refer :all]
            [client-portal-web-api.specs.alert-response-conditions :refer :all]
            [client-portal-web-api.specs.scanner-result :refer :all]
            [client-portal-web-api.specs.inline-response-200-29 :refer :all]
            [client-portal-web-api.specs.inline-response-200-28 :refer :all]
            [client-portal-web-api.specs.inline-response-200-27 :refer :all]
            [client-portal-web-api.specs.system-error :refer :all]
            [client-portal-web-api.specs.inline-response-200-2 :refer :all]
            [client-portal-web-api.specs.inline-response-200-26 :refer :all]
            [client-portal-web-api.specs.inline-response-200-1 :refer :all]
            [client-portal-web-api.specs.inline-response-200-25 :refer :all]
            [client-portal-web-api.specs.inline-response-200-24 :refer :all]
            [client-portal-web-api.specs.inline-response-200-23 :refer :all]
            [client-portal-web-api.specs.inline-response-200-22 :refer :all]
            [client-portal-web-api.specs.performance-tpps :refer :all]
            [client-portal-web-api.specs.history-result :refer :all]
            [client-portal-web-api.specs.inline-response-200-21 :refer :all]
            [client-portal-web-api.specs.inline-response-200-20 :refer :all]
            [client-portal-web-api.specs.inline-object-3 :refer :all]
            [client-portal-web-api.specs.inline-object-2 :refer :all]
            [client-portal-web-api.specs.order-data-warnings :refer :all]
            [client-portal-web-api.specs.inline-object-5 :refer :all]
            [client-portal-web-api.specs.inline-object-4 :refer :all]
            [client-portal-web-api.specs.calendar-request-filters :refer :all]
            [client-portal-web-api.specs.inline-object-7 :refer :all]
            [client-portal-web-api.specs.inline-response-200-18-orders :refer :all]
            [client-portal-web-api.specs.inline-object-6 :refer :all]
            [client-portal-web-api.specs.inline-object-9 :refer :all]
            [client-portal-web-api.specs.inline-object-8 :refer :all]
            [client-portal-web-api.specs.inline-response-400 :refer :all]
            [client-portal-web-api.specs.inline-response-200-39-acct-list :refer :all]
            [client-portal-web-api.specs.inline-object-1 :refer :all]
            [client-portal-web-api.specs.scanner-params-filter :refer :all]
            [client-portal-web-api.specs.alert-response :refer :all]
            [client-portal-web-api.specs.scanner-result-contracts-contract :refer :all]
            [client-portal-web-api.specs.summary :refer :all]
            [client-portal-web-api.specs.inline-response-200-40 :refer :all]
            [client-portal-web-api.specs.set-account :refer :all]
            [client-portal-web-api.specs.scanner-params :refer :all]
            [client-portal-web-api.specs.calendar-request-date :refer :all]
            [client-portal-web-api.specs.performance :refer :all]
            [client-portal-web-api.specs.trade :refer :all]
            [client-portal-web-api.specs.inline-response-200-30-tif-types :refer :all]
            [client-portal-web-api.specs.performance-cps :refer :all]
            [client-portal-web-api.specs.account :refer :all]
            [client-portal-web-api.specs.inline-response-200-trading-times :refer :all]
            [client-portal-web-api.specs.transactions-transactions :refer :all]
            [client-portal-web-api.specs.account-parent :refer :all]
            )
  (:import (java.io File)))


(defn-spec portfolio-account-id-allocation-get-with-http-info any?
  "Account Allocation
  Information about the account's portfolio allocation by Asset Class, Industry and Category.  /portfolio/accounts or /portfolio/subaccounts must be called prior to this endpoint."
  [accountId string?]
  (check-required-params accountId)
  (call-api "/portfolio/{accountId}/allocation" :get
            {:path-params   {"accountId" accountId }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec portfolio-account-id-allocation-get (s/coll-of any?)
  "Account Allocation
  Information about the account's portfolio allocation by Asset Class, Industry and Category.  /portfolio/accounts or /portfolio/subaccounts must be called prior to this endpoint."
  [accountId string?]
  (let [res (:data (portfolio-account-id-allocation-get-with-http-info accountId))]
    (if (:decode-models *api-context*)
       (st/decode (s/coll-of any?) res st/string-transformer)
       res)))


(defn-spec portfolio-account-id-ledger-get-with-http-info any?
  "Account Ledger
  Information regarding settled cash, cash balances, etc. in the account's base currency and any other cash balances hold in other currencies.  /portfolio/accounts or /portfolio/subaccounts must be called prior to this endpoint. The list of supported currencies is available at https://www.interactivebrokers.com/en/index.php?f=3185."
  [accountId string?]
  (check-required-params accountId)
  (call-api "/portfolio/{accountId}/ledger" :get
            {:path-params   {"accountId" accountId }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec portfolio-account-id-ledger-get inline-response-200-6-spec
  "Account Ledger
  Information regarding settled cash, cash balances, etc. in the account's base currency and any other cash balances hold in other currencies.  /portfolio/accounts or /portfolio/subaccounts must be called prior to this endpoint. The list of supported currencies is available at https://www.interactivebrokers.com/en/index.php?f=3185."
  [accountId string?]
  (let [res (:data (portfolio-account-id-ledger-get-with-http-info accountId))]
    (if (:decode-models *api-context*)
       (st/decode inline-response-200-6-spec res st/string-transformer)
       res)))


(defn-spec portfolio-account-id-meta-get-with-http-info any?
  "Account Information
  Account information related to account Id /portfolio/accounts or /portfolio/subaccounts must be called prior to this endpoint."
  [accountId string?]
  (check-required-params accountId)
  (call-api "/portfolio/{accountId}/meta" :get
            {:path-params   {"accountId" accountId }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec portfolio-account-id-meta-get (s/coll-of account-spec)
  "Account Information
  Account information related to account Id /portfolio/accounts or /portfolio/subaccounts must be called prior to this endpoint."
  [accountId string?]
  (let [res (:data (portfolio-account-id-meta-get-with-http-info accountId))]
    (if (:decode-models *api-context*)
       (st/decode (s/coll-of account-spec) res st/string-transformer)
       res)))


(defn-spec portfolio-account-id-position-conid-get-with-http-info any?
  "Position by Conid
  Returns a list of all positions matching the conid. For portfolio models the conid could be in more than one model, returning an array with the name of the model it belongs to.  /portfolio/accounts or /portfolio/subaccounts must be called prior to this endpoint."
  [accountId string?, conid int?]
  (check-required-params accountId conid)
  (call-api "/portfolio/{accountId}/position/{conid}" :get
            {:path-params   {"accountId" accountId "conid" conid }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec portfolio-account-id-position-conid-get (s/coll-of any?)
  "Position by Conid
  Returns a list of all positions matching the conid. For portfolio models the conid could be in more than one model, returning an array with the name of the model it belongs to.  /portfolio/accounts or /portfolio/subaccounts must be called prior to this endpoint."
  [accountId string?, conid int?]
  (let [res (:data (portfolio-account-id-position-conid-get-with-http-info accountId conid))]
    (if (:decode-models *api-context*)
       (st/decode (s/coll-of any?) res st/string-transformer)
       res)))


(defn-spec portfolio-account-id-positions-invalidate-post-with-http-info any?
  "Invalidates the backend cache of the Portfolio"
  [accountId string?]
  (check-required-params accountId)
  (call-api "/portfolio/{accountId}/positions/invalidate" :post
            {:path-params   {"accountId" accountId }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec portfolio-account-id-positions-invalidate-post any?
  "Invalidates the backend cache of the Portfolio"
  [accountId string?]
  (let [res (:data (portfolio-account-id-positions-invalidate-post-with-http-info accountId))]
    (if (:decode-models *api-context*)
       (st/decode any? res st/string-transformer)
       res)))


(defn-spec portfolio-account-id-positions-page-id-get-with-http-info any?
  "Portfolio Positions
  Returns a list of positions for the given account. The endpoint supports paging, page's default size is 30 positions. /portfolio/accounts or /portfolio/subaccounts must be called prior to this endpoint."
  ([accountId string?, pageId string?, ] (portfolio-account-id-positions-page-id-get-with-http-info accountId pageId nil))
  ([accountId string?, pageId string?, {:keys [model sort direction period]} (s/map-of keyword? any?)]
   (check-required-params accountId pageId)
   (call-api "/portfolio/{accountId}/positions/{pageId}" :get
             {:path-params   {"accountId" accountId "pageId" pageId }
              :header-params {}
              :query-params  {"model" model "sort" sort "direction" direction "period" period }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    []})))

(defn-spec portfolio-account-id-positions-page-id-get (s/coll-of any?)
  "Portfolio Positions
  Returns a list of positions for the given account. The endpoint supports paging, page's default size is 30 positions. /portfolio/accounts or /portfolio/subaccounts must be called prior to this endpoint."
  ([accountId string?, pageId string?, ] (portfolio-account-id-positions-page-id-get accountId pageId nil))
  ([accountId string?, pageId string?, optional-params any?]
   (let [res (:data (portfolio-account-id-positions-page-id-get-with-http-info accountId pageId optional-params))]
     (if (:decode-models *api-context*)
        (st/decode (s/coll-of any?) res st/string-transformer)
        res))))


(defn-spec portfolio-account-id-summary-get-with-http-info any?
  "Account Summary
  Returns information about margin, cash balances and other information related to specified account. See also /portfolio/{accountId}/ledger. /portfolio/accounts or /portfolio/subaccounts must be called prior to this endpoint."
  [accountId string?]
  (check-required-params accountId)
  (call-api "/portfolio/{accountId}/summary" :get
            {:path-params   {"accountId" accountId }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec portfolio-account-id-summary-get inline-response-200-5-spec
  "Account Summary
  Returns information about margin, cash balances and other information related to specified account. See also /portfolio/{accountId}/ledger. /portfolio/accounts or /portfolio/subaccounts must be called prior to this endpoint."
  [accountId string?]
  (let [res (:data (portfolio-account-id-summary-get-with-http-info accountId))]
    (if (:decode-models *api-context*)
       (st/decode inline-response-200-5-spec res st/string-transformer)
       res)))


(defn-spec portfolio-accounts-get-with-http-info any?
  "Portfolio Accounts
  In non-tiered account structures, returns a list of accounts for which the user can view position and account information. This endpoint must be called prior to calling other /portfolio endpoints for those accounts. For querying a list of accounts which the user can trade, see /iserver/accounts. For a list of subaccounts in tiered account structures (e.g. financial advisor or ibroker accounts) see /portfolio/subaccounts."
  []
  (call-api "/portfolio/accounts" :get
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec portfolio-accounts-get (s/coll-of account-spec)
  "Portfolio Accounts
  In non-tiered account structures, returns a list of accounts for which the user can view position and account information. This endpoint must be called prior to calling other /portfolio endpoints for those accounts. For querying a list of accounts which the user can trade, see /iserver/accounts. For a list of subaccounts in tiered account structures (e.g. financial advisor or ibroker accounts) see /portfolio/subaccounts."
  []
  (let [res (:data (portfolio-accounts-get-with-http-info))]
    (if (:decode-models *api-context*)
       (st/decode (s/coll-of account-spec) res st/string-transformer)
       res)))


(defn-spec portfolio-allocation-post-with-http-info any?
  "Account Alloction (All Accounts)
  Similar to /portfolio/{accountId}/allocation but returns a consolidated view of of all the accounts returned by /portfolio/accounts. /portfolio/accounts or /portfolio/subaccounts must be called prior to this endpoint."
  [body inline-object-5]
  (check-required-params body)
  (call-api "/portfolio/allocation" :post
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    body
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec portfolio-allocation-post (s/coll-of any?)
  "Account Alloction (All Accounts)
  Similar to /portfolio/{accountId}/allocation but returns a consolidated view of of all the accounts returned by /portfolio/accounts. /portfolio/accounts or /portfolio/subaccounts must be called prior to this endpoint."
  [body inline-object-5]
  (let [res (:data (portfolio-allocation-post-with-http-info body))]
    (if (:decode-models *api-context*)
       (st/decode (s/coll-of any?) res st/string-transformer)
       res)))


(defn-spec portfolio-positions-conid-get-with-http-info any?
  "Positions by Conid
  Returns an object of all positions matching the conid for all the selected accounts. For portfolio models the conid could be in more than one model, returning an array with the name of the model it belongs to. /portfolio/accounts or /portfolio/subaccounts must be called prior to this endpoint."
  [conid int?]
  (check-required-params conid)
  (call-api "/portfolio/positions/{conid}" :get
            {:path-params   {"conid" conid }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec portfolio-positions-conid-get inline-response-200-7-spec
  "Positions by Conid
  Returns an object of all positions matching the conid for all the selected accounts. For portfolio models the conid could be in more than one model, returning an array with the name of the model it belongs to. /portfolio/accounts or /portfolio/subaccounts must be called prior to this endpoint."
  [conid int?]
  (let [res (:data (portfolio-positions-conid-get-with-http-info conid))]
    (if (:decode-models *api-context*)
       (st/decode inline-response-200-7-spec res st/string-transformer)
       res)))


(defn-spec portfolio-subaccounts-get-with-http-info any?
  "List of Sub-Accounts
  Used in tiered account structures (such as Financial Advisor and IBroker Accounts) to return a list of up to 100 sub-accounts for which the user can view position and account-related information. This endpoint must be called prior to calling other /portfolio endpoints for those sub-accounts. If you have more than 100 sub-accounts use /portfolio/subaccounts2. To query a list of accounts the user can trade, see /iserver/accounts."
  []
  (call-api "/portfolio/subaccounts" :get
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec portfolio-subaccounts-get account-spec
  "List of Sub-Accounts
  Used in tiered account structures (such as Financial Advisor and IBroker Accounts) to return a list of up to 100 sub-accounts for which the user can view position and account-related information. This endpoint must be called prior to calling other /portfolio endpoints for those sub-accounts. If you have more than 100 sub-accounts use /portfolio/subaccounts2. To query a list of accounts the user can trade, see /iserver/accounts."
  []
  (let [res (:data (portfolio-subaccounts-get-with-http-info))]
    (if (:decode-models *api-context*)
       (st/decode account-spec res st/string-transformer)
       res)))


(defn-spec portfolio-subaccounts2-get-with-http-info any?
  "List of Sub-Accounts (Large Accounts)
  Used in tiered account structures (such as Financial Advisor and IBroker Accounts) to return a list of sub-accounts, paginated up to 20 accounts per page, for which the user can view position and account-related information. This endpoint must be called prior to calling other /portfolio endpoints for those sub-accounts. If you have less than 100 sub-accounts use /portfolio/subaccounts. To query a list of accounts the user can trade, see /iserver/accounts."
  [page string?]
  (check-required-params page)
  (call-api "/portfolio/subaccounts2" :get
            {:path-params   {"page" page }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec portfolio-subaccounts2-get inline-response-200-4-spec
  "List of Sub-Accounts (Large Accounts)
  Used in tiered account structures (such as Financial Advisor and IBroker Accounts) to return a list of sub-accounts, paginated up to 20 accounts per page, for which the user can view position and account-related information. This endpoint must be called prior to calling other /portfolio endpoints for those sub-accounts. If you have less than 100 sub-accounts use /portfolio/subaccounts. To query a list of accounts the user can trade, see /iserver/accounts."
  [page string?]
  (let [res (:data (portfolio-subaccounts2-get-with-http-info page))]
    (if (:decode-models *api-context*)
       (st/decode inline-response-200-4-spec res st/string-transformer)
       res)))


