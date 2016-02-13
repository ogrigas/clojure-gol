(ns game.graphics
  (:require [quil.core :as q]
            [quil.middlewares.fun-mode :refer [fun-mode]]
            [game.logic :as game]))

(defn setup! []
  (q/frame-rate 12)
  (q/stroke 0)
  (q/stroke-weight 2)
  (q/fill 255)
  {:cells (game/cell-patterns :infinite-growth)
   :camera -200})

(defn next-state [state]
  (-> state (update :cells game/next-generation)
            (update :camera #(+ 0.75 %))))

(defn draw! [{cells :cells c :camera}]
  (q/background 0)
  (doseq [[x y] cells :let [d 10]]
    (q/rect (+ c (* x d)) (+ c (* y d)) d d)))

(q/defsketch animation
             :setup setup!
             :draw draw!
             :update next-state
             :size [250 250]
             :middleware [fun-mode])
