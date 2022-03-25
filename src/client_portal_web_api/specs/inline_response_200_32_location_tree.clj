(ns client-portal-web-api.specs.inline-response-200-32-location-tree
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [client-portal-web-api.specs.inline-response-200-32-locations :refer :all]
            )
  (:import (java.io File)))


(def inline-response-200-32-location-tree-data
  {
   (ds/opt :display_name) string?
   (ds/opt :type) string?
   (ds/opt :locations) (s/coll-of inline-response-200-32-locations-spec)
   })

(def inline-response-200-32-location-tree-spec
  (ds/spec
    {:name ::inline-response-200-32-location-tree
     :spec inline-response-200-32-location-tree-data}))
