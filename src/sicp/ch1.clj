(ns sicp.ch1)

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
    
;;;;;;;;;;;;

(defn abs
  [x]
  (if (< x 0)	
    (- x)
    x))

(defn average
  [x y]
	(/ (+ x y) 2))

(defn improve
  [guess x]
	(average guess (/ x guess)))

(defn square [x] (* x x))

(defn cube [x] (* x x x))

(defn- good-enough?
  [guess x]
	(< (abs (- (square guess) x)) 0.001))

(defn- good-enough-frac?
  [guess x]
	(< (abs (- (square guess) x)) 
     (abs (/ x 1000))))

(defn- sqrt-iter
  [frac? guess x]
	(if (if frac?
      	(good-enough-frac? guess x)
        (good-enough? guess x))
		guess
		(recur frac? (improve guess x) x)))

(defn sqrt
  ([x & {:keys [guess frac?]
         :or {guess 1.0, frac? true}}]	
    (sqrt-iter frac? guess x)))

;; ex 1.6
(defn new-if
  [predicate then-clause else-clause]
	(cond 
   predicate then-clause
	 :else else-clause))

