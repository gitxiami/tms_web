<template>
  <div>
    <!-- 条件search -->
    <div class="search">
      <more-panel>
        <el-form  slot="form" :inline="true"  class="demo-form-inline">
          <el-form-item  :label="$t('parameterManage.para.serialLabel')">
            <el-input  @keydown.enter.native="search()" size="small" v-model="searchParams.deviceSn" :placeholder="$t('parameterManage.para.serialPlace')" ></el-input>
          </el-form-item>
          <el-form-item  :label="$t('parameterManage.para.versionLabel')">
            <el-input  @keydown.enter.native="search()" size="small" v-model="searchParams.paraVer" :placeholder="$t('parameterManage.para.versionPlace')" ></el-input>
          </el-form-item>
        </el-form>
        <div slot="control">
          <el-button  size="small" icon="search" type="primary" @click="search()">{{$t('search')}}</el-button>
          <el-button  size="small" icon="circle-close" type="primary"  @click="reset()">{{$t('reset')}}</el-button>
          <template  v-for="(item,index) in popedomList.button">
            <el-button v-if="item.popedomId=='05101'" size="small" type="primary" @click="addVisiable=true" :key="index"><i class="iconfont" v-bind:class="item.popedomIconcls"></i>{{isEn ? item.popedomName:item.popedomRemark}}</el-button>
          </template>
        </div>
      </more-panel>
    </div>
    <el-table :empty-text="emptyText" highlight-current-row @current-change="select" :height="tableHeight"  border stripe :data="tableData"  style="width:100%;">
      <el-table-column align="center" show-overflow-tooltip type="index" width="50"></el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('parameterManage.para.terminalSerial')" prop="deviceSn" min-width="120" ></el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('version')" prop="paraVer"  min-width="80"></el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('parameterManage.para.serverParameter')" prop="serverPara" min-width="160"></el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('parameterManage.para.serverParameter1')" prop="serverParaBak1" min-width="160"></el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('parameterManage.para.serverParameter2')" prop="serverParaBak2" min-width="160"></el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('createTime')" prop="createdDatetime" min-width="160"></el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('operation')" min-width="130">
        <template slot-scope="scope" >
          <el-button :title="isEn ? item.popedomName:item.popedomRemark" class="iconHandle"  v-for="(item,index) in popedomList.button" v-if="(item.popedomId=='05102')" @click="openDpduPara(scope.row)" :key="index" type="warning" size="mini"><i class="iconfont" :class="item.popedomIconcls"></i></el-button>
          <el-button :title="isEn ? item.popedomName:item.popedomRemark" class="iconHandle"  v-for="(item,index) in popedomList.button" v-if="(item.popedomId=='05103')" @click="openMchntPara(scope.row)" :key="index" type="primary" size="mini"><i class="iconfont" :class="item.popedomIconcls"></i></el-button>
        </template></el-table-column>
    </el-table>
    <my-pagination @loadingStatus="loadingStatus" :reload="reload" :searchParams="searchParams" :searchFlag="searchFlag" :url="url" @tableContent="tableContent"></my-pagination>
    <!-- 添加参数 -->
    <el-dialog width="40%" :title="$t('parameterManage.para.addFormTitle')" :visible.sync="addVisiable" :close-on-click-modal="false">
      <el-form :model="addForm" :rules="rules" label-width="180px" ref="addForm" >
        <el-form-item prop="deviceSn" :label="$t('parameterManage.para.serialLabel')" >
          <el-input type="text" v-model="addForm.deviceSn"></el-input>
        </el-form-item>
        <el-form-item prop="paraVer" :label="$t('parameterManage.para.versionLabel')" >
          <el-input type="text" v-model="addForm.paraVer"></el-input>
        </el-form-item>
        <el-form-item prop="serverPara" :label="$t('parameterManage.para.serverParameter')" >
          <el-input type="text" v-model="addForm.serverPara"></el-input>
        </el-form-item>
        <el-form-item prop="serverParaBak1" :label="$t('parameterManage.para.serverParameter1')" >
          <el-input type="text" v-model="addForm.serverParaBak1"></el-input>
        </el-form-item>
        <el-form-item prop="serverParaBak2" :label="$t('parameterManage.para.serverParameter2')" >
          <el-input type="text" v-model="addForm.serverParaBak2"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="addPara()" :loading="handleLoading">{{$t('ok')}}</el-button>
        <el-button @click="addVisiable=false">{{$t('cancel')}}</el-button>
      </div>
    </el-dialog>
    <!-- tpdu参数 -->
    <el-dialog width="70%" :title="$t('parameterManage.para.tpduDetails')" :visible.sync="detailVisiable" :close-on-click-modal="false">
      <div class="">
        <div class="search">
            <div slot="control">
              <template  v-for="(item,index) in popedomList.button">
                <el-button v-if="item.popedomId=='0510201'" size="small" type="primary" @click="addTpduVisiable=true" :key="index"><i class="iconfont" v-bind:class="item.popedomIconcls"></i>{{isEn ? item.popedomName:item.popedomRemark}}</el-button>
              </template>
            </div>
        </div>
        <el-table :empty-text="emptyText" highlight-current-row @current-change="select" :height="detableHeight"  border stripe :data="deTableData"  style="width:100%;">
          <!-- <el-table-column align="center" show-overflow-tooltip type="index" width="50"></el-table-column> -->
          <el-table-column  align="center" show-overflow-tooltip :label="$t('parameterManage.para.code')" prop="code" min-width="150" ></el-table-column>
          <el-table-column  align="center" show-overflow-tooltip :label="$t('parameterManage.para.value')" prop="val" min-width="120"></el-table-column>
        </el-table>
        <my-pagination @loadingStatus="loadingStatus" :reload="dereload" :searchParams="deSearchData"  :url="deUrl" @tableContent="deTableContent"></my-pagination>
      </div>
    </el-dialog>
    <el-dialog width="30%" :title="$t('parameterManage.para.addTpduFormTitle')"  :visible.sync="addTpduVisiable" :close-on-click-modal="false">
      <el-form :model="addTpduForm" :rules="rules" label-width="100px" ref="addTpduForm" >
        <el-form-item prop="code" :label="$t('parameterManage.para.code')" >
          <el-input type="text" v-model="addTpduForm.code"></el-input>
        </el-form-item>
        <el-form-item prop="val" :label="$t('parameterManage.para.value')" >
          <el-input type="text" v-model="addTpduForm.val"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="addTpdu()" :loading="handleLoading">{{$t('ok')}}</el-button>
        <el-button @click="addTpduVisiable=false">{{$t('cancel')}}</el-button>
      </div>
    </el-dialog>
    <!-- mchnt参数 -->
    <el-dialog width="70%"  :title="$t('parameterManage.para.mchntDetails')" :visible.sync="detailVisiable1" :close-on-click-modal="false">
      <div class="">
        <div class="search">
            <div slot="control">
              <template  v-for="(item,index) in popedomList.button">
                <el-button v-if="item.popedomId=='0510301'" size="small" type="primary" @click="addmchntVisiable=true" :key="index"><i class="iconfont" v-bind:class="item.popedomIconcls"></i>{{isEn ? item.popedomName:item.popedomRemark}}</el-button>
              </template>
            </div>
        </div>
        <el-table :empty-text="emptyText" highlight-current-row @current-change="select" :height="detableHeight1"  border stripe :data="deTableData1"  style="width:100%;">
          <el-table-column align="center" show-overflow-tooltip type="index" width="50"></el-table-column>
          <el-table-column  align="center" show-overflow-tooltip :label="$t('parameterManage.para.type')" prop="type" min-width="100" ></el-table-column>
          <el-table-column  align="center" show-overflow-tooltip :label="$t('parameterManage.para.currency')" prop="currency" min-width="100" ></el-table-column>
          <el-table-column  align="center" show-overflow-tooltip label="mid" prop="mid" min-width="120" ></el-table-column>
          <el-table-column  align="center" show-overflow-tooltip label="tid" prop="tid" min-width="120" ></el-table-column>
          <el-table-column  align="center" show-overflow-tooltip label="trans" prop="trans" min-width="80" >
            <template slot-scope="scope">
              <el-tag
                :type="scope.row.trans === '0' ? 'primary' : 'success'"
                close-transition>{{scope.row.trans === '0' ? (isEn?'trans' : 'trans'):(isEn?'cash' : 'cash')}}</el-tag>
            </template>
          </el-table-column>
          <el-table-column  align="center" show-overflow-tooltip :label="$t('parameterManage.para.mchntName')" prop="mchntName" min-width="150" ></el-table-column>           <el-table-column align="center" show-overflow-tooltip :label="$t('operation')" min-width="80">
            <template slot-scope="scope" >
              <el-button :title="isEn ? item.popedomName:item.popedomRemark" class="iconHandle"  v-for="(item,index) in popedomList.button" v-if="(item.popedomId=='0510302')" @click="openEditMchntPara(scope.row)" :key="index" type="warning" size="mini"><i class="iconfont" :class="item.popedomIconcls"></i></el-button>
            </template>
          </el-table-column>
        </el-table>
        <my-pagination @loadingStatus="loadingStatus" :reload="dereload1" :searchParams="deSearchData1"  :url="deUrl1" @tableContent="deTableContent1"></my-pagination>
      </div>
    </el-dialog>
    <el-dialog width="40%" :title="$t('parameterManage.para.addMchntFormTitle')" :visible.sync="addmchntVisiable" :close-on-click-modal="false">
      <el-form :model="addMchntForm" :rules="mchntFormRules" label-width="120px" ref="addMchntForm" >
        <el-form-item prop="type" :label="$t('parameterManage.para.type')" >
          <el-input type="text" v-model="addMchntForm.type"></el-input>
        </el-form-item>
        <el-form-item prop="currency" :label="$t('parameterManage.para.currency')" >
          <el-input type="text" v-model="addMchntForm.currency"></el-input>
        </el-form-item>
        <el-form-item prop="mid" label="mid" >
          <el-input type="text" v-model="addMchntForm.mid"></el-input>
        </el-form-item>
        <el-form-item prop="tid" label="tid" >
          <el-input type="text" v-model="addMchntForm.tid"></el-input>
        </el-form-item>
        <el-form-item prop="trans" label="trans">
          <el-radio-group v-model="addMchntForm.trans">
            <el-radio label="0">trans</el-radio>
            <el-radio label="1">cash</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item prop="mchntName" :label="$t('parameterManage.para.mchntName')" >
          <el-input type="text" v-model="addMchntForm.mchntName"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="addMchntPara()" :loading="handleLoading">{{$t('ok')}}</el-button>
        <el-button @click="addmchntVisiable=false">{{$t('cancel')}}</el-button>
      </div>
    </el-dialog>
    <el-dialog width="40%" :title="$t('parameterManage.para.editMchntFormTitle')" :visible.sync="editmchntVisiable" :close-on-click-modal="false">
      <el-form :model="editMchntForm" :rules="mchntFormRules" label-width="120px" ref="editMchntForm" >
        <el-form-item prop="type" :label="$t('parameterManage.para.type')" >
          <el-input type="text" v-model="editMchntForm.type"></el-input>
        </el-form-item>
        <el-form-item prop="currency" :label="$t('parameterManage.para.currency')" >
          <el-input type="text" v-model="editMchntForm.currency"></el-input>
        </el-form-item>
        <el-form-item prop="mid" label="mid" >
          <el-input type="text" v-model="editMchntForm.mid"></el-input>
        </el-form-item>
        <el-form-item prop="tid" label="tid" >
          <el-input type="text" v-model="editMchntForm.tid"></el-input>
        </el-form-item>
        <el-form-item prop="trans" label="trans">
          <el-radio-group v-model="editMchntForm.trans">
            <el-radio label="0">trans</el-radio>
            <el-radio label="1">cash</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item prop="mchntName" :label="$t('parameterManage.para.mchntName')" >
          <el-input type="text" v-model="editMchntForm.mchntName"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="editMchntPara()" :loading="handleLoading">{{$t('ok')}}</el-button>
        <el-button @click="editmchntVisiable=false">{{$t('cancel')}}</el-button>
      </div>
    </el-dialog>
  </div>
</template>
<script>
import mixin from '@/mixins/mixin'
import {parameterRules} from '@/mixins/rules'
import {mchntFormRules} from '@/mixins/rules'
export default {
  mixins: [mixin],
  data () {
    return {
      dereload:false,
      detableHeight:'300',
      deTableData:[],
      deSearchData:{ pageNo:1, pageSize:10 },
      detailVisiable:false,
      deUrl:'/oversea_tms/deviceAppPara/showTpduByPara.action',
      dereload1:false,
      detableHeight1:'300',
      deTableData1:[],
      deSearchData1:{ pageNo:1, pageSize:10 },
      detailVisiable1:false,
      deUrl1:'/oversea_tms/deviceAppPara/showTpduByPara.action',
      addTpduVisiable:false,
      addmchntVisiable:false,
      editmchntVisiable:false,
      url:'/oversea_tms/deviceAppPara/showPara.action',
      searchParams:{ deviceSn:'',paraVer:'',pageNo:1,pageSize:10 },  
      addForm:{deviceSn:"", paraVer:"", serverPara:"", serverParaBak1:"", serverParaBak2:"" },
      addTpduForm:{ code:"", val:"", paraId:"" },
      addMchntForm:{ paraId:"", type:"", currency:"",  mid:"",  tid:"", trans:"",  mchntName:"" },
      editMchntForm:{ mchntId:"",paraId:"", type:"", currency:"",  mid:"",  tid:"", trans:"",  mchntName:"" },
      rules:parameterRules,
      mchntFormRules:mchntFormRules
    };
  },
  methods: {
    deTableContent(data){//加载应用包详情表格数据
      this.deTableData=data;
    },
    deTableContent1(data){
      this.deTableData1=data;
    },
    addPara(){
      this.$refs.addForm.validate((valid)=>{
        if(valid){
          this.submitData({
            data:this.addForm,
            url:"/oversea_tms/deviceAppPara/addPara.action",
            success:(data)=>{
              this.reload=!this.reload;
              this.addVisiable=false;
              this.$refs.addForm.resetFields();
            }
          })
        }
      })
    },
    openDpduPara(row){
      this.deUrl='/oversea_tms/deviceAppPara/showTpduByPara.action?paraId='+row.paraId;
      this.dereload=!this.dereload;
      this.detailVisiable=true;
    },
    openMchntPara(row){
      this.deUrl1='/oversea_tms/deviceAppPara/showMchntByPara.action?paraId='+row.paraId;
      this.dereload1=!this.dereload1;
      this.detailVisiable1=true;
    },
    addTpdu(){
      this.$refs.addTpduForm.validate((valid)=>{
        if(valid){
          this.addTpduForm.paraId = this.rowData.paraId;
          this.submitData({
            data:this.addTpduForm,
            url:"/oversea_tms/deviceAppPara/addTpdu.action",
            success:(data)=>{
              this.dereload=!this.dereload;
              this.addTpduVisiable=false;
              this.$refs.addTpduForm.resetFields();
            }
          })
        }
      })
    },
    addMchntPara(){
      this.$refs.addMchntForm.validate((valid)=>{
        if(valid){
          this.addMchntForm.paraId = this.rowData.paraId;
          this.submitData({
            data:this.addMchntForm,
            url:"/oversea_tms/deviceAppPara/addMchnt.action",
            success:(data)=>{
              this.dereload1=!this.dereload1;
              this.addmchntVisiable=false;
              this.$refs.addMchntForm.resetFields();
            }
          })
        }
      })
    },
    openEditMchntPara(row){
      this.editmchntVisiable=true;
      Object.keys(this.editMchntForm).forEach((key)=>{
          this.editMchntForm[key]=row[key];
      })
    },
    editMchntPara(){
      this.$refs.editMchntForm.validate((valid)=>{
        if(valid){
          this.submitData({
            data:this.editMchntForm,
            url:"/oversea_tms/deviceAppPara/updateMchnt.action",
            success:(data)=>{
              this.dereload1=!this.dereload1;
              this.editmchntVisiable=false;
            }
          })
        }
      })
    }
  }
}
</script>