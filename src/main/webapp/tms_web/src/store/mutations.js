export default {
    GET_POPEDOM (state,list){
        state.popedomList=list
    },
    LoadingTrue (state){
        state.handleLoading=true
    },
    LoadingFalse (state){
        state.handleLoading=false
    },
    EN (state){
        state.isEn = true
    },
    CN (state){
        state.isEn = false
    }
}