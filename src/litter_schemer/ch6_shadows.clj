(ns litter-schemer.ch6-shadows)

(def aexp '(4 \+ 5))

(defn first-sub-exp [aexp]
  (second aexp))

(defn sec-sub-exp [aexp]
  (nth aexp 2))

(defn operator [aexp]
  (first aexp))

(defn numbered? [aexp]
  (cond
    (number? aexp)	true
    (= (second aexp) \+) (and (number? (first aexp)) (number? (nth aexp 2)))
    (= (second aexp) \x) (and (number? (first aexp)) (number? (nth aexp 2)))
    (= (second aexp) \^) (and (number? (first aexp)) (number? (nth aexp 2)))
    :else	false))

(defn value [nexp]
  (cond
    (number? nexp)	nexp
    (= (operator nexp) \+) (+ (value (first-sub-exp nexp)) (value (sec-sub-exp nexp)))
		(= (operator nexp) \x) (* (value (first-sub-exp nexp)) (value (sec-sub-exp nexp)))
		(= (operator nexp) \^) (Math/pow (value (first-sub-exp nexp)) (value (sec-sub-exp nexp)))
  	:else	nil))

(defn sero? [n]
  (= '() n))

(defn add1 [n]
  (cons '() n))

(defn sub1 [n]
  (next n))

(defn plus [n m]
  (concat n m))

(def one-two '((()) (()())))
(defn lat? [l]
  (cond
    (empty? l)	true
    (not (seq? (first l)))	(lat? (rest l))
    :else			false))