<template>
    <div>
      <div v-for="(button, index) in buttonLinks" :key="index">
        <button
          class="blue-theme-button"
          :style="{
            top: buttonPositions[index].top + 'px',
            left: buttonPositions[index].left + 'px',
          }"
          @click="$router.push(button.link)"
        >
          <img :src="button.image" alt="Button Image" class="button-image" />
        </button>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    props: {
      buttonLinks: {
        type: Array,
        required: true,
      },
      buttonPositions: {
        type: Array,
        required: true,
      },
    },
  };
  </script>
  
  <style scoped>
  .blue-theme-button {
    position: absolute;
    background-color: #007bff;
    color: white;
    border: none;
    font-size: 14px;
    cursor: pointer;
    transition: background-color 0.2s ease-in-out;
    padding: 0;
    transform: scale(0.9);
  }
  
  .blue-theme-button:hover {
    background-color: #0056b3;
  }
  
  .button-image {
    width: 100%;
    height: 100%;
    display: block;
  }
  </style>
  