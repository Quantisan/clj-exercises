(ns sicp.ch1-3)

(defn sum [term a next b]
  (if (> a b)
    0
    (+ (term a)
       (sum term (next a) next b))))

(defn cube [x]
  (* x x x))

(defn sum-cubes [a b]
  (sum cube a inc b))

(defn sum-integers [a b]
  (sum identity a inc b))

(defn integral [f a b dx]
  (let [add-dx  (fn [x] (+ x dx))]
    (* (sum f (+ a (/ dx 2.0)) add-dx b) dx)))

; ex 1.29
(defn simpson [f a b n]
  {:pre [(even? n)]}
  (let [h  (/ (- b a) n)
        term (fn [k]
               (let [coeff  (cond
                              (zero? k) 1
                              (= k n)   1
                              (odd? k)  4
                              (even? k) 2)]
                 (* coeff
                    (f (+ a (* k h))))))]
    (* (/ h 3)
       (sum term 0 inc n))))

; ex 1.30
(defn sum-iter [term a next b]
  (loop [a  a, result 0]
    (if (> a b)
      result
      (recur (next a) (+ (term a) result)))))

; ex 1.31
(defn product [term a next b]
  {:pre [(integer? a) (integer? b)]}
  (loop [a  a, result 1]
    (if (> a b)
      result
      (recur (next a) (* (term a) result)))))

(defn factorial [n]
  (product identity 1 inc n))

(defn pi-term [k] 
  (if (even? k) 
    (/ (+ k 2) (+ k 1)) 
    (/ (+ k 1) (+ k 2))))

(defn pi-guess [n]
  (float (* (product pi-term 1 inc n) 4)))

; ex 1.31-b
(defn product-rec [term a next b]
  {:pre [(integer? a) (integer? b)]}
  (if (> a b)
    1
    (* (term a)
       (product-rec term (next a) next b))))

; ex 1.32
(defn accumulate [combiner null-value term a next b]
  {:pre [(fn? combiner) (integer? a) (integer? b)]}
  (if (> a b)
    null-value
    (combiner (term a)
              (accumulate combiner null-value term (next a) next b))))
(def sum-acc (partial accumulate + 0))
(def product-acc (partial accumulate * 1))

(defn accumulate-iter [combiner null-value term a next b]
  {:pre [(fn? combiner) (integer? a) (integer? b)]}
  (loop [a  a, result null-value]
    (if (> a b)
      result
      (recur (next a) (combiner (term a) result)))))
