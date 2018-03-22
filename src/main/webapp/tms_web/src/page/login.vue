<template>
  <div class="loginPage">
      <div class="content">
        <div class="paper">
          <el-form :model="loginForm" ref="loginForm">
            <el-form-item>
              <el-input autofocus @keydown.enter.native="login()" placeholder="username" v-model="loginForm.opUsername">
              </el-input>
            </el-form-item>
            <el-form-item>
              <el-input placeholder="password" @keydown.enter.native="login()" type="password" v-model="loginForm.opPwd">
              </el-input>
            </el-form-item>
            <el-form-item>
                <el-button  @click="login()" class="loginBtn" type="primary" >login</el-button>
            </el-form-item>
          </el-form>
        </div>
      </div>
      <el-dialog width="30%" title="modify password" :visible.sync="editVisiable" :close-on-click-modal='false'>
        <el-form :rules="rules" :model="editForm" label-width="150px" ref="editForm" >
            <el-form-item prop="oldPwd" label="old password" >
            <el-input ref="editInput" type="password" v-model="editForm.oldPwd" auto-complete="off"></el-input>
            </el-form-item>
            <el-form-item prop="newPwd" type="password" label="new password" >
            <el-input type="password" v-model="editForm.newPwd" auto-complete="off"></el-input>
            </el-form-item>
            <el-form-item prop="confirmPassword" type="password" label="confirm password" >
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
import {pwdRules} from '@/mixins/rules'
export default {
  data () {
    return {
      loginForm:{
        opUsername:'',
        opPwd:''
      },
      editVisiable:false,
      editForm:{
        newPwd:'',oldPwd:'',confirmPassword:''
      },
      rules:pwdRules
    };
  },
  methods: {
    login(){//登录
      this.getData({
        data:this.loginForm,
        url:'/oversea_tms/login.action',
        success:(response)=>{
          if(response.code==0 || response.code==3){
            this.$message.error(response.message);
            this.loginForm.userName='';
          }else if(response.code==1){
            var sStorage = window.sessionStorage;
            sStorage.setItem('userName',this.loginForm.opUsername);
            if(this.loginForm.opUsername=='appuser' || this.loginForm.opUsername=='jiangsu'){
              this.$router.push({path:'/oversea_tms/index/app'});
            }else{
              this.$router.push({path:'/oversea_tms/index/operator'});
            }
          }else if(response.code==2){
            this.$message.warning(response.message);
            this.editVisiable = true;
          }
        }
      })
    },
    changePwd(){
        this.$refs.editForm.validate((valid)=>{
            if(valid){
                if(this.editForm.newPwd!=this.editForm.confirmPassword){
                    this.$message.error('two input password inconsistencies');
                    return 
                }
                this.getData({
                    data:this.editForm,
                    url:'/oversea_tms/operator/updatePwd.action',
                    success:(data)=>{
                      if(data.type){
                        this.$message.success(data.message);
                        this.editVisiable=false;
                      }else{
                        this.$message.error(data.message);
                      }
                    }
                })
            }
        })
    }
  }
}
</script>
<style lang="less" scoped>
    .content{
        position: absolute;
        top:40%;
        left: 50%;
        transform: translateX(-50%) translateY(-50%);
        .paper{
            margin-top: 20px;
            padding: 40px 50px 20px;
            width: 400px;
            background: white;
            border-radius: 2px;
            box-shadow: 0 3px 10px rgba(0, 0, 0, 0.156863), 0 3px 10px rgba(0, 0, 0, 0.227451);
        }
        .loginBtn{
            margin-top: 20px;
            width: 100%;
        }
        .forgetBtn{
            float:right;
        }
    }
    .loginPage{
        background-image:url('../assets/login_bg.png') ;
        background-size: 100% 100%;
        height: 100%;
    }
</style>