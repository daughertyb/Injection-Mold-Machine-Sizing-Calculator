<template>
  <div id="app">
    <h2 id="google-title">Google Direction</h2>

    <div id="map">
      <div id="toAndFrom">
        <div id="inputFrom">
          <div id="toFromLandmark">
            <h3>From: {{ this.$store.state.selectedLandmarks[0].name }}</h3>
            <h3>
              To:
              {{
                this.$store.state.selectedLandmarks[
                  this.$store.state.selectedLandmarks.length - 1
                ].name
              }}
            </h3>
          </div>

          <input
            v-show="this.hideInput == false"
            v-bind:from="originLandmark()"
            v-bind:mode="addWaypoint()"
            type="text"
          />
        </div>

        <div id="inputTo">
          <input
            v-show="this.hideInput == false"
            v-bind:to="destinationLandmark()"
            type="text"
          />
        </div>
        <div>
          <select v-model="directionMode" id="mode">
            <option value="driving">Driving</option>
            <option value="walking">Walking</option>
            <option value="bicycling">Bicycling</option>
          </select>
        </div>
      </div>

      <iframe
        width="700px"
        height="500px"
        v-bind:src="src()"
        allowfullscreen
      ></iframe>
    </div>
  </div>
</template>

<script>
export default {
  props: ["landmarkmap"],

  name: "MapDirection",
  data() {
    return {
      directionMode: "driving",
      hideInput: true,
      origin: "",
      originName: "",
      destination: "",
      destinationName: "",
      waypoints: "",

      url:
        "https://www.google.com/maps/embed/v1/directions?key=AIzaSyB5uhVBlG2NKfe8pT0rGiTpBkOr2JJjgLg",
    };
  },
  methods: {
    src: function () {
      return (
        this.url +
        "&origin=" +
        this.origin +
        "&destination=" +
        this.destination +
        "&mode=" +
        this.directionMode
      );
    },

    originLandmark() {
      this.origin = this.$store.state.selectedLandmarks[0].coordinate;
    },
    destinationLandmark() {
      this.destination = this.$store.state.selectedLandmarks[
        this.$store.state.selectedLandmarks.length - 1
      ].coordinate;
    },

    addWaypoint() {
      if (this.$store.state.selectedLandmarks.length > 2) {
        this.url = "https://www.google.com/maps/embed/v1/directions?key=AIzaSyB5uhVBlG2NKfe8pT0rGiTpBkOr2JJjgLg";
        this.url = this.url + "&waypoints=";
        for (
          let i = 1;
          i < this.$store.state.selectedLandmarks.length - 2;
          i++
        ) {
          this.url =
            this.url +
            (this.$store.state.selectedLandmarks[i].coordinate + "|");
        }
        this.url =
          this.url +
          this.$store.state.selectedLandmarks[
            this.$store.state.selectedLandmarks.length - 2
          ].coordinate;
      }
    },
  },
};
</script>
 

<style>
/* #app {
  display: block;
  justify-content: flex-start;
  margin: 40px;
} */

#map {
  display: flex;
  padding: 10px;
  justify-content: center;
  align-items: center;
  background-color: #aadaff;
  width: 900px;
  border: saddlebrown 20px;
}

#toAndFrom {
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: flex-start;
  width: 300px;
  padding: 10px;
}

#inputFrom {
  display: flex;
  font-weight: bold;
  padding: 10px;
}
#inputTo {
  display: flex;
  font-weight: bold;
  padding: 10px;
}
#mode {
  display: flex;
  font-size: 20px;
  font-weight: bold;
  padding: 10px;
  border: 5px solid #669df6;
  border-radius: 10px;
}

#toFromLandmark {
  color: #664243;
  font-size: 20px;
}
</style>