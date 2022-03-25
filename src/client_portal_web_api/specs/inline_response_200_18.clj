(ns client-portal-web-api.specs.inline-response-200-18
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [client-portal-web-api.specs.inline-response-200-18-orders :refer :all]
            )
  (:import (java.io File)))


(def inline-response-200-18-data
  {
   (ds/opt :orders) (s/coll-of inline-response-200-18-orders-spec)
   (ds/opt :snapshot) boolean?
   })

(def inline-response-200-18-spec
  (ds/spec
    {:name ::inline-response-200-18
     :spec inline-response-200-18-data}))
