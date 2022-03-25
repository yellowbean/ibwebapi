(ns client-portal-web-api.specs.inline-response-200-33
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def inline-response-200-33-data
  {
   (ds/opt :server_id) string?
   (ds/opt :column_name) string?
   (ds/opt :symbol) string?
   (ds/opt :conidex) string?
   (ds/opt :con_id) float?
   (ds/opt :available_chart_periods) string?
   (ds/opt :company_name) string?
   (ds/opt :contract_description_1) string?
   (ds/opt :listing_exchange) string?
   (ds/opt :sec_type) string?
   })

(def inline-response-200-33-spec
  (ds/spec
    {:name ::inline-response-200-33
     :spec inline-response-200-33-data}))
