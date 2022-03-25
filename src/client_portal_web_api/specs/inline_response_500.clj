(ns client-portal-web-api.specs.inline-response-500
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def inline-response-500-data
  {
   (ds/opt :error) string?
   })

(def inline-response-500-spec
  (ds/spec
    {:name ::inline-response-500
     :spec inline-response-500-data}))
