import Vue from 'vue'
import Router from 'vue-router'
const login = () => import(/* webpackChunkName: "common" */ '../page/login.vue')
const index = () => import(/* webpackChunkName: "common" */ '../page/index.vue')
const log = () => import(/* webpackChunkName: "common" */ '../page/systemManage/log.vue')
const operator = () => import(/* webpackChunkName: "system" */ '../page/systemManage/operator.vue')
const role = () => import(/* webpackChunkName: "system" */ '../page/systemManage/role.vue')
const org = () => import(/* webpackChunkName: "system" */ '../page/systemManage/organization.vue')
const app = () => import(/* webpackChunkName: "appPkg" */ '../page/appManage/appManage.vue')
const firmWare = () => import(/* webpackChunkName: "appPkg" */ '../page/appManage/firmWareManage.vue')
const document = () => import(/* webpackChunkName: "appPkg" */ '../page/appManage/documentManage.vue')
const terminal = () => import(/* webpackChunkName: "terminal" */ '../page/terminalManage/terminalManage.vue')
const devGroup = () => import(/* webpackChunkName: "terminal" */ '../page/terminalManage/devGroupManage.vue')
const model = () => import(/* webpackChunkName: "terminal" */ '../page/terminalManage/modelManage.vue')
const key = () => import(/* webpackChunkName: "terminal" */ '../page/terminalManage/keyManage.vue')
const Manufacturer = () => import(/* webpackChunkName: "terminal" */ '../page/terminalManage/brandManage.vue')
const merchant = () => import(/* webpackChunkName: "merchant" */ '../page/merchantManage/merchantManage.vue')
const paramter = () => import(/* webpackChunkName: "parameter" */ '../page/parameterManage/parameter.vue')
const pospParamter = () => import(/* webpackChunkName: "parameter" */ '../page/parameterManage/pospParameter.vue')
Vue.use(Router)
export default new Router({
  mode:'history',
  fallback:false,
  routes: [
    {
      path: '/oversea_tms',
      redirect:'/oversea_tms/login'
    },{
      path: '/oversea_tms/login',
      name:'login',
      component:login
    },{
      path: '/oversea_tms/index',
      name: 'index',
      component: index,
      children:[
        {
          path: 'operator',
          name: 'User',
          component: operator
        },{
          path: 'role',
          name: 'Role',
          component: role
        },{
          path: 'org',
          name: 'Organization',
          component: org
        },{
          path: 'app',
          name: 'App',
          component: app
        },{
          path: 'firmWare',
          name: 'Firmware',
          component: firmWare
        },{
          path: 'document',
          name: 'Document',
          component: document
        },{
          path: 'Manufacturer',
          name: 'Manufacturer',
          component: Manufacturer
        },{
          path: 'model',
          name: 'Model',
          component: model
        },{
          path: 'key',
          name: 'Key',
          component: key
        },{
          path: 'devGroup',
          name: 'Group',
          component: devGroup
        },{
          path: 'terminal',
          name: 'Info',
          component: terminal
        },{
          path: 'merchant',
          name: 'Merchant',
          component: merchant
        },{
          path: 'log',
          name: 'Operation Log',
          component: log
        },{
          path: 'paramter',
          name: 'Terminal Parameter',
          component: paramter
        },{
          path: 'pospParamter',
          name: 'POSP Parameter',
          component: pospParamter
        }
      ]
    }
  ]
})
