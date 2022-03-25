(ns client-portal-web-api.specs.-hmds-scanner-filters
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [client-portal-web-api.specs. :refer :all]
            )
  (:import (java.io File)))


(def -hmds-scanner-filters-data
  {
   (ds/opt :code) string?
   (ds/opt :value) any?
   })

(def -hmds-scanner-filters-spec
  (ds/spec
    {:name ::-hmds-scanner-filters
     :spec -hmds-scanner-filters-data}))
