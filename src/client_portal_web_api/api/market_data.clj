(ns client-portal-web-api.api.market-data
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


(defn-spec iserver-marketdata-conid-unsubscribe-get-with-http-info any?
  "Market Data Cancel (Single)
  Cancel market data for given conid. To cancel all market data request(s), see /iserver/marketdata/unsubscribeall."
  [conid string?]
  (check-required-params conid)
  (call-api "/iserver/marketdata/{conid}/unsubscribe" :get
            {:path-params   {"conid" conid }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec iserver-marketdata-conid-unsubscribe-get inline-response-200-25-spec
  "Market Data Cancel (Single)
  Cancel market data for given conid. To cancel all market data request(s), see /iserver/marketdata/unsubscribeall."
  [conid string?]
  (let [res (:data (iserver-marketdata-conid-unsubscribe-get-with-http-info conid))]
    (if (:decode-models *api-context*)
       (st/decode inline-response-200-25-spec res st/string-transformer)
       res)))


(defn-spec iserver-marketdata-history-get-with-http-info any?
  "Market Data History
  Get historical market Data for given conid, length of data is controlled by 'period' and 'bar'.
Formatted as: min=minute, h=hour, d=day, w=week, m=month, y=year
e.g. period =1y with bar =1w returns 52 data points (Max of 1000 data points supported).
**Note**: There's a limit of 5 concurrent requests. Excessive requests will return a 'Too many requests' status 429 response."
  ([conid string?, period string?, ] (iserver-marketdata-history-get-with-http-info conid period nil))
  ([conid string?, period string?, {:keys [exchange bar outsideRth]} (s/map-of keyword? any?)]
   (check-required-params conid period)
   (call-api "/iserver/marketdata/history" :get
             {:path-params   {}
              :header-params {}
              :query-params  {"conid" conid "exchange" exchange "period" period "bar" bar "outsideRth" outsideRth }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    []})))

(defn-spec iserver-marketdata-history-get history-data-spec
  "Market Data History
  Get historical market Data for given conid, length of data is controlled by 'period' and 'bar'.
Formatted as: min=minute, h=hour, d=day, w=week, m=month, y=year
e.g. period =1y with bar =1w returns 52 data points (Max of 1000 data points supported).
**Note**: There's a limit of 5 concurrent requests. Excessive requests will return a 'Too many requests' status 429 response."
  ([conid string?, period string?, ] (iserver-marketdata-history-get conid period nil))
  ([conid string?, period string?, optional-params any?]
   (let [res (:data (iserver-marketdata-history-get-with-http-info conid period optional-params))]
     (if (:decode-models *api-context*)
        (st/decode history-data-spec res st/string-transformer)
        res))))


(defn-spec iserver-marketdata-snapshot-get-with-http-info any?
  "Market Data
  Get Market Data for the given conid(s). The endpoint will return by default bid, ask, last, change, change pct, close, listing exchange.
See response fields for a list of available fields that can be request via fields argument.
The endpoint /iserver/accounts must be called prior to /iserver/marketdata/snapshot.
For derivative contracts the endpoint /iserver/secdef/search must be called first.
First /snapshot endpoint call for given conid will initiate the market data request. 
To receive all available fields the /snapshot endpoint will need to be called several times.
To receive streaming market data the endpoint /ws can be used. Refer to [Streaming WebSocket Data](https://interactivebrokers.github.io/cpwebapi/RealtimeSubscription.html) for details."
  ([conids string?, ] (iserver-marketdata-snapshot-get-with-http-info conids nil))
  ([conids string?, {:keys [since fields]} (s/map-of keyword? any?)]
   (check-required-params conids)
   (call-api "/iserver/marketdata/snapshot" :get
             {:path-params   {}
              :header-params {}
              :query-params  {"conids" conids "since" since "fields" fields }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    []})))

(defn-spec iserver-marketdata-snapshot-get (s/coll-of inline-response-200-24-spec)
  "Market Data
  Get Market Data for the given conid(s). The endpoint will return by default bid, ask, last, change, change pct, close, listing exchange.
See response fields for a list of available fields that can be request via fields argument.
The endpoint /iserver/accounts must be called prior to /iserver/marketdata/snapshot.
For derivative contracts the endpoint /iserver/secdef/search must be called first.
First /snapshot endpoint call for given conid will initiate the market data request. 
To receive all available fields the /snapshot endpoint will need to be called several times.
To receive streaming market data the endpoint /ws can be used. Refer to [Streaming WebSocket Data](https://interactivebrokers.github.io/cpwebapi/RealtimeSubscription.html) for details."
  ([conids string?, ] (iserver-marketdata-snapshot-get conids nil))
  ([conids string?, optional-params any?]
   (let [res (:data (iserver-marketdata-snapshot-get-with-http-info conids optional-params))]
     (if (:decode-models *api-context*)
        (st/decode (s/coll-of inline-response-200-24-spec) res st/string-transformer)
        res))))


(defn-spec iserver-marketdata-unsubscribeall-get-with-http-info any?
  "Market Data Cancel (All)
  Cancel all market data request(s). To cancel market data for given conid, see /iserver/marketdata/{conid}/unsubscribe."
  []
  (call-api "/iserver/marketdata/unsubscribeall" :get
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec iserver-marketdata-unsubscribeall-get inline-response-200-26-spec
  "Market Data Cancel (All)
  Cancel all market data request(s). To cancel market data for given conid, see /iserver/marketdata/{conid}/unsubscribe."
  []
  (let [res (:data (iserver-marketdata-unsubscribeall-get-with-http-info))]
    (if (:decode-models *api-context*)
       (st/decode inline-response-200-26-spec res st/string-transformer)
       res)))


(defn-spec md-snapshot-get-with-http-info any?
  "Market Data Snapshot (Beta)
  Get a snapshot of Market Data for the given conid(s).See response for a list of available fields that can be requested from the fields argument.
Must be connected to a brokerage session before can query snapshot data.
First /snapshot endpoint call for given conid(s) will initiate the market data request, make an additional request to receive field values back.
To receive all available fields the /snapshot endpoint will need to be called several times.
To receive streaming market data the endpoint /ws can be used. Refer to [Streaming WebSocket Data](https://interactivebrokers.github.io/cpwebapi/RealtimeSubscription.html) for details."
  ([conids string?, ] (md-snapshot-get-with-http-info conids nil))
  ([conids string?, {:keys [fields]} (s/map-of keyword? any?)]
   (check-required-params conids)
   (call-api "/md/snapshot" :get
             {:path-params   {}
              :header-params {}
              :query-params  {"conids" conids "fields" fields }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    []})))

(defn-spec md-snapshot-get market-data-spec
  "Market Data Snapshot (Beta)
  Get a snapshot of Market Data for the given conid(s).See response for a list of available fields that can be requested from the fields argument.
Must be connected to a brokerage session before can query snapshot data.
First /snapshot endpoint call for given conid(s) will initiate the market data request, make an additional request to receive field values back.
To receive all available fields the /snapshot endpoint will need to be called several times.
To receive streaming market data the endpoint /ws can be used. Refer to [Streaming WebSocket Data](https://interactivebrokers.github.io/cpwebapi/RealtimeSubscription.html) for details."
  ([conids string?, ] (md-snapshot-get conids nil))
  ([conids string?, optional-params any?]
   (let [res (:data (md-snapshot-get-with-http-info conids optional-params))]
     (if (:decode-models *api-context*)
        (st/decode market-data-spec res st/string-transformer)
        res))))


