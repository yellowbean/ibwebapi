(ns client-portal-web-api.specs.scanner-result-contracts-contract
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def scanner-result-contracts-contract-data
  {
   (ds/opt :inScanTime) string?
   (ds/opt :distance) int?
   (ds/opt :contractID) int?
   })

(def scanner-result-contracts-contract-spec
  (ds/spec
    {:name ::scanner-result-contracts-contract
     :spec scanner-result-contracts-contract-data}))
