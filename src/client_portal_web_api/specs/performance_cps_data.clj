(ns client-portal-web-api.specs.performance-cps-data
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def performance-cps-data-data
  {
   (ds/opt :id) string?
   (ds/opt :idType) string?
   (ds/opt :start) string?
   (ds/opt :baseCurrency) string?
   (ds/opt :returns) (s/coll-of float?)
   (ds/opt :end) string?
   })

(def performance-cps-data-spec
  (ds/spec
    {:name ::performance-cps-data
     :spec performance-cps-data-data}))
