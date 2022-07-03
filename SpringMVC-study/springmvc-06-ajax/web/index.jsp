<%--
  Created by IntelliJ IDEA.
  User: TianYanning
  Date: 2022/5/12
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script src="${pageContext.request.contextPath}/statics/js/jquery-3.4.1.js"></script>
    <script>
      function a(){
        $.post({
          url:"${pageContext.request.contextPath}/a1",
          /* data键值对：key是前端的，value是后端的*/
          data:{"name":$("#username").val()},
          success:function (data){
            alert(data)
          },
          error:function (){

          }
        })
      }
/*success是回调函数
回调函数可以看成，让别人做事，传进去的额外信息。*/
    </script>

  </head>
  <body>

  <%--失去焦点的时候，发起一个请求（携带信息）到后台--%>
  用户名：<input type="text" id="username" onblur="a()">

  </body>
</html>
