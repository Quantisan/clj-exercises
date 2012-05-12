(ns sicp.ch2-2-2
  (:use [sicp.ch2-2-1 :only (reverse append)]))

(defn count-leaves [x]
  (cond
    (and (coll? x) (empty? x)) 0
    (not (coll? x)) 1
    :else (+ (count-leaves (first x))
             (count-leaves (rest x)))))

; ex 2.25
(first (rest (first (rest (rest '(1 3 (5 7) 9))))))(first (first '((7))))(first (rest (first (rest (first (rest (first (rest (first (rest (first (rest '(1 (2 (3 (4 (5 (6 7))))))))))))))))))

; ex 2.27
(defn deep-reverse [coll]
  (when (seq coll)
    (if (coll? (last coll))
      (cons (deep-reverse (last coll)) (deep-reverse (drop-last coll)))
      (cons (last coll) (reverse (drop-last coll))))))
(defn deep-reverse [coll]
  (if (coll? coll)
    (reverse (map deep-reverse coll))
    coll))
(def x (list (list 1 2) (list 3 4)))

(= (deep-reverse x) '((4 3) (2 1)))

; ex 2.28
(defn fringe [coll]
  (when (seq coll)
    (let [[x & coll] coll]
      (if (coll? x)
        (into (into [] (fringe x)) (fringe coll)) ;; or use 'append'
        (cons x (fringe coll))))))