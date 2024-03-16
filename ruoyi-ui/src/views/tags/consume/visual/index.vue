<template>
  <div class="app-container" style="margin-left: 20px; margin-right: 20px">
    <div class="flex-container">
      <el-row>
        <el-col :span="8">
          <router-link to="visual">
            <el-card @click="handleJump()" class="card1">
              <div slot="header"><span class="chartTitle">每月消费次数分布</span></div>
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
            <div slot="header"><span class="chartTitle">用户消费能力分布</span></div>
            <div ref="rfmChart" class="card-img"  style="width: 500px; height: 350px;"></div>
          </el-card>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="8">
          <el-card class="card1">
            <div slot="header"><span class="chartTitle">支付方式</span></div>
            <div ref="pieChart" class="card-img" style="width: 400px; height: 400px;"></div>
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
            <div slot="header"><span class="chartTitle">用户价格敏感度分布</span></div>
            <div ref="psmChart" class="card-img" style="width: 400px; height: 400px;"></div>
          </el-card>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
import {findConsume} from "@/api/tags/consume";
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
      findConsume()
        .then(response => {
          console.log('==================Data:', response.data);
          this.allFrequencyData = response.data.allFrequencyList;
          this.allUnitPriceData = response.data.allUnitPriceList;
          this.allMaxOrderAmountData = response.data.allMaxOrderAmountList;
          this.rfmData = response.data.rfmList.sort();
          this.psmData = response.data.psmList.sort();
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
      this.drawHistogram('frequencyChart', '每月消费次数', this.allFrequencyData);
      this.drawBoxPlot('unitPriceChart', '', this.allUnitPriceData, []);
      this.drawScatterPlot('scatterChart', '',this.allUnitPriceData, this.allMaxOrderAmountData);
      this.drawPieChart('pieChart', '支付方式', this.paymentData, ['支付宝']);
      // this.drawPieChart('regionChart', '所属地区', this.regionData, ['中国大陆']);
      // this.drawRoundedRingChart('faceChart', '政治面貌', this.politicalFaceData, ['群众', '党员', '无党派人士']);
      this.drawRoseChart('psmChart', '用户价格敏感度', this.psmData, ['极度敏感', '极度不敏感','一般敏感','不太敏感','比较敏感']);
      this.drawRoseChart('rfmChart', '用户消费能力', this.rfmData, ['中', '中下','中上','低', '高']);
    },

    drawScatterPlot(chartId, chartTitle, data1, data2) {
      const chartDom = this.$refs[chartId] // 获取图表容器
      const myChart = echarts.init(chartDom) // 初始化图表

      const combinedData = data1.map((item, index) => [item, data2[index]]);

      console.log("filter data = ", combinedData);

      const option = {
        title: {
          text: chartTitle
        },
        xAxis: {
          min: 0,
          data: data2,
          // min: 0,
          // max: 140000,
          // interval: 20000,
        },
        yAxis: {
          min: 1000,
          max: 4000,
          interval: 500,
        },
        series: [{
          symbolSize: 5, // 设置散点大小
          data: data1,
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
      //   title: {
      //     left: 'center'
      //   },


        series: [
          {
            name: '黑白名单',
            type: 'pie',
            radius: ['20%', '30%'],
            center: ['25%', '50%'],
            label: {
              position: 'inner'
            },
            data: data1,
            itemStyle: {
              color: '#ff7f50', // 设置第一个环的颜色为橙色
            }
          },
          {
            name: '支付方式',
            type: 'pie',
            radius: ['40%', '55%'],
            center: ['25%', '50%'],
            label: {
              position: 'outer'
            },
            data: data2,
            itemStyle: {
              color: '#87ceeb', // 设置第二个环的颜色为天蓝色
            },
            emphasis: {
              itemStyle: {
                color: '#87ceeb' // 设置鼠标悬停时外环的颜色为天蓝色
              }
            }
          }
        ]
      };
      // 使用刚指定的配置项和数据显示图表。
      myChart.setOption(option)
    },

    // ============================直方图=========================
    drawHistogram(chartId, chartTitle, data) {
      const chartDom = this.$refs[chartId]; // 获取图表容器的 DOM 元素
      const myChart = echarts.init(chartDom); // 初始化 ECharts 实例

      const minValue = 10;
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
          formatter: '消费次数 <br/>{b} : {c}'
        },

        xAxis: {
          type: 'category',
          data: xAxisData,
          name: '消费次数'
        },
        yAxis: {
          type: 'value',
          max: 550,
          interval: 50,
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

    // ====================箱线图=====================
    drawBoxPlot(chartId, chartTitle, data, labels) {
      const chartDom = this.$refs[chartId];// 获取图表容器的DOM元素
      const myChart = echarts.init(chartDom); // 初始化echarts实例

      const minValue = Math.min(...data);
      const maxValue = Math.max(...data);
      const median = this.getMedian(data);
      const quartile1 = this.getQuartile(data, 0.25);
      const quartile3 = this.getQuartile(data, 0.75);

      console.log("min = ", minValue);
      console.log("max = ", maxValue);
      console.log("median = ", median);
      console.log("quartile1 = ", quartile1);
      console.log("quartile3 = ", quartile3);


      const boxplotData = [
        [minValue, quartile1, median, quartile3, maxValue]
      ];

      console.log("all data =  ", boxplotData);

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
          data: ['订单价钱']
        },
        yAxis: {
          type: 'value',
          name: '价钱',
          axisLine: {
            show: true // 显示纵轴轴线
          }
        },
        series: [{
          type: 'boxplot',
          data: boxplotData,
          itemStyle: {
            borderWidth: 5, // 调整箱线图线条粗细
            // borderColor: [84, 112, 198] // 线条颜色
          },
          emphasis: {
            itemStyle: {
              borderWidth: 3, // 鼠标悬停时线条粗细
              borderColor: [84, 112, 198]
            }
          }
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
