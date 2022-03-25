(ns client-portal-web-api.specs.history-result-bars-data
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def history-result-bars-data-data
  {
   (ds/opt :t) float?
   (ds/opt :o) float?
   (ds/opt :c) float?
   (ds/opt :h) float?
   (ds/opt :l) float?
   (ds/opt :v) float?
   })

(def history-result-bars-data-spec
  (ds/spec
    {:name ::history-result-bars-data
     :spec history-result-bars-data-data}))
