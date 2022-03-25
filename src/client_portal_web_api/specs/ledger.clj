(ns client-portal-web-api.specs.ledger
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def ledger-data
  {
   (ds/opt :commoditymarketvalue) float?
   (ds/opt :futuremarketvalue) float?
   (ds/opt :settledcash) float?
   (ds/opt :exchangerate) float?
   (ds/opt :sessionid) int?
   (ds/opt :cashbalance) float?
   (ds/opt :corporatebondsmarketvalue) float?
   (ds/opt :warrantsmarketvalue) float?
   (ds/opt :netliquidationvalue) float?
   (ds/opt :interest) float?
   (ds/opt :unrealizedpnl) float?
   (ds/opt :stockmarketvalue) float?
   (ds/opt :moneyfunds) float?
   (ds/opt :currency) string?
   (ds/opt :realizedpnl) float?
   (ds/opt :funds) float?
   (ds/opt :acctcode) string?
   (ds/opt :issueroptionsmarketvalue) float?
   (ds/opt :key) string?
   (ds/opt :timestamp) int?
   (ds/opt :severity) int?
   })

(def ledger-spec
  (ds/spec
    {:name ::ledger
     :spec ledger-data}))
