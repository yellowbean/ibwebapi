(ns client-portal-web-api.specs.trade
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def trade-data
  {
   (ds/opt :execution_id) string?
   (ds/opt :symbol) string?
   (ds/opt :side) string?
   (ds/opt :order_description) string?
   (ds/opt :trade_time) string?
   (ds/opt :trade_time_r) float?
   (ds/opt :size) string?
   (ds/opt :price) string?
   (ds/opt :order_ref) string?
   (ds/opt :submitter) string?
   (ds/opt :exchange) string?
   (ds/opt :commission) float?
   (ds/opt :net_amount) float?
   (ds/opt :account) string?
   (ds/opt :acountCode) string?
   (ds/opt :company_name) string?
   (ds/opt :contract_description_1) string?
   (ds/opt :sec_type) string?
   (ds/opt :conid) string?
   (ds/opt :conidex) string?
   (ds/opt :position) string?
   (ds/opt :clearing_id) string?
   (ds/opt :clearing_name) string?
   (ds/opt :liquidation_trade) float?
   })

(def trade-spec
  (ds/spec
    {:name ::trade
     :spec trade-data}))
