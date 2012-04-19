(ns sicp.ch1-1)

;; ex. 1.2
(/ (+ 5
   		4
   		(- 2
      	 (- 3
         		(+ 6 (/ 4 5)))))
   (* 3
      (- 6 2)
      (- 2 7)))

;; ex. 1.3, only using if/cond
(defn larger-two
"Define a procedure that takes three numbers as arguments and 
returns the sum of the squares of the two larger numbers."
  [a b c]
  (cond
    (and (< a b) (< a c))	(+ (* b b) (* c c))		; a is smallest
    (and (< b a) (< b c)) (+ (* a a) (* c c))		; b is smallest
    (and (< c a) (< c b)) (+ (* a a) (* b b))))	; c is smallest

;; ex 1.5
(def p p)
(defn test [x y]
  (if (= x 0) 0 y))
(test 0 p)

;; ex 1.6
(defn abs
  [x]
  (if (< x 0)	
    (- x)
    x))

(defn average
  [x y]
	(/ (+ x y) 2))

(defn square [x] (* x x))

(defn new-if
  [predicate then-clause else-clause]
	(cond 
   predicate then-clause
	 :else else-clause))
(defn ok? [guess x]
  (< (abs (- (square guess) x)) 0.001))
(defn improve
  [guess x]
	(average guess (/ x guess)))
(defn sqrt-new-if [guess x]
  (new-if (ok? guess x)
          guess
          (sqrt-new-if (improve guess x)
                     x)))

;;;;;;;;;;;;;;;;;;;;;;;;
;; ex 1.7, 1.8
;;;;;;;;;;;;;;;;;;;;;;;;
(defn cube [x] (* x x x))

(defn improve-sq
  [guess x]
	(average guess (/ x guess)))

(defn- improve-cb
  [guess x]
  (/ (+ (/ x (square guess))
     		(* 2 guess))
     3))

(defn good-enough?
  [f]
  (fn [guess x]
		(< (abs (- (f guess) x)) 
    	(abs (/ x 1000)))))

(defn- sqrt-iter
  [guess x]
	(if ((good-enough? square) guess x)
		guess
		(recur (improve-sq guess x) x)))

(defn- cbrt-iter
  [guess x]
	(if ((good-enough? cube) guess x)
		guess
		(recur (improve-cb guess x) x)))

(defn sqrt
  ([x & {:keys [guess]
         :or {guess 1.0}}]	
    (sqrt-iter guess x)))

(defn cbrt
  ([x & {:keys [guess]
         :or {guess 1.0}}]	
    (cbrt-iter guess x)))


