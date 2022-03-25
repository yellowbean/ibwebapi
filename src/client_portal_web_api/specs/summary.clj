(ns client-portal-web-api.specs.summary
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def summary-data
  {
   (ds/opt :amount) float?
   (ds/opt :currency) string?
   (ds/opt :isNull) boolean?
   (ds/opt :timestamp) int?
   (ds/opt :value) string?
   })

(def summary-spec
  (ds/spec
    {:name ::summary
     :spec summary-data}))
