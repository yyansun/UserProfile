<!--<template>-->
<!--  <div class="app-container">-->
<!--    <div style="margin-left: 20px">-->
<!--      <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">-->
<!--        <el-form-item label="用户名" prop="username">-->
<!--          <el-input-->
<!--            v-model="queryParams.username"-->
<!--            placeholder="请输入用户名"-->
<!--            clearable-->
<!--            @keyup.enter.native="handleQuery"-->
<!--          />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="联系方式" prop="mobile">-->
<!--          <el-input-->
<!--            v-model="queryParams.mobile"-->
<!--            placeholder="请输入联系方式"-->
<!--            clearable-->
<!--            @keyup.enter.native="handleQuery"-->
<!--          />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="性别" prop="gender">-->
<!--          <el-select v-model="queryParams.gender" placeholder="请选择性别" clearable>-->
<!--            <el-option-->
<!--              v-for="dict in dict.type.user_gender"-->
<!--              :key="dict.value"-->
<!--              :label="dict.label"-->
<!--              :value="dict.value"-->
<!--            />-->
<!--          </el-select>-->
<!--        </el-form-item>-->
<!--        <el-form-item label="职业" prop="job">-->
<!--          <el-select v-model="queryParams.job" placeholder="请选择职业" clearable>-->
<!--            <el-option-->
<!--              v-for="dict in dict.type.user_job"-->
<!--              :key="dict.value"-->
<!--              :label="dict.label"-->
<!--              :value="dict.value"-->
<!--            />-->
<!--          </el-select>-->
<!--        </el-form-item>-->
<!--        <br>-->
<!--        <el-form-item label="年龄段" prop="ageRange">-->
<!--          <el-select v-model="queryParams.ageRange" placeholder="请选择年龄段" clearable>-->
<!--            <el-option-->
<!--              v-for="dict in dict.type.user_age"-->
<!--              :key="dict.value"-->
<!--              :label="dict.label"-->
<!--              :value="dict.value"-->
<!--            />-->
<!--          </el-select>-->
<!--        </el-form-item>-->
<!--        <el-form-item label="政治面貌" prop="politicalFace">-->
<!--          <el-select v-model="queryParams.politicalFace" placeholder="请选择政治面貌" clearable>-->
<!--            <el-option-->
<!--              v-for="dict in dict.type.user_political_face"-->
<!--              :key="dict.value"-->
<!--              :label="dict.label"-->
<!--              :value="dict.value"-->
<!--            />-->
<!--          </el-select>-->
<!--        </el-form-item>-->
<!--        <el-form-item label="所属地区" prop="region">-->
<!--          <el-select v-model="queryParams.region" placeholder="请选择所属地区" clearable>-->
<!--            <el-option-->
<!--              v-for="dict in dict.type.user_region"-->
<!--              :key="dict.value"-->
<!--              :label="dict.label"-->
<!--              :value="dict.value"-->
<!--            />-->
<!--          </el-select>-->
<!--        </el-form-item>-->
<!--        <el-form-item label="婚姻状况" prop="marriage">-->
<!--          <el-select v-model="queryParams.marriage" placeholder="请选择婚姻状况" clearable>-->
<!--            <el-option-->
<!--              v-for="dict in dict.type.user_marriage"-->
<!--              :key="dict.value"-->
<!--              :label="dict.label"-->
<!--              :value="dict.value"-->
<!--            />-->
<!--          </el-select>-->
<!--        </el-form-item>-->

<!--        <br>-->
<!--        <el-form-item style="margin-left: 30px">-->
<!--          <el-button type="primary" icon="el-icon-search" size="medium" @click="handleQuery">搜索</el-button>-->
<!--          <el-button icon="el-icon-refresh" size="medium" @click="resetQuery">重置</el-button>-->
<!--        </el-form-item>-->
<!--      </el-form>-->
<!--    </div>-->
<!--    <el-row>-->
<!--      <el-col :span="16">-->
<!--        <el-card style="width: 890px; margin-left: 20px">-->
<!--          <el-table v-loading="loading" :data="portraitList" @selection-change="handleSelectionChange">-->
<!--            <el-table-column label="用户编号" align="center" prop="id" width="80"/>-->
<!--            <el-table-column label="用户名" align="center" prop="username" width="80"/>-->
<!--            <el-table-column label="性别" align="center" prop="gender" width="60">-->
<!--              <template slot-scope="scope">-->
<!--                <dict-tag :options="dict.type.user_gender" :value="scope.row.gender"/>-->
<!--              </template>-->
<!--            </el-table-column>-->
<!--            <el-table-column label="生日" align="center" prop="birthday" width="100">-->
<!--              <template slot-scope="scope">-->
<!--                <span>{{ parseTime(scope.row.birthday, '{y}-{m}-{d}') }}</span>-->
<!--              </template>-->
<!--            </el-table-column>-->
<!--            <el-table-column label="职业" align="center" prop="job">-->
<!--              <template slot-scope="scope">-->
<!--                <dict-tag :options="dict.type.user_job" :value="scope.row.job"/>-->
<!--              </template>-->
<!--            </el-table-column>-->
<!--            <el-table-column label="联系方式" align="center" prop="mobile" width="110"/>-->
<!--            <el-table-column label="政治面貌" align="center" prop="politicalFace">-->
<!--              <template slot-scope="scope">-->
<!--                <dict-tag :options="dict.type.user_political_face" :value="scope.row.politicalFace"/>-->
<!--              </template>-->
<!--            </el-table-column>-->
<!--            <el-table-column label="所属地区" align="center" prop="region">-->
<!--              <template slot-scope="scope">-->
<!--                <dict-tag :options="dict.type.user_region" :value="scope.row.region"/>-->
<!--              </template>-->
<!--            </el-table-column>-->
<!--            <el-table-column label="婚姻状况" align="center" prop="marriage">-->
<!--              <template slot-scope="scope">-->
<!--                <dict-tag :options="dict.type.user_marriage" :value="scope.row.marriage"/>-->
<!--              </template>-->
<!--            </el-table-column>-->
<!--          </el-table>-->

<!--          <pagination-->
<!--            v-show="total>0"-->
<!--            :total="total"-->
<!--            :page.sync="queryParams.pageNum"-->
<!--            :limit.sync="queryParams.pageSize"-->
<!--            @pagination="getList"-->
<!--          />-->
<!--        </el-card>-->
<!--      </el-col>-->
<!--      <el-col :span="8">-->
<!--        <el-card>-->
<!--          <h1>TEST</h1>图1-->

<!--        </el-card>-->
<!--      </el-col>-->
<!--    </el-row>-->
<!--    &lt;!&ndash;    &lt;!&ndash; 添加或修改用户特征对话框 &ndash;&gt;&ndash;&gt;-->
<!--    &lt;!&ndash;    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>&ndash;&gt;-->
<!--    &lt;!&ndash;      <el-form ref="form" :model="form" :rules="rules" label-width="80px">&ndash;&gt;-->
<!--    &lt;!&ndash;      </el-form>&ndash;&gt;-->
<!--    &lt;!&ndash;      <div slot="footer" class="dialog-footer">&ndash;&gt;-->
<!--    &lt;!&ndash;        <el-button type="primary" @click="submitForm">确 定</el-button>&ndash;&gt;-->
<!--    &lt;!&ndash;        <el-button @click="cancel">取 消</el-button>&ndash;&gt;-->
<!--    &lt;!&ndash;      </div>&ndash;&gt;-->
<!--    &lt;!&ndash;    </el-dialog>&ndash;&gt;-->
<!--  </div>-->

<!--</template>-->

<!--<script>-->
<!--import { listPortrait, getPortrait, delPortrait, addPortrait, updatePortrait } from "@/api/tags/portrait";-->
<!--import * as echarts from "echarts";-->

<!--export default {-->
<!--  name: "Visual",-->
<!--  dicts: ['user_age', 'user_gender', 'user_region', 'user_political_face', 'user_marriage', 'user_job'],-->
<!--  data() {-->
<!--    return {-->
<!--      // 遮罩层-->
<!--      genderData: [],-->
<!--      // 初始性别数据，假设有两个性别，初始值为0-->
<!--      loading: true,-->
<!--      // 选中数组-->
<!--      ids: [],-->
<!--      // 非单个禁用-->
<!--      single: true,-->
<!--      // 非多个禁用-->
<!--      multiple: true,-->
<!--      // 显示搜索条件-->
<!--      showSearch: true,-->
<!--      // 总条数-->
<!--      total: 0,-->
<!--      // 用户特征表格数据-->
<!--      portraitList: [],-->
<!--      // 弹出层标题-->
<!--      title: "",-->
<!--      // 是否显示弹出层-->
<!--      open: false,-->
<!--      // 查询参数-->
<!--      queryParams: {-->
<!--        pageNum: 1,-->
<!--        pageSize: 10,-->
<!--        username: null,-->
<!--        gender: null,-->
<!--        job: null,-->
<!--        mobile: null,-->
<!--        politicalFace: null,-->
<!--        region: null,-->
<!--        marriage: null,-->
<!--        ageRange: null-->
<!--      },-->
<!--      // 表单参数-->
<!--      form: {},-->
<!--      // 表单校验-->
<!--      rules: {-->
<!--        username: [-->
<!--          {required: true, message: "用户名不能为空", trigger: "blur"}-->
<!--        ],-->
<!--      }-->
<!--    };-->
<!--  },-->


<!--  mounted() {-->
<!--    this.$nextTick(() => {-->
<!--      this.fetchGenderData();-->
<!--    });-->
<!--  },-->

<!--  created() {-->
<!--    this.getList();-->
<!--  },-->

<!--  methods: {-->
<!--    /** 查询用户特征列表 */-->
<!--    getList() {-->
<!--      this.loading = true;-->
<!--      listPortrait(this.queryParams).then(response => {-->
<!--        this.portraitList = response.rows;-->
<!--        this.total = response.total;-->
<!--        this.loading = false;-->
<!--      });-->
<!--    },-->


<!--    // 取消按钮-->
<!--    cancel() {-->
<!--      this.open = false;-->
<!--      this.reset();-->
<!--    },-->
<!--    // 表单重置-->
<!--    reset() {-->
<!--      this.form = {-->
<!--        id: null,-->
<!--        username: null,-->
<!--        memberRankId: null,-->
<!--        gender: null,-->
<!--        birthday: null,-->
<!--        job: null,-->
<!--        mobile: null,-->
<!--        politicalFace: null,-->
<!--        region: null,-->
<!--        marriage: null,-->
<!--        ageRange: null-->
<!--      };-->
<!--      this.resetForm("form");-->
<!--    },-->
<!--    /** 搜索按钮操作 */-->
<!--    handleQuery() {-->
<!--      this.queryParams.pageNum = 1;-->
<!--      this.getList();-->
<!--    },-->
<!--    /** 重置按钮操作 */-->
<!--    resetQuery() {-->
<!--      this.resetForm("queryForm");-->
<!--      this.handleQuery();-->
<!--    },-->
<!--    // 多选框选中数据-->
<!--    handleSelectionChange(selection) {-->
<!--      this.ids = selection.map(item => item.id)-->
<!--      this.single = selection.length !== 1-->
<!--      this.multiple = !selection.length-->
<!--    },-->
<!--    /** 新增按钮操作 */-->
<!--    handleAdd() {-->
<!--      this.reset();-->
<!--      this.open = true;-->
<!--      this.title = "添加用户特征";-->
<!--    },-->
<!--    /** 修改按钮操作 */-->
<!--    handleUpdate(row) {-->
<!--      this.reset();-->
<!--      const id = row.id || this.ids-->
<!--      getPortrait(id).then(response => {-->
<!--        this.form = response.data;-->
<!--        this.open = true;-->
<!--        this.title = "修改用户特征";-->
<!--      });-->
<!--    },-->
<!--    /** 提交按钮 */-->
<!--    submitForm() {-->
<!--      this.$refs["form"].validate(valid => {-->
<!--        if (valid) {-->
<!--          if (this.form.id != null) {-->
<!--            updatePortrait(this.form).then(response => {-->
<!--              this.$modal.msgSuccess("修改成功");-->
<!--              this.open = false;-->
<!--              this.getList();-->
<!--            });-->
<!--          } else {-->
<!--            addPortrait(this.form).then(response => {-->
<!--              this.$modal.msgSuccess("新增成功");-->
<!--              this.open = false;-->
<!--              this.getList();-->
<!--            });-->
<!--          }-->
<!--        }-->
<!--      });-->
<!--    },-->
<!--    /** 删除按钮操作 */-->
<!--    handleDelete(row) {-->
<!--      const ids = row.id || this.ids;-->
<!--      this.$modal.confirm('是否确认删除用户特征编号为"' + ids + '"的数据项？').then(function () {-->
<!--        return delPortrait(ids);-->
<!--      }).then(() => {-->
<!--        this.getList();-->
<!--        this.$modal.msgSuccess("删除成功");-->
<!--      }).catch(() => {-->
<!--      });-->
<!--    },-->
<!--    /** 导出按钮操作 */-->
<!--    handleExport() {-->
<!--      this.download('tags/portrait/export', {-->
<!--        ...this.queryParams-->
<!--      }, `portrait_${new Date().getTime()}.xlsx`)-->
<!--    }-->
<!--  }-->
<!--}-->
<!--</script>-->


<template>
  <div class="app-container" style="margin-left: 20px; margin-right: 20px">
    <div class="flex-container">
    <el-row>
      <el-col :span="7">
        <router-link to="visual">
          <el-card @click="handleJump()" class="card1">
            <div slot="header"><span class="chartTitle">性别分布</span></div>
            <div ref="genderChart" class="card-img" style="width: 350px; height: 350px;"></div>
          </el-card>
        </router-link>

      </el-col>
      <el-col :span="8">
        <el-card class="card1">
          <div slot="header"><span class="chartTitle">政治面貌分布</span></div>
          <div ref="faceChart" class="card-img"  style="width: 350px; height: 350px;"></div>
        </el-card>
      </el-col>

      <el-col :span="9">
          <el-card class="card1" style="margin-right: 0">
            <div slot="header"><span class="chartTitle">职业分布</span></div>
            <div ref="jobChart" class="card-img"  style="width: 500px; height: 350px;"></div>
          </el-card>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="7">
        <el-card class="card1">
          <div slot="header"><span class="chartTitle">所属地区分布</span></div>
          <div ref="regionChart" class="card-img" style="width: 400px; height: 400px;"></div>
        </el-card>
      </el-col>
      <el-col :span="8">
        <el-card class="card1">
          <div slot="header"><span class="chartTitle">婚姻状况分布</span></div>
          <div ref="marriageChart" class="card-img" style="width: 400px; height: 400px;"></div>
        </el-card>
      </el-col>
      <el-col :span="9">
          <el-card class="card1" style="margin-right: 0">
            <div slot="header"><span class="chartTitle">年龄分布</span></div>
            <div ref="ageChart" class="card-img" style="width: 400px; height: 400px;"></div>
          </el-card>
      </el-col>
    </el-row>
    </div>
  </div>
</template>

<script>
import {findBy} from "@/api/tags/portrait";
import * as echarts from "echarts";

export default {
  name:"Index",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 初始性别数据，假设有两个性别，初始值为0
      genderData: [],
      ageRangeData: [],
      jobData: [],
      marriageData: [],
      politicalFaceData: [],
      regionData: [],
    }
  },

  mounted() {
    this.$nextTick(() => {
      this.fetchData();
    });
  },

  methods: {
    goIndex() {
      this.$router.push('/tags/portrait/visual');
    },

    fetchData() {
      this.loading = true;
      findBy()
        .then(response => {
          console.log('==================Data:', response.data);
          this.genderData = response.data.genderList;
          this.ageRangeData = response.data.ageRangeList.sort();
          this.jobData = response.data.jobList.sort();
          this.marriageData = response.data.marriageList;
          this.politicalFaceData = response.data.politicalFaceList;
          this.regionData = response.data.regionList;
          this.$nextTick(() => {
            this.drawCharts(); // 在下一个tick中调用绘制图表的方法
          });
        })
        .catch(error => {
          console.error('Error fetching data:', error);
        })
        .finally(() => {
          this.loading = false;
        });
    },

    handleJump: function( ) {
      this.$router.push("/tags/portrait/visual");
    },

    drawCharts() {
      this.drawPieChart('genderChart', '', this.genderData, ['男', '女']);
      this.drawRoundedRingChart('marriageChart', '婚姻状况', this.marriageData, ['未婚', '已婚', '离异']);
      this.drawPieChart('regionChart', '所属地区', this.regionData, ['中国大陆']);
      this.drawRoundedRingChart('faceChart', '政治面貌', this.politicalFaceData, ['群众', '党员', '无党派人士']);
      this.drawRoseChart('jobChart', '职业', this.jobData, ['军人', '白领','学生','公务员','警察','教师']);
      this.drawRoseChart('ageChart', '年龄段', this.ageRangeData, ['00后', '80后','70后','90后']);
      },

    drawPieChart(chartId, chartTitle, data, labels) {
      const chartDom = this.$refs[chartId] // 获取图表容器
      const myChart = echarts.init(chartDom) // 初始化图表
      const option = {
        // title: {
        //   text: chartTitle
        // },
        tooltip: {
          trigger: 'item',
          formatter: '{a} <br/>{b} : {c} ({d}%)'
        },
        series: [
          {
            name: chartTitle,
            type: 'pie',
            radius: '55%',
            data: labels.map((label, index) => ({ value: data[index], name: label }))
          }
        ]
      };
      myChart.setOption(option) // 设置图表配置选项
    },

    drawRoseChart(chartId, chartTitle, data, labels) {
      const chartDom = this.$refs[chartId]; // 获取图表容器的DOM元素
      const myChart = echarts.init(chartDom); // 初始化echarts实例

      const option = {
        tooltip: {
          trigger: 'item',
          formatter: '{a} <br/>{b} : {c} ({d}%)'
        },
        series: [
          {
            name: chartTitle,
            type: 'pie',
            radius: [30, 150], // 设置南丁格尔玫瑰图的内外半径范围，第一个值为内半径，第二个值为外半径
            roseType: 'area', // 设置为南丁格尔玫瑰图类型
            itemStyle: {
              borderRadius: 8
            },
            data: labels.map((label, index) => ({ value: data[index], name: label }))
          }
        ]
      };

      myChart.setOption(option); // 将配置选项应用到图表中
    },

    drawRoundedRingChart(chartId, chartTitle, data, labels) {
      const chartDom = this.$refs[chartId]; // 获取图表容器的 DOM 元素
      const myChart = echarts.init(chartDom); // 初始化 ECharts 实例

      const option = {
        // title: {
        //   text: chartTitle,
        //   left: 'center'
        // },
        tooltip: {
          trigger: 'item',
          formatter: '{a} <br/>{b}: {c} ({d}%)'
        },
        series: [
          {
            name: chartTitle,
            type: 'pie',
            radius: ['35%', '70%'], // 设置内外半径
            avoidLabelOverlap: false,
            label: {
              show: false,
              position: 'center'
            },
            emphasis: {
              label: {
                show: true,
                fontSize: '30',
                fontWeight: 'bold'
              }
            },
            labelLine: {
              show: false
            },
            itemStyle: {
              borderRadius: 10, // 设置圆角
              borderColor: '#fff',
              borderWidth: 2
            },
            data: labels.map((label, index) => ({ value: data[index], name: label }))
          }
        ]
      };

      myChart.setOption(option); // 将配置选项应用到图表中
    },


    drawBarChart(chartId, chartTitle, data, labels) {
      const chartDom = this.$refs[chartId];
      const myChart = echarts.init(chartDom);
      const option = {
        // title: {
        //   text: chartTitle
        // },
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'shadow'
          }
        },
        xAxis: {
          type: 'category',
          data: labels
        },
        yAxis: {
          type: 'value'
        },
        series: [{
          data: data,
          type: 'bar'
        }]
      };
      myChart.setOption(option);
    }
  },

}
</script>
<style>
  .chartTitle {
    font-weight: 700;
    font-size: 20px;
  }

  .card1 {
    margin-right: 20px;
    margin-bottom: 20px;
  }

  .flex-container {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
  }

</style>
