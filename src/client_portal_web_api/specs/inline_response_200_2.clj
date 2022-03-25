(ns client-portal-web-api.specs.inline-response-200-2
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def inline-response-200-2-data
  {
   (ds/opt :symbol) (s/coll-of any?)
   })

(def inline-response-200-2-spec
  (ds/spec
    {:name ::inline-response-200-2
     :spec inline-response-200-2-data}))
