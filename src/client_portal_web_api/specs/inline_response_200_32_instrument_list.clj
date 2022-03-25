(ns client-portal-web-api.specs.inline-response-200-32-instrument-list
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def inline-response-200-32-instrument-list-data
  {
   (ds/opt :display_name) string?
   (ds/opt :type) string?
   (ds/opt :filters) (s/coll-of string?)
   })

(def inline-response-200-32-instrument-list-spec
  (ds/spec
    {:name ::inline-response-200-32-instrument-list
     :spec inline-response-200-32-instrument-list-data}))
