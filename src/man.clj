(ns man)

(defn generate
  "Generate a list of n random numbers each chosen from [0, k)."
  [n k]
  (when (> n 0)
    (lazy-seq (cons (rand-int k) (generate (dec n) k)))))

(defn duplicates
  "Returns all the duplicates of key within coll."
  [coll key]
  (filter (partial = key) coll))

(defn remove-dups
  "Returns a coll without all the duplicates of key."
  [coll key]
  (remove (partial = key) coll))

(defn sift-recur
" Given a list of items, find all the duplicates.
  Rules: - only equal can be used
        - items are not comparable (i.e. no sorting)."
  [coll]
  (when-let [s (seq coll)]
    (let [f      (first s)
          r      (rest s)
          dups   (duplicates s f)]
      (if (seq dups)      
        (lazy-seq (cons dups (sift-recur (remove-dups r f))))
        (lazy-seq (sift-recur (remove-dups r f)))))))

;; TODO parallelize