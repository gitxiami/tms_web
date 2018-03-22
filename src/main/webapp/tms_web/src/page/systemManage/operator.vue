<template>
    <div class="operatorPage">
        <div class="search">
            <more-panel>
                <el-form slot="form" :inline="true"  class="demo-form-inline">
                    <el-form-item  :label="$t('systemManage.operator.username')">
                        <el-input ref="opUsername" @keydown.enter.native="search()" size="small" v-model="searchParams.opUsername" :placeholder="$t('systemManage.operator.usernamePlace')" ></el-input>
                    </el-form-item>
                    <el-form-item  :label="$t('systemManage.operator.realname')">
                        <el-input  @keydown.enter.native="search()" size="small" v-model="searchParams.opRealname" :placeholder="$t('systemManage.operator.realnamePlace')" ></el-input>
                    </el-form-item>
                    <el-form-item  :label="$t('systemManage.operator.role')">
                        <el-select size="small" v-model="searchParams.roleId">
                            <el-option :key="index" v-for="(item,index) in roleData" :label="item.roleName" :value="item.roleId" ></el-option>
                        </el-select>
                    </el-form-item>
                </el-form>
                <div slot="control">
                    <el-button  size="small" icon="search" type="primary" @click="search()">{{$t('search')}}</el-button>
                    <el-button  size="small" icon="circle-close" type="primary"  @click="reset()">{{$t('reset')}}</el-button>
                    <template  v-for="(item,index) in popedomList.button">
                        <el-button v-if="item.popedomId=='01101'" size="small" type="primary"  @click="openAddOperator()" :key="index"><i class="iconfont" v-bind:class="item.popedomIconcls"></i>{{isEn ? item.popedomName:item.popedomRemark}}</el-button>
                    </template>
                </div>
            </more-panel>
        </div>
        <el-table :empty-text="emptyText" @current-change="select" :height="tableHeight" :data="tableData" style="width: 100%" highlight-current-row border stripe>
            <el-table-column align="center" show-overflow-tooltip type="index" width="50"></el-table-column>
            <el-table-column type="expand">
                <template slot-scope="props">
                    <el-form label-position="left" inline class="demo-table-expand" >
                        <el-form-item :label="$t('remark')">
                        <span class="itemValue">{{ props.row.opRemark }}</span>
                        </el-form-item>
                    </el-form>
                </template>
            </el-table-column>
            <el-table-column align="center" show-overflow-tooltip :label="$t('systemManage.operator.username')" prop="opUsername" min-width="120" ></el-table-column>
            <el-table-column align="center" show-overflow-tooltip :label="$t('systemManage.operator.realname')" prop="opRealname" min-width="120" ></el-table-column>
            <el-table-column align="center" show-overflow-tooltip :label="$t('systemManage.operator.organization')" prop="orgName" min-width="140" ></el-table-column>
            <el-table-column align="center" show-overflow-tooltip :label="$t('systemManage.operator.role')" prop="roleName" min-width="120"></el-table-column>
            <el-table-column align="center" show-overflow-tooltip :label="$t('systemManage.operator.tel')" prop="opTel" min-width="120"></el-table-column>
            <el-table-column align="center" show-overflow-tooltip :label="$t('systemManage.operator.status')" prop="opStatusName"  min-width="120">
                <template slot-scope="scopes">
                    <el-tag size="small" v-if="scopes.row.opStatus=='0'"  type="success" close-transition>{{isEn?'normal':'正常'}}</el-tag>
                    <el-tag size="small" v-if="scopes.row.opStatus=='1'"  type="danger" close-transition>{{isEn?'locked':'锁定'}}</el-tag>
                </template>
            </el-table-column>
            <el-table-column align="center" show-overflow-tooltip :label="$t('operation')" min-width="200">
                <template slot-scope="scope" >
                    <el-button :title="isEn ? item.popedomName:item.popedomRemark" v-for="(item,index) in popedomList.button" v-if="(item.popedomId=='01102')" @click="openEditOperator(scope.row)" :key="index" type="warning" size="mini"><i class="iconfont" :class="item.popedomIconcls"></i></el-button>
                    <el-button :title="isEn ? item.popedomName:item.popedomRemark" v-for="(item,index) in popedomList.button" v-if="(item.popedomId=='01104')" @click="unlockOperator(scope.row)" :key="index" type="success" size="mini"><i class="iconfont" :class="item.popedomIconcls"></i></el-button>
                    <el-button :title="isEn ? item.popedomName:item.popedomRemark" v-for="(item,index) in popedomList.button" v-if="(item.popedomId=='01105')" @click="resetOperator(scope.row)" :key="index" type="primary" size="mini"><i class="iconfont" :class="item.popedomIconcls"></i></el-button>
                    <el-button :title="isEn ? item.popedomName:item.popedomRemark" v-for="(item,index) in popedomList.button" v-if="(item.popedomId=='01103')" @click="deleteOperator(scope.row)" :key="index" type="info" size="mini"><i class="iconfont" :class="item.popedomIconcls"></i></el-button>
                </template>
            </el-table-column>
        </el-table>
        <my-pagination @loadingStatus="loadingStatus" :reload="reload" :searchParams="searchParams" :searchFlag="searchFlag" :url="url" @tableContent="tableContent"></my-pagination>
        <!--添加用户-->
        <el-dialog  :title="$t('systemManage.operator.addFormTitle')" :visible.sync="addVisiable" :close-on-click-modal="false">
            <el-form  :model="addForm" :rules="rules" label-width="100px" ref="addForm" >
                <el-row>
                    <el-col :lg="{span: 12, offset: 0}" >
                        <el-popover v-model="treeVisiableAdd"  ref="popover2" trigger="click">
                            <el-tree  style="width:200px;height:240px;overflow:auto"
                                @node-click="orgAdd" :expand-on-click-node="false"
                                :data="treeData" :props="props"  node-key="orgId"
                                >
                            </el-tree>
                        </el-popover>
                        <el-form-item prop="orgName" :label="$t('systemManage.operator.organization')" >
                            <el-input readonly v-popover:popover2 v-model="addForm.orgName"></el-input>
                        </el-form-item>
                        <el-form-item prop="roleId" :label="$t('systemManage.operator.role')" >
                            <el-select v-model="addForm.roleId">
                                <el-option :key="index" v-for="(item,index) in roleData" :label="item.roleName" :value="item.roleId" ></el-option>
                            </el-select>
                        </el-form-item>
                        <el-form-item prop="opRealname" :label="$t('systemManage.operator.realname')" >
                        <el-input v-model="addForm.opRealname"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :lg="{span: 12, offset: 0}" >
                        <el-form-item prop="opUsername" :label="$t('systemManage.operator.username')" >
                        <el-input v-model="addForm.opUsername"></el-input>
                        </el-form-item>
                        <el-form-item prop="opTel" :label="$t('systemManage.operator.tel')" >
                        <el-input v-model="addForm.opTel"></el-input>
                        </el-form-item>
                        <el-form-item prop="opRemark" :label="$t('remark')" >
                        <el-input type="textarea" v-model="addForm.opRemark"></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button type="primary" @click="addOperator()" :loading="handleLoading">{{$t('ok')}}</el-button>
                <el-button @click="addVisiable=false">{{$t('cancel')}}</el-button>
            </div>
        </el-dialog>
        <!--编辑用户-->
        <el-dialog :title="$t('systemManage.operator.editFormTitle')" :visible.sync="editVisiable" :close-on-click-modal="false">
            <el-form :model="editForm" :rules="rules" label-width="100px" ref="editForm" >
                <el-row>
                <el-col :lg="{span: 12, offset: 0}" >
                    <el-form-item prop="opUsername" :label="$t('systemManage.operator.username')" >
                    <el-input disabled v-model="editForm.opUsername"></el-input>
                    </el-form-item>
                    <el-popover v-model="treeVisiableEdit"  ref="popover3" trigger="click">
                    <el-tree  style="height:240px;overflow:auto"
                        @node-click="orgEdit" :expand-on-click-node="false"
                        :data="treeData"  :props="props"  node-key="orgId"
                        >
                    </el-tree>
                    </el-popover>
                    <el-form-item prop="orgId" :label="$t('systemManage.operator.organization')">
                    <el-input readonly v-popover:popover3 v-model="editForm.orgName"></el-input>
                    </el-form-item>
                    <el-form-item prop="opRealname" :label="$t('systemManage.operator.realname')">
                    <el-input v-model="editForm.opRealname"></el-input>
                    </el-form-item>
                    
                </el-col>
                <el-col :lg="{span: 12, offset: 0}" >
                    <el-form-item prop="roleId" :label="$t('systemManage.operator.role')" >
                    <el-select v-model="editForm.roleId">
                        <el-option :key="index" v-for="(item,index) in roleData" :label="item.roleName" :value="item.roleId" ></el-option>
                    </el-select>
                    </el-form-item>
                    <el-form-item prop="opTel" :label="$t('systemManage.operator.tel')">
                    <el-input v-model="editForm.opTel"></el-input>
                    </el-form-item>
                    <el-form-item prop="opRemark" :label="$t('remark')">
                    <el-input type="textarea" v-model="editForm.opRemark"></el-input>
                    </el-form-item>
                </el-col>
                </el-row>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button type="primary" @click="editOperator()" :loading="handleLoading">{{$t('ok')}}</el-button>
                <el-button @click="editVisiable=false">{{$t('cancel')}}</el-button>
            </div>
        </el-dialog>
    </div>
</template>
<script>
import mixin from '@/mixins/mixin'
import {opertorRules} from '@/mixins/rules'
import {mapState} from 'vuex'
export default {
  mixins: [mixin],
  data () {
    return {
        url:'/oversea_tms/operator/showOperatorByPage.action',
        searchParams:{
            opUsername:'',
            opRealname:'',
            roleId:'',
            pageNo:1,
            pageSize:10
        },
        treeData:[],
        roleData:[],
        treeVisiableAdd:false,
        treeVisiableEdit:false,
        addForm:{
            orgName:'',opUsername:'',opRealname:'',opTel:'',roleId:'',orgId:'',opRemark:''
        },
        editForm:{
            orgName:'',opId:'',opUsername:'',opRealname:'',opTel:'',roleId:'',orgId:'',opRemark:''
        },
        rules:opertorRules,
        props: {
            label: 'orgName'
        },
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
    this.getData({
        url:'/oversea_tms/role/allRole.action',
        success:(datas)=>{
          if(datas.message){
            this.$message.error(datas.message);
          }else{
            this.roleData=datas;
          }
        }
    })
  },
  methods: {
    openAddOperator(){
        this.addVisiable=true;
    },
    openEditOperator(row){
        this.editVisiable=true;
        Object.keys(this.editForm).forEach((key)=>{
            this.editForm[key]=row[key];
        })
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
    addOperator(){
        this.$refs.addForm.validate((valid)=>{
            if(valid){
                this.submitData({
                    data:this.addForm,
                    url:'/oversea_tms/operator/addOperator.action',
                    success:(data)=>{
                        this.reload=!this.reload;
                        this.addVisiable=false;
                        this.$refs.addForm.resetFields();
                    }
                })
            }
        })
    },
    editOperator(){
        this.$refs.editForm.validate((valid)=>{
            if(valid){
                
                this.submitData({
                    data:this.editForm,
                    url:'/oversea_tms/operator/updateOperator.action',
                    success:(data)=>{
                        this.reload=!this.reload;
                        this.editVisiable=false;
                        
                    }
                })
            }   
        })
    },
    deleteOperator(row){
        this.confirm({
            title:this.$t("systemManage.operator.deleteConfirm"),
            data:{
                "opId":row.opId
            },
            url:'/oversea_tms/operator/logoffOperator.action',
            success:(data)=>{
                this.reload=!this.reload;
            }
        })
    },
    unlockOperator(row){
        this.confirm({
            title:this.$t("systemManage.operator.unlockConfirm"),
            data:{
                "opId":row.opId
            },
            url:'/oversea_tms/operator/unlockOperator.action',
            success:(data)=>{
                this.reload=!this.reload;
            }
        })
    },
    resetOperator(row){
        this.confirm({
            title:this.$t("systemManage.operator.resetConfirm"),
            data:{
                "opId":row.opId
            },
            url:'/oversea_tms/operator/resetPwd.action',
            success:(data)=>{
                this.reload=!this.reload;
            }
        })
    },
  }
}
</script>