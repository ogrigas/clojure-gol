(ns game.graphics
  (:require [quil.core :refer :all]
            [quil.middlewares.fun-mode :refer :all]
            [game.logic :refer :all]))

(def initial-cells (cell-patterns :infinite-growth))

(defn setup-grid! []
  (smooth)
  (stroke 100 100 100)
  (stroke-weight 2)
  (fill 255 255 255)
  (frame-rate 12)
  initial-cells)

(defn draw-frame! [live-cells]
  (background 0 0 0)
  (let [size 20]
    (doseq [x (range 0 (width) size)]
      (line x 0 x (height)))
    (doseq [y (range 0 (height) size)]
      (line 0 y (width) y))
    (doseq [[x y] live-cells]
      (rect (* x size) (* y size) size size))))

(defsketch animation
           :setup setup-grid!
           :draw draw-frame!
           :update next-generation
           :title "Game of Life"
           :size [800 500]
           :middleware [fun-mode])
