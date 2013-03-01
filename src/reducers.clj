(ns reducers
  (:require [clojure.core.reducers :as r]))

(reduce + (r/map inc [1 2 3]))
