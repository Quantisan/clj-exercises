(ns sicp.ch2-2-1)

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

(def us-coins (list 50 25 10 5 1))