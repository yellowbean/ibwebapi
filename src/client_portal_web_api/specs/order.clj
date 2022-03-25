(ns client-portal-web-api.specs.order
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def order-data
  {
   (ds/opt :acct) string?
   (ds/opt :conid) int?
   (ds/opt :orderDesc) string?
   (ds/opt :description1) string?
   (ds/opt :ticker) string?
   (ds/opt :secType) string?
   (ds/opt :listingExchange) string?
   (ds/opt :remainingQuantity) string?
   (ds/opt :filledQuantity) string?
   (ds/opt :companyName) string?
   (ds/opt :status) string?
   (ds/opt :origOrderType) string?
   (ds/opt :side) string?
   (ds/opt :price) float?
   (ds/opt :bgColor) string?
   (ds/opt :fgColor) string?
   (ds/opt :orderId) int?
   (ds/opt :parentId) int?
   (ds/opt :order_ref) string?
   })

(def order-spec
  (ds/spec
    {:name ::order
     :spec order-data}))
