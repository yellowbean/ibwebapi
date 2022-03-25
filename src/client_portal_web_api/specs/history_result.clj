(ns client-portal-web-api.specs.history-result
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [client-portal-web-api.specs.history-result-bars :refer :all]
            )
  (:import (java.io File)))


(def history-result-data
  {
   (ds/opt :bars) history-result-bars-spec
   })

(def history-result-spec
  (ds/spec
    {:name ::history-result
     :spec history-result-data}))
