(ns joy.ch6-lazy)

(defn xconj [t v]
  (cond
    (nil? t) {:val v, :L nil, :R nil}
    (< v (:val t)) {:val (:val t),
                    :L (xconj (:L t) v),
                    :R (:R t)}))

(defn rec-step [[x & xs]]
  (if x
    [x (rec-step xs)]
    []))

(defn lz-rec-step [s]
  (lazy-seq
    (if (seq s)
      [(first s) (lz-rec-step (rest s))]
      [])))

(defn simple-range [i limit]
  (lazy-seq
    (when (< i limit)
      (cons i (simple-range (inc i) limit)))))

(defn triangle [n]
  (/ (* n (+ n 1)) 2))

(def tri-nums (map triangle (iterate inc 1)))

(defn defer-expensive [cheap expensive]
  (if-let [good-enough (force cheap)]
    good-enough
    (force expensive)))

(defn nom [n] (take n (repeatedly #(rand-int n))))

(defn sort-parts
	"Lazy, tail-recursive, incremental quicksort. Works against
	and creates partitions based on the pivot, defined as 'work'."
	[work]
	(lazy-seq
		(loop [[part & parts] work]
			(if-let [[pivot & xs] (seq part)]
				(let [smaller? #(< % pivot)]
					(recur (list*
			              (filter smaller? xs)
										pivot
										(remove smaller? xs)
										parts)))
    	(when-let [[x & parts] parts]
      	(cons x (sort-parts parts)))))))

(defn qsort [xs]
	(sort-parts (list xs)))