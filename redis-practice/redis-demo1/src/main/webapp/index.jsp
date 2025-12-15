
<%@ page contentType="text/html;charset=UTF-8" language="java"
         isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<select name="province" id="province">
    <option>请选择</option>
</select>
</body>
<script src="http://code.jquery.com/jquery-2.1.4.min.js"/>
<script type="text/javascript">
    $(function(){
        $.ajax({
            type:"GET",
            url:"${pageContext.request.contextPath}/province/findAll",
            contentType:"application/json;charset=UTF-8",
            dataType:"json",
            success:function(data){
                $(data).each(function(){
                    var option = "<option id="+this.id+">"+this.name+"</option>";
                    $("#province").append(option);
                })
            }
        })
    })
</script>
</html>
