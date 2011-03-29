(ns dojo-ants.test.core
  (:use [dojo-ants.core])
  (:use [clojure.test]))

(def ant1 {:x 5
	   :y 5})

(def ant2 {:x 6
	   :y 6})

(def water-ant {:x 2
	   :y 2})

(def test-world {:ants [ant1 ant2] :water #{[1 2] } :rows 10 :cols 10})

(deftest test-is-water 
  (is (is-water? test-world 1 2)))

(deftest test-north
  (is (= (north ant1)
	 {:x 5
	  :y 6})))

(deftest test-south
  (is (= (south ant2)
	 {:x 6
	  :y 5})))

(deftest test-east
  (is (= (east ant1)
	 {:x 6
	  :y 5})))

(deftest test-west
  (is (= (west ant2)
	 {:x 5
	  :y 6})))

(deftest test-move-success
  (is (= (move ant1 north test-world)
	 {:x 5
	  :y 6})))

(deftest test-move-into-water-should-fail
  (is (= (move water-ant west test-world)
	 {:x 2
	  :y 2})))

;(deftest test-orders
;  (is = (execute-orders test-world [ [1 north] ])
;	
;			
;
;
;
;			)))


