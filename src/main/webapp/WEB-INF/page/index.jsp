
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="${contextPath}/resources/model/assets/css/amazeui.css" />
    <link rel="stylesheet" href="${contextPath}/resources/model/assets/css/core.css" />
    <link rel="stylesheet" href="${contextPath}/resources/model/assets/css/menu.css" />
    <link rel="stylesheet" href="${contextPath}/resources/model/assets/css/index.css" />
    <link rel="stylesheet" href="${contextPath}/resources/model/assets/css/admin.css" />
    <link rel="stylesheet" href="${contextPath}/resources/model/assets/css/page/typography.css" />
    <link rel="stylesheet" href="${contextPath}/resources/model/assets/css/page/form.css" />
    <link rel="stylesheet" href="${contextPath}/resources/model/assets/css/component.css" />
</head>
<body>
<!-- Begin page -->
<header class="am-topbar am-topbar-fixed-top">
    <div class="am-topbar-left am-hide-sm-only">
        <a href="index.html" class="logo"><span>Admin<span>to</span></span><i class="zmdi zmdi-layers"></i></a>
    </div>

    <div class="contain">
        <ul class="am-nav am-navbar-nav am-navbar-left">

            <li><h4 class="page-title">元器件</h4></li>
        </ul>

      <%--  <ul class="am-nav am-navbar-nav am-navbar-right">
            <li class="inform"><i class="am-icon-bell-o" aria-hidden="true"></i></li>
            <li class="hidden-xs am-hide-sm-only">
                <form role="search" class="app-search">
                    <input type="text" placeholder="Search..." class="form-control">
                    <a href=""><img src="${contextPath}/resources/model/assets/img/search.png"></a>
                </form>
            </li>
        </ul>--%>
    </div>
</header>
<!-- end page -->


<div class="admin">
    <!-- sidebar start -->
    <div class="admin-sidebar am-offcanvas  am-padding-0" id="admin-offcanvas">
        <div class="am-offcanvas-bar admin-offcanvas-bar">
            <!-- User -->
            <div class="user-box am-hide-sm-only">
                <div class="user-img">
                    <img src="${contextPath}/resources/model/assets/img/avatar-1.jpg" alt="user-img" title="Mat Helme" class="img-circle img-thumbnail img-responsive">
                    <div class="user-status offline"><i class="am-icon-dot-circle-o" aria-hidden="true"></i></div>
                </div>
                <h5><a href="#">Mat Helme</a> </h5>
                <ul class="list-inline" >
                    <li>
                        <a href="#">
                            <i class="fa fa-cog" aria-hidden="true"></i>
                        </a>
                    </li>

                    <li>
                        <a href="#" class="text-custom">
                            <i class="fa fa-cog" aria-hidden="true"></i>
                        </a>
                    </li>
                </ul>
            </div>
            <!-- End User -->

            <ul class="am-list admin-sidebar-list"  id="ullist">
                <%--<li class="admin-parent">
                    <a class="am-cf" data-am-collapse="{target: '#collapse-nav1'}"><span class="am-icon-table"></span> 系统管理<span class="am-icon-angle-right am-fr am-margin-right"></span></a>
                    <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav1">
                        <li><a href="html/table_basic.html" class="am-cf"> 用户管理</span></a></li>
                        <li id="icli"><a href="${contextPath}/goods/index">角色管理</a></li>
                        <li id="icli"><a href="${contextPath}/goods/index">资源管理</a></li>
                        <li id="icli"><a href="${contextPath}/goods/index">权限管理</a></li>
                    </ul>
                </li>--%>
                <%--<li><a href="index.html"><span class="am-icon-home"></span> 首页</a></li>
                <li class="admin-parent">
                    <a class="am-cf" data-am-collapse="{target: '#collapse-nav1'}"><span class="am-icon-table"></span> 元器件 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
                    <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav1">
                        <li><a href="html/table_basic.html" class="am-cf"> 基本表格</span></a></li>
                        <li id="icli"><a href="${contextPath}/goods/index">元器件管理</a></li>
                    </ul>
                </li>
                <li class="admin-parent">
                    <a class="am-cf" data-am-collapse="{target: '#collapse-nav2'}"><i class="am-icon-line-chart" aria-hidden="true"></i> 统计图表 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
                    <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav2">
                        <li><a href="html/chart_line.html" class="am-cf"> 折线图</span></a></li>
                        <li><a href="html/chart_columnar.html" class="am-cf"> 柱状图</span></a></li>
                        <li><a href="html/chart_pie.html" class="am-cf"> 饼状图</span></a></li>
                    </ul>
                </li>
                <li class="admin-parent">
                    <a class="am-cf" data-am-collapse="{target: '#collapse-nav5'}"><span class="am-icon-file"></span> 表单 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
                    <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav5">
                        <li><a href="html/form_basic.html" class="am-cf"> 基本表单</a></li>
                        <li><a href="html/form_validate.html">表单验证</a></li>
                    </ul>
                </li>--%>
            </ul>
        </div>
    </div>
    <!-- sidebar end -->

    <!--</div>
</div>
</div>-->
    <!-- ========== Left Sidebar end ========== -->



    <!--	<div class="am-g">-->
    <!-- ============================================================== -->
    <!-- Start right Content here -->
    <div class="content-page">
        <!-- Start content -->
        <div class="content"></div>
    </div>
    <!-- end right Content here -->
    <!--</div>-->
</div>
</div>
<<input type="hidden" id="permissions" value="${permissions}">
<!-- navbar -->
<a href="admin-offcanvas" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}"><!--<i class="fa fa-bars" aria-hidden="true"></i>--></a>

<script type="text/javascript" src="${contextPath}/resources/js/jquery-1.11.1.min.js" ></script>
<script type="text/javascript" src="${contextPath}/resources/model/assets/js/jquery-2.1.0.js" ></script>
<script type="text/javascript" src="${contextPath}/resources/model/assets/js/amazeui.min.js"></script>
<script type="text/javascript" src="${contextPath}/resources/model/assets/js/app.js" ></script>
<script type="text/javascript" src="${contextPath}/resources/model/assets/js/blockUI.js" ></script>


<script>
    //初始化加载权限菜单
    $(document).ready(function(){
        //加载菜单
        var permissions= ${permissions};
        console.info(permissions);
        if(permissions){
            debugger
            for (var i=0;i<permissions.length;i++){
                level2='<li class="admin-parent">'+
                    '<a class="am-cf" data-am-collapse="{target: \'#collapse-nav1\'}"><span class="am-icon-table"></span>'+ permissions[i].name+'<span class="am-icon-angle-right am-fr am-margin-right"></span></a>'+
                    '<ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav1">';

                if(permissions[i].chlidPermissions){
                    var chilren = permissions[i].chlidPermissions;
                    for(var j=0;j<chilren.length;j++){
                        level2=level2+'<li id="icli"><a href="${contextPath}'+chilren[j].url+'">'+chilren[j].name+'</a></li>';
                    }

                }
                level2=level2+' </ul></li>';

                $level2=$(level2);
                $('#ullist').append($level2);
            }


        }

    });

</script>
</body>

</html>
