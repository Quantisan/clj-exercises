(ns litter-schemer.ch7-relations
  (:require [litter-schemer.ch5-stars :as stars])
  (:require [litter-schemer.ch3-cons :as con]))

(def lat '(:apples :peaches :pears :plums))
(def lat2 '(3 :apples 3 :peaches 4 9 :pears 6 :plums))
(def lat3 '(:apple :peach :pear :peach :plum :apple :lemon :peach))

(defn zet? [lat]
  (cond
    (empty? lat)	true
    (stars/member* (first lat) (rest lat))	false
    :else
    	(zet? (rest lat))))

(defn makeset [lat]
  (when-not (empty? lat)
    (cons (first lat) 
      		(makeset (con/multirember (first lat) (rest lat))))))

(def set1 #{4 :pounds :horseradish})
(def set2 #{:chicken :ounces})
(def set3 #{:four :pounds :chicken :and 5 :ounces :horseradish})
(defn zubset? [set1 set2]
  (cond
    (empty? set1)		true
  	(stars/member* (first set1) set2)
   		(zubset? (rest set1) set2)
     :else
     	false))

(def set4 #{:horseradish :pounds 4})
(defn eqset? [set1 set2]
	(and (zubset? set1 set2) (zubset? set2 set1)))

(defn intersect? [set1 set2]
  (cond
    (empty? set1)											false
    (stars/member* (first set1) set2)	true
    :else
    	(intersect? (rest set1) set2)))

(defn union2 [set1 set2]
  (makeset (concat set1 set2)))

(def lset '((6 :pears :and)
							 (3 :peaches :and 6 :peppers)
        			 (8 :pears :and 6 :plums)
							 (:and 6 :prunes :with some :apples)))

(defn front [l]
  (if (seq? (first l))
    (ffirst l)
    (first l)))

(defn intersectall [lset] 
  (when-not (empty? (first lset))
    (if (reduce #(and %1 %2) (map #(stars/member* (front lset) %) (rest lset)))
    	(cons (front lset) (intersectall (cons (rest (first lset)) (rest lset))))
   		(intersectall (cons (rest (first lset)) (rest lset))))))

(defn intersectall2 [lset]
  (let [lset2 (map #(into #{} %) lset)]
	  (if (empty? (rest lset2))
	    (first lset2)
	    (clojure.set/intersection (first lset2) (intersectall2 (rest lset2))))))

(defn a-pair? [l]
  (= (count l) 2))

(defn build [s1 s2]
  (cons s1 (cons s2 '())))

(defn third [p]
  (nth p 3))

(def rel1 '((8 3) (4 2) (7 6) (6 2) (3 4)))
(def rel2 '((4 3) (4 2) (7 6) (6 2) (3 4)))
(defn fun? [rel]
  (zet? (con/firsts rel)))

(defn revpair [pair]
  (build (second pair) (first pair)))

(def rel3 '((8 :a) (:pumpkin :pie) (:got :sick)))
(defn revrel [rel]
  (when-not (empty? rel)
    (let [revpair2, #(build (second %) (first %))]
  		(cons (revpair2 (first rel)) (revrel (rest rel))))))

(defn fullfun? [rel]
  (fun? (revrel rel)))