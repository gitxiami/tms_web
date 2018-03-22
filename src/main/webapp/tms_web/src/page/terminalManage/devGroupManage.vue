<template>
  <div>
    <!-- 条件search -->
    <div class="search">
      <more-panel>
        <el-form  slot="form" :inline="true"  class="demo-form-inline">
          <el-form-item  :label="$t('terminalManage.devGroup.searchLabel')">
            <el-input onkeydown="if(event.keyCode==13)return false;" @keydown.enter.native="search()" size="small" v-model="searchParams.groupName" :placeholder="$t('terminalManage.devGroup.searchPlaceHolder')" ></el-input>
          </el-form-item>
          <el-form-item  :label="$t('terminalManage.terminal.searchLabel')">
            <el-cascader clearable v-model="searchParams.searchArray" @change="lastChange" @active-item-change="handleChange" :options="deviceData" :props="props"></el-cascader>
          </el-form-item>
        </el-form>
        <div slot="control">
          <el-button  size="small" icon="search" type="primary" @click="search()">{{$t('search')}}</el-button>
          <el-button  size="small" icon="circle-close" type="primary"  @click="reset2()">{{$t('reset')}}</el-button>
          <template  v-for="(item,index) in popedomList.button">
            <el-button v-if="item.popedomId=='02501'" size="small" type="primary" @click="showAddGroup()" :key="index"><i class="iconfont" v-bind:class="item.popedomIconcls"></i>{{isEn ? item.popedomName:item.popedomRemark}}</el-button>
          </template>
        </div>
      </more-panel>
    </div>
    <el-table :empty-text="emptyText" highlight-current-row @current-change="select" :height="tableHeight"  border stripe :data="tableData"  style="width:100%;">
      <el-table-column align="center" show-overflow-tooltip type="index" width="50"></el-table-column>
      <el-table-column type="expand">
        <template slot-scope="props">
          <el-form label-position="left" inline class="demo-table-expand" >
            <el-form-item :label="$t('createTime')">
              <span class="itemValue">{{ props.row.createdDatetime}}</span>
            </el-form-item>
            <el-form-item :label="$t('updateTime')" >
              <span class="itemValue">{{ props.row.updateDatetime}}</span>
            </el-form-item>
          </el-form>
        </template>
      </el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('terminalManage.devGroup.searchLabel')" prop="groupName" min-width="170" ></el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('terminalManage.devGroup.modleName')" prop="modelName"  min-width="160"></el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('terminalManage.devGroup.creOpt')" prop="createOprater" min-width="160"></el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('operation')" min-width="100">
        <template slot-scope="scope" >
          <el-button :title="isEn ? item.popedomName:item.popedomRemark" class="iconHandle"  v-for="(item,index) in popedomList.button" v-if="(item.popedomId=='02502')" @click="showEditGroup(scope.row)" :key="index" type="warning" size="mini"><i class="iconfont" :class="item.popedomIconcls"></i></el-button>
          <el-button :title="isEn ? item.popedomName:item.popedomRemark" class="iconHandle"  v-for="(item,index) in popedomList.button" v-if="(item.popedomId=='02503')" @click="showDeleteGroup(scope.row)" :key="index" type="info" size="mini"><i class="iconfont" :class="item.popedomIconcls"></i></el-button>
          <el-button :title="isEn ? item.popedomName:item.popedomRemark" class="iconHandle"  v-for="(item,index) in popedomList.button" v-if="(item.popedomId=='02504')" @click="showImportParam(scope.row)" :key="index" type="success" size="mini"><i class="iconfont" :class="item.popedomIconcls"></i></el-button>
        </template></el-table-column>
    </el-table>
    <my-pagination @loadingStatus="loadingStatus" :reload="reload" :searchParams="searchParams" :searchFlag="searchFlag" :url="url" @tableContent="tableContent"></my-pagination>
    <!--添加分组-->
    <el-dialog id="fixDialog" :title="$t('terminalManage.devGroup.addFormTitle')" :visible.sync="addVisiable" :close-on-click-modal="false">
      <el-form :model="addForm" :rules="rules" label-width="120px" ref="addForm" >
        <el-row>
          <el-col :lg="{span: 11, offset: 0}"  :sm="{span: 11, offset: 0}" :xs="{span: 11, offset: 0}">
            <el-form-item prop="groupName" :label="$t('terminalManage.devGroup.searchLabel')" >
              <el-input type="text" v-model="addForm.groupName"></el-input>
            </el-form-item>
            <el-form-item>
              <el-checkbox v-model="checked">{{$t('terminalManage.devGroup.copyModel')}}</el-checkbox>
            </el-form-item>
          </el-col>
          <el-col :lg="{span: 11, offset: 1}"  :sm="{span: 11, offset: 1}" :xs="{span: 11, offset: 1}">
            <el-form-item prop="modelArray"  :label="$t('terminalManage.devGroup.termModel')">
              <el-cascader clearable v-model="addForm.modelArray" @change="lastChangeAdd" @active-item-change="handleChangeAdd" :options="deviceData" :props="props"></el-cascader>
            </el-form-item>
            <el-form-item prop="groupId" :label="$t('terminalManage.devGroup.selGroup')" >
              <el-select v-model="addForm.groupId" :disabled="!checked" @change="copyAllAdd">
                  <el-option :key="index" v-for="(item,index) in selGroupData" :label="item.groupName" :value="item.groupId" ></el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-transfer
          size="large"
          filterable
          :filter-placeholder="$t('terminalManage.devGroup.transPlace')"
          :titles="[$t('terminalManage.devGroup.terminalPool'), $t('terminalManage.devGroup.newGroup')]"
          v-model="nowAdd"
          :props="transProps"
          :data="originalAdd">
        </el-transfer>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="addGroup()" :loading="handleLoading">{{$t('ok')}}</el-button>
        <el-button @click="addVisiable=false">{{$t('cancel')}}</el-button>
      </div>
    </el-dialog>
    <!--修改分组-->
    <el-dialog id="fixDialog" :title="$t('terminalManage.devGroup.editFormTitle')" :visible.sync="editVisiable" :close-on-click-modal="false">
      <el-form :model="editForm" :rules="rules" label-width="120px" ref="editForm" >
        <input type="hidden" v-model="groupIdEdit">
        <el-form-item prop="groupName" :label="$t('terminalManage.devGroup.searchLabel')" >
          <el-input type="text" v-model="editForm.groupName" disabled="disabled"></el-input>
        </el-form-item>
        <input type="hidden" v-model="editForm.modelId">
        <el-row>
          <el-col :lg="{span: 11, offset: 0}"  :sm="{span: 11, offset: 0}" :xs="{span: 11, offset: 0}">
            <el-form-item prop="modelName" :label="$t('terminalManage.devGroup.termModel')" >
              <el-input type="text" v-model="editForm.modelName" disabled="disabled"></el-input>
            </el-form-item>
          </el-col>
          <el-col :lg="{span: 11, offset: 1}"  :sm="{span: 11, offset: 1}" :xs="{span: 11, offset: 1}">
            <el-form-item prop="groupId" :label="$t('terminalManage.devGroup.selGroup')" >
              <el-select v-model="editForm.groupId" @change="copyAllEdit">
                  <el-option :key="index" v-for="(item,index) in selGroupDataEdit" :label="item.groupName" :value="item.groupId" :disabled="groupIdEdit==editForm.groupId"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-transfer
          size="large"
          filterable
          :filter-placeholder="$t('terminalManage.devGroup.transPlace')"
          :titles="[$t('terminalManage.devGroup.terminalPool'), $t('terminalManage.devGroup.group')]"
          v-model="nowEdit"
          :props="transProps"
          :data="originalEdit">
        </el-transfer>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="editGroup()" :loading="handleLoading">{{$t('ok')}}</el-button>
        <el-button @click="editVisiable=false">{{$t('cancel')}}</el-button>
      </div>
    </el-dialog>
    <!-- 显示组里的终端序列号 -->
    <el-dialog width="30%" :title="$t('terminalManage.devGroup.addGroupTitle')" :visible.sync="addGroupVisiable" :close-on-click-modal="false">
      <p class="confirmTitle">{{$t('terminalManage.devGroup.devGroupTitle')}}</p>
      <table cellspacing="0" cellpadding="3px" border="0" class="devTable">
        <tr>
          <td style="width:30px">&nbsp;</td>
          <td>{{$t('terminalManage.devGroup.deviceSn')}}</td>
        </tr>
        <tr v-for="(item,index) in selGroupDev" :key="index">
          <td><span class="devIndex">{{index+1}}</span></td>
          <td>{{item.deviceSn}}</td>
        </tr>
      </table>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="sureToAddAll()" :loading="handleLoading">{{$t('ok')}}</el-button>
        <el-button @click="addGroupVisiable=false">{{$t('cancel')}}</el-button>
      </div>
    </el-dialog>
    <!-- 删除组 -->
    <el-dialog width="30%" :title="$t('terminalManage.devGroup.delGroupTitle')" :visible.sync="deleteGroupVisiable" :close-on-click-modal="false">
      <p class="confirmTitle">{{$t('terminalManage.devGroup.delGroupConfirm')}}</p>
      <table cellspacing="0" cellpadding="3px" border="0" class="devTable">
        <tr>
          <td style="width:30px">&nbsp;</td>
          <td>{{$t('terminalManage.devGroup.deviceSn')}}</td>
        </tr>
        <tr v-for="(item,index) in deletDevData" :key="index">
          <td><span class="devIndex">{{index+1}}</span></td>
          <td>{{item.deviceSn}}</td>
        </tr>
      </table>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="sureToDelete()" :loading="handleLoading">{{$t('ok')}}</el-button>
        <el-button @click="deleteGroupVisiable=false">{{$t('cancel')}}</el-button>
      </div>
    </el-dialog>
    <!-- 导入参数 -->
    <el-dialog id="fixDialog2" :title="$t('terminalManage.devGroup.importParamTitle')" :visible.sync="importVisiable" :close-on-click-modal="false">
      <el-button type="primary" @click="showUpload">{{$t('terminalManage.devGroup.importFile')}}</el-button>
      <p class="line2">{{$t('terminalManage.devGroup.appName')}}:<span class="red">{{appName}}</span></p>
      <p class="line2">{{$t('version')}}:<span class="red">{{version}}</span></p>
      <v-table
        column-width-drag
        style="margin-top:15px"
        :height="500"
        :columns="columns"
        :table-data="paramData"
        even-bg-color="#f4f4f4"
        row-hover-color="#eee"
        row-click-color="#edf7ff"
      ></v-table>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="importParam()" :loading="handleLoading">{{$t('ok')}}</el-button>
        <el-button @click="importVisiable=false">{{$t('cancel')}}</el-button>
      </div>
    </el-dialog>
    <!-- 上传文件 -->
    <el-dialog  :title="$t('terminalManage.devGroup.importFile')" :visible.sync="uploadVisiable" :close-on-click-modal="false">
      <el-form :model="uploadForm"   label-width="150px" ref="uploadForm" >
        <el-form-item :label="$t('terminalManage.terminal.selectKey')" prop="fileName">
          <input  ref="file" type="file" style='display:none' @change="fileChange()"/>
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
import {devGroupRules} from '@/mixins/rules'
export default {
  mixins: [mixin],
  data () {
    var _this=this;
    return {
      url:'/oversea_tms/deviceGroup/showDeviceGroup.action',
      searchParams:{
        searchArray:[],
        groupName:'',
        modelId:'',
        pageNo:1,
        pageSize:10
      },  
      deviceData:[],
      addForm:{
        modelArray:[],
        groupName:'',
        modelId:'',
        groupId:'',
      },
      nowAdd:[],
      originalAdd:[],
      deviceDataAdd:[],
      selGroupData:[],
      selGroupDev:[],
      checked:false,
      editForm:{
        groupId:'',
        modelId:'',
        modelName:'',
        groupName:'',
      },
      groupIdEdit:'',
      nowEdit:[],
      originalEdit:[],
      selGroupDataEdit:[],
      props:{
        'value':'id',
        'label':'name'
      },
      transProps:{
        key:'deviceId',
        label:'deviceSn'
      },
      rules:devGroupRules,
      addGroupVisiable:false,
      deleteGroupVisiable:false,
      deletDevData:[],
      delGroupId:'',
      option:'add',
      importVisiable:false,
      importGroupId:'',
      paramData:[],
      columns:  [
        {field: 'custome', title:_this.$t('seri'), width: 50, titleAlign: 'center', columnAlign: 'center',
                            formatter: function (rowData,rowIndex,pagingIndex,field) {
                                return rowIndex + 1
                            }, isFrozen: true,isResize:true},
        {field: 'paramName', title:_this.$t('terminalManage.terminal.paramName'), width: 220, titleAlign: 'center',columnAlign:'center',isResize:true},
        {field: 'paramValue', title:_this.$t('terminalManage.terminal.paramValue'), width: 240, titleAlign: 'center',columnAlign:'center',isResize:true},
        {field: 'paramStatus', title: _this.$t('terminalManage.terminal.paramStatus'), width: 120, titleAlign: 'center',columnAlign:'center',isResize:true},
        {field: 'parameter', title: _this.$t('terminalManage.terminal.parameter'), width: 320, titleAlign: 'center',columnAlign:'left',isResize:true}
      ],
      uploadVisiable:false,
      uploadForm:{
        uploadFile:'',
        fileName:''
      },
      appName:'',
      version:''
    };
  },
  mounted () {
    this.getData({
      url:'/oversea_tms/brand/allBrand.action',
      success:(data)=>{
        this.deviceData=data;
        this.deviceDataAdd=data;
      }
    })
  },
  methods: {
    lastChange(value,index){
      this.searchParams.brandId=value[0];
      this.searchParams.modelTypeId=value[1];
      this.searchParams.modelId=value[2];
    },
    handleChange(value,index){
      if(value.length!=2) return 
      if(this.deviceData[index[0]].children[index[1]].children.length) return 
      this.getData({
        data:{ 'brandId':value[0] , 'modelTypeId':value[1]},
        url:'/oversea_tms/model/allModel.action',
        success:(data)=>{ 
          if(!data.length){
            var arr=[{
              id:'',
              name:this.$t('noTernimal'),
              disabled: true,
            }]
            this.deviceData[index[0]].children[index[1]].children=arr
          }else{
            this.deviceData[index[0]].children[index[1]].children=data;
          }
        }
      })
    },
    lastChangeAdd(value,index){
      this.addForm.modelId=value[2];
      this.addForm.groupId='';
      this.nowAdd=[];
      this.originalAdd=[];
      if(value[2]){
        this.getData({
          data:{
            'modelId':value[2]
          },
          url:'/oversea_tms/deviceGroup/allDeviceGroupByModel.action',
          success:(data)=>{
            this.selGroupData=data;
          }
        })
      }else{
        this.selGroupData=[];
        this.addForm.modelId='';
      }
      this.getWithoutGroup();
    },
    handleChangeAdd(value,index){
      if(value.length!=2) return 
      if(this.deviceDataAdd[index[0]].children[index[1]].children.length) return 
      this.getData({
        data:{ 'brandId':value[0] , 'modelTypeId':value[1]},
        url:'/oversea_tms/model/allModel.action',
        success:(data)=>{ 
          if(!data.length){
            var arr=[{
              id:'',
              name:this.$t('noTernimal'),
              disabled: true,
            }]
            this.deviceDataAdd[index[0]].children[index[1]].children=arr
          }else{
            this.deviceDataAdd[index[0]].children[index[1]].children=data;
          }
        }
      })
    },
    getWithoutGroup(){
      if(this.addForm.modelId){
        this.getData({
          data:{ 
            'modelId':this.addForm.modelId,
            'deviceSn':this.addForm.deviceSn
          },
          url:'/oversea_tms/deviceGroup/allDeviceWithoutGroup.action',
          success:(data)=>{
            this.originalAdd=this.originalAdd.concat(data);
          }
        })
      }else{
        this.originalAdd=[];
      }
    },
    copyAllAdd(){
      this.option='add';
      this.getData({
        data:{
          'groupId':this.addForm.groupId
        },
        url:'/oversea_tms/deviceGroup/showDeviceByGroup.action',
        success:(data)=>{
          if(data.length>0){
            this.addGroupVisiable=true;
            this.selGroupDev=data;
          }else{
            this.$message.error(this.$t('noDev'));
            this.selGroupDev=[];
          }
        }
      })
    },
    copyAllEdit(){
      this.option='edit';
      this.getData({
        data:{
          'groupId':this.editForm.groupId
        },
        url:'/oversea_tms/deviceGroup/showDeviceByGroup.action',
        success:(data)=>{
          if(data.length>0){
            this.addGroupVisiable=true;
            this.selGroupDev=data;
          }else{
            this.$message.error(this.$t('noDev'));
            this.selGroupDev=[];
          }
        }
      })
    },
    sureToAddAll(){
      if(this.option=='add'){
        if(this.nowAdd.length>0){
        //判断是否已添加
          var length1=this.nowAdd.length;
          var length2=this.selGroupDev.length;
          var flag=false;
          for(var i=0; i<length1; i++){
            for(var j=0; j<length2; j++){
              if(this.nowAdd[i]==this.selGroupDev[j].deviceId){
                flag=true;
                break;
              }
            }
            if(flag){
              break;
            }
          }
          if(flag){
            this.$message.warning(this.$t('selDev'));
          }else{
            this.addAllToGroup();
          }
        }else{
          this.addAllToGroup();
        }
      }else{
        this.originalEdit=this.originalEdit.concat(this.selGroupDev);
        //去重
        var result = [], hash = {};  hash_ = {}
        for (var i = 0; i<this.originalEdit.length; i++) {
          var elem = this.originalEdit[i].deviceSn; 
          if (!hash[elem]) {
            result.push(this.originalEdit[i]);
            hash[elem] = true;
          }
        }
        this.originalEdit=result;
      }
    },
    addAllToGroup(){
      var length=this.selGroupDev.length;
      for(var i=0; i<length; i++){
        this.originalAdd.push(this.selGroupDev[i]);
        this.nowAdd.push(this.selGroupDev[i].deviceId);
      }
      this.$message.success(this.$t('AddSuccess'));
      this.addGroupVisiable=false;
    },
    showAddGroup(){
      this.addVisiable=true;
      this.originalAdd=[];
      this.nowAdd=[];
      this.checked=false;
      if(this.$refs.addForm){
        this.$refs.addForm.resetFields();
      }
    },
    addGroup(){
      this.$refs.addForm.validate((valid)=>{
        if(valid){
          var data={};
          data.groupName=this.addForm.groupName;
          data.modelId=this.addForm.modelId;
          data.deviceIds=this.nowAdd.join(',');
          this.submitData({
            data:data,
            url:'/oversea_tms/deviceGroup/addDeviceGroup.action',
            success:(data)=>{
              this.reload=!this.reload;
              this.addVisiable=false;
              this.$refs.addForm.resetFields();
            }
          }) 
        }
      })
    },
    showEditGroup(row){
      this.editVisiable=true;
      Object.keys(this.editForm).forEach((key)=>{
          this.editForm[key]=row[key];
      })
      this.groupIdEdit=row.groupId;
      this.getData({
        data:{ 
          'modelId':this.editForm.modelId,
        },
        url:'/oversea_tms/deviceGroup/allDeviceGroupByModel.action',
        success:(data)=>{
          this.selGroupDataEdit=data;
        }
      })
      this.getData({
        data:{ 
          'groupId':row.groupId,
        },
        url:'/oversea_tms/deviceGroup/showDeviceByGroup.action',
        success:(data)=>{
          this.originalEdit=data;
          for(var i=0; i<data.length; i++){
            this.nowEdit.push(data[i].deviceId);
          }
        }
      })
    },
    editGroup(){
      this.$refs.editForm.validate((valid)=>{
        if(valid){
          var data={};
          data.groupId=this.groupIdEdit;
          data.deviceIds=this.nowEdit.join(',');
          this.submitData({
            data:data,
            url:'/oversea_tms/deviceGroup/updateDeviceGroup.action',
            success:(data)=>{
              this.reload=!this.reload;
              this.editVisiable=false;
              this.$refs.editForm.resetFields();
            }
          }) 
        }
      })
    },
    showDeleteGroup(row){
      this.deleteGroupVisiable=true;
      this.delGroupId=row.groupId;
      this.getData({
        data:{
          'groupId':row.groupId
        },
        url:'/oversea_tms/deviceGroup/showDeviceByGroup.action',
        success:(data)=>{
          this.deletDevData=data;
        }
      })
    },
    sureToDelete(){
      this.submitData({
        data:{
          'groupId':this.delGroupId
        },
        url:'/oversea_tms/deviceGroup/deleteDeviceGroup.action',
        success:(data)=>{
          this.reload=!this.reload;
          this.deleteGroupVisiable=false;
          this.deletDevData=[];
          this.delGroupId='';
        }
      })
    },
    showImportParam(row){
      this.importVisiable=true;
      this.importGroupId=row.groupId;
    },
    importParam(){
      var data={};
      data.groupId=this.importGroupId;
      data.deviceParams=JSON.stringify(this.paramData);
      this.submitData({
        data:data,
        url:'/oversea_tms/deviceParam/addParamByGroup.action',
        success:(data)=>{
          this.reload=!this.reload;
          this.importVisiable=false;
          this.paramData=[];
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
      this.uploadForm.uploadFile=this.$refs.file.files[0];
    },
    uploadFile(){
      if(!this.uploadForm.fileName){
        this.$message.error(this.$t('selectOneFile'));
        return 
      }
      // this.handleLoading = true;
      this.fileSubmit2({
        data:this.uploadForm,
        url:'/oversea_tms/deviceParam/readParamFile.action',
        success:(data)=>{
          this.uploadVisiable = false;
          this.appName=data[0].paramStatus;
          this.version=data[1].paramStatus;
          data.shift();
          data.shift();
          this.paramData=data;
          this.$refs.uploadForm.resetFields();
        }
      })
    },
  }
}
</script>
<style lang="less" scoped>
.el-cascader{
  width:100%;
}
.el-transfer{
  padding-left:85px;
}
.confirmTitle{
  font-size:16px;
  color:#C73E4B;
  font-weight: bold;
  text-align: center;
}
.devSn{
  padding-left:35px;
}
.devIndex{
  display:inline-block;
  width:20px;
  height:20px;
  line-height: 20px;
  text-align: center;
  background:#999;
  color:#fff;
  border-radius: 10px;
  margin-right:10px;
}
.devTable{
  width:100%;
  max-height: 300px;
  overflow:auto;
}
.devTable tr td{
  border:solid 1px #c1c1c1;
}
.line2{
  width:30%;
  display:inline-block;
  line-height: 35px;
  margin-left:15px;
}
.red{
  color:#C73E4B;
}
</style>
