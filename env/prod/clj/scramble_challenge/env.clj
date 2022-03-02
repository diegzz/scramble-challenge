(ns scramble-challenge.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[scramble-challenge started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[scramble-challenge has shut down successfully]=-"))
   :middleware identity})
