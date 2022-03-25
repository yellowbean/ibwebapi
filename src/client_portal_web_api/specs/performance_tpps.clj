(ns client-portal-web-api.specs.performance-tpps
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [client-portal-web-api.specs.performance-cps-data :refer :all]
            )
  (:import (java.io File)))


(def performance-tpps-data
  {
   (ds/opt :dates) (s/coll-of string?)
   (ds/opt :freq) string?
   (ds/opt :data) (s/coll-of performance-cps-data-spec)
   })

(def performance-tpps-spec
  (ds/spec
    {:name ::performance-tpps
     :spec performance-tpps-data}))
