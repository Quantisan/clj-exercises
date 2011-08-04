(ns joy.foundations)

(set! *print-meta* true)

(comment
(def *file-key* \a)
(def *rank-key* \0)

(defn- file-component [file]
  (- (int file) (int *file-key*)))

(defn- rank-component [rank]
  (* 8 (- 8 (- (int rank) (int *rank-key*)))))

(defn- index [file rank]
  (+ (file-component file) (rank-component rank)))

(defn lookup [board pos]
  (let [[file rank] pos]
    (board (index file rank))))
)

(letfn [(index [file rank]
          (let [f (- (int file) (int \a))
                r (* 8 (- 8 (- (int rank) (int \0))))]
            (+ f r)))]
  (defn lookup [board pos]
    (let [[file rank] pos]
      (board (index file rank)))))


(defn lookup2 [board pos]
  (let [[file rank] (map int pos)
        [fc rc] (map int [\a \0])
        f (- file fc)
        r (* 8 (- 8 (- rank rc)))
        index (+ f r)]
    (board index)))

(def bv
  [\r \n \b \q \k \b \n \r
	 \p \p \p \p \p \p \p \p
	 \- \- \- \- \- \- \- \-
	 \- \- \- \- \- \- \- \-
	 \- \- \- \- \- \- \- \-
	 \- \- \- \- \- \- \- \-
	 \P \P \P \P \P \P \P \P
	 \R \N \B \Q \K \B \N \R])


(defn xors [max-x max-y] 
  (for [x (range max-x) y (range max-y)] 
    [x y (rem (bit-xor x y) 256)]))
(defn f-values [f xs ys]
  (for [x (range xs) y (range ys)]
    [x y (rem (f x y) 256)]))

(defn clear [g] (.clearRect g 0 0 200 200))
(def frame (java.awt.Frame.))
(.setSize frame (java.awt.Dimension. 200 200))
(.setVisible frame true)
(def gfx (.getGraphics frame))
(doseq [[x y xor] (xors 500 500)]
  (.setColor gfx (java.awt.Color. xor xor xor))
  (.fillRect gfx x y 1 1))

(defn draw-values [f xs ys]
  (clear gfx)
  (.setSize frame (java.awt.Dimension. xs ys))
  (doseq [[x y v] (f-values f xs ys)]
    (.setColor gfx (java.awt.Color. v v v))
    (.fillRect gfx x y 1 1)))




