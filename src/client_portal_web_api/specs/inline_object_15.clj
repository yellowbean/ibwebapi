(ns client-portal-web-api.specs.inline-object-15
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def inline-object-15-data
  {
   (ds/opt :response) string?
   })

(def inline-object-15-spec
  (ds/spec
    {:name ::inline-object-15
     :spec inline-object-15-data}))
