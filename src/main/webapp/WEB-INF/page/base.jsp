<%@ page language="java" pageEncoding="UTF-8" %>
<!--遮罩层-->
<div class="am-modal am-modal-loading am-modal-no-btn" tabindex="50" id="myloading">
    <div class="am-modal-dialog">
        <div class="am-modal-hd">正在载入...</div>
        <div class="am-modal-bd">
            <span class="am-icon-spinner am-icon-spin"></span>
        </div>
    </div>
</div>


<!-- alert弹框-->
<div class="am-modal am-modal-alert" tabindex="100" id="my-alert">
    <div class="am-modal-dialog">
        <div class="am-modal-hd " id="msg" id="msg">Amaze UI</div>
        <div class="am-modal-footer">
            <span class="am-modal-btn">确定</span>
        </div>
    </div>
</div>
<!-- 删除确认弹框-->
<div class="am-modal am-modal-confirm" tabindex="75" id="my-confirm">
    <div class="am-modal-dialog">
        <div class="am-modal-hd"> 确定要删除这条记录吗？</div>
        <div class="am-modal-footer">
            <span class="am-modal-btn" data-am-modal-cancel>取消</span>
            <span class="am-modal-btn" data-am-modal-confirm>确定</span>
        </div>
    </div>
</div>
<script>
    //遮罩层
    function maskOn() {
        $('#myloading').modal('open');
    }

    function maskOff() {
        $('#myloading').modal('close');
    }

    //自定义alert弹窗
    myAlert = function (msg) {
        $('#msg').html(msg);
        $('#my-alert').modal('open');
    }
    closeMyAlert = function () {
        $('#my-alert').modal('close');
    }

    /****************************重写confirm弹框确定和取消事begin**********************/
    var $confirm = $('#my-confirm');
    var $confirmBtn = $confirm.find('[data-am-modal-confirm]');
    var $cancelBtn = $confirm.find('[data-am-modal-cancel]');

    //重写confirm弹框确定和取消事件
    $cancelBtn.off('click.cancel.modal.amui').on('click', function () {
        return;
    });
    //重写confirm弹框确定和取消事件
    $confirmBtn.off('click.confirm.modal.amui').on('click', function () {
        //自定义确认事件
        confirmBtn();

    });
</script>