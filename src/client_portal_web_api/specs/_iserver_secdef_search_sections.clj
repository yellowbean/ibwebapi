(ns client-portal-web-api.specs.-iserver-secdef-search-sections
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def -iserver-secdef-search-sections-data
  {
   (ds/opt :secType) string?
   (ds/opt :months) string?
   (ds/opt :symbol) string?
   (ds/opt :exchange) string?
   (ds/opt :legSecType) string?
   })

(def -iserver-secdef-search-sections-spec
  (ds/spec
    {:name ::-iserver-secdef-search-sections
     :spec -iserver-secdef-search-sections-data}))
