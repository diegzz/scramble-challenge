(ns scramble-challenge.env
  (:require
    [selmer.parser :as parser]
    [clojure.tools.logging :as log]
    [scramble-challenge.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[scramble-challenge started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[scramble-challenge has shut down successfully]=-"))
   :middleware wrap-dev})
