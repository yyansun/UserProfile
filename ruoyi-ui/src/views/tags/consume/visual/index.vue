<template>
  <div class="app-container" style="margin-left: 20px; margin-right: 20px">
    <div class="flex-container">
        <el-col :span="7">
            <el-card @click="handleJump()" class="card1">
              <div slot="header"><span class="chartTitle">性别分布</span></div>
              <div ref="genderChart" class="card-img" style="width: 350px; height: 350px;"></div>
            </el-card>
        </el-col>

<!--        </el-col>-->
<!--        <el-col :span="8">-->
<!--          <el-card class="card1">-->
<!--            <div slot="header"><span class="chartTitle">政治面貌分布</span></div>-->
<!--            <div ref="faceChart" class="card-img"  style="width: 350px; height: 350px;"></div>-->
<!--          </el-card>-->
<!--        </el-col>-->

<!--        <el-col :span="9">-->
<!--          <el-card class="card1" style="margin-right: 0">-->
<!--            <div slot="header"><span class="chartTitle">职业分布</span></div>-->
<!--            <div ref="jobChart" class="card-img"  style="width: 500px; height: 350px;"></div>-->
<!--          </el-card>-->
<!--        </el-col>-->
<!--      <el-row>-->
<!--        <el-col :span="7">-->
<!--          <el-card class="card1">-->
<!--            <div slot="header"><span class="chartTitle">所属地区分布</span></div>-->
<!--            <div ref="regionChart" class="card-img" style="width: 400px; height: 400px;"></div>-->
<!--          </el-card>-->
<!--        </el-col>-->
<!--        <el-col :span="8">-->
<!--          <el-card class="card1">-->
<!--            <div slot="header"><span class="chartTitle">婚姻状况分布</span></div>-->
<!--            <div ref="marriageChart" class="card-img" style="width: 400px; height: 400px;"></div>-->
<!--          </el-card>-->
<!--        </el-col>-->
<!--        <el-col :span="9">-->
<!--          <el-card class="card1" style="margin-right: 0">-->
<!--            <div slot="header"><span class="chartTitle">年龄分布</span></div>-->
<!--            <div ref="ageChart" class="card-img" style="width: 400px; height: 400px;"></div>-->
<!--          </el-card>-->
<!--        </el-col>-->
<!--      </el-row>-->
    </div>
  </div>
</template>

<script>
import {findData} from "@/api/tags/consume";
import * as echarts from "echarts";

export default {
  name:"Index",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 初始性别数据，假设有两个性别，初始值为0
      genderData: [],
      // ageRangeData: [],
      // jobData: [],
      // marriageData: [],
      // politicalFaceData: [],
      // regionData: [],
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
      findData()
        .then(response => {
          console.log('==================Data:', response.data);
          this.genderData = response.data.genderList;
          // this.ageRangeData = response.data.ageRangeList.sort();
          // this.jobData = response.data.jobList.sort();
          // this.marriageData = response.data.marriageList;
          // this.politicalFaceData = response.data.politicalFaceList;
          // this.regionData = response.data.regionList;
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
      // this.drawRoundedRingChart('marriageChart', '婚姻状况', this.marriageData, ['未婚', '已婚', '离异']);
      // this.drawPieChart('regionChart', '所属地区', this.regionData, ['中国大陆']);
      // this.drawRoundedRingChart('faceChart', '政治面貌', this.politicalFaceData, ['群众', '党员', '无党派人士']);
      // this.drawRoseChart('jobChart', '职业', this.jobData, ['军人', '白领','学生','公务员','警察','教师']);
      // this.drawRoseChart('ageChart', '年龄段', this.ageRangeData, ['00后', '80后','70后','90后']);
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
