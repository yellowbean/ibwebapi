(ns client-portal-web-api.specs.system-error
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def system-error-data
  {
   (ds/opt :error) string?
   })

(def system-error-spec
  (ds/spec
    {:name ::system-error
     :spec system-error-data}))
