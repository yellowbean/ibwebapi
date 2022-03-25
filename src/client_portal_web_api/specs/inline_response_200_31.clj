(ns client-portal-web-api.specs.inline-response-200-31
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [client-portal-web-api.specs.inline-response-200-31-rules :refer :all]
            )
  (:import (java.io File)))


(def inline-response-200-31-data
  {
   (ds/opt :cfi_code) string?
   (ds/opt :symbol) string?
   (ds/opt :cusip) string?
   (ds/opt :expiry_full) float?
   (ds/opt :con_id) float?
   (ds/opt :maturity_date) float?
   (ds/opt :industry) string?
   (ds/opt :instrument_type) string?
   (ds/opt :trading_class) string?
   (ds/opt :valid_exchanges) string?
   (ds/opt :allow_sell_long) boolean?
   (ds/opt :is_zero_commission_security) boolean?
   (ds/opt :local_symbol) string?
   (ds/opt :classifier) string?
   (ds/opt :currency) string?
   (ds/opt :text) string?
   (ds/opt :underlying_con_id) float?
   (ds/opt :r_t_h) boolean?
   (ds/opt :multiplier) string?
   (ds/opt :strike) string?
   (ds/opt :right) string?
   (ds/opt :underlying_issuer) string?
   (ds/opt :contract_month) string?
   (ds/opt :company_name) string?
   (ds/opt :smart_available) boolean?
   (ds/opt :exchange) string?
   (ds/opt :rules) (s/coll-of inline-response-200-31-rules-spec)
   })

(def inline-response-200-31-spec
  (ds/spec
    {:name ::inline-response-200-31
     :spec inline-response-200-31-data}))
