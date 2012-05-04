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

; ex 2.5
(defn cons [a b]
  (* (Math/pow 2 a) (Math/pow 3 b)))
(defn pow-cnt [x n]
  (loop [x x, n n, i 0]
    (if (zero? (mod x n))
      (recur (/ x n) n (inc i))
      i)))
(defn car [z]
  (pow-cnt z 2))
(defn cdr [z]
  (pow-cnt z 3))