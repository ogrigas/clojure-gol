(ns game.graphics
  (:require [quil.core :as q]
            [quil.middlewares.fun-mode :refer [fun-mode]]
            [game.logic :as game]))

(def initial-cells (game/cell-patterns :infinite-growth))

(defn setup-grid! []
  (q/frame-rate 10)
  (q/stroke 0)
  (q/stroke-weight 2)
  (q/fill 255)
  {:cells initial-cells
   :camera [-130 -130]})

(defn update-state [state]
  (-> state
      (update :cells game/next-generation)
      (update-in [:camera 0] #(+ 0.8 %))
      (update-in [:camera 1] #(+ 0.8 %))))

(defn draw-frame! [{:keys [cells camera]}]
  (q/background 0)
  (q/with-translation [camera]
    (let [size 10]
      (doseq [x (range 0 (q/width) size)]
        (q/line x 0 x (q/height)))
      (doseq [y (range 0 (q/height) size)]
        (q/line 0 y (q/width) y))
      (doseq [[x y] cells]
        (q/rect (* x size) (* y size) size size)))))

(q/defsketch animation
             :setup setup-grid!
             :draw draw-frame!
             :update update-state
             :title "Game of Life"
             :size [500 500]
             :middleware [fun-mode])
