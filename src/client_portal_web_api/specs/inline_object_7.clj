(ns client-portal-web-api.specs.inline-object-7
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def inline-object-7-data
  {
   (ds/opt :devicename) string?
   (ds/opt :deviceId) string?
   (ds/opt :uiName) string?
   (ds/opt :enabled) boolean?
   })

(def inline-object-7-spec
  (ds/spec
    {:name ::inline-object-7
     :spec inline-object-7-data}))
