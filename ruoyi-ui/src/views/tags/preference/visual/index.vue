<template>
  <div class="app-container" style="margin-left: 20px; margin-right: 20px">
    <div class="flex-container">
      <el-row>
        <el-col :span="8">
          <router-link to="visual">
            <el-card class="card1">
              <div slot="header"><span class="chartTitle">购物性别分布</span></div>
              <div ref="usgChart" class="card-img" style="width: 400px; height: 400px;"></div>
            </el-card>
          </router-link>

        </el-col>
        <el-col :span="8">
          <el-card class="card1">
            <div slot="header"><span class="chartTitle">浏览时段分布</span></div>
            <div ref="timeSlotChart" class="card-img" style="width: 400px; height: 400px;"></div>
          </el-card>
        </el-col>


        <el-col :span="8">
          <el-card class="card1" style="margin-right: 0">
            <div slot="header"><span class="chartTitle">商品推荐</span></div>
            <div ref="topChart" class="card-img"  style="width: 400px; height: 400px;"></div>
          </el-card>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="8">
          <el-card class="card1">
            <div slot="header"><span class="chartTitle">最近登录情况分布</span></div>
            <div ref="loginCycleChart" class="card-img" style="width: 400px; height: 400px;"></div>
          </el-card>
        </el-col>
        <el-col :span="8">
          <el-card class="card1" style="margin-right: 0">
            <div slot="header"><span class="chartTitle">活跃度分布</span></div>
            <div ref="rfeChart" class="card-img" style="width: 400px; height: 400px;"></div>
          </el-card>
        </el-col>
        <el-col :span="8">
          <el-card class="card1">
            <div slot="header"><span class="chartTitle">每月访问次数分布</span></div>
            <div ref="frequencyChart" class="card-img"  style="width: 400px; height: 400px;"></div>
          </el-card>
        </el-col>
      </el-row>
  </div>
  </div>
</template>

<script>
import {findPreference} from "@/api/tags/preference";
import * as echarts from "echarts";

export default {
  name: "Index",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 初始性别数据，假设有两个性别，初始值为0
      usgData: [],
      frequencyData: [],
      rfeData: [],
      timeSlotData: [],
      loginCycleData: [],
      top1Data: [],
      top2Data: [],
      top3Data: [],
      top4Data: [],
      top5Data: [],
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
      findPreference()
        .then(response => {
          console.log('==================Data:', response.data);
          this.usgData = response.data.usgList;
          this.frequencyData = response.data.frequencyList;
          this.rfeData = response.data.rfeList;
          this.loginCycleData = response.data.loginCycleList;
          this.timeSlotData = response.data.timeSlotList;
          this.top1Data = response.data.top1List;
          this.top2Data = response.data.top2List;
          this.top3Data = response.data.top3List;
          this.top4Data = response.data.top4List;
          this.top5Data = response.data.top5List;

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

    drawCharts() {
      this.drawPieChart('usgChart', '购物性别', this.usgData, ['男', '女']);
      this.drawHistogram('frequencyChart', '每月消费次数', this.frequencyData);
      this.drawPieChart('loginCycleChart', '最近登录', this.loginCycleData, ['1天内', '7天内', '14天内', '30天内', '一个月前']);
      this.drawRoseChart('rfeChart', '活跃度', this.rfeData, ['非常活跃', '活跃', '不活跃', '非常不活跃']);
      this.drawRoseChart('timeSlotChart', '活跃度', this.timeSlotData, ['早晨', '上午','中午', '下午', '傍晚', '凌晨']);
      this.drawBarChart('topChart', '商品推荐', this.top1Data, this.top2Data, this.top3Data, this.top4Data, this.top5Data);
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
            data: labels.map((label, index) => ({value: data[index], name: label}))
          }
        ]
      };
      myChart.setOption(option) // 设置图表配置选项
    },

    drawBarChart(chartId, chartTitle, data1, data2, data3, data4, data5) {
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
        grid:{
          right:80
        },
        xAxis: {
          name: '编号',
          data: [6603, 10935, 9371, 6395, 11949],
        },
        yAxis: {
          name: '商品热度',
          type: 'value',
          axisLine: {
            show: true // 不显示坐标轴线
          },
        },
        series: [{
          data: [9789, 8423, 6999, 5426, 2563],
          type: 'bar'
        }]
      };
      myChart.setOption(option);
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
          data: labels.map((label, index) => ({value: data[index], name: label}))
        }
      ]
    };

    myChart.setOption(option); // 将配置选项应用到图表中
  },

  // ============================直方图=========================
  drawHistogram(chartId, chartTitle, data) {
    const chartDom = this.$refs[chartId]; // 获取图表容器的 DOM 元素
    const myChart = echarts.init(chartDom); // 初始化 ECharts 实例

    const minValue = Math.min(...data);
    const maxValue = Math.max(...data);

    const interval = 10;
    const binCount = Math.ceil((maxValue - minValue) / interval);

    console.log("========max:", maxValue);
    console.log("========min:", minValue);
    console.log("========interval:", interval);
    console.log("========binCount:", binCount);

    const histogramData = new Array(binCount).fill(0);
    for (const value of data) {
      const binIndex = Math.floor((value - minValue) / interval);
      histogramData[binIndex]++;
    }

    const xAxisData = [];
    for (let i = 0; i < binCount; i++) {
      xAxisData.push(`${minValue + i * interval}-${minValue + (i + 1) * interval}`);
    }

    const option = {
      // title: {
      //   text: chartTitle
      // },
      tooltip: {
        trigger: 'item',
        formatter: '访问次数 <br/>{b} : {c}'
      },

      xAxis: {
        type: 'category',
        data: xAxisData,
        name: '访问次数'
      },
      yAxis: {
        type: 'value',
        max: 220,
        interval: 20,
        name: '人数',
        axisLine: {
          show: true // 不显示坐标轴线
        },
      },
      series: [{
        data: histogramData,
        type: 'bar'
      }]
    };

    myChart.setOption(option); // 将配置选项应用到图表中
  },

  getMedian(data) {
    const sortedData = data.slice().sort((a, b) => a - b);
    const len = sortedData.length;
    const middleIndex = Math.floor(len / 2);
    if (len % 2 === 0) {
      return (sortedData[middleIndex - 1] + sortedData[middleIndex]) / 2;
    } else {
      return sortedData[middleIndex];
    }
  },

  getQuartile(data, percentile) {
    const sortedData = data.slice().sort((a, b) => a - b);
    const len = sortedData.length;
    const index = Math.floor(len * percentile);
    return sortedData[index];
  },
}
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
