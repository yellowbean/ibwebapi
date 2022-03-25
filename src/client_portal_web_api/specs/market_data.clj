(ns client-portal-web-api.specs.market-data
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def market-data-data
  {
   (ds/opt :31) string?
   (ds/opt :70) float?
   (ds/opt :71) float?
   (ds/opt :82) string?
   (ds/opt :83) float?
   (ds/opt :84) string?
   (ds/opt :85) string?
   (ds/opt :86) string?
   (ds/opt :87) string?
   (ds/opt :88) string?
   (ds/opt :6509) string?
   (ds/opt :7057) string?
   (ds/opt :7058) string?
   (ds/opt :7059) float?
   (ds/opt :7068) string?
   (ds/opt :7195) string?
   (ds/opt :7196) string?
   (ds/opt :7197) string?
   (ds/opt :7198) string?
   (ds/opt :7199) string?
   (ds/opt :7200) string?
   (ds/opt :7201) string?
   (ds/opt :7202) string?
   (ds/opt :7203) string?
   (ds/opt :7204) string?
   (ds/opt :7205) string?
   (ds/opt :7206) string?
   (ds/opt :7207) string?
   (ds/opt :7208) string?
   (ds/opt :7209) string?
   (ds/opt :7210) string?
   (ds/opt :7211) string?
   (ds/opt :7212) string?
   (ds/opt :7245) string?
   (ds/opt :7246) string?
   (ds/opt :7247) string?
   (ds/opt :7248) string?
   (ds/opt :7249) string?
   (ds/opt :7263) string?
   (ds/opt :7264) string?
   (ds/opt :7265) string?
   (ds/opt :7266) string?
   (ds/opt :7267) string?
   (ds/opt :7268) string?
   (ds/opt :7269) string?
   (ds/opt :7271) string?
   (ds/opt :7272) string?
   (ds/opt :7273) string?
   (ds/opt :7274) string?
   (ds/opt :7275) string?
   (ds/opt :7276) string?
   (ds/opt :7277) string?
   (ds/opt :7282) string?
   (ds/opt :7283) string?
   (ds/opt :7284) string?
   (ds/opt :7286) float?
   (ds/opt :7287) string?
   (ds/opt :7288) string?
   (ds/opt :7289) string?
   (ds/opt :7290) string?
   (ds/opt :7293) string?
   (ds/opt :7294) string?
   (ds/opt :7295) float?
   (ds/opt :7296) float?
   (ds/opt :7331) string?
   (ds/opt :7370) string?
   (ds/opt :7371) string?
   (ds/opt :7372) string?
   (ds/opt :7635) string?
   (ds/opt :7636) float?
   (ds/opt :7637) string?
   (ds/opt :7644) string?
   (ds/opt :7674) string?
   (ds/opt :7675) string?
   (ds/opt :7676) string?
   (ds/opt :7677) string?
   (ds/opt :7681) string?
   (ds/opt :7698) string?
   (ds/opt :7699) string?
   (ds/opt :7718) string?
   (ds/opt :7720) string?
   (ds/opt :7743) string?
   (ds/opt :7761) string?
   (ds/opt :7992) string?
   (ds/opt :7993) string?
   (ds/opt :7994) string?
   (ds/opt :7995) string?
   (ds/opt :conid) int?
   (ds/opt :minTick) float?
   (ds/opt :BboExchange) string?
   (ds/opt :HasDelayed) boolean?
   (ds/opt :sizeMinTick) int?
   (ds/opt :BestEligible) int?
   (ds/opt :BestBidExch) int?
   (ds/opt :BestAskExch) int?
   (ds/opt :PreOpenBid) int?
   (ds/opt :LastAttribs) int?
   (ds/opt :TimestampBase) int?
   (ds/opt :TimestampDelta) int?
   (ds/opt :LastExch) int?
   (ds/opt :CloseAttribs) int?
   })

(def market-data-spec
  (ds/spec
    {:name ::market-data
     :spec market-data-data}))
