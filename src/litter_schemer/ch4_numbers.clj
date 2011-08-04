(ns litter-schemer.ch4-numbers)

(defn plus [n m]
  (if (zero? m) 
    n
    (inc (plus n (dec m)))))

(defn sub [n m]
  (if (zero? m) 
    n
    (dec (sub n (dec m)))))

(defn addtup [tup]
  (if (empty? tup)
    0
    (+ (first tup) (addtup (rest tup)))))

(defn mul [n m]
  (if (zero? m)
    0
    (+ n (mul n (dec m)))))

(def tup1 '(2 3))
(def tup2 '(4 6))

(defn tup-plus [tup1 tup2]
  (cond
    (empty? tup1)	tup2
    (empty? tup2)	tup1
    :else
    	(cons (+ (first tup1) (first tup2))
      			(tup-plus (rest tup1) (rest tup2)))))

(defn gt [n m]
  (cond
    (zero? n)	false
    (zero? m)	true
    :else
    	(gt (dec n) (dec m))))

(defn lt [n m]
  (cond
    (zero? m)	false
    (zero? n)	true
    :else
    	(lt (dec n) (dec m))))

(defn eq [n m]
	(if (or (lt n m) (gt n m))
   false
   true))

(defn pow [n m]
  (if (zero? m)
    1
    (* n (pow n (dec m)))))

(defn div [n m]
  (if (< n m)
    0
    (inc (div (- n m) m))))

(def lat '(:hot :dogs :with :and))
(defn len [lat]
  (if (empty? lat)
    0
    (inc (len (rest lat)))))

(defn pick [n lat]
  (cond
    (= n 1)		(first lat)    
    :else			(pick (dec n) (rest lat))))

(defn rempick [n lat]
  (cond
    (= n 1)		(rest lat)    
    :else			(cons (first lat) (rempick (dec n) (rest lat)))))

(defn no-nums [lat]
  (cond
    (empty? lat)						'()
    (number? (first lat))		(no-nums (rest lat))
    :else										(cons (first lat) 
                     							(no-nums (rest lat)))))

(defn occur [a lat]
  (cond
    (empty? lat)			0
    (= (first lat) a)	(inc (occur a (rest lat)))
    :else							(occur a (rest lat))))


     