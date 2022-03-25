(ns client-portal-web-api.specs.performance-cps
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [client-portal-web-api.specs.performance-cps-data :refer :all]
            )
  (:import (java.io File)))


(def performance-cps-data
  {
   (ds/opt :dates) (s/coll-of string?)
   (ds/opt :freq) string?
   (ds/opt :data) (s/coll-of performance-cps-data-spec)
   })

(def performance-cps-spec
  (ds/spec
    {:name ::performance-cps
     :spec performance-cps-data}))
