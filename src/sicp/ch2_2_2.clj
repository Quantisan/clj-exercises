(ns sicp.ch2-2-2)

(defn count-leaves [x]
  (cond
    (and (coll? x) (empty? x)) 0
    (not (coll? x)) 1
    :else (+ (count-leaves (first x))
             (count-leaves (rest x)))))

; ex 2.25
(first (rest (first (rest (rest '(1 3 (5 7) 9))))))(first (first '((7))))(first (rest (first (rest (first (rest (first (rest (first (rest (first (rest '(1 (2 (3 (4 (5 (6 7))))))))))))))))))