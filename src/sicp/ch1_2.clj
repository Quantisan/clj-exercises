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

(defn g [n] (A 1 n))
(defn f [n] (A 2 n))

;;;;
;; pg 82

(defn fib-rec
  [n]
  (cond 
    (= n 0) 0
    (= n 1) 1
    :else (+ (fib-rec (dec n))
             (fib-rec (- n 2)))))

(defn fib-iter
  [n]
  (letfn [(iter 
            [a b count]
            (if (= count 0)
              b
              (recur (+ a b) a (dec count))))]
         (iter 1 0 n)))

;;;;;
;; pg 84

(defn first-denomination 
  [kinds-of-coins]
  (cond
    (= kinds-of-coins 1) 1
    (= kinds-of-coins 2) 5
    (= kinds-of-coins 3) 10
    (= kinds-of-coins 4) 25
    (= kinds-of-coins 5) 50))

(defn cc 
  [amount kinds-of-coins]
  (cond 
    (= amount 0) 1
    (or (< amount 0) (= kinds-of-coins 0)) 0
    :else (+ (cc amount
                 (- kinds-of-coins 1))
             (cc (- amount
                    (first-denomination kinds-of-coins))
                 kinds-of-coins))))

(defn count-change
  [amount]
  (cc amount 5))

;; ex 1.11
(defn f-rec
  "A function f is defined by the rule that f (n) = n if
n < 3 and f (n) = f (n - 1) + 2f (n - 2) + 3f (n - 3) if n >= 3. Write a
procedure that computes f by means of a recursive process. Write
a procedure that computes f by means of an iterative process."
  [n]
  (if (< n 3)
    n
    (+ (f-rec (dec n))
       (* 2 (f-rec (- n 2)))
       (* 3 (f-rec (- n 3))))))

(defn f-iter2
"
 f (n) = n if n < 3;
 and f (n) = f (n - 1) + 2f (n - 2) + 3f (n - 3) if n >= 3
"
  [n]
  (if (< n 3)
    n
    (loop [a 2, b 1, c 0, x n]
      (if (< x 3)
        a
        (recur (+ a (* 2 b) (* 3 c)) a b (dec x))))))

(defn f-iter
"f (n) = n if n < 3;
and f (n) = f (n - 1) + 2f (n - 2) + 3f (n - 3) if n >= 3"
  [n]
  (letfn [(iter 
            [a b c count]
            (if (> count n)
              a
              (recur (+ a 
                        (* 2 b)
                        (* 3 c))
                     a
                     b
                     (inc count))))]
         (if (< n 3)
           n
           (iter 2 1 0 3))))

; ex 1.12
(defn pascal [depth pos]
  (if (or (= depth 1) (= pos 1) (= pos depth))
    1
    (+ (pascal (dec depth) (dec pos)) 
       (pascal (dec depth) pos))))

; ex 1.16
(defn square [x] (* x x))

(defn fast-expt [b n]
  (cond 
    (= n 0) 1
    (even? n) (square (fast-expt b (/ n 2)))
    :else (* b (fast-expt b (- n 1)))))
  
(defn fast-expt-iter [b n]
  (loop [a   (if (even? n) 1 b)
         x   b
         cnt n]
    (if (< cnt 2)
      (* a x)
      (recur a (square x) (/ cnt 2)))))

; ex 1.17
(defn mult [a b]
  (if (zero? b)
    0
    (+ a (mult a (- b 1)))))
    
(defn double [x]
  (+ x x))
(defn half [x]
  (/ x 2))

(defn fast-mult [a b]
  (cond 
    (zero? b) 0
    (even? b) (double (fast-mult a (half b)))
    :else (+ a (fast-mult a (dec b)))))

; ex 1.18
(defn fast-mult-iter [a b]
  (loop [buf (if (even? b) 0 a)
         x   a
         cnt b]
    (if (< cnt 2)
      (+ buf x)
      (recur buf (double x) (half cnt)))))

; ex 1.19
(defn fib-iter [a b p q count]
  (println a b p q count)
  (cond 
    (zero? count) b
    (even? count) (fib-iter a
                            b 
                            (+ (square p) (square q))
                            (+ (square q) (* 2 p q))
                            (half count))
    :else (fib-iter (+ (* b q) (* a q) (* a p))
                    (+ (* b p) (* a q))
                    p
                    q
                    (dec count))))

(defn fib [n]
  (fib-iter 1 0 0 1 n))

; pg 98
(defn divides? [a b]
     (zero? (rem b a)))
(defn find-divisor [n test-divisor]
   (cond 
     (> (square test-divisor) n) n
     (divides? test-divisor n) test-divisor
     :else (find-divisor n (inc test-divisor))))
(defn smallest-divisor [n]
  (find-divisor n 2))
(defn prime? [n]
  (= n (smallest-divisor n)))