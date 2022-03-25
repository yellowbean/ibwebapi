(ns client-portal-web-api.specs.scanner-params
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [client-portal-web-api.specs.scanner-params-filter :refer :all]
            )
  (:import (java.io File)))


(def scanner-params-data
  {
   (ds/opt :instrument) string?
   (ds/opt :type) string?
   (ds/opt :filter) (s/coll-of scanner-params-filter-spec)
   (ds/opt :location) string?
   (ds/opt :size) string?
   })

(def scanner-params-spec
  (ds/spec
    {:name ::scanner-params
     :spec scanner-params-data}))
