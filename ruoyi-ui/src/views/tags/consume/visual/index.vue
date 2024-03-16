<template>
  <div class="app-container" style="margin-left: 20px; margin-right: 20px">
    <div class="flex-container">
      <el-row>
        <el-col :span="8">
          <router-link to="visual">
            <el-card @click="handleJump()" class="card1">
              <div slot="header"><span class="chartTitle">消费次数分布</span></div>
              <div ref="frequencyChart" class="card-img" style="width: 350px; height: 350px;"></div>
            </el-card>
          </router-link>

        </el-col>
        <el-col :span="8">
          <el-card class="card1">
            <div slot="header"><span class="chartTitle">客单价分布</span></div>
            <div ref="unitPriceChart" class="card-img"  style="width: 350px; height: 350px;"></div>
          </el-card>
        </el-col>

        <el-col :span="8">
          <el-card class="card1" style="margin-right: 0">
            <div slot="header"><span class="chartTitle">Rfm分布</span></div>
            <div ref="rfmChart" class="card-img"  style="width: 500px; height: 350px;"></div>
          </el-card>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="8">
          <el-card class="card1">
            <div slot="header"><span class="chartTitle">支付方式\黑名单分布</span></div>
            <div ref="twoPieChart" class="card-img" style="width: 400px; height: 400px;"></div>
          </el-card>
        </el-col>
        <el-col :span="8">
          <el-card class="card1">
            <div slot="header"><span class="chartTitle">散点图分布</span></div>
            <div ref="scatterChart" class="card-img" style="width: 400px; height: 400px;"></div>
          </el-card>
        </el-col>
        <el-col :span="8">
          <el-card class="card1" style="margin-right: 0">
            <div slot="header"><span class="chartTitle">Psm分布</span></div>
            <div ref="psmChart" class="card-img" style="width: 400px; height: 400px;"></div>
          </el-card>
        </el-col>
      </el-row>
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
      blackData: [],
      payment: [],
      rfmData: [],
      psmData: [],
      frequencyData: [],
      unitPriceData: [],
      marriageData: [],
      politicalFaceData: [],
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
      findData()
        .then(response => {
          console.log('==================Data:', response.data);
          this.frequencyData = response.data.frequencyList;
          this.allUnitPriceData = response.data.allUnitPriceList;
          this.allMaxOrderAmountData = response.data.allMaxOrderAmountList;
          this.rfmData = response.data.rfmList;
          this.marriageData = response.data.marriageList;
          this.politicalFaceData = response.data.politicalFaceList;
          this.psmData = response.data.psmList;
          this.paymentData = response.data.paymentList;

          console.log("#############rfmData:", this.rfmData);

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
      this.drawHistogram('frequencyChart', '', this.frequencyData, ['1', '2', '3', '4']);
      this.drawBoxPlot('unitPriceChart', '', this.allUnitPriceData, []);
      this.drawScatterPlot('scatterChart', '',[this.allMaxOrderAmountData, this.allUnitPriceData])
      this.drawTwoPie('twoPieChart', '', this.paymentData, this.blackData);
      // this.drawPieChart('regionChart', '所属地区', this.regionData, ['中国大陆']);
      // this.drawRoundedRingChart('faceChart', '政治面貌', this.politicalFaceData, ['群众', '党员', '无党派人士']);
      this.drawRoseChart('psmChart', 'PSM', this.psmData, ['军人', '白领','学生','公务员','警察','教师']);
      this.drawRoseChart('rfmChart', 'RFM', this.rfmData, ['00后', '80后','70后','90后', '22']);
    },

    drawScatterPlot(chartId, chartTitle, data) {
      const chartDom = this.$refs[chartId] // 获取图表容器
      const myChart = echarts.init(chartDom) // 初始化图表

      const option = {
        title: {
          text: chartTitle
        },
        xAxis: {},
        yAxis: {},
        series: [{
          symbolSize: 20, // 设置散点大小
          data: data,
          type: 'scatter'
        }]
      };

      myChart.setOption(option); // 将配置选项应用到图表中
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

    drawTwoPie(chartId, chartTitle, data1, data2) {
      const chartDom = this.$refs[chartId]; // 获取图表容器的DOM元素
      const myChart = echarts.init(chartDom); // 初始化echarts实例
      const option = {
        title: {
          text: '两个环状图合在一起',
          subtext: '示例',
          left: 'center'
        },
        series: [
          {
            name: '图例1',
            type: 'pie',
            radius: ['20%', '30%'],
            center: ['25%', '50%'],
            label: {
              position: 'inner'
            },
            data: data1
          },
          {
            name: '图例2',
            type: 'pie',
            radius: ['40%', '55%'],
            center: ['25%', '50%'],
            label: {
              position: 'outer'
            },
            data: data2
          }
        ]
      };
      // 使用刚指定的配置项和数据显示图表。
      myChart.setOption(option)
    },

    drawHistogram(chartId, chartTitle, data, labels) {
      const chartDom = this.$refs[chartId]; // 获取图表容器的 DOM 元素
      const myChart = echarts.init(chartDom); // 初始化 ECharts 实例
      const option = {
        title: {
          text: chartTitle
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

      myChart.setOption(option); // 将配置选项应用到图表中
    },

    drawBoxPlot(chartId, chartTitle, data, labels) {
      const chartDom = this.$refs[chartId];// 获取图表容器的DOM元素
      const myChart = echarts.init(chartDom); // 初始化echarts实例

      const option = {
        title: {
          text: chartTitle
        },
        tooltip: {
          trigger: 'item',
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
          type: 'boxplot',
          data: data
        }]
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

    // drawScatterChart(chartId, chartTitle, data, lables) {
    //
    // }

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
