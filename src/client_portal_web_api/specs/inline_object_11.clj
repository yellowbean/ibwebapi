(ns client-portal-web-api.specs.inline-object-11
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def inline-object-11-data
  {
   (ds/opt :confirmed) boolean?
   })

(def inline-object-11-spec
  (ds/spec
    {:name ::inline-object-11
     :spec inline-object-11-data}))
