import Vue from "vue";
import VueRouter from 'vue-router'
import Content from "../components/Content";
import Main from "../components/Main";
import Clare from '../components/Clare'

//安装路由
Vue.use(VueRouter);

//配置导出路由
//结构：Router对象中有一个routes数组，数组元素是对象
export default new VueRouter({
  routes: [
    {
      //路由的路径（跳转组件的代号）
      path: '/content',
      name: 'content',
      //跳转的组件
      component: Content
    },
    {
      path: '/main',
      component: Main
    },
    {
      //路由的路径（跳转组件的代号）
      path: '/clare',
      //跳转的组件
      component: Clare
    }
  ]
});
