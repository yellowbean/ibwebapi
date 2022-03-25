(ns client-portal-web-api.specs.inline-object-14
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def inline-object-14-data
  {
   (ds/req :conid) string?
   (ds/req :isBuy) boolean?
   })

(def inline-object-14-spec
  (ds/spec
    {:name ::inline-object-14
     :spec inline-object-14-data}))
