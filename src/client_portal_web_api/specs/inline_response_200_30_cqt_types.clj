(ns client-portal-web-api.specs.inline-response-200-30-cqt-types
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def inline-response-200-30-cqt-types-data
  {
   (ds/opt :0) string?
   })

(def inline-response-200-30-cqt-types-spec
  (ds/spec
    {:name ::inline-response-200-30-cqt-types
     :spec inline-response-200-30-cqt-types-data}))
