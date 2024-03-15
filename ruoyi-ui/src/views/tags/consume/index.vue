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
      <el-form-item label="黑名单" prop="isBlacklist">
        <el-select v-model="queryParams.isBlacklist" placeholder="请选择黑名单" clearable>
          <el-option
            v-for="dict in dict.type.user_is_blacklist"
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
      <el-form-item label="客单价" prop="unitPriceRange">
        <el-select v-model="queryParams.unitPriceRange" placeholder="请选择客单价" clearable>
          <el-option
            v-for="dict in dict.type.user_unitprice_range"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="支付方式" prop="payment">
        <el-select v-model="queryParams.payment" placeholder="请选择支付方式" clearable>
          <el-option
            v-for="dict in dict.type.user_payment"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="单笔最高" prop="maxOrderRange">
        <el-select v-model="queryParams.maxOrderRange" placeholder="请选择单笔最高" clearable>
          <el-option
            v-for="dict in dict.type.user_maxorder_range"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="购买频率" prop="freqValue">
        <el-select v-model="queryParams.freqValue" placeholder="请选择购买频率" clearable>
          <el-option
            v-for="dict in dict.type.user_freq_value"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="退货频率" prop="retValue">
        <el-select v-model="queryParams.retValue" placeholder="请选择退货频率" clearable>
          <el-option
            v-for="dict in dict.type.user_ret_value"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="换货频率" prop="excValue">
        <el-select v-model="queryParams.excValue" placeholder="请选择换货频率" clearable>
          <el-option
            v-for="dict in dict.type.user_exc_value"
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
          v-hasPermi="['tags:consume:add']"
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
          v-hasPermi="['tags:consume:edit']"
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
          v-hasPermi="['tags:consume:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['tags:consume:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="consumeList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="用户编号" align="center" prop="id" />
      <el-table-column label="用户名" align="center" prop="username" />
      <el-table-column label="黑名单" align="center" prop="isBlacklist">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.user_is_blacklist" :value="scope.row.isBlacklist"/>
        </template>
      </el-table-column>
      <el-table-column label="消费周期" align="center" prop="consumptionCycle">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.user_consumption_cycle" :value="scope.row.consumptionCycle"/>
        </template>
      </el-table-column>
      <el-table-column label="客单价" align="center" prop="unitPrice" />
      <el-table-column label="支付方式" align="center" prop="payment">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.user_payment" :value="scope.row.payment"/>
        </template>
      </el-table-column>
      <el-table-column label="单笔最高" align="center" prop="maxOrderAmount" />
      <el-table-column label="购买次数/月" align="center" prop="frequency" />
      <el-table-column label="退货次数/月" align="center" prop="returnRate" />
      <el-table-column label="换货次数/月" align="center" prop="exchangeRate" />
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
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['tags:consume:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['tags:consume:remove']"
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

    <!-- 添加或修改消费特征对话框 -->
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
import { listConsume, getConsume, delConsume, addConsume, updateConsume } from "@/api/tags/consume";

export default {
  name: "Consume",
  dicts: ['user_consumption_cycle', 'user_psm', 'user_exc_value', 'user_rfm', 'user_maxorder_range', 'user_payment', 'user_is_blacklist', 'user_unitprice_range', 'user_ret_value', 'user_freq_value'],
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
      // 消费特征表格数据
      consumeList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        username: null,
        isBlacklist: null,
        consumptionCycle: null,
        unitPriceRange: null,
        payment: null,
        maxOrderRange: null,
        freqValue: null,
        retValue: null,
        excValue: null,
        rfm: null,
        psm: null
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
    /** 查询消费特征列表 */
    getList() {
      this.loading = true;
      listConsume(this.queryParams).then(response => {
        this.consumeList = response.rows;
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
        isBlacklist: null,
        consumptionCycle: null,
        unitPrice: null,
        unitPriceRange: null,
        payment: null,
        maxOrderAmount: null,
        maxOrderRange: null,
        frequency: null,
        freqValue: null,
        returnRate: null,
        retValue: null,
        exchangeRate: null,
        excValue: null,
        rfm: null,
        psm: null
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
      this.title = "添加消费特征";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getConsume(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改消费特征";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateConsume(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addConsume(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除消费特征编号为"' + ids + '"的数据项？').then(function() {
        return delConsume(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('tags/consume/export', {
        ...this.queryParams
      }, `consume_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
