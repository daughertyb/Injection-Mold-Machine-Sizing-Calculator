<template>
  <div id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'allCities' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'machines' }">Machines</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'itinerary' }">My Itinerary</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link> 
      
    </div>
    <router-view />
  </div>
</template>
<style scoped>

#nav {
  font-family: "Open Sans Condensed", sans-serif;
  font-weight: 1000;
}

</style>