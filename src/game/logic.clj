(ns game.logic)

(def cell-patterns
  {:block            #{[4 4] [4 5] [5 4] [5 5]}

   :blinker          #{[4 5] [5 5] [6 5]}

   :glider           #{[6 5] [6 6] [4 5] [5 6] [6 4]}

   :spaceship        #{[2 2] [5 2] [6 3] [2 4] [6 4] [3 5] [4 5]
                       [5 5] [6 5]}

   :infinite-growth  #{[12 17] [14 16] [14 17] [16 13] [16 14]
                       [16 15] [18 12] [18 13] [18 14] [19 13]}

   :gosper-gun       #{[2 6] [2 7] [3 6] [3 7] [12 6] [12 7]
                       [12 8] [13 5] [13 9] [14 4] [14 10] [15 4]
                       [15 10] [16 7] [17 5] [17 9] [18 6] [18 7]
                       [18 8] [19 7] [22 4] [22 5] [22 6] [23 4]
                       [23 5] [23 6] [24 3] [24 7] [26 2] [26 3]
                       [26 7] [26 8] [36 4] [36 5] [37 4] [37 5]}})

(defn neighbours [[x y]]
  (for [dx [-1 0 1] dy (if (= 0 dx) [-1 1] [-1 0 1])]
    [(+ dx x) (+ dy y)]))

(defn next-generation [cells]
  (set (for [[loc n] (frequencies (mapcat neighbours cells))
             :when (or (= n 3) (and (= n 2) (cells loc)))] loc)))
