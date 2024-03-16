<template>
  <div class="app-container" style="margin-left: 20px; margin-right: 20px">

  </div>
</template>

<script>
import {findBy} from "@/api/tags/preference";
import * as echarts from "echarts";

export default {
  name:"Index",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 初始性别数据，假设有两个性别，初始值为0
      blackData: [],
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
      findBy()
        .then(response => {
          console.log('==================Data:', response.data);
          // this.allFrequencyData = response.data.allFrequencyList;
          // this.allUnitPriceData = response.data.allUnitPriceList;
          // this.allMaxOrderAmountData = response.data.allMaxOrderAmountList;
          // this.rfmData = response.data.rfmList.sort();
          // this.psmData = response.data.psmList.sort();
          // this.paymentData = response.data.paymentList;
          //
          // console.log("#############rfmData:", this.rfmData);

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
