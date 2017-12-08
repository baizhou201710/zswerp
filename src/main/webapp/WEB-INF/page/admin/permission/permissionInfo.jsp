<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>

<meta charset="utf-8"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>权限与资源管理详情页面</title>
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
<script type="text/javascript" src="${contextPath}/resources/model/assets/js/blockUI.js"></script>
<script type="text/javascript" src="${contextPath}/resources/util/util.js"></script>


<!-- Begin page -->

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
                            <label for="name" class="am-u-sm-2 am-form-label am-text-right am-padding-right-0"><label
                                    style="color:red">*&nbsp;&nbsp;</label>资源名称</label>
                            <div class="am-u-sm-4">
                                <input type="hidden" class="am-form-field am-input-sm am-radius" id="id">
                                <input type="text" class="am-form-field am-input-sm am-radius" id="name"
                                       placeholder="请输入名称">
                            </div>

                            <label for="url" class="am-u-sm-2 am-form-label am-text-right am-padding-right-0"><label
                                    style="color:red">*&nbsp;&nbsp;</label>url</label>
                            <div class="am-u-sm-4 ">
                                <input type="text" class="am-form-field am-input-sm am-radius " id="url"
                                       placeholder="请输入url">
                            </div>
                        </div>

                        <div class="am-form-group am-form-group-sm am-margin-left am-margin-right">
                            <label class="am-u-sm-2 am-form-label am-text-right am-padding-right-0"
                                   for="type">类型</label>
                            <div class="am-u-sm-4">
                                <select id="type"
                                        data-am-selected="{btnWidth: '100%', btnSize: 'sm', btnStyle: 'secondary' }">

                                </select>
                                <span class="am-form-caret"></span>
                            </div>


                            <label for="state" class="am-u-sm-2 am-form-label am-text-right am-padding-right-0"><label
                                    style="color:red">*&nbsp;&nbsp;</label>状态</label>
                            <div class="am-u-sm-4">
                                <select id="state"
                                        data-am-selected="{btnWidth: '100%', btnSize: 'sm', btnStyle: 'secondary' }">

                                </select>
                                <span class="am-form-caret"></span>
                            </div>
                        </div>

                        <div class="am-form-group am-form-group-sm am-margin-left am-margin-right">
                            <input type="hidden" id="parentId"/>
                            <input type="hidden" id="level"/>
                            <label for="parentName"
                                   class="am-u-sm-2 am-form-label am-text-right am-padding-right-0">上级</label>
                            <div class="am-u-sm-6 am-u-end">
                                <input type="text" class="am-form-field am-input-sm am-radius" id="parentName"
                                       placeholder="请选择上级">
                            </div>
                        </div>

                        <div class="am-form-group am-form-group-sm am-margin-left am-margin-right">
                            <label for="orderNum"
                                   class="am-u-sm-2 am-form-label am-text-right am-padding-right-0">排序号</label>
                            <div class="am-u-sm-4 am-u-end">
                                <input type="text" class="am-form-field am-input-sm am-radius am-u-sm-4" rows="3"
                                       id="orderNum" placeholder="请输入排序号"/>
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
                        <div id="operation" hidden="hidden">
                            <div class="am-form-group am-form-group-sm am-margin-left am-margin-right">
                                <div i>
                                    <label for="creator"
                                           class="am-u-sm-2 am-form-label am-text-right am-padding-right-0">创建人</label>
                                    <div class="am-u-sm-4 am-u-end">
                                        <input type="text" class="am-form-field am-input-sm am-radius" id="creator"
                                               disabled/>
                                    </div>
                                    <label for="createTime"
                                           class="am-u-sm-2 am-form-label am-text-right am-padding-right-0">创建时间</label>
                                    <div class="am-u-sm-4 am-u-end">
                                        <input type="text" class="am-form-field am-input-sm am-radius" id="createTime"
                                               disabled/>
                                    </div>
                                </div>


                            </div>
                            <div class="am-form-group am-form-group-sm am-margin-left am-margin-right">
                                <div>
                                    <label for="modifier"
                                           class="am-u-sm-2 am-form-label am-text-right am-padding-right-0">修改人</label>
                                    <div class="am-u-sm-4 am-u-end">
                                        <input type="text" class="am-form-field am-input-sm am-radius" id="modifier"
                                               disabled/>
                                    </div>
                                    <label for="modifiedTime"
                                           class="am-u-sm-2 am-form-label am-text-right am-padding-right-0">修改时间</label>
                                    <div class="am-u-sm-4 am-u-end">
                                        <input type="text" class="am-form-field am-input-sm am-radius" id="modifiedTime"
                                               disabled/>
                                    </div>
                                </div>


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


<!-- navbar -->

<%--
--%>
<script>
    var result =${result};
    var id = util.getUrlParam("id");
    var typeStr = "";//类型
    var state = "";//状态
    $(document).ready(function () {
        //初始化
        if (result.code == '0') {

            if (id) {//修改
                $('#operation').show();
                //填充数据
                if (result.content) {
                    data = result.content;
                    $('#id').val(data.id);
                    $('#name').val(data.name);
                    $('#url').val(data.url);
                    typeStr = data.type;
                    state = data.state;
                    $('#level').val(data.level);
                    $('#parentId').val(data.parentId);
                    $('#parentName').val(data.parentId);
                    $('#description').val(data.description);
                    $('#orderNum').val(data.orderNum);
                    $('#creator').val(data.creator);
                    $('#createTime').val(util.formatDate(data.createTime));
                    $('#modifier').val(data.modifier);
                    $('#modifiedTime').val(util.formatDate(data.modifiedTime));
                }

            }

        } else {
            alert(result.msg);
        }

        //类型下拉列表
        util.dictSelect($('#type'), "permission_type", typeStr, null, null);
        //状态下拉列表
        util.dictSelect($('#state'), "state", state, "0", "3");//排除删除状态

    });


</script>

