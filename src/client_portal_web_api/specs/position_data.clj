(ns client-portal-web-api.specs.position-data
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def position-data-data
  {
   (ds/opt :conid) float?
   (ds/opt :position) float?
   (ds/opt :avgCost) float?
   })

(def position-data-spec
  (ds/spec
    {:name ::position-data
     :spec position-data-data}))
