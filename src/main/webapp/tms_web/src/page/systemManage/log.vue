<template>
  <div>
    <!-- 条件search -->
    <div class="search">
      <more-panel>
        <el-form  slot="form" :inline="true"  class="demo-form-inline">
        <el-form-item  :label="$t('systemManage.log.username')">
            <el-input  @keydown.enter.native="search()" size="small" v-model="searchParams.opUsername" :placeholder="$t('systemManage.log.namePlace')" ></el-input>
        </el-form-item>
        <el-form-item :label="$t('systemManage.log.status')">
            <el-select size="small" v-model="searchParams.logStatus">
                <el-option  :label="isEn?'success':'成功'" :value="1" ></el-option>
                <el-option  :label="isEn?'fail':'失败'" :value="0" ></el-option>
            </el-select>
        </el-form-item>
        </el-form>
        <div slot="control">
          <el-button  size="small" icon="search" type="primary" @click="search()">{{$t('search')}}</el-button>
          <el-button  size="small" icon="circle-close" type="primary"  @click="reset()">{{$t('reset')}}</el-button>
        </div>
      </more-panel>
    </div>
    <el-table :empty-text="emptyText" highlight-current-row @current-change="select" :height="tableHeight"  border stripe :data="tableData"  style="width:100%;">
      <el-table-column align="center" show-overflow-tooltip type="index" width="50"></el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('systemManage.log.username')" prop="opUsername" min-width="120" ></el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('systemManage.log.operate')" prop="logName" min-width="120"></el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('systemManage.log.time')" prop="createdDatetime"  min-width="140"></el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('systemManage.log.org')" prop="orgName" min-width="170"></el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('systemManage.log.ip')" prop="opIp"  min-width="120"></el-table-column>
      <el-table-column align="center" show-overflow-tooltip :label="$t('systemManage.log.status')" prop="logStatusName"  min-width="100">
        <template slot-scope="scopes">
            <el-tag size="small" v-if="scopes.row.logStatus=='1'"  type="success" close-transition>{{isEn?'success':'成功'}}</el-tag>
            <el-tag size="small" v-if="scopes.row.logStatus=='0'"  type="danger" close-transition>{{isEn?'fail':'失败'}}</el-tag>
        </template>
      </el-table-column>
    </el-table>
    <my-pagination @loadingStatus="loadingStatus" :reload="reload" :searchParams="searchParams" :searchFlag="searchFlag" :url="url" @tableContent="tableContent"></my-pagination>
  </div>
</template>
<script>
import mixin from '@/mixins/mixin'
export default {
  mixins: [mixin],
  data () {
    return {
      url:'/oversea_tms/log/showLogByPage.action',
      searchParams:{
          opUsername:'',
          logStatus:'',
          pageNo:1,
          pageSize:10
      },  
    };
  }
}
</script>