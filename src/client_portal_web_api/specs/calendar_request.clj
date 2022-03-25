(ns client-portal-web-api.specs.calendar-request
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [client-portal-web-api.specs.calendar-request-date :refer :all]
            [client-portal-web-api.specs.calendar-request-filters :refer :all]
            )
  (:import (java.io File)))


(def calendar-request-data
  {
   (ds/opt :date) calendar-request-date-spec
   (ds/opt :filters) calendar-request-filters-spec
   })

(def calendar-request-spec
  (ds/spec
    {:name ::calendar-request
     :spec calendar-request-data}))
