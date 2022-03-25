(ns client-portal-web-api.specs.inline-response-200-21
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [client-portal-web-api.specs.inline-response-200-21-amount :refer :all]
            [client-portal-web-api.specs.inline-response-200-21-equity :refer :all]
            [client-portal-web-api.specs.inline-response-200-21-equity :refer :all]
            [client-portal-web-api.specs.inline-response-200-21-equity :refer :all]
            )
  (:import (java.io File)))


(def inline-response-200-21-data
  {
   (ds/opt :amount) inline-response-200-21-amount-spec
   (ds/opt :equity) inline-response-200-21-equity-spec
   (ds/opt :initial) inline-response-200-21-equity-spec
   (ds/opt :maintenance) inline-response-200-21-equity-spec
   (ds/opt :warn) string?
   (ds/opt :error) string?
   })

(def inline-response-200-21-spec
  (ds/spec
    {:name ::inline-response-200-21
     :spec inline-response-200-21-data}))
