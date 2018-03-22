<template>
    <div class="menu">
        <el-menu unique-opened	 class="el-menu-vertical-demo" :collapse="isCollapse">
            <div @click="collapseMenu" class="more-menu-btn">
                <span :class="!isCollapse?'el-icon-arrow-left':'el-icon-arrow-right'" class="collapse el-icon-arrow-left"></span>
            </div>
            <el-submenu :index="index.toString()" v-for="(item,index) in menus" :key="index">
                <template slot="title">
                    <i class="iconfont" :class="item.popedomIconcls"></i>
                    <span slot="title">{{isEn ? item.popedomName:item.popedomRemark}}</span>
                </template>
                <router-link :to="{name:items.popedomName}"  v-for="(items,index) in item.children" :key="index">
                    <el-menu-item :index="items.popedomId.toString()">{{isEn ? items.popedomName:items.popedomRemark}}</el-menu-item>
                </router-link>
            </el-submenu>
        </el-menu>
    </div>
</template>
<script>
import { mapState } from 'vuex'
export default {
  data () {
    return {
        isCollapse:false,
        menus:[]
    };
  },
  computed: {
    ...mapState(['isEn'])
  },
  methods: {
      collapseMenu(){
          this.isCollapse=!this.isCollapse;
          if(!this.isCollapse){
                document.getElementById('mainContent').style.left="262px";    
          }else{
              setTimeout(() => {
                document.getElementById('mainContent').style.left="79px";    
              }, 500);
          }
      }
  },
  mounted () {
      this.$store.dispatch('getPopedom',{
        success:(data)=>{
            if(data.code=="3"){
                this.$message.error(data.message);
                this.$router.push({path: '/oversea_tms/'})
                return 
            }
            this.menus = data.menu;
        }
      })
  }
}
</script>
<style lang="less" scoped>
  .el-menu-vertical-demo:not(.el-menu--collapse){
    width: 247px;
    position: absolute;
    top: 0;
    bottom: 0;
    box-shadow: 1px 3px 10px 0px rgba(0, 0, 0, 0.12);
  }
  .el-menu{
      height: 100%;
  }
  .menu{
    position: absolute;
    top: 0;
    bottom: 0;
  }
  .collapse{
      margin-top: 15px;
  }
  .more-menu-btn {
        z-index: 999;
        cursor: pointer;
        border: 1px solid #e9e9e9;
        color: #96a1a7;
        border-radius: 2px;
        height:  48px;
        text-align: center;
        line-height: 14px;
        position: absolute;
        right: 0;
        top: 50%;
        transform: translateY(-50%);
    }
</style>