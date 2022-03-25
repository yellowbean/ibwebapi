(ns client-portal-web-api.specs.set-account
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def set-account-data
  {
   (ds/opt :acctId) string?
   })

(def set-account-spec
  (ds/spec
    {:name ::set-account
     :spec set-account-data}))
