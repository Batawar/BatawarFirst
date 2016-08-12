<%--
  Created by IntelliJ IDEA.
  User: jingbo.lin
  Date: 2016/8/1
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
    <title>myIndex</title>
    <link href="../../resources/js/bootstrap.min.css" rel="stylesheet" >
    <script type="text/javascript" src="../../resources/js/jquery-3.1.0.min.js"></script>
    <script type="text/javascript" src="../../resources/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../../resources/js/Angular.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
        $("#editUser").on("click",function () {

            $.ajax({
                type:"GET",
                url:"/get",
                success:function(){
                   // alert("good");
                    window.location.href = "/edit"
                }
            });

        });
        $("#test").on("click",function(){
            $.ajax({
                type:"GET",
                url:"/index/test",
                success:function(){
                    alert("hhh");
                },
                error:function () {
                    alert("nnn");
                }
            })
        })
    });

</script>
</head>
<body>
<nav class = "navbar navbar-default navbar-static-top" role = "navigation" >
    <div class = "navbar-header">
        <a class = "navbar-brand" href = "/">MyTest</a>
    </div>
    <div>
        <ul class = "nav navbar-nav">
            <li><a href = "/">Home</a></li>
            <li class = "active"><a href = "/index">Index</a></li>
        </ul>
    </div>
    <div class = "navbar-right">
        <p class = "navbar-text">Signed in as</p>

        <button type = "button" class = "btn btn-default navbar-btn dropdown-toggle" data-toggle="dropdown">${name}
            <span class = "caret"></span>
        </button>
        <ul class = "dropdown-menu" role = "menu">
            <li><a href = "/index/logOut">Log out</a></li>
        </ul>



        <span>&nbsp;*5</span>
    </div>

</nav>
<br>
<div class = "page-header">
    <div class="container ">
        <div class="row">
            <div class="col-md-1">
                <img id="blog"src="../../resources/image/下载.jpg" class="img-rounded" width="80px" height="80px"/>
            </div>
            <div class="col-md-6">
                <h1>
                    MyIndex<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><small>Create by jingbo.lin</small>
                </h1>

            </div>

        </div>
    </div>
</div>


    <h1>Hello World!</h1>
<input type="button" value="edit" id="editUser" name="editUser">
<button type="button" id="test" name="test">test</button>
</body>
</html>
