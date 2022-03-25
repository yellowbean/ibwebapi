(ns client-portal-web-api.specs.inline-response-200-39-acct-list
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def inline-response-200-39-acct-list-data
  {
   (ds/opt :0) string?
   })

(def inline-response-200-39-acct-list-spec
  (ds/spec
    {:name ::inline-response-200-39-acct-list
     :spec inline-response-200-39-acct-list-data}))
