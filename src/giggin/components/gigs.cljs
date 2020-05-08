(ns giggin.components.gigs
  (:require [giggin.state :as state]
            [giggin.helpers :refer [format-price]]
            [reagent.core :as r]
            [giggin.components.gig-editor :refer [gig-editor]]))

(defn gigs
  []
 (let [add-to-order #(swap! state/orders update % inc)
       modal (r/atom false)
       values (r/atom {:id nil :title "" :desc "" :price 0 :img "" :sold-out false})]
  (fn
   []
   [:main
    [:div.gigs
     [:button.add-gig {:on-click #(reset! modal true)}
      [:div.add__title
       [:i.icon.icon--plus]
       [:p "Add gig"]]]
     [gig-editor modal values]
     (for [{:keys [id img title price desc]} (vals @state/gigs)]
       [:div.gig {:key id}
        [:img.gig__artwork {:src img :alt title}]
        [:div.gig__body
         [:div.gig__title
          [:div.btn.btn--primary.float--right.tooltip
           {:data-tooltip "Add to order"
            :on-click #(add-to-order id)}
           [:i.icon.icon--plus]] title]
         [:p.gig__price (format-price price)]
         [:p.gig__desc desc]]])]])))

; (defn gigs
;   []
;   [:main
;    [:div.gigs (map (fn [gig]
;                      [:div.gig {:key (:id gig)}
;                       [:img.gig__artwork {:src (get gig :img) :alt (:title gig)}]
;                       [:div.gig__body
;                        [:div.gig__title
;                         [:div.btn.btn--primary.float--right.tooltip {:data-tooltip "Add to order"}
;                          [:i.icon.icon--plus]] (:title gig)]
;                        [:p.gig__price (:price gig)]
;                        [:p.gig__desc (:desc gig)]]]) (vals @state/gigs))]])
