(ns humaweb.social
  (:use [hiccup.page-helpers :only [javascript-tag]]
        [noir.core :only [defpartial]]))

(defpartial social-head []
  (facebook-head)
  (google-head)
  (twitter-head))

(defpartial social-buttons []
  [:table
   [:tr
    [:td (twitter-buttons)]
    [:td (facebook-buttons)]
    [:td (google-buttons)]]])

(defn- social-link [name alt]
  (link-to-nw (str "http://www." name ".com/humasect")
              (image (str name ".png") alt)))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defpartial facebook-head []
  (javascript-tag "(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = '//connect.facebook.net/en_US/all.js#xfbml=1&appId=266792696721807';
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));"))

(defpartial facebook-buttons []
  [:div.fb-like {:data-send "true"
                 :data-width "100%"
                 :data-show-faces "true"}])

(defpartial google-head []
  (javascript-tag "(function() {
    var po = document.createElement('script'); po.type = 'text/javascript'; po.async = true;
    po.src = 'https://apis.google.com/js/plusone.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(po, s);
  })();"))

(defpartial google-buttons []
  [:div.g-plusone {:data-annotation "inline"}])

(defpartial twitter-head []
  (javascript-tag "!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0];if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src='//platform.twitter.com/widgets.js';fjs.parentNode.insertBefore(js,fjs);}}(document,'script','twitter-wjs');"))

(defpartial twitter-buttons []
  [:a.twitter-share-button {:href "https://twitter.com/share"
                            :data-via "twitterapi"
                            :data-lang "en"} "Tweet"])

(defpartial twitterfeed-head []
  (javascript-tag "$('#twitter-feed').jTweetsAnywhere({
        username: $('#twitter-feed').attr('username'),
        count: 3,
        showTweetFeed: {
            showProfileImages: true,
            showUserScreenNames: true,
            showUserFullNames: true,
            showActionReply: true,
            showActionRetweet: true,
            showActionFavorite: true
        },
        showTweetBox: {
            label: '<span style=\'color: #303030\'>Spread the word ...</span>'
        }
    });"))

(defpartial twitterfeed-view [username]
  [:div#twitter-feed {:username username}])