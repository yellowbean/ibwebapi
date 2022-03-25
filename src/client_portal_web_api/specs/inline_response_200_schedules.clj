(ns client-portal-web-api.specs.inline-response-200-schedules
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [client-portal-web-api.specs.inline-response-200-sessions :refer :all]
            [client-portal-web-api.specs.inline-response-200-trading-times :refer :all]
            )
  (:import (java.io File)))


(def inline-response-200-schedules-data
  {
   (ds/opt :clearingCycleEndTime) int?
   (ds/opt :tradingScheduleDate) int?
   (ds/opt :sessions) inline-response-200-sessions-spec
   (ds/opt :tradingTimes) inline-response-200-trading-times-spec
   })

(def inline-response-200-schedules-spec
  (ds/spec
    {:name ::inline-response-200-schedules
     :spec inline-response-200-schedules-data}))
