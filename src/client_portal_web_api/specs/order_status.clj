(ns client-portal-web-api.specs.order-status
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def order-status-data
  {
   (ds/opt :sub_type) string?
   (ds/opt :request_id) string?
   (ds/opt :order_id) int?
   (ds/opt :conidex) string?
   (ds/opt :symbol) string?
   (ds/opt :side) string?
   (ds/opt :contract_description_1) string?
   (ds/opt :listing_exchange) string?
   (ds/opt :option_acct) string?
   (ds/opt :company_name) string?
   (ds/opt :size) string?
   (ds/opt :total_size) string?
   (ds/opt :currency) string?
   (ds/opt :account) string?
   (ds/opt :order_type) string?
   (ds/opt :limit_price) string?
   (ds/opt :stop_price) string?
   (ds/opt :cum_fill) string?
   (ds/opt :order_status) string?
   (ds/opt :order_status_description) string?
   (ds/opt :tif) string?
   (ds/opt :fg_color) string?
   (ds/opt :bg_color) string?
   (ds/opt :order_not_editable) boolean?
   (ds/opt :editable_fields) string?
   (ds/opt :cannot_cancel_order) boolean?
   (ds/opt :outside_rth) boolean?
   (ds/opt :deactivate_order) boolean?
   (ds/opt :use_price_mgmt_algo) boolean?
   (ds/opt :sec_type) string?
   (ds/opt :available_chart_periods) string?
   (ds/opt :order_description) string?
   (ds/opt :order_description_with_contract) string?
   (ds/opt :alert_active) int?
   (ds/opt :child_order_type) string?
   (ds/opt :size_and_fills) string?
   (ds/opt :exit_strategy_display_price) string?
   (ds/opt :exit_strategy_chart_description) string?
   (ds/opt :exit_strategy_tool_availability) string?
   (ds/opt :allowed_duplicate_opposite) boolean?
   (ds/opt :order_time) string?
   (ds/opt :oca_group_id) string?
   })

(def order-status-spec
  (ds/spec
    {:name ::order-status
     :spec order-status-data}))
