(ns client-portal-web-api.specs.inline-response-200-32
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [client-portal-web-api.specs.inline-response-200-32-scan-type-list :refer :all]
            [client-portal-web-api.specs.inline-response-200-32-instrument-list :refer :all]
            [client-portal-web-api.specs.inline-response-200-32-filter-list :refer :all]
            [client-portal-web-api.specs.inline-response-200-32-location-tree :refer :all]
            )
  (:import (java.io File)))


(def inline-response-200-32-data
  {
   (ds/opt :scan_type_list) (s/coll-of inline-response-200-32-scan-type-list-spec)
   (ds/opt :instrument_list) (s/coll-of inline-response-200-32-instrument-list-spec)
   (ds/opt :filter_list) (s/coll-of inline-response-200-32-filter-list-spec)
   (ds/opt :location_tree) (s/coll-of inline-response-200-32-location-tree-spec)
   })

(def inline-response-200-32-spec
  (ds/spec
    {:name ::inline-response-200-32
     :spec inline-response-200-32-data}))
