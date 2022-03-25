(ns client-portal-web-api.specs.inline-response-200-8
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def inline-response-200-8-data
  {
   (ds/opt :BN) int?
   })

(def inline-response-200-8-spec
  (ds/spec
    {:name ::inline-response-200-8
     :spec inline-response-200-8-data}))
