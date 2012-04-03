(ns logic.core
"
  The Reasoned Schemer
"  
  (:refer-clojure :exclude [==])
  (:use clojure.core.logic))

;;; Chapter 1 ;;;
(run* (q)
      u#)

(run* (q)
      (== true q))

(run* (q)
      u#
      (== true q))

(run* (q)
      s#
      (== true q))

(run* (r)
      s#
      (== 'corn r))

(run* (r)
      u#
      (== 'corn r))

(run* (q)
      s#
      (== false q))

(run* (x)
      (let [x  false]
        (== true x)))

(run* (x)
      (let [x  false]
        (== false x)))

(run* (q)
      (fresh (x)
             (== true x)
             (== true q)))

(run* (x)
      s#)

(run* (x)
      (let [x false]
        (fresh (x)
               (== true x))))

(run* (r)
      (fresh (x y)
             (== (cons x (cons y '())) r)))
        