// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
//import VueRouter from 'vue-router'
//可以省略/index，因为index会默认加载
import VueRouter from './router'

Vue.config.productionTip = false

//实际不在这个入口中配置，而是在./router/index.js 作为路由的配置文件

/*//显式声明使用vue-router
Vue.use(VueRouter)*/

/* eslint-disable no-new */
new Vue({
  el: '#app',
  //配置路由
  router: VueRouter,
  components: { App },
  template: '<App/>'
})
