(ns litter-schemer.ch5-stars)

(def a :cup)
(def l '((:coffee) :cup ((:tea) :cup)
          (:and (:hick)) :cup))
(defn rember* [a l]
  (cond
    (empty? l)	'()
    (not (seq? (first l)))
    	(if (= (first l) a)
      	(rember* a (rest l))
       	(cons (first l) (rember* a (rest l))))    
    :else
    	(cons (rember* a (first l)) (rember* a (rest l)))))

(defn leftmost [l]
  (if (not (seq? (first l)))
  	(first l)
   	(leftmost (first l))))

(defn member* [a l]
  (cond
    (empty? l)	false
    (not (seq? (first l)))
    	(or (= (first l) a) (member* a (rest l)))   
    :else
    	(or (member* a (first l)) (member* a (rest l)))))

; fail
(defn member2* [a l]
  (cond
    (empty? l)			false
    (= (first l) a) true   
    :else
    	(or (member2* a (first l)) (member2* a (rest l)))))

(defn insertR* [newkey oldkey l]
  (cond
    (empty? l)	'()
    (not (seq? (first l)))
    	(if (= (first l) oldkey)
      	(cons oldkey (cons newkey (insertR* newkey oldkey (rest l))))
       	(cons (first l) (insertR* newkey oldkey (rest l))))    
    :else
    	(cons (insertR* newkey oldkey (first l)) (insertR* newkey oldkey (rest l)))))

(defn insertL* [newkey oldkey l]
  (cond
    (empty? l)	'()
    (not (seq? (first l)))
    	(if (= (first l) oldkey)
      	(cons newkey (cons oldkey (insertL* newkey oldkey (rest l))))
       	(cons (first l) (insertL* newkey oldkey (rest l))))    
    :else
    	(cons (insertL* newkey oldkey (first l)) (insertL* newkey oldkey (rest l)))))

(defn occur* [a l]
  (cond
    (empty? l)	0
    (not (seq? (first l)))
    	(if (= (first l) a)
      	(inc (occur* a (rest l)))
       	(occur* a (rest l)))
    :else
    	(+ (occur* a (first l)) (occur* a (rest l)))))

(defn subst* [newkey oldkey l]
  (cond
    (empty? l)	'()
    (not (seq? (first l)))
    	(if (= (first l) oldkey)
      	(cons newkey (subst* newkey oldkey (rest l)))
       	(cons (first l) (subst* newkey oldkey (rest l))))
    :else
    	(cons (subst* newkey oldkey (first l)) (subst* newkey oldkey (rest l)))))