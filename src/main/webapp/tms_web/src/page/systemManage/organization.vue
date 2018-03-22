<template>
  <div>
    <el-row>
      <el-col :lg="5">
        <!-- 机构树 -->
        <div style="padding-right:10px">
          <el-form label-position="right" class="demo-form-inline">
            <el-form-item  >
              <el-input size="small" v-model="branchNameSearch" :placeholder="$t('systemManage.org.searchPlace')" ></el-input>
            </el-form-item>
          </el-form>
          <el-tree style="overflow:auto;border: 1px solid #d1dbe5;" :style="{height:treeHeight}"
            :data="treeData" :default-expand-all="true"  :expand-on-click-node="false"  highlight-current
            :props="props"  node-key="orgId" ref="ztree" :filter-node-method="filterNode"  @current-change="orgSearch">
          </el-tree>
        </div>
      </el-col>
      <el-col :lg="19">
        <el-table highlight-current-row @current-change="select" :height="tableHeight"  border stripe :data="tableData"  style="width:100%;">
            <el-table-column align="center" show-overflow-tooltip type="index" width="50"></el-table-column>
            <el-table-column type="expand">
              <template slot-scope="props">
                <el-form label-position="left" inline class="demo-table-expand" >
                  <el-form-item :label="$t('systemManage.org.level')">
                    <span class="itemValue">{{ props.row.orgLvName}}</span>
                  </el-form-item>
                  <el-form-item :label="$t('tel')" >
                    <span class="itemValue">{{ props.row.orgTel}}</span>
                  </el-form-item>
                  <el-form-item  :label="$t('address')">
                    <span class="itemValue">{{ props.row.orgAddress}}</span>
                  </el-form-item>
                  <el-form-item :label="$t('createTime')" >
                    <span class="itemValue">{{ props.row.createdDatetime}}</span>
                  </el-form-item>
                  <el-form-item :label="$t('updateTime')">
                    <span class="itemValue">{{ props.row.updateDatetime}}</span>
                  </el-form-item>
                  <el-form-item :label="$t('remark')">
                    <span class="itemValue">{{ props.row.orgRemark}}</span>
                  </el-form-item>
                </el-form>
              </template>
            </el-table-column>
            <el-table-column align="center" show-overflow-tooltip :label="$t('systemManage.org.name')" prop="orgName" min-width="120"></el-table-column>
            <el-table-column align="center" show-overflow-tooltip :label="$t('systemManage.org.id')" prop="orgId" min-width="90"></el-table-column>
            <el-table-column align="center" show-overflow-tooltip :label="$t('systemManage.org.type')" prop="orgTypeName" min-width="90"></el-table-column>
            <el-table-column align="center" show-overflow-tooltip :label="$t('linkman')" prop="orgLinkman" min-width="80"></el-table-column>
            <el-table-column align="center" show-overflow-tooltip :label="$t('operation')" min-width="150">
              <template slot-scope="scope" >
                <el-button :title="isEn ? item.popedomName:item.popedomRemark" class="iconHandle"  v-for="(item,index) in popedomList.button" v-if="(item.popedomId=='01301')" @click="showAddOrg(scope.row)" :key="index" type="primary" size="mini"><i class="iconfont" :class="item.popedomIconcls"></i></el-button>
                <el-button :title="isEn ? item.popedomName:item.popedomRemark" class="iconHandle"  v-for="(item,index) in popedomList.button" v-if="(item.popedomId=='01302')" @click="showEditOrg(scope.row)" :key="index" type="warning" size="mini"><i class="iconfont" :class="item.popedomIconcls"></i></el-button>
                <el-button :title="isEn ? item.popedomName:item.popedomRemark" class="iconHandle"  v-for="(item,index) in popedomList.button" v-if="(item.popedomId=='01303')" @click="showDeleteOrg(scope.row)" :key="index" type="info" size="mini"><i class="iconfont" :class="item.popedomIconcls"></i></el-button>
              </template></el-table-column>
        </el-table>
      </el-col>
    </el-row>
    <!--添加子机构-->
    <el-dialog width="65%" :title="$t('systemManage.org.addFormTitle')" :visible.sync="addVisiable" :close-on-click-modal="false">
      <el-form :model="addForm" :rules="rules" label-width="150px" ref="addForm" >
        <el-row>
          <el-col :lg="{span: 11, offset: 0}" >
            <el-form-item prop="orgParentName" :label="$t('systemManage.org.parentOrg')" >
              <el-input disabled v-model="addForm.orgParentName"></el-input>
            </el-form-item>
            <el-form-item prop="orgId" :label="$t('systemManage.org.id')" >
              <el-input v-model="addForm.orgId"></el-input>
            </el-form-item>
            <el-form-item prop="orgType" :label="$t('systemManage.org.type')" >
              <el-select size="small" v-model="addForm.orgType">
                  <el-option label="clearing agencies" :value="0" ></el-option>
                  <el-option label="administrative agencies" :value="1" ></el-option>
              </el-select>
            </el-form-item>
            <el-form-item prop="orgAddress" :label="$t('address')" >
              <el-input type="text" v-model="addForm.orgAddress"></el-input>
            </el-form-item>
          </el-col>
          <el-col :lg="{span: 11, offset: 1}" >
            <el-form-item prop="orgName" :label="$t('systemManage.org.name')" >
              <el-input v-model="addForm.orgName"></el-input>
            </el-form-item>
            <el-form-item prop="orgLinkman" :label="$t('linkman')" >
              <el-input v-model="addForm.orgLinkman"></el-input>
            </el-form-item>
            <el-form-item prop="orgTel" :label="$t('tel')" >
              <el-input v-model="addForm.orgTel"></el-input>
            </el-form-item>
          </el-col>
          <el-col :lg="{span: 23}">
            <el-form-item prop="orgRemark" :label="$t('remark')" >
              <el-input type="textarea" v-model="addForm.orgRemark"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="addOrg()" :loading="handleLoading">{{$t('ok')}}</el-button>
        <el-button @click="addVisiable=false">{{$t('cancel')}}</el-button>
      </div>
    </el-dialog>
    <!--编辑机构-->
    <el-dialog width="65%" :title="$t('systemManage.org.editFormTitle')" :visible.sync="editVisiable" :close-on-click-modal="false">
      <el-form :model="editForm" :rules="rules" label-width="120px" ref="editForm" >
        <el-row>
          <el-col :lg="{span: 11, offset: 0}" >
            <el-form-item prop="orgId" :label="$t('systemManage.org.id')" >
              <el-input disabled v-model="editForm.orgId"></el-input>
            </el-form-item>
            <el-form-item prop="orgType" :label="$t('systemManage.org.type')" >
              <el-select disabled size="small" v-model="editForm.orgType">
                  <el-option label="clearing agencies" value="0" ></el-option>
                  <el-option label="administrative agencies" value="1" ></el-option>
              </el-select>
            </el-form-item>
            <el-form-item prop="orgAddress" :label="$t('address')" >
              <el-input type="text" v-model="editForm.orgAddress"></el-input>
            </el-form-item>
          </el-col>
          <el-col :lg="{span: 11, offset: 1}" >
            <el-form-item prop="orgName" :label="$t('systemManage.org.name')" >
              <el-input v-model="editForm.orgName"></el-input>
            </el-form-item>
            <el-form-item prop="orgLinkman" :label="$t('linkman')" >
              <el-input v-model="editForm.orgLinkman"></el-input>
            </el-form-item>
            <el-form-item prop="orgTel" :label="$t('tel')" >
              <el-input v-model="editForm.orgTel"></el-input>
            </el-form-item>
          </el-col>
          <el-col :lg="{span: 23}">
            <el-form-item prop="orgRemark" :label="$t('remark')" >
              <el-input type="textarea" v-model="editForm.orgRemark"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="editOrg()" :loading="handleLoading">{{$t('ok')}}</el-button>
        <el-button @click="editVisiable=false">{{$t('cancel')}}</el-button>
      </div>
    </el-dialog>
  </div>
</template>
<script>
import mixin from '@/mixins/mixin'
import {orgRules} from '@/mixins/rules'
export default {
  mixins: [mixin],
  data () {
    return {
      treeHeight:'',
      treeData:[],
      branchNameSearch:'',
      props: {
        label: 'orgName',
        children:'children'
      },
      addForm:{
        orgParentName:'', orgName:'',orgId:'',orgPid:'',orgAddress:'',orgLinkman:'',orgTel:'',orgRemark:'',orgType:''
      },
      editForm:{
        orgParentName:'', orgName:'',orgId:'',orgAddress:'',orgLinkman:'',orgTel:'',orgRemark:'',orgType:''
      },
      rules:orgRules
    };
  },
  mounted () {
    this.tableHeight=document.documentElement.clientHeight-117;
    this.treeHeight=document.documentElement.clientHeight-180+'px';
    window.onresize =()=> {
      this.tableHeight=document.documentElement.clientHeight-117;
        this.treeHeight=document.documentElement.clientHeight-180+'px';
    };
    this.initData()
  },
  watch: {
    branchNameSearch(val){
      this.$refs.ztree.filter(val);
    }
  },
  methods: {
    initData(){
      this.getData({
        url:'/oversea_tms/organization/showOrgList.action',
        success:(data)=>{
          this.treeData=data.concat();
          this.tableData=data;
          if(data[0].children){
            data[0].children.forEach((element)=>{
              this.tableData.push(element)
            })
          }
        }
      })
    },
    filterNode(value, data) {//过滤节点
      if (!value) return true;
      return data.orgName.indexOf(value) !== -1;
    },
    orgSearch(node,allNode){
      var arr = allNode.childNodes;
      if(!arr.length) return
      var data=[];
      arr.forEach(function(element) {
        data.push(element.data);
      }, this);
      data.unshift(node)
      this.tableData=data;
    },
    showAddOrg(row){
      this.addForm.orgParentName = row.orgName;
      this.addForm.orgPid = row.orgId;
      this.addVisiable = true;
    },
    addOrg(){
      this.$refs.addForm.validate((valid)=>{
        if(valid){
            this.submitData({
            data:this.addForm,
            url:'/oversea_tms/organization/addOrg.action',
            success:(data)=>{
              this.initData();
              this.addVisiable=false;
              this.$refs.addForm.resetFields();
            }
          })
        }
      })
      
    },
    showEditOrg(row){
      
      this.editVisiable=true
      Object.keys(this.editForm).forEach((key)=>{
          this.editForm[key]=row[key];
      })
    },
    editOrg(){
      this.$refs.editForm.validate((valid)=>{
          if(valid){
             this.submitData({
              data:this.editForm,
              url:'/oversea_tms/organization/updateOrg.action',
              success:(data)=>{
                this.initData();
                this.editVisiable=false;
              }
            }) 
          }
      })
    },
    showDeleteOrg(row){
      this.confirm({
        title:this.$t("systemManage.org.deleteConfirm"),
        url:'/oversea_tms/organization/deleteOrg.action',
        data:{
            orgId:row.orgId
        },
        success:(data)=>{
          this.initData()
        }
      })
    }
  }
}
</script>
<style lang="less" scoped>
  .demo-table-expand .el-form-item {
      width: 30%;
  }
</style>