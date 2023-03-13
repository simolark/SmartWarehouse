<template>
  <div style="margin-top: 10px; margin-bottom: 80px">
    <el-card>
      <div style="padding: 20px; color: #888">
        <div>
          <el-input type="textarea" :rows="3" v-model="entity.content"></el-input>
          <div style="text-align: right; padding: 10px"><el-button type="primary" @click="save">留言</el-button></div>
        </div>
      </div>

      <div style="display: flex; padding: 20px" v-for="item in messages">
        <div style="text-align: center; flex: 1">
          <el-image :src="item.avatar" style="width: 60px; height: 60px; border-radius: 50%"></el-image>
        </div>
        <div style="padding: 0 10px; flex: 5">
          <div><b style="font-size: 14px">{{ item.username }}</b></div>
          <div style="padding: 10px 0; color: #888">
            {{ item.content }}
            <el-button type="text" size="mini" @click="del(item.id)" v-if="item.username === user.username">删除</el-button>
          </div>
          <div style="background-color: #eee; padding: 10px" v-if="item.parentMessage">{{ item.username }}：{{ item.parentMessage.content }}</div>
          <div style="color: #888; font-size: 12px">
            <span>{{ item.time  }}</span>
            <el-button type="text" style="margin-left: 20px" @click="reReply(item.id)">回复</el-button>
          </div>
        </div>
      </div>

      <el-dialog title="回复信息" v-model="dialogFormVisible" width="30%">
        <el-form :model="entity" label-width="80px">
          <el-form-item label="内容">
            <el-input v-model="entity.reply" autocomplete="off" type="textarea" :rows="3"></el-input>
          </el-form-item>
        </el-form>
        <template #footer>
          <el-button @click="cancel">取 消</el-button>
          <el-button type="primary" @click="reply">确 定</el-button>
        </template>
      </el-dialog>
    </el-card>


  </div>
</template>

<script>
import request from "@/utils/request";

export default {
  name: "Message",
  data() {
    return {
      user: {},
      messages: [],
      dialogFormVisible: false,
      isCollapse: false,
      entity: {}
    }
  },
  created() {
    this.user = sessionStorage.getItem("user") ? JSON.parse(sessionStorage.getItem("user")) : {};
    this.loadMessage();


  },
  methods: {
    loadMessage() {
      // 如果是留言的话，就写死=0
      // 如果是 评论，则需要设置 当前被评论的模块的id作为foreignId
      let foreignId = 0;
      request.get("/message/foreign/" + foreignId).then(res => {
        this.messages = res.data;
      })
    },
    cancel() {
      this.dialogFormVisible = false;
      this.entity = {};
    },
    reReply(id) {
      this.dialogFormVisible = true;
      this.entity.parentId = id;
    },
    reply() {
      this.entity.content = this.entity.reply;
      this.save();
    },

    save() {
      if (!this.user.username) {
        this.$message({
          message: "请登录",
          type: "warning"
        });
        return;
      }
      if (!this.entity.content) {
        this.$message({
          message: "请填写内容",
          type: "warning"
        });
        return;
      }
      // 如果是评论的话，在 save的时候要注意设置 当前模块的id为 foreignId。也就是  entity.foreignId = 模块id
      request.post("/message", this.entity).then(res => {
        if (res.code === '0') {
          this.$message({
            message: "评论成功",
            type: "success"
          });
        } else {
          this.$message({
            message: res.msg,
            type: "error"
          });
        }
        this.entity = {}
        this.loadMessage();
        this.dialogFormVisible = false;
      })
    },
    del(id) {
      request.delete("/message/" + id).then(res => {
        this.$message({
          message: "删除成功",
          type: "success"
        });
        this.loadMessage()
      })
    }
  }
}
</script>
