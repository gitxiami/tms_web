<template>
  <div>
    <!-- 条件search -->
    <div class="search">
      <more-panel>
        <el-form  slot="form" :inline="true"  class="demo-form-inline">
          <el-form-item  :label="$t('appManage.document.searchLabel')">
            <el-input onkeydown="if(event.keyCode==13)return false;" @keydown.enter.native="search()" size="small" v-model="searchParams.docName" :placeholder="$t('appManage.document.searchPlaceHolder')" ></el-input>
          </el-form-item>
        </el-form>
        <div slot="control">
          <el-button  size="small" icon="search" type="primary" @click="search()">{{$t('search')}}</el-button>
          <el-button  size="small" icon="circle-close" type="primary"  @click="reset()">{{$t('reset')}}</el-button>
          <template  v-for="(item,index) in popedomList.button">
            <el-button v-if="item.popedomId=='03301'" size="small" type="primary" @click="showUpload()" :key="index"><i class="iconfont" v-bind:class="item.popedomIconcls"></i>{{isEn ? item.popedomName:item.popedomRemark}}</el-button>
          </template>
        </div>
      </more-panel>
    </div>
    <el-table :empty-text="emptyText" highlight-current-row @current-change="select" :height="tableHeight"  border stripe :data="tableData"  style="width:100%;">
      <el-table-column align="center" show-overflow-tooltip type="index" width="50"></el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('appManage.document.docName')" prop="docName" min-width="170" ></el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('appManage.document.docDesc')" prop="docDesc"  min-width="180"></el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('appManage.document.createdDatetime')" prop="createdDatetime" min-width="180"></el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('operation')" min-width="120">
        <template slot-scope="scope" >
          <el-button :title="isEn ? item.popedomName:item.popedomRemark" class="iconHandle"  v-for="(item,index) in popedomList.button" v-if="(item.popedomId=='03302')" @click="showDown(scope.row)" :key="index" type="warning" size="mini"><i class="iconfont" :class="item.popedomIconcls"></i></el-button>
          <el-button :title="isEn ? item.popedomName:item.popedomRemark" class="iconHandle"  v-for="(item,index) in popedomList.button" v-if="(item.popedomId=='03303')" @click="openDelete(scope.row)" :key="index" type="info" size="mini"><i class="iconfont" :class="item.popedomIconcls"></i></el-button>
        </template></el-table-column>
    </el-table>
    <my-pagination @loadingStatus="loadingStatus" :reload="reload" :searchParams="searchParams" :searchFlag="searchFlag" :url="url" @tableContent="tableContent"></my-pagination>
    <!-- 上传文件 -->
    <el-dialog  :title="$t('appManage.document.importFormTitle')" :visible.sync="uploadVisiable" :close-on-click-modal="false">
      <el-form :model="uploadForm"   label-width="150px" ref="uploadForm" >
        <el-form-item prop="docName" :label="$t('appManage.document.docName')" >
          <el-input v-model="uploadForm.docName"></el-input>
        </el-form-item>
        <el-form-item :label="$t('appManage.document.selectKey')" prop="fileName">
          <input  ref="file" type="file" style='display:none' @change="fileChange()"/>
          <el-input v-model="uploadForm.fileName" style='display:none' auto-complete="off"></el-input>
          <el-button type="primary" size="mini" @click="selectFile()">{{$t('selectFile')}}</el-button>
          <el-tag v-if="uploadForm.fileName"  type="primary">{{uploadForm.fileName}}</el-tag>
        </el-form-item>
        <el-form-item prop="docDesc" :label="$t('appManage.document.docDesc')" >
          <el-input type="textarea" v-model="uploadForm.docDesc"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="uploadFile()" :loading="handleLoading">{{$t('ok')}}</el-button>
        <el-button @click="uploadVisiable=false">{{$t('cancel')}}</el-button>
      </div>
    </el-dialog>
    
  </div>
</template>
<script>
import mixin from '@/mixins/mixin'
import { documentRules } from '@/mixins/rules'
export default {
  mixins: [mixin],
  data () {
    return {
      url:'/oversea_tms/doc/showDocByPage.action',
      searchParams:{
          docName:'',
          pageNo:1,
          pageSize:10
      },
      uploadForm:{
        docName:'',
        docDesc:'',
        uploadFile:'',
        fileName:''
      },
      rules:documentRules,
      uploadVisiable:false
    };
  },
  methods: {
    showUpload(){
      this.uploadVisiable = true;
    },
    selectFile(){//选择文件
      this.$refs.file.value='';
      this.$refs.file.click()
    },
    fileChange(){//文件改变
      this.uploadForm.fileName=this.$refs.file.files[0].name;
      this.uploadForm.uploadFile=this.$refs.file.files[0];
    },
    uploadFile(){
      if(!this.uploadForm.fileName){
        this.$message.error(this.$t('selectOneFile'));
        return 
      }
      this.handleLoading = true;
      this.fileSubmit({
        data:this.uploadForm,
        url:'/oversea_tms/doc/uploadDoc.action',
        success:(data)=>{
          this.reload=!this.reload;
          this.$refs.uploadForm.resetFields();
        }
      })
    },
    showDown(row){
        window.open('/oversea_tms/doc/downloadDoc.action?docId='+row.docId);
    },
    openDelete(row){
      this.confirm({
        title:this.$t("appManage.document.deleteConfirm"),
        data:{
          "docId":row.docId
        },
        url:'/oversea_tms/doc/deleteDoc.action',
        success:(data)=>{
            this.reload=!this.reload;
        }
      })
    }
  }
}
</script>
<style lang="less" scoped>
#app .demo-table-expand label{
    width:200px;
}
</style>
