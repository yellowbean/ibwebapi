(ns client-portal-web-api.api.order
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


(defn-spec iserver-account-account-id-order-order-id-delete-with-http-info any?
  "Cancel Order
  Cancels an open order. Must call /iserver/accounts endpoint prior to cancelling an order. Use /iservers/account/orders endpoint to review open-order(s) and get latest order status."
  [accountId string?, orderId string?]
  (check-required-params accountId orderId)
  (call-api "/iserver/account/{accountId}/order/{orderId}" :delete
            {:path-params   {"accountId" accountId "orderId" orderId }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec iserver-account-account-id-order-order-id-delete inline-response-200-23-spec
  "Cancel Order
  Cancels an open order. Must call /iserver/accounts endpoint prior to cancelling an order. Use /iservers/account/orders endpoint to review open-order(s) and get latest order status."
  [accountId string?, orderId string?]
  (let [res (:data (iserver-account-account-id-order-order-id-delete-with-http-info accountId orderId))]
    (if (:decode-models *api-context*)
       (st/decode inline-response-200-23-spec res st/string-transformer)
       res)))


(defn-spec iserver-account-account-id-order-order-id-post-with-http-info any?
  "Modify Order
  Modifies an open order. Must call /iserver/accounts endpoint prior to modifying an order. Use /iservers/account/orders endpoint to review open-order(s)."
  [accountId string?, orderId string?, body modify-order]
  (check-required-params accountId orderId body)
  (call-api "/iserver/account/{accountId}/order/{orderId}" :post
            {:path-params   {"accountId" accountId "orderId" orderId }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    body
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec iserver-account-account-id-order-order-id-post (s/coll-of inline-response-200-22-spec)
  "Modify Order
  Modifies an open order. Must call /iserver/accounts endpoint prior to modifying an order. Use /iservers/account/orders endpoint to review open-order(s)."
  [accountId string?, orderId string?, body modify-order]
  (let [res (:data (iserver-account-account-id-order-order-id-post-with-http-info accountId orderId body))]
    (if (:decode-models *api-context*)
       (st/decode (s/coll-of inline-response-200-22-spec) res st/string-transformer)
       res)))


(defn-spec iserver-account-account-id-order-post-with-http-info any?
  "Place Order (Deprecated)
  This endpoint is going to be deprecated, you can use /iserver/account/{accountId}/orders, just pass one order
in the array, the order structure will be same.
Please note here, sometimes this endpoint alone can't make sure you submit the order successfully,
you could receive some questions in the response, you have to to answer them in order to submit the order
successfully. You can use \"/iserver/reply/{replyid}\" endpoint to answer questions"
  [accountId string?, body order-request]
  (check-required-params accountId body)
  (call-api "/iserver/account/{accountId}/order" :post
            {:path-params   {"accountId" accountId }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    body
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec iserver-account-account-id-order-post (s/coll-of inline-response-200-19-spec)
  "Place Order (Deprecated)
  This endpoint is going to be deprecated, you can use /iserver/account/{accountId}/orders, just pass one order
in the array, the order structure will be same.
Please note here, sometimes this endpoint alone can't make sure you submit the order successfully,
you could receive some questions in the response, you have to to answer them in order to submit the order
successfully. You can use \"/iserver/reply/{replyid}\" endpoint to answer questions"
  [accountId string?, body order-request]
  (let [res (:data (iserver-account-account-id-order-post-with-http-info accountId body))]
    (if (:decode-models *api-context*)
       (st/decode (s/coll-of inline-response-200-19-spec) res st/string-transformer)
       res)))


(defn-spec iserver-account-account-id-order-whatif-post-with-http-info any?
  "Preview Order (Deprecated)
  This end-point is going to be deprecated, you can use /iserver/account/{accountId}/orders/whatif,
just pass one order in the array, the order structure will be same.
This endpoint allows you to preview order without actually submitting the order and you can get
commission information in the response."
  [accountId string?, body order-request]
  (check-required-params accountId body)
  (call-api "/iserver/account/{accountId}/order/whatif" :post
            {:path-params   {"accountId" accountId }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    body
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec iserver-account-account-id-order-whatif-post inline-response-200-21-spec
  "Preview Order (Deprecated)
  This end-point is going to be deprecated, you can use /iserver/account/{accountId}/orders/whatif,
just pass one order in the array, the order structure will be same.
This endpoint allows you to preview order without actually submitting the order and you can get
commission information in the response."
  [accountId string?, body order-request]
  (let [res (:data (iserver-account-account-id-order-whatif-post-with-http-info accountId body))]
    (if (:decode-models *api-context*)
       (st/decode inline-response-200-21-spec res st/string-transformer)
       res)))


(defn-spec iserver-account-account-id-orders-post-with-http-info any?
  "Place Orders
  When connected to an IServer Brokerage Session, this endpoint will allow you to submit orders. 
CP WEB API supports various advanced orderTypes, for additional details and examples refer to [IBKR Quant Blog](https://www.tradersinsight.news/category/ibkr-quant-news/programming_languages/rest-development/).
  * Bracket - Attach additional opposite-side order(s) by using a single **cOID** sent with the parent and set the same value for **parentId** in each child order(s).
  * Cash Quantity -  Send orders using monetary value by specifying **cashQty** instead of quantity, e.g. cashQty: 200. The endpoint /iserver/contract/rules returns list of valid orderTypes in cqtTypes.
  * Currency Conversion - Convert cash from one currency to another by including **isCcyConv** = **true**. To specify the cash quantity use **fxQTY** instead of quantity, e.g. fxQTY: 100.
  * Fractional - Contracts that support fractional shares can be traded by specifying **quantity** as a float, e.g. quantity: 0.001. The endpoint /iserver/contract/rules returns a list of valid orderTypes in fraqTypes.
  * IB Algos - Attached user-defined settings to your trades by using any of IBKR's Algo Orders. Use the endpoint /iserver/contract/{conid}/algos to identify the available strategies for a contract.
  * One-Cancels-All (OCA) - Group multiple unrelated orders by passing order request info in an array and including **isSingleGroup = true** for each order. All orders will be assigned the same oca_group_id."
  [accountId string?, body inline-object-10]
  (check-required-params accountId body)
  (call-api "/iserver/account/{accountId}/orders" :post
            {:path-params   {"accountId" accountId }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    body
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec iserver-account-account-id-orders-post (s/coll-of inline-response-200-19-spec)
  "Place Orders
  When connected to an IServer Brokerage Session, this endpoint will allow you to submit orders. 
CP WEB API supports various advanced orderTypes, for additional details and examples refer to [IBKR Quant Blog](https://www.tradersinsight.news/category/ibkr-quant-news/programming_languages/rest-development/).
  * Bracket - Attach additional opposite-side order(s) by using a single **cOID** sent with the parent and set the same value for **parentId** in each child order(s).
  * Cash Quantity -  Send orders using monetary value by specifying **cashQty** instead of quantity, e.g. cashQty: 200. The endpoint /iserver/contract/rules returns list of valid orderTypes in cqtTypes.
  * Currency Conversion - Convert cash from one currency to another by including **isCcyConv** = **true**. To specify the cash quantity use **fxQTY** instead of quantity, e.g. fxQTY: 100.
  * Fractional - Contracts that support fractional shares can be traded by specifying **quantity** as a float, e.g. quantity: 0.001. The endpoint /iserver/contract/rules returns a list of valid orderTypes in fraqTypes.
  * IB Algos - Attached user-defined settings to your trades by using any of IBKR's Algo Orders. Use the endpoint /iserver/contract/{conid}/algos to identify the available strategies for a contract.
  * One-Cancels-All (OCA) - Group multiple unrelated orders by passing order request info in an array and including **isSingleGroup = true** for each order. All orders will be assigned the same oca_group_id."
  [accountId string?, body inline-object-10]
  (let [res (:data (iserver-account-account-id-orders-post-with-http-info accountId body))]
    (if (:decode-models *api-context*)
       (st/decode (s/coll-of inline-response-200-19-spec) res st/string-transformer)
       res)))


(defn-spec iserver-account-account-id-orders-whatif-post-with-http-info any?
  "Preview Orders
  This endpoint allows you to preview order without actually submitting the order and you can get
commission information in the response. Also supports bracket orders."
  [accountId string?, body inline-object-12]
  (check-required-params accountId body)
  (call-api "/iserver/account/{accountId}/orders/whatif" :post
            {:path-params   {"accountId" accountId }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    body
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec iserver-account-account-id-orders-whatif-post inline-response-200-21-spec
  "Preview Orders
  This endpoint allows you to preview order without actually submitting the order and you can get
commission information in the response. Also supports bracket orders."
  [accountId string?, body inline-object-12]
  (let [res (:data (iserver-account-account-id-orders-whatif-post-with-http-info accountId body))]
    (if (:decode-models *api-context*)
       (st/decode inline-response-200-21-spec res st/string-transformer)
       res)))


(defn-spec iserver-account-order-status-order-id-get-with-http-info any?
  "Order Status"
  [orderId string?]
  (check-required-params orderId)
  (call-api "/iserver/account/order/status/{orderId}" :get
            {:path-params   {"orderId" orderId }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec iserver-account-order-status-order-id-get order-status-spec
  "Order Status"
  [orderId string?]
  (let [res (:data (iserver-account-order-status-order-id-get-with-http-info orderId))]
    (if (:decode-models *api-context*)
       (st/decode order-status-spec res st/string-transformer)
       res)))


(defn-spec iserver-account-orders-fa-group-post-with-http-info any?
  "Place Orders for FA
  Financial Advisors can use this endpoint to place an order for a specified group. To place an order for a specified account use the endpoint /iserver/account/{accountId}/order.
More information about groups can be found in the [TWS Users' Guide:](https://guides.interactivebrokers.com/twsguide/twsguide.htm#usersguidebook/financialadvisors/create_an_account_group_for_share_allocation.htm)."
  [faGroup string?, body order-request]
  (check-required-params faGroup body)
  (call-api "/iserver/account/orders/{faGroup}" :post
            {:path-params   {"faGroup" faGroup }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    body
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec iserver-account-orders-fa-group-post (s/coll-of inline-response-200-19-spec)
  "Place Orders for FA
  Financial Advisors can use this endpoint to place an order for a specified group. To place an order for a specified account use the endpoint /iserver/account/{accountId}/order.
More information about groups can be found in the [TWS Users' Guide:](https://guides.interactivebrokers.com/twsguide/twsguide.htm#usersguidebook/financialadvisors/create_an_account_group_for_share_allocation.htm)."
  [faGroup string?, body order-request]
  (let [res (:data (iserver-account-orders-fa-group-post-with-http-info faGroup body))]
    (if (:decode-models *api-context*)
       (st/decode (s/coll-of inline-response-200-19-spec) res st/string-transformer)
       res)))


(defn-spec iserver-account-orders-get-with-http-info any?
  "Live Orders
  The endpoint is meant to be used in polling mode, e.g. requesting every x seconds.
The response will contain two objects, one is notification, the other is orders.
Orders is the list of live orders (cancelled, filled, submitted).
Notifications contains information about execute orders as they happen, see status field.
To receive streaming live orders the endpoint /ws can be used. Refer to [Streaming WebSocket Data](https://interactivebrokers.github.io/cpwebapi/RealtimeSubscription.html) for details."
  ([] (iserver-account-orders-get-with-http-info nil))
  ([{:keys [body]} (s/map-of keyword? any?)]
   (call-api "/iserver/account/orders" :get
             {:path-params   {}
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    body
              :content-types []
              :accepts       ["application/json"]
              :auth-names    []})))

(defn-spec iserver-account-orders-get inline-response-200-18-spec
  "Live Orders
  The endpoint is meant to be used in polling mode, e.g. requesting every x seconds.
The response will contain two objects, one is notification, the other is orders.
Orders is the list of live orders (cancelled, filled, submitted).
Notifications contains information about execute orders as they happen, see status field.
To receive streaming live orders the endpoint /ws can be used. Refer to [Streaming WebSocket Data](https://interactivebrokers.github.io/cpwebapi/RealtimeSubscription.html) for details."
  ([] (iserver-account-orders-get nil))
  ([optional-params any?]
   (let [res (:data (iserver-account-orders-get-with-http-info optional-params))]
     (if (:decode-models *api-context*)
        (st/decode inline-response-200-18-spec res st/string-transformer)
        res))))


(defn-spec iserver-reply-replyid-post-with-http-info any?
  "Place Order Reply
  Reply to questions when placing orders and submit orders"
  [replyid string?, body inline-object-11]
  (check-required-params replyid body)
  (call-api "/iserver/reply/{replyid}" :post
            {:path-params   {"replyid" replyid }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    body
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec iserver-reply-replyid-post (s/coll-of inline-response-200-20-spec)
  "Place Order Reply
  Reply to questions when placing orders and submit orders"
  [replyid string?, body inline-object-11]
  (let [res (:data (iserver-reply-replyid-post-with-http-info replyid body))]
    (if (:decode-models *api-context*)
       (st/decode (s/coll-of inline-response-200-20-spec) res st/string-transformer)
       res)))


