(ns client-portal-web-api.specs.inline-object-8
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def inline-object-8-data
  {
   (ds/opt :alertId) int?
   (ds/opt :alertActive) int?
   })

(def inline-object-8-spec
  (ds/spec
    {:name ::inline-object-8
     :spec inline-object-8-data}))
