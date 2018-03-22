<template>
  <div>
    <!-- 条件search -->
    <div class="search">
      <more-panel>
        <el-form  slot="form" :inline="true"  class="demo-form-inline">
          <el-form-item  :label="$t('terminalManage.terminal.searchLabel')">
            <el-cascader clearable v-model="searchParams.searchArray" @change="lastChange" @active-item-change="handleChange" :options="deviceData" :props="props"></el-cascader>
          </el-form-item>
        </el-form>
        <div slot="control">
          <el-button  size="small" icon="search" type="primary" @click="search()">{{$t('search')}}</el-button>
          <template  v-for="(item,index) in popedomList.button">
            <el-button v-if="item.popedomId=='02301'" size="small" type="primary" @click="showAddDevice()" :key="index"><i class="iconfont" v-bind:class="item.popedomIconcls"></i>{{isEn ? item.popedomName:item.popedomRemark}}</el-button>
            <el-button v-if="item.popedomId=='02306'" size="small" type="primary" @click="showUpload()" :key="index"><i class="iconfont" v-bind:class="item.popedomIconcls"></i>{{isEn ? item.popedomName:item.popedomRemark}}</el-button>
          </template>
        </div>
      </more-panel>
    </div>
    <el-table :empty-text="emptyText" highlight-current-row @current-change="select" :height="tableHeight"  border stripe :data="tableData"  style="width:100%;">
      <el-table-column align="center" show-overflow-tooltip type="index" width="50"></el-table-column>
      <el-table-column type="expand">
        <template slot-scope="props">
          <el-form label-position="left" inline class="demo-table-expand" >
            <el-form-item :label="$t('terminalManage.brand.name')">
              <span class="itemValue">{{ props.row.brandName}}</span>
            </el-form-item>
            <el-form-item :label="$t('terminalManage.model.type')" >
              <span class="itemValue">{{ props.row.modelTypeName}}</span>
            </el-form-item>
          </el-form>
        </template>
      </el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('deviceSn')" prop="deviceSn" min-width="180" ></el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('terminalManage.model.model')" prop="modelName" min-width="120"></el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('terminalManage.terminal.keyStatus')" prop="keyStatus" min-width="100" ></el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('terminalManage.terminal.merchant')" prop="mchntName" min-width="120">
        <template slot-scope="scopes">
            <el-tag size="small" :type="scopes.row.mchntName==''?'danger':'success'" close-transition>{{scopes.row.mchntName==''?(isEn?'Not Bound':'未绑定'):scopes.row.mchntName}}</el-tag>
        </template>
      </el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('terminalManage.terminal.status')" prop="deviceStatusName" min-width="80">
        <template slot-scope="scopes">
            <el-tag size="small" v-if="scopes.row.deviceStatus=='1'" type="success" close-transition>{{isEn?'enable':'启用'}}</el-tag>
            <el-tag size="small" v-if="scopes.row.deviceStatus=='2'" type="danger" close-transition>{{isEn?'stop':'停用'}}</el-tag>
            <el-tag size="small" v-if="scopes.row.deviceStatus=='0'" type="info" close-transition>{{isEn?'disable':'未启用'}}</el-tag>
        </template>
      </el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('terOpt')" min-width="200">
        <template slot-scope="scope">
          <el-button :title="isEn ? item.popedomName:item.popedomRemark" class="iconHandle"  v-for="(item,index) in popedomList.button" v-if="(item.popedomId=='02304')" @click="showStartDevice(scope.row)" :key="index" type="success" size="mini"><i class="iconfont" :class="item.popedomIconcls"></i></el-button>
          <el-button :title="isEn ? item.popedomName:item.popedomRemark" class="iconHandle"  v-for="(item,index) in popedomList.button" v-if="(item.popedomId=='02303')" @click="showStopDevice(scope.row)" :key="index" type="danger" size="mini"><i class="iconfont" :class="item.popedomIconcls"></i></el-button>
          <el-button :title="isEn ? item.popedomName:item.popedomRemark" class="iconHandle"  v-for="(item,index) in popedomList.button" v-if="(item.popedomId=='02305')" @click="showDeleteDevice(scope.row)" :key="index" type="info" size="mini"><i class="iconfont" :class="item.popedomIconcls"></i></el-button>
          <el-button :title="isEn ? item.popedomName:item.popedomRemark" class="iconHandle"  v-for="(item,index) in popedomList.button" v-if="(item.popedomId=='02307')" @click="showDeviceLog(scope.row)" :key="index" type="warning" size="mini"><i class="iconfont" :class="item.popedomIconcls"></i></el-button>
        </template></el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('perOpt')" min-width="140">
        <template slot-scope="scope">
          <el-button :title="isEn ? item.popedomName:item.popedomRemark" class="iconHandle"  v-for="(item,index) in popedomList.button" v-if="(item.popedomId=='0230601')" @click="showAddParam(scope.row)" :key="index" type="success" size="mini"><i class="iconfont" :class="item.popedomIconcls"></i></el-button>
          <el-button :title="isEn ? item.popedomName:item.popedomRemark" class="iconHandle"  v-for="(item,index) in popedomList.button" v-if="(item.popedomId=='0230602')" @click="showEditParam(scope.row)" :key="index" type="warning" size="mini"><i class="iconfont" :class="item.popedomIconcls"></i></el-button>
          <el-button :title="isEn ? item.popedomName:item.popedomRemark" class="iconHandle"  v-for="(item,index) in popedomList.button" v-if="(item.popedomId=='0230603')" @click="showDeleteParam(scope.row)" :key="index" type="info" size="mini"><i class="iconfont" :class="item.popedomIconcls"></i></el-button>
        </template></el-table-column>
    </el-table>
    <my-pagination @loadingStatus="loadingStatus" :reload="reload" :searchParams="searchParams" :searchFlag="searchFlag" :url="url" @tableContent="tableContent"></my-pagination>
    <!--添加终端-->
    <el-dialog width="30%" :title="$t('terminalManage.terminal.addFormTitle')" :visible.sync="addVisiable" :close-on-click-modal="false">
      <el-form :model="addForm" :rules="rules" label-width="140px" ref="addForm" >
        <el-form-item prop="deviceSn" :label="$t('deviceSn')" >
          <el-input type="text" v-model="addForm.deviceSn"></el-input>
        </el-form-item>
        <el-form-item prop="modelArray" :label="$t('terminalManage.model.model')" >
          <el-cascader v-model="addForm.modelArray" style="width:100%" @change="selectOver" @active-item-change="handleChange" :options="deviceData" :props="props"></el-cascader>
        </el-form-item>
        <el-form-item prop="deviceHwVersion" :label="$t('terminalManage.terminal.HardwareVersion')" >
          <el-input type="text" v-model="addForm.deviceHwVersion"></el-input>
        </el-form-item>
        <el-form-item prop="deviceSwVersion" :label="$t('terminalManage.terminal.SoftwareVersion')" >
          <el-input type="text" v-model="addForm.deviceSwVersion"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="addDevice()" :loading="handleLoading">{{$t('ok')}}</el-button>
        <el-button @click="addVisiable=false">{{$t('cancel')}}</el-button>
      </div>
    </el-dialog>
    <!-- 上传文件 -->
    <el-dialog  :title="$t('terminalManage.terminal.importFormTitle')" :visible.sync="uploadVisiable" :close-on-click-modal="false">
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
    <!-- 终端日志 -->
    <el-dialog width="70%"  :title="$t('terminalManage.terminal.logFormTitle')" :visible.sync="detailVisiable" :close-on-click-modal="false">
      <div class="">
        <div class="search">
          <more-panel>
            <el-form  slot="form" :inline="true"  class="demo-form-inline">
              <el-form-item  :label="$t('createTime')">
                <el-date-picker
                  v-model="deSearchData.createdDatetime"
                  type="date" value-format="yyyy-MM-dd"
                  :placeholder="$t('selectDate')">
                </el-date-picker>
              </el-form-item>
            </el-form>
             <div slot="control">
                <el-button  size="small" icon="search" type="primary" @click="deSearch()">{{$t('search')}}</el-button>
              </div>
          </more-panel>
        </div>
        <el-table :empty-text="emptyText" highlight-current-row @current-change="select" :height="detableHeight"  border stripe :data="deTableData"  style="width:100%;">
          <el-table-column align="center" show-overflow-tooltip type="index" width="50"></el-table-column>
          <el-table-column align="center" show-overflow-tooltip :label="$t('deviceSn')" prop="deviceSn" min-width="150" ></el-table-column>
          <el-table-column align="center" show-overflow-tooltip :label="$t('createTime')" prop="createdDatetime" min-width="160" ></el-table-column>
          <el-table-column align="center" show-overflow-tooltip :label="$t('operation')" min-width="100">
            <template slot-scope="scope" >
              <el-button :title="isEn ? item.popedomName:item.popedomRemark" class="iconHandle"  v-for="(item,index) in popedomList.button" v-if="(item.popedomId=='0230701')" @click="downloadLog(scope.row)" :key="index" type="success" size="mini"><i class="iconfont" :class="item.popedomIconcls"></i>{{isEn ? item.popedomName:item.popedomRemark}}</el-button>
            </template>
          </el-table-column>
        </el-table>
        <my-pagination @loadingStatus="loadingStatus" :reload="dereload" :searchFlag="deSearchFlag" :searchParams="deSearchData"  :url="deUrl" @tableContent="deTableContent"></my-pagination>
      </div>
    </el-dialog>
    <!--添加参数-->
    <el-dialog width="30%" :title="$t('terminalManage.terminal.addParamFormTitle')" :visible.sync="addParamVisiable" :close-on-click-modal="false">
      <el-form :model="addParamForm" :rules="rules" label-width="140px" ref="addParamForm" >
        <el-form-item prop="paramName" :label="$t('terminalManage.terminal.paramName')" >
          <el-input type="text" v-model="addParamForm.paramName"></el-input>
        </el-form-item>
        <el-form-item prop="paramValue" :label="$t('terminalManage.terminal.paramValue')" >
          <el-input type="text" v-model="addParamForm.paramValue"></el-input>
        </el-form-item>
        <el-form-item prop="paramStatus" :label="$t('terminalManage.terminal.paramStatus')" >
          <el-select v-model="addParamForm.paramStatus">
              <el-option  label="Public" value="0" ></el-option>
              <el-option  label="Private" value="1" ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item prop="parameter" :label="$t('terminalManage.terminal.parameter')" >
          <el-input type="textarea" v-model="addParamForm.parameter"></el-input>
        </el-form-item>
        <el-form-item prop="memo" :label="$t('terminalManage.terminal.memo')" >
          <el-input type="textarea" v-model="addParamForm.memo"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="addParam()" :loading="handleLoading">{{$t('ok')}}</el-button>
        <el-button @click="addParamVisiable=false">{{$t('cancel')}}</el-button>
      </div>
    </el-dialog>
    <!--修改参数-->
    <el-dialog  id="fixDialog" :title="$t('terminalManage.terminal.editParamFormTitle')" :visible.sync="editParamVisiable" :close-on-click-modal="false">
      <v-table
              column-width-drag
              is-horizontal-resize
              style="width:100%"
              :height="500"
              :columns="columns"
              :table-data="paramData"
              row-hover-color="#eee"
              row-click-color="#edf7ff"
              :cell-edit-done="cellEditDone"
      ></v-table>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="editParam()" :loading="handleLoading">{{$t('ok')}}</el-button>
        <el-button @click="editParamVisiable=false">{{$t('cancel')}}</el-button>
      </div>
    </el-dialog>
    <!--删除参数-->
    <el-dialog  id="fixDialog2" :title="$t('terminalManage.terminal.deleteParamFormTitle')" :visible.sync="delParamVisiable" :close-on-click-modal="false">
      <v-table
            column-width-drag
            is-horizontal-resize
            style="width:100%"
            :columns="columnsDel"
            :table-data="paramData"
            row-hover-color="#eee"
            row-click-color="#edf7ff"
            :select-all="selectALL"
            :select-change="selectChange"
            :select-group-change="selectGroupChange"
    ></v-table>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="delParam()" :loading="handleLoading">{{$t('ok')}}</el-button>
        <el-button @click="editParamVisiable=false">{{$t('cancel')}}</el-button>
      </div>
    </el-dialog>
  </div>
</template>
<script>
import mixin from '@/mixins/mixin'
import {deviceRules} from '@/mixins/rules'
export default {
  mixins: [mixin],
  data () {
    var _this=this;
    return {
      dereload:false,
      detableHeight:'300',
      deTableData:[],
      deUrl:'/oversea_tms/deviceLog/showDeviceLogByPage.action',
      detailVisiable:false,
      deSearchData:{ createdDatetime:'',pageNo:1, pageSize:10 },
      deSearchFlag:false,
      url:'/oversea_tms/device/showDevice.action',
      searchParams:{
        searchArray:[],
        brandId:'',
        modelId:'',
        modelTypeId:'',
        pageNo:1,
        pageSize:10
      },  
      addForm:{
        deviceId:'',
        deviceSn:'',
        brandId:'',
        modelTypeId:'',
        modelArray:[],
        deviceHwVersion:'',
        deviceSwVersion:'',
        modelId:''
      },
      uploadForm:{
        file:'',
        fileName:''
      },
      deviceData:[],
      props:{
        'value':'id',
        'label':'name'
      },
      rules:deviceRules,
      uploadVisiable:false,
      // 参数
      addParamVisiable:false,
      addParamForm:{
        deviceId:'',
        paramName:'',
        paramValue:'',
        paramStatus:'',
        parameter:'',
        memo:''
      },
      editParamVisiable:false,
      editDeviceId:'',
      paramData:[],
      columns:  [
        {field: 'paramName', title:_this.$t('terminalManage.terminal.paramName'), width: 80, titleAlign: 'center',columnAlign:'center',isEdit:false,
        formatter: function (rowData,rowIndex,pagingIndex,field) {
              return `<span class='cell-edit-color'>${rowData[field]}</span>`;
          },isResize:true},
        {field: 'paramValue', title: _this.$t('terminalManage.terminal.paramValue'), width: 220, titleAlign: 'center',columnAlign:'center',isEdit:true,isResize:true},
        {field: 'paramStatus', title: _this.$t('terminalManage.terminal.paramStatus'), width: 150, titleAlign: 'center',columnAlign:'center',isEdit:true,formatter: function (rowData,rowIndex,pagingIndex,field) {
              if(rowData[field]!=0 && rowData[field]!=1){
                _this.$message.error(_this.$t('terminalManage.terminal.publicPrivate'));
                return '';
              }else{
                return rowData[field];
              }
          },isResize:true},
        {field: 'parameter', title: _this.$t('terminalManage.terminal.parameter'), width: 220, titleAlign: 'center',columnAlign:'left',isEdit:true,isResize:true}
      ],
      delParamVisiable:false,
      columnsDel:  [
        {width: 60, titleAlign: 'center',columnAlign:'center',type: 'selection'},
        {field: 'paramName', title:_this.$t('terminalManage.terminal.paramName'), width: 80, titleAlign: 'center',columnAlign:'center',isResize:true},
        {field: 'paramValue', title: _this.$t('terminalManage.terminal.paramValue'), width: 220, titleAlign: 'center',columnAlign:'center',isResize:true},
        {field: 'paramStatus', title: _this.$t('terminalManage.terminal.paramStatus'), width: 150, titleAlign: 'center',columnAlign:'center',isResize:true},
        {field: 'parameter', title: _this.$t('terminalManage.terminal.parameter'), width: 220, titleAlign: 'center',columnAlign:'left',isResize:true}
      ],
      rowData:'',
    };
  },
  mounted () {
    this.getData({
      url:'/oversea_tms/brand/allBrand.action',
      success:(data)=>{
        this.deviceData=data;
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
    selectOver(value){
      this.addForm.brandId=value[0];
      this.addForm.modelTypeId=value[1];
      this.addForm.modelId=value[2];
    },
    showAddDevice(){
      this.addVisiable=true;
    },
    addDevice(){
      this.$refs.addForm.validate((valid)=>{
        if(valid){
          this.submitData({
            data:this.addForm,
            url:'/oversea_tms/device/addDevice.action',
            success:(data)=>{
              
              this.reload=!this.reload;
              this.addVisiable=false;
              this.$refs.addForm.resetFields();
            }
          }) 
        }
      })
    },
    showStopDevice(row){
      this.confirm({
        title:this.$t("terminalManage.terminal.stopConfirm"),
        url:'/oversea_tms/device/disableDevice.action',
        data:{
          'deviceId':row.deviceId
        },
        success:(data)=>{
          this.reload=!this.reload
        }
      })
    },
    showStartDevice(row){
      this.confirm({
        title:this.$t("terminalManage.terminal.startConfirm"),
        url:'/oversea_tms/device/enableDevice.action',
        data:{
          'deviceId':row.deviceId
        },
        success:(data)=>{
          this.reload=!this.reload
        }
      })
    },
    showDeleteDevice(row){
      this.confirm({
        title:this.$t("terminalManage.terminal.deleteConfirm"),
        url:'/oversea_tms/device/cancleDevice.action',
        data:{
          'deviceId':row.deviceId
        },
        success:(data)=>{
          this.reload=!this.reload
        }
      })
    },
    showUpload(){
      this.uploadVisiable = true;
    },
    selectFile(){//选择文件
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
    showDeviceLog(row){
      this.deUrl='/oversea_tms/deviceLog/showDeviceLogByPage.action?deviceSn='+row.deviceSn;
      this.dereload=!this.dereload;
      this.detailVisiable=true;
    },
    deSearch(){
      this.deSearchFlag=!this.deSearchFlag;
    },
    downloadLog(row){
      window.open("/oversea_tms/deviceLog/showDeviceLogByPage.action?deviceLogId="+row.deviceLogId);
    },
    deTableContent(data){//加载应用包详情表格数据
      this.deTableData=data;
    },
    showAddParam(row){
      this.addParamVisiable=true;
      this.addParamForm.deviceId=row.deviceId;
    },
    addParam(){
      this.$refs.addParamForm.validate((valid)=>{
        if(valid){
          this.submitData({
            data:this.addParamForm,
            url:'/oversea_tms/deviceParam/addDeviceParam.action',
            success:(data)=>{
              this.addParamVisiable=false;
              this.$refs.addParamForm.resetFields();
            }
          }) 
        }
      })
    },
    showEditParam(row){
      this.editDeviceId=row.deviceId;
      this.editParamVisiable=true;
      this.getData({
        data:{
          'deviceId':row.deviceId
        },
        url:'/oversea_tms/deviceParam/showParamByDevice.action',
        success:(data)=>{
          this.paramData=data;
        }
      })
    },
    editParam(){
      var data={};
      data.deviceParams=JSON.stringify(this.paramData);
      this.submitData({
        data:data,
        url:'/oversea_tms/deviceParam/updateParam.action',
        success:(data)=>{
          this.editParamVisiable=false;
          this.paramData=[];
        }
      }) 
    },
    // 单元格编辑回调
    cellEditDone(newValue,oldValue,rowIndex,rowData,field){
        this.paramData[rowIndex][field] = newValue;
        // 接下来处理你的业务逻辑，数据持久化等...
    },
    showDeleteParam(row){
      this.delParamVisiable=true;
      this.getData({
        data:{
          'deviceId':row.deviceId
        },
        url:'/oversea_tms/deviceParam/showParamByDevice.action',
        success:(data)=>{
          this.paramData=data;
        }
      })
    },
    delParam(){
      if(this.rowData.length>0){
        var length=this.rowData.length;
        var arr=[];
        for(var i=0; i<length; i++){
          arr.push(this.rowData[i].paramId);
        }
        this.submitData({
          data:{
            'paramIds':arr.join(',')
          },
          url:'/oversea_tms/deviceParam/deleteParam.action',
          success:(data)=>{
            this.delParamVisiable=false;
            this.paramData=[];
          }
        }) 
      }else{
        this.$message.error(this.$t('selectOneData'));
      }
    },
    selectALL(selection){
        this.rowData=selection;
    },

    selectChange(selection,rowData){
        this.rowData=selection;
    },
    selectGroupChange(selection){
        this.rowData=selection;
    }
  }
}
</script>
<style lang="less" scoped>
.cell-edit-color{
    color:#2db7f5;
    font-weight: bold;
}
.v-table-class{
   font-size: 14px;
    font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
}
.v-table-title-class {
   font-weight: normal;
    color: #333333;
    text-shadow: 0 0 0 #333333;
}
.v-table-body-class {
  font-weight: normal;
    color: #333333;
    text-shadow: 0 0 0 #333333;
}
</style>
