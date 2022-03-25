(ns client-portal-web-api.specs.inline-response-200-20
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def inline-response-200-20-data
  {
   (ds/opt :order_id) string?
   (ds/opt :order_status) string?
   (ds/opt :local_order_id) string?
   })

(def inline-response-200-20-spec
  (ds/spec
    {:name ::inline-response-200-20
     :spec inline-response-200-20-data}))
