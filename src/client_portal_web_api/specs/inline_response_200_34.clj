(ns client-portal-web-api.specs.inline-response-200-34
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [client-portal-web-api.specs. :refer :all]
            )
  (:import (java.io File)))


(def inline-response-200-34-data
  {
   (ds/opt :acctId) any?
   })

(def inline-response-200-34-spec
  (ds/spec
    {:name ::inline-response-200-34
     :spec inline-response-200-34-data}))
