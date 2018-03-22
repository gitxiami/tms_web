<template>
  <div>
    <!-- 条件search -->
    <div class="search">
      <more-panel>
        <el-form  slot="form" :inline="true"  class="demo-form-inline">
          <el-form-item  :label="$t('appManage.firmWare.nameLabel')">
            <el-input  @keydown.enter.native="search()" size="small" v-model="searchParams.firmName" :placeholder="$t('appManage.firmWare.namePlace')" ></el-input>
          </el-form-item>
          <el-form-item  :label="$t('version')">
            <el-input  @keydown.enter.native="search()" size="small" v-model="searchParams.firmVer" :placeholder="$t('appManage.firmWare.nameVersion')" ></el-input>
          </el-form-item>
        </el-form>
        <div slot="control">
          <el-button  size="small" icon="search" type="primary" @click="search()">{{$t('search')}}</el-button>
          <el-button  size="small" icon="circle-close" type="primary"  @click="reset()">{{$t('reset')}}</el-button>
          <template  v-for="(item,index) in popedomList.button">
            <el-button v-if="item.popedomId=='03201'" size="small" type="primary" @click="showAddFirm()" :key="index"><i class="iconfont" style="margin-right:5px" v-bind:class="item.popedomIconcls"></i>{{isEn ? item.popedomName:item.popedomRemark}}</el-button>
          </template>
        </div>
      </more-panel>
    </div>
    <el-table  :empty-text="emptyText" highlight-current-row @current-change="select" :height="tableHeight"  border stripe :data="tableData"  style="width:100%;">
      <el-table-column align="center" show-overflow-tooltip type="index" width="50"></el-table-column>
      <el-table-column type="expand">
              <template slot-scope="props">
                <el-form label-position="left" inline class="demo-table-expand" >
                  <el-form-item :label="$t('appManage.firmWare.id')" style="width:33%">
                    <span class="itemValue">{{ props.row.firmId}}</span>
                  </el-form-item>
                  <el-form-item :label="$t('createTime')" style="width:33%">
                    <span class="itemValue">{{ props.row.createdDatetime}}</span>
                  </el-form-item>
                  <el-form-item :label="$t('updateTime')" style="width:33%">
                    <span class="itemValue">{{ props.row.updateDatetime}}</span>
                  </el-form-item>
                  <el-form-item :label="$t('appManage.firmWare.FolderPath')" style="width:100%">
                    <span class="itemValue">{{ props.row.firmFolderPath}}</span>
                  </el-form-item>
                  <el-form-item :label="$t('appManage.firmWare.FilePath')" style="width:100%">
                    <span class="itemValue">{{ props.row.firmFilePath}}</span>
                  </el-form-item>
                  <el-form-item :label="$t('remark')" style="width:100%">
                    <span class="itemValue">{{ props.row.firmDesc}}</span>
                  </el-form-item>
                </el-form>
              </template>
            </el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('appManage.firmWare.nameLabel')" prop="firmName" min-width="150" ></el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('version')" prop="firmVer" min-width="80" ></el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('downloadFlag')" prop="firmDownloadFlag" min-width="140" >
        <template slot-scope="scope">
          <el-tag
            :type="scope.row.firmDownloadFlag === '0' ? 'primary' : 'success'"
            close-transition>{{scope.row.firmDownloadFlag === '0' ? (isEn?'force download' : '强制下载'):(isEn?'force download' : 'unforced download')}}</el-tag>
        </template>
      </el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('appManage.firmWare.status')" prop="firmStatusName" min-width="120" >
        <template slot-scope="scopes">
            <el-tag size="small" v-if="scopes.row.firmStatus=='0'" type="info" close-transition>{{isEn?'ready':'未上线'}}</el-tag>
            <el-tag size="small" v-if="scopes.row.firmStatus=='1'" type="success" close-transition>{{isEn?'online':'已上线'}}</el-tag>
            <el-tag size="small" v-if="scopes.row.firmStatus=='2'" type="danger" close-transition>{{isEn?'offline':'已下线'}}</el-tag>
        </template>
      </el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('appManage.firmWare.download')" min-width="80">
        <template slot-scope="scope" >
          <el-button :title="isEn ? item.popedomName:item.popedomRemark" class="iconHandle"  v-for="(item,index) in popedomList.button" v-if="(item.popedomId=='03202')" @click="downloadFirmWare(scope.row)" :key="index" type="success" size="mini"><i class="iconfont" :class="item.popedomIconcls"></i>{{isEn ? item.popedomName:item.popedomRemark}}</el-button>
        </template></el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('operation')" min-width="100">
        <template slot-scope="scope" >
          <el-button :title="isEn ? item.popedomName:item.popedomRemark" class="iconHandle"  v-for="(item,index) in popedomList.button" v-if="(item.popedomId=='03203')" @click="onlineFirmWare(scope.row)" :key="index" type="warning" size="mini"><i class="iconfont" :class="item.popedomIconcls"></i></el-button>
          <el-button :title="isEn ? item.popedomName:item.popedomRemark" class="iconHandle"  v-for="(item,index) in popedomList.button" v-if="(item.popedomId=='03204')" @click="offlineFirmWare(scope.row)" :key="index" type="danger" size="mini"><i class="iconfont" :class="item.popedomIconcls"></i></el-button>
          <el-button :title="isEn ? item.popedomName:item.popedomRemark" class="iconHandle"  v-for="(item,index) in popedomList.button" v-if="(item.popedomId=='03205')" @click="openDelete(scope.row)" :key="index" type="info" size="mini"><i class="iconfont" :class="item.popedomIconcls"></i></el-button>
        </template></el-table-column>
    </el-table>
    <my-pagination @loadingStatus="loadingStatus" :reload="reload" :searchParams="searchParams" :searchFlag="searchFlag" :url="url" @tableContent="tableContent"></my-pagination>
    <!--添加固件-->
    <el-dialog  :label="$t('appManage.firmWare.addFormTitle')" :visible.sync="addVisiable" :close-on-click-modal="false">
      <el-form :model="addForm" :rules="rules" label-width="150px" ref="addForm" >
        <el-form-item :label="$t('appManage.firmWare.selectFirmWare')"  prop="fileName">
          <input  ref="file" type="file" style='display:none' @change="fileChange()"/>
          <el-input v-model="addForm.fileName" style='display:none' auto-complete="off"></el-input>
          <el-button type="primary" size="mini" @click="selectFile()">{{$t('selectFile')}}</el-button>
          <el-tag v-if="addForm.fileName"  type="primary">{{addForm.fileName}}</el-tag>
        </el-form-item>
        <el-form-item prop="firmDownloadFlag" :label="$t('downloadFlag')">
          <el-radio-group v-model="addForm.firmDownloadFlag">
            <el-radio label="0">{{$t('forceDownload')}}</el-radio>
            <el-radio label="1">{{$t('unforcedDownload')}}</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item prop="firmName" :label="$t('appManage.firmWare.nameLabel')" >
          <el-input v-model="addForm.firmName"></el-input>
        </el-form-item>
        <el-form-item prop="firmVer" :label="$t('version')" >
          <el-input v-model="addForm.firmVer"></el-input>
        </el-form-item>
        <el-form-item prop="firmDesc" :label="$t('remark')" >
          <el-input type="textarea" v-model="addForm.firmDesc"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="addFirm()" :loading="handleLoading">{{$t('ok')}}</el-button>
        <el-button @click="addVisiable=false">{{$t('cancel')}}</el-button>
      </div>
    </el-dialog>
  </div>
</template>
<script>
import mixin from '@/mixins/mixin'
import {firmWareRules} from '@/mixins/rules'
export default {
  mixins: [mixin],
  data () {
    return {
      url:'/oversea_tms/firmWare/showFirmWareByPage.action',
      searchParams:{
        firmVer:'',
        firmName:'',
        pageNo:1,
        pageSize:10
      },  
      addForm:{
        firmName:'',uploadFile:'',firmDownloadFlag:'0',firmDesc:'',firmVer:'',fileName:''
      },
      rules:firmWareRules
    };
  },
  methods: {
    selectFile(){//选择文件
      this.$refs.file.click()
    },
    fileChange(){//文件改变
      this.addForm.fileName=this.$refs.file.files[0].name;
      this.addForm.uploadFile=this.$refs.file.files[0];
    },
    showAddFirm(){
      this.addVisiable=true;
      
    },
    addFirm(){
      this.$refs.addForm.validate((valid)=>{
        if(valid){
          
          this.fileSubmit({
            data:this.addForm,
            url:'/oversea_tms/firmWare/uploadFirmWare.action',
            success:(data)=>{
              this.reload=!this.reload;
              
              this.addVisiable=false;
              this.$refs.addForm.resetFields();
            }
          })
        }
      })
      
    },
    onlineFirmWare(row){
      this.confirm({
        title:this.$t('appManage.firmWare.onlineConfirm'),
        data:{
          "firmId":row.firmId
        },
        url:'/oversea_tms/firmWare/onlineFirmWare.action',
        success: (data) => {
          this.reload=!this.reload;
        }
      })
    },
    offlineFirmWare(row){
      this.confirm({
        title:this.$t('appManage.firmWare.outlineConfirm'),
        data:{
          "firmId":row.firmId
        },
        url:'/oversea_tms/firmWare/offlineFirmWare.action',
        success: (data) => {
          this.reload=!this.reload;
        }
      })
    },
    downloadFirmWare(row){
      window.open("/oversea_tms/firmWare/downloadFirmWare.action?firmId="+row.firmId+"&firmVer="+row.firmVer);
    },
    openDelete(row){
      this.confirm({
        title:this.$t("appManage.firmWare.deleteConfirm"),
        data:{
          "firmId":row.firmId
        },
        url:'/oversea_tms/firmWare/deleteFirmWare.action',
        success:(data)=>{
            this.reload=!this.reload;
        }
      })
    }
  },
  
}
</script>