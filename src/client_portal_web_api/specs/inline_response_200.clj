(ns client-portal-web-api.specs.inline-response-200
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [client-portal-web-api.specs.inline-response-200-schedules :refer :all]
            )
  (:import (java.io File)))


(def inline-response-200-data
  {
   (ds/opt :id) string?
   (ds/opt :tradeVenueId) string?
   (ds/opt :schedules) (s/coll-of inline-response-200-schedules-spec)
   })

(def inline-response-200-spec
  (ds/spec
    {:name ::inline-response-200
     :spec inline-response-200-data}))
