<%--
  Created by IntelliJ IDEA.
  User: jingbo.lin
  Date: 2016/7/27
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script type="text/javascript" src="../../resources/js/Angular.js"></script>
<script type="text/javascript" >
    function minute(){

        window.location.href = "/index"
    }
   /*  var app = angular.module('myApp', []);
            app.common('demoController', ['$scope', '$interval', function($s, $i) {
                $s.time = 3;
                var timer = null;
                timer = $i(function(){
                    $s.time = $s.time - 1;
                    if($s.time === 0) {
                        $i.cancel(timer);
                    }
                }, 1000);
            }]); */
    window.setTimeout(minute,1000);
</script>

<head>
    <title>two</title>
</head>
<body>
<h1>
    Loading...
   <!-- <div ng-app="myApp">{{countDown}}</div> -->
</h1>
</body>
</html>
