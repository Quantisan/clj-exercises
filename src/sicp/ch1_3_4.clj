(ns sicp.ch1-3-4
  (:use [sicp.ch1-3-3 :only (average fixed-point)]
        [sicp.ch1-2 :only (square)]))

(defn average-damp [f]
  (fn [x] (average x (f x))))

((average-damp square) 10)

(defn sqrt [x]
  (fixed-point (average-damp (fn [y] (/ x y)))
               1.0))