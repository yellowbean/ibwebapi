(ns client-portal-web-api.specs.inline-response-200-sessions
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def inline-response-200-sessions-data
  {
   (ds/opt :openingTime) int?
   (ds/opt :closingTime) int?
   (ds/opt :prop) string?
   })

(def inline-response-200-sessions-spec
  (ds/spec
    {:name ::inline-response-200-sessions
     :spec inline-response-200-sessions-data}))
