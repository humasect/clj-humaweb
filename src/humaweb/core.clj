(ns humaweb.core
  (:use [noir.core :only [defpartial]]
        [hiccup.core :only [html]]
        [hiccup.page-helpers :only [include-css include-js html5]]))

(defmacro defpartial- [fname params & body]
  ;;"Private version of defpartial"
  `(defn- ~fname ~params
     (html ~body)))

(defpartial link-to-nw [route & content]
  ;;"Link in new window"
  [:a {:href route :target "_blank"}
   content])

(defpartial image [name alt]
  ;;"Convenient <img> tag for static images under ./resources/"
  [:img {:src (str "/img/" name) :alt alt}])

(defpartial option [value & content]
  ;;"<option> tag"
  [:option {:value value}
   content])


