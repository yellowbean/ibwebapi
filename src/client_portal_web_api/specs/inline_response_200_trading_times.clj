(ns client-portal-web-api.specs.inline-response-200-trading-times
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def inline-response-200-trading-times-data
  {
   (ds/opt :openingTime) int?
   (ds/opt :closingTime) int?
   (ds/opt :cancelDayOrders) string?
   })

(def inline-response-200-trading-times-spec
  (ds/spec
    {:name ::inline-response-200-trading-times
     :spec inline-response-200-trading-times-data}))
