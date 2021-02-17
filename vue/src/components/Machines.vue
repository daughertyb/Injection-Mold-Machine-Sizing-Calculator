<template>
  <div>
  {{machines}}
    </div>
</template>

<script>
import machineAPI from "@/services/APIServices.js";


<table id="app" class="display table" width="100%">
  <tbody>
    <tr v-for="machine in machines" v-bind:key="machine.id">
      <td> {{ machine }}</td>
    </tr>
  </tbody>
</table>

export default {
    data() {
    return {
      machines: []
    };
    },

created() {
      machineAPI
      .allMachines()
      .then((response) => {
        this.machines = response.data;
      })
      .catch((error) => {
        if (error.response) {
          ("Ope, Not Available Option :O");
        }
      });

   
  },
  };



</script>

<style>

</style>