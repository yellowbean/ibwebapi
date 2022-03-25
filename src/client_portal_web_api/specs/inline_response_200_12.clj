(ns client-portal-web-api.specs.inline-response-200-12
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [client-portal-web-api.specs.inline-response-200-12-e :refer :all]
            )
  (:import (java.io File)))


(def inline-response-200-12-data
  {
   (ds/opt :M) int?
   (ds/opt :E) (s/coll-of inline-response-200-12-e-spec)
   })

(def inline-response-200-12-spec
  (ds/spec
    {:name ::inline-response-200-12
     :spec inline-response-200-12-data}))
