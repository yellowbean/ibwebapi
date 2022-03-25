(ns client-portal-web-api.specs.account-parent
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def account-parent-data
  {
   (ds/opt :mmc) (s/coll-of string?)
   (ds/opt :accountId) string?
   (ds/opt :isMParent) boolean?
   (ds/opt :isMChild) boolean?
   (ds/opt :isMultiplex) boolean?
   })

(def account-parent-spec
  (ds/spec
    {:name ::account-parent
     :spec account-parent-data}))
