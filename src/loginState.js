import Vue from 'vue'

var username = '111'
window.sessionStorage.setItem("username", username);
console.log(window.sessionStorage.getItem("username"));