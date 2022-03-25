(ns client-portal-web-api.specs.inline-response-200-23
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def inline-response-200-23-data
  {
   (ds/opt :order_id) string?
   (ds/opt :msg) string?
   (ds/opt :conid) int?
   (ds/opt :account) string?
   })

(def inline-response-200-23-spec
  (ds/spec
    {:name ::inline-response-200-23
     :spec inline-response-200-23-data}))
