(ns client-portal-web-api.specs.alert-response-conditions
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def alert-response-conditions-data
  {
   (ds/opt :condition_type) int?
   (ds/opt :conidex) string?
   (ds/opt :contract_description_1) string?
   (ds/opt :condition_operator) string?
   (ds/opt :condition_trigger_method) string?
   (ds/opt :condition_value) string?
   (ds/opt :condition_logic_bind) string?
   (ds/opt :condition_time_zone) string?
   })

(def alert-response-conditions-spec
  (ds/spec
    {:name ::alert-response-conditions
     :spec alert-response-conditions-data}))
