(ns giggin.firebase.init
  (:require ["firebase/app" :as firebase]
            ["firebase/database"]
            ["firebase/auth"]))

(defn firebase-init
  []
  (firebase/initializeApp
    {:apiKey "AIzaSyCPdkc3Zi4AoWpnnB-5cRBBvyn555geRJg"
     :authDomain "giggin-f9dd5.firebaseapp.com"
     :databaseURL "https://giggin-f9dd5.firebaseio.com"
     :projectId "giggin-f9dd5"
     :appId "1:202378429919:web:6d185c8f776721041bb06a"}))
  ;))
