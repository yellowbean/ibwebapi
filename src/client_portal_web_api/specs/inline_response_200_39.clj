(ns client-portal-web-api.specs.inline-response-200-39
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [client-portal-web-api.specs.inline-response-200-39-acct-list :refer :all]
            )
  (:import (java.io File)))


(def inline-response-200-39-data
  {
   (ds/opt :mainAcct) string?
   (ds/opt :acctList) (s/coll-of inline-response-200-39-acct-list-spec)
   })

(def inline-response-200-39-spec
  (ds/spec
    {:name ::inline-response-200-39
     :spec inline-response-200-39-data}))
