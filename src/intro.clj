(ns intro)


"First high-level programming languages:"

;   _____ ___  ____ _____ ____      _    _   _           _  ___  ____ _____
;  |  ___/ _ \|  _ \_   _|  _ \    / \  | \ | |         / |/ _ \| ___|___  |
;  | |_ | | | | |_) || | | |_) |  / _ \ |  \| |  _____  | | (_) |___ \  / /
;  |  _|| |_| |  _ < | | |  _ <  / ___ \| |\  | |_____| | |\__, |___) |/ /
;  |_|   \___/|_| \_\|_| |_| \_\/_/   \_\_| \_|         |_|  /_/|____//_/   


"and then"

;   _      _  ___    ___                    _    __   _____    _
;  ( )    (_)(  _`\ (  _`\                /' ) /'_ `\(  ___) /'_`\
;  | |    | || (_(_)| |_) )    ______    (_, |( (_) || (__  ( (_) )
;  | |  _ | |`\__ \ | ,__/'   (______)     | | \__, ||___ `\ > _ <'
;  | |_( )| |( )_) || |                    | |    | |( )_) |( (_) )
;  (____/'(_)`\____)(_)                    (_)    (_)`\___/'`\___/'









(def imperative->declarative
  
  {:statements     [:expressions]
   
   :branching      [:polymorphism, :higher-order-functions]
   
   :looping        [:recursion, :higher-order-functions]
   
   :mutable-state  [:values]
   
   :side-effects   [:data-transformations]})










;     ________        _                             ___   ____  ____  _____
;    / ____/ /___    (_)_  __________              |__ \ / __ \/ __ \/__  /
;   / /   / / __ \  / / / / / ___/ _ \   ______    __/ // / / / / / /  / /
;  / /___/ / /_/ / / / /_/ / /  /  __/  /_____/   / __// /_/ / /_/ /  / /
;  \____/_/\____/_/ /\__,_/_/   \___/            /____/\____/\____/  /_/
;              /___/


(def clojure-philosophy

  [:simplicity

   :focus

   :empowerment

   :consistency

   :pragmatism])








(def clojure-features

  [:minimalist

   :homoiconic              ; code as data

   :dynamic                 ; REPL, strong typing
   
   :compiled

   :functional              ; pure functions, persistent data structures

   :abstraction-oriented    ; protocols, records, multimethods

   :concurrent              ; dynamic vars atoms, agents, STM

   :hosted])









"One can describe any programming language in terms of:"

;        __                 __
;  __   |__)_. _ .|_.   _  |_    _  _ _ _ _. _  _  _
;       |  | ||||||_|\/(-  |__)(|_)| (-_)_)|(_)| )_)
;                               |
;                           _   __
;  __   |\/| _ _  _  _   _ (_  /   _  _ |_ . _  _ |_. _  _
;       |  |(-(_|| )_)  (_)|   \__(_)||||_)|| )(_||_|(_)| )
;
;                           _
;  __   |\/| _ _  _  _   _ (_   /\ |_  _|_ _ _  _|_. _  _
;       |  |(-(_|| )_)  (_)|   /--\|_)_)|_| (_|(_|_|(_)| )



     ["Structure and Interpretation of Computer Programs"]
                            ["H. Abelson", "G.J. Sussman"]










;^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
;        __                 __
;  __   |__)_. _ .|_.   _  |_    _  _ _ _ _. _  _  _
;       |  | ||||||_|\/(-  |__)(|_)| (-_)_)|(_)| )_)
;                               |


(def syntax-for-built-in-data-types
  
  {:nil           nil
   
   :boolean       true
   
   :long          42

   :double        42.0
   
   :big-integer   42N
   
   :big-decimal   42M
   
   :ratio         1/3

   :character     \p

   :string        "Quick Brown Fox"

   :regex         #"[\w\d]+"
   
   :keyword       :quick-brown-fox
   
   :symbol        contains?
   
   :vector        [1 1 2 3 5 8 13 21]

   :list          (:quick :brown :fox)

   :map           {:name "Alan" :surname "Perlis"}
   
   :set           #{1 2 3}
   
   :function      (fn [foo bar] "BAZ")

   :function'     #(.toUpperCase %)                  })










;^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
;                           _   __
;  __   |\/| _ _  _  _   _ (_  /   _  _ |_ . _  _ |_. _  _
;       |  |(-(_|| )_)  (_)|   \__(_)||||_)|| )(_||_|(_)| )


(comment


  (some-function arg1 arg2 arg3)


  (if test-expr then-expr else-expr)   ; also: cond, case, when ...


  (do expr1 expr2 expr3)    ; also: doseq, doall, dotimes ...

 
  )








;^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
;                           _
;  __   |\/| _ _  _  _   _ (_   /\ |_  _|_ _ _  _|_. _  _
;       |  |(-(_|| )_)  (_)|   /--\|_)_)|_| (_|(_|_|(_)| )



(def person {:name "Aaron" :age 17})
(def point-2d [12 5])


(def adult? (fn [age] (>= age 18)))

(defn adult? [age]
  (>= age 18))


(let [age (:age person)
      name (:name person)]
  (str "Is " name " adult: " (adult? age)))


; destructuring

(defn distance [point1 point2]
  (let [[x1 y1] point1
        [x2 y2] point2
        dx (- x2 x1)
        dy (- y2 y1)]
    (Math/sqrt (+ (* dx dx) (* dy dy)))))


(defn distance [[x1 y1] [x2 y2]]
  (let [dx (- x2 x1)
        dy (- y2 y1)]
    (Math/sqrt (+ (* dx dx) (* dy dy)))))



