(ns client-portal-web-api.specs.inline-response-200-21-amount
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def inline-response-200-21-amount-data
  {
   (ds/opt :amount) string?
   (ds/opt :commission) string?
   (ds/opt :total) string?
   })

(def inline-response-200-21-amount-spec
  (ds/spec
    {:name ::inline-response-200-21-amount
     :spec inline-response-200-21-amount-data}))
