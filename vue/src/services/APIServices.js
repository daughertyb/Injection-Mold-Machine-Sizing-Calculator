import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:8080"
  });


  export default { 
    
     allMachines(){ 
        return http.get('/machines');   
      },

      getLandmarkByCity(cityName){ 
        return http.get(`/landmarks-city/${cityName}`);   
      },

      getAllLandmarks() {
        return http.get('/get-all-landmarks')
      },

      
    
    
  }