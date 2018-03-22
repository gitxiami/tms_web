<template>
    <el-pagination style="text-align:right"
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :total="parseInt(total)"
        layout="total, sizes, prev, pager, next, jumper"
        :current-page.sync="pageNow"
    ></el-pagination>
</template>
<script>
export default {
  data () {
    return {
      pageNow:1,
      sizeNow:10,
      total:'',
      searchContent:{}
    };
  },
  created () {
   this.initData();
  },
  methods: {
    initData(searchParams){
      this.$emit('loadingStatus',this.$t('loadingText'))
      this.getData({
        data:searchParams,
        url:this.url,
        success:(data)=>{
          if(!data.rows.length){
            this.$emit('loadingStatus',this.$t('emptyText'));
          }
          if(data.code){
            this.$message.error(data.message);
            this.total=0;
            this.$emit('tableContent',[]);
          }else{
            this.total=data.total;
            this.$emit('tableContent',data.rows)
          }
        }
      })
    },
    handleSizeChange(rows){
      this.searchContent.pageSize=rows;
      this.sizeNow=rows;
      this.initData(this.searchContent);
    },
    handleCurrentChange(page){
      this.searchContent.pageNo =page;
      this.initData(this.searchContent);
    }
  },
  watch: {
    searchFlag(){
      this.searchContent=Object.assign({},this.searchParams);
      this.searchContent.pageSize=this.sizeNow;
      if(this.pageNow==1){
        this.initData(this.searchContent)
      }else{
        this.pageNow=1;
      }
    },
    reload(){
      if(this.pageNow==1){
        this.initData(this.searchContent)
      }else{
        this.pageNow=1;
      }
    }
  },
  props: ['url','searchParams','reload','searchFlag']
}
</script>