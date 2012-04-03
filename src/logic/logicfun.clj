(ns logic.logicfun
"
  http://clojure.com/blog/2011/12/08/lojic-part-two.html
"  
  (:refer-clojure :exclude [==])
  (:use clojure.core.logic))

(run 1 [q])

(run 1 [q] (== 4 q))

(run 1 [q] (== 4 q) (== 5 q))

(run 1 [q]
     (conde [(== 4 q)]
            [(== 5 q)]))

(run 2 [q]
     (conde [(== 4 q) (== 7 q)]
            [(== 5 q)]))

(run 1 [q]
     (fresh [a b]
            (== a 4)
            (== b 5)
            (== q [a b])))