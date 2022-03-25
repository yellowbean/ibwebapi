(ns client-portal-web-api.specs.history-data
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [client-portal-web-api.specs.history-data-data :refer :all]
            )
  (:import (java.io File)))


(def history-data-data
  {
   (ds/opt :symbol) string?
   (ds/opt :text) string?
   (ds/opt :priceFactor) int?
   (ds/opt :startTime) string?
   (ds/opt :high) string?
   (ds/opt :low) string?
   (ds/opt :timePeriod) string?
   (ds/opt :barLength) int?
   (ds/opt :mdAvailability) string?
   (ds/opt :mktDataDelay) int?
   (ds/opt :outsideRth) boolean?
   (ds/opt :tradingDayDuration) int?
   (ds/opt :volumeFactor) int?
   (ds/opt :priceDisplayRule) int?
   (ds/opt :priceDisplayValue) string?
   (ds/opt :negativeCapable) boolean?
   (ds/opt :messageVersion) int?
   (ds/opt :data) (s/coll-of history-data-data-spec)
   (ds/opt :points) int?
   (ds/opt :travelTime) int?
   })

(def history-data-spec
  (ds/spec
    {:name ::history-data
     :spec history-data-data}))
