(ns client-portal-web-api.specs.contract
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [client-portal-web-api.specs.contract-rules :refer :all]
            )
  (:import (java.io File)))


(def contract-data
  {
   (ds/opt :r_t_h) boolean?
   (ds/opt :con_id) string?
   (ds/opt :company_name) string?
   (ds/opt :exchange) string?
   (ds/opt :local_symbol) string?
   (ds/opt :instrument_type) string?
   (ds/opt :currency) string?
   (ds/opt :companyName) string?
   (ds/opt :category) string?
   (ds/opt :industry) string?
   (ds/opt :rules) contract-rules-spec
   })

(def contract-spec
  (ds/spec
    {:name ::contract
     :spec contract-data}))
