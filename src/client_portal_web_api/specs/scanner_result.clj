(ns client-portal-web-api.specs.scanner-result
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [client-portal-web-api.specs.scanner-result-contracts :refer :all]
            )
  (:import (java.io File)))


(def scanner-result-data
  {
   (ds/opt :total) int?
   (ds/opt :size) int?
   (ds/opt :offset) int?
   (ds/opt :scanTime) string?
   (ds/opt :id) float?
   (ds/opt :position) string?
   (ds/opt :Contracts) scanner-result-contracts-spec
   })

(def scanner-result-spec
  (ds/spec
    {:name ::scanner-result
     :spec scanner-result-data}))
