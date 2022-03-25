(ns client-portal-web-api.specs.history-result-bars
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [client-portal-web-api.specs.history-result-bars-data :refer :all]
            )
  (:import (java.io File)))


(def history-result-bars-data
  {
   (ds/opt :open) float?
   (ds/opt :startTime) string?
   (ds/opt :startTimeVal) int?
   (ds/opt :endTime) string?
   (ds/opt :endTimeVal) int?
   (ds/opt :points) int?
   (ds/opt :data) (s/coll-of history-result-bars-data-spec)
   (ds/opt :mktDataDelay) int?
   })

(def history-result-bars-spec
  (ds/spec
    {:name ::history-result-bars
     :spec history-result-bars-data}))
