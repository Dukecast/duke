(ns duke.app
  (:require [om.core :as om :include-macros true]
            [sablono.core :as html :refer-macros [html]]))

(defn widget [data owner]
  (reify
    om/IRender
    (render [this]
      (html
       [:h2 (:text data)]))))

(defn init []
  (om/root widget {:text "This is duke, prepare to be amazed"}
           {:target (. js/document (getElementById "container"))}))
