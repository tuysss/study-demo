<!-- ERROR: TEMPLATE里只能存在一个根节点，i.e，内部只能有一个根标签-->
<template>
  <div>
    <h1>用户信息页</h1>
    <!-- 前端Main.vue在点击跳转链接时，将id连同url一起传给router。跳转到新页面后，从router中取 -->
<!--    <p>{{$router.params.id}}</p>-->
    {{id}}

  </div>
</template>

<script>
export default {
  name: "UserProfile",
  props: ['id'],
  //类拦截器
  beforeRouteEnter: (to,from,next)=>{
    console.log("进入路由之前");  //期望：进入之前，钩子函数加载数据
    next(vm => {
      vm.getData();  //进入路由之前执行方法
    })
  },
  beforeRouteLeave: (to,from,next)=>{
    console.log("离开路由之前");
    //next(false);  //不允许离开

    //next('/');  //改变路由的跳转方向，强转
    methods: {
      function getData(){
        this.axios({
          method: 'get',
          url: 'http://localhost:8082/static/mock/data.json'
        }).then(function (response){
          console.log(response);
        })
      }
    }
  }
}
</script>

<style scoped>

</style>
