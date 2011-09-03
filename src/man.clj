(ns man)

;; Q: given a long collection of items, find all the duplicates.
;;    only equal can be used, not comparable (i.e. no sorting).

(defn generate
  "Generate a list of n random numbers each chosen from [0, k)."
  [n k]
  (when (> n 0)
    (lazy-seq (cons (rand-int k) (generate (dec n) k)))))

(defn duplicates
  "Returns all the duplicates of key within coll."
  [coll key]
  (filter (partial = key) coll))

