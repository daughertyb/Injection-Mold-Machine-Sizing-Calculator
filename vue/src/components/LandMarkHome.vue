<template>
  <div class="mainPage">

      <div>
  
      <header id="title">
        <H1>Select a City and Venue Type to Explore</H1>
      </header>
     
        
      <div class="box-1">
        <div class="btn btn-one">
       <div class="btn btn-one" v-on:click="addToItinerary" router-link="Itinerary">
           <span>Create an Itinerary</span>
         </div>
       </div>
       </div>
      </div>

      <section >
        <select id="all-Cities" v-model="filter.city">
          <option :value="''" disabled selected>All Cities</option>
          <option v-for="city in cities" v-bind:key="city.id">
            {{ city }}
          </option>
        </select>

        <select id="all-Venues" v-model="filter.venueType">
          <option :value="''" disabled selected>All Venues</option>
          <option
            v-for="venueType in filteredLandmarks"
            v-bind:key="venueType.id"
          >
            {{ venueType.venueType }}
          </option>
        </select>
      </section>
      <table>
        <tr></tr>

        <tr v-for="option in filteredLandmarks" v-bind:key="option.id">
          <div class="results">
            <h2>{{ option.cityValue }}</h2>
          <div id="card-img">
            <img id="landmark-imgs" :src="option.images" />
            <h2>{{ option.name }}
            <h3 id="description">{{ option.description }}</h3>
            </h2>
          </div>
          
          <section id="venue-days-time">
            <div id="venueType">
              {{ option.venueType }}
            </div>
            <br />
            <div id="operatingDays">
              {{ option.operatingDays }}
            </div>
            <br />
            <div id="openingTime-closingTime">
              {{ option.openingTime }}
              <br />
              {{ option.closingTime }}
            </div>
          </section>
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
                    
                  )
                "
                v-bind:id="option.id"
                v-bind:value="option.id"
              />  Add To Itinerary
            </div>
              <br>
          </div>
        </tr>
        <footer>
     </footer>
      </table>
     
    </div>
 
</template>

<script>
import cityAPI from "@/services/APIServices.js";

export default {
   data() {
    return {
      cities: [],
      cityValue: "",
      allLandmarks: [],
      landmarkPosition: [],
      selectedLandmarks: [],
      landmarkByCity: {
        images: "",
        name: "",
        description: "",
        venueType: "",
        operatingDays: "",
        openingTime: "",
        closingTime: "",
        isChecked: false,
      },

      filter: {
        city: "",
        venueType: "",
        operatingDays: "",
        openingTime: "",
        closingTime: "",
      },
      selectedLandmark: {
        name: "",
        images: "",
        venueType: "",
        description: "",
      },
    };
  },
  created() {
    cityAPI
      .allCities()
      .then((response) => {
        this.cities = response.data;
      })
      .catch((error) => {
        if (error.response) {
          ("Ope, Not Available Option :O");
        }
      });

    // 1. Load up all the data we need
    cityAPI.getAllLandmarks().then((response) => {
      this.allLandmarks = response.data;
    });
  },
  methods: {

  addToItinerary() {

    // pass the this.selectedLandmarks array to the mutator.
    this.$store.commit('ADDSELECTEDLANDMARKS', this.selectedLandmarks);
    this.$router.push('/itinerary');
    
  },
    venueTypeFilter: function (val) {
      if (this.allVenueTypes.indexOf(val.id) === -1) {
        //arr.push(val.id);
        return val.id;
      }
    },

    selectLandmark(n, i, v, d, c) {
      this.selectedLandmark.name = n;
      this.selectedLandmark.images = i;
      this.selectedLandmark.venueType = v;
      this.selectedLandmark.description = d;
      this.selectedLandmark.coordinates = c;

        let found = false;
        let indexFound = -123;

        for (let i = 0; i < this.selectedLandmarks.length; i++) {

          if (this.selectedLandmarks[i].name === this.selectedLandmark.name) {
            found = true;
            indexFound = i;
          }
        }

        if (found) {
          this.selectedLandmarks.splice(indexFound, 1);
        } else {

          let newLandMark = {
            name : this.selectedLandmark.name,
            images : this.selectedLandmark.images,
            venueType : this.selectedLandmark.venueType,
            description: this.selectedLandmark.description,
            coordinate: this.selectedLandmark.coordinates
          }

          this.selectedLandmarks.push(newLandMark);
        }
    },
  },



  computed: {
    filteredLandmarks() {
      let filteredVenues = this.allLandmarks;
      if (this.filter.city != "") {
        filteredVenues = filteredVenues.filter((option) =>
          option.location.includes(this.filter.city)
        );
      }

      if (this.filter.venueType != "") {
        filteredVenues = filteredVenues.filter((option) =>
          option.venueType.includes(this.filter.venueType)
        );
      }
      return filteredVenues;
    },
  },
};
</script>


<style scoped>
@import "https://fonts.googleapis.com/css?family=Open+Sans+Condensed:300";

/* html,
/* body {
  width: 100%;
  height: 100%;
  overflow: hidden;
  margin: 0;
  display: flex;
  flex-direction: column;
  flex-wrap: wrap;
  font-family: "Open Sans Condensed", sans-serif;
} */ 

div[class*="box"] {
  height: 33.33%;
  width: 100%;
  display: flex;
  justify-content: center;
  align-items: right;
}

#card-img {
  display: flex;
  justify-content: space-between;
}

#venue-days-time {
  font-size: 1.3rem;
  font-weight: 600;
}

/* Top one makes whole color of button */
/* .box-1 {
  background-color: #4063a581;
} */


.btn {
  line-height: 50px;
  height: 50px;
  text-align: center;
  width: 250px;
  cursor: pointer;
  
}

tr {
  margin-left: 15px;
  margin-right: 15px;
}

.btn-one {
  /* Button text color */
  background-color: #4063a581;
  color: rgb(0, 0, 0);  
  transition: all 0.3s;
  position: relative;
  font-size: 1.4rem;
  font-weight: 600;
  /* border-radius: 25px; */
  
}
.btn-one span {
  transition: all 0.3s;
}
.btn-one::before {
  content: "";
  position: absolute;
  bottom: 0;
  left: 0;
  width: 100%;
  height: 100%;
  z-index: 1;
  opacity: 0;
  transition: all 0.3s;
  border-top-width: 1px;
  border-bottom-width: 1px;
  border-top-style: solid;
  border-bottom-style: solid;
  border-top-color: rgba(255, 255, 255, 0.5);
  border-bottom-color: rgba(255, 255, 255, 0.5);
  transform: scale(0.1, 1);
}
.btn-one:hover span {
  letter-spacing: 3px;
  
}
.btn-one:hover::before {
  opacity: 1;
  transform: scale(1, 1);
}
.btn-one::after {
  content: "";
  position: absolute;
  bottom: 0;
  left: 0;
  width: 100%;
  height: 100%;
  z-index: 1;
  transition: all 0.3s;
  background-color: rgba(255, 255, 255, 0.1);
}
.btn-one:hover::after {
  opacity: 0;
  transform: scale(0.1, 1);
}

/* ---------------------------------------------------------------------------------------------------------------------------- */

h1 {
  font-size: 1.7rem;
  display: flex;
  justify-content: center;
  padding-bottom: 10px;
  padding-top: 10px;
}

.mainPage {
    background-color: rgba(59, 68, 100, 0.616);
}

#venueType {
  font-weight: 500;
  
}

h2 {
 
}

#description {
  font-weight: 500;
}

#directions {
  font-weight: 600;
  font-size: 1.5rem;
  padding-right: 10px;
}

#all-Cities {
  font-size: 1.3rem;
  background-color: rgba(200, 199, 196, 0.452);
  margin-left: 42%;
}

#all-Venues {
    font-size: 1.3rem;
    background-color: rgba(200, 199, 196, 0.452);
    margin-left: 15px;
    margin-top: 20px;
}

#landmark-imgs {
  padding-bottom: 20px;
  height: 200px;
  width: 200px;
  border-radius: 20%;
  padding-top: 20px;
  padding-left: 10px;
  padding-right: 10px;
  /* border: 3px solid black; */
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
  padding-left: 20px;
}

.mapDirection {
  display: flex;
  justify-content: center;
  border-radius: 15%;
}

table {
  display: grid;
}


</style>