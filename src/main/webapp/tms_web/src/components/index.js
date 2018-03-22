// import paginationComponent from './pagination.vue'
// import morePanelComponent  from './more-panel.vue'
const myPagination={
    install:function (Vue) {
        Vue.component('myPagination',()=>import(/* webpackChunkName: "common" */ './pagination.vue'))
    }
}
const myPagination2={
    install:function (Vue) {
        Vue.component('myPagination2',()=>import(/* webpackChunkName: "common" */ './pagination2.vue'))
    }
}
const morePanel={
    install:function (Vue) {
        Vue.component('morePanel',()=>import(/* webpackChunkName: "common" */ './more-panel.vue'))
    }
}
export { morePanel, myPagination,myPagination2}