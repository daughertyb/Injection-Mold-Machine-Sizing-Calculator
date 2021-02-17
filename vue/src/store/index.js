import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    selectedLandmarks: []

    // Andy: Add an array that captures all the selected marks.
    // If you want to refer to this array outside of this file
    // you want to say: $store.state.selectedLandmarks.

  },

  mutations: {

    // Andy: You need a mutator to replace what's in the landmarks array
    // with what the caller of the mutator passes in.

    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    },
    ADDSELECTEDLANDMARKS(state, selectedLandmarks) {
      state.selectedLandmarks = [];
      state.selectedLandmarks = selectedLandmarks;
    }
    ,
    REMOVELANDMARK(state, name) {
      state.selectedLandmarks = state.selectedLandmarks.filter( (landmark) => landmark.name !== name );
    }
  }
})
