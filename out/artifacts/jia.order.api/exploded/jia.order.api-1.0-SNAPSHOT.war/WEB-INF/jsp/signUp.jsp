<%--
  Created by IntelliJ IDEA.
  User: jingbo.lin
  Date: 2016/8/5
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="../../resources/js/jquery-3.1.0.js"></script>
    <script type="text/javascript" src="../../resources/js/jquery-3.1.0.min.js"></script>
    <script type="text/javascript" src="../../resources/js/bootstrap.min.js"></script>
    <link href="../../resources/js/bootstrap.min.css" rel="stylesheet" >
    <script type="text/javascript" >
//        $(document).ready(function () {
//
//            $("#signUp").on("click",function () {
//                var un = $("#name").val();
//                var pwd = $("#pwd").val();
//                $.ajax({
//                    url:"/insert",
//                    data:{name:un,password:pwd},
//                    type:"POST",
//                    dataType:"json",
//                    success:function (data) {
//                        alert("welcome " + data.name + "! Don forget you id:" + data.id);
//                        window.location.href = "/index";
//                    },
//                    error:function () {
//                        alert("error");
//                    }
//                })
//            })
//        })

    </script>
    <title>Sign Up</title>
</head>
<body>
<nav class = "navbar navbar-default navbar-static-top" role = "navigation" >
    <div class = "navbar-header">
        <a class = "navbar-brand" href = "/">MyTest</a>
    </div>
    <div>
        <ul class = "nav navbar-nav">
            <li><a href = "/">Home</a></li>
            <li class = "active"><a href = "/signUp">Sign Up</a></li>
        </ul>

    </div>

</nav>
<form class = "form-horizontal" role = "form" action = "/insert" method="get" onsubmit="window.location.href = '/index';" >
    <div class = "form-group">
        <label class="col-sm-2 control-label" for = "name">UserName</label>
        <div class = "col-sm-10">
            <input type = "text" id = "name" name="name" placeholder="username">
        </div>

    </div>
    <div class = "form-group">
        <label class = "col-sm-2 control-label" for = "pwd">Password</label>
        <div class = "col-sm-10">
            <input type = "password" id = "pwd" name="pwd" placeholder="password">
        </div>
    </div>
    <div class = "form-group">
        <div class = "col-sm-offset-2 col-sm-10">
            <input type = "submit" value = "submit">
            <%--<button class = "btn btn-default" id = "signUp">sign up</button>--%>
        </div>
    </div>

</form>



</body>
</html>
