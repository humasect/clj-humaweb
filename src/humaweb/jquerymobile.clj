(ns humaweb.jquerymobile
  (:use [noir.core :only [defpartial]]
        [hiccup.core :only [html]]
        [hiccup.page-helpers :only [include-css include-js html5
                                    unordered-list]]
        [humaweb.core]
        [humaweb.util :only [map2s]]))

;; (defpartial data-role [name & content]
;;   [:div {:data-role name}
;;    content])

;;;;;;;;;;;;

(defpartial navlink-to [route & content]
  ;;"Navigation link button for JQM"
  [:a {:href route}
   content])

(defpartial navlink-icon-to [route icon & content]
  ;;"Navigation Link button with a JQM icon"
  [:a {:href route :data-icon icon}
   content])

(defpartial selectmenu [name values]
  [:select {:id name
            :name name
            ;;:class "ui-box"
            ;;:data-icon "gear"
            :data-native-menu "false"
            :onchange (str "window.top.location.href = "
                           "this.options[this.selectedIndex].value")}
   (map2s 'humaweb.core/option values)
   ])

(defpartial jqm-page [route title &
                      {:keys [header footer js css navbar content]}]
  (html5
   [:head
    [:title title]
    [:meta {:name "viewport"
            :content (str "width=device-width, initial-scale=1, "
                          "maximum-scale=1, user-scalable=no")}]
    (map include-css
         (concat
          ["http://code.jquery.com/mobile/1.0/jquery.mobile-1.0.min.css"]
          css))
    (map include-js
         (concat
          ["http://code.jquery.com/jquery-1.6.4.min.js"
           "http://code.jquery.com/mobile/1.0/jquery.mobile-1.0.min.js"]
          js))
    ]
   
   [:body
    [:div {:data-role "page"}
     [:div {:data-role "header"}
      (navlink-icon-to '/ "home" "Home")
      header
      [:div {:data-role "navbar"}
       (unordered-list navbar)
       ]
      (navlink-icon-to 'contact-us "info" "Contact Us")]
     [:div {:data-role "content"} content]
     [:div {:data-role "footer"} footer]]]))
