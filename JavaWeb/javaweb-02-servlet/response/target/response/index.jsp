<%@page isELIgnored="false" %>
<%@page contentType="text/html;charset=UTF-8" %>
<html>
<body>
<h2>Hello World!</h2>

<%--EL表达式--%>
<%--这里提交的是路径，"/"相对于web目录下，因此还需要找到项目的路径--%>
<%--${pageContext.request.contextPath}代表当前的项目--%>
<form action="${pageContext.request.contextPath}/login" method="get">
    用户名：<input type="text" name=""username><br>
    密码：<input type="password" name="password"><br>
    <input type="submit">
</form>

</body>
</html>
