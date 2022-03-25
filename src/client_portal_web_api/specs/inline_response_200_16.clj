(ns client-portal-web-api.specs.inline-response-200-16
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def inline-response-200-16-data
  {
   (ds/opt :order_id) int?
   (ds/opt :account) string?
   (ds/opt :alert_name) string?
   (ds/opt :alert_active) int?
   (ds/opt :order_time) string?
   (ds/opt :alert_triggered) boolean?
   (ds/opt :alert_repeatable) int?
   })

(def inline-response-200-16-spec
  (ds/spec
    {:name ::inline-response-200-16
     :spec inline-response-200-16-data}))
