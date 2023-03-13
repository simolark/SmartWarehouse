<template>
  <div class="app-container">
    <upload-excel-component :on-success="handleSuccess" :before-upload="beforeUpload" />
    <el-table :data="tableData" border highlight-current-row style="width: 100%;margin-top:20px;">
      <el-table-column v-for="item of tableHeader" :key="item" :prop="item" :label="item" />
    </el-table>
    
    <h3 style="margin-left:805px;">点此上传训练集</h3>
  <el-upload action="http://localhost:9090/files/upload/KNNtrain" :on-success="filesUploadSuccess">

    <el-button style="margin-left:820px;" size="small" type="primary" autofocus="true">上传训练集</el-button>
    
  </el-upload>
  <h3 style="margin-left:805px;">点此上传测试集</h3>

  <el-upload action="http://localhost:9090/files/upload/KNNtest" :on-success="filesUploadSuccess">

<el-button style="margin-left:820px;" size="small" type="primary">上传测试集</el-button>

</el-upload>

  </div>
</template>

<script>
import UploadExcelComponent from '@/components/UploadExcel/index.vue'

export default {
  name: 'UploadExcel',
  components: { UploadExcelComponent },
  data() {
    return {
      tableData: [],
      tableHeader: [] 
    }
  },
  methods: {
    filesUploadSuccess(res){
       console.log(res)
    },
    // 文件上传
    beforeUpload(file) {
      const isLt1M = file.size / 1024 / 1024 < 1

      if (isLt1M) {
        return true
      }

      this.$message({
        message: 'Please do not upload files larger than 1m in size.',
        type: 'warning'
      })
      return false
    },
    handleSuccess({ results, header }) {
      this.tableData = results
      this.tableHeader = header
    }
  }
}
</script>
