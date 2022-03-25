(ns client-portal-web-api.specs.inline-response-200-17
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def inline-response-200-17-data
  {
   (ds/opt :request_id) int?
   (ds/opt :order_id) int?
   (ds/opt :success) boolean?
   (ds/opt :text) string?
   (ds/opt :order_status) string?
   (ds/opt :failure_list) string?
   })

(def inline-response-200-17-spec
  (ds/spec
    {:name ::inline-response-200-17
     :spec inline-response-200-17-data}))
