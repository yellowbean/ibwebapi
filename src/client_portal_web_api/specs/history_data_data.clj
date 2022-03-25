(ns client-portal-web-api.specs.history-data-data
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def history-data-data-data
  {
   (ds/opt :o) float?
   (ds/opt :c) float?
   (ds/opt :h) float?
   (ds/opt :l) float?
   (ds/opt :v) float?
   (ds/opt :t) float?
   })

(def history-data-data-spec
  (ds/spec
    {:name ::history-data-data
     :spec history-data-data-data}))
