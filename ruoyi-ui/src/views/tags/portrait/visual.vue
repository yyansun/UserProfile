<template>
  <div class="app-container">
    <div style="margin-left: 20px">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="用户名" prop="username">
        <el-input
          v-model="queryParams.username"
          placeholder="请输入用户名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="联系方式" prop="mobile">
        <el-input
          v-model="queryParams.mobile"
          placeholder="请输入联系方式"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
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
      <br>
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
      <el-form-item label="政治面貌" prop="politicalFace">
        <el-select v-model="queryParams.politicalFace" placeholder="请选择政治面貌" clearable>
          <el-option
            v-for="dict in dict.type.user_political_face"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="所属地区" prop="region">
        <el-select v-model="queryParams.region" placeholder="请选择所属地区" clearable>
          <el-option
            v-for="dict in dict.type.user_region"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="婚姻状况" prop="marriage">
        <el-select v-model="queryParams.marriage" placeholder="请选择婚姻状况" clearable>
          <el-option
            v-for="dict in dict.type.user_marriage"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>

      <br>
      <el-form-item style="margin-left: 30px">
        <el-button type="primary" icon="el-icon-search" size="medium" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="medium" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>
    </div>
    <el-row>
      <el-col :span="16">
        <el-card style="width: 890px; margin-left: 20px">
          <el-table v-loading="loading" :data="portraitList" @selection-change="handleSelectionChange">
            <el-table-column label="用户编号" align="center" prop="id" width="80"/>
            <el-table-column label="用户名" align="center" prop="username" width="80"/>
            <el-table-column label="性别" align="center" prop="gender" width="60">
              <template slot-scope="scope">
                <dict-tag :options="dict.type.user_gender" :value="scope.row.gender"/>
              </template>
            </el-table-column>
            <el-table-column label="生日" align="center" prop="birthday" width="100">
              <template slot-scope="scope">
                <span>{{ parseTime(scope.row.birthday, '{y}-{m}-{d}') }}</span>
              </template>
            </el-table-column>
            <el-table-column label="职业" align="center" prop="job">
              <template slot-scope="scope">
                <dict-tag :options="dict.type.user_job" :value="scope.row.job"/>
              </template>
            </el-table-column>
            <el-table-column label="联系方式" align="center" prop="mobile" width="110"/>
            <el-table-column label="政治面貌" align="center" prop="politicalFace">
              <template slot-scope="scope">
                <dict-tag :options="dict.type.user_political_face" :value="scope.row.politicalFace"/>
              </template>
            </el-table-column>
            <el-table-column label="所属地区" align="center" prop="region">
              <template slot-scope="scope">
                <dict-tag :options="dict.type.user_region" :value="scope.row.region"/>
              </template>
            </el-table-column>
            <el-table-column label="婚姻状况" align="center" prop="marriage">
              <template slot-scope="scope">
                <dict-tag :options="dict.type.user_marriage" :value="scope.row.marriage"/>
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
      </el-col>
      <el-col :span="8">
        <el-card>
          <h1>TEST</h1>图1

        </el-card>
      </el-col>
    </el-row>
<!--    &lt;!&ndash; 添加或修改用户特征对话框 &ndash;&gt;-->
<!--    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>-->
<!--      <el-form ref="form" :model="form" :rules="rules" label-width="80px">-->
<!--      </el-form>-->
<!--      <div slot="footer" class="dialog-footer">-->
<!--        <el-button type="primary" @click="submitForm">确 定</el-button>-->
<!--        <el-button @click="cancel">取 消</el-button>-->
<!--      </div>-->
<!--    </el-dialog>-->
  </div>

</template>

<script>
import { listPortrait, getPortrait, delPortrait, addPortrait, updatePortrait } from "@/api/tags/portrait";
import * as echarts from "echarts";

export default {
  name: "Visual",
  dicts: ['user_age', 'user_gender', 'user_region', 'user_political_face', 'user_marriage', 'user_job'],
  data() {
    return {
      // 遮罩层
      genderData: [],
      // 初始性别数据，假设有两个性别，初始值为0
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
      // 用户特征表格数据
      portraitList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        username: null,
        gender: null,
        job: null,
        mobile: null,
        politicalFace: null,
        region: null,
        marriage: null,
        ageRange: null
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



  mounted() {
    this.$nextTick(() => {
      this.fetchGenderData();
    });
  },

  created() {
    this.getList();
  },

  methods: {
    /** 查询用户特征列表 */
    getList() {
      this.loading = true;
      listPortrait(this.queryParams).then(response => {
        this.portraitList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },

    fetchGenderData() {
      this.loading = true;
      findByGender()
        .then(response => {
          console.log('================Gender data:', response.data);
          this.genderData = response.data;
          this.$nextTick(() => {
            this.drawPieChart(); // 在下一个tick中调用绘制图表的方法
          });
        })
        .catch(error => {
          console.error('Error fetching gender data:', error);
        })
        .finally(() => {
          this.loading = false;
        });
    },


    drawPieChart() {
      const chartDom = this.$refs.pieChart // 获取图表容器
      const myChart = echarts.init(chartDom) // 初始化图表
      const option = {
        title: {
          text: 'Gender Distribution'
        },
        tooltip: {
          trigger: 'item',
          formatter: '{a} <br/>{b} : {c} ({d}%)'
        },
        series: [
          {
            name: 'Gender',
            type: 'pie',
            radius: '55%',
            data: [
              { value: this.genderData[0], name: 'Male' }, // 使用性别数据绘制饼图
              { value: this.genderData[1], name: 'Female' },
            ]
          }
        ]
      }
      myChart.setOption(option) // 设置图表配置选项
    }
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
        memberRankId: null,
        gender: null,
        birthday: null,
        job: null,
        mobile: null,
        politicalFace: null,
        region: null,
        marriage: null,
        ageRange: null
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
      this.title = "添加用户特征";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getPortrait(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改用户特征";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updatePortrait(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addPortrait(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除用户特征编号为"' + ids + '"的数据项？').then(function() {
        return delPortrait(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('tags/portrait/export', {
        ...this.queryParams
      }, `portrait_${new Date().getTime()}.xlsx`)
    }
};
</script>
