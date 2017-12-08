<%@ page language="java" pageEncoding="UTF-8" %>
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


    <script type="text/javascript" src="${contextPath}/resources/js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="${contextPath}/resources/model/assets/js/jquery-2.1.0.js"></script>
    <script type="text/javascript" src="${contextPath}/resources/model/assets/js/amazeui.min.js"></script>
    <script type="text/javascript" src="${contextPath}/resources/model/assets/js/app.js"></script>
    <script type="text/javascript" src="${contextPath}/resources/model/assets/js/blockUI.js"></script>
    <script type="text/javascript" src="${contextPath}/resources/model/assets/js/amazeui.dialog.min.js"></script>
    <script type="text/javascript" src="${contextPath}/resources/util/util.js"></script>

</head>
<body>
<!-- Begin page -->
<header class="am-topbar am-topbar-fixed-top">
    <div class="am-topbar-left am-hide-sm-only">
        <a href="index.html" class="logo"><span>Admin<span>to</span></span><i class="zmdi zmdi-layers"></i></a>
    </div>

    <div class="contain">
        <ul class="am-nav am-navbar-nav am-navbar-left">

            <li><h4 class="page-title"></h4></li>
        </ul>
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
            </ul>
        </div>
    </div>
    <!-- sidebar end -->
    <!-- ========== Left Sidebar end ========== -->



    <!--	<div class="am-g">-->
    <!-- ============================================================== -->
    <!-- Start right Content here -->
    <div class="content-page" id="content">
    </div>
    <!-- end right Content here -->
    <!--</div>-->
</div>
</div>


<!-- navbar -->
<a href="admin-offcanvas" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}"><!--<i class="fa fa-bars" aria-hidden="true"></i>--></a>

<script>
    //初始化加载权限菜单
    var rootUrl = "${contextPath}";
    $(document).ready(function(){
        //加载菜单
        var permissions= ${permissions};
        if(permissions){
            for (var i=0;i<permissions.length;i++){
                level2='<li class="admin-parent">'+
                    '<a class="am-cf" data-am-collapse="{target: \'#collapse-nav1\'}"><span class="am-icon-table"></span>'+ permissions[i].name+'<span class="am-icon-angle-right am-fr am-margin-right"></span></a>'+
                    '<ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav1">';

                if(permissions[i].chlidPermissions){
                    var chilren = permissions[i].chlidPermissions;
                    for(var j=0;j<chilren.length;j++){
                        level2 = level2 + '<li onclick="loadPage(\'' + chilren[j].url + '\',this)"><a href="#">' + chilren[j].name + '</a></li>';
                    }

                }
                level2=level2+' </ul></li>';

                $level2=$(level2);
                $('#ullist').append($level2);
            }


        }

    });

    //加载页面
    function loadPage(url, a) {
        $('#content').load(rootUrl + url);
    }


</script>
</body>
</html>
