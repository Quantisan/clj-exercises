(ns sicp.ch1-3-3)

(defn abs "(abs n) is the absolute value of n" [n]
  {:pre [(number? n)]}
  (if (neg? n) 
    (- n)
    n))

(defn close-enough? [x y & tolerance]
  (< (abs (- x y)) (or tolerance 0.001)))
(defn average [x y & more]
  (/ (apply + x y more) (+ (count more) 2)))

(defn search [f neg-point pos-point]
  (let [midpoint (average neg-point pos-point)]
    (if (close-enough? neg-point pos-point)
      midpoint
      (let [test-value (f midpoint)]
        (cond (pos? test-value)
                (search f neg-point midpoint)
              (neg? test-value)
                (search f midpoint pos-point)
              :else midpoint)))))

(defn half-interval [f a b]
  (let [a-value (f a)
        b-value (f b)]
    (cond 
      (and (neg? a-value) (pos? b-value))  (search f a b)
      (and (neg? b-value) (pos? a-value))  (search f b a)
      :else
       (throw (IllegalArgumentException. "Values are not of opposite sign")))))

; Finding fixed points
(defn fixed-point [f first-guess]
  (letfn [(test [guess]
                (print guess " ")
                (let [next (f guess)]
                  (if (close-enough? guess next)
                    next
                    (test next))))]
    (test first-guess)))

(defn sqrt [x]
  (fixed-point (fn [y] (average y (/ x y))) 1.0))

; ex 1.35
(defn golden-ratio []
  (fixed-point #(+ 1 (/ %)) 1.0))

; ex 1.36
(defn x-x []
  (fixed-point #(/ (Math/log 1000) (Math/log %)) 2.0))

; ex 1.37
(defn cont-frac [n d k]
  (letfn [(rec [i]
                (if (= i k)
                  (/ (n i) (d i))
                  (/ (n i) (+ (d i) (rec (inc i))))))]
         (rec 1)))

; ex. 1.37-b