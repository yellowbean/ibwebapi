(ns client-portal-web-api.specs.inline-object-3
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def inline-object-3-data
  {
   (ds/opt :acctIds) (s/coll-of string?)
   })

(def inline-object-3-spec
  (ds/spec
    {:name ::inline-object-3
     :spec inline-object-3-data}))
