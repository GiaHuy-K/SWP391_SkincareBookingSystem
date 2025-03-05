// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
import { getAnalytics } from "firebase/analytics";
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
const firebaseConfig = {
  apiKey: "AIzaSyDYHLgUrLk6eCIp9CRWTIANtNAHdFcj2Rw",
  authDomain: "skincarebookingsystem-c4232.firebaseapp.com",
  projectId: "skincarebookingsystem-c4232",
  storageBucket: "skincarebookingsystem-c4232.firebasestorage.app",
  messagingSenderId: "858067499312",
  appId: "1:858067499312:web:0faad2295437b8f1c5f0f5",
  measurementId: "G-FFRJYWSHK5"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
const analytics = getAnalytics(app);