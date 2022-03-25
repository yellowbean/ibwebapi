(ns client-portal-web-api.specs.inline-response-200-12-e
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def inline-response-200-12-e-data
  {
   (ds/opt :NM) string?
   (ds/opt :I) string?
   (ds/opt :UI) string?
   (ds/opt :A) string?
   })

(def inline-response-200-12-e-spec
  (ds/spec
    {:name ::inline-response-200-12-e
     :spec inline-response-200-12-e-data}))
