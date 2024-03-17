<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="用户编号" prop="userId">
        <el-input
          v-model="queryParams.userId"
          placeholder="请输入id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <div ref="relationChart" class="card-img" style="width: 1200px; height: 1200px;"></div>
<!--    <el-table v-loading="loading" :data="profileList" @selection-change="handleSelectionChange">-->
<!--      <el-table-column type="selection" width="55" align="center" />-->
<!--      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">-->
<!--        <template slot-scope="scope">-->
<!--          <el-button-->
<!--            size="mini"-->
<!--            type="text"-->
<!--            icon="el-icon-edit"-->
<!--            @click="handleUpdate(scope.row)"-->
<!--            v-hasPermi="['tags:profile:edit']"-->
<!--          >修改</el-button>-->
<!--          <el-button-->
<!--            size="mini"-->
<!--            type="text"-->
<!--            icon="el-icon-delete"-->
<!--            @click="handleDelete(scope.row)"-->
<!--            v-hasPermi="['tags:profile:remove']"-->
<!--          >删除</el-button>-->
<!--        </template>-->
<!--      </el-table-column>-->
<!--    </el-table>-->

<!--    <pagination-->
<!--      v-show="total>0"-->
<!--      :total="total"-->
<!--      :page.sync="queryParams.pageNum"-->
<!--      :limit.sync="queryParams.pageSize"-->
<!--      @pagination="getList"-->
<!--    />-->

<!--    &lt;!&ndash; 添加或修改单人画像对话框 &ndash;&gt;-->
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
import { listProfile, getProfile, delProfile, addProfile, updateProfile } from "@/api/tags/profile";
import {findPortrait} from "@/api/tags/portrait";
import * as echarts from "echarts";

export default {
  name: "Profile",
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
      // ===================单人画像表格数据================
      profileList: [],
      userId:[],
      usg:[],
      unitPriceRange: [],
      rfm:[],
      rfe:[],
      returnRate: [],
      psm: [],
      politicalFace: [],
      payType: [],
      nationality: [],
      maxOrderRange: [],
      marriage: [],
      loginCycle: [],
      logTimeSlot: [],
      logFrequency: [],
      job:[],
      isBlacklist: [],
      gender:[],
      exchangeRate: [],
      consumptionCycle: [],
      buyFrequency: [],
      ageRange: [],
      bpTop1: [],
      bpTop2: [],
      bpTop3: [],
      bpTop4: [],
      bpTop5: [],


      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        userId: null,
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
    fetchData(userId) {
      this.loading = true;
      getProfile(userId)
        .then(response => {
          console.log('==================Data:', response.data);

          if (response.data) {
            this.profileList = response.data;
            if (this.profileList) {

              console.log('=================profile:', this.profileList);
              this.gender = this.profileList.gender;
              this.userId = this.profileList.userId;
              this.usg = this.profileList.usg;
              this.unitPriceRange = this.profileList.unitPriceRange;
              this.rfm = this.profileList.rfm;
              this.rfe = this.profileList.rfe;
              this.returnRate = this.profileList.returnRate;
              this.psm = this.profileList.psm;
              this.politicalFace = this.profileList.politicalFace;
              this.payType = this.profileList.payType;
              this.nationality = this.profileList.nationality;
              this.maxOrderRange = this.profileList.maxOrderRange;
              this.marriage = this.profileList.marriage;
              this.loginCycle = this.profileList.loginCycle;
              this.logTimeSlot = this.profileList.logTimeSlot;
              this.logFrequency = this.profileList.logFrequency;
              this.job = this.profileList.job;
              this.isBlacklist = this.profileList.isBlacklist;
              this.gender = this.profileList.gender;
              this.exchangeRate = this.profileList.exchangeRate;
              this.consumptionCycle = this.profileList.consumptionCycle;
              this.buyFrequency = this.profileList.buyFrequency;
              this.ageRange = this.profileList.ageRange;
              this.bpTop1 = this.profileList.bpTop1;
              this.bpTop2 = this.profileList.bpTop2;
              this.bpTop3 = this.profileList.bpTop3;
              this.bpTop4 = this.profileList.bpTop4;
              this.bpTop5 = this.profileList.bpTop5;
            }
          }

          console.log('==================Data:', this.profileList);
          console.log("=========未开始画图==========");
          this.$nextTick(() => {
            console.log("=========￥￥开始画图￥￥==========");
            this.drawRelationChart('relationChart', '关系图', this.profileList, []); // 在下一个tick中调用绘制图表的方法
          });
        })
        .catch(error => {
          console.error('Error fetching data:', error);
        })
        .finally(() => {
          this.loading = false;
        });
    },

    drawRelationChart(chartId, chartTitle, nodes, links) {
      const chartDom = this.$refs[chartId]; // 获取图表容器的DOM元素
      const myChart = echarts.init(chartDom); // 初始化echarts实例

      const option = {
        title: {
          text: '个人用户画像',
          // link: 'www.baidu.c'
        },
        tooltip: {},
        animationDurationUpdate: 1500,
        animationEasingUpdate: 'quinticInOut',
        label: {
          normal: {
            show: true,
            textStyle: {
              fontSize: 18
            },
          }
        },
        legend: {
          x: 'center',
          data: ['userId', '消费特征', '用户特征', '兴趣特征']
        },
        series: [

          {
            type: 'graph',
            layout: 'force',
            symbolSize: 80,
            focusNodeAdjacency: true,
            roam: true,
            categories: [{
              name: 'userId'
            }, {
              name: '消费特征'
            }, {
              name: '用户特征'
            }, {
              name: '兴趣特征'
            }],
            label: {
              normal: {
                show: true,
                textStyle: {
                  fontSize: 18
                },
              }
            },
            force: {
              repulsion: 2000
            },
            edgeLabel: {
              normal: {
                show: true,
                textStyle: {
                  fontSize: 18
                },
                formatter: '{c}'
              }
            },
            data: [
              {
              name: this.userId,
              category: 0,
            },
              {
                name: '婚姻状况：'+ this.marriage,
                category: 2,
                draggable: false,
              },
              {
                name: '用户价值：' + this.rfm,
                category: 1,
                draggable: true,
              }, {
                name: '活跃度：' + this.rfe,
                category: 3,
                draggable: true,
              },
              {
                name: '价格敏感度：' + this.psm,
                category: 1,
                draggable: true,
              },
              {
                name:'政治面貌：' + this.politicalFace,
                category: 2,
                draggable: true,
              }, {
                name: '性别：'+ this.gender,
                category: 2,
                draggable: true,
              }, {
                name: '支付方式：'+ this.payType,
                category: 1,
                draggable: true,
              }, {
                name: '购买频率' + this.buyFrequency,
                category: 1,
                draggable: true,
              },
              {
                name: '登录频率' + this.logFrequency,
                category: 3,
                draggable: true,
              },
              {
                name: '浏览时段: ' + this.logTimeSlot,
                category: 3,
                draggable: true,
              },
              {
                name: '职业：' + this.job,
                category: 2,
                draggable: true,
              },
              {
                name: '年龄段：' + this.ageRange,
                category: 2,
                draggable: true,
              },
              {
                name: '消费周期：' + this.consumptionCycle,
                category: 1,
                draggable: true,
              },
              {
                name: '是否为黑名单：' + this.isBlacklist,
                category: 1,
                draggable: true,
              },
              {
                name: '客单价：' + this.unitPriceRange,
                category: 1,
                draggable: true,
              },
``
            ],
            // links: [{
            //   source: this.useId,
            //   target: '消费特征',
            //   value: '',
            //   lineStyle: {
            //     normal: {
            //       color: 'red',
            //     }
            //   }
            //
            // }
            // ],
            // }, {
            //   source: '总经理',
            //   target: '副秘书长',
            //   value: '上级',
            //   lineStyle: {
            //     normal: {
            //       color: 'red',
            //     }
            //   }
            //
            // }, {
            //   source: '秘书长',
            //   target: '传达丙',
            //   value: '上级'
            // }, {
            //   source: '副秘书长',
            //   target: '传达丁',
            //   value: '上级'
            // }, {
            //   source: '秘书长',
            //   target: '夏桀',
            //   value: '上级'
            // }, {
            //   source: '副秘书长',
            //   target: '传达甲',
            //   value: '上级'
            // }, {
            //   source: '副秘书长',
            //   target: '传达乙',
            //   value: '上级'
            // }, {
            //   source: '基层甲',
            //   target: '传达丁',
            //   value: '上级',
            //   lineStyle: {
            //     normal: {
            //       color: 'red',
            //       type: 'dotted'
            //     }
            //   }
            //
            // }, {
            //   source: '基层丁',
            //   target: '传达丁',
            //   value: '上级',
            //   lineStyle: {
            //     normal: {
            //       color: 'red',
            //       type: 'dotted'
            //     }
            //   }
            //
            // }, {
            //   source: '基层丁',
            //   target: '传达丙',
            //   value: '上级',
            //   lineStyle: {
            //     normal: {
            //       color: 'red',
            //       type: 'dotted'
            //     }
            //   }
            //
            // }, {
            //   source: '基层乙',
            //   target: '传达丙',
            //   value: '上级',
            //   lineStyle: {
            //     normal: {
            //       color: 'red',
            //       type: 'dotted'
            //     }
            //   }
            // }, {
            //   source: '基层丙',
            //   target: '传达丙',
            //   value: '上级',
            //   lineStyle: {
            //     normal: {
            //       color: 'red',
            //       type: 'dotted'
            //     }
            //   }
            // }, ],
            lineStyle: {
              normal: {
                opacity: 0.7,
                width: 1,
                curveness: 0.1
              }
            }
          }
        ]
      };

        // myChart.clear();
        myChart.setOption(option); // 将配置选项应用到图表中
    },


    /** 查询单人画像列表 */
    getList() {
      this.loading = true;
      listProfile(this.queryParams).then(response => {
        this.profileList = response.rows;
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
        userId: null,
        gender: null,
        job: null,
        nationality: null,
        marriage: null,
        politicalFace: null,
        isBlacklist: null,
        rfm: null,
        rfe: null,
        psm: null,
        usg: null,
        ageRange: null,
        buyFrequency: null,
        consumptionCycle: null,
        exchangeRate: null,
        loginCycle: null,
        logFrequency: null,
        logTimeSlot: null,
        maxOrderRange: null,
        payType: null,
        returnRate: null,
        unitPriceRange: null,
        BpTop1: null,
        BpTop2: null,
        BpTop3: null,
        BpTop4: null,
        BpTop5: null
      };
      this.resetForm("form");
    },


    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
      this.fetchData(this.queryParams.userId);
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.userId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加单人画像";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const userId = row.userId || this.ids
      getProfile(userId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改单人画像";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.userId != null) {
            updateProfile(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addProfile(this.form).then(response => {
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
      const userIds = row.userId || this.ids;
      this.$modal.confirm('是否确认删除单人画像编号为"' + userIds + '"的数据项？').then(function() {
        return delProfile(userIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('tags/profile/export', {
        ...this.queryParams
      }, `profile_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
