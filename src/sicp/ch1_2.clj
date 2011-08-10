(ns sicp.ch1-2)

(defn factorial-down
  [n]
	(if (= n 1)
		1
		(* n (factorial-down (dec n)))))

(defn factorial-up
  [n]
  (letfn [(iter [product counter max-count]
          	(if (> counter max-count)
							product
							(recur (* counter product)
								(+ counter 1)
								max-count)))]                
	(iter 1 1 n)))

;; ex 1.9
(defn plus-1
  [a b]
	(if (= a 0)
		b
		(inc (plus-1 (dec a) b))))	; iterative

(defn plus-2
  [a b]
	(if (= a 0)
		b
		(recur (dec a) (inc b))))		; recursive

;; ex. 1.10
(defn A
  [x y]
	(cond 
  	(= y 0) 0
    (= x 0) (* 2 y)
		(= y 1) 2
		:else (A (dec x)
             (A x (dec y)))))


;;;;

(defn fib-rec
  [n]
  (cond 
    (= n 0) 0
    (= n 1) 1
    :else (+ (fib (dec n))
             (fib (- n 2)))))

(defn fib-iter
  [n]
  (letfn [(iter 
            [a b count]
            (if (= count 0)
              b
              (recur (+ a b) a (dec count))))]
         (iter 1 0 n)))
                