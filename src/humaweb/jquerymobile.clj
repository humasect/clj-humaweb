(ns humaweb.jquerymobile
  (:use [noir.core :only [defpartial]]
        [hiccup.core :only [html]]
        [hiccup.page-helpers :only [include-css include-js html5
                                    unordered-list]]
        [humaweb.core]))

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

(defpartial jqm-page [route title &
                      {:keys [header footer js css navlinks content]}]
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
       ;(unordered-list navlinks)
       ]
      (navlink-icon-to 'contact-us "info" "Contact Us")]
     [:div {:data-role "content"} content]
     [:div {:data-role "footer"} footer]]]))
