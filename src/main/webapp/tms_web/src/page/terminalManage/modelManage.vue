<template>
  <div>
    <!-- 条件search -->
    <div class="search">
      <more-panel>
        <el-form  slot="form" :inline="true"  class="demo-form-inline">
          <el-form-item  :label="$t('terminalManage.brand.searchLabel')">
            <el-select v-model="searchParams.brandId">
                <el-option :placeholder="$t('terminalManage.brand.searchPlace')" :key="index" v-for="(item,index) in brandData" :label="item.brandName" :value="item.brandId" ></el-option>
            </el-select>
          </el-form-item>
        </el-form>
        <div slot="control">
          <el-button  size="small" icon="search" type="primary" @click="search()">{{$t('search')}}</el-button>
          <el-button  size="small" icon="circle-close" type="primary"  @click="reset()">{{$t('reset')}}</el-button>
          <template  v-for="(item,index) in popedomList.button">
            <el-button v-if="item.popedomId=='02201'" size="small" type="primary" @click="showAddModel()" :key="index"><i class="iconfont" v-bind:class="item.popedomIconcls"></i>{{isEn ? item.popedomName:item.popedomRemark}}</el-button>
          </template>
        </div>
      </more-panel>
    </div>
    <el-table :empty-text="emptyText" highlight-current-row @current-change="select" :height="tableHeight"  border stripe :data="tableData"  style="width:100%;">
      <el-table-column align="center" show-overflow-tooltip type="index" width="50"></el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('terminalManage.brand.name')" prop="brandName" min-width="170" ></el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('terminalManage.model.type')" prop="modelTypeName"  min-width="160"></el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('terminalManage.model.model')" prop="modelName" min-width="160"></el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('operation')" min-width="100">
        <template slot-scope="scope" >
          <el-button :title="isEn ? item.popedomName:item.popedomRemark" class="iconHandle"  v-for="(item,index) in popedomList.button" v-if="(item.popedomId=='02202')" @click="showEditModel(scope.row)" :key="index" type="warning" size="mini"><i class="iconfont" :class="item.popedomIconcls"></i></el-button>
          <el-button :title="isEn ? item.popedomName:item.popedomRemark" class="iconHandle"  v-for="(item,index) in popedomList.button" v-if="(item.popedomId=='02203')" @click="showDeleteModel(scope.row)" :key="index" type="info" size="mini"><i class="iconfont" :class="item.popedomIconcls"></i></el-button>
        </template></el-table-column>
    </el-table>
    <my-pagination @loadingStatus="loadingStatus" :reload="reload" :searchParams="searchParams" :searchFlag="searchFlag" :url="url" @tableContent="tableContent"></my-pagination>
    <!--添加型号-->
    <el-dialog width="30%" :title="$t('terminalManage.model.addFormTitle')" :visible.sync="addVisiable" :close-on-click-modal="false">
      <el-form :model="addForm" :rules="rules" label-width="120px" ref="addForm" >
        <el-form-item prop="brandId" :label="$t('terminalManage.brand.name')" >
          <el-select v-model="addForm.brandId">
              <el-option :key="index" v-for="(item,index) in brandData" :label="item.brandName" :value="item.brandId" ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item prop="modelTypeId" :label="$t('terminalManage.model.type')" >
          <el-select v-model="addForm.modelTypeId">
              <el-option  label="Fixed POS" value="1" ></el-option>
              <el-option  label="Traditional POS" value="2" ></el-option>
              <el-option  label="Intelligent POS" value="3" ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item prop="modelName" :label="$t('terminalManage.model.model')" >
          <el-input type="text" v-model="addForm.modelName"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="addModel()" :loading="handleLoading">{{$t('ok')}}</el-button>
        <el-button @click="addVisiable=false">{{$t('cancel')}}</el-button>
      </div>
    </el-dialog>
    <!--修改型号-->
    <el-dialog width="30%" :title="$t('terminalManage.model.editFormTitle')" :visible.sync="editVisiable" :close-on-click-modal="false">
      <el-form :model="editForm" :rules="rules" label-width="120px" ref="editForm" >
        <el-form-item prop="brandId" :label="$t('terminalManage.brand.name')" >
          <el-select v-model="editForm.brandId">
              <el-option :key="index" v-for="(item,index) in brandData" :label="item.brandName" :value="item.brandId" ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item prop="modelTypeId" :label="$t('terminalManage.model.type')" >
          <el-select v-model="editForm.modelTypeId">
              <el-option  label="Fixed POS" value="1" ></el-option>
              <el-option  label="Traditional POS" value="2" ></el-option>
              <el-option  label="Intelligent POS" value="3" ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item prop="modelName" :label="$t('terminalManage.model.model')" >
          <el-input type="text" v-model="editForm.modelName"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="editModel()" :loading="handleLoading">{{$t('ok')}}</el-button>
        <el-button @click="editVisiable=false">{{$t('cancel')}}</el-button>
      </div>
    </el-dialog>
  </div>
</template>
<script>
import mixin from '@/mixins/mixin'
import { modelRules } from '@/mixins/rules'
export default {
  mixins: [mixin],
  data () {
    return {
      url:'/oversea_tms/model/showModel.action',
      searchParams:{
          brandId:'',
          pageNo:1,
          pageSize:10
      },
      brandData:[],
      addForm:{
        brandId:'',
        modelTypeId:'',
        modelName:''
      },
      editForm:{
        brandId:'',
        modelTypeId:'',
        modelName:'',
        modelId:''
      },
      rules:modelRules
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
    showAddModel(){
      
      this.addVisiable=true;
    },
    addModel(){
      this.$refs.addForm.validate((valid)=>{
        if(valid){
          
          this.submitData({
            url:'/oversea_tms/model/addModel.action',
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
    showEditModel(row){
      this.editVisiable=true;
      
      Object.keys(this.editForm).forEach((key)=>{
          this.editForm[key]=row[key];
      })
    },
    editModel(){
      this.$refs.editForm.validate((valid)=>{
        if(valid){
          
          this.submitData({
            url:'/oversea_tms/model/updateModel.action',
            data:this.editForm,
            success:(data)=>{
              this.reload=!this.reload;
              
              this.editVisiable=false;
            }
          }) 
        }
      })
    },
    showDeleteModel(row){
      this.confirm({
        title:this.$t("terminalManage.model.deleteConfirm"),
        url:'/oversea_tms/model/deleteModel.action',
        data:{
          'modelId':row.modelId
        },
        success:()=>{
          this.reload=!this.reload;
        }
      })
    }
  }
}
</script>