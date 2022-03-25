(ns client-portal-web-api.specs.inline-response-200-35
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def inline-response-200-35-data
  {
   (ds/opt :confirmed) boolean?
   })

(def inline-response-200-35-spec
  (ds/spec
    {:name ::inline-response-200-35
     :spec inline-response-200-35-data}))
