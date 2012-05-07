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
      (f (((comp a b) f) x)))))
(((add one two) inc) 1)

; ex 2.7
(defn make-interval [a b] [a b])
(defn upper-bound [x] (apply max x))
(defn lower-bound [x] (apply min x))

(defn add-interval [x y]
  (make-interval (+ (lower-bound x) (lower-bound y))
                 (+ (upper-bound x) (upper-bound y))))
(defn mul-interval [x y]
  (let [p1 (*(lower-bound x) (lower-bound y))
        p2 (*(lower-bound x) (upper-bound y))
        p3 (*(upper-bound x) (lower-bound y))
        p4 (*(upper-bound x) (upper-bound y))]
    (make-interval (min p1 p2 p3 p4)
                   (max p1 p2 p3 p4))))

; ex 2.10
(defn div-interval [x y]
  {:pre [(zero? (upper-bound y)) (zero? (lower-bound y))]}
  (mul-interval x
                (make-interval (/ 1.0 (upper-bound y))
                               (/ 1.0 (lower-bound y)))))

; ex 2.8
(defn sub-interval [x y]
  (make-interval (- (lower-bound x) (upper-bound y))
                 (- (upper-bound x) (lower-bound y))))
; ex 2.9
(defn width [x]
  (/ (- (upper-bound x) (lower-bound x)) 2.0))
                        