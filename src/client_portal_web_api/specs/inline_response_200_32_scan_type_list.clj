(ns client-portal-web-api.specs.inline-response-200-32-scan-type-list
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def inline-response-200-32-scan-type-list-data
  {
   (ds/opt :display_name) string?
   (ds/opt :code) string?
   (ds/opt :instruments) (s/coll-of string?)
   })

(def inline-response-200-32-scan-type-list-spec
  (ds/spec
    {:name ::inline-response-200-32-scan-type-list
     :spec inline-response-200-32-scan-type-list-data}))
