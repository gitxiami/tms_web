<template>
  <div>
    <!-- 条件search -->
    <div class="search">
      <more-panel>
        <el-form  slot="form" :inline="true"  class="demo-form-inline">
          <el-form-item  :label="$t('terminalManage.brand.searchLabel')">
            <el-input onkeydown="if(event.keyCode==13)return false;" @keydown.enter.native="search()" size="small" v-model="searchParams.brandName" :placeholder="$t('terminalManage.brand.searchPlace')" ></el-input>
          </el-form-item>
        </el-form>
        <div slot="control">
          <el-button  size="small" icon="search" type="primary" @click="search()">{{$t('search')}}</el-button>
          <el-button  size="small" icon="circle-close" type="primary"  @click="reset()">{{$t('reset')}}</el-button>
          <template  v-for="(item,index) in popedomList.button">
            <el-button v-if="item.popedomId=='02101'" size="small" type="primary" @click="showAddBrand()" :key="index"><i class="iconfont" v-bind:class="item.popedomIconcls"></i>{{isEn ? item.popedomName:item.popedomRemark}}</el-button>
          </template>
        </div>
      </more-panel>
    </div>
    <el-table :empty-text="emptyText" highlight-current-row @current-change="select" :height="tableHeight"  border stripe :data="tableData"  style="width:100%;">
      <el-table-column align="center" show-overflow-tooltip type="index" width="50"></el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('terminalManage.brand.name')" prop="brandName" min-width="170" ></el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('linkman')" prop="brandLinkman"  min-width="120"></el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('tel')" prop="brandTel" min-width="130"></el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('operation')" min-width="100">
        <template slot-scope="scope" >
          <el-button :title="isEn ? item.popedomName:item.popedomRemark" class="iconHandle"  v-for="(item,index) in popedomList.button" v-if="(item.popedomId=='02102')" @click="showEditBrand(scope.row)" :key="index" type="warning" size="mini"><i class="iconfont" :class="item.popedomIconcls"></i></el-button>
          <el-button :title="isEn ? item.popedomName:item.popedomRemark" class="iconHandle"  v-for="(item,index) in popedomList.button" v-if="(item.popedomId=='02103')" @click="showDeleteBrand(scope.row)" :key="index" type="info" size="mini"><i class="iconfont" :class="item.popedomIconcls"></i></el-button>
        </template></el-table-column>
    </el-table>
    <my-pagination @loadingStatus="loadingStatus" :reload="reload" :searchParams="searchParams" :searchFlag="searchFlag" :url="url" @tableContent="tableContent"></my-pagination>
    <!--添加厂商-->
    <el-dialog width="30%" :title="$t('terminalManage.brand.addFormTitle')" :visible.sync="addVisiable" :close-on-click-modal="false">
      <el-form :model="addForm" :rules="rules" label-width="120px" ref="addForm" >
        <el-form-item prop="brandName" :label="$t('terminalManage.brand.name')" >
          <el-input v-model="addForm.brandName"></el-input>
        </el-form-item>
        <el-form-item prop="brandLinkman" :label="$t('linkman')" >
          <el-input type="text" v-model="addForm.brandLinkman"></el-input>
        </el-form-item>
        <el-form-item prop="brandTel" :label="$t('tel')" >
          <el-input type="text" v-model="addForm.brandTel"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="addBrand()" :loading="handleLoading">{{$t('ok')}}</el-button>
        <el-button @click="addVisiable=false">{{$t('cancel')}}</el-button>
      </div>
    </el-dialog>
    <!--修改厂商-->
    <el-dialog width="30%" :title="$t('terminalManage.brand.editFormTitle')" :visible.sync="editVisiable" :close-on-click-modal="false">
      <el-form :model="editForm" :rules="rules" label-width="120px" ref="editForm" >
        <el-form-item prop="brandName" :label="$t('terminalManage.brand.name')" >
          <el-input v-model="editForm.brandName"></el-input>
        </el-form-item>
        <el-form-item prop="brandLinkman" :label="$t('linkman')" >
          <el-input type="text" v-model="editForm.brandLinkman"></el-input>
        </el-form-item>
        <el-form-item prop="brandTel" :label="$t('tel')" >
          <el-input type="text" v-model="editForm.brandTel"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="editBrand()" :loading="handleLoading">{{$t('ok')}}</el-button>
        <el-button @click="editVisiable=false">{{$t('cancel')}}</el-button>
      </div>
    </el-dialog>
  </div>
</template>
<script>
import mixin from '@/mixins/mixin'
import {brandRules} from '@/mixins/rules'
export default {
  mixins: [mixin],
  data () {
    return {
      url:'/oversea_tms/brand/showBrand.action',
      searchParams:{
          brandName:'',
          pageNo:1,
          pageSize:10
      },
      addForm:{
        brandName:'',
        brandLinkman:'',
        brandTel:''
      },
      editForm:{
        brandId:'',
        brandName:'',
        brandLinkman:'',
        brandTel:''
      },
      rules:brandRules
    };
  },
  methods: {
    showAddBrand(){
      
      this.addVisiable=true;
    },
    addBrand(){
      this.$refs.addForm.validate((valid)=>{
        if(valid){
          
          this.submitData({
            url:'/oversea_tms/brand/addBrand.action',
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
    showEditBrand(row){
      this.editVisiable=true;
      
      Object.keys(this.editForm).forEach((key)=>{
          this.editForm[key]=row[key];
      })
    },
    editBrand(){
      this.$refs.editForm.validate((valid)=>{
        if(valid){
          
          this.submitData({
            url:'/oversea_tms/brand/updateBrand.action',
            data:this.editForm,
            success:(data)=>{
              this.reload=!this.reload;
              
              this.editVisiable=false;
            }
          })
        }
      })
    },
    showDeleteBrand(row){
      this.confirm({
        title:this.$t("terminalManage.brand.deleteConfirm"),
        url:'/oversea_tms/brand/deleteBrand.action',
        data:{
          'brandId':row.brandId
        },
        success:()=>{
          this.reload=!this.reload;
        }
      })
    }
  }
}
</script>