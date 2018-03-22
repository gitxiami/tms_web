// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import qs from 'qs'
import axios from 'axios'
import VueI18n from 'vue-i18n'
import store from './store'
import { Button, Select, Option, Checkbox, Input, Table, TableColumn, Form, FormItem, Menu, MenuItem, Submenu, Pagination,
Message, MessageBox, Notification, Tag, Col, Row, Tree, Popover, Dialog, Radio, RadioGroup, CheckboxGroup,
Cascader, Alert, DatePicker, Transfer } from 'element-ui'
import { morePanel, myPagination, myPagination2 } from './components/index.js'
import 'element-ui/lib/theme-chalk/index.css'
import './style/common.less'
// 引入样式
import 'vue-easytable/libs/themes-base/index.css'
// 导入 table 和 分页组件
import {VTable} from 'vue-easytable'
Vue.config.productionTip = false
import messages from './mixins/lang'
import locale from 'element-ui/lib/locale'
Vue.use(VueI18n)
var language = sessionStorage.getItem('language') ? sessionStorage.getItem('language'):'en';

const i18n = new VueI18n({
  locale: language, // set locale
  messages, // set locale messages
})
locale.i18n((key, value) => i18n.t(key, value))
Vue.prototype.setLanguage = (lang) => {
  i18n.locale = lang;
}
Vue.prototype.getLanguage = () => {
  return i18n.locale;
}



// 注册到全局
Vue.component(VTable.name, VTable)
//按需引入 需要  babel-plugin-component  babel-preset-es2015
Vue.use(Select);Vue.use(Option);Vue.use(Checkbox);Vue.use(Input);Vue.use(Table);Vue.use(TableColumn);Vue.use(Form);Vue.use(FormItem);
Vue.use(Menu);Vue.use(MenuItem);Vue.use(Button);Vue.use(Submenu);Vue.use(Pagination);Vue.use(myPagination);Vue.use(myPagination2);Vue.use(morePanel);
Vue.use(Tag);Vue.use(Col);Vue.use(Row);Vue.use(Tree);Vue.use(Popover);Vue.use(Dialog);Vue.use(Radio);Vue.use(RadioGroup);
Vue.use(CheckboxGroup);Vue.use(Cascader);Vue.use(Alert);Vue.use(DatePicker);Vue.use(Transfer)
window.vue = new Vue({
    el: '#app',
    router,
    i18n,
    store,
    template: '<App/>',
    components: { App }
})
Vue.prototype.$msgbox = MessageBox;
Vue.prototype.$message = Message;
Vue.prototype.$confirm = MessageBox.confirm;

Vue.prototype.getData=(option) => {
  var datas;
  if(option.data){
    datas=qs.stringify(option.data);
  }
  axios({
      "method":'post',
      "data":datas,
      "url":option.url,
  }).then((Response)=>{
      option.success(Response.data);
  }).catch((error)=>{
      Message.error(error);
      router.push({path: '/oversea_tms/'})
  })
}


