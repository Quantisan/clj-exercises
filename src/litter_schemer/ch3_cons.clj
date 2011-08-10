(ns litter-schemer.ch3-cons)



(defn multirember [a lat]
  (cond
    (empty? lat)	'()
 		(= a (first lat))	(multirember a (rest lat))
    :else
    	(cons (first lat) 
           	(multirember a (rest lat)))))

(defn rember2 [a lat]
  (cond
    (empty? lat)	'()
 		(= a (first lat))	(rest lat)
    :else
    	(cons (first lat) 
           	(rember2 a (rest lat)))))

(defn rember [a lat]
  (cond
    (empty? lat)	'()
    :else
    	(cond
    		(= a (first lat))	(rest lat)
    		:else							
      		(cons 
          	(first lat) 
           	(rember a (rest lat))))))

(def l '(((:five :plums) :four) 
				(:eleven :green :oranges) 
				((:no) :more))) 


(defn firsts [lat]
  (cond
    (empty? lat)	'()
    :else
    	(cons (first (first lat))
       			(firsts (rest lat)))))

(def newkey :e)
(def oldkey :d)
(def lat '(:a :b :c :d :f :g :d))

(defn multiinsertR [newkey oldkey lat]
  (cond
    (empty? lat)	'()
    :else
    	(if (= (first lat) oldkey)
      	(cons oldkey (cons newkey (multiinsertR newkey oldkey (rest lat))))
       	(cons (first lat) (multiinsertR newkey oldkey (rest lat))))))

(def a :and)

(def newkey :cake)
(def oldkey :and)
(def lat '(:bacon :lettuce :and :tomato :and :jelly))

(comment
(defn insertR [newkey oldkey lat]
  (if (empty? lat)	
    '()
  	(if (= (first lat) oldkey)
    	(cons oldkey (cons newkey (rest lat)))
     	(cons (first lat) (insertR newkey oldkey (rest lat))))))

(defn insertL [newkey oldkey lat]
  (if (empty? lat)
    '()
  	(if (= (first lat) oldkey)
    	(cons newkey lat)
     	(cons (first lat) (insertL newkey oldkey (rest lat))))))
)

(defn multiinsertL [newkey oldkey lat]
  (if (empty? lat)
    '()
  	(if (= (first lat) oldkey)
    	(cons newkey (cons oldkey (multiinsertL newkey oldkey (rest lat))))
     	(cons (first lat) (multiinsertL newkey oldkey (rest lat))))))

(defn insert [f]
  (fn [newkey oldkey lat]
    (when (seq lat)
      (if (= (first lat) oldkey)
        (f newkey oldkey lat)
        (cons (first lat) (insert newkey oldkey (rest lat)))))))

(def insertR
  (insert (fn [newkey oldkey lat]
            (cons oldkey (cons newkey (rest lat))))))

