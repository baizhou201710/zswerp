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
<%--<header class="am-topbar am-with-topbar-fixed-top" >
</header>--%>
<!-- end page -->


<div class="admin">
    <!-- Start right Content here -->
    <div class="content-page">
        <!-- Start content -->
        <div class="content am-margin-top-lg">
            <div class="am-g">

                <!-- col start -->
                <div class="am-u-md-12">
                    <%--<div class="card-box">--%>
                    <%--<h4 class="header-title m-t-0 m-b-30">水平排列</h4>--%>

                    <div id="detailDiv">

                        <form class="am-form am-form-horizontal" id="detailform" >
                            <div class="am-form-group am-form-group-sm am-margin-left am-margin-right">
                                <label for="stock" class="am-u-sm-2 am-form-label am-text-right am-padding-right-0"><label style="color:red">*&nbsp;&nbsp;</label>入库数量</label>
                                <div class="am-u-sm-4">
                                    <input type="hidden" class="am-form-field am-input-sm am-radius" id="goodsId" >
                                    <input type="text" class="am-form-field am-input-sm am-radius" id="stock" placeholder="请输入入库数量">
                                </div>

                                <label for="purchasePrice" class="am-u-sm-2 am-form-label am-text-right am-padding-right-0"><label style="color:red">*&nbsp;&nbsp;</label>进价</label>
                                <div class="am-u-sm-4 ">
                                    <input type="text" class="am-form-field am-input-sm am-radius "  id="purchasePrice" placeholder="请输入进价">
                                </div>
                            </div>

                            <div class="am-form-group am-form-group-sm am-margin-left am-margin-right">
                                <label for="batch" class="am-u-sm-2 am-form-label am-text-right am-padding-right-0"><label style="color:red">*&nbsp;&nbsp;</label>批次号</label>
                                <div class="am-u-sm-4 am-u-end">
                                    <input type="text" class="am-form-field am-input-sm am-radius" id="batch" placeholder="请输入入批次号">
                                </div>
                            </div>

                            <div class="am-form-group am-form-group-sm am-margin-left am-margin-right">
                                <label for="detalidescription" class="am-u-sm-2 am-form-label am-text-right am-padding-right-0">备注</label>
                                <div class="am-u-sm-10 am-u-end">
                                    <textarea class="am-form-field am-input-sm am-radius am-u-sm-4" rows="3" id="detalidescription" placeholder="请输入备注"></textarea>
                                </div>

                            </div>
                        </form>
                    </div>

                    <%--</div>--%>
                </div>

                <!-- col end -->
            </div>
            <!-- row end -->

        </div>
    </div>
    <!-- end right Content here -->
    <!--</div>-->
</div>
</div>
<div class="am-modal am-modal-loading am-modal-no-btn" tabindex="2" id="my-modal-loading" >
    <div class="am-modal-dialog">
        <div class="am-modal-hd">正在载入...</div>
        <div class="am-modal-bd">
            <span class="am-icon-spinner am-icon-spin"></span>
        </div>
    </div>
</div>
<!-- navbar -->
<script type="text/javascript" src="${contextPath}/resources/js/jquery-1.11.1.min.js" ></script>
<script type="text/javascript" src="${contextPath}/resources/model/assets/js/jquery-2.1.0.js" ></script>
<script type="text/javascript" src="${contextPath}/resources/model/assets/js/amazeui.min.js"></script>
<script type="text/javascript" src="${contextPath}/resources/model/assets/js/blockUI.js" ></script>
<script type="text/javascript" src="${contextPath}/resources/util/util.js"></script>
<%--
--%>
<script>
    var goodsId = util.getUrlParam("goodsId");//goodsId
    console.info(goodsId);
    $(document).ready(function () {
        //初始化赋值
        $('#goodsId').val(goodsId);
    });


</script>

</body>

</html>


