(ns client-portal-web-api.specs.contract-rules
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def contract-rules-data
  {
   (ds/opt :orderTypes) (s/coll-of string?)
   (ds/opt :orderTypesOutside) (s/coll-of string?)
   (ds/opt :defaultSize) float?
   (ds/opt :sizeIncrement) float?
   (ds/opt :tifTypes) (s/coll-of string?)
   (ds/opt :limitPrice) float?
   (ds/opt :stopprice) float?
   (ds/opt :preview) boolean?
   (ds/opt :displaySize) string?
   (ds/opt :increment) string?
   })

(def contract-rules-spec
  (ds/spec
    {:name ::contract-rules
     :spec contract-rules-data}))
