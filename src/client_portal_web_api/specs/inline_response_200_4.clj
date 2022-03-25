(ns client-portal-web-api.specs.inline-response-200-4
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [client-portal-web-api.specs.inline-response-200-4-metadata :refer :all]
            [client-portal-web-api.specs.inline-response-200-4-subaccounts :refer :all]
            )
  (:import (java.io File)))


(def inline-response-200-4-data
  {
   (ds/opt :metadata) inline-response-200-4-metadata-spec
   (ds/opt :subaccounts) (s/coll-of inline-response-200-4-subaccounts-spec)
   })

(def inline-response-200-4-spec
  (ds/spec
    {:name ::inline-response-200-4
     :spec inline-response-200-4-data}))
