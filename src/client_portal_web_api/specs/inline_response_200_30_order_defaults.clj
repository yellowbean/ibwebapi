(ns client-portal-web-api.specs.inline-response-200-30-order-defaults
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [client-portal-web-api.specs.inline-response-200-30-string :refer :all]
            )
  (:import (java.io File)))


(def inline-response-200-30-order-defaults-data
  {
   (ds/opt :string) (s/coll-of inline-response-200-30-string-spec)
   })

(def inline-response-200-30-order-defaults-spec
  (ds/spec
    {:name ::inline-response-200-30-order-defaults
     :spec inline-response-200-30-order-defaults-data}))
