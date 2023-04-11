<template>
    <div class="grid-box">
      <div v-for="(dot, index) in dots" :key="index" :class="[dot.isActive ? 'active' : '', 'dot']"></div>
    </div>
  </template>
  
  <script>
  export default {
    props: {
      activeCount: {
        type: Number,
        required: true,
      },
    },
    data() {
      return {
        dots: Array(50).fill().map((_, index) => ({
          isActive: index < this.activeCount,
        })),
      };
    },
    watch: {
      activeCount(newVal) {
        this.dots.forEach((dot, index) => {
          dot.isActive = index < newVal;
        });
      },
    },
  };
  </script>
  
  <style scoped>
  .grid-box {
    display: flex;
    flex-wrap: wrap;
    width: 100px;
    height: 100px;
    border: 1px solid #ccc;
    margin: 5px;
  }
  
  .dot {
    width: 10px;
    height: 10px;
    background-color: blue;
    margin: 1px;
  }
  
  .active {
    background-color: red;
  }
  </style>
  