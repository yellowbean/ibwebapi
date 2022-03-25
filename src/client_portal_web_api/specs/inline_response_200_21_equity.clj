(ns client-portal-web-api.specs.inline-response-200-21-equity
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def inline-response-200-21-equity-data
  {
   (ds/opt :current) string?
   (ds/opt :change) string?
   (ds/opt :after) string?
   })

(def inline-response-200-21-equity-spec
  (ds/spec
    {:name ::inline-response-200-21-equity
     :spec inline-response-200-21-equity-data}))
