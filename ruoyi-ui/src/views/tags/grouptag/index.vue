<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="性别" prop="gender">
        <el-select v-model="queryParams.gender" placeholder="请选择性别" clearable>
          <el-option
            v-for="dict in dict.type.user_gender"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="职业" prop="job">
        <el-select v-model="queryParams.job" placeholder="请选择职业" clearable>
          <el-option
            v-for="dict in dict.type.user_job"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="年龄段" prop="ageRange">
        <el-select v-model="queryParams.ageRange" placeholder="请选择年龄段" clearable>
          <el-option
            v-for="dict in dict.type.user_age"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="消费周期" prop="consumptionCycle">
        <el-select v-model="queryParams.consumptionCycle" placeholder="请选择消费周期" clearable>
          <el-option
            v-for="dict in dict.type.user_consumption_cycle"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="消费能力" prop="rfm">
        <el-select v-model="queryParams.rfm" placeholder="请选择消费能力" clearable>
          <el-option
            v-for="dict in dict.type.user_rfm"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="价格敏感度" prop="psm">
        <el-select v-model="queryParams.psm" placeholder="请选择价格敏感度" clearable>
          <el-option
            v-for="dict in dict.type.user_psm"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
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
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['tags:grouptag:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['tags:grouptag:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['tags:grouptag:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['tags:grouptag:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="grouptagList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="用户编号" align="center" prop="id" />
      <el-table-column label="用户名" align="center" prop="username" />
      <el-table-column label="性别" align="center" prop="gender">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.user_gender" :value="scope.row.gender"/>
        </template>
      </el-table-column>
      <el-table-column label="职业" align="center" prop="job">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.user_job" :value="scope.row.job"/>
        </template>
      </el-table-column>
      <el-table-column label="年龄段" align="center" prop="ageRange">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.user_age" :value="scope.row.ageRange"/>
        </template>
      </el-table-column>
      <el-table-column label="消费周期" align="center" prop="consumptionCycle">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.user_consumption_cycle" :value="scope.row.consumptionCycle"/>
        </template>
      </el-table-column>
      <el-table-column label="消费能力" align="center" prop="rfm">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.user_rfm" :value="scope.row.rfm"/>
        </template>
      </el-table-column>
      <el-table-column label="价格敏感度" align="center" prop="psm">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.user_psm" :value="scope.row.psm"/>
        </template>
      </el-table-column>
      <el-table-column label="最近登录" align="center" prop="loginCycle">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.user_login_cycle" :value="scope.row.loginCycle"/>
        </template>
      </el-table-column>
      <el-table-column label="访问频率" align="center" prop="freqValue">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.user_login_frequency" :value="scope.row.freqValue"/>
        </template>
      </el-table-column>
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
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['tags:grouptag:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['tags:grouptag:remove']"
          >删除</el-button>
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

    <!-- 添加或修改组合标签对话框 -->
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
import { listGrouptag, getGrouptag, delGrouptag, addGrouptag, updateGrouptag } from "@/api/tags/grouptag";

export default {
  name: "Grouptag",
  dicts: ['user_age', 'user_consumption_cycle', 'user_psm', 'user_gender', 'user_login_frequency', 'user_login_timeslot', 'user_usg', 'user_rfm', 'user_login_cycle', 'user_job', 'user_rfe'],
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
      // 组合标签表格数据
      grouptagList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        gender: null,
        job: null,
        ageRange: null,
        consumptionCycle: null,
        rfm: null,
        psm: null,
        loginCycle: null,
        freqValue: null,
        timeSlot: null,
        usg: null,
        rfe: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询组合标签列表 */
    getList() {
      this.loading = true;
      listGrouptag(this.queryParams).then(response => {
        this.grouptagList = response.rows;
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
        gender: null,
        job: null,
        ageRange: null,
        consumptionCycle: null,
        rfm: null,
        psm: null,
        loginCycle: null,
        freqValue: null,
        timeSlot: null,
        usg: null,
        rfe: null
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
      this.title = "添加组合标签";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getGrouptag(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改组合标签";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateGrouptag(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addGrouptag(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除组合标签编号为"' + ids + '"的数据项？').then(function() {
        return delGrouptag(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('tags/grouptag/export', {
        ...this.queryParams
      }, `grouptag_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
