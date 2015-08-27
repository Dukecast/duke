(ns duke.styles
  (:require [garden.def :refer [defrule defstyles]]
            [garden.stylesheet :refer [rule]]))

(defstyles screen
  (let [body (rule :body)]
    (body
     {:font-family "Helvetica Neue"
      :font-size "18px" 
      :color "#4E4E4E"
      :background-color "#F0F0E7"})))
