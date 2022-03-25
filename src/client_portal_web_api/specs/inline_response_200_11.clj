(ns client-portal-web-api.specs.inline-response-200-11
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def inline-response-200-11-data
  {
   (ds/opt :T) int?
   (ds/opt :V) int?
   })

(def inline-response-200-11-spec
  (ds/spec
    {:name ::inline-response-200-11
     :spec inline-response-200-11-data}))
