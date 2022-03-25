(ns client-portal-web-api.specs.order-data
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [client-portal-web-api.specs.order-data-warnings :refer :all]
            )
  (:import (java.io File)))


(def order-data-data
  {
   (ds/opt :clientOrderId) string?
   (ds/opt :execId) string?
   (ds/opt :execType) string?
   (ds/opt :orderType) string?
   (ds/opt :orderStatus) string?
   (ds/opt :symbol) string?
   (ds/opt :orderQty) string?
   (ds/opt :price) string?
   (ds/opt :lastShares) string?
   (ds/opt :lastPrice) string?
   (ds/opt :cumQty) string?
   (ds/opt :leavesQty) string?
   (ds/opt :avgPrice) string?
   (ds/opt :side) string?
   (ds/opt :orderId) string?
   (ds/opt :account) string?
   (ds/opt :secType) string?
   (ds/opt :txTime) string?
   (ds/opt :rcptTime) string?
   (ds/opt :tif) string?
   (ds/opt :conid) string?
   (ds/opt :currency) string?
   (ds/opt :exchange) string?
   (ds/opt :listingExchange) string?
   (ds/opt :text) float?
   (ds/opt :warnings) order-data-warnings-spec
   (ds/opt :commCurr) string?
   (ds/opt :comms) string?
   (ds/opt :realizedPnl) string?
   })

(def order-data-spec
  (ds/spec
    {:name ::order-data
     :spec order-data-data}))
