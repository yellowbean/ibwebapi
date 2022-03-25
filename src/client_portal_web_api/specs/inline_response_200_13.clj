(ns client-portal-web-api.specs.inline-response-200-13
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [client-portal-web-api.specs. :refer :all]
            )
  (:import (java.io File)))


(def inline-response-200-13-data
  {
   (ds/opt :accounts) (s/coll-of string?)
   (ds/opt :aliases) any?
   (ds/opt :selectedAccount) string?
   })

(def inline-response-200-13-spec
  (ds/spec
    {:name ::inline-response-200-13
     :spec inline-response-200-13-data}))
