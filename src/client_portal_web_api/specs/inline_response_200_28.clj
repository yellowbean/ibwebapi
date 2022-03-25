(ns client-portal-web-api.specs.inline-response-200-28
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def inline-response-200-28-data
  {
   (ds/opt :call) (s/coll-of string?)
   (ds/opt :put) (s/coll-of string?)
   })

(def inline-response-200-28-spec
  (ds/spec
    {:name ::inline-response-200-28
     :spec inline-response-200-28-data}))
