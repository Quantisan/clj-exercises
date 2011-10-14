(ns euler.probs1s
  (:require [clojure.math.numeric-tower :as math])
  (:require [clojure.string :as str])
  (:use [clojure.set :only (difference)]))

(declare primes)  
  
(defn p1 []
  (apply + (let [x (range 1000)]
             (filter #(or (= (rem % 3) 0) (= (rem % 5) 0)) x))))

(defn p2 []
	(letfn [(fib [lim]
           (loop [lat [1 2]]
             (let [x2 (last lat)
                   x1 (last (butlast lat))]
               (if (< x2 lim)
                 (recur (conj lat (+ x1 x2)))
                 lat))))]
   (apply + (filter even? (fib 4e6)))))

(defn recur-fib [lim]
 (loop [lat [0 1]]
   (let [x2 (last lat)
         x1 (last (butlast lat))]
     (if (< x2 lim)
       (recur (conj lat (+ x1 x2)))
       lat))))

(def fib-seq 
  ((fn rfib [a b] 
     (lazy-seq (cons a (rfib b (+ a b)))))
   0 1))

(def lz-fib
  (lazy-cat [0 1] 
		        (map (fn [a b]
			            (println (format "Adding %d and %d." a b))
			            (+ a b))
		        	(rest lz-fib) lz-fib)))

;; stackoverflow Q: fix it => DONE
;; http://stackoverflow.com/questions/6454424/fibonacci-sequence-using-loop-and-recur
(defn fib-even-sum [upto]
  (loop [previous 1 nxt 1 sum 0]
    (if (or (<= upto 1) (>= nxt upto))
     	sum
	    (if (= (mod nxt 2) 0)
	       (recur nxt (+ previous nxt) (+ sum nxt))
	       (recur nxt (+ previous nxt) sum)))))


(defn slow-primes [ub]
	(reduce
	 (fn [primes number]
	   (if (some zero? (pmap (partial rem number) primes))
	     primes
	     (conj primes number)))
	 [2]
	 (take ub (iterate inc 3))))

(defn slower-primes [ub]
  (loop [p [2], i 3]
    (if (< i ub)
      (recur (if (some zero? (map (partial rem i) p)) p (conj p i)) (inc i))
      p)))

(defn p3-1 [a]
  (letfn [(divisors [x]
  					(filter #(zero? (rem x %)) (range 1 (inc x))))
          (primes [x]
            (filter #(= (count (divisors %)) 2) (range 1 (inc (math/sqrt x)))))]
    (primes (divisors a))))

(defn p3-2 [a]
  (let [primes (take-while #(> a (* % %)) primes)
        divisibles? (filter #(zero? (rem a %)) primes)]
    (apply max divisibles?)))

(defn p3-3 [value]
  (loop [x value, fac 2]
    (if (= x 1)
      fac
      (let [divisible? 	(zero? (rem x fac))
            new-x				(if divisible? (/ x fac) x)
            new-fac			(if divisible? fac (inc fac))]
       	(recur new-x new-fac))))) 

(defn p6 [n]
  (let [nums						(range 1 (inc n))
        sum-of-squares	(->> nums (map #(* % %)) (reduce +))
        square-of-sum		(#(* % %) (reduce + nums))]
    (- square-of-sum sum-of-squares)))

(defn p5-3 [n]
  (letfn [(gcd [a b] (if (zero? b) a (recur b (mod a b))))
          (lcm [a b] (/ (* a b) (gcd a b)))]
    (reduce #(lcm %1 %2) (range 1 (inc n)))))

(defn p5-2 [n]
  (let [pri-set		(into #{} (take-while #(> n %) primes))
        rng-set		(into #{} (range 2 (inc n)))
        com				(into [] (difference rng-set pri-set))
        pri-map		(zipmap pri-set (repeatedly 1))]
    (loop [pm		pri-map
           com	com]
      (reduce	#()))))

(defn p5-1 [n]
  (let [nums			(range 2 (inc n))
        fractions	(->> nums (map #(/ 7 %)))]
    (denominator 
      (reduce (fn [x y]
                (let [sum (+ x y)]
                  (/ (denominator sum))))
        fractions))))

(defn p4-1 [digits]		;; a quick solution, note a-b? doesn't traverse all range
  (let [lb		(math/expt 10 (dec digits))			;; lower bound
        ub		(math/expt 10 digits)						;; upper bound
        rs		(range (* ub ub) (* lb lb) -1)	
        pal?	(fn [x]													;; is number palindrome?
                   (let [str-x	(str x)]
                     (= str-x (str/reverse str-x))))
        pa		(filter pal? rs)		;; filters out palindrome numbers
       	a-b? 	(fn	[x]			;; is x = a * b, where count(a, b) = digits?                 
							  (let [guess		(math/ceil (math/sqrt x))]	;; * initial guess at sqrt *
							    (loop [a	guess]
							      (cond
							        (> a (Math/pow 10 digits))	nil
							        (zero? (rem x a))						(list x)
               				:else												(recur (inc a))))))]
    (first (drop-while nil? (map #(a-b? %) pa)))))

(defn p7-1 [n]
  (loop [primes	[2], idx 3]
    	(if (= (count primes) n)
    		(last primes)
     		(let [idx-root		(math/floor (math/sqrt idx))
             	shr-primes	(filter #(<= % idx-root) primes)
							prime?			(every? #(not= % 0) (map #(rem idx %) shr-primes))]
          (recur 
            (if prime? 
             (conj primes idx)
             primes)
		        (+ idx 2))))))
    
(def p7-2		;; not working
  (lazy-seq (loop [primes	[2], idx 3]
		(let [idx-root		(math/floor (math/sqrt idx))
         	shr-primes	(filter #(<= % idx-root) primes)
					prime?			(every? #(not= % 0) (map #(rem idx %) shr-primes))]
      (recur 
        (if prime? 
         (conj primes idx)
         primes)
        (+ idx 2))))))

(def p8-str	 "73167176531330624919225119674426574742355349194934
							96983520312774506326239578318016984801869478851843
							85861560789112949495459501737958331952853208805511
							12540698747158523863050715693290963295227443043557
							66896648950445244523161731856403098711121722383113
							62229893423380308135336276614282806444486645238749
							30358907296290491560440772390713810515859307960866
							70172427121883998797908792274921901699720888093776
							65727333001053367881220235421809751254540594752243
							52584907711670556013604839586446706324415722155397
							53697817977846174064955149290862569321978468622482
							83972241375657056057490261407972968652414535100474
							82166370484403199890008895243450658541227588666881
							16427171479924442928230863465674813919123162824586
							17866458359124566529476545682848912883142607690042
							24219022671055626321111109370544217506941658960408
							07198403850962455444362981230987879927244284909188
							84580156166097919133875499200524063689912560717606
							05886116467109405077541002256983155200055935729725
							71636269561882670428252483600823257530420752963450")

(def p8-q (let [s	 "73167176531330624919225119674426574742355349194934
										96983520312774506326239578318016984801869478851843
										85861560789112949495459501737958331952853208805511
										12540698747158523863050715693290963295227443043557
										66896648950445244523161731856403098711121722383113
										62229893423380308135336276614282806444486645238749
										30358907296290491560440772390713810515859307960866
										70172427121883998797908792274921901699720888093776
										65727333001053367881220235421809751254540594752243
										52584907711670556013604839586446706324415722155397
										53697817977846174064955149290862569321978468622482
										83972241375657056057490261407972968652414535100474
										82166370484403199890008895243450658541227588666881
										16427171479924442928230863465674813919123162824586
										17866458359124566529476545682848912883142607690042
										24219022671055626321111109370544217506941658960408
										07198403850962455444362981230987879927244284909188
										84580156166097919133875499200524063689912560717606
										05886116467109405077541002256983155200055935729725
										71636269561882670428252483600823257530420752963450"]
            (str/replace s #"[\t\n]" "")))

(defn p8-1 
  ([]		(p8-1 p8-q))
  ([x]	(let [lat			(partition 5 1 x)
	        to-int	(fn [x]
	                 (map (fn [y] (Character/getNumericValue y)) 
	                   x))
	        lat			(map to-int lat)
	        sums		(map #(apply * %) lat)]
         (apply max sums))))

(defn p8-2 [string]
  (->> (partition 5 1 string)
       (map (partial map #(Character/getNumericValue %)))
       (map (partial reduce *))
       (reduce max)))

(defn p9-1 [x]
  (let [check-eq	(fn [c]
	                 (fn [a]		;; reworked equality formulas into only A and C
	                   (= (+ (* (- x a c) (+ a c)) 
	                        	(* a c) 
	                         	(* c c))
	                     	(/ (* x x) 2))))]
    (remove nil? 
      (for [c			(range 3 (- x 2))
	          :let	[as	(range 1 (dec c))]]
	      (letfn [(scan-as [as]					;; recur a's list
	               (let [[a & as]	as]		
	                 (when a
	                   (if ((check-eq c) a)
	                     (let [b (- x a c)]
	                       (* a b c))
	                     (scan-as (next as))))))]
	       	(scan-as as))))))

(defn recur-primes [n]
  (loop [primes	[2], idx 3]
    	(if (>= (last primes) n)
    		(drop-last primes)
     		(let [idx-root		(math/floor (math/sqrt idx))
             	shr-primes	(filter (partial >= idx-root) primes)
							prime?			(every? (partial not= 0) (map (partial rem idx) shr-primes))]
          (recur 
            (if prime? 
             (conj primes idx)
             primes)
		        (+ idx 2))))))

(defn lazy-primes
  ([]				(lazy-primes [2] 3))
  ([ps idx]	(let [root					(math/floor (math/sqrt idx))
                  shr-primes		(take-while (partial >= root) ps)
									prime?				(every? (partial not= 0) (map (partial rem idx) shr-primes))]
              (lazy-seq (cons (last ps) (lazy-primes 
                             (if prime? 
                               (conj ps idx)
                               ps)
                             (inc idx)))))))

(defn lazy-primes2
  ([]				(lazy-primes2 [2] 3))
  ([ps new-p]	(for [idx						(iterate inc (last ps))
                    :let [root					(math/floor (math/sqrt idx))
                  				shr-primes		(take-while (partial >= root) ps)]
										:when	(every? (partial not= 0) (map (partial rem idx) shr-primes))]
              (lazy-seq (cons (last ps) (lazy-primes2                               
                                          (conj ps (first idx))
                                          (first idx)))))))

(defn fib-maker
  ([] (concat [0 1] (fib-maker 0 1)))
  ([a b] (lazy-seq (cons b (fib-maker b (+ a b))))))

(defn sieve-primes [n]
  (letfn [(sieve [p col]
            (remove #(zero? (rem % p)) col))
          (traverse	[stream]
            (let [[p & col :as all]		stream]
	            (if (< (* p p) n)
              	(cons p (traverse (sieve p col)))
               	all)))]                    
    (traverse (range 2 n))))

(defn p10-1 [ub]
  (reduce + (sieve-primes ub)))

;; found on stackoverflow, very slow, fix it
(defn find-primes-sum [last-prime nums]
    (loop [p last-prime, n nums, sum 0]
        ;(println p)
        (if (empty? n)
        sum
        (recur 
          (first n) 
          (doall (remove #(zero? (mod % (first n))) n))
          (+ sum (first n))))))

(defn sieve-primes-until [limit]
    (find-primes-sum 2 (filter odd? (range 2 (inc limit)))))

;(println (sieve-primes-until 2000000))



