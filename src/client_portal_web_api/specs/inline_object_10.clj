(ns client-portal-web-api.specs.inline-object-10
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [client-portal-web-api.specs.order-request :refer :all]
            )
  (:import (java.io File)))


(def inline-object-10-data
  {
   (ds/opt :orders) (s/coll-of order-request-spec)
   })

(def inline-object-10-spec
  (ds/spec
    {:name ::inline-object-10
     :spec inline-object-10-data}))
