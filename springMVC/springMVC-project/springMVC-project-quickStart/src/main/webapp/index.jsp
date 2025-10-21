
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="${pageContext.request.contextPath}/demo1/hello">[搭建springmvc的入门案例]</a><br>

    <a href="${pageContext.request.contextPath}/demo1/getBasicParam?name=lisi&age=24">[获取基本数据类型参数]</a><br>

    <form action="${pageContext.request.contextPath}/demo1/getPojoParams" method="post">
        账户编号: <input type="text" name="id"><br>
        账户名称: <input type="text" name="name"><br>
        账户金额: <input type="text" name="money"><br>
        <input type="submit" name="提交"><br>
    </form>

    <form action="${pageContext.request.contextPath}/demo1/findUser" method="post">
        用户名 <input type="text" name="name"><br>
        密码 <input type="text" name="password"><br>
        年龄 <input type="text" name="age"><br>

        账户1名称 <input type="text" name="accountList[0].name"><br>
        账户1金额 <input type="text" name="accountList[0].money"><br>

        账户2名称 <input type="text" name="accountList[1].name"><br>
        账户2金额 <input type="text" name="accountList[1].money"><br>

        账户3名称 <input type="text" name="accountList[2].name"><br>
        账户3金额 <input type="text" name="accountList[2].money"><br>

        账户4名称 <input type="text" name="accountMap['one'].name"><br>
        账户4金额 <input type="text" name="accountMap['one'].money"><br>

        账户5名称 <input type="text" name="accountMap['two'].name"><br>
        账户5金额 <input type="text" name="accountMap['two'].money"><br>

        <input type="submit" name="提交"><br>
    </form>

    <a href="${pageContext.request.contextPath}/demo1/getDate?date=2025-10-18">获取日期</a><br>

    <a href="${pageContext.request.contextPath}/demo1/getDate2?date=2025-10-18">获取日期2</a><br>

    <a href="${pageContext.request.contextPath}/demo1/testServletAPI?name=kobe&age=38">测试原生servletAPI</a><br>

    <a href="${pageContext.request.contextPath}/demo1/testRequestParam?username=kobe&age=38">requestParam注解测试</a><br>

    <form action="${pageContext.request.contextPath}/demo1/testRequestBody" method="post">
        用户名称 <input type="text" name="username"><br>
        用户密码 <input type="text" name="password"><br>
        用户年龄 <input type="text" name="age"><br>
        <input type="submit" value="保存"><br>
    </form>

    <a href="${pageContext.request.contextPath}/demo1/testRequestHeader">测试RequestHeader注解</a><br>

    <a href="${pageContext.request.contextPath}/demo1/testCookieValue">测试CookieValue注解</a><br>

    <a href="${pageContext.request.contextPath}/demo1/putSession">在session域中存入数据</a>
    <a href="${pageContext.request.contextPath}/demo1/getSession">在session域中获取数据</a>
    <a href="${pageContext.request.contextPath}/demo1/clearSession">清空session域中的数据</a>

    <form action="${pageContext.request.contextPath}/demo1/showStudent" method="post">
        姓名: <input type="text" name="username"><br>
        年龄: <input type="text" name="age"><br>
        <input type="submit" value="提交"><br>
    </form>

    <a href="${pageContext.request.contextPath}/demo1/testPathVariable/1001/kobe">测试PathVariable注解</a><br>

    <a href="${pageContext.request.contextPath}/demo1/testMatrixVariable/1;username=kobe;ages=11,12,13">测试矩阵变量</a><br>

    <a href="${pageContext.request.contextPath}/demo1/testVoid">测试Void返回值</a><br>

    <a href="${pageContext.request.contextPath}/demo1/testModelAndView">测试ModelAndView返回值</a><br>

    <a href="${pageContext.request.contextPath}/demo1/testMap">使用map集合进行域对象传值</a><br>

    <a href="${pageContext.request.contextPath}/demo1/testModel">使用Model进行域对象传值</a><br>
</body>
</html>
