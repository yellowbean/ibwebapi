(ns client-portal-web-api.specs.order-data-warnings
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def order-data-warnings-data
  {
   (ds/opt :PRICECAP) string?
   (ds/opt :TIME) string?
   })

(def order-data-warnings-spec
  (ds/spec
    {:name ::order-data-warnings
     :spec order-data-warnings-data}))
