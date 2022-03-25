(ns client-portal-web-api.specs.inline-object
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def inline-object-data
  {
   (ds/opt :conids) (s/coll-of int?)
   })

(def inline-object-spec
  (ds/spec
    {:name ::inline-object
     :spec inline-object-data}))
