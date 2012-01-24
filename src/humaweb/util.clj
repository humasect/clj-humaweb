(ns humaweb.util)

(defn map2s [f a]
  (map #(@(resolve f) (first %) (first (rest %))) a))

;; (defn map3s [f a]
;;   (map #(@(resolve f) (first %) (first (rest %)) (first))))

(defn get-current-directory []
  (. (java.io.File. ".") getCanonicalPath))

(defn get-current-port []
  (Integer. (get (System/getenv) "PORT" "8080")))

(defn get-database-url []
  (System/getenv "DATABASE_URL"))