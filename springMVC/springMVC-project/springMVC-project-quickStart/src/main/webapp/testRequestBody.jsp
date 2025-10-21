
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <input type="button" value="按钮" id="testJson">

    <form action="${pageContext.request.contextPath}/demo2/testRequestEntity" method="post">
        用户名 <input type="text" name="username"><br>
        用户密码 <input type="password" name="password"><br>
        用户年龄 <input type="text" name="age"><br>
        <input type="submit" value="提交">
    </form>
</body>
<script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
    $(function(){
        $("#testJson").click(function () {
            $.ajax({
                type: 'post',
                url: '${pageContext.request.contextPath}/demo2/testAjax',
                contentType: 'application/json;charset=utf-8',
                data: '{"id": 1, "name": "kobe", "money": 1000.0}',
                dataType: 'json',
                success: function (data) {
                    console.log(data);
                }
            })
        })
    })
</script>
</html>
