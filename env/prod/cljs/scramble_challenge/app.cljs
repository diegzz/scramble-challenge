(ns scramble-challenge.app
  (:require [scramble-challenge.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
