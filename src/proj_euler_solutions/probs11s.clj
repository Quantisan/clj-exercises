(ns euler.probs11s
    (:use clojure.math.numeric-tower))

(defn int-to-digits-recur 
  "Converts an integer to a list of its digits (in reverse)."
  [x]
  (if-not (zero? x)
    (cons (rem x 10) (int-to-digits (floor (/ x 10))))))

(defn int-to-digits-mapper
  "Converts an integer to a list of its digits."
  [x]
  (letfn 
    [(char-to-int 
       [c]
       (- (int c) 48))]
    (map char-to-int (str x))))

(defn p16
  ([]
    (p16 1000))
  ([pow]
    (let [num (expt 2 pow)]
      (reduce + (int-to-digits-mapper num)))))
      
(defn factorial [x]
  (let [nums (range 2N (inc x))]  ;; note use of big int
    (reduce * nums)))

(defn p20
  ([]
    (p20 100))
  ([x]
    (reduce + (int-to-digits-mapper (factorial x)))))