(ns sicp.ch1-3-4
  (:use [sicp.ch1-3-3 :only (average fixed-point)]
        [sicp.ch1-2 :only (square)]
        [sicp.ch1-1 :only (cube)]))

(defn average-damp [f]
  (fn [x] (average x (f x))))

((average-damp square) 10)

(defn sqrt [x]
  (fixed-point (average-damp (fn [y] (/ x y)))
               1.0))

(defn cube-root [x]
  (fixed-point (average-damp (fn [y] (/ x (square y))))
               1.0))

(def dx 0.00001)

(defn deriv [g]
  (fn [x]
    (/ (- (g (+ x dx)) (g x))
       dx)))

(defn newton-transform [g]
  (fn [x]
    (- x (/ (g x) ((deriv g) x)))))

(defn newtons-method [g guess]
  (fixed-point (newton-transform g) guess))

(defn sqrt2 [x]
  (newtons-method (fn [y] (- (square y) x)) 1.0))

(defn fixed-point-of-transform [g transform guess]
  (fixed-point (transform g) guess))

(defn sqrt3 [x]
  (fixed-point-of-transform (fn [y] (/ x y))
                            average-damp
                            1.0))

(defn sqrt4 [x]
  (fixed-point-of-transform (fn [y] (- (square y) x))
                            newton-transform
                            1.0))

; ex 1.40
(defn cubic [a b c]
  (fn [x]
    (+ (cube x) (* a (square x)) (* b x) c)))
(defn cubic-root [a b c]
  (newtons-method (cubic a b c) 1))

; ex 1.41
(defn double [f]
  (fn [x]
    (f (f x))))
(((double (double double)) inc) 5)  ;; 21

; ex 1.42
(defn compose [f g]
  (fn [x]
    (f (g x))))