(ns client-portal-web-api.specs.transactions
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [client-portal-web-api.specs.transactions-transactions :refer :all]
            )
  (:import (java.io File)))


(def transactions-data
  {
   (ds/opt :id) string?
   (ds/opt :currency) string?
   (ds/opt :includesRealTime) boolean?
   (ds/opt :from) float?
   (ds/opt :to) float?
   (ds/opt :transactions) (s/coll-of transactions-transactions-spec)
   })

(def transactions-spec
  (ds/spec
    {:name ::transactions
     :spec transactions-data}))
