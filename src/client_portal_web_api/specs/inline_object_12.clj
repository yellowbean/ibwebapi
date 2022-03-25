(ns client-portal-web-api.specs.inline-object-12
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [client-portal-web-api.specs.order-request :refer :all]
            )
  (:import (java.io File)))


(def inline-object-12-data
  {
   (ds/opt :orders) (s/coll-of order-request-spec)
   })

(def inline-object-12-spec
  (ds/spec
    {:name ::inline-object-12
     :spec inline-object-12-data}))
