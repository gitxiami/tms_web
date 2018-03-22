import {mapState,mapActions,mapMutations} from 'vuex'
var mixin = {
    data () {
        return {
            emptyText:"loading...",
            tableData:[],
            reload:false,
            tableHeight:'',
            searchFlag:false,
            rules:{},
            rowData:'',
            addVisiable:false,
            editVisiable:false
        }
    },
    computed: {
        ...mapState(['popedomList','handleLoading','isEn'])  
    },
    mounted () {
        this.tableHeight=document.documentElement.clientHeight-220;
        window.onresize =()=> {
            this.tableHeight=document.documentElement.clientHeight-220;
        };
    },
    methods: {
        ...mapActions(['submitData','confirm','fileSubmit','fileSubmit2']),
        tableContent(data){//表格数据加载
          this.tableData=data;
        },
        select(val){//表格数据行选择
          this.rowData=val;
        },
        search(){
            this.searchFlag=!this.searchFlag;
        },
        reset(){
            Object.keys(this.searchParams).forEach((key)=>{
                if(key!="pageNo"){
                    this.searchParams[key]='';
                }
            })
        },
        reset2(){
            Object.keys(this.searchParams).forEach((key)=>{
                if(key!="pageNo" && key!='searchArray'){
                    this.searchParams[key]='';
                }else if(key=='searchArray'){
                    this.searchParams[key]=[];
                }
            })
        },
        loadingStatus(status){
            this.emptyText = status;
        }
    }
}

export default mixin