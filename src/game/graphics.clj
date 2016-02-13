(ns game.graphics
  (:require [quil.core :as q]
            [quil.middlewares.fun-mode :refer [fun-mode]]
            [game.logic :as game]))

(defn setup! []
  (q/frame-rate 12)
  (q/stroke 0)
  (q/stroke-weight 2)
  (q/fill 255)
  {:cam -170
   :cells (game/cell-patterns :infinite-growth)})

(defn next-state [state]
  (-> state (update :cells game/next-generation)
            (update :cam + 0.75)))

(defn draw! [{:keys [cam cells]}]
  (q/background 0)
  (doseq [[x y] cells :let [d 10]]
    (q/rect (+ cam (* x d)) (+ cam (* y d)) d d)))

(q/defsketch animation
             :setup setup!
             :draw draw!
             :update next-state
             :size [250 250]
             :middleware [fun-mode])
