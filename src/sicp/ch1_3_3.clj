(ns sicp.ch1-3-3)

(defn abs "(abs n) is the absolute value of n" [n]
  {:pre [(number? n)]}
  (if (neg? n) 
    (- n)
    n))

(defn close-enough? [x y]
  (< (abs (- x y)) 0.001))
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