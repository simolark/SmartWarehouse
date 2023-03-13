<template>
  <el-carousel indicator-position="outside">
    <el-carousel-item>
      <h3> 一：上传训练集</h3>
    </el-carousel-item>
    <el-carousel-item>
      <h3> 二：上传测试集</h3>
    </el-carousel-item>
    <el-carousel-item>
      <h3> 三：在预测结果中查看历史数据</h3>
    </el-carousel-item>
    <el-carousel-item>
      <h3> 四：在留言版中讨论</h3>
    </el-carousel-item>
  </el-carousel>
</template>

<style>
  .el-carousel__item h3 {
    color: #475669;
    font-size: 30px;
    opacity: 0.75;
    line-height: 300px;
    margin-left:530px;
  }
  
  .el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
  }
  
  .el-carousel__item:nth-child(2n+1) {
    background-color: #d3dce6;
  }
</style>