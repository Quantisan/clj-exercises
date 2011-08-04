(ns joy.data-types)

(def matrix
  [[1 2 3]
   [4 5 6]
   [7 8 9]])

(defn neighbors
  ([size yx] (neighbors [[-1 0] [1 0] [0 -1] [0 1]] size yx))
  ([deltas size yx]
    (filter (fn [new-yx]
              (every? #(< -1 % size) new-yx))
      (map #(map + yx %) deltas))))

(defn strict-map1 [f coll]
  (loop [coll coll, acc nil]
    (if (empty? coll)
      acc
      (recur (next coll) (cons (f (first coll)) acc)))))

(defmethod print-method clojure.lang.PersistentQueue
  [q, w]
  (print-method '<- w) (print-method (seq q) w) (print-method '-< w))

