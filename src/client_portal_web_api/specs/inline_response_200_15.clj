(ns client-portal-web-api.specs.inline-response-200-15
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def inline-response-200-15-data
  {
   (ds/opt :request_id) int?
   (ds/opt :order_id) int?
   (ds/opt :success) boolean?
   (ds/opt :text) string?
   (ds/opt :order_status) string?
   (ds/opt :warning_message) string?
   })

(def inline-response-200-15-spec
  (ds/spec
    {:name ::inline-response-200-15
     :spec inline-response-200-15-data}))
