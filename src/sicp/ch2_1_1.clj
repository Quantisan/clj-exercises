(ns sicp.ch2-1-1
  (:use [sicp.ch1-1 :only (abs)]))

(defn gcd [a b]
  (if (zero? b)
    a
    (abs (gcd b (mod a b)))))

; ex 2.1
(defn sign [n d]
  (let [sign (neg? (* n d))]
    (if sign
      (- (abs n))
      (abs n))))

(defn make-rat [n d]
  (let [g  (gcd n d)
        n  (sign n d)]
    (cons (/ n g) [(abs (/ d g))])))

(defn numer [x] (first x))
(defn denom [x] (last x))

(defn add-rat [x y]
  (make-rat (+ (* (numer x) (denom y))
               (* (numer y) (denom x)))
            (* (denom x) (denom y))))

(defn sub-rat [x y]
  (make-rat (- (* (numer x) (denom y))
               (* (numer y) (denom x)))
            (* (denom x) (denom y))))

(defn mul-rat [x y]
  (make-rat (* (numer x) (numer y))
            (* (denom x) (denom y))))
  
(defn div-rat [x y]
  (make-rat (* (numer x) (denom y))
            (* (denom x) (numer y))))

(defn equal-rat? [x y]     (= (* (numer x) (denom y))        (* (numer y) (denom x))))

(defn print-rat [x]
  (println (numer x) "/" (denom x)))

(def one-half (make-rat 1 2))
(def one-third (make-rat 1 3))