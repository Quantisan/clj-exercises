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