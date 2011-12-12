#!/bin/sh
git clone https://github.com/clojure/clojurescript.git
cd clojurescript
script/bootstrap
wget -O lib/hiccups-0.1.1.jar http://clojars.org/repo/hiccups/hiccups/0.1.1/hiccups-0.1.1.jar
