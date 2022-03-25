(ns client-portal-web-api.specs.stats-data
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def stats-data-data
  {
   (ds/opt :Conid) float?
   (ds/opt :Exchange) string?
   (ds/opt :V) float?
   (ds/opt :T) float?
   (ds/opt :TT) float?
   (ds/opt :P) string?
   })

(def stats-data-spec
  (ds/spec
    {:name ::stats-data
     :spec stats-data-data}))
