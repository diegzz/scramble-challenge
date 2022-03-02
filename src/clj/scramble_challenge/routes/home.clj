(ns scramble-challenge.routes.home
  (:require
   [scramble-challenge.layout :as layout]
   [clojure.java.io :as io]
   [scramble-challenge.middleware :as middleware]
   [ring.util.response]
   [ring.util.http-response :as response]
   [clojure.set :as set]
   [struct.core :as st]))

(def scramble-schema
  [[:str1
    st/required
    st/string]

   [:str2
    st/required
    st/string]])

(defn validate-scramble [params]
  (first (st/validate params scramble-schema)))

(defn scramble [str1 str2]
  (set/subset? (set str2) (set str1)))

(defn scramble? [params]
  (scramble (:str1 params) (:str2 params)))

(defn scramble! [{:keys [params]}]
  (if-let [errors (validate-scramble params)]
    (-> (response/found "/")
        (assoc :flash (assoc params :errors errors)))
    (->
      (response/found "/")
      (assoc :flash (assoc params :scramble (scramble? params)))
      )))

(defn home-page [{:keys [flash] :as request}]
  (layout/render
   request
   "home.html"
   (merge (select-keys flash [:scramble :errors]))))

(defn home-routes []
  [""
   {:middleware [middleware/wrap-formats]}
   ["/" {:get home-page
         :post scramble!}]])

