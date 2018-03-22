<template>
  <div>
    <!-- 条件search -->
    <div class="search">
      <more-panel>
        <el-form  slot="form" :inline="true"  class="demo-form-inline">
          <el-form-item  :label="$t('merchantManage.merchant.name')">
            <el-input onkeydown="if(event.keyCode==13)return false;" @keydown.enter.native="search()" size="small" v-model="searchParams.mchntName" :placeholder="$t('merchantManage.merchant.namePlace')" ></el-input>
          </el-form-item>
        </el-form>
        <div slot="control">
          <el-button  size="small" icon="search" type="primary" @click="search()">{{$t('search')}}</el-button>
          <el-button  size="small" icon="circle-close" type="primary"  @click="reset()">{{$t('reset')}}</el-button>
          <template  v-for="(item,index) in popedomList.button">
            <el-button v-if="item.popedomId=='04102'" size="small" type="primary" @click="showAddMchnt()" :key="index"><i class="iconfont" v-bind:class="item.popedomIconcls"></i>{{isEn ? item.popedomName:item.popedomRemark}}</el-button>
          </template>
        </div>
      </more-panel>
    </div>
    <el-table :empty-text="emptyText" highlight-current-row @current-change="select" :height="tableHeight"  border stripe :data="tableData"  style="width:100%;">
      <el-table-column align="center" show-overflow-tooltip type="index" width="50"></el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('merchantManage.merchant.name')" prop="mchntName" min-width="150" ></el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('systemManage.log.org')" prop="orgName" min-width="150" ></el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('merchantManage.merchant.artificial')" prop="artifNm"  min-width="120"></el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('merchantManage.merchant.status')" prop="statusName" min-width="130">
        <template slot-scope="scopes">
            <el-tag size="small" v-if="scopes.row.status=='2'" type="danger" close-transition>{{isEn?'stop':'停用'}}</el-tag>
            <el-tag size="small" v-if="scopes.row.status=='1'" type="success" close-transition>{{isEn?'enable':'启用'}}</el-tag>
            <el-tag size="small" v-if="scopes.row.status=='0'" type="info" close-transition>{{isEn?'disable':'未启用'}}</el-tag>
            <el-tag size="small" v-if="scopes.row.status=='4'" type="warning" close-transition>{{isEn?'lockout':'锁定'}}</el-tag>
        </template>
      </el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('operation')" min-width="220">
        <template slot-scope="scope" >
          <el-button :title="isEn ? item.popedomName:item.popedomRemark" class="iconHandle"  v-for="(item,index) in popedomList.button" v-if="(item.popedomId=='04101')" @click="showDetailMchnt(scope.row)" :key="index" type="primary" size="mini"><i class="iconfont" :class="item.popedomIconcls"></i></el-button>
          <el-button :title="isEn ? item.popedomName:item.popedomRemark" class="iconHandle"  v-for="(item,index) in popedomList.button" v-if="(item.popedomId=='04103')" @click="showEditMchnt(scope.row)" :key="index" type="warning" size="mini"><i class="iconfont" :class="item.popedomIconcls"></i></el-button>
          <el-button :title="isEn ? item.popedomName:item.popedomRemark" class="iconHandle"  v-for="(item,index) in popedomList.button" v-if="(item.popedomId=='04104')" @click="showStartMchnt(scope.row)" :key="index" type="success" size="mini"><i class="iconfont" :class="item.popedomIconcls"></i></el-button>
          <el-button :title="isEn ? item.popedomName:item.popedomRemark" class="iconHandle"  v-for="(item,index) in popedomList.button" v-if="(item.popedomId=='04105')" @click="showStopMchnt(scope.row)" :key="index" type="danger" size="mini"><i class="iconfont" :class="item.popedomIconcls"></i></el-button>
          <el-button :title="isEn ? item.popedomName:item.popedomRemark" class="iconHandle"  v-for="(item,index) in popedomList.button" v-if="(item.popedomId=='04106')" @click="showDeleteMchnt(scope.row)" :key="index" type="info" size="mini"><i class="iconfont" :class="item.popedomIconcls"></i></el-button>
        </template></el-table-column>
    </el-table>
    <my-pagination @loadingStatus="loadingStatus" :reload="reload" :searchParams="searchParams" :searchFlag="searchFlag" :url="url" @tableContent="tableContent"></my-pagination>
    <el-dialog top="50px" width="70%" :title="$t('merchantManage.merchant.addFormTitle')" :visible.sync="addVisiable" :close-on-click-modal="false">
      <el-form :model="addForm" :rules="rules" label-width="140px" ref="addForm" >
        <el-row>
          <el-col :lg="{span: 8, offset: 0}"> 
            <el-form-item prop="mchntId" :label="$t('merchantManage.merchant.id')" >
              <el-input type="text" v-model="addForm.mchntId"></el-input>
            </el-form-item>
            <el-form-item prop="mchntAbbr" :label="$t('merchantManage.merchant.businessName')" >
              <el-input type="text" v-model="addForm.mchntAbbr"></el-input>
            </el-form-item>
            <el-form-item prop="mobileNo" :label="$t('merchantManage.merchant.mobileNo')" >
              <el-input type="text" v-model="addForm.mobileNo"></el-input>
            </el-form-item>
            <el-popover v-model="treeVisiableAdd"  ref="popover2" trigger="click">
                <el-tree  style="width:200px;height:240px;overflow:auto"
                    @node-click="orgAdd" :expand-on-click-node="false"
                    :data="treeData" :props="props"  node-key="orgId"
                    >
                </el-tree>
            </el-popover>
          </el-col>
          <el-col :lg="{span: 8, offset: 0}"> 
            <el-form-item prop="mchntName" :label="$t('merchantManage.merchant.name')" >
              <el-input type="text" v-model="addForm.mchntName"></el-input>
            </el-form-item>
            <el-form-item prop="artifCertifId" :label="$t('merchantManage.merchant.IdNumber')" >
              <el-input type="text" v-model="addForm.artifCertifId"></el-input>
            </el-form-item>
            <el-form-item prop="commAddr" :label="$t('merchantManage.merchant.businessAddr')" >
              <el-input type="text" v-model="addForm.commAddr"></el-input>
            </el-form-item>
          </el-col>
          <el-col :lg="{span: 8, offset: 0}"> 
            <el-form-item prop="artifNm" :label="$t('merchantManage.merchant.artificial')" >
              <el-input type="text" v-model="addForm.artifNm"></el-input>
            </el-form-item>
            <el-form-item prop="regAddr" :label="$t('merchantManage.merchant.regAddr')" >
              <el-input type="text" v-model="addForm.regAddr"></el-input>
            </el-form-item>
            <el-form-item prop="orgName" :label="$t('systemManage.log.org')" >
              <el-input readonly v-popover:popover2 v-model="addForm.orgName"></el-input>              
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col  :lg="{span: 24, offset: 0}">
            <el-form-item prop="deviceIds" :label="$t('merchantManage.merchant.terminal')" >
              <el-input disabled type="text" v-model="addForm.deviceIds.join(',')"></el-input>              
            </el-form-item>
          </el-col>
        </el-row>
        <el-table :empty-text="isEn?'no available devices':'没有可用终端'" :height="deTableHeight"  border stripe :data="deTableData"  style="width:100%;">
          <el-table-column align="center" show-overflow-tooltip type="index" width="50"></el-table-column>
          <el-table-column align="center" show-overflow-tooltip :label="$t('merchantManage.merchant.terminalId')" prop="deviceId" min-width="100" ></el-table-column>
          <el-table-column align="center" show-overflow-tooltip :label="$t('deviceSn')" prop="deviceSn" min-width="100" ></el-table-column>
          <el-table-column align="center" show-overflow-tooltip :label="$t('terminalManage.brand.name')" prop="brandName"  min-width="150"></el-table-column>
          <el-table-column align="center" show-overflow-tooltip :label="$t('terminalManage.model.type')" prop="modelTypeName" min-width="120"></el-table-column>
          <el-table-column align="center" show-overflow-tooltip :label="$t('terminalManage.model.model')" prop="modelName" min-width="90"></el-table-column>
          <el-table-column align="center" show-overflow-tooltip :label="$t('operation')" min-width="80">
          <template slot-scope="scope">
            <el-button  class="iconHandle"  @click="addDevice(scope.row,'addForm',$event)" type="success" size="mini"><i class="el-icon-circle-plus-outline" ></i></el-button>
          </template></el-table-column>
        </el-table>
        <my-pagination :reload="deReload" :url="deUrl" @tableContent="deTableContent"></my-pagination>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="addMchnt()" :loading="handleLoading">{{$t('ok')}}</el-button>
        <el-button @click="addVisiable=false">{{$t('cancel')}}</el-button>
      </div>
    </el-dialog>
    <el-dialog top="50px" class="editDialog" width="70%" :title="$t('merchantManage.merchant.editFormTitle')" :visible.sync="editVisiable" :close-on-click-modal="false">
      <el-form :model="editForm" :rules="rules" label-width="140px" ref="editForm" >
        <el-row>
          <el-col :lg="{span: 8, offset: 0}"> 
            <el-form-item prop="mchntId" :label="$t('merchantManage.merchant.id')" >
              <el-input type="text" v-model="editForm.mchntId"></el-input>
            </el-form-item>
            <el-form-item prop="mchntAbbr" :label="$t('merchantManage.merchant.businessName')" >
              <el-input type="text" v-model="editForm.mchntAbbr"></el-input>
            </el-form-item>
            <el-form-item prop="mobileNo" :label="$t('merchantManage.merchant.mobileNo')" >
              <el-input type="text" v-model="editForm.mobileNo"></el-input>
            </el-form-item>
            <el-popover v-model="treeVisiableEdit"  ref="popover3" trigger="click">
                <el-tree  style="width:200px;height:240px;overflow:auto"
                    @node-click="orgEdit" :expand-on-click-node="false"
                    :data="treeData" :props="props"  node-key="orgId"
                    >
                </el-tree>
            </el-popover>
          </el-col>
          <el-col :lg="{span: 8, offset: 0}"> 
            <el-form-item prop="mchntName" :label="$t('merchantManage.merchant.name')" >
              <el-input type="text" v-model="editForm.mchntName"></el-input>
            </el-form-item>
            <el-form-item prop="artifCertifId" :label="$t('merchantManage.merchant.IdNumber')" >
              <el-input type="text" v-model="editForm.artifCertifId"></el-input>
            </el-form-item>
            <el-form-item prop="commAddr" :label="$t('merchantManage.merchant.businessAddr')" >
              <el-input type="text" v-model="editForm.commAddr"></el-input>
            </el-form-item>
          </el-col>
          <el-col :lg="{span: 8, offset: 0}"> 
            <el-form-item prop="artifNm" :label="$t('merchantManage.merchant.artificial')" >
              <el-input type="text" v-model="editForm.artifNm"></el-input>
            </el-form-item>
            <el-form-item prop="regAddr" :label="$t('merchantManage.merchant.regAddr')" >
              <el-input type="text" v-model="editForm.regAddr"></el-input>
            </el-form-item>
            <el-form-item prop="orgName" :label="$t('systemManage.log.org')" >
              <el-input readonly v-popover:popover3 v-model="editForm.orgName"></el-input>              
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col  :lg="{span: 24, offset: 0}">
            <el-form-item  :label="$t('merchantManage.merchant.terminal')" >
              <el-input disabled type="text" v-model="editForm.deviceIds.join(',')"></el-input>              
            </el-form-item>
          </el-col>
        </el-row>
        <el-table :empty-text="isEn?'no available termial':'没有可用终端'" v-if="editVisiable" :height="deTableHeight"   stripe :data="deTableData"  style="width:100%;">
          <el-table-column align="center" show-overflow-tooltip :label="$t('merchantManage.merchant.terminalId')" prop="deviceId" min-width="180" ></el-table-column>
          <el-table-column align="center" show-overflow-tooltip :label="$t('deviceSn')" prop="deviceSn" min-width="120" ></el-table-column>
          <el-table-column align="center" show-overflow-tooltip :label="$t('terminalManage.brand.name')" prop="brandName"  min-width="120"></el-table-column>
          <el-table-column align="center" show-overflow-tooltip :label="$t('terminalManage.model.type')" prop="modelTypeName" min-width="120"></el-table-column>
          <el-table-column align="center" show-overflow-tooltip :label="$t('terminalManage.model.model')" prop="modelName" min-width="120"></el-table-column>
          <el-table-column align="center" show-overflow-tooltip :label="$t('operation')" min-width="80">
          <template slot-scope="scope">
            <el-button  class="iconHandle" type="success" size="mini"><i @click="addDevice(scope.row,'editForm',$event)" class="el-icon-circle-plus-outline" ></i></el-button>
          </template></el-table-column>
          <div slot="append" v-if="editVisiable&&deviceData.length">
            <el-table :show-header="false" :data="deviceData" style="width:100%;border:none"  >
              <el-table-column align="center" show-overflow-tooltip :label="$t('merchantManage.merchant.terminalId')" prop="deviceId" min-width="180" ></el-table-column>
              <el-table-column align="center" show-overflow-tooltip :label="$t('deviceSn')" prop="deviceSn" min-width="120" ></el-table-column>
              <el-table-column align="center" show-overflow-tooltip :label="$t('terminalManage.brand.name')" prop="brandName"  min-width="120"></el-table-column>
              <el-table-column align="center" show-overflow-tooltip :label="$t('terminalManage.model.type')" prop="modelTypeName" min-width="120"></el-table-column>
              <el-table-column align="center" show-overflow-tooltip :label="$t('terminalManage.model.model')" prop="modelName" min-width="120"></el-table-column>
              <el-table-column align="center" show-overflow-tooltip :label="$t('operation')" min-width="80">
              <template slot-scope="scope">
                <el-button  class="iconHandle"   type="info" size="mini"><i @click="addDevice(scope.row,'editForm',$event)" class="el-icon-circle-plus-outline" ></i></el-button>
              </template>
              </el-table-column>
            </el-table>
          </div>
        </el-table>
        <my-pagination :reload="deReloadEdit" :url="deUrl" @tableContent="deTableContent"></my-pagination>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="editMchnt()" :loading="handleLoading">{{$t('ok')}}</el-button>
        <el-button @click="editVisiable=false">{{$t('cancel')}}</el-button>
      </div>
    </el-dialog>
    <el-dialog width="70%" :title="$t('merchantManage.merchant.detailFormTitle')" :visible.sync="detailVisiable" :close-on-click-modal="false">
      <el-alert :title="$t('merchantManage.merchant.basicInfo')" center type="success"></el-alert>
      <table class="detail" style="width:100%">
        <tr>
          <td style="width:20%">{{$t('merchantManage.merchant.id')}}</td>
          <td style="width:30%"><el-tag>{{detailData.mchntId==''?'无':detailData.mchntId}}</el-tag></td>
          <td style="width:20%">{{$t('merchantManage.merchant.businessName')}}</td>
          <td style="width:30%"><el-tag>{{detailData.mchntAbbr==''?'无':detailData.mchntAbbr}}</el-tag></td>
        </tr>
        <tr>
          <td>{{$t('merchantManage.merchant.mobileNo')}}</td>
          <td><el-tag>{{detailData.mobileNo==''?'无':detailData.mobileNo}}</el-tag></td>
          <td>{{$t('merchantManage.merchant.businessAddr')}}</td>
          <td><el-tag>{{detailData.commAddr==''?'无':detailData.commAddr}}</el-tag></td>
        </tr>
        <tr>
          <td>{{$t('merchantManage.merchant.name')}}</td>
          <td><el-tag>{{detailData.mchntName==''?'无':detailData.mchntName}}</el-tag></td>
          <td>{{$t('merchantManage.merchant.IdNumber')}}</td>
          <td><el-tag>{{detailData.artifCertifId==''?'无':detailData.artifCertifId}}</el-tag></td>
        </tr>
        <tr>
          <td>{{$t('merchantManage.merchant.artificial')}}</td>
          <td><el-tag>{{detailData.artifNm==''?'无':detailData.artifNm}}</el-tag></td>
          <td>{{$t('merchantManage.merchant.regAddr')}}</td>
          <td><el-tag>{{detailData.regAddr==''?'无':detailData.regAddr}}</el-tag></td>
        </tr>
        <tr>
          <td>{{$t('systemManage.log.org')}}</td>
          <td><el-tag>{{detailData.orgName==''?'无':detailData.orgName}}</el-tag></td>
        </tr>
      </table>
      <el-alert :title="$t('merchantManage.merchant.terminalInfo')" center type="success"></el-alert>
      <el-table :empty-text="isEn?'no devices':'无绑定终端'" border stripe :data="detailDeviceData"  style="width:100%;">
        <el-table-column align="center" show-overflow-tooltip type="index" width="50"></el-table-column>
        <el-table-column align="center" show-overflow-tooltip :label="$t('merchantManage.merchant.terminalId')" prop="deviceId" min-width="100" ></el-table-column>
        <el-table-column align="center" show-overflow-tooltip :label="$t('deviceSn')" prop="deviceSn" min-width="100" ></el-table-column>
        <el-table-column align="center" show-overflow-tooltip :label="$t('terminalManage.brand.name')" prop="brandName"  min-width="150"></el-table-column>
        <el-table-column align="center" show-overflow-tooltip :label="$t('terminalManage.model.type')" prop="modelTypeName" min-width="120"></el-table-column>
        <el-table-column align="center" show-overflow-tooltip :label="$t('terminalManage.model.model')" prop="modelName" min-width="120"></el-table-column>
      </el-table>
      <div slot="footer" class="dialog-footer">
        <el-button @click="detailVisiable=false">{{$t('cancel')}}</el-button>
      </div>
    </el-dialog>
  </div>
</template>
<script>
import mixin from '@/mixins/mixin'
import {merchantRules} from '@/mixins/rules'
export default {
  mixins: [mixin],
  data () {
    return {
      treeData:[],
      props: {
          label: 'orgName'
      },
      treeVisiableAdd:false,
      treeVisiableEdit:false,
      url:'/oversea_tms/merchant/showMerchantByPage.action',
      deUrl:'/oversea_tms/device/showNoMerchantDevice.action',
      deTableHeight:'230',
      deReload:false,
      deReloadEdit:false,
      deTableData:[],
      searchParams:{
        mchntName:'',
        pageNo:1,
        pageSize:10
      },  
      rules : merchantRules,
      addForm:{
        orgName:'',mchntId:'',mchntName:'',mchntAbbr:'',commAddr:'',mobileNo:'',artifNm:'',artifCertifId:'',regAddr:'',orgId:'',deviceIds:[]
      },
      editForm:{
        orgName:'',mchntId:'',mchntName:'',mchntAbbr:'',commAddr:'',mobileNo:'',artifNm:'',artifCertifId:'',regAddr:'',orgId:'',deviceIds:[]
      },
      deviceData:[],
      detailVisiable:false,
      detailData:{},
      detailDeviceData:[]
    };
  },
  mounted () {
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
    deTableContent(data){
      this.deTableData=data;
    },
    orgAdd(node){
        this.treeVisiableAdd=false;
        this.addForm.orgId=node.orgId;
        this.addForm.orgName=node.orgName;
    },
    orgEdit(node){
        this.treeVisiableEdit=false;
        this.editForm.orgId=node.orgId;
        this.editForm.orgName=node.orgName;
    },
    showAddMchnt(){
      this.addVisiable = true;
      this.deReload = !this.deReload;
    },
    addDevice(row,type,obj){
      if(obj.target.tagName=="SPAN") return ;
      if(obj.target.tagName!="I"){
        if(obj.target.className=="el-button iconHandle el-button--info el-button--mini"){//去除
          for(var i=0; i<this[type].deviceIds.length; i++) {
            if(this[type].deviceIds[i] == row.deviceId) {
              this[type].deviceIds.splice(i, 1);
              break;
            }
          }
          obj.target.setAttribute('class','el-button iconHandle el-button--success el-button--mini');
        }else{//添加
          this[type].deviceIds.push(row.deviceId);
          obj.target.setAttribute('class','el-button iconHandle el-button--info el-button--mini');
        }
      }else{
        if(obj.path[2].className=="el-button iconHandle el-button--info el-button--mini"){
          for(var i=0; i<this[type].deviceIds.length; i++) {
            if(this[type].deviceIds[i] == row.deviceId) {
              this[type].deviceIds.splice(i, 1);
              break;
            }
          }
          obj.path[2].setAttribute('class','el-button iconHandle el-button--success el-button--mini');
        }else{
          this[type].deviceIds.push(row.deviceId);
          obj.path[2].setAttribute('class','el-button iconHandle el-button--info el-button--mini');
        }
      }
    },
    addMchnt(){
      this.$refs.addForm.validate((valid)=>{
        if(valid){
          this.submitData({
            data:this.addForm,
            url:'/oversea_tms/merchant/addMerchant.action',
            success:(data) => {
              this.reload=!this.reload;
              this.addVisiable=false;
              this.$refs.addForm.resetFields();
            }
          })
        }
      })
    },
    showEditMchnt(row){
      this.getData({
        data:{
          mchntId:row.mchntId
        },
        url:'/oversea_tms/merchant/findMerchantById.action',
        success:(data)=>{
          this.deReloadEdit = !this.deReloadEdit;
          Object.keys(this.editForm).forEach((key)=>{
            this.editForm[key]=data.merchant[key];
          })
          this.deviceData = data.device;
          this.editForm.deviceIds=[];
          data.device.forEach((element)=>{
            this.editForm.deviceIds.push(element.deviceId);
          })
          this.editVisiable = true;
        }
      })
    },
    editMchnt(){
      this.$refs.editForm.validate((valid)=>{
        if(valid){
          this.submitData({
            data:this.editForm,
            url:'/oversea_tms/merchant/updateMerchant.action',
            success:(data)=>{
              this.reload=!this.reload;
              this.editVisiable=false;
            }
          })
        }
      })
    },
    showDetailMchnt(row){
      this.getData({
        data:{
          mchntId:row.mchntId
        },
        url:'/oversea_tms/merchant/findMerchantById.action',
        success:(data)=>{
          this.detailData=data.merchant;
          this.detailDeviceData=data.device
          this.detailVisiable=true;
        }
      })
    },
    showStartMchnt(row){
      this.confirm({
        title:this.$t('merchantManage.merchant.startConfirm'),
        data:{
          "mchntId":row.mchntId
        },
        url:'/oversea_tms/merchant/enableMerchant.action',
        success:(data)=>{
          this.reload=!this.reload;
        }
      })
    },
    showStopMchnt(row){
      this.confirm({
        title:this.$t('merchantManage.merchant.stopConfirm'),
        data:{
          "mchntId":row.mchntId
        },
        url:'/oversea_tms/merchant/disableMerchant.action',
        success:(data)=>{
          this.reload=!this.reload;
        }
      })
    },
    showDeleteMchnt(row){
      this.confirm({
        title:this.$t('merchantManage.merchant.deleteConfirm'),
        data:{
          "mchntId":row.mchntId
        },
        url:'/oversea_tms/merchant/delMerchat.action',
        success:(data)=>{
          this.reload=!this.reload;
        }
      })
    }
  }
}
</script>
<style lang="less">
 .detail{
   text-align: center;
   border-collapse:collapse;
 }
 .detail tr td{
   border: 1px solid #eaeefb;
   padding: 5px 0;
 }
 .editDialog .el-table::before{
   display: none;
 }
</style>
