(ns client-portal-web-api.specs.account
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [client-portal-web-api.specs.account-parent :refer :all]
            )
  (:import (java.io File)))


(def account-data
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
   (ds/opt :covestor) boolean?
   (ds/opt :parent) account-parent-spec
   (ds/opt :desc) string?
   })

(def account-spec
  (ds/spec
    {:name ::account
     :spec account-data}))
