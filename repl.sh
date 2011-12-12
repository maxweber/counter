#!/bin/sh

cd clojurescript

CLJSC_CP=''
for next in lib/*: src/clj: src/cljs: test/cljs; do
  CLJSC_CP=$CLJSC_CP$next
done

java -server -cp $CLJSC_CP clojure.main -e "(use 'cljs.closure) (def opts {:output-to \"../main.js\" :output-dir \"../out\"}) (build \"../src\" opts) (require '[cljs.repl :as repl]) (require '[cljs.repl.browser :as browser]) (def env (browser/repl-env)) (println \"open index.html in your browser\") (repl/repl env)"
