(ns client-portal-web-api.specs.inline-response-200-30-string
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def inline-response-200-30-string-data
  {
   (ds/opt :ORTH) boolean?
   (ds/opt :SP) string?
   (ds/opt :LP) string?
   (ds/opt :PC) string?
   (ds/opt :TA) string?
   (ds/opt :TU) string?
   (ds/opt :ROA) string?
   (ds/opt :ROP) string?
   (ds/opt :TT) string?
   (ds/opt :UNP) boolean?
   })

(def inline-response-200-30-string-spec
  (ds/spec
    {:name ::inline-response-200-30-string
     :spec inline-response-200-30-string-data}))
