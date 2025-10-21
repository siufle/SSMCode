
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>新增员工</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/employee" method="post">
        员工姓名 <input type="text" name="lastName"><br>
        员工邮箱 <input type="text" name="email"><br>
        员工性别 <input type="radio" name="gender" value="1">男
        <input type="radio" name="gender" value="0">女<br>
        <input type="submit" value="提交"><br>
    </form>
</body>
</html>
