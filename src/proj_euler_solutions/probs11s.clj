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
  (letfn [(char-to-int
            [c]
            (Integer. (str c)))]                       
  (map char-to-int (apply list (str x)))))

(defn p16
  ([]
    (p16 1000))
  ([pow]
    (let [num (expt 2 pow)]
      (reduce + (int-to-digits-mapper num)))))
      