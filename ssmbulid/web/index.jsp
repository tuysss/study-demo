
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>
    <style type="text/css">
      a{
        text-decoration: none;
        color: black;
        font-size: 18px;
      }
      h3{
        width: 180px;
        height:38px;
        margin: 100px auto;
        text-align: center;
        line-height: 38px;
        background: beige;
        border-radius: 5px;

      }
    </style>
  </head>
  <body>

  <h3>
    <%--超链接取绝对地址，为了项目发布后也能正常运行--%>
    <a href="${pageContext.request.contextPath}/book/allBook">进入书籍页面</a>
  </h3>

  </body>
</html>
