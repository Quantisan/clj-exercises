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

; ex. 2.2
(defn make-point [x y]
  [x y])
(defn x-point [p]
  (first p))
(defn y-point [p]
  (last p))
(defn print-point [p]
  (println p))

(defn avg [& more]
  (double (/ (apply + more) (count more))))

(defn make-segment [start end]
  [start end])
(defn start-segment [sg]
  (first sg))
(defn end-segment [sg]
  (last sg))
(defn midpoint-segment [sg]
  (let [s  (start-segment sg)
        e  (end-segment sg)]
    (make-point (avg (x-point s) (x-point e))
                (avg (y-point s) (y-point e)))))

; ex 2.3
(defn make-rect [up-left low-right]
  [up-left low-right])
(defn up-left-point [r]
  (first r))
(defn low-right-point [r]
  (last r))
(defn top-rect [r]
  (y-point (up-left-point r)))
(defn bottom-rect [r]
  (y-point (low-right-point r)))
(defn left-rect [r]
  (x-point (up-left-point r)))
(defn right-rect [r]
  (x-point (low-right-point r)))
(defn height-width-rect [r]
  [(abs (- (right-rect r) (left-rect r)))
   (abs (- (top-rect r) (bottom-rect r)))])
(defn perimeter-rect [r]
  (apply + (height-width-rect r)))
(defn area-rect [r]
  (apply * (height-width-rect r)))