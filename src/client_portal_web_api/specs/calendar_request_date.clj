(ns client-portal-web-api.specs.calendar-request-date
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def calendar-request-date-data
  {
   (ds/opt :start) string?
   (ds/opt :end) string?
   })

(def calendar-request-date-spec
  (ds/spec
    {:name ::calendar-request-date
     :spec calendar-request-date-data}))
