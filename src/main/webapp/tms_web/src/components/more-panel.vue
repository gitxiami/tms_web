<template>
  <div :class="prefix">
    <div :class="prefix+'-body'" :style="{height:height}">
      <div :class="prefix+'-form'" ref="panelForm" :style="{paddingRight: panelPR}">
        <slot name="form"></slot>
        <div :class="prefix+'-control'" :style="controlStyle" ref="panelControl">
            <slot name="control"></slot>
        </div>
      </div>
    </div>
    <slot></slot>
    <div href="javascript:;" :class="prefix+'-btn'" class="moreBtn" @click="click" v-show="showBtn">
      <span class="anticon" :class="'el-icon-'+btnIcon"></span>
    </div>
  </div>
</template>
<script lang="babel">
  export default {
    name: 'MorePanel',
    data: ()=>({
      prefix: 'ant-more-panel',
      collapse: true,
      bindResize: false,
      showBtn: false,
      panelPR: 0
    }),
    props: {
      originalHeight:{
        type: [Number,String],
        default: 41
      },
      controlStyle:{
        type:Object,
        default: ()=>({})
      }
    },
    watch:{
      showBtn(){
        this.panelPR = this.$refs.panelControl.offsetWidth + 'px'
      }
    },
    computed: {
      height(){
        return this.collapse?this.originalHeight + 'px':'auto'
      },
      btnIcon(){
        return this.collapse?'arrow-down':'arrow-up'
      }
    },
    mounted(){
      this.panelPR = this.$refs.panelControl.offsetWidth + 'px'
      this.ifShowBtn();
      if(!this.bindResize){
        window.addEventListener("resize",this.ifShowBtn);
        this.bindResize = true;
      }
    },
    methods: {
      ifShowBtn(){
        if(!this.$el) return;
        this.$nextTick(()=> {
          if(this.$refs.panelForm){
              
              this.showBtn = this.$refs.panelForm.offsetHeight > this.originalHeight;
          }
        });
      },
      click(event){
        this.collapse = !this.collapse;
      }
    },
    
  }
</script>
<style lang="less">
  .ant-more-panel-form{
    width:100%;
  }
  .ant-more-panel{
      .el-form-item{
          margin-bottom: 0;
      }
  }
  .ant-more-panel {
    background-color: #fff;
    border-radius: 2px;
    font-size: 12px;
    position: relative;
    padding: 15px;
    display: flex;
    border: 1px solid #e9e9e9;
    transition: all .3s;
    padding-bottom: 20px;
  }
  .ant-more-panel:hover {
    box-shadow: 0 1px 6px rgba(0, 0, 0, 0.2);
    border-color: #eee;
  }
  .ant-more-panel-body {
    flex: 1;
    overflow: hidden;
  }
  .ant-more-panel-form {
    position: relative;
    display: inline-block;
  }
  .ant-more-panel-control {
    position: absolute;
    right: 0;
    top: 0;
    padding-top: 2px;
  }
  .ant-more-panel-btn {
    cursor: pointer;
    border: 1px solid #e9e9e9;
    color: #96A1A7;
    border-radius: 2px;
    width: 48px;
    text-align: center;
    line-height: 14px;
    position: absolute;
    left: 50%;
    bottom: -1px;
    margin-left: -1px;
  }
</style>
