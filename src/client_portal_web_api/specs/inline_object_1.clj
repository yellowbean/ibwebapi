(ns client-portal-web-api.specs.inline-object-1
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [client-portal-web-api.specs.-hmds-scanner-filters :refer :all]
            )
  (:import (java.io File)))


(def inline-object-1-data
  {
   (ds/opt :instrument) string?
   (ds/opt :locations) string?
   (ds/opt :scanCode) string?
   (ds/opt :secType) string?
   (ds/opt :filters) (s/coll-of -hmds-scanner-filters-spec)
   })

(def inline-object-1-spec
  (ds/spec
    {:name ::inline-object-1
     :spec inline-object-1-data}))
