(ns game.graphics
  (:require [quil.core :refer :all]
            [quil.middlewares.fun-mode :refer :all]
            [game.logic :refer :all]))

(def initial-cells (cell-patterns :infinite-growth))

(defn setup-grid! []
  (frame-rate 10)
  (stroke 0)
  (stroke-weight 2)
  (fill 255)
  {:cells initial-cells
   :camera [-130 -130]})

(defn update-state [state]
  (-> state
      (update :cells next-generation)
      (update-in [:camera 0] #(+ 0.8 %))
      (update-in [:camera 1] #(+ 0.8 %))))

(defn draw-frame! [{:keys [cells camera]}]
  (background 0)
  (with-translation [camera]
    (let [size 10]
      (doseq [x (range 0 (width) size)]
        (line x 0 x (height)))
      (doseq [y (range 0 (height) size)]
        (line 0 y (width) y))
      (doseq [[x y] cells]
        (rect (* x size) (* y size) size size)))))

(defsketch animation
           :setup setup-grid!
           :draw draw-frame!
           :update update-state
           :title "Game of Life"
           :size [500 500]
           :middleware [fun-mode])
