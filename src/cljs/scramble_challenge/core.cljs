(ns scramble-challenge.core)

(def str1 (r/atom ""))
(def str2 (r/atom ""))

(defn form []
  [:div
   [:input {:type "text"
            :value @str1
            :on-change #(reset! str1 (.-value (.-target %)))}]
   [:input {:type "text"
            :value @str2
            :on-change #(reset! str2 (.-value (.-target %)))}]])

(defn ^:dev/after-load mount-components []
  (let [content (js/document.getElementById "app")]
    (while (.hasChildNodes content)
      (.removeChild content (.-lastChild content)))
    (.appendChild content (js/document.createTextNode "Scramble Challenge"))
    (.appendChild content (js/document.createTextNode (form)))))

(defn init! []
  (mount-components))
