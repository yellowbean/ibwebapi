(ns client-portal-web-api.api.contract
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


(defn-spec iserver-contract-conid-algos-get-with-http-info any?
  "IB Algo Params
  Returns supported IB Algos for contract. Must be called a second time to query the list of available parameters."
  ([conid string?, ] (iserver-contract-conid-algos-get-with-http-info conid nil))
  ([conid string?, {:keys [algos addDescription addParams]} (s/map-of keyword? any?)]
   (check-required-params conid)
   (call-api "/iserver/contract/{conid}/algos" :get
             {:path-params   {"conid" conid }
              :header-params {}
              :query-params  {"algos" algos "addDescription" addDescription "addParams" addParams }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    []})))

(defn-spec iserver-contract-conid-algos-get (s/coll-of inline-response-200-29-spec)
  "IB Algo Params
  Returns supported IB Algos for contract. Must be called a second time to query the list of available parameters."
  ([conid string?, ] (iserver-contract-conid-algos-get conid nil))
  ([conid string?, optional-params any?]
   (let [res (:data (iserver-contract-conid-algos-get-with-http-info conid optional-params))]
     (if (:decode-models *api-context*)
        (st/decode (s/coll-of inline-response-200-29-spec) res st/string-transformer)
        res))))


(defn-spec iserver-contract-conid-info-and-rules-get-with-http-info any?
  "Info and Rules
  Returns both contract info and rules from a single endpoint.
For only contract rules, use the endpoint /iserver/contract/rules.
For only contract info, use the endpoint /iserver/contract/{conid}/info."
  [conid string?, isBuy boolean?]
  (check-required-params conid isBuy)
  (call-api "/iserver/contract/{conid}/info-and-rules" :get
            {:path-params   {"conid" conid }
             :header-params {}
             :query-params  {"isBuy" isBuy }
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec iserver-contract-conid-info-and-rules-get inline-response-200-31-spec
  "Info and Rules
  Returns both contract info and rules from a single endpoint.
For only contract rules, use the endpoint /iserver/contract/rules.
For only contract info, use the endpoint /iserver/contract/{conid}/info."
  [conid string?, isBuy boolean?]
  (let [res (:data (iserver-contract-conid-info-and-rules-get-with-http-info conid isBuy))]
    (if (:decode-models *api-context*)
       (st/decode inline-response-200-31-spec res st/string-transformer)
       res)))


(defn-spec iserver-contract-conid-info-get-with-http-info any?
  "Contract Details
  Using the Contract Identifier get contract info. You can use this to prefill your order before you submit an order"
  [conid string?]
  (check-required-params conid)
  (call-api "/iserver/contract/{conid}/info" :get
            {:path-params   {"conid" conid }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec iserver-contract-conid-info-get contract-spec
  "Contract Details
  Using the Contract Identifier get contract info. You can use this to prefill your order before you submit an order"
  [conid string?]
  (let [res (:data (iserver-contract-conid-info-get-with-http-info conid))]
    (if (:decode-models *api-context*)
       (st/decode contract-spec res st/string-transformer)
       res)))


(defn-spec iserver-contract-rules-post-with-http-info any?
  "Contract Rules
  Returns trading related rules for a specific contract and side. For both contract info and rules use the endpoint /iserver/contract/{conid}/info-and-rules."
  [conid inline-object-14]
  (check-required-params conid)
  (call-api "/iserver/contract/rules" :post
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    conid
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec iserver-contract-rules-post inline-response-200-30-spec
  "Contract Rules
  Returns trading related rules for a specific contract and side. For both contract info and rules use the endpoint /iserver/contract/{conid}/info-and-rules."
  [conid inline-object-14]
  (let [res (:data (iserver-contract-rules-post-with-http-info conid))]
    (if (:decode-models *api-context*)
       (st/decode inline-response-200-30-spec res st/string-transformer)
       res)))


(defn-spec iserver-secdef-info-get-with-http-info any?
  "Secdef Info
  Provides Contract Details of Futures, Options, Warrants, Cash and CFDs based on conid. To get the strike price for Options/Warrants use \"/iserver/secdef/strikes\" endpoint. Must call /secdef/search for the underlying contract first."
  ([conid string?, sectype string?, ] (iserver-secdef-info-get-with-http-info conid sectype nil))
  ([conid string?, sectype string?, {:keys [month exchange strike right]} (s/map-of keyword? any?)]
   (check-required-params conid sectype)
   (call-api "/iserver/secdef/info" :get
             {:path-params   {}
              :header-params {}
              :query-params  {"conid" conid "sectype" sectype "month" month "exchange" exchange "strike" strike "right" right }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    []})))

(defn-spec iserver-secdef-info-get any?
  "Secdef Info
  Provides Contract Details of Futures, Options, Warrants, Cash and CFDs based on conid. To get the strike price for Options/Warrants use \"/iserver/secdef/strikes\" endpoint. Must call /secdef/search for the underlying contract first."
  ([conid string?, sectype string?, ] (iserver-secdef-info-get conid sectype nil))
  ([conid string?, sectype string?, optional-params any?]
   (let [res (:data (iserver-secdef-info-get-with-http-info conid sectype optional-params))]
     (if (:decode-models *api-context*)
        (st/decode any? res st/string-transformer)
        res))))


(defn-spec iserver-secdef-search-post-with-http-info any?
  "Search by Symbol or Name
  Search by underlying symbol or company name. Relays back what derivative contract(s) it has. This endpoint must be called before using /secdef/info.
If company name is specified will only receive limited response: conid, companyName, companyHeader and symbol."
  [symbol inline-object-13]
  (check-required-params symbol)
  (call-api "/iserver/secdef/search" :post
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    symbol
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec iserver-secdef-search-post (s/coll-of inline-response-200-27-spec)
  "Search by Symbol or Name
  Search by underlying symbol or company name. Relays back what derivative contract(s) it has. This endpoint must be called before using /secdef/info.
If company name is specified will only receive limited response: conid, companyName, companyHeader and symbol."
  [symbol inline-object-13]
  (let [res (:data (iserver-secdef-search-post-with-http-info symbol))]
    (if (:decode-models *api-context*)
       (st/decode (s/coll-of inline-response-200-27-spec) res st/string-transformer)
       res)))


(defn-spec iserver-secdef-strikes-get-with-http-info any?
  "Search Strikes
  Query strikes for Options/Warrants. For the conid of the underlying contract, available contract months and exchanges use \"/iserver/secdef/search\""
  ([conid string?, sectype string?, month string?, ] (iserver-secdef-strikes-get-with-http-info conid sectype month nil))
  ([conid string?, sectype string?, month string?, {:keys [exchange]} (s/map-of keyword? any?)]
   (check-required-params conid sectype month)
   (call-api "/iserver/secdef/strikes" :get
             {:path-params   {}
              :header-params {}
              :query-params  {"conid" conid "sectype" sectype "month" month "exchange" exchange }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    []})))

(defn-spec iserver-secdef-strikes-get inline-response-200-28-spec
  "Search Strikes
  Query strikes for Options/Warrants. For the conid of the underlying contract, available contract months and exchanges use \"/iserver/secdef/search\""
  ([conid string?, sectype string?, month string?, ] (iserver-secdef-strikes-get conid sectype month nil))
  ([conid string?, sectype string?, month string?, optional-params any?]
   (let [res (:data (iserver-secdef-strikes-get-with-http-info conid sectype month optional-params))]
     (if (:decode-models *api-context*)
        (st/decode inline-response-200-28-spec res st/string-transformer)
        res))))


(defn-spec trsrv-futures-get-with-http-info any?
  "Security Futures by Symbol
  Returns a list of non-expired future contracts for given symbol(s)"
  [symbols string?]
  (check-required-params symbols)
  (call-api "/trsrv/futures" :get
            {:path-params   {}
             :header-params {}
             :query-params  {"symbols" symbols }
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec trsrv-futures-get inline-response-200-1-spec
  "Security Futures by Symbol
  Returns a list of non-expired future contracts for given symbol(s)"
  [symbols string?]
  (let [res (:data (trsrv-futures-get-with-http-info symbols))]
    (if (:decode-models *api-context*)
       (st/decode inline-response-200-1-spec res st/string-transformer)
       res)))


(defn-spec trsrv-secdef-post-with-http-info any?
  "Secdef by Conid
  Returns a list of security definitions for the given conids"
  [body inline-object]
  (check-required-params body)
  (call-api "/trsrv/secdef" :post
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    body
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec trsrv-secdef-post (s/coll-of any?)
  "Secdef by Conid
  Returns a list of security definitions for the given conids"
  [body inline-object]
  (let [res (:data (trsrv-secdef-post-with-http-info body))]
    (if (:decode-models *api-context*)
       (st/decode (s/coll-of any?) res st/string-transformer)
       res)))


(defn-spec trsrv-secdef-schedule-get-with-http-info any?
  "Get trading schedule for symbol
  Returns the trading schedule up to a month for the requested contract"
  ([assetClass string?, symbol string?, ] (trsrv-secdef-schedule-get-with-http-info assetClass symbol nil))
  ([assetClass string?, symbol string?, {:keys [exchange exchangeFilter]} (s/map-of keyword? any?)]
   (check-required-params assetClass symbol)
   (call-api "/trsrv/secdef/schedule" :get
             {:path-params   {}
              :header-params {}
              :query-params  {"assetClass" assetClass "symbol" symbol "exchange" exchange "exchangeFilter" exchangeFilter }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    []})))

(defn-spec trsrv-secdef-schedule-get inline-response-200-spec
  "Get trading schedule for symbol
  Returns the trading schedule up to a month for the requested contract"
  ([assetClass string?, symbol string?, ] (trsrv-secdef-schedule-get assetClass symbol nil))
  ([assetClass string?, symbol string?, optional-params any?]
   (let [res (:data (trsrv-secdef-schedule-get-with-http-info assetClass symbol optional-params))]
     (if (:decode-models *api-context*)
        (st/decode inline-response-200-spec res st/string-transformer)
        res))))


(defn-spec trsrv-stocks-get-with-http-info any?
  "Security Stocks by Symbol
  Returns an object contains all stock contracts for given symbol(s)"
  [symbols string?]
  (check-required-params symbols)
  (call-api "/trsrv/stocks" :get
            {:path-params   {}
             :header-params {}
             :query-params  {"symbols" symbols }
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec trsrv-stocks-get inline-response-200-2-spec
  "Security Stocks by Symbol
  Returns an object contains all stock contracts for given symbol(s)"
  [symbols string?]
  (let [res (:data (trsrv-stocks-get-with-http-info symbols))]
    (if (:decode-models *api-context*)
       (st/decode inline-response-200-2-spec res st/string-transformer)
       res)))


