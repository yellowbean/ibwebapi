(ns client-portal-web-api.specs.inline-response-200-4-subaccounts
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def inline-response-200-4-subaccounts-data
  {
   (ds/opt :id) string?
   (ds/opt :accountId) string?
   (ds/opt :accountVan) string?
   (ds/opt :accountTitle) string?
   (ds/opt :displayName) string?
   (ds/opt :accountAlias) string?
   (ds/opt :accountStatus) float?
   (ds/opt :currency) string?
   (ds/opt :type) string?
   (ds/opt :tradingType) string?
   (ds/opt :faclient) boolean?
   (ds/opt :clearingStatus) string?
   })

(def inline-response-200-4-subaccounts-spec
  (ds/spec
    {:name ::inline-response-200-4-subaccounts
     :spec inline-response-200-4-subaccounts-data}))
