(ns client-portal-web-api.specs.inline-response-200-3
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def inline-response-200-3-data
  {
   (ds/opt :LOGIN_TYPE) float?
   (ds/opt :USER_NAME) string?
   (ds/opt :USER_ID) float?
   (ds/opt :expire) float?
   (ds/opt :RESULT) boolean?
   (ds/opt :AUTH_TIME) float?
   })

(def inline-response-200-3-spec
  (ds/spec
    {:name ::inline-response-200-3
     :spec inline-response-200-3-data}))
