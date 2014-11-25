(ns niftyn8.list-test
  (:require [midje.sweet :refer :all]
            [clojure.test.check :as tc]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [niftyn8.list :as nlist]))

(fact "returns a single integer"
  (tc/quick-check
   100
   (prop/for-all [s (gen/such-that not-empty (gen/vector gen/int))]
                 (integer? (nlist/last s))))
  => (just {:result true :num-tests 100 :seed anything}))

(fact "emulates behavior of clojure.core/last"
  (tc/quick-check
   100
   (prop/for-all [s (gen/vector gen/int)]
                 (= (nlist/last s) (last s))))
  => (just {:result true :num-tests 100 :seed anything}))
