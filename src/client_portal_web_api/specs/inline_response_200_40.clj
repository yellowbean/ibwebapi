(ns client-portal-web-api.specs.inline-response-200-40
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [client-portal-web-api.specs.order-data :refer :all]
            )
  (:import (java.io File)))


(def inline-response-200-40-data
  {
   (ds/opt :orders) (s/coll-of order-data-spec)
   })

(def inline-response-200-40-spec
  (ds/spec
    {:name ::inline-response-200-40
     :spec inline-response-200-40-data}))
