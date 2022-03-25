(ns client-portal-web-api.api.portfolio-analyst
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


(defn-spec pa-performance-post-with-http-info any?
  "Account Performance
  Returns the performance (MTM) for the given accounts, if more than one account is passed, the result is consolidated."
  [body inline-object-2]
  (check-required-params body)
  (call-api "/pa/performance" :post
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    body
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec pa-performance-post performance-spec
  "Account Performance
  Returns the performance (MTM) for the given accounts, if more than one account is passed, the result is consolidated."
  [body inline-object-2]
  (let [res (:data (pa-performance-post-with-http-info body))]
    (if (:decode-models *api-context*)
       (st/decode performance-spec res st/string-transformer)
       res)))


(defn-spec pa-summary-post-with-http-info any?
  "Account Balance's Summary
  Returns a summary of all account balances for the given accounts, if more than one account is passed, the result is consolidated."
  [body inline-object-3]
  (check-required-params body)
  (call-api "/pa/summary" :post
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    body
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec pa-summary-post summary-spec
  "Account Balance's Summary
  Returns a summary of all account balances for the given accounts, if more than one account is passed, the result is consolidated."
  [body inline-object-3]
  (let [res (:data (pa-summary-post-with-http-info body))]
    (if (:decode-models *api-context*)
       (st/decode summary-spec res st/string-transformer)
       res)))


(defn-spec pa-transactions-post-with-http-info any?
  "Position's Transaction History
  transaction history for a given number of conids and accounts.
Types of transactions include dividend payments, buy and sell transactions, transfers."
  [body inline-object-4]
  (check-required-params body)
  (call-api "/pa/transactions" :post
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    body
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec pa-transactions-post transactions-spec
  "Position's Transaction History
  transaction history for a given number of conids and accounts.
Types of transactions include dividend payments, buy and sell transactions, transfers."
  [body inline-object-4]
  (let [res (:data (pa-transactions-post-with-http-info body))]
    (if (:decode-models *api-context*)
       (st/decode transactions-spec res st/string-transformer)
       res)))


