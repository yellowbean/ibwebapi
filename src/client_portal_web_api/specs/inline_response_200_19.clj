(ns client-portal-web-api.specs.inline-response-200-19
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def inline-response-200-19-data
  {
   (ds/opt :id) string?
   (ds/opt :message) (s/coll-of string?)
   })

(def inline-response-200-19-spec
  (ds/spec
    {:name ::inline-response-200-19
     :spec inline-response-200-19-data}))
