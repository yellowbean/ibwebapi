(ns client-portal-web-api.specs.inline-response-200-4-metadata
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def inline-response-200-4-metadata-data
  {
   (ds/opt :total) float?
   (ds/opt :pageSize) float?
   (ds/opt :pageNume) float?
   })

(def inline-response-200-4-metadata-spec
  (ds/spec
    {:name ::inline-response-200-4-metadata
     :spec inline-response-200-4-metadata-data}))
