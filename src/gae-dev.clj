(in-ns 'user)
(clojure.core/use 'clojure.core)
(require '[appengine-magic.core :as ae])

;;(def dev-handler (noir.server/gen-handler {:mode :dev :ns 'hoovyweb}))
(ae/def-appengine-app dev-app #(noir.server/gae-handler {:mode :dev
                                                         :ns 'dev-app}))
(ae/serve dev-app)
