(ns client-portal-web-api.specs.inline-response-200-18-orders
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def inline-response-200-18-orders-data
  {
   (ds/opt :acct) string?
   (ds/opt :conidex) string?
   (ds/opt :conid) float?
   (ds/opt :orderId) string?
   (ds/opt :cashCcy) string?
   (ds/opt :sizeAndFills) float?
   (ds/opt :orderDesc) string?
   (ds/opt :description1) string?
   (ds/opt :ticker) string?
   (ds/opt :secType) string?
   (ds/opt :listingExchange) string?
   (ds/opt :remainingQuantity) float?
   (ds/opt :filledQuantity) float?
   (ds/opt :companyName) string?
   (ds/opt :status) string?
   (ds/opt :origOrderType) string?
   (ds/opt :supportsTaxOpt) float?
   (ds/opt :lastExecutionTime) float?
   (ds/opt :lastExecutionTime_r) float?
   (ds/opt :orderType) string?
   (ds/opt :order_ref) string?
   (ds/opt :side) string?
   (ds/opt :timeInForce) string?
   (ds/opt :price) float?
   (ds/opt :bgColor) string?
   (ds/opt :fgColor) string?
   })

(def inline-response-200-18-orders-spec
  (ds/spec
    {:name ::inline-response-200-18-orders
     :spec inline-response-200-18-orders-data}))
