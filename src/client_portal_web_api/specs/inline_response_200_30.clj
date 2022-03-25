(ns client-portal-web-api.specs.inline-response-200-30
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [client-portal-web-api.specs.inline-response-200-30-rules :refer :all]
            )
  (:import (java.io File)))


(def inline-response-200-30-data
  {
   (ds/opt :rules) (s/coll-of inline-response-200-30-rules-spec)
   })

(def inline-response-200-30-spec
  (ds/spec
    {:name ::inline-response-200-30
     :spec inline-response-200-30-data}))
