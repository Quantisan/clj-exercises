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
        (into (into [] (fringe x)) (fringe coll)) ;; or use 'append' to keep data type
        (cons x (fringe coll))))))

; ex 2.29
(defn make-mobile [left right]     (list left right))
(defn make-branch [length structure]     (list length structure))
(defn left-branch [mob]
  (first mob))
(defn right-branch [mob]
  (last mob))
(defn branch-length [br]
  (first br))
(defn branch-structure [br]
  (last br))

(def a (make-branch 3 10))
(def b (make-branch 2 4))
(def c (make-branch 1 7))
(def mob (make-mobile a (make-branch 6 (make-mobile b c))))

(defn total-weight [mob]
  (let [left  (left-branch mob)
        right (right-branch mob)
        left-struct (branch-structure left)
        right-struct (branch-structure right)]
  (+ (if (coll? left-struct)
       (total-weight left-struct)
       left-struct)
     (if (coll? right-struct)
       (total-weight right-struct)
       right-struct))))

(defn branch-torque [br]
  (let [stc  (branch-structure br)]
    (* (branch-length br) (if (coll? stc)
                            (total-weight stc)
                            stc))))
(defn balanced? [mob]
  (let [left  (left-branch mob)
        right (right-branch mob)        
        left-struct (branch-structure left)
        right-struct (branch-structure right)]
    (and (= (branch-torque left) (branch-torque right))
         (if (coll? left-struct)
           (balanced? left-struct)
           true)
         (if (coll? right-struct)
           (balanced? right-struct)
           true))))


(defn scale-tree [tree factor]
  (cond 
    (and (coll? tree) (empty? tree)) nil
    (not (coll? tree)) (* tree factor)
    :else (cons (scale-tree (first tree) factor)
                (scale-tree (rest tree) factor))))

(defn scale-tree [tree factor]
  (map (fn [sub-tree]
         (if (coll? sub-tree)
           (scale-tree sub-tree factor)
           (* sub-tree factor)))
       tree))
                 