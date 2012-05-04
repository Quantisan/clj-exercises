(ns sicp.ch2-1-3)

; ex 2.4
(defn cons [x y]
  (fn [m]
    (m x y)))
(defn car [z]
  (z (fn [p q]
       p)))
(defn cdr [z]
  (z (fn [p q]
       q)))