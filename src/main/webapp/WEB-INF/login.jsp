<%--
  Created by IntelliJ IDEA.
  User: baizhou
  Date: 2017/11/16
  Time: 17:08
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登陆</title>
    <link rel="stylesheet" href="${contextPath}/resources/model/assets/css/core.css" />
    <link rel="stylesheet" href="${contextPath}/resources/model/assets/css/menu.css" />
    <link rel="stylesheet" href="${contextPath}/resources/model/assets/css/amazeui.css" />
    <link rel="stylesheet" href="${contextPath}/resources/model/assets/css/component.css" />
    <link rel="stylesheet" href="${contextPath}/resources/model/assets/css/page/form.css" />
</head>
<body>
<div class="account-pages">
    <div class="wrapper-page">
        <div class="text-center">
            <a href="${contextPath}/login" class="logo"><span>北京中声文<span>进销存</span></span></a>
        </div>

        <div class="m-t-40 card-box">
            <div class="text-center">
                <h4 class="text-uppercase font-bold m-b-0">Sign In</h4>
            </div>
            <div class="panel-body">
                <form class="am-form">
                    <div class="am-g">
                        <div class="am-form-group">
                            <input id="username" type="text" class="am-radius"  placeholder="Username" maxlength="15">
                        </div>

                        <div class="am-form-group form-horizontal m-t-20">
                            <input id="password" type="password" class="am-radius"  placeholder="Password" maxlength="18">
                        </div>

                        <div class="am-form-group ">
                            <label style="font-weight: normal;color: #999;">
                                <input type="checkbox" class="remeber"> Remember me
                            </label>
                        </div>

                        <div class="am-form-group ">
                            <button id="button" type="button" class="am-btn am-btn-primary am-radius" style="width: 100%;height: 100%;">Log In</button>
                        </div>

                        <div class="am-form-group ">
                            <a href="page-recoverpw.html" class="text-muted"><i class="fa fa-lock m-r-5"></i> Forgot your password?</a>
                        </div>
                    </div>

                </form>

            </div>
        </div>
    </div>
   ${code};
</div>
<script type="text/javascript" src="${contextPath}/resources/js/jquery-1.11.1.min.js" ></script>
<script>
    $(document).ready(function(){
        //登陆
        $("#button").click(function(){
            var username= $("#username").val();
            var password=$("#password").val();
            if(!username){
                alert("请输入用户名！");
            }
            if(!password){
                alert("请输入密码！");
            }
            console.info("rew");
            $.ajax({
                type: "post",
                dataType: "json",
                url: '${contextPath}/login',
                data: {"username":username,"password":password},
                success: function (data) {
                    //成功执行
                   if(data){
                       if(data.code==0){
                           //登陆成功自动跳转
                           window.location.href="${contextPath}/index";
                       }else{
                           //失败提示信息
                           alert(data.msg);
                       }
                   }
                }
            });
        });


        //校验username参数，只能为数字或字母，不能超过15位
        $("#username").change(function(){
            if($("#username").val()){
                var re =  /^[0-9a-zA-Z]*$/g;  //判断字符串是否为数字和字母组合
                if(!re.test($("#username").val())||$("#username").val().length>15){
                    alert("登陆账号为小于15位的字母和数字组合，请正确输入！")
                }
            }

        });
        //校验password参数，不能超过18位,不能小于6位
        $("#password").change(function(){
            if($("#password").val()){
                if($("#password").val().length>18){
                    alert("密码长度应小于18位！")
                }
            }
        });
    });

</script>
</body>
</html>