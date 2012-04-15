(ns sicp.ch1-3-2
  (:use [sicp.ch1-2 :only (square)]))

; ex 1.34
(defn f [g]
  (g 2))

(f square)  ;; 4
(f (fn [z] (* z (+ z 1))))  ;; 6

;(f f) > (f 2) > (2 2)