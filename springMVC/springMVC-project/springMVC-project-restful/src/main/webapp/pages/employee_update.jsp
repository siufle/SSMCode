
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>更新员工信息</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/employee" method="post">
        <input type="hidden" name="_method" value="put">
        员工姓名 <input type="text" name="lastName" value="${employee.lastName}"><br>
        员工邮箱 <input type="text" name="email" value="${employee.email}"><br>
        员工性别
        <c:if test="${employee.gender == 1}" >
            <input type="radio" name="gender" value="1" checked>男
            <input type="radio" name="gender" value="0">女<br>
        </c:if>
        <c:if test="${employee.gender == 0}" >
            <input type="radio" name="gender" value="1" >男
            <input type="radio" name="gender" value="0" checked>女<br>
        </c:if>
        <input type="submit" value="修改">
    </form>
</body>
</html>
