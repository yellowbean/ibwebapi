(ns client-portal-web-api.specs.secdef-info
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def secdef-info-data
  {
   (ds/opt :conid) float?
   (ds/opt :symbol) string?
   (ds/opt :secType) string?
   (ds/opt :exchange) string?
   (ds/opt :listingExchange) string?
   (ds/opt :right) string?
   (ds/opt :strike) string?
   (ds/opt :currency) string?
   (ds/opt :cusip) string?
   (ds/opt :coupon) string?
   (ds/opt :desc1) string?
   (ds/opt :desc2) string?
   (ds/opt :maturityDate) string?
   (ds/opt :multiplier) string?
   (ds/opt :tradingClass) string?
   (ds/opt :validExchanges) string?
   })

(def secdef-info-spec
  (ds/spec
    {:name ::secdef-info
     :spec secdef-info-data}))
