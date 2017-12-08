<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta charset="utf-8"/>
    <meta content="width=device-width, initial-scale=1.0">
    <title>权限与资源管理</title>
    <link rel="stylesheet" href="${contextPath}/resources/model/assets/css/amazeui.css"/>
    <link rel="stylesheet" href="${contextPath}/resources/model/assets/css/core.css"/>
    <link rel="stylesheet" href="${contextPath}/resources/model/assets/css/menu.css"/>
    <link rel="stylesheet" href="${contextPath}/resources/model/assets/css/index.css"/>
    <link rel="stylesheet" href="${contextPath}/resources/model/assets/css/admin.css"/>
    <link rel="stylesheet" href="${contextPath}/resources/model/assets/css/page/typography.css"/>
    <link rel="stylesheet" href="${contextPath}/resources/model/assets/css/page/form.css"/>
    <link rel="stylesheet" href="${contextPath}/resources/model/assets/css/component.css"/>
    <link rel="stylesheet" href="${contextPath}/resources/model/assets/tree/amazeui.tree.min.css"/>

    <script type="text/javascript" src="${contextPath}/resources/js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="${contextPath}/resources/model/assets/js/jquery-2.1.0.js"></script>
    <script type="text/javascript" src="${contextPath}/resources/model/assets/js/amazeui.min.js"></script>
    <script type="text/javascript" src="${contextPath}/resources/model/assets/js/app.js"></script>
    <script type="text/javascript" src="${contextPath}/resources/model/assets/js/blockUI.js"></script>
    <script type="text/javascript" src="${contextPath}/resources/model/assets/tree/amazeui.tree.min.js"></script>
    <script type="text/javascript" src="${contextPath}/resources/model/assets/js/amazeui.dialog.min.js"></script>


</head>
<body>
<!-- Begin page -->
<header class="am-topbar am-topbar-fixed-top">
    <div class="am-topbar-left am-hide-sm-only">
        <a href="index.html" class="logo"><span>Admin<span>to</span></span><i class="zmdi zmdi-layers"></i></a>
    </div>

    <div class="contain">
        <ul class="am-nav am-navbar-nav am-navbar-left">

            <li><h4 class="page-title">权限与资源管理</h4></li>
        </ul>
    </div>
</header>
<!-- end page -->


<div class="admin">
    <!-- Start right Content here -->
    <!-- Start content -->
    <div class="content am-cf" id="tree">
        <div class="card-box am-fl" style="height: 90%;width:20%">
            <ul class="am-tree am-tree-folder-select" role="tree" id="myTree">
                <li class="am-tree-branch am-hide" data-template="treebranch" role="treeitem" aria-expanded="false">
                    <div class="am-tree-branch-header">
                        <button class="am-tree-icon am-tree-icon-caret am-icon-caret-right"><span class="am-sr-only">Open</span>
                        </button>
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


        <div class="card-box  am-fr" style="height: 90%;width:80%">
            <div class="am-g">
                <div class="am-u-sm-12 am-u-md-6 ">
                    <div class="am-btn-toolbar">
                        <%--<div class="am-btn-group am-btn-group-xs ">--%>
                        <button type="button" class="am-btn am-btn-xs am-btn-primary" onclick="" setselPermission()>
                            <span class="am-icon-plus"></span> 新增
                        </button>
                        <%--<button type="button" class="am-btn am-btn-xs am-btn-primary " onclick="save()"><span class="am-icon-save"></span> 保存</button>
                        <button type="button" class="am-btn am-btn-xs am-btn-primary "><span class="am-icon-archive"></span> 审核</button>
                        <button type="button" class="am-btn am-btn-xs am-btn-primary "><span class="am-icon-trash-o"></span> 删除</button>--%>
                        <%--</div>--%>
                    </div>
                </div>

                <div class="am-u-sm-12 am-u-md-5">
                    <div class="am-input-group ">
                        <input id="searchParams" type="text" class="am-form-field" maxlength="30">
                        <span class="am-input-group-btn">
				            <button id="searchBtn" class="am-btn am-btn-primary" type="button">搜索</button>
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
                                <th class="table-id am-text-nowrap">ID</th>
                                <th class="table-title am-text-nowrap">资源名称</th>
                                <th class="table-title am-text-nowrap">url</th>
                                <th class="table-title am-text-nowrap">层级</th>
                                <th class="table-title am-text-nowrap">类型</th>
                                <th class="table-title am-text-nowrap">状态</th>
                                <th class="table-title am-text-nowrap">排序号</th>
                                <th class="table-title am-text-nowrap">备注</th>
                                <th class="table-title am-text-nowrap" colspan="2">操作</th>
                            </tr>
                            </thead>
                            <tbody id="contents">
                            </tbody>
                        </table>
                        <div class="am-cf">
                            共<label id="tolPage">0</label>页，<label id="tolRecord">0</label>条记录
                            <div class="am-fr">
                                <ul class="am-pagination am-pagination-centered">
                                    <li class="am-disabled" id="perPage"><a href="#"> << Prev</a></li>
                                    <li class="am-active" id="pageNow"><a href="#" id="pagelink">1</a></li>
                                    <li id="nextPage" class="am-disabled"><a href="#">Next >> </a></li>
                                </ul>
                            </div>
                        </div>

                        <hr/>

                        <p>注：.....</p>
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<!-- end right Content here -->
<!--</div>-->
</div>
</div>

<script>
    var $loading = AMUI.dialog.loading();

    //setTimeout(function() { $loading.modal('close'); }, 3000);

    //设置iframe大小
    debugger
    var pageHight = $(window).height();
    var pageWidth = $(window).width();
    $('#permissionInfo').width(pageWidth * 0.55);
    $('#permissionInfo').height(pageHight * 0.55);
    $('#add').attr("data-am-modal", "{target: '#detailPage', closeViaDimmer: 0, width:" + pageWidth * 0.6 + ", height:" + pageHight * 0.75 + "}");

    var pageSize = 10;//默认每页10条数据
    var pageNo = 1;//当前页码，默认第一页
    var tolPgae = 1;//总页数，默认一页
    var selectedId = "";//左侧树默认被选择时的id
    var selPermissonId = "";//被选中的项id
    $(document).ready(function () {
        //初始化加载数据
        $('#myTree').tree({
            dataSource: dataSource,
            multiSelect: false,
            cacheItems: false,
            folderSelect: true
        })
        queryList(selectedId, pageNo, pageSize);

    });

    //选择树
    var $myTree = $('#myTree');
    $('#myTree').on('selected.tree.amui', function (e, selected) {
        selectedId = selected.target.attr.id;
        queryList(selectedId, pageNo, pageSize);
    });
    var dataSource = function (parentData, callback) {
        debugger
        var parentId = "";
        if (parentData && parentData.attr && parentData.attr.id) {
            parentId = parentData.attr.id;
        }
        $.ajax({
            type: 'get',
            url: '${contextPath}/sys/permission/tree',
            dataType: 'json',
            data: {"id": parentId},
            success: function (response) {

                if (response.code == 0) {
                    callback({data: response.content});
                } else {
                    myAlert(response.msg);
                }
            },
            error: function () {
                myAlert("系统错误,请联系系统管理员！");
            }
        });
    };


    //查询按钮
    $("#searchBtn").click(function () {
        pageSize = 10;
        pageNo = 1;
        initPage();
        queryList("", pageNo, pageSize);
    });


    //分页，上一页
    $("#perPage").click(function () {
        if ($(this).hasClass('am-disabled')) {
            return;
        }
        if (pageNo <= 1) {
            return;
        }
        pageNo = pageNo - 1;
        initPage();
        queryList("", pageNo, pageSize);
    });

    //分页，下一页
    $("#nextPage").click(function () {
        if ($(this).hasClass('am-disabled')) {
            return;
        }
        tolPage = parseInt($("#tolPage").html());
        if (pageNo >= tolPage) {
            return;
        }
        pageNo = pageNo + 1;
        initPage();
        queryList("", pageNo, pageSize);
    });

    //pageNow
    $('#pageNow').click(function () {
        if ($(this).hasClass('am-disabled')) {
            return;
        }
        initPage();
        pageNo = parseInt($('#pagelink').html());
        queryList("", pageNo, pageSize);
    });

    //列表查询
    function queryList(parentId, pageNo, pageSize) {
        debugger
        //构造查询参数
        var key = $.trim($("#searchParams").val());
        var param = {"pageNo": pageNo, "pageSize": pageSize};
        if (key) {
            param.key = key;
        } else {
            param.parentId = parentId;
        }
        $loading.modal('open');
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
                        $('#pagelink').html(pageNo);
                        $("#tolRecord").html(data.content.page.tolRecord);
                        $("#tolPage").html(data.content.page.tolPage);
                        tolPgae = data.content.page.tolPage;
                        if (data.content && data.content.permissionList) {
                            var permissionList = data.content.permissionList;

                            for (var i = 0; i < permissionList.length; i++) {
                                var perId = permissionList[i].id;
                                tr = ' <tr class="">' +
                                    '<td>' + (i + 1) + '</td>' +
                                    '<td><a style="cursor:pointer"  onclick="setselPermission(\'' + perId + '\')">' + permissionList[i].name + '</a></td>' +
                                    '<td class="am-text-nowrap">' + permissionList[i].url + '</td>' +
                                    '<td class="am-text-nowrap">' + permissionList[i].level + '</td>' +
                                    '<td class="am-text-nowrap">' + permissionList[i].type + '</td>';
                                if (permissionList[i].state && permissionList[i].state == "启用") {
                                    tr = tr + '<td class="am-text-break am-text-success">' + permissionList[i].state + '</td>' +
                                        ' <td class="am-text-nowrap">' + permissionList[i].orderNum + '</td>' +
                                        '<td >' + permissionList[i].description + '</td>' +
                                        '<td><a class="am-btn am-btn-default am-btn-xs am-hide-sm-only am-text-danger" onclick="updateState(\'' + perId + '\',\'1\')"><span class="am-icon-pencil-square-o"></span>禁用</a></td>';
                                } else if (permissionList[i].state && permissionList[i].state == "禁用") {
                                    tr = tr + '<td class="am-text-break am-text-danger">' + permissionList[i].state + '</td>' +
                                        '<td class="am-text-nowrap">' + permissionList[i].orderNum + '</td>' +
                                        '<td >' + permissionList[i].description + '</td>' +
                                        '<td><a class="am-btn am-btn-default am-btn-xs am-hide-sm-only am-text-success" onclick="updateState(\'' + perId + '\',\'0\')"><span class="am-icon-pencil-square-o"></span>启用</a></td>';
                                }
                                tr = tr + '<td><a class="am-btn am-btn-default am-btn-xs am-hide-sm-only am-text-danger" onclick="updateState(\'' + perId + '\',\'3\')"><span class="am-icon-trash-o"></span>删除</a></td></tr>';


                                $tr = $(tr);
                                $("#contents").append($tr);

                            }

                            if (pageNo > 1) {
                                $('#perPage').removeClass('am-disabled');
                            }
                            if (pageNo < tolPgae) {
                                $('#nextPage').removeClass('am-disabled');
                            }


                        }
                        $loading.modal('close');
                    } else {
                        $loading.modal('close');
                        alert(data.msg);
                    }
                }
            },
            error: function () {
                $loading.modal('close');
                alert("系统错误,请联系系统管理员！");
            }
        });
    }

    //每次查询都初始化分页块
    initPage = function () {
        $('#perPage').addClass('am-disabled');
        $('#nextPage').addClass('am-disabled');
        $('#pageNow').removeClass('am-disabled').addClass('am-active');
    }

    //新增修改页面
    $('#detailPage').on('open.modal.amui', function () {
        window.parent.$('#permissionInfo').attr("src", "${contextPath}/sys/permission/permissionInfo?id=" + selPermissonId);
        //  调用完成后清空
        selPermissonId = "";

    })

    //获取点击项的id
    function setselPermission(id) {
        selPermissonId = id;
        //动态生成iframe页面,取消和确定要放在这个函数里面
        var $iframe = AMUI.dialog.iframe({
            iframe: '<iframe id="permissionInfo" width="' + pageWidth * 0.55 + '" height="' + pageHight * 0.55 + '" src="${contextPath}/sys/permission/permissionInfo?id=' + selPermissonId + '" frameborder="0" scrolling="auto"></iframe>',
            pageHight: pageHight * 0.75,
            pageWidth: pageWidth * 0.7
        });
        //取消
        $('#cancel').click(function () {
            $iframe.modal('close');
        });

        $('#save').click(function () {
            //获取iframe参数并校验
            var id = $('#permissionInfo').contents().find("#id").val();
            var name = $('#permissionInfo').contents().find("#name").val();
            var url = $('#permissionInfo').contents().find("#url").val();
            var level = 3;//$('#permissionInfo').contents().find("#level").val();
            var type = $('#permissionInfo').contents().find("#type").val();
            var state = $('#permissionInfo').contents().find("#state").val();
            var parentId = $('#permissionInfo').contents().find("#parentName").val();
            var description = $('#permissionInfo').contents().find("#description").val();
            var orderNum = $('#permissionInfo').contents().find("#orderNum").val();


            var data = {
                "id": id,
                "name": name,
                "url": url,
                "level": level,
                "type": type,
                "state": state,
                "parentId": parentId,
                "description": description,
                "orderNum": orderNum
            };

            $loading.modal('open');
            //保存或新增
            $.ajax({
                type: 'post',
                url: '${contextPath}/sys/permission/save',
                dataType: 'json',
                data: data,
                success: function (response) {

                    if (response.code == 0) {
                        var $alert = util.alert('保存成功系统错误,请联系系统管理员系统错误,请联系系统管理员系统错误,请联系系统管理员！');
                        //自动关闭遮罩层并刷新页面
                        setTimeout(function () {
                                $loading.modal('close');
                                $alert.modal('close');
                                $iframe.modal('close');
                                $('#myTree').tree({dataSource: dataSource});
                                queryList(selectedId, pageNo, pageSize);
                            }
                            , 500);
                    } else {
                        $loading.modal('close');
                        util.alert(response.msg);
                    }
                },
                error: function () {
                    $loading.modal('close');
                    util.alert("系统错误,请联系系统管理员！");
                }
            });
        });
    }

    //状态改变
    updateState = function (id, state) {
        $loading.modal('open');
        $.ajax({
            type: 'post',
            url: '${contextPath}/sys/permission/updateState',
            dataType: 'json',
            data: {"id": id, "state": state},
            success: function (response) {

                if (response.code == 0) {
                    var $alert = util.alert('保存成功!');
                    //自动关闭遮罩层并刷新页面
                    setTimeout(function () {
                            $loading.modal('close');
                            $alert.modal('close');
                            $('#tree').load(location.href + $('#tree'));
                            queryList(selectedId, pageNo, pageSize);
                        }
                        , 500);
                } else {
                    $loading.modal('close');
                    util.alert(response.msg);
                }
            },
            error: function () {
                $loading.modal('close');
                util.alert("系统错误,请联系系统管理员！");
            }
        });
    }
</script>
</body>
</html>
