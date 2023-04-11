<template>
    <div class="button-container">
      <!-- 创建一个按钮，点击时调用goToAnotherPage方法 -->
      <button class="blue-theme-button square-button" @click="goToAnotherPage">
        <font-awesome-icon :icon="['fas', 'arrow-right']" />
        <span class="button-text">入库</span>
      </button>
    </div>
  </template>
  
  <script>
  export default {
    methods: {
      // 定义一个方法用于跳转到另一个页面
      goToAnotherPage() {
        // 使用this.$router.push设置要跳转到的页面路由
        this.$router.push({ path: '/message' });
      }
    }
  }
  </script>
  
  <style scoped>
  .button-container {
    position: absolute;
    top: 50%;
    left: 20%;
    transform: translate(-50%, -50%);
    z-index: 2;
  }
  
  .blue-theme-button {
    background-color: #007bff;
    color: white;
    border: none;
    font-size: 24px;
    cursor: pointer;
    transition: background-color 0.2s ease-in-out;
    border-radius: 25px;
  }
  
  .blue-theme-button:hover {
    background-color: #0056b3;
  }
  
  .square-button {
    width: 100px;
    height: 100px;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
  }
  </style>
  