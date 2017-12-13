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
                    <form class="am-form am-form-horizontal">
                        <div class="am-form-group am-form-group-sm am-margin-left am-margin-right">
                            <label for="goodsNo" class="am-u-sm-2 am-form-label am-text-right am-padding-right-0">
                                <label style="color:red">* </label>型号</label>
                            <div class="am-u-sm-4">
                                <input type="hidden" class="am-form-field am-input-sm am-radius" id="id">
                                <input type="text" class="am-form-field am-input-sm am-radius" id="goodsNo"
                                       placeholder="请输入型号">
                            </div>
                            <label for="brand" class="am-u-sm-2 am-form-label am-text-right am-padding-right-0">
                                <label style="color:red">* </label>生产商</label>
                            <div class="am-u-sm-4 ">
                                <input type="text" class="am-form-field am-input-sm am-radius " id="brand"
                                       placeholder="请输入生产商">
                            </div>
                        </div>
                        <div class="am-form-group am-form-group-sm am-margin-left am-margin-right">
                            <label for="packageType" class="am-u-sm-2 am-form-label am-text-right am-padding-right-0">
                                <label style="color:red">* </label>封装</label>
                            <div class="am-u-sm-4">
                                <input type="text" class="am-form-field am-input-sm am-radius" id="packageType"
                                       placeholder="请输入封装">
                            </div>
                            <label for="location"
                                   class="am-u-sm-2 am-form-label am-text-right am-padding-right-0">存放位置</label>
                            <div class="am-u-sm-4 ">
                                <input type="text" class="am-form-field am-input-sm am-radius " id="location"
                                       placeholder="请输入存放位置">
                            </div>
                        </div>
                        <div class="am-form-group am-form-group-sm am-margin-left am-margin-right">
                            <div id="tolSotckDiv" hidden="hidden">
                                <label for="tolStock" class="am-u-sm-2 am-form-label am-text-right am-padding-right-0">库存量</label>
                                <div class="am-u-sm-4 am-u-end">
                                    <input type="text" class="am-form-field am-input-sm am-radius" id="tolStock">
                                </div>
                            </div>
                            <label for="salePrice" class="am-u-sm-2 am-form-label am-text-right am-padding-right-0">
                                <label style="color:red">* </label>建议售价</label>
                            <div class="am-u-sm-4 am-u-end">
                                <input type="text" class="am-form-field am-input-sm am-radius" id="salePrice"
                                       placeholder="请输入建议售价">
                            </div>
                        </div>
                        <div class="am-form-group am-form-group-sm am-margin-left am-margin-right">
                            <label for="description"
                                   class="am-u-sm-2 am-form-label am-text-right am-padding-right-0">备注</label>
                            <div class="am-u-sm-10 am-u-end">
                                <textarea class="am-form-field am-input-sm am-radius am-u-sm-4" rows="3"
                                          id="description" placeholder="请输入备注"></textarea>
                            </div>
                        </div>
                    </form>
                    <div id="detailDiv" hidden="hidden">
                        <div class="am-form-group am-form-group-sm am-margin-left am-margin-right am-text-sm">
                            <label class="am-u-sm-2 am-form-label am-text-right am-padding-right-0">是否有入库</label>
                            <label class="am-radio-inline am-margin-left" id="radio1">
                                <input type="radio" name="radio" value="1" data-am-ucheck checked>无</label>
                            <label class="am-radio-inline" id="radio2">
                                <input type="radio" name="radio" value="0" data-am-ucheck>有</label>
                        </div>
                        <form class="am-form am-form-horizontal" id="detailform" hidden="hidden">
                            <div class="am-form-group am-form-group-sm am-margin-left am-margin-right">
                                <label for="stock" class="am-u-sm-2 am-form-label am-text-right am-padding-right-0">
                                    <label style="color:red">* </label>入库数量</label>
                                <div class="am-u-sm-4">
                                    <input type="text" class="am-form-field am-input-sm am-radius" id="stock"
                                           placeholder="请输入入库数量">
                                </div>
                                <label for="purchasePrice"
                                       class="am-u-sm-2 am-form-label am-text-right am-padding-right-0">
                                    <label style="color:red">* </label>进价</label>
                                <div class="am-u-sm-4 ">
                                    <input type="text" class="am-form-field am-input-sm am-radius " id="purchasePrice"
                                           placeholder="请输入进价">
                                </div>
                            </div>
                            <div class="am-form-group am-form-group-sm am-margin-left am-margin-right">
                                <label for="batch" class="am-u-sm-2 am-form-label am-text-right am-padding-right-0">
                                    <label style="color:red">* </label>批次号</label>
                                <div class="am-u-sm-4 am-u-end">
                                    <input type="text" class="am-form-field am-input-sm am-radius" id="batch"
                                           placeholder="请输入入批次号">
                                </div>
                            </div>
                            <div class="am-form-group am-form-group-sm am-margin-left am-margin-right">
                                <label for="detalidescription"
                                       class="am-u-sm-2 am-form-label am-text-right am-padding-right-0">备注</label>
                                <div class="am-u-sm-10 am-u-end">
                                    <textarea class="am-form-field am-input-sm am-radius am-u-sm-4" rows="3"
                                              id="detalidescription" placeholder="请输入备注"></textarea>
                                </div>
                            </div>
                        </form>
                    </div>
                    <%--</div>--%></div>
                <!-- col end -->
            </div>
            <!-- row end -->
        </div>
    </div>
    <!-- end right Content here -->
    <!--</div>-->
</div>
</div>
<div class="am-modal am-modal-loading am-modal-no-btn" tabindex="2" id="my-modal-loading">
    <div class="am-modal-dialog">
        <div class="am-modal-hd">正在载入...</div>
        <div class="am-modal-bd"><span class="am-icon-spinner am-icon-spin"></span>

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
    var id = util.getUrlParam("id"); //goodsId
    var hasDetail = "no"; //是否有入库操作

    var isVaild = true; //参数是否都校验成功
    var errorMsg = ""; //参数校验不过时的错误信息
    $(document).ready(function () {

        //初始化加载数据
        if (id) { //更新
            $.ajax({
                type: 'get',
                url: '${contextPath}/goods/queryGoodsInfo',
                dataType: 'json',
                data: {
                    'id': id
                },
                success: function (response) {

                    if (response.code == 0) {
                        if (response.content) {
                            //数据填充
                            goods = response.content;
                            $('#id').val(goods.id);
                            $('#goodsNo').val(goods.goodsNo);
                            $('#brand').val(goods.brand);
                            $('#packageType').val(goods.packageType);
                            $('#tolStock').val(goods.tolStock);
                            $('#salePrice').val(goods.salePrice);
                            $('#location').val(goods.location);
                            $('#description').val(goods.description);

                            $('#tolSotckDiv').show();
                            $('#detailDiv').hide();

                        }
                    } else {
                        alert(response.msg);
                    }
                },
                error: function () {
                    alert("系统错误,请联系系统管理员！");
                }
            });
        } else { //新增
            $('#tolSotckDiv').hide();
            $('#detailDiv').show();
        }

        //radio按钮
        $('#radio1').click(function () {
            $('#detailform').hide();
            //清除值
            $('#detailform input').val('');
            hasDetail = "no";
        });

        $('#radio2').click(function () {
            $('#detailform').show();
            hasDetail = "yes";
        });
    });

    //校验参数
    $('#goodsNo').keyup(function () {
        //允许数字、字母和特殊字符
        $('#goodsNo').val($('#goodsNo').val().replace(/[^\w\-+'"|.\/]/ig, ''));

    }).change(function () {
        var val = $.trim($('#goodsNo').val());
        if (val.length = 0 || val.length > 30) {
            alert("请输入正确格式！");
            isVaild = false;
            errorMsg = "请输入正确的型号！";
            return;
        }
    });

    getFlag = function () {
        return hasDetail;
    }

    isVaild = function () {
        return isVaild;
    }
    errorMsg = function () {
        return errorMsg;
    }
</script>

</body>

</html>


