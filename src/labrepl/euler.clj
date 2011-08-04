(ns labrepl.euler)

(defn divides? [nu de]
  (zero? (rem nu de)))

(defn divides-any
  "Return a predicate that tests whether its arg can be
   evenly divided by any of nums."
  [& nums]
  (fn [arg]
    (boolean (some #(divides? arg %) nums))))

(defn p1 [upper]
  (let [divisible? (divides-any 3 5)]
    (loop [sum 0, n 1]
      (if (>= n upper)		
        sum
        (recur (if (divisible? n) (+ sum n) sum) (inc n))))))

(defn problem-1
  "Sum the numbers divisible by 3 or 5, from 0 to upper."
  ([] (problem-1 1000))
  ([upper]
     (apply
      +
      (filter
       (divides-any 3 5)
       (range upper)))))