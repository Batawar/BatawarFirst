<%--
  Created by IntelliJ IDEA.
  User: jingbo.lin
  Date: 2016/8/2
  Time: 18:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="../../resources/js/jquery-3.1.0.js"></script>
    <script type="text/javascript" src="../../resources/js/jquery-3.1.0.min.js"></script>
    <script type="text/javascript">
      //  alert(document.getElementById("hide").value);
        function change() {
            if($("#cpwd").val() != "${password}"){
                alert("The current pawword is wrong")
            }
            else{
                var mid = ${id};
                var nn = $("#newName").val();
                var np = $("#npwd").val();
                $.ajax({
                    type:"POST",
                    data:{id:mid,name:nn,password:np},
                    url:"/index/edit",
                    success:function(){
                        alert("good change");
                        window.location.href = "/edit"
                    },
                    error:function(){
                        alert("error");
                    }
                })
            }
        }
    </script>
</head>
<body>
id:${id}<br>
current name:${name}<br>
new name:<input type="text" id="newName">
current password:<input type="password" id="cpwd"><br>
<div id="check"></div>
new password:<input type="password" id="npwd"><br>
<input type="button" value="submit" onclick="change()" >
</body>
</html>
