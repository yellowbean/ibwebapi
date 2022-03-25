(ns client-portal-web-api.api.fyi
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


(defn-spec fyi-deliveryoptions-device-id-delete-with-http-info any?
  "Delete a device"
  [deviceId string?]
  (check-required-params deviceId)
  (call-api "/fyi/deliveryoptions/{deviceId}" :delete
            {:path-params   {"deviceId" deviceId }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec fyi-deliveryoptions-device-id-delete any?
  "Delete a device"
  [deviceId string?]
  (let [res (:data (fyi-deliveryoptions-device-id-delete-with-http-info deviceId))]
    (if (:decode-models *api-context*)
       (st/decode any? res st/string-transformer)
       res)))


(defn-spec fyi-deliveryoptions-device-post-with-http-info any?
  "Enable/Disable device option"
  [body inline-object-7]
  (check-required-params body)
  (call-api "/fyi/deliveryoptions/device" :post
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    body
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec fyi-deliveryoptions-device-post inline-response-200-11-spec
  "Enable/Disable device option"
  [body inline-object-7]
  (let [res (:data (fyi-deliveryoptions-device-post-with-http-info body))]
    (if (:decode-models *api-context*)
       (st/decode inline-response-200-11-spec res st/string-transformer)
       res)))


(defn-spec fyi-deliveryoptions-email-put-with-http-info any?
  "Enable/Disable email option"
  [enabled string?]
  (check-required-params enabled)
  (call-api "/fyi/deliveryoptions/email" :put
            {:path-params   {}
             :header-params {}
             :query-params  {"enabled" enabled }
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec fyi-deliveryoptions-email-put inline-response-200-11-spec
  "Enable/Disable email option"
  [enabled string?]
  (let [res (:data (fyi-deliveryoptions-email-put-with-http-info enabled))]
    (if (:decode-models *api-context*)
       (st/decode inline-response-200-11-spec res st/string-transformer)
       res)))


(defn-spec fyi-deliveryoptions-get-with-http-info any?
  "Get delivery options
  options for sending fyis to email and other devices"
  []
  (call-api "/fyi/deliveryoptions" :get
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec fyi-deliveryoptions-get inline-response-200-12-spec
  "Get delivery options
  options for sending fyis to email and other devices"
  []
  (let [res (:data (fyi-deliveryoptions-get-with-http-info))]
    (if (:decode-models *api-context*)
       (st/decode inline-response-200-12-spec res st/string-transformer)
       res)))


(defn-spec fyi-disclaimer-typecode-get-with-http-info any?
  "Get disclaimer for a certain kind of fyi"
  [typecode string?]
  (check-required-params typecode)
  (call-api "/fyi/disclaimer/{typecode}" :get
            {:path-params   {"typecode" typecode }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec fyi-disclaimer-typecode-get inline-response-200-10-spec
  "Get disclaimer for a certain kind of fyi"
  [typecode string?]
  (let [res (:data (fyi-disclaimer-typecode-get-with-http-info typecode))]
    (if (:decode-models *api-context*)
       (st/decode inline-response-200-10-spec res st/string-transformer)
       res)))


(defn-spec fyi-disclaimer-typecode-put-with-http-info any?
  "Mark disclaimer read"
  [typecode string?]
  (check-required-params typecode)
  (call-api "/fyi/disclaimer/{typecode}" :put
            {:path-params   {"typecode" typecode }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec fyi-disclaimer-typecode-put inline-response-200-11-spec
  "Mark disclaimer read"
  [typecode string?]
  (let [res (:data (fyi-disclaimer-typecode-put-with-http-info typecode))]
    (if (:decode-models *api-context*)
       (st/decode inline-response-200-11-spec res st/string-transformer)
       res)))


(defn-spec fyi-notifications-get-with-http-info any?
  "Get a list of notifications"
  ([max string?, ] (fyi-notifications-get-with-http-info max nil))
  ([max string?, {:keys [exclude include]} (s/map-of keyword? any?)]
   (check-required-params max)
   (call-api "/fyi/notifications" :get
             {:path-params   {}
              :header-params {}
              :query-params  {"exclude" exclude "include" include "max" max }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    []})))

(defn-spec fyi-notifications-get (s/coll-of any?)
  "Get a list of notifications"
  ([max string?, ] (fyi-notifications-get max nil))
  ([max string?, optional-params any?]
   (let [res (:data (fyi-notifications-get-with-http-info max optional-params))]
     (if (:decode-models *api-context*)
        (st/decode (s/coll-of any?) res st/string-transformer)
        res))))


(defn-spec fyi-notifications-more-get-with-http-info any?
  "Get more notifications based on a certain one"
  [id string?]
  (check-required-params id)
  (call-api "/fyi/notifications/more" :get
            {:path-params   {}
             :header-params {}
             :query-params  {"id" id }
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec fyi-notifications-more-get (s/coll-of any?)
  "Get more notifications based on a certain one"
  [id string?]
  (let [res (:data (fyi-notifications-more-get-with-http-info id))]
    (if (:decode-models *api-context*)
       (st/decode (s/coll-of any?) res st/string-transformer)
       res)))


(defn-spec fyi-notifications-notification-id-put-with-http-info any?
  "Get a list of notifications"
  [notificationId string?]
  (check-required-params notificationId)
  (call-api "/fyi/notifications/{notificationId}" :put
            {:path-params   {"notificationId" notificationId }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec fyi-notifications-notification-id-put any?
  "Get a list of notifications"
  [notificationId string?]
  (let [res (:data (fyi-notifications-notification-id-put-with-http-info notificationId))]
    (if (:decode-models *api-context*)
       (st/decode any? res st/string-transformer)
       res)))


(defn-spec fyi-settings-get-with-http-info any?
  "Get a list of subscriptions
  Return the current choices of subscriptions, we can toggle the option"
  []
  (call-api "/fyi/settings" :get
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec fyi-settings-get (s/coll-of inline-response-200-9-spec)
  "Get a list of subscriptions
  Return the current choices of subscriptions, we can toggle the option"
  []
  (let [res (:data (fyi-settings-get-with-http-info))]
    (if (:decode-models *api-context*)
       (st/decode (s/coll-of inline-response-200-9-spec) res st/string-transformer)
       res)))


(defn-spec fyi-settings-typecode-post-with-http-info any?
  "Enable/Disable certain subscription
  Configure which typecode you would like to enable/disable."
  [typecode string?, body inline-object-6]
  (check-required-params typecode body)
  (call-api "/fyi/settings/{typecode}" :post
            {:path-params   {"typecode" typecode }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    body
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec fyi-settings-typecode-post any?
  "Enable/Disable certain subscription
  Configure which typecode you would like to enable/disable."
  [typecode string?, body inline-object-6]
  (let [res (:data (fyi-settings-typecode-post-with-http-info typecode body))]
    (if (:decode-models *api-context*)
       (st/decode any? res st/string-transformer)
       res)))


(defn-spec fyi-unreadnumber-get-with-http-info any?
  "Get unread number of fyis. The HTTP method POST is also supported.
  Returns the total number of unread fyis"
  []
  (call-api "/fyi/unreadnumber" :get
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec fyi-unreadnumber-get inline-response-200-8-spec
  "Get unread number of fyis. The HTTP method POST is also supported.
  Returns the total number of unread fyis"
  []
  (let [res (:data (fyi-unreadnumber-get-with-http-info))]
    (if (:decode-models *api-context*)
       (st/decode inline-response-200-8-spec res st/string-transformer)
       res)))


