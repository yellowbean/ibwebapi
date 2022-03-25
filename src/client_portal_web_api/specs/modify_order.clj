(ns client-portal-web-api.specs.modify-order
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def modify-order-data
  {
   (ds/opt :acctId) string?
   (ds/opt :conid) int?
   (ds/opt :orderType) string?
   (ds/opt :outsideRTH) boolean?
   (ds/opt :price) float?
   (ds/opt :auxPrice) float?
   (ds/opt :side) string?
   (ds/opt :listingExchange) string?
   (ds/opt :ticker) string?
   (ds/opt :tif) string?
   (ds/opt :quantity) float?
   (ds/opt :deactivated) boolean?
   })

(def modify-order-spec
  (ds/spec
    {:name ::modify-order
     :spec modify-order-data}))
