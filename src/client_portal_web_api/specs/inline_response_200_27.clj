(ns client-portal-web-api.specs.inline-response-200-27
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [client-portal-web-api.specs.-iserver-secdef-search-sections :refer :all]
            )
  (:import (java.io File)))


(def inline-response-200-27-data
  {
   (ds/opt :conid) int?
   (ds/opt :companyHeader) string?
   (ds/opt :companyName) string?
   (ds/opt :symbol) string?
   (ds/opt :description) string?
   (ds/opt :restricted) string?
   (ds/opt :fop) string?
   (ds/opt :opt) string?
   (ds/opt :war) string?
   (ds/opt :sections) (s/coll-of -iserver-secdef-search-sections-spec)
   })

(def inline-response-200-27-spec
  (ds/spec
    {:name ::inline-response-200-27
     :spec inline-response-200-27-data}))
