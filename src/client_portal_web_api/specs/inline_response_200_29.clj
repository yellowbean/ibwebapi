(ns client-portal-web-api.specs.inline-response-200-29
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [client-portal-web-api.specs.-iserver-contract-conid-algos-parameters :refer :all]
            )
  (:import (java.io File)))


(def inline-response-200-29-data
  {
   (ds/opt :name) string?
   (ds/opt :description) string?
   (ds/opt :id) string?
   (ds/opt :parameters) (s/coll-of -iserver-contract-conid-algos-parameters-spec)
   })

(def inline-response-200-29-spec
  (ds/spec
    {:name ::inline-response-200-29
     :spec inline-response-200-29-data}))
