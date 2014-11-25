(ns niftyn8.list
  (:refer-clojure :exclude [last]))

(defn last
  "Returns the last element in a list"
  ([xs] (last xs nil))
  ([xs item] (if (empty? xs)
               item
               (recur (rest xs) (first xs)))))
