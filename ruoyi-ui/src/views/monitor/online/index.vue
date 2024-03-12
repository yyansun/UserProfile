<template>
  <div class="app-container" style="margin-left: 30px; margin-right: 50px">
    <div class="container">
      <div class="left-area">
        <!-- 左侧区域的内容 -->
        <span v-html="'性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别&nbsp;&nbsp;&nbsp;'" class="custom-text"></span>
        <el-button @click="fetchData" type="primary">男</el-button>
        <el-button @click="handleCilck" type="primary">女</el-button>
      </div>
      <div class="right-area">
        <span v-html="'年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄&nbsp;&nbsp;&nbsp;'" class="custom-text"></span>
        <el-button @click="handleCilck" type="primary">70后</el-button>
        <el-button @click="handleCilck" type="primary">80后</el-button>
        <el-button @click="handleCilck" type="primary">90后</el-button>
        <el-button @click="handleCilck" type="primary">00后</el-button>
        <el-button @click="handleCilck" type="primary">10后</el-button>
        <el-button @click="handleCilck" type="primary">20后</el-button>
      </div>
    </div>
    <br>
    <div class="container">
      <div class="left-area">
        <span v-html="'婚姻状况&nbsp;&nbsp;&nbsp;'" class="custom-text"></span>
        <el-button @click="handleCilck" type="primary">未婚</el-button>
        <el-button @click="handleCilck" type="primary">已婚</el-button>
        <el-button @click="handleCilck" type="primary">离异</el-button>
      </div>
      <div class="right-area">
        <span v-html="'职&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;业&nbsp;&nbsp;&nbsp;'" class="custom-text"></span>
        <el-button @click="handleCilck" type="primary">学生</el-button>
        <el-button @click="handleCilck" type="primary">公务员</el-button>
        <el-button @click="handleCilck" type="primary">军人</el-button>
        <el-button @click="handleCilck" type="primary">警察</el-button>
        <el-button @click="handleCilck" type="primary">教师</el-button>
        <el-button @click="handleCilck" type="primary">白领</el-button>
      </div>
    </div>
    <br>
    <div class="container">
      <div class="left-area">
        <span v-html="'政治面貌&nbsp;&nbsp;&nbsp;'" class="custom-text"></span>
        <el-button @click="handleCilck" type="primary">党员</el-button>
        <el-button @click="handleCilck" type="primary">群众</el-button>
        <el-button @click="handleCilck" type="primary">无党派人士</el-button>
      </div>
      <div class="right-area">
        <span v-html="'所属地区&nbsp;&nbsp;&nbsp;'" class="custom-text"></span>
        <el-button @click="handleCilck" type="primary">中国大陆</el-button>
        <el-button @click="handleCilck" type="primary">中国香港</el-button>
        <el-button @click="handleCilck" type="primary">中国澳门</el-button>
        <el-button @click="handleCilck" type="primary">中国台湾</el-button>
      </div>
    </div>
    <br>
    <div class="container-below">
      <div class="left-table">
    <el-table
      v-loading="loading"
      :data="list.slice((pageNum-1)*pageSize,pageNum*pageSize)"
      style="width: 100%;"
    >
      <el-table-column label="序号" type="index" align="center">
        <template slot-scope="scope">
          <span>{{(pageNum - 1) * pageSize + scope.$index + 1}}</span>
        </template>
      </el-table-column>
      <el-table-column label="用户名称" align="center" prop="userName" :show-overflow-tooltip="true" />
      <el-table-column label="性别" align="center" prop="gender" :show-overflow-tooltip="true" />
      <el-table-column label="生日" align="center" prop="birthday" />
      <el-table-column label="手机号码" align="center" prop="telephone" />
      <el-table-column label="职业" align="center" prop="job" />
      <el-table-column label="政治面貌" align="center" prop="politicalFace" :show-overflow-tooltip="true" />
      <el-table-column label="所属地区" align="center" prop="region" :show-overflow-tooltip="true" />
      <el-table-column label="婚姻状况" align="center" prop="marriage" />
    </el-table>
        <pagination v-show="total>0" :total="total" :page.sync="pageNum" :limit.sync="pageSize" />
      </div>
      <div class="right-pic">
        一个饼图
      </div>
    </div>
    </div>
</template>

<style>
.container {
  display: flex;
}

.left-area {
  flex: 3; /* 左侧区域占据可用空间的40% */
}

.right-area {
  flex: 7; /* 右侧区域占据可用空间的60% */
}

.custom-text {
  font-size: 16px;
  font-family: "Microsoft YaHei";
}

.el-button--primary {
  background-color: rgb(232, 244, 255) !important;
  color: black;
}
.el-button--primary:focus,
.el-button--primary:hover {
  background-color: rgb(64, 158, 255) !important;
}

.container-below {
  display:flex;
}

.left-table {
  flex: 6;
}

.right-pic{
  flex: 4;
}
</style>


<script>
import { list, forceLogout } from "@/api/monitor/online";

export default {
  name: "Online",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 总条数
      total: 0,
      // 表格数据
      list: [],
      pageNum: 1,
      pageSize: 10,
      // 查询参数
      queryParams: {
        ipaddr: undefined, // syyyyyyyyyyyyyyyyyyyyyyyyyyy
        userName: undefined
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询功能 */
    fetchData() {
      this.loading = true;
      list(this.queryParams).then(response => {
        this.list = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },

    /** 查询登录日志列表 */
    getList() {
      this.loading = true;
      list(this.queryParams).then(response => {
        this.list = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    /** 强退按钮操作 */
    handleForceLogout(row) {
      this.$modal.confirm('是否确认强退名称为"' + row.userName + '"的用户？').then(function() {
        return forceLogout(row.tokenId);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("强退成功");
      }).catch(() => {});
    }
  }
};
</script>

