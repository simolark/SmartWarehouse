<template>
  <div class="container">
    <div class="grid">
      <GridBox v-for="(count, index) in activeCounts" :key="index" :activeCount="count" />
    </div>
  </div>
</template>

<script>
import GridBox from '@/components/GridBox.vue';

export default {
  components: {
    GridBox,
  },
  data() {
    return {
      activeCounts: Array(20).fill(0), // 初始时，每个框的激活点数都设置为零
    };
  },
  methods: {
    async fetchData() {
      // 使用fetch或axios从后端获取数据
      // 假设您获取到了一个包含20个数字的数组，分别表示每个框的激活点数
      // const responseData = await fetch('your-backend-url-here');
      // const data = await responseData.json();

      // 更新activeCounts数组
      this.activeCounts = this.generateMockData();
    },
    generateMockData() {
      return Array.from({ length: 20 }, () => Math.floor(Math.random() * 51));
    },
    
  },
  created() {
    this.fetchData();
  },
};
</script>

<style scoped>
.container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
}

.grid {
  display: grid;
  grid-template-columns: repeat(5, 1fr);
  grid-template-rows: repeat(4, 1fr);
  grid-gap: 10px;
}
</style>
