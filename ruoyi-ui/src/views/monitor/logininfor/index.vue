<template>
  <div class="app-container">
    <div class="table-top">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">

      <el-form-item label="用户名称" prop="userName">
        <el-input
          v-model="queryParams.userName"
          placeholder="请输入用户名称"
          clearable
          style="width: 200px;"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="性别" prop="ipaddr">
        <el-input
          v-model="queryParams.ipaddr"
          placeholder="请输入性别"
          clearable
          style="width: 200px;"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="职业" prop="loginLocation">
        <el-input
          v-model="queryParams.loginLocation"
          placeholder="请输入职业"
          clearable
          style="width: 200px;"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="婚姻状况" prop="browser">
        <el-input
          v-model="queryParams.browser"
          placeholder="请输入婚姻状况"
          clearable
          style="width: 200px;"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <br>
      <el-form-item label="政治面貌" prop="os">
        <el-input
          v-model="queryParams.os"
          placeholder="请输入政治面貌"
          clearable
          style="width: 200px;"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="所属地区" prop="msg">
        <el-input
          v-model="queryParams.msg"
          placeholder="请输入所属地区"
          clearable
          style="width: 200px;"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="会员情况" prop="status">
        <el-select
          v-model="queryParams.status"
          placeholder="是否为会员"
          clearable
          style="width: 200px"
        >
          <el-option
            v-for="dict in dict.type.sys_common_status"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="出生日期">
        <el-date-picker
          v-model="dateRange"
          style="width: 240px"
          value-format="yyyy-MM-dd HH:mm:ss"
          type="daterange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
          :default-time="['00:00:00', '23:59:59']"
        ></el-date-picker>
      </el-form-item>
    </el-form>
    </div>
      <div class="table-middle">
        <el-form>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="medium" @click="handleQuery" style="margin-right: 20px">搜索</el-button>
        <el-button icon="el-icon-refresh" size="medium" @click="reloadPage">重置</el-button>
      </el-form-item>
        </el-form>
    </div>
    <div class="container-below">
      <el-card class="left-table">
        <el-table ref="tables" v-loading="loading" :data="list" @selection-change="handleSelectionChange" :default-sort="defaultSort" @sort-change="handleSortChange">
<!--          <el-table-column type="selection" width="30" align="center" />-->
          <el-table-column label="用户编号" align="center" prop="infoId" width="70" />
          <el-table-column label="用户名称" align="center" prop="userName" :show-overflow-tooltip="true" sortable="custom" :sort-orders="['descending', 'ascending']" />
          <el-table-column label="性别" align="center" prop="ipaddr" width="60" :show-overflow-tooltip="true" />
          <el-table-column label="职业" align="center" prop="loginLocation" :show-overflow-tooltip="true" />
          <el-table-column label="婚姻状况" align="center" prop="browser" :show-overflow-tooltip="true" />
          <el-table-column label="政治面貌" align="center" prop="os" />
          <el-table-column label="所属地区" align="center" prop="msg" :show-overflow-tooltip="true" />
          <el-table-column label="会员情况" align="center" prop="status">
            <template slot-scope="scope">
              <dict-tag :options="dict.type.sys_common_status" :value="scope.row.status"/>
            </template>
          </el-table-column>
          <el-table-column label="出生日期" align="center" prop="loginTime" sortable="custom" :sort-orders="['descending', 'ascending']" width="80">
            <template slot-scope="scope">
              <span>{{ parseTime(scope.row.loginTime) }}</span>
            </template>
          </el-table-column>
        </el-table>

        <pagination
          v-show="total>0"
          :total="total"
          :page.sync="queryParams.pageNum"
          :limit.sync="queryParams.pageSize"
          @pagination="getList"
        />
      </el-card>
      <el-card class="right-pic">一个饼图</el-card>
    </div>

  </div>
</template>

<script>
import { list, delLogininfor, cleanLogininfor, unlockLogininfor } from "@/api/monitor/logininfor";

export default {
  name: "Logininfor",
  dicts: ['sys_common_status'],
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 选择用户名
      selectName: "",
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 表格数据
      list: [],
      // 日期范围
      dateRange: [],
      // 默认排序
      defaultSort: {prop: 'infoId', order: 'aescending'},
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        ipaddr: undefined,
        userName: undefined,
        status: undefined
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
      list(this.addDateRange(this.queryParams, this.dateRange)).then(response => {
          this.list = response.rows;
          this.total = response.total;
          this.loading = false;
        }
      );
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.dateRange = [];
      this.resetForm("queryForm");
      this.queryParams.pageNum = 1;
      this.$refs.tables.sort(this.defaultSort.prop, this.defaultSort.order)
    },

    reloadPage() {
      window.location.reload();
    },
    /** 多选框选中数据 */
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.infoId)
      this.single = selection.length!=1
      this.multiple = !selection.length
      this.selectName = selection.map(item => item.userName);
    },
    /** 排序触发事件 */
    handleSortChange(column, prop, order) {
      this.queryParams.orderByColumn = column.prop;
      this.queryParams.isAsc = column.order;
      this.getList();
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const infoIds = row.infoId || this.ids;
      this.$modal.confirm('是否确认删除访问编号为"' + infoIds + '"的数据项？').then(function() {
        return delLogininfor(infoIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 清空按钮操作 */
    handleClean() {
      this.$modal.confirm('是否确认清空所有登录日志数据项？').then(function() {
        return cleanLogininfor();
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("清空成功");
      }).catch(() => {});
    },
    /** 解锁按钮操作 */
    handleUnlock() {
      const username = this.selectName;
      this.$modal.confirm('是否确认解锁用户"' + username + '"数据项?').then(function() {
        return unlockLogininfor(username);
      }).then(() => {
        this.$modal.msgSuccess("用户" + username + "解锁成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('monitor/logininfor/export', {
        ...this.queryParams
      }, `logininfor_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>

<style>
.container-below {
  display:flex;
}

.left-table {
  flex: 6;
  margin: 20px;
}

.right-pic{
  flex: 4;
  margin: 20px;
}

.table-top{
  margin: 30px;
  margin-top: 10px;
  margin-bottom: 5px;
}

.table-middle{
  margin-left: 30px;
}
</style>

