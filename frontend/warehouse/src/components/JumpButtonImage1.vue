<template>
    <div class="button-container">
      <button class="blue-theme-button" @click="goToAnotherPage">
        <img
          src="@/assets/1.png"
          alt="Example Image"
          class="button-image"
          @load="onImageLoad"
        />
      </button>
    </div>
  </template>
  

<!-- <script>
export default {
  methods: {
    // 定义一个方法用于跳转到另一个页面
    goToAnotherPage() {
      // 使用this.$router.push设置要跳转到的页面路由
      this.$router.push({ path: '/message' });
    }
  }
}
</script> -->
  
<script>
export default {
  methods: {
    goToAnotherPage() {
      // 使用this.$router.push设置要跳转到的页面路由
      this.$router.push({ path: '/category' });
    },
    onImageLoad(event) {
      const img = event.target;
      const button = img.parentElement;
      button.style.width = img.naturalWidth + 'px';
      button.style.height = img.naturalHeight + 'px';
    },
  },
};
</script>


<style scoped>
.button-container {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
}

.blue-theme-button {
  background-color: #007bff;
  color: white;
  border: none;
  font-size: 14px;
  cursor: pointer;
  transition: background-color 0.2s ease-in-out;
  padding: 0; /* 移除按钮的内边距 */
  transform: scale(2); /* 设置缩放比例，您可以根据需要调整此值 */
}

.blue-theme-button:hover {
  background-color: #030f1d2b;
}

.button-image {
  width: 100%;
  height: 100%;
  display: block; /* 移除图片周围的空白 */
}
</style>

