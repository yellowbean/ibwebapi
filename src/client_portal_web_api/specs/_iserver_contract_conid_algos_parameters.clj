(ns client-portal-web-api.specs.-iserver-contract-conid-algos-parameters
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def -iserver-contract-conid-algos-parameters-data
  {
   (ds/req :id) string?
   (ds/opt :required) boolean?
   (ds/opt :name) string?
   (ds/req :valueClassName) string?
   (ds/opt :minValue) float?
   (ds/opt :maxValue) float?
   (ds/opt :defaultValue) boolean?
   (ds/opt :legalStrings) string?
   (ds/opt :description) string?
   (ds/opt :guiRank) float?
   (ds/opt :priceMarketRule) boolean?
   (ds/opt :enabledConditions) string?
   })

(def -iserver-contract-conid-algos-parameters-spec
  (ds/spec
    {:name ::-iserver-contract-conid-algos-parameters
     :spec -iserver-contract-conid-algos-parameters-data}))
