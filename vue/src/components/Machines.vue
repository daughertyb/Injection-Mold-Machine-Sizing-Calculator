<template>

  <div id="table">
     <br>
  <table-component
     :data="machines"
     sort-by="machineId"
     sort-order="asc"
     >
     <table-column show="machineId" label="Machine ID" data-type="numeric"></table-column>
     <table-column show="brand" label="Brand" data-type="numeric"></table-column>
     <table-column show="model" label="Model"></table-column>
     <table-column show="tonnage" label="Tonnage" data-type="numeric"></table-column>
     <table-column show="tieBarHorizontal" label="Tie Bar Horizontal" data-type="numeric"></table-column>
     <table-column show="tieBarVertical" label="Tie Bar Verticle" data-type="numeric"></table-column>
     <table-column show="plattenHorizontal" label="Platten Horizontal" data-type="numeric"></table-column>
     <table-column show="plattenVertical" label="Platten Vertical" data-type="numeric"></table-column>
     <table-column show="moldHeightMin" label="Mold Height Minimum" data-type="numeric"></table-column>
     <table-column show="moldHeightMax" label="Mold Height Maximum" data-type="numeric"></table-column>
     <table-column show="shotSizePe" label="Shot Size PE" data-type="numeric"></table-column>
     <table-column show="shotSizePs" label="Shot Size PS" data-type="numeric"></table-column>
     <table-column show="dateAdded" label="Date Added" :filterable="false" data-type="date:DD/MM/YYYY"></table-column>

 </table-component>
    </div>
</template>

<script>
import machineAPI from "@/services/APIServices.js";




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

.table {
    border-bottom: 20px;
}
</style>