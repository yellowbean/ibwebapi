(ns client-portal-web-api.specs.scanner-params-filter
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def scanner-params-filter-data
  {
   (ds/opt :code) string?
   (ds/opt :value) float?
   })

(def scanner-params-filter-spec
  (ds/spec
    {:name ::scanner-params-filter
     :spec scanner-params-filter-data}))
