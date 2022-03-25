(ns client-portal-web-api.specs.performance
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [client-portal-web-api.specs.performance-cps :refer :all]
            [client-portal-web-api.specs.performance-tpps :refer :all]
            [client-portal-web-api.specs.performance-nav :refer :all]
            )
  (:import (java.io File)))


(def performance-data
  {
   (ds/opt :id) string?
   (ds/opt :cps) performance-cps-spec
   (ds/opt :tpps) performance-tpps-spec
   (ds/opt :nav) performance-nav-spec
   (ds/opt :pm) string?
   (ds/opt :included) (s/coll-of string?)
   (ds/opt :currencyType) string?
   (ds/opt :rc) int?
   })

(def performance-spec
  (ds/spec
    {:name ::performance
     :spec performance-data}))
