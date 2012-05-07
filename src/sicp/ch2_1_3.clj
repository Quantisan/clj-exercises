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

; ex 2.6
(def zero (fn [f] (fn [x] x)))

(defn add-1 [n]
  (fn [f]
    (fn [x] (f ((n f) x)))))

((zero inc) 1)
(def one (fn [f] (fn [x] (f x))))
(def two (fn [f] (fn [x] (f (f x)))))
((one inc) 1)
((two inc) 1)

(defn add [a b]
  (fn [f]
    (fn [x]
      (f ((b (a f)) x)))))
(((add one two) inc) 1)