(ns client-portal-web-api.specs.inline-response-200-31-rules
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [client-portal-web-api.specs.inline-response-200-30-can-trade-acct-ids :refer :all]
            [client-portal-web-api.specs.inline-response-200-30-order-types :refer :all]
            [client-portal-web-api.specs.inline-response-200-30-ibalgo-types :refer :all]
            [client-portal-web-api.specs.inline-response-200-30-fraq-types :refer :all]
            [client-portal-web-api.specs.inline-response-200-30-cqt-types :refer :all]
            [client-portal-web-api.specs.inline-response-200-30-order-defaults :refer :all]
            [client-portal-web-api.specs.inline-response-200-30-order-types-outside :refer :all]
            [client-portal-web-api.specs.inline-response-200-30-tif-types :refer :all]
            )
  (:import (java.io File)))


(def inline-response-200-31-rules-data
  {
   (ds/opt :algoEligible) boolean?
   (ds/opt :canTradeAcctIds) (s/coll-of inline-response-200-30-can-trade-acct-ids-spec)
   (ds/opt :error) string?
   (ds/opt :orderTypes) (s/coll-of inline-response-200-30-order-types-spec)
   (ds/opt :ibalgoTypes) (s/coll-of inline-response-200-30-ibalgo-types-spec)
   (ds/opt :fraqTypes) (s/coll-of inline-response-200-30-fraq-types-spec)
   (ds/opt :cqtTypes) (s/coll-of inline-response-200-30-cqt-types-spec)
   (ds/opt :orderDefaults) (s/coll-of inline-response-200-30-order-defaults-spec)
   (ds/opt :orderTypesOutside) (s/coll-of inline-response-200-30-order-types-outside-spec)
   (ds/opt :defaultSize) int?
   (ds/opt :cashSize) int?
   (ds/opt :sizeIncrement) int?
   (ds/opt :tifTypes) (s/coll-of inline-response-200-30-tif-types-spec)
   (ds/opt :defaultTIF) string?
   (ds/opt :limitPrice) float?
   (ds/opt :stopprice) float?
   (ds/opt :orderOrigination) float?
   (ds/opt :preview) boolean?
   (ds/opt :displaySize) float?
   (ds/opt :fraqInt) float?
   (ds/opt :cashCcy) string?
   (ds/opt :cashQtyIncr) float?
   (ds/opt :priceMagnifier) float?
   (ds/opt :negativeCapable) boolean?
   (ds/opt :increment) float?
   (ds/opt :incrementDigits) int?
   })

(def inline-response-200-31-rules-spec
  (ds/spec
    {:name ::inline-response-200-31-rules
     :spec inline-response-200-31-rules-data}))
