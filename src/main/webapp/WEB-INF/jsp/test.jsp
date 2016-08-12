<%--
  Created by IntelliJ IDEA.
  User: jingbo.lin
  Date: 2016/7/26
  Time: 11:43
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
        $(document).ready(function() {
            $("#submit").on("click", function() {
              //  alert($("#name").val());
                var ttt = $("#name").val();
                var pwd = $("#pwd").val();
                var t = $("#id").val();
                $.ajax({
                    data:{id:t,name:ttt,password:pwd},
                    type:"POST",
                    dataType:"json",
                    url: "/login",
                    error:function(data) {
                        alert("error!!!:" + data.msg);
                        $("#result").html("不存在该账号");
                        document.getElementById("warning").style.display = "block";
                    },
                    success:function (data) {
                      //  alert("success:" + data.msg);
                        if(data.msg == "fail"){

                            $("#result").html("请输入正确账户密码");
                            document.getElementById("warning").style.display = "block";
                        }
                        else{
                            window.location.href = "/index";
                        }

                    }
                });
            });
            $("#signUp").on("click",function(){

                window.location.href = "/signUp";

            });


        });


    </script>
    <script type="text/javascript">
        function login(){
            if(event.keyCode == 13){
                document.getElementsById("submit").click();
            }
        }
    </script>
</head>

<body id="xxx" onkeydown="login()">

    <nav class = "navbar navbar-default navbar-static-top" role = "navigation" >
        <div class = "navbar-header">
            <a class = "navbar-brand" href = "/">MyTest</a>
        </div>
        <div>
            <ul class = "nav navbar-nav">
                <li class = "active"><a href = "/">Home</a></li>
                <li><a href = "/signUp">Sign Up</a></li>
            </ul>

        </div>

    </nav>

    <div style = "display:none" id = "warning">
        <div class = "alert alert-dismissable alert-warning" >
            <div id = "result"></div>
            <button type = "button" class = "close" data-dismiss = "alert" aria-hidden="true">&times;</button>
        </div>

    </div>
    <%--<ul class="nav nav-tabs">--%>
        <%--<li class="active"><a href="/">Home</a> </li>--%>
        <%--<li><a href="/signUp">Sign Up</a> </li>--%>
        <%--<li><a href="/index">Index</a></li>--%>
    <%--</ul>--%>

    <div class="container">
        <div class="row">
            <br><br><br>
        </div>

        <div class="row " style="background-image: url(../../resources/image/tomcat.jpg); display:table;margin-left:auto;margin-right:auto; padding:200px; ">
            <p class="text-center text-primary">
                <strong>Welcome</strong><br>
            </p>



            <input type="text" id="id" name="id" placeholder="id">

            <br><br>
            <input type="text" id = "name" name = "name" placeholder="username">


            <br><br>
            <input type="password" id="pwd" name="pwd" placeholder="password">
            <br><br>

            <button id="signUp" class="btn btn-default">sign up</button>
            <span>&nbsp;*2</span>
            <button id="submit" name="submit" class="btn btn-default">log in</button>

        </div>

        <div class="row">
            <br><br><br>
        </div>
    </div>







</body>
</html>
