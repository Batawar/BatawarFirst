<%--
  Created by IntelliJ IDEA.
  User: jingbo.lin
  Date: 2016/8/8
  Time: 18:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="../../resources/js/jquery-3.1.0.js"></script>
    <script type="text/javascript" src="../../resources/js/jquery-3.1.0.min.js"></script>
    <script type="text/javascript" src="../../resources/js/bootstrap.min.js"></script>
    <link href="../../resources/js/bootstrap.min.css" rel="stylesheet" >
    <script type="text/javascript">
        $(document).ready(function(){
            $("#getImage").on("click",function(){
                $.ajax({
                    type:"GET",
                    url:"/getFile/getImage",
                    error:function () {
                        $("#haha").html = "error";
                    },
                    success:function () {
                        $("#haha").html = "success";
                    }
                })

            })
        })
    </script>
</head>
<body>
Let's get images.
<button id="getImage" name="getImage" type="button">get</button>
${End}
<div id="haha">${End}</div>
</body>
</html>
