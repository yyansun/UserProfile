<template>
  <div class="app-container" style="margin-left: 30px; margin-right: 50px">
<!--    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" label-width="68px">-->
<!--      <el-form-item label="登录地址" prop="ipaddr">-->
<!--        <el-input-->
<!--          v-model="queryParams.ipaddr"-->
<!--          placeholder="请输入登录地址"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="用户名称" prop="userName">-->
<!--        <el-input-->
<!--          v-model="queryParams.userName"-->
<!--          placeholder="请输入用户名称"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item>-->
<!--        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>-->
<!--        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>-->
<!--      </el-form-item>-->

<!--    </el-form>-->
    <div>
      性别
      <el-button>男</el-button>
      <el-button>女</el-button>
    </div>
    <div>
      政治面貌
      <el-button>党员</el-button>
      <el-button>群众</el-button>
      <el-button>无党派人士</el-button>
    </div>
    <div>
      职业
      <el-button>学生</el-button>
      <el-button>公务员</el-button>
      <el-button>军人</el-button>
      <el-button>警察</el-button>
      <el-button>教师</el-button>
      <el-button>白领</el-button>
    </div>
    <div>
      婚姻状况
      <el-button>未婚</el-button>
      <el-button>已婚</el-button>
      <el-button>离异</el-button>
    </div>
    <div>
      所属地区
      <el-button>中国大陆</el-button>
      <el-button>中国香港</el-button>
      <el-button>中国澳门</el-button>
      <el-button>中国台湾</el-button>
    </div>
    <el-col :span="1.5">
      <el-button
        type="primary"
        plain
        icon="el-icon-plus"
        style="margin-left: 20px; font-size: 16px"
        size="mini"
        @click="handleAdd"
        v-hasPermi="['system:role:add']"
      >添加</el-button>
    </el-col>
    <el-col :span="1.5">
      <el-button
        type="success"
        plain
        icon="el-icon-edit"
        style="margin-left: 20px; font-size: 16px"
        size="mini"
        :disabled="single"
        @click="handleUpdate"
        v-hasPermi="['system:role:edit']"
      >修改</el-button>
    </el-col>
    <el-col :span="1.5">
      <el-button
        type="danger"
        plain
        icon="el-icon-delete"
        style="margin-left: 20px; font-size:16px"
        size="mini"
        :disabled="multiple"
        @click="handleDelete"
        v-hasPermi="['system:role:remove']"
      >删除</el-button>
      </el-col>
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

<!--      <el-table-column label="手机号码" align="center" prop="os" />-->
<!--        <template slot-scope="scope">-->
<!--          <span>{{ parseTime(scope.row.loginTime) }}</span>-->
<!--        </template>-->
<!--      </el-table-column>-->
<!--      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">-->
<!--        <template slot-scope="scope">-->
<!--          <el-button-->
<!--            size="mini"-->
<!--            type="text"-->
<!--            icon="el-icon-delete"-->
<!--            @click="handleForceLogout(scope.row)"-->
<!--            v-hasPermi="['monitor:online:forceLogout']"-->
<!--          >强退</el-button>-->
<!--        </template>-->
<!--      </el-table-column>-->
    </el-table>

    <pagination v-show="total>0" :total="total" :page.sync="pageNum" :limit.sync="pageSize" />
  </div>
</template>

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
        ipaddr: undefined,
        userName: undefined
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
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

