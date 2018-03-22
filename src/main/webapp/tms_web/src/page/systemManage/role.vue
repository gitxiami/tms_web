<template>
  <div>
    <!-- 条件search -->
    <div class="search">
      <more-panel>
        <el-form  slot="form" :inline="true"  class="demo-form-inline">
          <el-form-item  :label="$t('systemManage.role.searchLabel')">
            <el-input onkeydown="if(event.keyCode==13)return false;" @keydown.enter.native="search()" size="small" v-model="searchParams.roleName" :placeholder="$t('systemManage.role.searchPlaceHolder')" ></el-input>
          </el-form-item>
        </el-form>
        <div slot="control">
          <el-button  size="small" icon="search" type="primary" @click="search()">{{$t('search')}}</el-button>
          <el-button  size="small" icon="circle-close" type="primary"  @click="reset()">{{$t('reset')}}</el-button>
          <template  v-for="(item,index) in popedomList.button">
            <el-button v-if="item.popedomId=='01201'" size="small" type="primary" @click="openAddRole()" :key="index"><i class="iconfont" v-bind:class="item.popedomIconcls"></i>{{isEn ? item.popedomName:item.popedomRemark}}</el-button>
          </template>
        </div>
      </more-panel>
    </div>
    <el-table :empty-text="emptyText" highlight-current-row @current-change="select" :height="tableHeight"  border stripe :data="tableData"  style="width:100%;">
      <el-table-column align="center" show-overflow-tooltip type="index" width="50"></el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('systemManage.role.fieldId')" prop="roleId" min-width="240" ></el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('systemManage.role.fieldname')" prop="roleName" min-width="170" ></el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('remark')" prop="roleRemark" min-width="220"></el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('operation')" min-width="170">
        <template slot-scope="scope" >
          <el-button :title="isEn ? item.popedomName:item.popedomRemark" class="iconHandle"  v-for="(item,index) in popedomList.button" v-if="(item.popedomId=='01202')" @click="openEditRole(scope.row)" :key="index" type="warning" size="mini"><i class="iconfont" :class="item.popedomIconcls"></i></el-button>
          <el-button :title="isEn ? item.popedomName:item.popedomRemark" class="iconHandle"  v-for="(item,index) in popedomList.button" v-if="(item.popedomId=='01204')" @click="openConfigRole(scope.row)" :key="index" type="success" size="mini"><i class="iconfont" :class="item.popedomIconcls"></i></el-button>
          <el-button :title="isEn ? item.popedomName:item.popedomRemark" class="iconHandle"  v-for="(item,index) in popedomList.button" v-if="(item.popedomId=='01203')" @click="openDeleteRole(scope.row)" :key="index" type="info" size="mini"><i class="iconfont" :class="item.popedomIconcls"></i></el-button>
        </template></el-table-column>
    </el-table>
    <my-pagination @loadingStatus="loadingStatus" :reload="reload" :searchParams="searchParams" :searchFlag="searchFlag" :url="url" @tableContent="tableContent"></my-pagination>
    <!--添加角色-->
    <el-dialog width="40%" :title="$t('systemManage.role.addFormTitle')" :visible.sync="addVisiable" :close-on-click-modal="false">
      <el-form :model="addForm" :rules="rules" label-width="130px" ref="addForm" >
        <el-form-item prop="roleName" :label="$t('systemManage.role.fieldname')" >
          <el-input v-model="addForm.roleName"></el-input>
        </el-form-item>
        <el-form-item prop="roleRemark" :label="$t('remark')" >
          <el-input type="textarea" v-model="addForm.roleRemark"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="addRole()" :loading="handleLoading">{{$t('ok')}}</el-button>
        <el-button @click="addVisiable=false">{{$t('cancel')}}</el-button>
      </div>
    </el-dialog>
    <!--编辑角色-->
    <el-dialog width="40%" :title="$t('systemManage.role.editFormTitle')" :visible.sync="editVisiable" :close-on-click-modal="false">
      <el-form :model="editForm" :rules="rules" label-width="130px" ref="editForm" >
        <el-form-item prop="roleName" :label="$t('systemManage.role.fieldname')" >
          <el-input v-model="editForm.roleName"></el-input>
        </el-form-item>
        <el-form-item prop="roleRemark" :label="$t('remark')" >
          <el-input type="textarea" v-model="editForm.roleRemark"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="editRole()" :loading="handleLoading">{{$t('ok')}}</el-button>
        <el-button @click="editVisiable=false">{{$t('cancel')}}</el-button>
      </div>
    </el-dialog>
    <el-dialog width="75%" class="popedomDialog" :title="$t('systemManage.role.configFormTitle')" :visible.sync="configVisiable" :close-on-click-modal="false">
      <el-row  v-for="(item,index) in popedomData" :key="index" >
        <el-col :span="3">
          <el-checkbox-group v-model="checkedPopedom" @change="handleCheckedCitiesChange">
            <el-checkbox @change="checkChange(item,$event)" :key="index" :label="item.popedomId">{{isEn ? item.popedomName:item.popedomRemark}}</el-checkbox>
          </el-checkbox-group>
        </el-col>
        <el-col :span="21">
          <div class="grid-content bg-purple" v-for="(item2,index2) in item.children" :key="index2">
            <el-col :span="4">
              <el-checkbox-group v-model="checkedPopedom" @change="handleCheckedCitiesChange">
                <el-checkbox @change="checkChange(item2,$event)" :key="index2" :label="item2.popedomId">{{isEn ? item2.popedomName:item2.popedomRemark}}</el-checkbox>
              </el-checkbox-group>
            </el-col>
            <el-col :span="20">
              <el-checkbox-group v-model="checkedPopedom" @change="handleCheckedCitiesChange">
                <div class="left" style="width:25%" v-for="(item3,index3) in item2.children" :key="index3">
                  <el-checkbox :label="item3.popedomId" >{{isEn ? item3.popedomName:item3.popedomRemark}}</el-checkbox>
                </div>
              </el-checkbox-group>
            </el-col>
          </div>
        </el-col>
      </el-row>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="configRole()" :loading="handleLoading">{{$t('ok')}}</el-button>
        <el-button @click="configVisiable=false">{{$t('cancel')}}</el-button>
      </div>
    </el-dialog>
  </div>
</template>
<script>
import mixin from '@/mixins/mixin'
import {roleRules} from '@/mixins/rules'
export default {
  mixins: [mixin],
  data () {
    return {
      url:'/oversea_tms/role/showRole.action',
      searchParams:{
          roleName:'',
          pageNo:1,
          pageSize:10
      },  
      rules:roleRules,
      addForm:{
        roleName:'',
        roleRemark:''
      },
      editForm:{
        roleId:'',
        roleName:'',
        roleRemark:''
      },
      configVisiable:false,
      popedomData:[],
      checkedPopedom:[],
      checkAll:''
    };
  },
  methods: {
    openAddRole(){
      this.addVisiable=true;
      
    },
    addRole(){
      this.$refs.addForm.validate((valid)=>{
        if(valid){
          
          this.submitData({
              data:this.addForm,
              url:'/oversea_tms/role/addRole.action',
              success:(data)=>{
                this.reload=!this.reload;
                this.addVisiable=false;
                  
                this.$refs.addForm.resetFields();
              }
          })
        }
      })
      
    },
    openEditRole(row){
      this.editVisiable=true;
      
      Object.keys(this.editForm).forEach((key)=>{
          this.editForm[key]=row[key];
      })
    },
    editRole(){
      this.$refs.editForm.validate((valid)=>{
        if(valid){
          
          this.submitData({
              data:this.editForm,
              url:'/oversea_tms/role/updateRole.action',
              success:(data)=>{
                this.reload=!this.reload;
                this.editVisiable=false;
                  
              }
          })
        }
      })
      
    },
    openDeleteRole(row){
      this.confirm({
        title:this.$t("systemManage.role.deleteConfirm"),
        url:'/oversea_tms/role/deleteRole.action',
        data:{
          roleId:row.roleId
        },
        success:(data)=>{
          this.reload=!this.reload;
        }
      })
    },
    openConfigRole(row){
      if(row.popedomIds!=""){
        this.checkedPopedom=row.popedomIds.split(',');
      }else{
        this.checkedPopedom=[];
      }
      this.configVisiable=true;
    },
    configRole(){
      this.submitData({
        data:{ "roleId":this.rowData.roleId, "popedomIdList":this.checkedPopedom.join(',') },
        url:'/oversea_tms/role/configRole.action',
        success:(data)=>{
          
          this.reload=!this.reload;
          this.configVisiable=false;
        }
      })
    },
    handleCheckedCitiesChange(value){
      this.checkedPopedom=value;
    },
    checkChange(obj,checked){
      if(checked){
        this.checkedPopedom.push.apply(this.checkedPopedom,obj.ids);
        if(obj.children&&obj.children.length){
          obj.children.forEach(element => {
            this.checkedPopedom.push.apply(this.checkedPopedom,element.ids);  
          });
        }
      }else{
        this.checkedPopedom = this.checkedPopedom.filter(key => !obj.ids.includes(key))
        if(obj.children&&obj.children.length){
          obj.children.forEach(element => {
            this.checkedPopedom = this.checkedPopedom.filter(key => !element.ids.includes(key))
          });
        }
      }
    },
    getPopedom(){
      this.getData({
        url:'/oversea_tms/popedom/allPopedom.action',
        success:(data)=>{
          this.popedomData=data;
        }
      })
    }
  },
  mounted () {
    this.getPopedom();
  }
}
</script>
<style lang="less">
  .popedomDialog .el-dialog{
    width: 60%;
  }
  
</style>
