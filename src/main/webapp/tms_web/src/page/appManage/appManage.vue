<template>
  <div>
    <!-- 条件search -->
    <div class="search">
      <more-panel>
        <el-form  slot="form" :inline="true"  class="demo-form-inline">
          <el-form-item  :label="$t('appManage.app.nameLabel')">
            <el-input  @keydown.enter.native="search()" size="small" v-model="searchParams.appName" :placeholder="$t('appManage.app.searchPlace')" ></el-input>
          </el-form-item>
          <el-form-item  :label="$t('appManage.app.statusLabel')">
            <el-select size="small" v-model="searchParams.appStatus">
              <el-option :label="isEn?'ready':'未上线'" :value="0" ></el-option>
              <el-option :label="isEn?'online':'上线'" :value="1" ></el-option>
              <el-option :label="isEn?'offline':'下线'" :value="2" ></el-option>
            </el-select>
          </el-form-item>
        </el-form>
        <div slot="control">
          <el-button  size="small" icon="search" type="primary" @click="search()">{{$t('search')}}</el-button>
          <el-button  size="small" icon="circle-close" type="primary"  @click="reset()">{{$t('reset')}}</el-button>
          <template  v-for="(item,index) in popedomList.button">
            <el-button v-if="item.popedomId=='03101'" size="small" type="primary" @click="showAddApp()" :key="index"><i class="iconfont" v-bind:class="item.popedomIconcls"></i>{{isEn ? item.popedomName:item.popedomRemark}}</el-button>
          </template>
        </div>
      </more-panel>
    </div>
    <el-table :empty-text="emptyText" highlight-current-row @current-change="select" :height="tableHeight"  border stripe :data="tableData"  style="width:100%;">
      <el-table-column align="center" show-overflow-tooltip type="index" width="50"></el-table-column>
      <el-table-column type="expand">
        <template slot-scope="props">
            <el-form label-position="left" inline class="demo-table-expand" >
                <el-form-item :label="$t('appManage.app.key')">
                <span class="itemValue">{{ props.row.appId }}</span>
                </el-form-item>
                <el-form-item :label="$t('remark')">
                <span class="itemValue">{{ props.row.appDesc }}</span>
                </el-form-item>
            </el-form>
        </template>
      </el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('appManage.app.name')" prop="appName" min-width="130" ></el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('appManage.app.brandName')" prop="brandName" min-width="120" ></el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('appManage.app.terminalType')" prop="modelTypeName" min-width="110" ></el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('appManage.app.terminalModel')" prop="modelName" min-width="110"></el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('linkman')" prop="appContact" min-width="100" ></el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('appManage.app.applicationIcon')"  min-width="120"  >
        <template  slot-scope="scopes">
          <img style="width:20px;height:20px" :src="scopes.row.appIconType+scopes.row.appIcon" />
        </template>
      </el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('appManage.app.status')" prop="appStatusName" min-width="100" >
        <template slot-scope="scopes">
            <el-tag size="small" v-if="scopes.row.appStatus=='0'" type="info" close-transition>{{isEn?'ready':'未上线'}}</el-tag>
            <el-tag size="small" v-if="scopes.row.appStatus=='1'" type="success" close-transition>{{isEn?'online':'已上线'}}</el-tag>
            <el-tag size="small" v-if="scopes.row.appStatus=='2'" type="danger" close-transition>{{isEn?'offline':'已下线'}}</el-tag>
        </template>
      </el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('operation')" min-width="200">
        <template slot-scope="scope" >
          <el-button :title="isEn ? item.popedomName:item.popedomRemark" class="iconHandle"  v-for="(item,index) in popedomList.button" v-if="(item.popedomId=='03102')" @click="showEditApp(scope.row)" :key="index" type="warning" size="mini"><i class="iconfont" :class="item.popedomIconcls"></i></el-button>
          <el-button :title="isEn ? item.popedomName:item.popedomRemark" class="iconHandle"  v-for="(item,index) in popedomList.button" v-if="(item.popedomId=='03104')" @click="onLineApp(scope.row)" :key="index" type="success" size="mini"><i class="iconfont" :class="item.popedomIconcls"></i></el-button>
          <el-button :title="isEn ? item.popedomName:item.popedomRemark" class="iconHandle"  v-for="(item,index) in popedomList.button" v-if="(item.popedomId=='03105')" @click="outLineApp(scope.row)" :key="index" type="danger" size="mini"><i class="iconfont" :class="item.popedomIconcls"></i></el-button>
          <el-button :title="isEn ? item.popedomName:item.popedomRemark" class="iconHandle"  v-for="(item,index) in popedomList.button" v-if="item.popedomId=='03106'"   @click="showAppPkg(scope.row)" :key="index" type="primary" size="mini"><i class="iconfont" :class="item.popedomIconcls"></i></el-button>
          <el-button :title="isEn ? item.popedomName:item.popedomRemark" class="iconHandle"  v-for="(item,index) in popedomList.button" v-if="(item.popedomId=='03103')" @click="deleteApp(scope.row)" :key="index" type="info" size="mini"><i class="iconfont" :class="item.popedomIconcls"></i></el-button>
        </template>
      </el-table-column>
    </el-table>
    <my-pagination2  @loadingStatus="loadingStatus" :reload="reload" :searchParams="searchParams" :searchFlag="searchFlag" :url="url" @tableContent="tableContent"></my-pagination2>
    <!--添加应用-->
    <el-dialog :title="$t('appManage.app.addFormTitle')" :visible.sync="addVisiable" :close-on-click-modal="false">
      <el-form  :model="addForm" :rules="rules" label-width="150px" ref="addForm" >
        <el-form-item :label="$t('appManage.app.applicationIcon')" prop="addfileName">
          <input  ref="iconFileAdd" type="file" style='display:none' @change="fileChange('iconAdd')"/>
          <el-input v-model="addForm.addfileName" style='display:none' auto-complete="off"></el-input>
          <el-button type="primary" size="mini" @click="selectFile('iconAdd')">{{$t('selectFile')}}</el-button>
          <el-tag v-if="addForm.addfileName"  type="primary">{{addForm.addfileName}}</el-tag>
        </el-form-item>
        <el-popover v-model="treeVisiableAdd"  ref="popover2" trigger="click">
          <el-tree  style="width:200px;height:240px;overflow:auto"
              @node-click="orgAdd" :expand-on-click-node="false"
              :data="treeData" :props="propsOrg"  node-key="bak1"
              >
          </el-tree>
        </el-popover>
        <el-form-item prop="orgName" :label="$t('systemManage.operator.organization')" >
          <el-input readonly v-popover:popover2 v-model="addForm.orgName"></el-input>
        </el-form-item>
        <el-form-item prop="appName" :label="$t('appManage.app.name')" >
          <el-input v-model="addForm.appName"></el-input>
        </el-form-item>
        <el-form-item prop="modelData" :label="$t('appManage.app.selectTerminal')" >
          <el-cascader v-model="addForm.modelData" style="width:100%" @change="selectDevice" @active-item-change="handleChange" :options="deviceData" :props="props"></el-cascader>
        </el-form-item>
        <el-form-item prop="appContact" :label="$t('linkman')" >
          <el-input v-model="addForm.appContact"></el-input>
        </el-form-item>
        <el-form-item prop="appDesc" :label="$t('remark')" >
          <el-input type="textarea" v-model="addForm.appDesc"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="addApp()" :loading="handleLoading">{{$t('ok')}}</el-button>
        <el-button @click="addVisiable=false">{{$t('cancel')}}</el-button>
      </div>
    </el-dialog>
    <!--修改应用-->
    <el-dialog :title="$t('appManage.app.editFormTitle')" :visible.sync="editVisiable" :close-on-click-modal="false">
      <el-form  :model="editForm" :rules="rules" label-width="150px" ref="editForm" >
        <el-form-item :label="$t('appManage.app.applicationIcon')">
          <input  ref="iconFileEdit" type="file" style='display:none' @change="fileChange('iconEdit')"/>
          <el-input v-model="editForm.addfileName" style='display:none' auto-complete="off"></el-input>
          <el-button type="primary" size="mini" @click="selectFile('iconEdit')">{{$t('selectFile')}}</el-button>
          <el-tag v-if="editForm.addfileName"  type="primary">{{editForm.addfileName}}</el-tag>
        </el-form-item>
        <el-popover v-model="treeVisiableEdit"  ref="popover2" trigger="click">
          <el-tree  style="width:200px;height:240px;overflow:auto"
              @node-click="orgEdit" :expand-on-click-node="false"
              :data="treeData" :props="propsOrg"  node-key="bak1"
              >
          </el-tree>
        </el-popover>
        <el-form-item prop="orgName" :label="$t('systemManage.operator.organization')" >
          <el-input readonly v-popover:popover2 v-model="editForm.orgName"></el-input>
        </el-form-item>
        <el-form-item prop="appName" :label="$t('appManage.app.name')" >
          <el-input disabled v-model="editForm.appName"></el-input>
        </el-form-item>
        <el-form-item prop="modelId" :label="$t('appManage.app.selectTerminal')" >
          <el-cascader disabled v-model="editForm.deviceArray" style="width:100%" @change="selectDevice" @active-item-change="handleChange" :options="deviceData" :props="props"></el-cascader>
        </el-form-item>
        <el-form-item prop="appContact" :label="$t('linkman')" >
          <el-input v-model="editForm.appContact"></el-input>
        </el-form-item>
        <el-form-item prop="appDesc" :label="$t('remark')" >
          <el-input type="textarea" v-model="editForm.appDesc"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="editApp()" :loading="handleLoading">{{$t('ok')}}</el-button>
        <el-button @click="editVisiable=false">{{$t('cancel')}}</el-button>
      </div>
    </el-dialog>
    <!-- 应用包详情 -->
    <el-dialog width="70%" class="detail" :title="$t('appManage.app.packageDetails')" :visible.sync="detailVisiable" :close-on-click-modal="false">
      <div class="">
        <div class="search">
            <div slot="control">
              <template  v-for="(item,index) in popedomList.button">
                <el-button v-if="item.popedomId=='0310601'" size="small" type="primary" @click="showUploadPkg()" :key="index"><i class="iconfont" v-bind:class="item.popedomIconcls"></i>{{isEn ? item.popedomName:item.popedomRemark}}</el-button>
              </template>
            </div>
        </div>
        <el-table :empty-text="emptyText" highlight-current-row @current-change="select" :height="detableHeight"  border stripe :data="deTableData"  style="width:100%;">
          <el-table-column align="center" show-overflow-tooltip type="index" width="50"></el-table-column>
          <el-table-column align="center" show-overflow-tooltip :label="$t('appManage.app.name')" prop="appName" min-width="150" ></el-table-column>
          <el-table-column align="center" show-overflow-tooltip :label="$t('version')" prop="appPkgVer" min-width="90"></el-table-column>
          <el-table-column align="center" show-overflow-tooltip :label="$t('downloadFlag')" prop="appDownloadFlag" min-width="170" >
            <template slot-scope="scope">
              <el-tag
                :type="scope.row.appDownloadFlag === '0' ? 'primary' : 'success'"
                close-transition>{{scope.row.appDownloadFlag === '0' ? (isEn?'force download' : '强制下载'):(isEn?'force download' : 'unforced download')}}</el-tag>
            </template>
          </el-table-column>
          <el-table-column align="center" show-overflow-tooltip :label="$t('createTime')" prop="createdDatetime" min-width="160" ></el-table-column>
          <el-table-column align="center" show-overflow-tooltip :label="$t('remark')" prop="appPkgDesc" min-width="160"></el-table-column>
          <el-table-column align="center" show-overflow-tooltip :label="$t('appManage.app.download')" min-width="80">
            <template slot-scope="scope" >
              <el-button :title="isEn ? item.popedomName:item.popedomRemark" class="iconHandle"  v-for="(item,index) in popedomList.button" v-if="(item.popedomId=='0310602')" @click="downloadPkg(scope.row)" :key="index" type="success" size="mini"><i class="iconfont" :class="item.popedomIconcls"></i>{{isEn ? item.popedomName:item.popedomRemark}}</el-button></template></el-table-column>
          <el-table-column align="center" show-overflow-tooltip :label="$t('operation')" min-width="80">
            <template slot-scope="scope" >
              <el-button :title="isEn ? item.popedomName:item.popedomRemark" class="iconHandle"  v-for="(item,index) in popedomList.button" v-if="(item.popedomId=='0310603')" @click="openDelete(scope.row)" :key="index" type="info" size="mini"><i class="iconfont" :class="item.popedomIconcls"></i></el-button>
            </template></el-table-column>
        </el-table>
        <my-pagination @loadingStatus="loadingStatus" :reload="dereload" :searchParams="deSearchData"  :url="deUrl" @tableContent="deTableContent"></my-pagination>
      </div>
    </el-dialog>
    <!--添加应用包-->
    <el-dialog  :title="$t('appManage.app.addpackageFormTitle')" :visible.sync="pkgVisiable" :close-on-click-modal="false">
      <el-form  :model="addPkgForm" :rules="rules" label-width="150px" ref="addPkgForm" >
        <input type="hidden" v-model="addPkgForm.appId">
        <el-form-item :label="$t('appManage.app.selectPackage')" prop="addfileName">
          <input  ref="file" type="file" style='display:none' @change="fileChange()"/>
          <el-input v-model="addPkgForm.addfileName" style='display:none' auto-complete="off"></el-input>
          <el-button type="primary" size="mini" @click="selectFile()">{{$t('selectFile')}}</el-button>
          <el-tag v-if="addPkgForm.addfileName"  type="primary">{{addPkgForm.addfileName}}</el-tag>
        </el-form-item>
        <el-form-item prop="appDownloadFlag" :label="$t('downloadFlag')">
          <el-radio-group v-model="addPkgForm.appDownloadFlag">
            <el-radio label="0">{{$t('forceDownload')}}</el-radio>
            <el-radio label="1">{{$t('unforcedDownload')}}</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item prop="appPkgVer" :label="$t('version')" >
          <el-input v-model="addPkgForm.appPkgVer"></el-input>
        </el-form-item>
        <el-form-item prop="appPkgDesc" :label="$t('remark')" >
          <el-input type="textarea" v-model="addPkgForm.appPkgDesc"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="addPkg()" :loading="handleLoading">{{$t('ok')}}</el-button>
        <el-button @click="pkgVisiable=false">{{$t('cancel')}}</el-button>
      </div>
    </el-dialog>
  </div>
</template>
<script>
import mixin from '@/mixins/mixin'
import {appRules} from '@/mixins/rules'
export default {
  mixins: [mixin],
  data () {
    return {
      dereload:false,
      detableHeight:'300',
      deTableData:[],
      deUrl:'/oversea_tms/appPkg/showAppPkgByPage.action',
      detailVisiable:false,
      treeVisiableAdd:false,
      treeData:[],
      treeVisiableEdit:false,
      propsOrg: {
          label: 'orgName'
      },
      url:'/oversea_tms/app/showAppByPage.action',
      searchParams:{ appName:'', appStatus:'', pageNo:1, pageSize:10 },  
      deSearchData:{ pageNo:1, pageSize:10 },
      deviceData:[],
      addForm:{ bak1:"", modelData:[], appName:'', appDesc:'', brandId:'',modelTypeId:'', modelId:'', appContact:'', file:'',addfileName:'' },
      editForm:{ orgName:"", bak1:"", appId:'', appName:'', appDesc:'', brandId:'',modelTypeId:'', modelId:'', appContact:'',deviceArray:'',addfileName:'',file:'' },
      pkgVisiable:false,
      addPkgForm:{ appId:'', appPkgVer:'', appDownloadFlag:'0', uploadFile:'', appPkgDesc:'', addfileName:'' },
      props:{
        'value':'id',
        'label':'name'
      },
      rules:appRules,
    };
  },
  mounted () {
    this.getData({
      url:'/oversea_tms/brand/allBrand.action',
      success:(data)=>{
        this.deviceData=data;
      }
    });
    this.getData({
      url:'/oversea_tms/organization/showOrgListForOrg.action',
      success:(datas)=>{
        if(datas.message){
              this.$message.error(datas.message);
          }else{
              this.treeData=datas;
          }
      }
    })
  },
  methods: {
    orgAdd(node){
      this.treeVisiableAdd=false;
      this.addForm.bak1=node.orgId;
      this.addForm.orgName=node.orgName;
    },
    orgEdit(node){
        this.treeVisiableEdit=false;
        this.editForm.bak1=node.orgId;
        this.editForm.orgName=node.orgName;
    },
    deTableContent(data){//加载应用包详情表格数据
      this.deTableData=data;
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
              name:this.$t('hasTerminal'),
              disabled: true,
            }]
            this.deviceData[index[0]].children[index[1]].children=arr
          }else{
            this.deviceData[index[0]].children[index[1]].children=data;
          }
        }
      })
    },
    selectDevice(value){
      this.addForm.brandId=value[0];
      this.addForm.modelTypeId=value[1];
      this.addForm.modelId=value[2];
    },
    showAddApp(){
      this.addVisiable=true;
      
    },  
    addApp(){
      this.$refs.addForm.validate((valid)=>{
        if(valid){
          
          this.fileSubmit({
            data:this.addForm,
            url:'/oversea_tms/app/addApp.action',
            success:(data)=>{
              this.reload=!this.reload;
              this.addVisiable=false;
                
              this.$refs.addForm.resetFields();
            }
          })
        }
      })
    },
    showEditApp(row){
      this.editVisiable=true;
      
      Object.keys(this.editForm).forEach((key)=>{
          this.editForm[key]=row[key];
      })
      this.editForm.deviceArray=[];
      this.editForm.deviceArray.push(row.brandId);
      this.editForm.deviceArray.push(row.modelTypeId);
      this.editForm.deviceArray.push(row.modelId);
    },
    editApp(){
      this.$refs.editForm.validate((valid)=>{
        if(valid){
          
          this.fileSubmit({
              data:this.editForm,
              url:'/oversea_tms/app/updateApp.action',
              success:(data)=>{
                this.reload=!this.reload;
                this.editVisiable=false;
                  
              }
          })
        }
      })
    },
    deleteApp(row){
      this.confirm({
          title:this.$t('appManage.app.deleteConfirm'),
          data:{
              "appId":row.appId
          },
          url:'/oversea_tms/app/deleteApp.action',
          success:(data)=>{
              this.reload=!this.reload;
          }
      })
    },
    onLineApp(row){
      this.confirm({
          title:this.$t('appManage.app.onlineConfirm'),
          data:{
              "appId":row.appId
          },
          url:'/oversea_tms/app/onlineApp.action',
          success:(data)=>{
              this.reload=!this.reload;
          }
      })
    },
    outLineApp(row){
      this.confirm({
          title:this.$t('appManage.app.outlineConfirm'),
          data:{
              "appId":row.appId
          },
          url:'/oversea_tms/app/offlineApp.action',
          success:(data)=>{
              this.reload=!this.reload;
          }
      })
    },
    showAppPkg(row){
      this.deUrl='/oversea_tms/appPkg/showAppPkgByPage.action?appId='+row.appId;
      this.dereload=!this.dereload;
      this.detailVisiable=true;
    },
    showUploadPkg(){
      
      this.pkgVisiable=true;
    },
    selectFile(type){//选择文件
      if(type=="iconAdd"){
        this.$refs.iconFileAdd.click()
      }else if(type=="iconEdit"){
        this.$refs.iconFileEdit.click()
      }else{
        this.$refs.file.click()
      }
    },
    fileChange(type){//文件改变
      if(type=="iconAdd"){
        this.addForm.addfileName=this.$refs.iconFileAdd.files[0].name;
        this.addForm.file=this.$refs.iconFileAdd.files[0];
      }else if(type=="iconEdit"){
        this.editForm.addfileName=this.$refs.iconFileEdit.files[0].name;
        this.editForm.file=this.$refs.iconFileEdit.files[0];
      }else{
        this.addPkgForm.addfileName=this.$refs.file.files[0].name;
        this.addPkgForm.uploadFile=this.$refs.file.files[0];
      }
    },
    addPkg(){
      this.$refs.addPkgForm.validate((valid)=>{
        if(valid){
          
          this.addPkgForm.appId=this.rowData.appId
          this.fileSubmit({
            data:this.addPkgForm,
            url:'/oversea_tms/appPkg/uploadAppPkg.action',
            success:(data) => {
              this.dereload=!this.dereload;
              this.pkgVisiable=false;
              this.$refs.addPkgForm.resetFields();
            }
          })
        }
      })
      
    },
    downloadPkg(row){
      this.$confirm(this.$t('appManage.app.downloadConfirm'), this.$t('prompt'), {
        confirmButtonText: this.$t('ok'),
        cancelButtonText: this.$t('cancel'),
        type: 'warning'
      }).then(() => {
        window.open("/oversea_tms/appPkg/downloadAppPkg.action?appId="+this.rowData.appId+"&appPkgVer="+row.appPkgVer);
      }).catch(()=>{})
    },
    openDelete(row){
      this.confirm({
        title:this.$t("appManage.app.deletePkgConfirm"),
        data:{
          "appId":row.appId,
          "appPkgVer":row.appPkgVer
        },
        url:'/oversea_tms/appPkg/deleteAppPkg.action',
        success:(data)=>{
            this.dereload=!this.dereload;
        }
      })
    }
  }
}
</script>
