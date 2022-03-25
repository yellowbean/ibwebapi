(ns client-portal-web-api.specs.alert-request
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [client-portal-web-api.specs.alert-request-conditions :refer :all]
            )
  (:import (java.io File)))


(def alert-request-data
  {
   (ds/opt :orderId) int?
   (ds/opt :alertName) string?
   (ds/opt :alertMessage) string?
   (ds/opt :alertRepeatable) int?
   (ds/opt :email) string?
   (ds/opt :sendMessage) int?
   (ds/opt :tif) string?
   (ds/opt :expireTime) string?
   (ds/opt :outsideRth) int?
   (ds/opt :iTWSOrdersOnly) int?
   (ds/opt :showPopup) int?
   (ds/opt :toolId) int?
   (ds/opt :playAudio) string?
   (ds/opt :conditions) (s/coll-of alert-request-conditions-spec)
   })

(def alert-request-spec
  (ds/spec
    {:name ::alert-request
     :spec alert-request-data}))
