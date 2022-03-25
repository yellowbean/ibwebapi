(ns client-portal-web-api.specs.transactions-transactions
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def transactions-transactions-data
  {
   (ds/opt :acctid) string?
   (ds/opt :conid) float?
   (ds/opt :cur) string?
   (ds/opt :fxRate) float?
   (ds/opt :desc) string?
   (ds/opt :date) string?
   (ds/opt :type) string?
   (ds/opt :qty) float?
   (ds/opt :pr) float?
   (ds/opt :amt) float?
   })

(def transactions-transactions-spec
  (ds/spec
    {:name ::transactions-transactions
     :spec transactions-transactions-data}))
