(ns humaweb.util)

(defn map2s [f a]
  (map #(@(resolve f) (first %) (first (rest %))) a))
