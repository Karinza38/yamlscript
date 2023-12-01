;; Copyright 2023 Ingy dot Net
;; This code is licensed under MIT license (See License for details)

;; This is the YAMLScript standard library.

(ns ys.std
  (:require
   [yamlscript.debug]
   [clojure.pprint :as pp]
   [clojure.string :as str])
  (:refer-clojure :exclude [print]))

(defn www [& xs]
  (apply yamlscript.debug/www xs))

(defn B [x] boolean x)

(defn F [x] (parse-double x))

(defn I [x] (parse-long x))

(defn M
  ([] {})
  ([x] (apply hash-map x))
  ([k v & xs] (apply hash-map k v xs)))

(defn S [& xs] (apply str xs))

(defn => [this] this)

(defn add [x & xs]
  (if (string? x)
    (apply str x xs)
    (apply + x xs)))

(defn err [& xs]
  (binding [*out* *err*]
    (apply clojure.core/print xs)
    (flush)))

(defn join [sep xs]
  (str/join sep xs))

(defn out [& xs]
  (apply clojure.core/print xs)
  (flush))

(defn pretty [o]
  (str/trim-newline
    (with-out-str
      (pp/pprint o))))

(defn print [o]
  (clojure.core/print o)
  (flush))

(defn rng [x y]
  (if (> y x)
    (range x (inc y))
    (range x (dec y) -1)))

(defn say [& xs]
  (apply clojure.core/println xs))

(defn times [x y]
  (if (and (string? x) (number? y))
    (apply str (repeat y x))
    (* x y)))

(defn warn [& xs]
  (binding [*out* *err*]
    (apply clojure.core/println xs)
    (flush)))

(comment)
