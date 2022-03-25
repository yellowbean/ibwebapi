(ns client-portal-web-api.specs.inline-response-200-32-filter-list
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def inline-response-200-32-filter-list-data
  {
   (ds/opt :group) string?
   (ds/opt :display_name) string?
   (ds/opt :code) string?
   (ds/opt :type) string?
   })

(def inline-response-200-32-filter-list-spec
  (ds/spec
    {:name ::inline-response-200-32-filter-list
     :spec inline-response-200-32-filter-list-data}))
