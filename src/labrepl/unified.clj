(ns labrepl.unified
  (:refer-clojure :exclude [get])
  (:use [clojure.contrib.json :only (read-json)]))

(defn create-1 []
  (atom {}))

(defn get [cache key]
  (@cache key))

(defn put-1 [cache key value]
  (swap! cache assoc key value))

(defn put
  ([cache value-map]
     (dosync
      (alter cache merge value-map)))
  ([cache key value]
     (dosync
      (alter cache assoc key value)))) 

(defn create
  ([] (create {}))
  ([initial-value] (ref initial-value)))

(let
 [[colors powers] (repeatedly create)]
 (dosync
  (put colors :hulk "green")
  (put powers :sinestro "fear-powered space flight"))
 {:colors colors, :powers powers})

(defn fast-put
  ([cache value-map]
     (dosync
      (commute cache merge value-map)))
  ([cache key value]
     (dosync
      (commute cache assoc key value))))