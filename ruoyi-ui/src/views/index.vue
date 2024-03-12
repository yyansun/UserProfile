<template>
  <div class="app-container">
    <el-row>
      <el-col :span="12">
        <el-card class="box">
          <div slot="header">Top Left</div>
          Content for Top Left Section
        </el-card>
      </el-col>
      <el-col :span="12">
        <el-card class="box">
          <div slot="header">Top Right</div>
          Content for Top Right Section
        </el-card>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="12">
        <el-card class="box">
          <div slot="header">Bottom Left</div>
          Content for Bottom Left Section
        </el-card>
      </el-col>
      <el-col :span="12">
        <el-card class="box">
          <div slot="header">Bottom Right</div>
          Content for Bottom Right Section
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<style>
  .box {
    margin: 20px;
  }
</style>
