(ns client-portal-web-api.specs.inline-response-200-37
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def inline-response-200-37-data
  {
   (ds/opt :passed) boolean?
   (ds/opt :authenticated) boolean?
   (ds/opt :connected) boolean?
   (ds/opt :competing) boolean?
   })

(def inline-response-200-37-spec
  (ds/spec
    {:name ::inline-response-200-37
     :spec inline-response-200-37-data}))
