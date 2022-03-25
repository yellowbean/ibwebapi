(ns client-portal-web-api.specs.inline-response-200-6
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [client-portal-web-api.specs.ledger :refer :all]
            )
  (:import (java.io File)))


(def inline-response-200-6-data
  {
   (ds/opt :BASE) ledger-spec
   })

(def inline-response-200-6-spec
  (ds/spec
    {:name ::inline-response-200-6
     :spec inline-response-200-6-data}))
