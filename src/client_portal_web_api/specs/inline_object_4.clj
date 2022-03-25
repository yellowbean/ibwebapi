(ns client-portal-web-api.specs.inline-object-4
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def inline-object-4-data
  {
   (ds/opt :acctIds) (s/coll-of string?)
   (ds/opt :conids) (s/coll-of float?)
   (ds/opt :currency) string?
   (ds/opt :days) float?
   })

(def inline-object-4-spec
  (ds/spec
    {:name ::inline-object-4
     :spec inline-object-4-data}))
