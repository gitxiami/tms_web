<template>
  <div class="indexPage">
    <div class="headerContainer">
      <div class="header">
        <div class="logo left">
          <!-- <img src="../assets/logo.png" /> -->
          <span>Sunyard TMS</span>
        </div>
        <div class="handleBox right">
          <ul class="handle clear">
            <li class="_handle left _handle_line" v-if="userName!='jiangsu'">
              <div class="subhandle">
                <a @click="changeLanguage()" class="_subhandle">{{$t('language')}}</a>
              </div>
            </li>
            <li class="_handle left _handle_line">
              <div class="subhandle">
                <a @click="openChangePwd()" class="_subhandle">{{$t('changePwd')}}</a>
              </div>
            </li>
            <li class="_handle left">
              <div class="subhandle">
                <a @click="logout()" class="_subhandle">{{$t('logout')}}</a>
              </div>
            </li>
          </ul>
        </div>
      </div>
    </div>
    <div class="main">
      <div class="container clear">
        <!-- <div class="nav-menu"> -->
        <nav-menu></nav-menu>
        <!-- </div> -->
        <!-- 表格数据显示 -->
        <div id="mainContent" class="content">
            <router-view></router-view>
        </div>
      </div>
    </div>
    <el-dialog width="30%" :title="$t('changePwd')" :visible.sync="editVisiable" :close-on-click-modal='false'>
      <el-form :rules="rules" :model="editForm" label-width="150px" ref="editForm" >
        <el-form-item prop="oldPwd" :label="$t('oldPwd')" >
          <el-input ref="editInput" type="password" v-model="editForm.oldPwd" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item prop="newPwd" type="password" :label="$t('newPwd')" >
          <el-input type="password" v-model="editForm.newPwd" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item prop="confirmPassword" type="password" :label="$t('confirmPwd')" >
          <el-input type="password" v-model="editForm.confirmPassword" auto-complete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="changePwd()">{{$t('ok')}}</el-button>
        <el-button @click="editVisiable=false">{{$t('cancel')}}</el-button>
      </div>
    </el-dialog>
  </div>
</template>
<script>
import navMenu from '@/components/menu'
import {pwdRules} from '@/mixins/rules'
import {mapActions,mapMutations} from 'vuex'
export default {
  data () {
    return {
      userName:'',
      menus:{},
      editVisiable:false,
      editForm:{
        newPwd:'',oldPwd:'',confirmPassword:''
      },
      rules:pwdRules
    };
  },
  mounted(){
    var sStorage = window.sessionStorage;
    this.userName=sStorage.getItem('userName');
    if(this.userName=='jiangsu'){//针对jiangsu用户只显示中文
      this.setLanguage("zh");
      this.CN();
      sessionStorage.setItem('language','zh');
    }
  },
  methods: {
    ...mapActions(['submitData']),
    ...mapMutations(['EN','CN']),
    logout(){
      this.$confirm(this.$t('exitConfirm'), this.$t('prompt'), {
        cancelButtonText: this.$t('cancel'),
        confirmButtonText: this.$t('ok'),
        type: 'warning'
      }).then(() => {
        this.getData({
          url:'/oversea_tms/logout.action',
          success:(data)=>{
            if(data.type){
              this.$router.push({path:'/oversea_tms/'});
            }
          }
        })
      }).catch(() => {});
    },
    openChangePwd(){
      this.editVisiable = true;
    },
    changePwd(){
      this.$refs.editForm.validate((valid)=>{
        if(valid){
          if(this.editForm.newPwd!=this.editForm.confirmPassword){
            this.$message.error(this.$t("pwdValidMsg"));
            return 
          }
          this.submitData({
            data:this.editForm,
            url:'/oversea_tms/operator/updatePwd.action',
            success:(data)=>{
              this.editVisiable=false;
              this.$router.push({path:'/oversea_tms/'});
            }
          })
        }
      })
    },
    changeLanguage(){
      if(this.getLanguage()=="en"){
        this.setLanguage("zh");
        this.CN();
        sessionStorage.setItem('language','zh');
      }else{
        this.setLanguage("en");
        this.EN();
        sessionStorage.setItem('language','en');
      }
      location.reload();
    }
  },
  components: {
    navMenu
  }
}
</script>
<style lang="less" scoped>
  .indexPage{
    height: 100%;
  }
  .headerContainer{
    background: #2D4E8B;
    position: absolute;
    z-index: 555;
    width: 100%;
    .header{
      height: 40px;
      padding-left:20px;
    }
    .logo{
      line-height: 40px;
      color: white;
      font-size: 15px;
      display: inline-block;
      padding-left: 30px;
      font-weight: 500;
      line-height: 40px;
      color: #FEFEFE;
      vertical-align: middle;
      span{
        color: rgba(255,255,255,0.5);
      }
    }
    .handleBox{
      line-height: 40px;
    }
    .handle{
      font-size: 14px;
      .subhandle{
        padding: 0 15px;
      }
      ._subhandle{
        cursor: pointer;
        color: rgba(255,255,255,0.5);
        &:hover{
          color:#108EE9;
        }
      }
    }
  }
  .main{
    height: 100%;
    position: absolute;
    padding-top: 40px;
    top: 0;
    width: 100%;

    .content{
      height: 100%;
      box-sizing:content-box;
      position: absolute;
      left:262px;
      right: 15px;
      top: 15px;
      // transition: all 0.3s;
    }
    .container{
      height: 100%;
      width:100%;
      overflow:hidden;
      position:relative;
    }
  }
</style>