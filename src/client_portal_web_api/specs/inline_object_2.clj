(ns client-portal-web-api.specs.inline-object-2
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def inline-object-2-data
  {
   (ds/opt :acctIds) (s/coll-of string?)
   (ds/opt :freq) string?
   })

(def inline-object-2-spec
  (ds/spec
    {:name ::inline-object-2
     :spec inline-object-2-data}))
