<template>
  <div class="app-container">
    <div class="all">

      <el-col class="col1">
        <el-row>
           <div slot="header">用户性别分布</div>
            <div ref="genderChart" class="card-img" style="width: 400px; height: 300px;"></div>
        </el-row>
      <el-row>
          <div slot="header">用户年龄分布</div>
          <div ref="ageRangeChart" class="card-img" style="width: 400px; height: 300px;"></div>
      </el-row>
      <el-row>
          <div slot="header">用户职业分布</div>
          <div ref="jobChart" class="card-img" style="width: 420px; height: 300px;"></div>
      </el-row>
      </el-col>
    <el-col class="col2">
      <el-row>
        <div slot="header">用户消费能力分布</div>
        <div ref="rfmChart" class="card-img" style="width: 400px; height: 300px;"></div>
      </el-row>
      <el-row>
        <div slot="header">RFE能力分布</div>
        <div ref="rfeChart" class="card-img" style="width: 450px; height: 300px;"></div>
      </el-row>
      <el-row>
        <div slot="header">用户浏览时段分布</div>
        <div ref="timeSlotChart" class="card-img" style="width: 450px; height: 300px;"></div>
      </el-row>
    </el-col>
    </div>
  </div>
</template>

<script>
import {findPortrait} from "@/api/tags/portrait";
import {findConsume} from "@/api/tags/consume";
import {findPreference} from "@/api/tags/preference";
import * as echarts from "echarts";

export default {
  name: "Index",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 初始性别数据，假设有两个性别，初始值为0
      genderData: [],
      jobData: [],
      ageRangeData: [],
      timeSlotData: [],
      rfeData: [],  // 用户活跃度
      rfmData: [], //用户消费能力
    }
  },

  mounted() {
    this.$nextTick(() => {
      this.fetchData();
    });
  },

  methods: {
    fetchData() {
      this.loading = true;

      findPortrait()
        .then(response => {
          console.log('==================Portrait Data:', response.data);

          this.genderData = response.data.genderList;
          this.jobData = response.data.jobList;
          this.ageRangeData = response.data.ageRangeList;

          this.$nextTick(() => {
            this.drawCharts1(); // 在下一个tick中调用绘制图表的方法
          });
        })
        .catch(error => {
          console.error('Error fetching data:', error);
        })
        .finally(() => {
          this.loading = false;
        });


      findConsume()
        .then(response => {
          console.log('==================Consume Data:', response.data);
          this.rfmData = response.data.rfmList;

          this.$nextTick(() => {
            this.drawCharts2(); // 在下一个tick中调用绘制图表的方法
          });
        })
        .catch(error => {
          console.error('Error fetching data:', error);
        })
        .finally(() => {
          this.loading = false;
        });

      findPreference()
        .then(response => {
          console.log('==================Preference Data:', response.data);
          this.rfeData = response.data.rfeList;
          this.timeSlotData = response.data.timeSlotList;

          console.log('==================rfe:', this.rfeData);
          console.log('==================Data:', this.timeSlotData);

          this.$nextTick(() => {
            this.drawCharts3(); // 在下一个tick中调用绘制图表的方法
          });
        })
        .catch(error => {
          console.error('Error fetching data:', error);
        })
        .finally(() => {
          this.loading = false;
        });

    },

    drawCharts1() {
      this.drawBarChart('genderChart', '用户性别', this.genderData, ['男', '女']);
      this.drawBarChart('ageRangeChart', '用户年龄', this.ageRangeData, ['00后', '90后', '80后', '70后']);
      this.drawBarChart('jobChart', '用户职业', this.jobData, ['警察', '白领', '学生', '公务员', '教师', '军人']);
    },

    drawCharts2() {
      this.drawBarChart('rfmChart', '用户消费能力', this.rfmData, ['高', '中上', '中', '中下', '低']);
    },

    drawCharts3() {
      this.drawBarChart('rfeChart', '用户活跃度', this.rfeData, ['非常活跃', '活跃', '不活跃', '非常不活跃']);
      this.drawBarChart('timeSlotChart', '用户浏览时段', this.timeSlotData, ['早晨', '上午', '中午', '下午', '傍晚', '凌晨']);
      },

    drawPieChart(chartId, chartTitle, data, labels) {
      const chartDom = this.$refs[chartId] // 获取图表容器
      const myChart = echarts.init(chartDom) // 初始化图表
      const option = {
        title: {
          text: chartTitle
        },
        tooltip: {
          trigger: 'item',
          formatter: '{a} <br/>{b} : {c} ({d}%)'
        },
        series: [
          {
            name: chartTitle,
            type: 'pie',
            radius: '55%',
            data: labels.map((label, index) => ({value: data[index], name: label}))
          }
        ]
      };
      myChart.setOption(option) // 设置图表配置选项
    },

    drawBarChart(chartId, chartTitle, data, labels, yTitle) {
      const chartDom = this.$refs[chartId];
      const myChart = echarts.init(chartDom);
      const option = {
        title: {
          text: chartTitle
        },
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'shadow'
          }
        },
        yAxis: {
          type: 'category',
          data: labels,
          axisLine: {
            show: true,
            lineStyle: {
              color: 'black'
            }
          }
        },
        xAxis: {
          type: 'value',
          name: 'r人数',
          axisLine: {
            show: true,
            lineStyle: {
              color: 'black'
            }
          }
        },
        grid: {
          right:100
        },

        series: [{
          data: data,
          type: 'bar',
          itemStyle: {
            // 通过判断索引或者名称来设置颜色
            color: function(params) {
              if (params.name === '男') {
                return '#5470C6'; // 如果是男性，设置为蓝色
              } else if (params.name === '女'){
                return '#9FE080';
              } else if (params.name === '教师'){
                return '#3BA272';
              } else if (params.name === '军人'){
                return '#5C7BD9';
              } else if (params.name === '警察'){
                return '#7ED3F4';
              } else if (params.name === '学生'){
                return '#FFDC60';
              } else if (params.name === '白领'){
                return '#9FE080';
              } else if (params.name === '公务员'){
                return '#FF7A7A';
              }  else if (params.name === '70后'){
                return '#FFDC60';
              } else if (params.name === '80后'){
                return '#9FE080';
              } else if (params.name === '90后'){
                return '#FF7A7A';
              } else if (params.name === '00后'){
                return '#5C7BD9';
              } else if (params.name === '高') {
                return '#7ED3F4';
              } else if (params.name === '中上'){
                return '#FFDC60';
              } else if (params.name === '中'){
                return '#9FE080';
              } else if (params.name === '中下'){
                return '#5C7BD9';
              } else if (params.name === '低'){
                return '#FF7A7A';
              } else if (params.name === '非常活跃'){
                return '#5C7BD9';
              } else if (params.name === '活跃'){
                return '#9FE080';
              } else if (params.name === '不活跃'){
                return '#FFDC60';
              } else if (params.name === '非常不活跃'){
                return '#FF7A7A';
              } else if (params.name === '早晨'){
                return '#5C7BD9';
              } else if (params.name === '上午'){
                return '#9FE080';
              } else if (params.name === '中午'){
                return '#FFDC60';
              } else if (params.name === '下午'){
                return '#FF7A7A';
              } else if (params.name === '傍晚'){
                return '#7ED3F4';
              } else if (params.name === '凌晨'){
                return '#3BA272';
              }
            }
          }
        }]
      };
      myChart.setOption(option);
    }
  },

  drawBar1Chart(chartId, chartTitle, data, labels) {
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
}

</script>

<style>
  .all {
    background-image: url("../assets/images/multitalk.svg");
    background-size: 25%; /* 不对图片进行缩放 */
    background-position: center; /* 将背景图片放置在视图的中间 */
    background-repeat: no-repeat;
    width: 100%;
    height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
    margin: 20px;
    margin-top: 70px;
    margin-bottom: 120px;
  }

  .col1 {
    margin-left: 100px;
    margin-top: 100px;
  }

  .col2 {
    margin-left: 450px;
    margin-top: 100px;
  }
</style>
