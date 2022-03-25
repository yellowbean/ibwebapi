(ns client-portal-web-api.api.ccp-beta-
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


(defn-spec ccp-account-get-with-http-info any?
  "Brokerage Accounts
  Provides the list of tradeable accounts"
  []
  (call-api "/ccp/account" :get
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec ccp-account-get inline-response-200-39-spec
  "Brokerage Accounts
  Provides the list of tradeable accounts"
  []
  (let [res (:data (ccp-account-get-with-http-info))]
    (if (:decode-models *api-context*)
       (st/decode inline-response-200-39-spec res st/string-transformer)
       res)))


(defn-spec ccp-auth-init-post-with-http-info any?
  "Start CCP Session
  Initiate a brokerage session to CCP. Only one brokerage session type can run at a time. If an existing brokerage session to iServer is running then call the endpoint /logout first. Note at this time only order management is possible from CCP session, market data and scanner endpoints can't be used since they are only available from iServer session. Work is in progress to provide new CCP endpoints for market data and scanners."
  ([] (ccp-auth-init-post-with-http-info nil))
  ([{:keys [compete locale mac machineId username]} (s/map-of keyword? any?)]
   (call-api "/ccp/auth/init" :post
             {:path-params   {}
              :header-params {}
              :query-params  {}
              :form-params   {"compete" compete "locale" locale "mac" mac "machineId" machineId "username" username }
              :content-types ["application/x-www-form-urlencoded"]
              :accepts       ["application/json"]
              :auth-names    []})))

(defn-spec ccp-auth-init-post inline-response-200-36-spec
  "Start CCP Session
  Initiate a brokerage session to CCP. Only one brokerage session type can run at a time. If an existing brokerage session to iServer is running then call the endpoint /logout first. Note at this time only order management is possible from CCP session, market data and scanner endpoints can't be used since they are only available from iServer session. Work is in progress to provide new CCP endpoints for market data and scanners."
  ([] (ccp-auth-init-post nil))
  ([optional-params any?]
   (let [res (:data (ccp-auth-init-post-with-http-info optional-params))]
     (if (:decode-models *api-context*)
        (st/decode inline-response-200-36-spec res st/string-transformer)
        res))))


(defn-spec ccp-auth-response-post-with-http-info any?
  "Complete CCP Session
  Session Token Authentication"
  ([] (ccp-auth-response-post-with-http-info nil))
  ([{:keys [auth]} (s/map-of keyword? any?)]
   (call-api "/ccp/auth/response" :post
             {:path-params   {}
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    auth
              :content-types []
              :accepts       ["application/json"]
              :auth-names    []})))

(defn-spec ccp-auth-response-post inline-response-200-37-spec
  "Complete CCP Session
  Session Token Authentication"
  ([] (ccp-auth-response-post nil))
  ([optional-params any?]
   (let [res (:data (ccp-auth-response-post-with-http-info optional-params))]
     (if (:decode-models *api-context*)
        (st/decode inline-response-200-37-spec res st/string-transformer)
        res))))


(defn-spec ccp-order-delete-with-http-info any?
  "Delete Order
  Sends an Order cancellation request. The status of the order can be queried through /ccp/order. Passing arguments as GET is also supported (requires passing action=delete) (GET is meant for development only)"
  [acct string?, id float?]
  (check-required-params acct id)
  (call-api "/ccp/order" :delete
            {:path-params   {}
             :header-params {}
             :query-params  {"acct" acct "id" id }
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec ccp-order-delete order-data-spec
  "Delete Order
  Sends an Order cancellation request. The status of the order can be queried through /ccp/order. Passing arguments as GET is also supported (requires passing action=delete) (GET is meant for development only)"
  [acct string?, id float?]
  (let [res (:data (ccp-order-delete-with-http-info acct id))]
    (if (:decode-models *api-context*)
       (st/decode order-data-spec res st/string-transformer)
       res)))


(defn-spec ccp-order-post-with-http-info any?
  "Submit Order
  Submits an Order."
  ([acct string?, conid float?, ccy string?, exchange string?, qty float?, ] (ccp-order-post-with-http-info acct conid ccy exchange qty nil))
  ([acct string?, conid float?, ccy string?, exchange string?, qty float?, {:keys [type side price tif]} (s/map-of keyword? any?)]
   (check-required-params acct conid ccy exchange qty)
   (call-api "/ccp/order" :post
             {:path-params   {}
              :header-params {}
              :query-params  {"acct" acct "conid" conid "ccy" ccy "exchange" exchange "qty" qty "type" type "side" side "price" price "tif" tif }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    []})))

(defn-spec ccp-order-post order-data-spec
  "Submit Order
  Submits an Order."
  ([acct string?, conid float?, ccy string?, exchange string?, qty float?, ] (ccp-order-post acct conid ccy exchange qty nil))
  ([acct string?, conid float?, ccy string?, exchange string?, qty float?, optional-params any?]
   (let [res (:data (ccp-order-post-with-http-info acct conid ccy exchange qty optional-params))]
     (if (:decode-models *api-context*)
        (st/decode order-data-spec res st/string-transformer)
        res))))


(defn-spec ccp-order-put-with-http-info any?
  "Update Order
  Updates an Order. Updating an order requires the same arguments as placing an order besides the conid. Note: The status of the order can be queried through GET /ccp/order."
  [acct string?, id float?]
  (check-required-params acct id)
  (call-api "/ccp/order" :put
            {:path-params   {}
             :header-params {}
             :query-params  {"acct" acct "id" id }
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec ccp-order-put order-data-spec
  "Update Order
  Updates an Order. Updating an order requires the same arguments as placing an order besides the conid. Note: The status of the order can be queried through GET /ccp/order."
  [acct string?, id float?]
  (let [res (:data (ccp-order-put-with-http-info acct id))]
    (if (:decode-models *api-context*)
       (st/decode order-data-spec res st/string-transformer)
       res)))


(defn-spec ccp-orders-get-with-http-info any?
  "Order Status
  Get status for all orders"
  ([acct string?, ] (ccp-orders-get-with-http-info acct nil))
  ([acct string?, {:keys [cancelled]} (s/map-of keyword? any?)]
   (check-required-params acct)
   (call-api "/ccp/orders" :get
             {:path-params   {}
              :header-params {}
              :query-params  {"acct" acct "cancelled" cancelled }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    []})))

(defn-spec ccp-orders-get inline-response-200-40-spec
  "Order Status
  Get status for all orders"
  ([acct string?, ] (ccp-orders-get acct nil))
  ([acct string?, optional-params any?]
   (let [res (:data (ccp-orders-get-with-http-info acct optional-params))]
     (if (:decode-models *api-context*)
        (st/decode inline-response-200-40-spec res st/string-transformer)
        res))))


(defn-spec ccp-positions-get-with-http-info any?
  "Positions
  List of positions"
  []
  (call-api "/ccp/positions" :get
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec ccp-positions-get position-data-spec
  "Positions
  List of positions"
  []
  (let [res (:data (ccp-positions-get-with-http-info))]
    (if (:decode-models *api-context*)
       (st/decode position-data-spec res st/string-transformer)
       res)))


(defn-spec ccp-status-get-with-http-info any?
  "CCP Status
  Provide the current CCP session status. When using the Gateway this endpoint will also initiate a brokerage session to CCP by sending /auth/init and response."
  []
  (call-api "/ccp/status" :get
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec ccp-status-get inline-response-200-38-spec
  "CCP Status
  Provide the current CCP session status. When using the Gateway this endpoint will also initiate a brokerage session to CCP by sending /auth/init and response."
  []
  (let [res (:data (ccp-status-get-with-http-info))]
    (if (:decode-models *api-context*)
       (st/decode inline-response-200-38-spec res st/string-transformer)
       res)))


(defn-spec ccp-trades-get-with-http-info any?
  "Trades
  Get a list of Trades, by default, the list is from today midnight to Date.now()."
  ([] (ccp-trades-get-with-http-info nil))
  ([{:keys [from to]} (s/map-of keyword? any?)]
   (call-api "/ccp/trades" :get
             {:path-params   {}
              :header-params {}
              :query-params  {"from" from "to" to }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    []})))

(defn-spec ccp-trades-get inline-response-200-40-spec
  "Trades
  Get a list of Trades, by default, the list is from today midnight to Date.now()."
  ([] (ccp-trades-get nil))
  ([optional-params any?]
   (let [res (:data (ccp-trades-get-with-http-info optional-params))]
     (if (:decode-models *api-context*)
        (st/decode inline-response-200-40-spec res st/string-transformer)
        res))))


