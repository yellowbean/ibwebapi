(ns client-portal-web-api.specs.scanner-result-contracts
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [client-portal-web-api.specs.scanner-result-contracts-contract :refer :all]
            )
  (:import (java.io File)))


(def scanner-result-contracts-data
  {
   (ds/opt :Contract) (s/coll-of scanner-result-contracts-contract-spec)
   })

(def scanner-result-contracts-spec
  (ds/spec
    {:name ::scanner-result-contracts
     :spec scanner-result-contracts-data}))
