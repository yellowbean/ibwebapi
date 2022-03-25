(ns client-portal-web-api.specs.inline-response-200-36
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [client-portal-web-api.specs. :refer :all]
            )
  (:import (java.io File)))


(def inline-response-200-36-data
  {
   (ds/opt :challenge) any?
   })

(def inline-response-200-36-spec
  (ds/spec
    {:name ::inline-response-200-36
     :spec inline-response-200-36-data}))
