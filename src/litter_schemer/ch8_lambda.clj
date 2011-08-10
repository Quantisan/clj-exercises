(ns litter-schemer.ch8-lambda)

(def a :tuna)
(def l '(:shrimp :salad :tuna :salad :and :tuna))

(defn rember-f [test?]
	(fn [a lat]
	  (cond
	    (empty? lat)	'()
	 		(test? a (first lat))	(rest lat)
	    :else
	    	(cons (first lat) 
	           	((rember-f test?) a (rest lat))))))

(def rember-eq (rember-f =))


(defn insertL-f [test?]
  (fn [newkey oldkey lat]
	  (if (empty? lat)
	    '()
	  	(if (test? (first lat) oldkey)
	    	(cons newkey lat)
	     	(cons (first lat) ((insertL-f test?) newkey oldkey (rest lat)))))))

(defn insertR-f [test?]
  (fn [newkey oldkey lat]
	  (if (empty? lat)	
	    '()
	  	(if (test? (first lat) oldkey)
	    	(cons oldkey (cons newkey (rest lat)))
	     	(cons (first lat) ((insertR-f test?) newkey oldkey (rest lat)))))))

(defn insert-g [side-f]
  (fn [newkey oldkey lat]
	  (when-not (empty? lat)
	  	(if (= (first lat) oldkey)
	    	(side-f newkey oldkey lat)
	     	(cons (first lat) ((insert-g side-f) newkey oldkey (rest lat)))))))

(defn seqL [newkey _ lat]
  (cons newkey lat))

(defn seqR [newkey oldkey lat]
  (cons oldkey (cons newkey (rest lat))))

(defn seqS [newkey _ lat]
  (cons newkey (rest lat)))

(def insertL (insert-g seqL))
(def insertR (insert-g seqR))
(def subst (insert-g seqS))
(insertL :cake :salad l)

(defn eq?-c [a]
  #(= % a))

(def eq?-salad (eq?-c :salad))

(comment
(defn atom-to-func [op]
  (cond
	  (= \+ op)	+
	  (= \x op) *
	  :else -))

(defn value [nexp]
  (cond
    (number? nexp)	nexp
    ((atom-to-func (operator nexp)) (value (first-sub-exp nexp)) (value (sec-sub-exp nexp)))))
)


(defn multirember-f [test?]
  (fn [a lat]
	  (when-not (empty? lat)
	 		(if (test? a (first lat))
      	((multirember-f test?) a (rest lat))
	    	(cons (first lat) 
	           	((multirember-f test?) a (rest lat)))))))
(def eq?-tuna (eq?-c :tuna))
(def multirember-eq? (multirember-f =))

(defn multiremberT [test? lat]
  (when-not (empty? lat)
 		(if (test? (first lat))
    	(multiremberT test? (rest lat))
    	(cons (first lat) 
           	(multiremberT test? (rest lat))))))

