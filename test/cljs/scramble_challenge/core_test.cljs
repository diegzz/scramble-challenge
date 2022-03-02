(ns scramble-challenge.core-test
  (:require [cljs.test :refer-macros [is are deftest testing use-fixtures]]
            [pjstadig.humane-test-output]
            [scramble-challenge.core :as rc]))

(deftest test-home
  (is (= true true)))

