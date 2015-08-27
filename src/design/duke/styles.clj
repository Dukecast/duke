(ns duke.styles
  (:require [garden.def :refer [defrule defstyles]]
            [garden.stylesheet :refer [rule]]
            [garden.units :refer [px]]))

(defrule body :body)
(defrule container :div#container)

(defstyles playlist
  [:ul.playlist {:margin "0"
                 :padding "0"
                 :list-style-type "none" }]
  [:.track {:border-bottom "1px dotted #ccc"
            :padding (px 10)}
   [:&:hover
    {:font-weight 'bold
     :background-color "#A7DBD8"}]])

(defstyles base
  (body {:font-family "Helvetica Neue"
         :font-size (px 18)
         :color "#4E4E4E"
         :background-color "#F0F0E7"}))

(defstyles screen
  (list base playlist))
