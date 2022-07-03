import Vue from 'vue'
import VueRouter from 'vue-router'
import Main from '../views/Main'
import Login from '../views/Login'
import UserProfile from '../views/user/Profile'
import UserList from '../views/user/List'
import NotFound from '../views/NotFound'

Vue.use(VueRouter);

export default new VueRouter({
  mode: 'history',
  routes:[
    {
      path: '/main',
      component: Main,
      props: true,
      children:[
        {
          path: '/user/profile',
          name: 'UserProfile',
          component: UserProfile,
          props: true
        }, {
          path: '/user/list',
          name: 'UserList',
          component: UserList
        }
      ]
    },
    {
      path: '/login',
      component: Login
    }, {
      path: '/goHome',
      redirect: '/main'
    }, {
      path: '*',
      component: NotFound
    }
  ]
});
