<template>
  <div class="posp">
    <!-- 条件search -->
    <div class="search">
      <more-panel>
        <el-form  slot="form" :inline="true"  class="demo-form-inline">
          <el-form-item  :label="$t('parameterManage.posp.paramType')">
              <el-select size="small" v-model="searchParams.paramType">
                <el-option :label="isEn?'CAPK':'公钥'" value="1" ></el-option>
                <el-option :label="isEn?'AID':'磁条卡参数'" value="2" ></el-option>
              </el-select>
          </el-form-item>
        </el-form>
        <div slot="control">
          <el-button  size="small" icon="search" type="primary" @click="search()">{{$t('search')}}</el-button>
          <el-button  size="small" icon="circle-close" type="primary"  @click="reset()">{{$t('reset')}}</el-button>
          <template  v-for="(item,index) in popedomList.button">
            <el-button v-if="item.popedomId=='05201'" size="small" type="primary" @click="addVisiable=true" :key="index"><i class="iconfont" v-bind:class="item.popedomIconcls"></i>{{isEn ? item.popedomName:item.popedomRemark}}</el-button>
          </template>
        </div>
      </more-panel>
    </div>
    <el-table class="table" :empty-text="emptyText" highlight-current-row @current-change="select" :height="tableHeight"  border stripe :data="tableData"  style="width:100%;">
      <el-table-column align="center" show-overflow-tooltip type="index" width="50"></el-table-column>
      <el-table-column type="expand">
          <template slot-scope="props">
              <el-form label-position="left" inline class="demo-table-expand" >
                  <el-form-item :label="$t('parameterManage.posp.paramVal')">
                  <span class="itemValue">{{ props.row.paramVal }}</span>
                  </el-form-item>
              </el-form>
          </template>
      </el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('parameterManage.posp.paramNo')" prop="paramNo" min-width="90" ></el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('parameterManage.posp.paramType')" prop="paramType"  min-width="100" :formatter="formatter"></el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('parameterManage.posp.paramVer')" prop="paramVer" min-width="80"></el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('parameterManage.posp.createOprater')" prop="createOprater" min-width="100"></el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('createTime')" prop="createDatetime" min-width="120"></el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('operation')" min-width="120">
        <template slot-scope="scope" >
          <el-button :title="isEn ? item.popedomName:item.popedomRemark" class="iconHandle"  v-for="(item,index) in popedomList.button" v-if="(item.popedomId=='05202')" @click="showEditPosp(scope.row)" :key="index" type="warning" size="mini"><i class="iconfont" :class="item.popedomIconcls"></i></el-button>
          <el-button :title="isEn ? item.popedomName:item.popedomRemark" class="iconHandle"  v-for="(item,index) in popedomList.button" v-if="(item.popedomId=='05203')" @click="showDeletePosp(scope.row)" :key="index" type="info" size="mini"><i class="iconfont" :class="item.popedomIconcls"></i></el-button>
        </template></el-table-column>
    </el-table>
    <my-pagination @loadingStatus="loadingStatus" :reload="reload" :searchParams="searchParams" :searchFlag="searchFlag" :url="url" @tableContent="tableContent"></my-pagination>
    <!-- 添加参数 -->
    <el-dialog width="40%" :title="$t('parameterManage.posp.addFormTitle')" :visible.sync="addVisiable" :close-on-click-modal="false">
      <el-form :model="addForm" :rules="rules" label-width="180px" ref="addForm" >
        <el-form-item prop="paramType" :label="$t('parameterManage.posp.paramType')" >
          <el-select v-model="addForm.paramType">
            <el-option :label="isEn?'CAPK':'公钥'" value="1" ></el-option>
            <el-option :label="isEn?'AID':'磁条卡参数'" value="2" ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item prop="paramNo" :label="$t('parameterManage.posp.paramNo')" >
          <el-input type="text" v-model="addForm.paramNo"></el-input>
        </el-form-item>
        <el-form-item prop="paramVer" :label="$t('parameterManage.posp.paramVer')" >
          <el-input type="text" v-model="addForm.paramVer"></el-input>
        </el-form-item>
        <el-form-item prop="paramVal" :label="$t('parameterManage.posp.paramVal')" >
          <el-input type="textarea" v-model="addForm.paramVal"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="addPosp()" :loading="handleLoading">{{$t('ok')}}</el-button>
        <el-button @click="addVisiable=false">{{$t('cancel')}}</el-button>
      </div>
    </el-dialog>
    <!-- 编辑参数 -->
    <el-dialog width="40%" :title="$t('parameterManage.posp.editFormTitle')" :visible.sync="editVisiable" :close-on-click-modal="false">
      <el-form :model="editForm" :rules="rules" label-width="180px" ref="editForm" >
        <el-form-item prop="paramType" :label="$t('parameterManage.posp.paramType')" >
          <el-select disabled="disabled" v-model="editForm.paramType">
            <el-option :label="isEn?'CAPK':'公钥'" value="1" ></el-option>
            <el-option :label="isEn?'AID':'磁条卡参数'" value="2" ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item prop="paramNo" :label="$t('parameterManage.posp.paramNo')" >
          <el-input disabled="disabled" type="text" v-model="editForm.paramNo"></el-input>
        </el-form-item>
        <el-form-item prop="paramVer" :label="$t('parameterManage.posp.paramVer')" >
          <el-input type="text" v-model="editForm.paramVer"></el-input>
        </el-form-item>
        <el-form-item prop="paramVal" :label="$t('parameterManage.posp.paramVal')" >
          <el-input type="textarea" v-model="editForm.paramVal"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="editPosp()" :loading="handleLoading">{{$t('ok')}}</el-button>
        <el-button @click="editVisiable=false">{{$t('cancel')}}</el-button>
      </div>
    </el-dialog>
  </div>
</template>
<script>
import mixin from '@/mixins/mixin'
import { pospRules } from '@/mixins/rules'
export default {
  mixins: [mixin],
  data () {
    return {
      url:'/oversea_tms/pospParam/showPospParam.action',
      searchParams:{
        paramType:"",
        pageNo:1,
        pageSize:10
      },  
      addForm:{ 
        paramType:"",
        paramNo:"",
        paramVer:"",
        paramVal:""
      },
      editForm:{ 
        paramType:"",
        paramNo:"",
        paramVer:"",
        paramVal:""
      },
      rules:pospRules
    };
  },
  methods: {
    formatter(row){
      return this.isEn?(row.paramType=="1"?'CAPK':"AID"):(row.paramType=="1"?'公钥':"磁条卡参数");
    },
    showEditPosp(row){
      Object.keys(this.editForm).forEach((key)=>{
          this.editForm[key]=row[key];
      })
      this.editVisiable=true;
    },
    showDeletePosp(row){
      this.confirm({
        title:this.$t("parameterManage.posp.deleteConfirm"),
        url:'/oversea_tms/pospParam/deletePospParam.action',
        data:{
          paramNo:row.paramNo,
          paramType:row.paramType
        },
        success:()=>{
          this.reload=!this.reload;
        }
      })
    },
    addPosp(){
      this.$refs.addForm.validate((valid)=>{
        if(valid){
          this.submitData({
            data:this.addForm,
            url:"/oversea_tms/pospParam/addPospParam.action",
            success:(data)=>{
              this.reload=!this.reload;
              this.addVisiable=false;
              this.$refs.addForm.resetFields();
            }
          })
        }
      })
    },
    editPosp(){
      this.$refs.editForm.validate((valid)=>{
        if(valid){
          this.submitData({
            data:this.editForm,
            url:"/oversea_tms/pospParam/updatePospParam.action",
            success:(data)=>{
              this.reload=!this.reload;
              this.addVisiable=false;
              this.$refs.addForm.resetFields();
            }
          })
        }
      })
    }
  }
}
</script>
<style lang="less" >
.posp .table{
  .demo-table-expand .el-form-item,.el-form--inline .el-form-item__content{
    width: 100%;
  }
  .itemValue{
    width: 100%;
    word-wrap:break-word;
    display: inline-block;
  }
}
</style>
