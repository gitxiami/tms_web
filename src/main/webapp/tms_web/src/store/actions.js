import axios from 'axios'
import router from '../router'
import qs from 'qs'
import Vue from 'vue'
export default {
    getPopedom({commit},option){
        axios({
            method:'post',
            data:'',
            url:'/oversea_tms/popedom/findPopedoms.action'
        }).then((response)=>{
            commit('GET_POPEDOM',response.data)
            option.success(response.data)
        }).catch((error)=>{
            router.push({path: '/oversea_tms/'})
        })
    },
    submitData({commit},option){
        commit('LoadingTrue');
        var datas;
        if(option.data){
            datas=qs.stringify(option.data);
        }
        axios({
            method:'post',
            data:datas,
            url:option.url
        }).then((Response)=>{
            if(Response.data.type){
                Vue.prototype.$message.success(Response.data.message);
                option.success(Response.data);
            }else{
                Vue.prototype.$message.error(Response.data.message);
            }
            commit('LoadingFalse');
        }).catch((error)=>{
            commit('LoadingFalse');
            router.push({path: '/oversea_tms/'})
        })
    },
    confirm({dispatch,commit},option){
        Vue.prototype.$msgbox.confirm(option.title, vue.$t("prompt"), {
            confirmButtonText: vue.$t("ok"),
            cancelButtonText: vue.$t("cancel"),
            type: 'warning'
        }).then(() => {
            dispatch('submitData',{
                data:option.data,
                url:option.url,
                success:(data)=>{
                    Vue.prototype.$message.success(data.message);
                    option.success(data);
                }
            })
        }).catch(()=>{})
    },
    fileSubmit({commit},option){
        commit('LoadingTrue');
        var formdata = new FormData();
        for (var attr in option.data) {
            formdata.append(attr, option.data[attr])
        }
        axios({
            method:'post',
            data: formdata,
            url:option.url,
            headers: {
                'Content-Type': 'multipart/form-data'
            }
        }).then((Response)=>{
            if(Response.data.type){
                Vue.prototype.$message.success(Response.data.message);
                option.success(Response)
            }else{
                Vue.prototype.$message.error(Response.data.message);
            }
            commit('LoadingFalse');
        }).catch((error)=>{
            commit('LoadingFalse');
            router.push({path: '/oversea_tms/'})
        })
    },
    fileSubmit2({commit},option){
        commit('LoadingTrue');
        var formdata = new FormData();
        for (var attr in option.data) {
            formdata.append(attr, option.data[attr])
        }
        axios({
            method:'post',
            data: formdata,
            url:option.url,
            headers: {
                'Content-Type': 'multipart/form-data'
            }
        }).then((Response)=>{
            option.success(Response.data)
            commit('LoadingFalse');
        }).catch((error)=>{
            commit('LoadingFalse');
            router.push({path: '/oversea_tms/'})
        })
    }
}