(ns client-portal-web-api.specs.alert-response
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [client-portal-web-api.specs.alert-response-conditions :refer :all]
            )
  (:import (java.io File)))


(def alert-response-data
  {
   (ds/opt :account) string?
   (ds/opt :order_id) int?
   (ds/opt :alert_name) string?
   (ds/opt :alert_message) string?
   (ds/opt :alert_active) int?
   (ds/opt :alert_repeatable) int?
   (ds/opt :alert_email) string?
   (ds/opt :alert_send_message) int?
   (ds/opt :tif) string?
   (ds/opt :expire_time) string?
   (ds/opt :order_status) string?
   (ds/opt :outsideRth) int?
   (ds/opt :itws_orders_only) int?
   (ds/opt :alert_show_popup) int?
   (ds/opt :alert_triggered) boolean?
   (ds/opt :order_not_editable) boolean?
   (ds/opt :tool_id) int?
   (ds/opt :alert_play_audio) string?
   (ds/opt :alert_mta_currency) string?
   (ds/opt :alert_mta_defaults) string?
   (ds/opt :time_zone) string?
   (ds/opt :alert_default_type) string?
   (ds/opt :condition_size) int?
   (ds/opt :condition_outside_rth) int?
   (ds/opt :conditions) (s/coll-of alert-response-conditions-spec)
   })

(def alert-response-spec
  (ds/spec
    {:name ::alert-response
     :spec alert-response-data}))
