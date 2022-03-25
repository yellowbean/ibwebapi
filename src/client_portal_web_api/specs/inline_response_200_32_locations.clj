(ns client-portal-web-api.specs.inline-response-200-32-locations
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def inline-response-200-32-locations-data
  {
   (ds/opt :display_name) string?
   (ds/opt :type) string?
   })

(def inline-response-200-32-locations-spec
  (ds/spec
    {:name ::inline-response-200-32-locations
     :spec inline-response-200-32-locations-data}))
