import Vue from 'vue'
import Vuex from 'vuex'
import mutations from './mutations'
import actions from './actions'
Vue.use(Vuex)
const language = sessionStorage.getItem('language') ? sessionStorage.getItem('language'):'en';
const state={
    popedomList:[],
    handleLoading:false,
    isEn:language=='en'?true:false
}
export default new Vuex.Store({
    state,
    actions,
    mutations
})