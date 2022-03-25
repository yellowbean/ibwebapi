(ns client-portal-web-api.specs.performance-nav
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [client-portal-web-api.specs.performance-cps-data :refer :all]
            )
  (:import (java.io File)))


(def performance-nav-data
  {
   (ds/opt :dates) (s/coll-of string?)
   (ds/opt :freq) string?
   (ds/opt :data) (s/coll-of performance-cps-data-spec)
   })

(def performance-nav-spec
  (ds/spec
    {:name ::performance-nav
     :spec performance-nav-data}))
