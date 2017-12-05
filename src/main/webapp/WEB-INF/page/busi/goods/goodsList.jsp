<%--
  Created by IntelliJ IDEA.
  User: baizhou
  Date: 2017/11/20
  Time: 10:43
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>后台模板</title>
    <link rel="stylesheet" href="${contextPath}/resources/model/assets/css/amazeui.css" />
    <link rel="stylesheet" href="${contextPath}/resources/model/assets/css/font-awesome.min.css">
    <link rel="stylesheet" href="${contextPath}/resources/model/assets/css/core.css" />
    <link rel="stylesheet" href="${contextPath}/resources/model/assets/css/menu.css" />
    <link rel="stylesheet" href="${contextPath}/resources/model/assets/css/index.css" />
    <link rel="stylesheet" href="${contextPath}/resources/model/assets/css/admin.css" />
    <link rel="stylesheet" href="${contextPath}/resources/model/assets/css/page/typography.css" />
    <link rel="stylesheet" href="${contextPath}/resources/model/assets/css/page/form.css" />
</head>
<body>
<!-- Begin page -->
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
                    <img src="${contextPath}/resources/model/assets/img/avatar-1.jpg" alt="user-img" title="Mat Helme" class="img-circle img-thumbnail img-responsive">
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
                        <li><a href="/goods/index">完整表格</a></li>
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
        <div class="content">
            <%-- <div class="card-box">--%>
            <!-- Row start -->
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
            <!-- Row end -->

            <!-- Row start -->
            <div class="am-g">
                <div class="am-u-sm-12">
                    <form class="am-form">
                        <table class="am-table am-table-striped am-table-hover table-main am-table-compact ">
                            <thead>
                            <tr class="">
                                <th class="table-check am-text-nowrap"></th>
                                <th class="table-id am-text-nowrap">ID</th>
                                <th class="table-title am-text-nowrap">型号</th>
                                <th class="table-title am-text-nowrap">生产商</th>
                                <th class="table-title am-text-nowrap ">封装</th>
                                <th class="table-title am-text-nowrap">库存量</th>
                                <th class="table-title am-text-nowrap">型号批次</th>
                                <th class="table-title am-text-nowrap">建议售价</th>
                                <th class="table-title am-text-nowrap">位置&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                                <th class="table-title am-text-nowrap">备注&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                                <th class="table-set" colspan="4">操作</th>
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
            <!-- Row end -->
        </div>
        <%-- </div>--%>
    </div>
</div>
<!-- end right Content here -->
<!--</div>-->
</div>
</div>

<!--新增修改页面-->
<div class="am-modal am-modal-no-btn" tabindex="13" id="doc-modal-1">
    <div class="am-modal-dialog" style="display: inline-block; width: auto;">
        <div class="am-modal-hd"><label class="am-text-primary am-text-sm">基本信息</label>
            <a href="javascript: void(0)" class="am-close am-close-alt am-close-spin" data-am-modal-close>&times;</a>
        </div>
        <div class="am-modal-bd">
            <iframe id="goodsInfo" width="700" height="400" frameborder="0" scrolling="auto"></iframe>
        </div>
        <div class="am-u-sm-5 am-u-md-3  am-fr" style="padding-top: 20px">
            <div class="am-input-group ">
                <button id="cancel" class="am-btn am-btn-default" type="button">取消</button>
                <button id="save" class="am-btn am-btn-default am-btn-primary" type="button" >确认</button>
            </div>
        </div>
    </div>
</div>

<!--新批次入库页面-->
<div class="am-modal am-modal-no-btn" tabindex="10" id="doc-modal-2">
    <div class="am-modal-dialog" style="display: inline-block; width: auto;">
        <div class="am-modal-hd"><label class="am-text-primary am-text-sm">入库信息</label>
            <a href="javascript: void(0)" class="am-close am-close-alt am-close-spin" data-am-modal-close>&times;</a>
        </div>
        <div class="am-modal-bd">
            <iframe id="inStockInfo" width="700" height="300" frameborder="0" scrolling="auto"></iframe>
        </div>
        <div class="am-u-sm-5 am-u-md-3  am-fr" style="padding-top: 20px">
            <div class="am-input-group ">
                <button id="cancelIn" class="am-btn am-btn-default" type="button">取消</button>
                <button id="saveIn" class="am-btn am-btn-default am-btn-primary" type="button" >确认</button>
            </div>
        </div>
    </div>
</div>

<!--出库页面-->

<div class="am-modal am-modal-prompt" tabindex="10" id="doc-modal-3">
    <div class="am-modal-dialog">
        <div class="am-modal-hd"><label class="am-text-primary am-text-sm">出库</label>
            <a href="javascript: void(0)" class="am-close am-close-alt am-close-spin" data-am-modal-close>&times;</a>
        </div>
        <div class="am-modal-bd">
            <input type="text" class="am-modal-prompt-input">
        </div>
        <div class="am-modal-footer">
            <span class="am-modal-btn" data-am-modal-cancel>取消</span>
            <span class="am-modal-btn" data-am-modal-confirm>提交</span>
        </div>
    </div>
</div>

<!--校正页面-->
<div class="am-modal am-modal-prompt" tabindex="10" id="doc-modal-4">
    <div class="am-modal-dialog">
        <div class="am-modal-hd"><label class="am-text-primary am-text-sm">库存校验</label>
            <a href="javascript: void(0)" class="am-close am-close-alt am-close-spin" data-am-modal-close>&times;</a>
        </div>
        <div class="am-modal-bd">
            <input type="text" class="am-modal-prompt-input">
        </div>
        <div class="am-modal-footer">
            <span class="am-modal-btn" data-am-modal-cancel>取消</span>
            <span class="am-modal-btn" data-am-modal-confirm>提交</span>
        </div>
    </div>
</div>

<!--遮罩层-->
<div class="am-modal am-modal-loading am-modal-no-btn" tabindex="2" id="my-modal-loading" >
    <div class="am-modal-dialog">
        <div class="am-modal-hd">正在载入...</div>
        <div class="am-modal-bd">
            <span class="am-icon-spinner am-icon-spin"></span>
        </div>
    </div>
</div>


<!-- alert弹框-->
<div class="am-modal am-modal-alert" tabindex="1" id="my-alert">
    <div class="am-modal-dialog">
        <div class="am-modal-hd" id="msg" id="msg">Amaze UI</div>
        <div class="am-modal-footer">
            <span class="am-modal-btn">确定</span>
        </div>
    </div>
</div>
<!-- 删除确认弹框-->
<div class="am-modal am-modal-confirm" tabindex="-1" id="my-confirm">
    <div class="am-modal-dialog">
        <div class="am-modal-hd"> 确定要删除这条记录吗？</div>
        <div class="am-modal-footer">
            <span class="am-modal-btn" data-am-modal-cancel>取消</span>
            <span class="am-modal-btn" data-am-modal-confirm>确定</span>
        </div>
    </div>
</div>

<!-- navbar -->
<a href="admin-offcanvas" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}"><!--<i class="fa fa-bars" aria-hidden="true"></i>--></a>

<script type="text/javascript" src="${contextPath}/resources/js/jquery-1.11.1.min.js" ></script>
<script type="text/javascript" src="${contextPath}/resources/model/assets/js/jquery-2.1.0.js" ></script>
<script type="text/javascript" src="${contextPath}/resources/model/assets/js/app.js" ></script>
<script type="text/javascript" src="${contextPath}/resources/model/assets/js/amazeui.min.js"></script>
<script type="text/javascript" src="${contextPath}/resources/model/assets/js/blockUI.js" ></script>
<script>
    var pageSize=10;//默认每页10条数据
    var pageNo=1;//当前页码，默认第一页
    var tolPgae=1;//总页数，默认一页
    var selGoodsId="";//被点击的goods
    $(document).ready(function(){
        //初始化查询
        queryGoodsList(pageNo,pageSize);

        //查询按钮
        $("#searchBtn").click(function(){
            pageSize=10;
            pageNo=1;
            $('#pagelink1').html(1);
            $('#pagelink2').html(2);
            $('#pagelink3').html(3);
            $('#pagelink4').html(4);
            $('#pagelink5').html(5);
            initPage();
            queryGoodsList(pageNo,pageSize);
        });



        //分页，上一页
        $("#perPage").click(function(){
            if($(this).hasClass('am-disabled')){
                return;
            }
            if(pageNo<=1){
                return;
            }
            pageNo=pageNo-1;
            initPage();
            queryGoodsList(pageNo,pageSize);
        });

        //分页，下一页
        $("#nextPage").click(function(){
            if($(this).hasClass('am-disabled')){
                return;
            }
            var tolPage=parseInt($("#tolPage").html());
            if(pageNo>=tolPage){
                return;
            }
            pageNo=pageNo+1;
            initPage();
            queryGoodsList(pageNo,pageSize);
        });

        //page1
        $('#page1').click(function(){
            if($(this).hasClass('am-disabled')){
                return;
            }
            initPage();
            pageNo=parseInt($('#pagelink1').html());
            queryGoodsList(pageNo,pageSize);
        });


        //page2
        $('#page2').click(function(){
            if($(this).hasClass('am-disabled')){
                return;
            }
            initPage();
            pageNo=parseInt($('#pagelink2').html());
            queryGoodsList(pageNo,pageSize);
        });


        //page3
        $('#page3').click(function(){
            if($(this).hasClass('am-disabled')){
                return;
            }
            initPage();
            pageNo=parseInt($('#pagelink3').html());
            queryGoodsList(pageNo,pageSize);
        });


        //page4
        $('#page4').click(function(){
            if($(this).hasClass('am-disabled')){
                return;
            }
            initPage();
            pageNo=parseInt($('#pagelink4').html());
            queryGoodsList(pageNo,pageSize);
        });


        //page5
        $('#page5').click(function(){
            if($(this).hasClass('am-disabled')){
                return;
            }
            initPage();
            pageNo=parseInt($('#pagelink5').html());
            queryGoodsList(pageNo,pageSize);
        });


    });


    //查询
    queryGoodsList=function(pageNo,pageSize) {
        $('#my-modal-loading').modal('open');//添加遮罩层
        //构造查询参数
        var key = $.trim($("#searchParams").val());
        $.ajax({
            type: "post",
            dataType: "json",
            url: '${contextPath}/goods/list',
            data: {"key": key, "pageNo": pageNo, "pageSize": pageSize},
            success: function (data) {
                //成功执行，显示列表
                if (data) {
                    if (data.code == 0) {
                        //清除原有数据列表
                        $("#tolRecord").html(data.content.page.tolRecord);
                        $("#tolPage").html(data.content.page.tolPage);
                        tolPgae=data.content.page.tolPage;
                        $("#contents").empty();
                        if (data.content && data.content.goodsList) {
                            var goodsList = data.content.goodsList;

                            for (var i = 0; i < goodsList.length; i++) {
                                var goodId = goodsList[i].id;
                                tr = ' <tr class=""><td><i class="fa fa-plus-square" style="cursor:pointer" aria-hidden="true" id="i' + goodId + '" onclick="showDetail(\'' + goodId + '\')"></td>' +
                                    '<td>' + (i + 1) + '</td>' +
                                    '<td><a style="cursor:pointer" data-am-modal="{target: \'#doc-modal-1 \', closeViaDimmer: 0, width: 800, height: 540}"  onclick="setSelgoods(\'' + goodId + '\')">' + goodsList[i].goodsNo + '</a></td>' +
                                    '<td class="am-text-nowrap">' + goodsList[i].brand + '</td>' +
                                    '<td class="am-text-nowrap">' + goodsList[i].packageType + '</td>' +
                                    '<td class="am-text-nowrap">' + goodsList[i].tolStock + '</td>' +
                                    '<td class="am-text-break">' + goodsList[i].batches + '</td>' +
                                    '<td class="am-text-nowrap">' + goodsList[i].salePrice + '</td>' +
                                    '<td >' + goodsList[i].location + '</td>' +
                                    '<td >' + goodsList[i].description + '</td>' +
                                    '<td><a class="am-btn am-btn-default am-btn-xs am-text-secondary" data-am-modal="{target: \'#doc-modal-1\', closeViaDimmer: 0, width: 800, height: 540}" onclick="setSelgoods(\'' + goodId + '\')"><span class="am-icon-pencil-square-o"></span> 编辑</a></td>'+
                                    '<td><a class="am-btn am-btn-default am-btn-xs am-hide-sm-only" data-am-modal="{target: \'#doc-modal-2\', closeViaDimmer: 0, width: 800, height: 460}" onclick="setSelgoods(\'' + goodId + '\')"><span class="am-icon-copy"></span> 入库</a></td>';
                                    if( goodsList[i].tolStock>0 && goodsList[i].goodsDetails && goodsList[i].goodsDetails.length==1){
                                        tr=tr+'<td><a class="am-btn am-btn-default am-btn-xs am-hide-sm-only"  onclick="outStock(\'' + goodsList[i].goodsDetails[0].id + '\')"><span class="am-icon-copy"></span> 出库</a></td>'+
                                            '<td><a class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only" onclick="delGoods(\'' + goodId + '\')"><span class="am-icon-trash-o"></span> 删除</a></td></tr>';
                                    }else{
                                        tr=tr+'<td><a class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only" onclick="delGoods(\'' + goodId + '\')"><span class="am-icon-trash-o"></span> 删除</a></td><td></td></tr>';
                                    }

                                   $tr=$(tr);
                                $("#contents").append($tr);
                                //有型号详情
                                if (goodsList[i].goodsDetails) {
                                    var details = goodsList[i].goodsDetails;
                                    $head = $('<tr class="am-primary ' + goodId +'"  hidden="hidden"><td rowspan=' + (details.length + 1) + ' colspan="3" style="vertical-align:middle;text-align:center;">各批次库存详情</td>' +
                                        '<td class="am-hide-sm-only" colspan="2">入库批次</td>' +
                                        '<td class="am-hide-sm-only">库存量</td>' +
                                        '<td class="am-hide-sm-only">型号批次</td>' +
                                        '<td class="am-hide-sm-only">进价</td>' +
                                        '<td class="am-hide-sm-only" colspan="2">备注</td>' +
                                        '<td class="am-hide-sm-only" colspan="4" >操作</td></tr>');
                                    $("#contents").append($head);
                                    for (var j = 0; j < details.length; j++) {
                                        $detail = $(' <tr class="am-primary  am-table-striped ' + goodId +'" hidden="hidden">' +
                                            '<td class="am-hide-sm-only am-active" colspan="2">' + details[j].inStorageBatch + '</td>' +
                                            '<td class="am-hide-sm-only">' + details[j].stock + '</td>' +
                                            '<td class="am-hide-sm-only">' + details[j].batch + '</td>' +
                                            '<td class="am-hide-sm-only">' + details[j].purchasePrice + '</td>' +
                                            '<td class="am-hide-sm-only" colspan="2">' + details[j].description + '</td>' +
                                            '<!--<td><button class="am-btn am-btn-default am-btn-xs am-text-secondary" data-am-modal="{target: \'#doc-modal-1\', closeViaDimmer: 0, width: 800, height: 540}" onclick="setSelgoods(\'-->' + details[j] + '\')"><span class="am-icon-pencil-square-o"></span> 入库</button></td>' +
                                            '<td ><a  class="am-btn am-btn-default am-btn-xs am-hide-sm-only"  onclick="outStock(\'' + details[j].id + '\')"><span class="am-icon-copy"></span> 出库</a></td>' +
                                            '<td><a class="am-btn am-btn-default am-btn-xs am-hide-sm-only"  onclick="adjustStock(\'' + details[j].id + '\')"><span class="am-icon-copy"></span> 校正</a></td>'+
                                            '<td colspan="2"><a class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only" onclick="delGoodsDetail(\'' + details[j].id + '\')"><span class="am-icon-trash-o"></span> 删除</a></td></tr>');

                                        $("#contents").append($detail);
                                    }
                                }

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

                        $('#my-modal-loading').modal('close');
                    } else {
                        $('#my-modal-loading').modal('close');
                        alert(data.msg);
                    }
                    $('#my-modal-loading').modal('close');
                }
                $('#my-modal-loading').modal('close');
            },
            error : function() {myAlert("系统错误,请联系系统管理员！");}
        });
    }



    //展开收起详情
    showDetail=function (i) {
        var iStr="#i"+i;
        var selStr="."+i;
        if($(iStr).hasClass('fa-plus-square')){//展开
            $(iStr).removeClass('fa-plus-square').addClass('fa-minus-square');
            //查询详情
            $(selStr).show();
        }else{//收起
            $(iStr).removeClass('fa-minus-square').addClass('fa-plus-square');
            $(selStr).hide();
        }
    }

    //每次查询都初始化分页块
    initPage=function () {
        $('#perPage').addClass('am-disabled');
        $('#nextPage').removeClass('am-disabled');
        $('#page1').removeClass('am-disabled').addClass('am-active');
        $('#page2').removeClass('am-disabled').removeClass('am-active');
        $('#page3').removeClass('am-disabled').removeClass('am-active');
        $('#page4').removeClass('am-disabled').removeClass('am-active');
        $('#page5').removeClass('am-disabled').removeClass('am-active');
    }

    //iframe取消按钮关闭iframe窗口
    $('#cancel').click(function(){
        $('#doc-modal-1').modal('close');
    });

    //绑定新增修改遮罩层open事件
    $('#doc-modal-1').on('open.modal.amui', function(){
        debugger
        window.parent.$('#goodsInfo').attr("src", "${contextPath}/goods/goodsInfo?id="+selGoodsId);
        //  调用完成后清空
        selGoodsId="";

    })

    //绑定入库页面遮罩层open事件
    $('#doc-modal-2').on('open.modal.amui', function(){
        if(selGoodsId){
            debugger
            window.parent.$('#inStockInfo').attr("src", "${contextPath}/goods/inStockInfo?goodsId="+selGoodsId);
            //  调用完成后清空
            selGoodsId="";
        }

    })

    //点击型号获取详细信息
    setSelgoods=function(goodsId){
        selGoodsId=goodsId;
    }



    //遮罩层确定按钮
    $('#save').click(function(){
        //获取iframe参数并校验
        debugger
        var id=$('#goodsInfo').contents().find("#id").val();
        var goodsNo=$('#goodsInfo').contents().find("#goodsNo").val();
        var brand=$('#goodsInfo').contents().find("#brand").val();
        var packageType=$('#goodsInfo').contents().find("#packageType").val();
        var salePrice=$('#goodsInfo').contents().find("#salePrice").val();
        var location=$('#goodsInfo').contents().find("#location").val();
        var description=$('#goodsInfo').contents().find("#description").val();

        var hasDetail=$("#goodsInfo")[0].contentWindow.getFlag();
        var stock=$('#goodsInfo').contents().find("#stock").val();
        var batch=$('#goodsInfo').contents().find("#batch").val();
        var purchasePrice=$('#goodsInfo').contents().find("#purchasePrice").val();
        var detailDescription=$('#goodsInfo').contents().find("#detailDescription").val();
        var data ={ "id":id,
            "goodsNo":goodsNo,
            "brand":brand,
            "packageType":packageType,
            "salePrice":salePrice,
            "location":location,
            "description":description
        };
        if(id==""||id==null){//新增
            if(hasDetail=="yes"&&stock){
                data.batch=batch;
                data.stock=stock;
                data.purchasePrice=purchasePrice;
                data.detailDescription=detailDescription;
                data.inStock="0";
            }
        }
        $('#my-modal-loading').modal('open');
        //保存或新增
        $.ajax({
            type:'post',
            url:'${contextPath}/goods/save',
            dataType:'json',
            data:data,
            success:function(response) {

                if(response.code==0){
                    //$('#my-modal-loading').modal('hide');
                    //关闭遮罩层
                    myAlert("保存成功！");
                    //一秒后自动关闭弹窗并跳转至list页面
                    var interval = setInterval(closealert,600);
                    function closealert(){

                        $('#my-alert').modal('close');
                        $('#doc-modal-1').modal('close');
                        //刷新页面
                        queryGoodsList(pageNo,pageSize);
                        clearTimeout(interval);
                    }



                }else{
                    $('#my-modal-loading').modal('close');
                    myAlert(response.msg);
                }
            },
            error : function() { myAlert("系统错误,请联系系统管理员！");}
        });



    });

    //自定义alert弹窗
    myAlert=function(msg){
        $('#msg').html(msg);
        $('#my-alert').modal('open');
    }

    //删除记录
    delGoods=function(id){
        if(!id){
            return;
        }
        var $confirm = $('#my-confirm');
        var $confirmBtn = $confirm.find('[data-am-modal-confirm]');
        var $cancelBtn = $confirm.find('[data-am-modal-cancel]');

        //重写confirm弹框确定和取消事件
        $cancelBtn.off('click.cancel.modal.amui').on('click', function() {
            return;
        });
        //重写confirm弹框确定和取消事件
        $confirmBtn.off('click.confirm.modal.amui').on('click', function() {
            $.ajax({
                type:'get',
                url:'${contextPath}/goods/del',
                dataType:'json',
                data:{"id":id},
                success:function(response) {

                    if(response.code==0){
                        myAlert("删除成功！");
                        //一秒后自动关闭弹窗并跳转至list页面
                        var interval = setInterval(closealert,600);
                        function closealert(){

                            $('#my-alert').modal('close');
                            //刷新页面
                            queryGoodsList(pageNo,pageSize);
                            clearTimeout(interval);
                        }



                    }else{
                        myAlert(response.msg);
                    }
                },
                error : function() { myAlert("系统错误,请联系系统管理员！");}
            });

        });

        //触发弹窗事件
        $('#my-confirm').modal('open');
    }




    /**
     * 入库页面
     */
    //取消
    $('#cancelIn').click(function () {
        $('#doc-modal-2').modal('close');
    });

    //入库确认
    $('#saveIn').click(function () {
        debugger
        var goodsId=$('#inStockInfo').contents().find("#goodsId").val();
        var stock=$('#inStockInfo').contents().find("#stock").val();
        var batch=$('#inStockInfo').contents().find("#batch").val();
        var purchasePrice=$('#inStockInfo').contents().find("#purchasePrice").val();
        var description=$('#inStockInfo').contents().find("#detalidescription").val();
        var data ={ "goodsId":goodsId,
            "stock":stock,
            "batch":batch,
            "purchasePrice":purchasePrice,
            "description":description
        };

        //保存或新增
        $.ajax({
            type:'post',
            url:'${contextPath}/goods/inStock',
            dataType:'json',
            data:data,
            success:function(response) {

                if(response.code==0){
                    //关闭遮罩层
                    myAlert("保存成功！");
                    //一秒后自动关闭弹窗并跳转至list页面
                    var interval = setInterval(closealert,600);
                    function closealert(){

                        $('#my-alert').modal('close');
                        $('#doc-modal-2').modal('close');
                        //刷新页面
                        queryGoodsList(pageNo,pageSize);
                        clearTimeout(interval);
                    }



                }else{
                    //$('#my-modal-loading').modal('close');
                    myAlert(response.msg);
                }
            },
            error : function() { myAlert("系统错误,请联系系统管理员！");}
        });
    });
    
    //出库
    outStock=function (id) {
        $('#doc-modal-3').modal({
            relatedTarget: this,
            onConfirm: function(e) {
                debugger
                var stock=e.data;
                //保存或新增
                $.ajax({
                    type:'post',
                    url:'${contextPath}/goods/outStock',
                    dataType:'json',
                    data:{"id":id,"stock":stock,"type":"1"},
                    success:function(response) {

                        if(response.code==0){
                            //关闭遮罩层
                            myAlert("出库成功！");
                            //一秒后自动关闭弹窗并跳转至list页面
                            var interval = setInterval(closealert,600);
                            function closealert(){

                                $('#my-alert').modal('close');
                                //$('#doc-modal-2').modal('close');
                                //刷新页面
                                queryGoodsList(pageNo,pageSize);
                                clearTimeout(interval);
                            }



                        }else{
                            myAlert(response.msg);
                        }
                    },
                    error : function() { myAlert("系统错误,请联系系统管理员！");}
                });
            },
            onCancel: function(e) {

            }
        });
    }
    //库存校验
    adjustStock=function (id) {
        $('#doc-modal-4').modal({
            relatedTarget: this,
            onConfirm: function(e) {
                debugger
                var stock=e.data;
                //保存或新增
                $.ajax({
                    type:'post',
                    url:'${contextPath}/goods/outStock',
                    dataType:'json',
                    data:{"id":id,"stock":stock,"type":"2"},
                    success:function(response) {

                        if(response.code==0){
                            //关闭遮罩层
                            myAlert("校正成功！");
                            //一秒后自动关闭弹窗并跳转至list页面
                            var interval = setInterval(closealert,600);
                            function closealert(){

                                $('#my-alert').modal('close');
                                //$('#doc-modal-2').modal('close');
                                //刷新页面
                                queryGoodsList(pageNo,pageSize);
                                clearTimeout(interval);
                            }



                        }else{
                            myAlert(response.msg);
                        }
                    },
                    error : function() { myAlert("系统错误,请联系系统管理员！");}
                });
            },
            onCancel: function(e) {

            }
        });
    }

    //删除摸个批次
    delGoodsDetail=function (id) {
        if(!id){
            return;
        }
        var $confirm = $('#my-confirm');
        var $confirmBtn = $confirm.find('[data-am-modal-confirm]');
        var $cancelBtn = $confirm.find('[data-am-modal-cancel]');

        //重写confirm弹框确定和取消事件
        $cancelBtn.off('click.cancel.modal.amui').on('click', function() {
            return;
        });
        //重写confirm弹框确定和取消事件
        $confirmBtn.off('click.confirm.modal.amui').on('click', function() {
            $.ajax({
                type:'get',
                url:'${contextPath}/goods/delDetail',
                dataType:'json',
                data:{"id":id},
                success:function(response) {

                    if(response.code==0){
                        myAlert("删除成功！");
                        //一秒后自动关闭弹窗并跳转至list页面
                        var interval = setInterval(closealert,600);
                        function closealert(){

                            $('#my-alert').modal('close');
                            //刷新页面
                            queryGoodsList(pageNo,pageSize);
                            clearTimeout(interval);
                        }



                    }else{
                        myAlert(response.msg);
                    }
                },
                error : function() { myAlert("系统错误,请联系系统管理员！");}
            });

        });

        //触发弹窗事件
        $('#my-confirm').modal('open');
    }

</script>


</body>
</html>
