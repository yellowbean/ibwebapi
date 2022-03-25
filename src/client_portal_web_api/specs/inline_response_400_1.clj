(ns client-portal-web-api.specs.inline-response-400-1
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def inline-response-400-1-data
  {
   (ds/opt :error) string?
   (ds/opt :statusCode) int?
   })

(def inline-response-400-1-spec
  (ds/spec
    {:name ::inline-response-400-1
     :spec inline-response-400-1-data}))
