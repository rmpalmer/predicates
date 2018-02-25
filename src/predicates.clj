(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(sum-f (fn [arg] (* 2 arg))
       (fn [arg] (* 3 arg)) 4)

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or  (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (if (nil? string) true
      (every? whitespace? string)))

(defn has-award? [book award]
  (let [awards (:awards book)]
    (contains? awards award)))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [a] (contains? (:awards book) a)) awards))

(defn my-some [pred a-seq]
  (first (map pred (filter pred a-seq))))

(def stuff [1 3 5 7 11])

(my-some odd? stuff)

(defn my-every? [pred a-seq]
  (= (filter pred a-seq) a-seq))

(defn prime? [n]
  (let [divides? (fn [x] (integer? (/ n x)))]
    (not (some divides? (range 2 (+ 1 (/ n 2)))))))

(prime? 132)
;^^
