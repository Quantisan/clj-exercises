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
               (let [c  (cond
                          (zero? k) 1
                          (= k n)   1
                          (odd? k)  4
                          (even? k) 2)]
                 (* c
                    (f (+ a (* k h))))))]
    (* (/ h 3)
       (sum term 0 inc n))))