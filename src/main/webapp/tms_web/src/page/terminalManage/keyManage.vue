<template>
  <div>
    <!-- 条件search -->
    <div class="search">
      <more-panel>
        <el-form  slot="form" :inline="true"  class="demo-form-inline">
          <el-form-item  :label="$t('terminalManage.key.searchLabel')">
            <el-select size="small" v-model="searchParams.useFlag">
                <el-option  :label="isEn?'in use':'使用中'" :value="0" ></el-option>
                <el-option  :label="isEn?'out of use':'未使用'" :value="1" ></el-option>
            </el-select>
          </el-form-item>
        </el-form>
        <div slot="control">
          <el-button  size="small" icon="search" type="primary" @click="search()">{{$t('search')}}</el-button>
          <el-button  size="small" icon="circle-close" type="primary"  @click="reset()">{{$t('reset')}}</el-button>
          <template  v-for="(item,index) in popedomList.button">
            <el-button v-if="item.popedomId=='02401'" size="small" type="primary" @click="showAddKey()" :key="index"><i class="iconfont" v-bind:class="item.popedomIconcls"></i>{{isEn ? item.popedomName:item.popedomRemark}}</el-button>
            <el-button v-if="item.popedomId=='02403'" size="small" type="primary" @click="showUpload()" :key="index"><i class="iconfont" v-bind:class="item.popedomIconcls"></i>{{isEn ? item.popedomName:item.popedomRemark}}</el-button>
          </template>
        </div>
      </more-panel>
    </div>
    <el-table :empty-text="emptyText" highlight-current-row @current-change="select" :height="tableHeight"  border stripe :data="tableData"  style="width:100%;">
      <el-table-column align="center" show-overflow-tooltip type="index" width="50"></el-table-column>
      <el-table-column type="expand">
        <template slot-scope="props">
          <el-form label-position="left" inline class="demo-table-expand" >
            <el-form-item :label="$t('terminalManage.key.tak')">
                <span class="itemValue">{{ props.row.tak}}</span>
            </el-form-item>
            <el-form-item class="longLabel" :label="$t('terminalManage.key.tmkReferenceNo')" >
                <span class="itemValue">{{ props.row.tmkReferenceNo}}</span>
            </el-form-item>
            <el-form-item  :label="$t('terminalManage.key.filler')">
                <span class="itemValue">{{ props.row.filler}}</span>
            </el-form-item>
            <el-form-item  :label="$t('terminalManage.key.createTime')">
                <span class="itemValue">{{ props.row.createTime}}</span>
            </el-form-item>
          </el-form>
        </template>
      </el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('terminalManage.key.description')" prop="description" min-width="170" ></el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('terminalManage.key.tmsCode')" prop="tmsCode"  min-width="160"></el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('terminalManage.key.tmk')" prop="tmk" min-width="160"></el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('terminalManage.key.searchLabel')" prop="useFlagName" min-width="120" >
        <template slot-scope="scopes">
            <el-tag size="small" v-if="scopes.row.useFlag=='0'" type="success" close-transition>{{isEn?scopes.row.useFlagName:'使用中'}}</el-tag>
            <el-tag size="small" v-if="scopes.row.useFlag=='1'" type="danger" close-transition>{{isEn?scopes.row.useFlagName:'未使用'}}</el-tag>
        </template>
      </el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('operation')" min-width="100">
        <template slot-scope="scope" >
          <el-button :title="isEn ? item.popedomName:item.popedomRemark" class="iconHandle"  v-for="(item,index) in popedomList.button" v-if="(item.popedomId=='02402')" @click="showDeleteKey(scope.row)" :key="index" type="warning" size="mini"><i class="iconfont" :class="item.popedomIconcls"></i></el-button>
        </template></el-table-column>
    </el-table>
    <my-pagination @loadingStatus="loadingStatus" :reload="reload" :searchParams="searchParams" :searchFlag="searchFlag" :url="url" @tableContent="tableContent"></my-pagination>
    <!--添加秘钥-->
    <el-dialog width="65%" :title="$t('terminalManage.key.addFormTitle')" :visible.sync="addVisiable" :close-on-click-modal="false">
      <el-form :model="addForm" :rules="rules" label-width="140px" ref="addForm" >
        <el-row>
          <el-col :lg="{span: 11, offset: 0}" >
            <el-form-item prop="description" :label="$t('terminalManage.key.description')" >
                <el-input type="text" v-model="addForm.description"></el-input>
            </el-form-item>
            <el-form-item prop="tmsCode" :label="$t('terminalManage.key.tmsCode')" >
                <el-input type="text" v-model="addForm.tmsCode"></el-input>
            </el-form-item>
            <el-form-item prop="tmk" :label="$t('terminalManage.key.tmk')" >
                <el-input type="text" v-model="addForm.tmk"></el-input>
            </el-form-item>
            <el-form-item prop="tmkReferenceNo" :label="$t('terminalManage.key.tmkReferenceNo')" >
                <el-input type="text" v-model="addForm.tmkReferenceNo"></el-input>
            </el-form-item>
          </el-col>
          <el-col :lg="{span: 11, offset: 1}" >
            <el-form-item prop="checksum" :label="$t('terminalManage.key.checksum')" >
                <el-input type="text" v-model="addForm.checksum"></el-input>
            </el-form-item>
            <el-form-item prop="filler" :label="$t('terminalManage.key.filler')" >
                <el-input type="text" v-model="addForm.filler"></el-input>
            </el-form-item>
            <el-form-item prop="tak" :label="$t('terminalManage.key.tak')" >
                <el-input type="text" v-model="addForm.tak"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="addKey()" :loading="handleLoading">{{$t('ok')}}</el-button>
        <el-button @click="addVisiable=false">{{$t('cancel')}}</el-button>
      </div>
    </el-dialog>
    <!-- 上传文件 -->
    <el-dialog  :title="$t('terminalManage.key.importFormTitle')" :visible.sync="uploadVisiable" :close-on-click-modal="false">
      <el-form :model="uploadForm"   label-width="150px" ref="uploadForm" >
        <el-form-item :label="$t('terminalManage.key.selectKey')" prop="fileName">
          <input  ref="file" type="file" id="fileUpload" style='display:none' @change="fileChange()"/>
          <el-input v-model="uploadForm.fileName" style='display:none' auto-complete="off"></el-input>
          <el-button type="primary" size="mini" @click="selectFile()">{{$t('selectFile')}}</el-button>
          <el-tag v-if="uploadForm.fileName"  type="primary">{{uploadForm.fileName}}</el-tag>
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
import { keyRules } from '@/mixins/rules'
export default {
  mixins: [mixin],
  data () {
    return {
      url:'/oversea_tms/device/showTerminalKey.action',
      searchParams:{
          useFlag:'',
          pageNo:1,
          pageSize:10
      },
      addForm:{
        description:'',
        tmsCode:'',
        tmk:'',
        tak:'',
        tmkReferenceNo:'',
        checksum:'',
        filler:'',
      },
      uploadForm:{
        file:'',
        fileName:''
      },
      rules:keyRules,
      uploadVisiable:false
    };
  },
  mounted () {
    this.getData({
      url:'/oversea_tms/brand/allBrand.action',
      success:(data)=>{
        this.brandData=data;
      }
    })
  },
  methods: {
    showAddKey(){
      
      this.addVisiable=true;
    },
    addKey(){
      this.$refs.addForm.validate((valid)=>{
        if(valid){
          this.submitData({
            url:'/oversea_tms/device/addTerminalKey.action',
            data:this.addForm,
            success:(data)=>{
              this.reload=!this.reload;
              
              this.addVisiable=false;
              this.$refs.addForm.resetFields();
            }
          })  
        }
      })
    },
    showUpload(){
      this.uploadVisiable = true;
    },
    selectFile(){//选择文件
      this.$refs.file.value='';
      this.$refs.file.click()

    },
    fileChange(){//文件改变
      this.uploadForm.fileName=this.$refs.file.files[0].name;
      this.uploadForm.file=this.$refs.file.files[0];
    },
    uploadFile(){
      if(!this.uploadForm.fileName){
        this.$message.error(this.$t('selectOneFile'));
        return 
      }
      this.handleLoading = true;
      this.fileSubmit({
        data:this.uploadForm,
        url:'/oversea_tms/device/generateTmk.action',
        success:(data)=>{
          this.reload=!this.reload;
          
          this.$refs.uploadForm.resetFields();
            
        }
      })
    },
    showDeleteKey(row){
      this.confirm({
        title:this.$t("terminalManage.key.deleteConfirm"),
        url:'/oversea_tms/device/deleteTerminalKey.action',
        data:{
          'keyId':row.keyId,
          'useFlag':row.useFlag
        },
        success:()=>{
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
