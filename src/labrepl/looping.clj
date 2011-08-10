(ns labrepl.looping)

(defn min-1
  [x & more]
  (loop [small x
         more (seq more)]
    (if-let [i (first more)]
      (recur (if (< i small) i small) (next more))
      )))

(defn min-2
  [x & more]
  (loop [min x
         [a & more] (seq more)]
    (if a
      (recur (if (< a min) a min) more)
      min)))

(defn min-3 [x]
 	(reduce #(if (< %1 %2) %1 %2) x))


(defn zipm-1 [ks vs]
  (loop [buff {}, [k & ks] (seq ks), [v & vs] (seq vs)]
    (if (and k v)
      (recur (assoc buff k v) ks vs)
      buff)))

(defn zipm-3 [ks vs]
  (reduce (fn [m [k v]] (assoc m k v)) {} (map vector ks vs)))
;(zipm-3 [:a :b :c] [1 2 3])

(defn zipm-4 [ks vs]
  (apply hash-map (interleave ks vs)))

(defn zipm-5 [ks vs]
  (into {} (map vector ks vs)))

(defn minmax-1 [x & more]
  (loop [mi x
         mx x
         [a & more] (seq more)]
    (if a
      (recur (if (< a mi) a mi) (if (> a mx) a mx) more)
      {:min mi, :max mx})))

(defn minmax-2 [x & more]
  (reduce (fn [mm x]
            (cond
              (< x (:min mm))	(assoc mm :min x)
              (> x (:max mm)) (assoc mm :max x)
              :else	mm))
    {:min x, :max x} (seq more)))