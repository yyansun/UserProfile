<!--<template>-->
<!--  <div class="container">-->
<!--    <div class="left-board">-->
<!--      <div class="logo-wrapper">-->
<!--        <div class="logo">-->
<!--          <img :src="logo" alt="logo"> Form Generator-->
<!--        </div>-->
<!--      </div>-->
<!--      <el-scrollbar class="left-scrollbar">-->
<!--        <div class="components-list">-->
<!--          <div class="components-title">-->
<!--            <svg-icon icon-class="component" />输入型组件-->
<!--          </div>-->
<!--          <draggable-->
<!--            class="components-draggable"-->
<!--            :list="inputComponents"-->
<!--            :group="{ name: 'componentsGroup', pull: 'clone', put: false }"-->
<!--            :clone="cloneComponent"-->
<!--            draggable=".components-item"-->
<!--            :sort="false"-->
<!--            @end="onEnd"-->
<!--          >-->
<!--            <div-->
<!--              v-for="(element, index) in inputComponents" :key="index" class="components-item"-->
<!--              @click="addComponent(element)"-->
<!--            >-->
<!--              <div class="components-body">-->
<!--                <svg-icon :icon-class="element.tagIcon" />-->
<!--                {{ element.label }}-->
<!--              </div>-->
<!--            </div>-->
<!--          </draggable>-->
<!--          <div class="components-title">-->
<!--            <svg-icon icon-class="component" />选择型组件-->
<!--          </div>-->
<!--          <draggable-->
<!--            class="components-draggable"-->
<!--            :list="selectComponents"-->
<!--            :group="{ name: 'componentsGroup', pull: 'clone', put: false }"-->
<!--            :clone="cloneComponent"-->
<!--            draggable=".components-item"-->
<!--            :sort="false"-->
<!--            @end="onEnd"-->
<!--          >-->
<!--            <div-->
<!--              v-for="(element, index) in selectComponents"-->
<!--              :key="index"-->
<!--              class="components-item"-->
<!--              @click="addComponent(element)"-->
<!--            >-->
<!--              <div class="components-body">-->
<!--                <svg-icon :icon-class="element.tagIcon" />-->
<!--                {{ element.label }}-->
<!--              </div>-->
<!--            </div>-->
<!--          </draggable>-->
<!--          <div class="components-title">-->
<!--            <svg-icon icon-class="component" /> 布局型组件-->
<!--          </div>-->
<!--          <draggable-->
<!--            class="components-draggable" :list="layoutComponents"-->
<!--            :group="{ name: 'componentsGroup', pull: 'clone', put: false }" :clone="cloneComponent"-->
<!--            draggable=".components-item" :sort="false" @end="onEnd"-->
<!--          >-->
<!--            <div-->
<!--              v-for="(element, index) in layoutComponents" :key="index" class="components-item"-->
<!--              @click="addComponent(element)"-->
<!--            >-->
<!--              <div class="components-body">-->
<!--                <svg-icon :icon-class="element.tagIcon" />-->
<!--                {{ element.label }}-->
<!--              </div>-->
<!--            </div>-->
<!--          </draggable>-->
<!--        </div>-->
<!--      </el-scrollbar>-->
<!--    </div>-->

<!--    <div class="center-board">-->
<!--      <div class="action-bar">-->
<!--        <el-button icon="el-icon-download" type="text" @click="download">-->
<!--          导出vue文件-->
<!--        </el-button>-->
<!--        <el-button class="copy-btn-main" icon="el-icon-document-copy" type="text" @click="copy">-->
<!--          复制代码-->
<!--        </el-button>-->
<!--        <el-button class="delete-btn" icon="el-icon-delete" type="text" @click="empty">-->
<!--          清空-->
<!--        </el-button>-->
<!--      </div>-->
<!--      <el-scrollbar class="center-scrollbar">-->
<!--        <el-row class="center-board-row" :gutter="formConf.gutter">-->
<!--          <el-form-->
<!--            :size="formConf.size"-->
<!--            :label-position="formConf.labelPosition"-->
<!--            :disabled="formConf.disabled"-->
<!--            :label-width="formConf.labelWidth + 'px'"-->
<!--          >-->
<!--            <draggable class="drawing-board" :list="drawingList" :animation="340" group="componentsGroup">-->
<!--              <draggable-item-->
<!--                v-for="(element, index) in drawingList"-->
<!--                :key="element.renderKey"-->
<!--                :drawing-list="drawingList"-->
<!--                :element="element"-->
<!--                :index="index"-->
<!--                :active-id="activeId"-->
<!--                :form-conf="formConf"-->
<!--                @activeItem="activeFormItem"-->
<!--                @copyItem="drawingItemCopy"-->
<!--                @deleteItem="drawingItemDelete"-->
<!--              />-->
<!--            </draggable>-->
<!--            <div v-show="!drawingList.length" class="empty-info">-->
<!--              从左侧拖入或点选组件进行表单设计-->
<!--            </div>-->
<!--          </el-form>-->
<!--        </el-row>-->
<!--      </el-scrollbar>-->
<!--    </div>-->

<!--    <right-panel-->
<!--      :active-data="activeData"-->
<!--      :form-conf="formConf"-->
<!--      :show-field="!!drawingList.length"-->
<!--      @tag-change="tagChange"-->
<!--    />-->

<!--    <code-type-dialog-->
<!--      :visible.sync="dialogVisible"-->
<!--      title="选择生成类型"-->
<!--      :show-file-name="showFileName"-->
<!--      @confirm="generate"-->
<!--    />-->
<!--    <input id="copyNode" type="hidden">-->
<!--  </div>-->
<!--</template>-->

<!--<script>-->
<!--import draggable from 'vuedraggable'-->
<!--import beautifier from 'js-beautify'-->
<!--import ClipboardJS from 'clipboard'-->
<!--import render from '@/utils/generator/render'-->
<!--import RightPanel from './RightPanel'-->
<!--import { inputComponents, selectComponents, layoutComponents, formConf } from '@/utils/generator/config'-->
<!--import { beautifierConf, titleCase } from '@/utils/index'-->
<!--import { makeUpHtml, vueTemplate, vueScript, cssStyle } from '@/utils/generator/html'-->
<!--import { makeUpJs } from '@/utils/generator/js'-->
<!--import { makeUpCss } from '@/utils/generator/css'-->
<!--import drawingDefault from '@/utils/generator/drawingDefault'-->
<!--import logo from '@/assets/logo/logo.png'-->
<!--import CodeTypeDialog from './CodeTypeDialog'-->
<!--import DraggableItem from './DraggableItem'-->

<!--let oldActiveId-->
<!--let tempActiveData-->

<!--export default {-->
<!--  components: {-->
<!--    draggable,-->
<!--    render,-->
<!--    RightPanel,-->
<!--    CodeTypeDialog,-->
<!--    DraggableItem-->
<!--  },-->
<!--  data() {-->
<!--    return {-->
<!--      logo,-->
<!--      idGlobal: 100,-->
<!--      formConf,-->
<!--      inputComponents,-->
<!--      selectComponents,-->
<!--      layoutComponents,-->
<!--      labelWidth: 100,-->
<!--      drawingList: drawingDefault,-->
<!--      drawingData: {},-->
<!--      activeId: drawingDefault[0].formId,-->
<!--      drawerVisible: false,-->
<!--      formData: {},-->
<!--      dialogVisible: false,-->
<!--      generateConf: null,-->
<!--      showFileName: false,-->
<!--      activeData: drawingDefault[0]-->
<!--    }-->
<!--  },-->
<!--  created() {-->
<!--    // 防止 firefox 下 拖拽 会新打卡一个选项卡-->
<!--    document.body.ondrop = event => {-->
<!--      event.preventDefault()-->
<!--      event.stopPropagation()-->
<!--    }-->
<!--  },-->
<!--  watch: {-->
<!--    // eslint-disable-next-line func-names-->
<!--    'activeData.label': function (val, oldVal) {-->
<!--      if (-->
<!--        this.activeData.placeholder === undefined-->
<!--        || !this.activeData.tag-->
<!--        || oldActiveId !== this.activeId-->
<!--      ) {-->
<!--        return-->
<!--      }-->
<!--      this.activeData.placeholder = this.activeData.placeholder.replace(oldVal, '') + val-->
<!--    },-->
<!--    activeId: {-->
<!--      handler(val) {-->
<!--        oldActiveId = val-->
<!--      },-->
<!--      immediate: true-->
<!--    }-->
<!--  },-->
<!--  mounted() {-->
<!--    const clipboard = new ClipboardJS('#copyNode', {-->
<!--      text: trigger => {-->
<!--        const codeStr = this.generateCode()-->
<!--        this.$notify({-->
<!--          title: '成功',-->
<!--          message: '代码已复制到剪切板，可粘贴。',-->
<!--          type: 'success'-->
<!--        })-->
<!--        return codeStr-->
<!--      }-->
<!--    })-->
<!--    clipboard.on('error', e => {-->
<!--      this.$message.error('代码复制失败')-->
<!--    })-->
<!--  },-->
<!--  methods: {-->
<!--    activeFormItem(element) {-->
<!--      this.activeData = element-->
<!--      this.activeId = element.formId-->
<!--    },-->
<!--    onEnd(obj, a) {-->
<!--      if (obj.from !== obj.to) {-->
<!--        this.activeData = tempActiveData-->
<!--        this.activeId = this.idGlobal-->
<!--      }-->
<!--    },-->
<!--    addComponent(item) {-->
<!--      const clone = this.cloneComponent(item)-->
<!--      this.drawingList.push(clone)-->
<!--      this.activeFormItem(clone)-->
<!--    },-->
<!--    cloneComponent(origin) {-->
<!--      const clone = JSON.parse(JSON.stringify(origin))-->
<!--      clone.formId = ++this.idGlobal-->
<!--      clone.span = formConf.span-->
<!--      clone.renderKey = +new Date() // 改变renderKey后可以实现强制更新组件-->
<!--      if (!clone.layout) clone.layout = 'colFormItem'-->
<!--      if (clone.layout === 'colFormItem') {-->
<!--        clone.vModel = `field${this.idGlobal}`-->
<!--        clone.placeholder !== undefined && (clone.placeholder += clone.label)-->
<!--        tempActiveData = clone-->
<!--      } else if (clone.layout === 'rowFormItem') {-->
<!--        delete clone.label-->
<!--        clone.componentName = `row${this.idGlobal}`-->
<!--        clone.gutter = this.formConf.gutter-->
<!--        tempActiveData = clone-->
<!--      }-->
<!--      return tempActiveData-->
<!--    },-->
<!--    AssembleFormData() {-->
<!--      this.formData = {-->
<!--        fields: JSON.parse(JSON.stringify(this.drawingList)),-->
<!--        ...this.formConf-->
<!--      }-->
<!--    },-->
<!--    generate(data) {-->
<!--      const func = this[`exec${titleCase(this.operationType)}`]-->
<!--      this.generateConf = data-->
<!--      func && func(data)-->
<!--    },-->
<!--    execRun(data) {-->
<!--      this.AssembleFormData()-->
<!--      this.drawerVisible = true-->
<!--    },-->
<!--    execDownload(data) {-->
<!--      const codeStr = this.generateCode()-->
<!--      const blob = new Blob([codeStr], { type: 'text/plain;charset=utf-8' })-->
<!--      this.$download.saveAs(blob, data.fileName)-->
<!--    },-->
<!--    execCopy(data) {-->
<!--      document.getElementById('copyNode').click()-->
<!--    },-->
<!--    empty() {-->
<!--      this.$confirm('确定要清空所有组件吗？', '提示', { type: 'warning' }).then(-->
<!--        () => {-->
<!--          this.drawingList = []-->
<!--        }-->
<!--      )-->
<!--    },-->
<!--    drawingItemCopy(item, parent) {-->
<!--      let clone = JSON.parse(JSON.stringify(item))-->
<!--      clone = this.createIdAndKey(clone)-->
<!--      parent.push(clone)-->
<!--      this.activeFormItem(clone)-->
<!--    },-->
<!--    createIdAndKey(item) {-->
<!--      item.formId = ++this.idGlobal-->
<!--      item.renderKey = +new Date()-->
<!--      if (item.layout === 'colFormItem') {-->
<!--        item.vModel = `field${this.idGlobal}`-->
<!--      } else if (item.layout === 'rowFormItem') {-->
<!--        item.componentName = `row${this.idGlobal}`-->
<!--      }-->
<!--      if (Array.isArray(item.children)) {-->
<!--        item.children = item.children.map(childItem => this.createIdAndKey(childItem))-->
<!--      }-->
<!--      return item-->
<!--    },-->
<!--    drawingItemDelete(index, parent) {-->
<!--      parent.splice(index, 1)-->
<!--      this.$nextTick(() => {-->
<!--        const len = this.drawingList.length-->
<!--        if (len) {-->
<!--          this.activeFormItem(this.drawingList[len - 1])-->
<!--        }-->
<!--      })-->
<!--    },-->
<!--    generateCode() {-->
<!--      const { type } = this.generateConf-->
<!--      this.AssembleFormData()-->
<!--      const script = vueScript(makeUpJs(this.formData, type))-->
<!--      const html = vueTemplate(makeUpHtml(this.formData, type))-->
<!--      const css = cssStyle(makeUpCss(this.formData))-->
<!--      return beautifier.html(html + script + css, beautifierConf.html)-->
<!--    },-->
<!--    download() {-->
<!--      this.dialogVisible = true-->
<!--      this.showFileName = true-->
<!--      this.operationType = 'download'-->
<!--    },-->
<!--    run() {-->
<!--      this.dialogVisible = true-->
<!--      this.showFileName = false-->
<!--      this.operationType = 'run'-->
<!--    },-->
<!--    copy() {-->
<!--      this.dialogVisible = true-->
<!--      this.showFileName = false-->
<!--      this.operationType = 'copy'-->
<!--    },-->
<!--    tagChange(newTag) {-->
<!--      newTag = this.cloneComponent(newTag)-->
<!--      newTag.vModel = this.activeData.vModel-->
<!--      newTag.formId = this.activeId-->
<!--      newTag.span = this.activeData.span-->
<!--      delete this.activeData.tag-->
<!--      delete this.activeData.tagIcon-->
<!--      delete this.activeData.document-->
<!--      Object.keys(newTag).forEach(key => {-->
<!--        if (this.activeData[key] !== undefined-->
<!--          && typeof this.activeData[key] === typeof newTag[key]) {-->
<!--          newTag[key] = this.activeData[key]-->
<!--        }-->
<!--      })-->
<!--      this.activeData = newTag-->
<!--      this.updateDrawingList(newTag, this.drawingList)-->
<!--    },-->
<!--    updateDrawingList(newTag, list) {-->
<!--      const index = list.findIndex(item => item.formId === this.activeId)-->
<!--      if (index > -1) {-->
<!--        list.splice(index, 1, newTag)-->
<!--      } else {-->
<!--        list.forEach(item => {-->
<!--          if (Array.isArray(item.children)) this.updateDrawingList(newTag, item.children)-->
<!--        })-->
<!--      }-->
<!--    }-->
<!--  }-->
<!--}-->
<!--</script>-->

<!--<style lang='scss'>-->
<!--.editor-tabs{-->
<!--  background: #121315;-->
<!--  .el-tabs__header{-->
<!--    margin: 0;-->
<!--    border-bottom-color: #121315;-->
<!--    .el-tabs__nav{-->
<!--      border-color: #121315;-->
<!--    }-->
<!--  }-->
<!--  .el-tabs__item{-->
<!--    height: 32px;-->
<!--    line-height: 32px;-->
<!--    color: #888a8e;-->
<!--    border-left: 1px solid #121315 !important;-->
<!--    background: #363636;-->
<!--    margin-right: 5px;-->
<!--    user-select: none;-->
<!--  }-->
<!--  .el-tabs__item.is-active{-->
<!--    background: #1e1e1e;-->
<!--    border-bottom-color: #1e1e1e!important;-->
<!--    color: #fff;-->
<!--  }-->
<!--  .el-icon-edit{-->
<!--    color: #f1fa8c;-->
<!--  }-->
<!--  .el-icon-document{-->
<!--    color: #a95812;-->
<!--  }-->
<!--}-->

<!--// home-->
<!--.right-scrollbar {-->
<!--  .el-scrollbar__view {-->
<!--    padding: 12px 18px 15px 15px;-->
<!--  }-->
<!--}-->
<!--.left-scrollbar .el-scrollbar__wrap {-->
<!--  box-sizing: border-box;-->
<!--  overflow-x: hidden !important;-->
<!--  margin-bottom: 0 !important;-->
<!--}-->
<!--.center-tabs{-->
<!--  .el-tabs__header{-->
<!--    margin-bottom: 0!important;-->
<!--  }-->
<!--  .el-tabs__item{-->
<!--    width: 50%;-->
<!--    text-align: center;-->
<!--  }-->
<!--  .el-tabs__nav{-->
<!--    width: 100%;-->
<!--  }-->
<!--}-->
<!--.reg-item{-->
<!--  padding: 12px 6px;-->
<!--  background: #f8f8f8;-->
<!--  position: relative;-->
<!--  border-radius: 4px;-->
<!--  .close-btn{-->
<!--    position: absolute;-->
<!--    right: -6px;-->
<!--    top: -6px;-->
<!--    display: block;-->
<!--    width: 16px;-->
<!--    height: 16px;-->
<!--    line-height: 16px;-->
<!--    background: rgba(0, 0, 0, 0.2);-->
<!--    border-radius: 50%;-->
<!--    color: #fff;-->
<!--    text-align: center;-->
<!--    z-index: 1;-->
<!--    cursor: pointer;-->
<!--    font-size: 12px;-->
<!--    &:hover{-->
<!--      background: rgba(210, 23, 23, 0.5)-->
<!--    }-->
<!--  }-->
<!--  & + .reg-item{-->
<!--    margin-top: 18px;-->
<!--  }-->
<!--}-->
<!--.action-bar{-->
<!--  & .el-button+.el-button {-->
<!--    margin-left: 15px;-->
<!--  }-->
<!--  & i {-->
<!--    font-size: 20px;-->
<!--    vertical-align: middle;-->
<!--    position: relative;-->
<!--    top: -1px;-->
<!--  }-->
<!--}-->

<!--.custom-tree-node{-->
<!--  width: 100%;-->
<!--  font-size: 14px;-->
<!--  .node-operation{-->
<!--    float: right;-->
<!--  }-->
<!--  i[class*="el-icon"] + i[class*="el-icon"]{-->
<!--    margin-left: 6px;-->
<!--  }-->
<!--  .el-icon-plus{-->
<!--    color: #409EFF;-->
<!--  }-->
<!--  .el-icon-delete{-->
<!--    color: #157a0c;-->
<!--  }-->
<!--}-->

<!--.left-scrollbar .el-scrollbar__view{-->
<!--  overflow-x: hidden;-->
<!--}-->

<!--.el-rate{-->
<!--  display: inline-block;-->
<!--  vertical-align: text-top;-->
<!--}-->
<!--.el-upload__tip{-->
<!--  line-height: 1.2;-->
<!--}-->

<!--$selectedColor: #f6f7ff;-->
<!--$lighterBlue: #409EFF;-->

<!--.container {-->
<!--  position: relative;-->
<!--  width: 100%;-->
<!--  height: 100%;-->
<!--}-->

<!--.components-list {-->
<!--  padding: 8px;-->
<!--  box-sizing: border-box;-->
<!--  height: 100%;-->
<!--  .components-item {-->
<!--    display: inline-block;-->
<!--    width: 48%;-->
<!--    margin: 1%;-->
<!--    transition: transform 0ms !important;-->
<!--  }-->
<!--}-->
<!--.components-draggable{-->
<!--  padding-bottom: 20px;-->
<!--}-->
<!--.components-title{-->
<!--  font-size: 14px;-->
<!--  color: #222;-->
<!--  margin: 6px 2px;-->
<!--  .svg-icon{-->
<!--    color: #666;-->
<!--    font-size: 18px;-->
<!--  }-->
<!--}-->

<!--.components-body {-->
<!--  padding: 8px 10px;-->
<!--  background: $selectedColor;-->
<!--  font-size: 12px;-->
<!--  cursor: move;-->
<!--  border: 1px dashed $selectedColor;-->
<!--  border-radius: 3px;-->
<!--  .svg-icon{-->
<!--    color: #777;-->
<!--    font-size: 15px;-->
<!--  }-->
<!--  &:hover {-->
<!--    border: 1px dashed #787be8;-->
<!--    color: #787be8;-->
<!--    .svg-icon {-->
<!--      color: #787be8;-->
<!--    }-->
<!--  }-->
<!--}-->

<!--.left-board {-->
<!--  width: 260px;-->
<!--  position: absolute;-->
<!--  left: 0;-->
<!--  top: 0;-->
<!--  height: 100vh;-->
<!--}-->
<!--.left-scrollbar{-->
<!--  height: calc(100vh - 42px);-->
<!--  overflow: hidden;-->
<!--}-->
<!--.center-scrollbar {-->
<!--  height: calc(100vh - 42px);-->
<!--  overflow: hidden;-->
<!--  border-left: 1px solid #f1e8e8;-->
<!--  border-right: 1px solid #f1e8e8;-->
<!--  box-sizing: border-box;-->
<!--}-->
<!--.center-board {-->
<!--  height: 100vh;-->
<!--  width: auto;-->
<!--  margin: 0 350px 0 260px;-->
<!--  box-sizing: border-box;-->
<!--}-->
<!--.empty-info{-->
<!--  position: absolute;-->
<!--  top: 46%;-->
<!--  left: 0;-->
<!--  right: 0;-->
<!--  text-align: center;-->
<!--  font-size: 18px;-->
<!--  color: #ccb1ea;-->
<!--  letter-spacing: 4px;-->
<!--}-->
<!--.action-bar{-->
<!--  position: relative;-->
<!--  height: 42px;-->
<!--  text-align: right;-->
<!--  padding: 0 15px;-->
<!--  box-sizing: border-box;;-->
<!--  border: 1px solid #f1e8e8;-->
<!--  border-top: none;-->
<!--  border-left: none;-->
<!--  .delete-btn{-->
<!--    color: #F56C6C;-->
<!--  }-->
<!--}-->
<!--.logo-wrapper{-->
<!--  position: relative;-->
<!--  height: 42px;-->
<!--  background: #fff;-->
<!--  border-bottom: 1px solid #f1e8e8;-->
<!--  box-sizing: border-box;-->
<!--}-->
<!--.logo{-->
<!--  position: absolute;-->
<!--  left: 12px;-->
<!--  top: 6px;-->
<!--  line-height: 30px;-->
<!--  color: #00afff;-->
<!--  font-weight: 600;-->
<!--  font-size: 17px;-->
<!--  white-space: nowrap;-->
<!--  > img{-->
<!--    width: 30px;-->
<!--    height: 30px;-->
<!--    vertical-align: top;-->
<!--  }-->
<!--  .github{-->
<!--    display: inline-block;-->
<!--    vertical-align: sub;-->
<!--    margin-left: 15px;-->
<!--    > img{-->
<!--      height: 22px;-->
<!--    }-->
<!--  }-->
<!--}-->

<!--.center-board-row {-->
<!--  padding: 12px 12px 15px 12px;-->
<!--  box-sizing: border-box;-->
<!--  & > .el-form {-->
<!--    // 69 = 12+15+42-->
<!--    height: calc(100vh - 69px);-->
<!--  }-->
<!--}-->
<!--.drawing-board {-->
<!--  height: 100%;-->
<!--  position: relative;-->
<!--  .components-body {-->
<!--    padding: 0;-->
<!--    margin: 0;-->
<!--    font-size: 0;-->
<!--  }-->
<!--  .sortable-ghost {-->
<!--    position: relative;-->
<!--    display: block;-->
<!--    overflow: hidden;-->
<!--    &::before {-->
<!--      content: " ";-->
<!--      position: absolute;-->
<!--      left: 0;-->
<!--      right: 0;-->
<!--      top: 0;-->
<!--      height: 3px;-->
<!--      background: rgb(89, 89, 223);-->
<!--      z-index: 2;-->
<!--    }-->
<!--  }-->
<!--  .components-item.sortable-ghost {-->
<!--    width: 100%;-->
<!--    height: 60px;-->
<!--    background-color: $selectedColor;-->
<!--  }-->
<!--  .active-from-item {-->
<!--    & > .el-form-item{-->
<!--      background: $selectedColor;-->
<!--      border-radius: 6px;-->
<!--    }-->
<!--    & > .drawing-item-copy, & > .drawing-item-delete{-->
<!--      display: initial;-->
<!--    }-->
<!--    & > .component-name{-->
<!--      color: $lighterBlue;-->
<!--    }-->
<!--  }-->
<!--  .el-form-item{-->
<!--    margin-bottom: 15px;-->
<!--  }-->
<!--}-->
<!--.drawing-item{-->
<!--  position: relative;-->
<!--  cursor: move;-->
<!--  &.unfocus-bordered:not(.activeFromItem) > div:first-child  {-->
<!--    border: 1px dashed #ccc;-->
<!--  }-->
<!--  .el-form-item{-->
<!--    padding: 12px 10px;-->
<!--  }-->
<!--}-->
<!--.drawing-row-item{-->
<!--  position: relative;-->
<!--  cursor: move;-->
<!--  box-sizing: border-box;-->
<!--  border: 1px dashed #ccc;-->
<!--  border-radius: 3px;-->
<!--  padding: 0 2px;-->
<!--  margin-bottom: 15px;-->
<!--  .drawing-row-item {-->
<!--    margin-bottom: 2px;-->
<!--  }-->
<!--  .el-col{-->
<!--    margin-top: 22px;-->
<!--  }-->
<!--  .el-form-item{-->
<!--    margin-bottom: 0;-->
<!--  }-->
<!--  .drag-wrapper{-->
<!--    min-height: 80px;-->
<!--  }-->
<!--  &.active-from-item{-->
<!--    border: 1px dashed $lighterBlue;-->
<!--  }-->
<!--  .component-name{-->
<!--    position: absolute;-->
<!--    top: 0;-->
<!--    left: 0;-->
<!--    font-size: 12px;-->
<!--    color: #bbb;-->
<!--    display: inline-block;-->
<!--    padding: 0 6px;-->
<!--  }-->
<!--}-->
<!--.drawing-item, .drawing-row-item{-->
<!--  &:hover {-->
<!--    & > .el-form-item{-->
<!--      background: $selectedColor;-->
<!--      border-radius: 6px;-->
<!--    }-->
<!--    & > .drawing-item-copy, & > .drawing-item-delete{-->
<!--      display: initial;-->
<!--    }-->
<!--  }-->
<!--  & > .drawing-item-copy, & > .drawing-item-delete{-->
<!--    display: none;-->
<!--    position: absolute;-->
<!--    top: -10px;-->
<!--    width: 22px;-->
<!--    height: 22px;-->
<!--    line-height: 22px;-->
<!--    text-align: center;-->
<!--    border-radius: 50%;-->
<!--    font-size: 12px;-->
<!--    border: 1px solid;-->
<!--    cursor: pointer;-->
<!--    z-index: 1;-->
<!--  }-->
<!--  & > .drawing-item-copy{-->
<!--    right: 56px;-->
<!--    border-color: $lighterBlue;-->
<!--    color: $lighterBlue;-->
<!--    background: #fff;-->
<!--    &:hover{-->
<!--      background: $lighterBlue;-->
<!--      color: #fff;-->
<!--    }-->
<!--  }-->
<!--  & > .drawing-item-delete{-->
<!--    right: 24px;-->
<!--    border-color: #F56C6C;-->
<!--    color: #F56C6C;-->
<!--    background: #fff;-->
<!--    &:hover{-->
<!--      background: #F56C6C;-->
<!--      color: #fff;-->
<!--    }-->
<!--  }-->
<!--}-->
<!--</style>-->

<template>
  <div class="app-container">
    <div>
      <el-row>
        <el-col :span="8">
          <el-card class="left-box">
            <div slot="header"><h3>查找用户</h3></div>
<!--            Content for Top Left Section-->
<!--            <el-form>-->
<!--            <el-form-item label="用户名称" prop="userName">-->
<!--              <el-input-->
<!--                v-model="queryParams.userName"-->
<!--                placeholder="请输入用户名称"-->
<!--                clearable-->
<!--                style="width: 240px"-->
<!--                @keyup.enter.native="handleQuery"-->
<!--              />-->
<!--            </el-form-item>-->
<!--            </el-form>-->
<!--            <div>-->
<!--&lt;!&ndash;            <el-form>&ndash;&gt;-->
<!--&lt;!&ndash;              <el-form-item label = "用户名称" prop="userName">&ndash;&gt;-->
<!--&lt;!&ndash;                <el-input&ndash;&gt;-->
<!--&lt;!&ndash;                  placeholder="请输入用户名称"&ndash;&gt;-->
<!--&lt;!&ndash;                />&ndash;&gt;-->
<!--&lt;!&ndash;              </el-form-item>&ndash;&gt;-->
<!--&lt;!&ndash;              <el-form-item label="手机号码" prop="phonenumber">&ndash;&gt;-->
<!--&lt;!&ndash;                <el-input&ndash;&gt;-->
<!--&lt;!&ndash;                  placeholder="请输入手机号码"&ndash;&gt;-->
<!--&lt;!&ndash;                />&ndash;&gt;-->
<!--&lt;!&ndash;              </el-form-item>&ndash;&gt;-->
<!--&lt;!&ndash;            </el-form>&ndash;&gt;-->
<!--              <el-form :model="formData" label-width="80px">-->
<!--                <el-row>-->
<!--                  <el-col :span="20">-->
<!--                    <el-form-item label="用户名称" prop="userName">-->
<!--                      <el-input placeholder="请输入用户名称"></el-input>-->
<!--                    </el-form-item>-->
<!--                  </el-col>-->
<!--                </el-row>-->
<!--                <el-row>-->
<!--                  <el-col :span="20">-->
<!--                    <el-form-item label="联系方式" prop="phonenumber">-->
<!--                      <el-input placeholder="请输入手机号码"></el-input>-->
<!--                    </el-form-item>-->
<!--                  </el-col>-->
<!--                </el-row>-->
<!--              </el-form>-->
<!--                <el-row>-->
<!--                  <el-col>-->
<!--                    <el-button>搜索</el-button>-->
<!--                    <el-button>重置</el-button>-->
<!--                  </el-col>-->
<!--                  <el-col >-->

<!--                  </el-col>-->
<!--                </el-row>-->
<!--            </div>-->
            <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="50px">
              <el-form-item label="用户名称" prop="userName">
                <el-input
                  v-model="queryParams.userName"
                  placeholder="请输入用户名称"
                  clearable
                  style="width: 240px"
                  @keyup.enter.native="handleQuery"
                />
              </el-form-item>
              <el-form-item label="手机号码" prop="phonenumber">
                <el-input
                  v-model="queryParams.phonenumber"
                  placeholder="请输入手机号码"
                  clearable
                  style="width: 240px"
                  @keyup.enter.native="handleQuery"
                />
              </el-form-item>
              <br>
              <el-form-item>
                <el-button type="primary" icon="el-icon-search" size="medium" @click="handleQuery">搜索</el-button>
                <el-button icon="el-icon-refresh" size="medium" @click="resetQuery">重置</el-button>
              </el-form-item>
            </el-form>
          </el-card>
        </el-col>
        <el-col :span="16">
          <el-card class="right-box">
            <div slot="header"><h3>用户个人画像</h3></div>
            Content for Top Right Section
          </el-card>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
import { listUser, getUser, delUser, addUser, updateUser, resetUserPwd, changeUserStatus, deptTreeSelect } from "@/api/system/user";
import { getToken } from "@/utils/auth";
import Treeselect from "@riophae/vue-treeselect";
import "@riophae/vue-treeselect/dist/vue-treeselect.css";

export default {
  name: "User",
  dicts: ['sys_normal_disable', 'sys_user_sex'],
  components: { Treeselect },
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
      // 用户表格数据
      userList: null,
      // 弹出层标题
      title: "",
      // 部门树选项
      deptOptions: undefined,
      // 是否显示弹出层
      open: false,
      // 部门名称
      deptName: undefined,
      // 默认密码
      initPassword: undefined,
      // 日期范围
      dateRange: [],
      // 岗位选项
      postOptions: [],
      // 角色选项
      roleOptions: [],
      // 表单参数
      form: {},
      defaultProps: {
        children: "children",
        label: "label"
      },
      // 用户导入参数
      upload: {
        // 是否显示弹出层（用户导入）
        open: false,
        // 弹出层标题（用户导入）
        title: "",
        // 是否禁用上传
        isUploading: false,
        // 是否更新已经存在的用户数据
        updateSupport: 0,
        // 设置上传的请求头部
        headers: { Authorization: "Bearer " + getToken() },
        // 上传的地址
        url: process.env.VUE_APP_BASE_API + "/system/user/importData"
      },
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        userName: undefined,
        phonenumber: undefined,
        status: undefined,
        deptId: undefined
      },
      // 列信息
      columns: [
        { key: 0, label: `用户编号`, visible: true },
        { key: 1, label: `用户名称`, visible: true },
        { key: 2, label: `用户昵称`, visible: true },
        { key: 3, label: `部门`, visible: true },
        { key: 4, label: `手机号码`, visible: true },
        { key: 5, label: `状态`, visible: true },
        { key: 6, label: `创建时间`, visible: true }
      ],
      // 表单校验
      rules: {
        userName: [
          { required: true, message: "用户名称不能为空", trigger: "blur" },
          { min: 2, max: 20, message: '用户名称长度必须介于 2 和 20 之间', trigger: 'blur' }
        ],
        nickName: [
          { required: true, message: "用户昵称不能为空", trigger: "blur" }
        ],
        password: [
          { required: true, message: "用户密码不能为空", trigger: "blur" },
          { min: 5, max: 20, message: '用户密码长度必须介于 5 和 20 之间', trigger: 'blur' },
          { pattern: /^[^<>"'|\\]+$/, message: "不能包含非法字符：< > \" ' \\\ |", trigger: "blur" }
        ],
        email: [
          {
            type: "email",
            message: "请输入正确的邮箱地址",
            trigger: ["blur", "change"]
          }
        ],
        phonenumber: [
          {
            pattern: /^1[3|4|5|6|7|8|9][0-9]\d{8}$/,
            message: "请输入正确的手机号码",
            trigger: "blur"
          }
        ]
      }
    };
  },
  watch: {
    // 根据名称筛选部门树
    deptName(val) {
      this.$refs.tree.filter(val);
    }
  },
  created() {
    this.getList();
    this.getDeptTree();
    this.getConfigKey("sys.user.initPassword").then(response => {
      this.initPassword = response.msg;
    });
  },
  methods: {
    /** 查询用户列表 */
    getList() {
      this.loading = true;
      listUser(this.addDateRange(this.queryParams, this.dateRange)).then(response => {
          this.userList = response.rows;
          this.total = response.total;
          this.loading = false;
        }
      );
    },
    /** 查询部门下拉树结构 */
    getDeptTree() {
      deptTreeSelect().then(response => {
        this.deptOptions = response.data;
      });
    },
    // 筛选节点
    filterNode(value, data) {
      if (!value) return true;
      return data.label.indexOf(value) !== -1;
    },
    // 节点单击事件
    handleNodeClick(data) {
      this.queryParams.deptId = data.id;
      this.handleQuery();
    },
    // // 用户状态修改
    // handleStatusChange(row) {
    //   let text = row.status === "0" ? "启用" : "停用";
    //   this.$modal.confirm('确认要"' + text + '""' + row.userName + '"用户吗？').then(function() {
    //     return changeUserStatus(row.userId, row.status);
    //   }).then(() => {
    //     this.$modal.msgSuccess(text + "成功");
    //   }).catch(function() {
    //     row.status = row.status === "0" ? "1" : "0";
    //   });
    // },
    // 取消按钮
    // cancel() {
    //   this.open = false;
    //   this.reset();
    // },
    // 表单重置
    reset() {
      this.form = {
        // userId: undefined,
        // deptId: undefined,
        userName: undefined,
        nickName: undefined,
        password: undefined,
        phonenumber: undefined,
        // email: undefined,
        // sex: undefined,
        // status: "0",
        // remark: undefined,
        postIds: [],
        roleIds: []
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
      this.dateRange = [];
      this.resetForm("queryForm");
      this.queryParams.deptId = undefined;
      this.$refs.tree.setCurrentKey(null);
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.userId);
      this.single = selection.length != 1;
      this.multiple = !selection.length;
    },
    // 更多操作触发
    handleCommand(command, row) {
      switch (command) {
        case "handleResetPwd":
          this.handleResetPwd(row);
          break;
        case "handleAuthRole":
          this.handleAuthRole(row);
          break;
        default:
          break;
      }
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      getUser().then(response => {
        this.postOptions = response.posts;
        this.roleOptions = response.roles;
        this.open = true;
        this.title = "添加用户";
        this.form.password = this.initPassword;
      });
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const userId = row.userId || this.ids;
      getUser(userId).then(response => {
        this.form = response.data;
        this.postOptions = response.posts;
        this.roleOptions = response.roles;
        this.$set(this.form, "postIds", response.postIds);
        this.$set(this.form, "roleIds", response.roleIds);
        this.open = true;
        this.title = "修改用户";
        this.form.password = "";
      });
    },
    /** 重置密码按钮操作 */
    handleResetPwd(row) {
      this.$prompt('请输入用户' + row.userName + '的新密码', "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        closeOnClickModal: false,
        inputPattern: /^.{5,20}$/,
        inputErrorMessage: "用户密码长度必须介于 5 和 20 之间",
        inputValidator: (value) => {
          if (/<|>|"|'|\||\\/.test(value)) {
            return "不能包含非法字符：< > \" ' \\\ |"
          }
        },
      }).then(({ value }) => {
        resetUserPwd(row.userId, value).then(response => {
          this.$modal.msgSuccess("修改成功，新密码是：" + value);
        });
      }).catch(() => {});
    },
    /** 分配角色操作 */
    handleAuthRole: function(row) {
      const userId = row.userId;
      this.$router.push("/system/user-auth/role/" + userId);
    },
    /** 提交按钮 */
    submitForm: function() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.userId != undefined) {
            updateUser(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addUser(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除用户编号为"' + userIds + '"的数据项？').then(function() {
        return delUser(userIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/user/export', {
        ...this.queryParams
      }, `user_${new Date().getTime()}.xlsx`)
    },
    /** 导入按钮操作 */
    handleImport() {
      this.upload.title = "用户导入";
      this.upload.open = true;
    },
    /** 下载模板操作 */
    importTemplate() {
      this.download('system/user/importTemplate', {
      }, `user_template_${new Date().getTime()}.xlsx`)
    },
    // 文件上传中处理
    handleFileUploadProgress(event, file, fileList) {
      this.upload.isUploading = true;
    },
    // 文件上传成功处理
    handleFileSuccess(response, file, fileList) {
      this.upload.open = false;
      this.upload.isUploading = false;
      this.$refs.upload.clearFiles();
      this.$alert("<div style='overflow: auto;overflow-x: hidden;max-height: 70vh;padding: 10px 20px 0;'>" + response.msg + "</div>", "导入结果", { dangerouslyUseHTMLString: true });
      this.getList();
    },
    // 提交上传文件
    submitFileForm() {
      this.$refs.upload.submit();
    }
  }
};
</script>

<style>
  .left-box{
    margin: 30px;
  }

  .right-box{
    margin: 30px;
  }
</style>
