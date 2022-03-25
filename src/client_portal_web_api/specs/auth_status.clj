(ns client-portal-web-api.specs.auth-status
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def auth-status-data
  {
   (ds/opt :authenticated) boolean?
   (ds/opt :connected) boolean?
   (ds/opt :competing) boolean?
   (ds/opt :fail) string?
   (ds/opt :message) string?
   (ds/opt :prompts) (s/coll-of string?)
   })

(def auth-status-spec
  (ds/spec
    {:name ::auth-status
     :spec auth-status-data}))
