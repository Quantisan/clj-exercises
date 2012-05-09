(ns sicp.ch2-2-1
  (:use [sicp.ch1-2 :only (square)]))

(defn append [list1 list2]
  (if (empty? list1)
    list2
    (cons (first list1) (append (rest list1) list2))))

; ex 2.17
(defn last-pair [coll]
  (if (= 1 (count coll))
    coll
    (last-pair (rest coll))))
(= (last-pair (list 23 72 149 34)) '(34))

; ex 2.18
(defn reverse [coll]
  (when (seq coll)
    (cons (last coll) (reverse (drop-last coll)))))
(= (reverse (list 1 4 9 16 25)) (list 25 16 9 4 1))

; ex 2.19
(defn first-denomination [coll]
  (first coll))
(defn except-first-denomination [coll]
  (rest coll))
(defn cc 
  [amount coin-values]
  (cond 
    (= amount 0) 1
    (or (< amount 0) (empty? coin-values)) 0
    :else (+ (cc amount
                 (except-first-denomination coin-values))
             (cc (- amount
                    (first-denomination coin-values))
                 coin-values))))

(def us-coins (list 50 25 10 5 1))(def uk-coins (list 100 50 20 10 5 2 1 0.5))

; ex 2.20
(defn same-parity [x & coll]
  (cons x (if (even? x)
            (filter even? coll)
            (filter odd? coll))))
(= (same-parity 1 2 3 4 5 6 7) '(1 3 5 7))
(= (same-parity 2 3 4 5 6 7) '(2 4 6))

; ex 2.21
(defn square-list [items]
  (if (empty? items)
    nil
    (cons (square (first items)) (square-list (rest items)))))(defn square-list [items] (map square items))

; ex 2.22
(defn square-list [items]
  (loop [things items, answer '()]
    (if (empty? things)
      answer
      (recur (rest things) (cons (square (first things)) answer)))))

(defn square-list [items]
  (loop [things items, answer '()]
    (if (empty? things)
      answer
      (recur (rest things) (conj answer (square (first things)))))))