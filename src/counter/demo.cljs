(ns counter.demo
  (:require [clojure.browser.repl :as repl]))

(repl/connect "http://localhost:9000/repl")

(comment
  (js/alert "Hello World")

  (defn get-count [callback]
    (callback "9521"))

  (get-count js/alert)
  
  (defn build-counter [count]
    (map
     (fn [number]
       (str "<span class=\"number" number "\">" number "</span>"))
     count))

  (build-counter "9521")
  
  (defn show [html]
    (.html (js/$ "#counter") (apply str html)))

  (defn demo1 []
    (get-count #(show (build-counter %))))
  
  (defn prepare-count [count digits]
    (apply str (reverse (take digits (concat (reverse count) (repeat "0"))))))

  (prepare-count "9521" 7)
  
  (defn demo2 []
    (get-count #(show (build-counter (prepare-count % 7)))))

  (ns cljs.user
    (:require [hiccups.runtime :as h]))
  
  (defn build-counter2 [count]
    (map (fn [n] [:span {:class (str "number" n)} n]) count))

  (build-counter "9521")

  (defn get-count [callback]
    (callback "11414"))
  
  (defn demo3 []
    (get-count #(show (h/render-html (build-counter2 (prepare-count % 7))))))
  )
