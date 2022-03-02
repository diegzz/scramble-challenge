(ns scramble-challenge.handler-test
  (:require
   [clojure.test :refer :all]
   [ring.mock.request :refer :all]
   [scramble-challenge.handler :refer :all]
   [scramble-challenge.middleware.formats :as formats]
   [scramble-challenge.routes.home :as routes]
   [muuntaja.core :as m]
   [mount.core :as mount]))

(defn parse-json [body]
  (m/decode formats/instance "application/json" body))

(use-fixtures
  :once
  (fn [f]
    (mount/start #'scramble-challenge.config/env
                 #'scramble-challenge.handler/app-routes)
    (f)))

(deftest test-app
  (testing "main route"
    (let [response ((app) (request :get "/"))]
      (is (= 200 (:status response)))))

  (testing "not-found route"
    (let [response ((app) (request :get "/invalid"))]
      (is (= 404 (:status response)))))
  
  (testing "scramble-post"
    (let [response ((app) (request :post "/" {:str1 "rekqodlw" :str2 "world"}))]
      (is (= 302 (:status response)))))
  
  (testing "scramble true"
    (let [is-scramble true]
      (is (= is-scramble (routes/scramble "rekqodlw" "world")))))
  
  (testing "scramble false"
    (let [is-scramble false]
      (is (= is-scramble (routes/scramble "rekqodlw" "codewar"))))))
