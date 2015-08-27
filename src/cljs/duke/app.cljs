(ns duke.app
  (:require [om.core :as om :include-macros true]
            [sablono.core :as html :refer-macros [html]]))

(defonce initial-state
  (atom {:playlist [{:id 1 :track "Wait and Bleed" :artist "Slipknot" :album "Slipknot"}
                    {:id 2 :track "Zzyzx Rd." :artist "Stone Sour" :album "Come What(ever) May"}
                    {:id 3 :track "Learn To Fly" :artist "Foo Fighters" :album "There Is Nothing Left To Lose"}
                    {:id 4 :track "Viking Death March" :artist "Billy Talent" :album "Dead Silence"}]
         :currently-playing 2}))

(defn widget [data owner]
  (reify
    om/IRender
    (render [this]
      (html
       [:h2 (:currently-playing data)]))))


(defn playlist-track [track owner]
  (reify
    om/IDisplayName
    (display-name [_] "track")
    om/IRender
    (render [this]
      (html [:li (str (:track track) " - " (:artist track))]))))


(defn playlist [data owner]
  (reify
    om/IDisplayName
    (display-name [_] "playlist")
    om/IRender
    (render [this]
      (html [:ul {:class-name "playlist"}
             (map (fn [track]
                    (om/build playlist-track track))
                    (:playlist data))]))))
(defn init []
  (om/root playlist initial-state
           {:target (. js/document (getElementById "container"))}))
