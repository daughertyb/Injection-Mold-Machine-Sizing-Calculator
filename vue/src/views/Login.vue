<template>
<div id="body">
  <div id="login" class="text-center">
    <form class="form-signin" @submit.prevent="login">
      <h1>The Layover</h1>
      <h3 class="tag">Explore Our List of Must-See Sights for Your Next Layover City!</h3>
      <h4 class="h3 mb-3 font-weight-normal">Please Sign In</h4>
      <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
      >Invalid username and password!</div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >Thank you for registering, please sign in.</div>
      <label for="username" class="sr-only">Username </label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <br>
      <label for="password" class="sr-only">Password </label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <br>
      <button type="submit">Sign in</button>
      <br>
      <br>
      <router-link :to="{ name: 'register' }">Need an account?</router-link>
    </form>
  </div>
 <img id="headerImg" src="../assets/home.jpg" alt="logo" />
</div>
</template>










<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>
<style scoped>

#tag {
  margin-left: auto;
  margin-right: auto;
  margin-top: 3px;
  margin-bottom: 3px;
  text-align: left;
  display: flex;
  justify-content: center;
}

#headerImg {
  display: flex;
  justify-content: stretch;
  margin: 0 auto;
  height: 500px;
  width: 100%;
  padding-bottom: 40px;
  font-family: "Open Sans Condensed", sans-serif;
 
}

form {
  text-align: center;
  display: block;
  font-size: 1.5rem;
  padding-bottom: 10px;
  font-family: "Open Sans Condensed", sans-serif;
}


#body {
 background-color: rgba(59, 68, 100, 0.616);
 font-family: "Open Sans Condensed", sans-serif;
}

</style>