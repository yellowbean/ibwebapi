(ns client-portal-web-api.specs.order-request
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [client-portal-web-api.specs. :refer :all]
            [client-portal-web-api.specs. :refer :all]
            )
  (:import (java.io File)))


(def order-request-data
  {
   (ds/opt :acctId) string?
   (ds/opt :conid) int?
   (ds/opt :conidex) string?
   (ds/opt :secType) string?
   (ds/opt :cOID) string?
   (ds/opt :parentId) string?
   (ds/opt :orderType) string?
   (ds/opt :listingExchange) string?
   (ds/opt :isSingleGroup) boolean?
   (ds/opt :outsideRTH) boolean?
   (ds/opt :price) float?
   (ds/opt :auxPrice) any?
   (ds/opt :side) string?
   (ds/opt :ticker) string?
   (ds/opt :tif) string?
   (ds/opt :referrer) string?
   (ds/opt :quantity) float?
   (ds/opt :cashQty) float?
   (ds/opt :fxQty) float?
   (ds/opt :useAdaptive) boolean?
   (ds/opt :isCcyConv) boolean?
   (ds/opt :allocationMethod) string?
   (ds/opt :strategy) string?
   (ds/opt :strategyParameters) any?
   })

(def order-request-spec
  (ds/spec
    {:name ::order-request
     :spec order-request-data}))
