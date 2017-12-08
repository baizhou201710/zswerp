/**
 *
 * @param baizhou
 * @returns {null}
 */


util = function () {
    var temp = this;

    //如： http://localhost:8083/uimcardprj
    //获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
    var curWwwPath = window.document.location.href;
    //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
    var pathName = window.document.location.pathname;
    var pos = curWwwPath.indexOf(pathName);
    //获取主机地址，如： http://localhost:8083
    var localhostPaht = curWwwPath.substring(0, pos);
    //获取带"/"的项目名，如：/uimcardprj
    var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);

    //获取url中的参数
    temp.getUrlParam = function (name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
        var r = window.location.search.substr(1).match(reg);  //匹配目标参数
        if (r != null) return unescape(r[2]);
        return null; //返回参数值
    }

    //时间格式化
    temp.formatDate = function (timeStr) {
        if (timeStr) {
            var time = new Date(timeStr);
            var year = time.getFullYear();
            var month = time.getMonth() + 1;
            var date = time.getDate();
            var hour = time.getHours();
            var minute = time.getMinutes();
            var second = time.getSeconds();
            return year + "/" + month + "/" + date + " " + hour + ":" + minute + ":" + second;
        }

    }
    /**
     * 根据数据字典生成下拉列表
     * $select对象，必选
     * dictCode数据字典，必选
     * vaule当前值，可选
     * defalut默认选中值，可选
     * excludeValue排除的值，可选
     */

    temp.dictSelect = function ($select, dictCode, value, defalut, excludeValue) {
        $.ajax({
            type: 'post',
            url: projectName + '/sys/dict/getDict?code=' + dictCode,
            dataType: 'json',
            success: function (response) {

                if (response.code == 0) {
                    if (response.content) {
                        var dicts = response.content;
                        $options = $();
                        for (var i = 0; i < dicts.length; i++) {
                            if (excludeValue) {
                                if (excludeValue != dicts[i].value) {
                                    if (value) {
                                        if (dicts[i].value == value) {
                                            $options = $options + '<option value="' + dicts[i].value + '" selected>' + dicts[i].name + '</option>';
                                        } else {
                                            $options = $options + '<option value="' + dicts[i].value + '">' + dicts[i].name + '</option>';
                                        }
                                    } else {
                                        if (dicts[i].value == defalut) {
                                            $options = $options + '<option value="' + dicts[i].value + '" selected>' + dicts[i].name + '</option>';
                                        } else {
                                            $options = $options + '<option value="' + dicts[i].value + '">' + dicts[i].name + '</option>';
                                        }
                                    }
                                }

                            } else {
                                if (value) {
                                    if (dicts[i].value == value) {
                                        $options = $options + '<option value="' + dicts[i].value + '" selected>' + dicts[i].name + '</option>';
                                    } else {
                                        $options = $options + '<option value="' + dicts[i].value + '">' + dicts[i].name + '</option>';
                                    }
                                } else {
                                    if (dicts[i].value == defalut) {
                                        $options = $options + '<option value="' + dicts[i].value + '" selected>' + dicts[i].name + '</option>';
                                    } else {
                                        $options = $options + '<option value="' + dicts[i].value + '">' + dicts[i].name + '</option>';
                                    }
                                }
                            }


                        }
                        $select.append($options);
                    }
                } else {
                    alert(response.msg);
                }
            },
            error: function () {
                alert("系统错误,请联系系统管理员！");
            }
        });

    }

    temp.alert = function (msg) {
        $alert = AMUI.dialog.alert({content: msg});
        ;
        return $alert;
    }
}
var util = new util();

