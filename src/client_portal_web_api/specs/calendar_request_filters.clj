(ns client-portal-web-api.specs.calendar-request-filters
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def calendar-request-filters-data
  {
   (ds/opt :recently_held) string?
   (ds/opt :corporate_earnings) string?
   (ds/opt :DivExDates) string?
   (ds/opt :ipo) string?
   (ds/opt :splits) string?
   (ds/opt :corporate_events) string?
   (ds/opt :economic_events) string?
   (ds/opt :option_show_monthly) string?
   (ds/opt :option_show_weekly) string?
   (ds/opt :country) string?
   (ds/opt :limit) string?
   (ds/opt :limit_region) string?
   })

(def calendar-request-filters-spec
  (ds/spec
    {:name ::calendar-request-filters
     :spec calendar-request-filters-data}))
