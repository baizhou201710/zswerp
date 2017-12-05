<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>权限与资源管理</title>
    <link rel="stylesheet" href="${contextPath}/resources/model/assets/css/amazeui.css" />
    <link rel="stylesheet" href="${contextPath}/resources/model/assets/css/core.css" />
    <link rel="stylesheet" href="${contextPath}/resources/model/assets/css/menu.css" />
    <link rel="stylesheet" href="${contextPath}/resources/model/assets/css/index.css" />
    <link rel="stylesheet" href="${contextPath}/resources/model/assets/css/admin.css" />
    <link rel="stylesheet" href="${contextPath}/resources/model/assets/css/page/typography.css" />
    <link rel="stylesheet" href="${contextPath}/resources/model/assets/css/page/form.css" />
    <link rel="stylesheet" href="${contextPath}/resources/model/assets/css/component.css" />
    <link rel="stylesheet" href="${contextPath}/resources/model/assets/tree/amazeui.tree.min.css" />
</head>
<body>
<header class="am-topbar am-topbar-fixed-top">
    <div class="am-topbar-left am-hide-sm-only">
        <a href="index.html" class="logo"><span>Admin<span>to</span></span><i class="zmdi zmdi-layers"></i></a>
    </div>

    <div class="contain">
        <ul class="am-nav am-navbar-nav am-navbar-left">

            <li><h4 class="page-title">基本表格</h4></li>
        </ul>

        <ul class="am-nav am-navbar-nav am-navbar-right">
            <li class="inform"><i class="am-icon-bell-o" aria-hidden="true"></i></li>
            <li class="hidden-xs am-hide-sm-only">
                <form role="search" class="app-search">
                    <input type="text" placeholder="Search..." class="form-control">
                    <a href=""><img src="${contextPath}/resources/model/assets/img/search.png"></a>
                </form>
            </li>
        </ul>
    </div>
</header>
<!-- Begin page -->

<!-- end page -->


<div class="admin">
    <!--<div class="am-g">-->
    <!-- ========== Left Sidebar Start ========== -->
    <!--<div class="left side-menu am-hide-sm-only am-u-md-1 am-padding-0">
        <div class="slimScrollDiv" style="position: relative; overflow: hidden; width: auto; height: 548px;">
            <div class="sidebar-inner slimscrollleft" style="overflow: hidden; width: auto; height: 548px;">-->
    <!-- sidebar start -->
    <div class="admin-sidebar am-offcanvas  am-padding-0" id="admin-offcanvas">
        <div class="am-offcanvas-bar admin-offcanvas-bar">
            <!-- User -->
            <div class="user-box am-hide-sm-only">
                <div class="user-img">
                    <img src="../assets/img/avatar-1.jpg" alt="user-img" title="Mat Helme" class="img-circle img-thumbnail img-responsive">
                    <div class="user-status offline"><i class="am-icon-dot-circle-o" aria-hidden="true"></i></div>
                </div>
                <h5><a href="#">Mat Helme</a> </h5>
                <ul class="list-inline">
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

            <ul class="am-list admin-sidebar-list">
                <li><a href="../index.html"><span class="am-icon-home"></span> 首页</a></li>
                <li class="admin-parent">
                    <a class="am-cf" data-am-collapse="{target: '#collapse-nav1'}"><span class="am-icon-table"></span> 表格 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
                    <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav1">
                        <li><a href="table_basic.html" class="am-cf"> 基本表格</span></a></li>
                        <li><a href="table_complete.html">完整表格</a></li>
                    </ul>
                </li>
                <li class="admin-parent">
                    <a class="am-cf" data-am-collapse="{target: '#collapse-nav2'}"><i class="am-icon-line-chart" aria-hidden="true"></i> 统计图表 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
                    <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav2">
                        <li><a href="chart_line.html" class="am-cf"> 折线图</span></a></li>
                        <li><a href="chart_columnar.html" class="am-cf"> 柱状图</span></a></li>
                        <li><a href="chart_pie.html" class="am-cf"> 饼状图</span></a></li>
                    </ul>
                </li>
                <li class="admin-parent">
                    <a class="am-cf" data-am-collapse="{target: '#collapse-nav5'}"><span class="am-icon-file"></span> 表单 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
                    <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav5">
                        <li><a href="form_basic.html" class="am-cf"> 基本表单</a></li>
                        <li><a href="form_validate.html">表单验证</a></li>
                    </ul>
                </li>
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
        <div class="content am-cf">
            <div class="card-box am-fl" style="height: 90%;width:20%">
                <ul class="am-tree am-tree-folder-select" role="tree" id="myTree">
                    <li class="am-tree-branch am-hide" data-template="treebranch" role="treeitem" aria-expanded="false">
                        <div class="am-tree-branch-header">
                            <button class="am-tree-icon am-tree-icon-caret am-icon-caret-right"><span class="am-sr-only">Open</span></button>
                            <button class="am-tree-branch-name">
                                <span class="am-tree-icon am-tree-icon-folder"></span>
                                <span class="am-tree-label"></span>
                            </button>
                        </div>
                        <ul class="am-tree-branch-children" role="group"></ul>
                        <div class="am-tree-loader"><span class="am-icon-spin am-icon-spinner"></span></div>
                    </li>
                    <li class="am-tree-item am-hide" data-template="treeitem" role="treeitem">
                        <button class="am-tree-item-name">
                            <span class="am-tree-icon am-tree-icon-item"></span>
                            <span class="am-tree-label"></span>
                        </button>
                    </li>
                </ul>
            </div>


            <div class="card-box  am-fr" style="height: 90%;width:79%">
                <div class="am-g">
                    <div class="am-u-sm-12 am-u-md-6 ">
                        <div class="am-btn-toolbar" >
                            <%--<div class="am-btn-group am-btn-group-xs ">--%>
                            <button type="button" class="am-btn am-btn-xs am-btn-primary " data-am-modal="{target: '#doc-modal-1', closeViaDimmer: 0, width: 800, height: 540}"><span class="am-icon-plus"></span> 新增</button>
                            <button type="button" class="am-btn am-btn-xs am-btn-primary " onclick="save()"><span class="am-icon-save"></span> 保存</button>
                            <button type="button" class="am-btn am-btn-xs am-btn-primary "><span class="am-icon-archive"></span> 审核</button>
                            <button type="button" class="am-btn am-btn-xs am-btn-primary "><span class="am-icon-trash-o"></span> 删除</button>
                            <%--</div>--%>
                        </div>
                    </div>

                    <div class="am-u-sm-12 am-u-md-5">
                        <div class="am-input-group ">
                            <input id="searchParams" type="text" class="am-form-field" maxlength="30">
                            <span class="am-input-group-btn">
				            <button id="searchBtn" class="am-btn am-btn-primary" type="button" >搜索</button>
				          </span>
                        </div>
                    </div>
                </div>
                <div class="am-g">
                    <div class="am-u-sm-12">
                        <form class="am-form">
                            <table class="am-table am-table-striped am-table-hover table-main am-table-compact ">
                                <thead>
                                <tr class="">
                                    <th class="table-check am-text-nowrap"></th>
                                    <th class="table-id am-text-nowrap">ID</th>
                                    <th class="table-title am-text-nowrap">资源名称</th>
                                    <th class="table-title am-text-nowrap">url</th>
                                    <th class="table-title am-text-nowrap ">层级</th>
                                    <th class="table-title am-text-nowrap">类型</th>
                                    <th class="table-title am-text-nowrap">状态</th>
                                    <th class="table-title am-text-nowrap">排序号</th>
                                    <th class="table-title am-text-nowrap">备注</th>
                                </tr>
                                </thead>
                                <tbody id="contents">
                                </tbody>
                            </table>
                            <div class="am-cf">
                                共<label id="tolPage" >0</label>页，<label id="tolRecord">0</label>条记录
                                <div class="am-fr">
                                    <ul class="am-pagination am-pagination-centered">
                                        <li class="am-disabled" id="perPage"><a href="#"> << Prev</a></li>
                                        <li class="am-active" id="page1"><a href="#" id="pagelink1">1</a></li>
                                        <li id="page2"><a href="#" id="pagelink2">2</a></li>
                                        <li id="page3"><a href="#" id="pagelink3">3</a></li>
                                        <li id="page4"><a href="#" id="pagelink4">4</a></li>
                                        <li id="page5"><a href="#" id="pagelink5">5</a></li>
                                        <li id="nextPage"><a href="#">Next >> </a></li>
                                    </ul>
                                </div>
                            </div>

                            <hr />

                            <p>注：.....</p>
                        </form>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>
<!-- end right Content here -->
<!--</div>-->
</div>
</div>

<!-- navbar -->
<a href="admin-offcanvas" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}"><!--<i class="fa fa-bars" aria-hidden="true"></i>--></a>

<script type="text/javascript" src="${contextPath}/resources/js/jquery-1.11.1.min.js" ></script>
<script type="text/javascript" src="${contextPath}/resources/model/assets/js/jquery-2.1.0.js" ></script>
<script type="text/javascript" src="${contextPath}/resources/model/assets/js/amazeui.min.js"></script>
<script type="text/javascript" src="${contextPath}/resources/model/assets/js/app.js" ></script>
<script type="text/javascript" src="${contextPath}/resources/model/assets/js/blockUI.js" ></script>
<script type="text/javascript" src="${contextPath}/resources/model/assets/tree/amazeui.tree.min.js" ></script>
<script>
    var pageSize=10;//默认每页10条数据
    var pageNo=1;//当前页码，默认第一页
    var tolPgae=1;//总页数，默认一页
    var selectedId="";//左侧树默认被选择时的id
    $(document).ready(function(){
        debugger
        //初始化加载数据
        $('#myTree').tree({
            dataSource:dataSource,
            multiSelect: false,
            cacheItems: true,
            folderSelect: true
        })
        queryList(selectedId,pageSize,pageNo);

    });

    //选择树
    var $myTree = $('#myTree');
    $('#myTree').on('selected.tree.amui', function(e, selected) {
        debugger
        selectedId=selected.target.attr.id;
        queryList(selectedId,pageSize,pageNo);
    });
    var dataSource = function(parentData, callback){
        var parentId="";
        if(parentData&&parentData.attr&&parentData.attr.id){
            parentId=parentData.attr.id;
        }
        console.info(parentData);
        $.ajax({
            type:'get',
            url:'${contextPath}/sys/permission/tree',
            dataType:'json',
            data:{"id":parentId},
            success:function(response) {

                if(response.code==0){
                    callback({ data:response.content});
                }else{
                    alert(response.msg);
                }
            },
            error : function() { alert("系统错误,请联系系统管理员！");}
        });
    };

//列表查询
function queryList(parentId,pageSize,pageNo) {
    //构造查询参数
    var key = $.trim($("#searchParams").val());
    var param={"pageNo": pageNo, "pageSize": pageSize};
    if(key){
        param.key=key;
    }else{
        param.parentId=parentId;
    }
    $.ajax({
        type: "post",
        dataType: "json",
        url: '${contextPath}/sys/permission/list',
        data: param,
        success: function (data) {
            //成功执行，显示列表
            if (data) {
                if (data.code == 0) {
                    //清除原有数据列表
                    $("#contents").empty();
                    $("#tolRecord").html(data.content.page.tolRecord);
                    $("#tolPage").html(data.content.page.tolPage);
                    tolPgae=data.content.page.tolPage;
                    if (data.content&&data.content.permissionList) {
                        var permissionList = data.content.permissionList;

                        for (var i = 0; i < permissionList.length; i++) {
                            var perId = permissionList[i].id;
                            tr = ' <tr class=""><td><i class="fa fa-plus-square" style="cursor:pointer" aria-hidden="true" id="i' + perId + '" onclick="showDetail(\'' + perId + '\')"></td>' +
                                '<td>' + (i + 1) + '</td>' +
                                '<td><a style="cursor:pointer" data-am-modal="{target: \'#doc-modal-1 \', closeViaDimmer: 0, width: 800, height: 540}"  onclick="setSelgoods(\'' + perId + '\')">' + permissionList[i].name + '</a></td>' +
                                '<td class="am-text-nowrap">' + permissionList[i].url + '</td>' +
                                '<td class="am-text-nowrap">' + permissionList[i].level + '</td>' +
                                '<td class="am-text-nowrap">' + permissionList[i].type + '</td>' +
                                '<td class="am-text-break">' + permissionList[i].state + '</td>' +
                                '<td class="am-text-nowrap">' + permissionList[i].orderNum + '</td>' +
                                '<td >' + permissionList[i].description + '</td>' +
                                '<td >' + permissionList[i].description + '</td>' +
                                '<td><a class="am-btn am-btn-default am-btn-xs am-text-secondary" data-am-modal="{target: \'#doc-modal-1\', closeViaDimmer: 0, width: 800, height: 540}" onclick="setSelgoods(\'' + perId + '\')"><span class="am-icon-pencil-square-o"></span> 编辑</a></td>'+
                                '<td><a class="am-btn am-btn-default am-btn-xs am-hide-sm-only" data-am-modal="{target: \'#doc-modal-2\', closeViaDimmer: 0, width: 800, height: 460}" onclick="setSelgoods(\'' + perId + '\')"><span class="am-icon-copy"></span>启用/禁用</a></td></tr>';

                            $tr=$(tr);
                            $("#contents").append($tr);

                        }


                        //页码排版
                        if(tolPgae<=5){
                            if(tolPgae<=1){
                                $('#perPage').addClass('am-disabled');
                                $('#nextPage').addClass('am-disabled');

                                $('#page1').nextAll().addClass('am-disabled');
                            }else if(tolPgae==2){
                                $("#page2").nextAll().addClass('am-disabled');
                                $('#nextPage').removeClass('am-disabled');
                                if(pageNo==2){
                                    $("#page1").removeClass('am-active');
                                    $("#page2").addClass('am-active');

                                    $('#perPage').removeClass('am-disabled');
                                    $('#nextPage').addClass('am-disabled');
                                }

                            }else if(tolPgae==3){
                                $("#page3").nextAll().addClass('am-disabled');
                                $('#nextPage').removeClass('am-disabled');
                                if(pageNo==2){
                                    $("#page1").removeClass('am-active');
                                    $("#page2").addClass('am-active');

                                    $('#perPage').removeClass('am-disabled');
                                    $('#nextPage').removeClass('am-disabled');
                                }else if(pageNo==3){
                                    $("#page1").removeClass('am-active');
                                    $("#page3").addClass('am-active');

                                    $('#perPage').removeClass('am-disabled');
                                    $('#nextPage').addClass('am-disabled');
                                }
                            }
                        }else{//大于5页
                            if(pageNo==2){
                                $("#page1").removeClass('am-active');
                                $("#page2").addClass('am-active');
                                $('#perPage').removeClass('am-disabled');
                            }else if(pageNo>=3){

                                $("#page1").removeClass('am-active');

                                if(pageNo-3>=1){
                                    $('#perPage').removeClass('am-disabled');
                                }
                                if(tolPgae-pageNo>=3){
                                    $('#pagelink1').html(pageNo-2);
                                    $('#pagelink2').html(pageNo-1);
                                    $('#pagelink3').html(pageNo);
                                    $('#pagelink4').html(pageNo+1);
                                    $('#pagelink5').html(pageNo+2);
                                    $("#page3").addClass('am-active');
                                }else if(tolPgae-pageNo==2){
                                    $('#pagelink1').html(pageNo-2);
                                    $('#pagelink2').html(pageNo-1);
                                    $('#pagelink3').html(pageNo);
                                    $('#pagelink4').html(pageNo+1);
                                    $('#pagelink5').html(pageNo+2);
                                    $("#page3").addClass('am-active');
                                    $('#nextPage').addClass('am-disabled');
                                }else if(tolPgae-pageNo==1){
                                    $("#page4").addClass('am-active');
                                    $('#nextPage').addClass('am-disabled');
                                }else if(tolPgae-pageNo==0){
                                    $("#page5").addClass('am-active');
                                    $('#nextPage').addClass('am-disabled');
                                }
                            }
                        }
                    }

                } else {
                    alert(data.msg);
                }
            }
        },
        error : function() {alert("系统错误,请联系系统管理员！");}
    });
}

</script>

</body>

</html>
