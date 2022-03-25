(ns client-portal-web-api.specs.alert-request-conditions
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def alert-request-conditions-data
  {
   (ds/opt :type) int?
   (ds/opt :conidex) string?
   (ds/opt :operator) string?
   (ds/opt :triggerMethod) string?
   (ds/opt :value) string?
   (ds/opt :logicBind) string?
   (ds/opt :timeZone) string?
   })

(def alert-request-conditions-spec
  (ds/spec
    {:name ::alert-request-conditions
     :spec alert-request-conditions-data}))
