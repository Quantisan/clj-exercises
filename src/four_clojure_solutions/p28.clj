(ns four-clojure-solutions.p28)

(def lat1 '(1 2 3 (4 5)))
(def lat2 '((1 2) 3 [4 [5 6]]))
(defn flatR [lat]
  (cond
    (empty? lat)							'()
    (not (seq? (first lat)))	(cons (first lat) (flatR (rest lat)))
    :else
    	(cons (flatR (first lat)) 
       			(flatR (rest lat)))))

(defn flat* [l]
  (loop [in l, out nil]
    (cond
      (empty? in)	out
      (not (seq? (first in)))
    		(recur (rest in) (cons (first in) out))
      :else
      	(cons (recur (first in) out) (recur (rest in) out)))))
     	

(println (flatR lat1))