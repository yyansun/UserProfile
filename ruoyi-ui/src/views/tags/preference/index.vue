<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="用户名" prop="username">
        <el-input
          v-model="queryParams.username"
          placeholder="请输入用户名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="最近登录" prop="loginCycle">
        <el-select v-model="queryParams.loginCycle" placeholder="请选择最近登录" clearable>
          <el-option
            v-for="dict in dict.type.user_login_cycle"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="访问频率" prop="freqValue">
        <el-select v-model="queryParams.freqValue" placeholder="请选择访问频率" clearable>
          <el-option
            v-for="dict in dict.type.user_login_frequency"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <br>
      <el-form-item label="浏览时段" prop="timeSlot">
        <el-select v-model="queryParams.timeSlot" placeholder="请选择浏览时段" clearable>
          <el-option
            v-for="dict in dict.type.user_login_timeslot"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="购物性别" prop="usg">
        <el-select v-model="queryParams.usg" placeholder="请选择购物性别" clearable>
          <el-option
            v-for="dict in dict.type.user_usg"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="活跃度" prop="rfe">
        <el-select v-model="queryParams.rfe" placeholder="请选择活跃度" clearable>
          <el-option
            v-for="dict in dict.type.user_rfe"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <br>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="medium" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="medium" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

<!--    </el-row>-->

    <el-table v-loading="loading" :data="preferenceList" @selection-change="handleSelectionChange">
<!--      <el-table-column type="selection" width="55" align="center" />-->
      <el-table-column label="用户编号" align="center" prop="id" />
      <el-table-column label="用户名" align="center" prop="username" />
      <el-table-column label="最近登录" align="center" prop="loginCycle">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.user_login_cycle" :value="scope.row.loginCycle"/>
        </template>
      </el-table-column>
      <el-table-column label="访问次数" align="center" prop="frequency" />
      <el-table-column label="浏览时段" align="center" prop="timeSlot">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.user_login_timeslot" :value="scope.row.timeSlot"/>
        </template>
      </el-table-column>
      <el-table-column label="购物性别" align="center" prop="usg">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.user_usg" :value="scope.row.usg"/>
        </template>
      </el-table-column>
      <el-table-column label="活跃度" align="center" prop="rfe">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.user_rfe" :value="scope.row.rfe"/>
        </template>
      </el-table-column>
      <el-table-column label="商品推荐top1" align="center" prop="top1" />
      <el-table-column label="商品推荐top2" align="center" prop="top2" />
      <el-table-column label="商品推荐top3" align="center" prop="top3" />
      <el-table-column label="商品推荐top4" align="center" prop="top4" />
      <el-table-column label="商品推荐top5" align="center" prop="top5" />
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改兴趣特征对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listPreference, getPreference, delPreference, addPreference, updatePreference } from "@/api/tags/preference";

export default {
  name: "Preference",
  dicts: ['user_login_frequency', 'user_login_timeslot', 'user_usg', 'user_login_cycle', 'user_rfe'],
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
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 兴趣特征表格数据
      preferenceList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        username: null,
        loginCycle: null,
        freqValue: null,
        timeSlot: null,
        usg: null,
        rfe: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        username: [
          { required: true, message: "用户名不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询兴趣特征列表 */
    getList() {
      this.loading = true;
      listPreference(this.queryParams).then(response => {
        this.preferenceList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        username: null,
        loginCycle: null,
        frequency: null,
        freqValue: null,
        timeSlot: null,
        usg: null,
        rfe: null,
        top1: null,
        top2: null,
        top3: null,
        top4: null,
        top5: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加兴趣特征";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getPreference(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改兴趣特征";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updatePreference(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addPreference(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除兴趣特征编号为"' + ids + '"的数据项？').then(function() {
        return delPreference(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('tags/preference/export', {
        ...this.queryParams
      }, `preference_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
