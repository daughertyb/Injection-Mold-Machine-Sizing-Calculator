<template>
  <div id="main">
    <header>
      <div>
        <br />
        <div>
          <h1>My Itinerary</h1>
          <!-- {{ this.selectedLandmark }} -->
          <br />
        </div>

        <p id="directions">Directions</p>
        <select
          id="directions-drop"
          v-model="selectedLandmark.name"
          v-on:change="googleRouteBuilderStart($event)"
        >
          <option :value="''" disabled selected>Starting Location</option>
          <option
            v-for="option in $store.state.selectedLandmarks"
            v-bind:key="option.id"
          >
            {{ option.name }}
          </option>
        </select>

        <button v-on:click="generateSteps">Generate Route</button>
      </div>
    </header>

    <table>
      <tr
        v-for="option in $store.state.selectedLandmarks"
        v-bind:key="option.id"
      >
        <h2>{{ option.startPoint }}</h2>

        <h2>{{ option.endPoint }}</h2>

        <img id="landmark-imgs" :src="option.images" />

        <h2>
          {{ option.name }}
          <h3 id="description">{{ option.description }}</h3>
        </h2>
        <br />

        <div>
          <input
            type="checkbox"
            v-on:change="
              selectLandmark(
                option.name,
                option.images,
                option.venueType,
                option.description,
                option.startPoint,
                option.endPoint,
                option.waypoints
              )
            "
            v-bind:id="option.id"
            v-bind:value="option.id"
          />Remove
        </div>
        <br />
      </tr>
    </table>
    <div>
    </div>
    <div id="map-layout">
      <ol id ="listframe">
<div id="myBox">
        <li id="direction" class="mapDirection">
        </li>
</div>
      </ol>
          <MapDirection></MapDirection>
    </div>
    <!-- <header>Header</header>
    <div id="main">
      <article>Article</article>
      <nav>Nav</nav>
      <aside>Aside</aside>
    </div>
    <footer>Footer</footer> -->
  </div>
</template>

<script>
import MapDirection from "./ItineraryDirections.vue";
import cityAPI from "@/services/APIServices.js";
export default {
  components: {
    MapDirection,
  },
  data() {
    return {
      waypoints: [],
      selectedLandmark: {
        name: "",
        images: "",
        venueType: "",
        description: "",
        startPoint: "",
        waypoints: "",
        endPoint: "",
      },
    };
  },

  methods: {
    generateSteps() {
      let routeQueryString = "";
      for (let i = 0; i < this.waypoints.length; i++) {
        routeQueryString =
          routeQueryString + "&routeQuery=" + this.waypoints[i].coordinate;
      }
      const dataStuff =
        "?waypointStartQuery=" +
        this.waypoints[0].coordinate +
        "&waypointEndQuery=" +
        this.waypoints[this.waypoints.length - 1].coordinate +
        routeQueryString;
      cityAPI.generateTravelRoute(dataStuff).then((response) => {
        const parentElement = document.getElementById("direction");
        for (let i = 0; i < response.data.length; i++) {
          const newElement = document.createElement("li");
          newElement.innerHTML = response.data[i];
          parentElement.appendChild(newElement);
        }
      });
    },
    selectLandmark(n, i, v, d, start, e, w) {
      this.selectedLandmark.name = n;
      this.selectedLandmark.images = i;
      this.selectedLandmark.venueType = v;
      this.selectedLandmark.description = d;
      this.selectedLandmark.startPoint = start;
      this.selectedLandmark.endPoint = e;
      this.selectedLandmark.waypoints = w;

      this.$store.commit("REMOVELANDMARK", this.selectedLandmark.name);
    },

    googleRouteBuilderStart(event) {
      let firstDestination = event.target.value;

      // make a copy of the store.state.selectedLandmarks array
      let landMarksArr = [];
      for (let i = 0; i < this.$store.state.selectedLandmarks.length; i++) {
        landMarksArr.push(this.$store.state.selectedLandmarks[i]);
      }

      let firstDestinationObj = {};
      let firstDestinationObjIndex = -123;

      for (let i = 0; i < landMarksArr.length; i++) {
        if (landMarksArr[i].name === firstDestination) {
          firstDestinationObj = landMarksArr[i];
          firstDestinationObjIndex = i;
        }
      }
      landMarksArr.splice(firstDestinationObjIndex, 1);
      landMarksArr.unshift(firstDestinationObj);

      console.log(landMarksArr);

      this.waypoints = landMarksArr;
    },

    getDirections() {
      // this.$store.commit('ADDSELECTEDLANDMARKS', this.selectedLandmarks);
      this.$router.push("/itinerary-directions");
      // drive
      // dont stop
      // just go
    },
  },
};
</script>
<style scoped>
#main {
  font-family: "Open Sans Condensed", sans-serif;
  background-color: rgba(82, 95, 138, 0.376);
}

/* html {
    background-color: rgba(82, 95, 138, 0.376);
} */

#venueType {
  font-weight: 500;
}

#description {
  font-weight: 500;
}

#directions {
  font-weight: 600;
  font-size: 1.5rem;
  padding-right: 10px;
}

#directions-drop {
  font-size: 1.3rem;
  background-color: rgba(94, 94, 179, 0.513);
}

#landmark-imgs {
  padding-bottom: 20px;
  height: 200px;
  width: 200px;
  border-radius: 20%;
  padding-top: 20px;
  padding-left: 10px;
  padding-right: 10px;
}

p {
  display: inline;
}

input[type="checkbox"] {
  -webkit-appearance: none;
  width: 30px;
  height: 30px;
  background: white;
  border-radius: 5px;
  border: 2px solid #555;
  margin-right: 20px;
  margin-top: 20px;
}

input[type="checkbox"]:checked {
  background: rgb(56, 96, 224);
}

tr {
  display: flex;
  justify-content: space-evenly;
  border: 3px solid black;
  border-radius: 10px;
  margin-top: 30px;
  background-color: rgba(192, 144, 11, 0.657);
}

.results {
  margin-top: 30px;
}

.mapDirection {
  display: flex;
  justify-content: center;
  border-radius: 15%;
}

table {
  display: grid;
}

#direction {
  display: block;
  margin-left: 50%;
  justify-content: right;
  flex-direction: column;
  border-radius: 15%;
  font-weight: 600;
  margin: 40px;

}

#map-layout {
  display:flex;
  flex-direction: row-reverse;
  align-items: center;
  justify-content:center;
  border: 20px #2B1F12;


}

#listframe {
  padding-top: 80px;
  padding-right: 5px;
}

#myBox {
   padding:5px;
   height:500px;
   width:500px;
   
   border:10px solid #4C433C;
   font:16px/26px Georgia, Garamond, Serif;
   overflow:scroll;
}

/* * {
  box-sizing: border-box;
}
body {
  display: flex;
  min-height: 100vh;
  flex-direction: column;
  margin: 0;
}

#directions{
font-size: 2rem;
}

#main {
  display: flex;
  flex: 1;
}
#main > article {
  flex: 1;
}
#main > nav,
#main > aside {
  flex: 0 0 20vw;
  background: beige;
}
#main > nav {
  order: -1;
}
header,
footer {
  background: yellowgreen;
  height: 20vh;
}
header,
footer,
article,
nav,
aside {
  padding: 1em;
} */
</style>