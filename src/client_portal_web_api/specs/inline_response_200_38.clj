(ns client-portal-web-api.specs.inline-response-200-38
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def inline-response-200-38-data
  {
   (ds/opt :authenticated) boolean?
   (ds/opt :connected) boolean?
   (ds/opt :name) string?
   })

(def inline-response-200-38-spec
  (ds/spec
    {:name ::inline-response-200-38
     :spec inline-response-200-38-data}))
