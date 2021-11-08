<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户登录页面</title>
</head>
<body>
    ${msg}
    <form action="/user/userlogin" method="post" >
        用户名:<input type="text" name="username"/><br/>
        密码:<input type="password" name="userpwd"/><br/>
        <input type="submit" value="登录">
    </form>
</body>
</html>
