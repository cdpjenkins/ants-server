(ns dojo-ants.core)

(def ROWS 100)
(def COLS 100)

;(def ant1 (map
;	   :x 5
;	   :y 5))
;
;(def ant2 (map
;	   :x 6
;	   :y 6))
     
;; water is a vector of coord pairs
;(def the-world {:ants [ant1 ant2] :water #{} :rows ROWS :cols COLS})

(defn is-water? [world x y] (contains? (:water world) [x y]))

(defn north [ant]
  {:x (:x ant)
   :y (inc (:y ant))})

(defn south [ant]
  {:x (:x ant)
   :y (dec (:y ant))})


(defn east [ant]
  {:x (inc (:x ant))
   :y (:y ant)})

(defn west [ant]
  {:x (dec (:x ant))
   :y (:y ant)})

(defn move [ant order world]
  (let [moved-ant (order ant)]
    (if (is-water? world (:x moved-ant) (:y moved-ant))
      ant
      moved-ant)))