<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>

<h1>登录</h1>

<div style="text-align: center">
    <%--该表单含义：以post方式提交表单，提交到login请求--%>
    <form action="${pageContext.request.contextPath}/login" method="post">
        用户名：<input type="text" name="username"><br>
        密码：<input type="password" name="password"><br>
        爱好：
        <input type=checkbox name="hobbies" value="sing">唱歌
        <input type=checkbox name="hobbies" value="chess">下棋
        <input type=checkbox name="hobbies" value="sports">运动
        <input type=checkbox name="hobbies" value="draw">画画
        <br>
        <input type="submit">
    </form>
</div>

</body>
</html>
