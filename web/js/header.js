layui.use(['jquery', 'carousel', 'element', 'table'], function () {
    var $ = layui.jquery;
    //用户名展示
    $.post(
        "showUsername.do",
        function (data) {
            if (data.name == null) {
                return
            } else {
                $("#pic").attr("src", data.picture);
                $("#user").html(data.name);
                $("#user").attr("href", 'safetyManagement.html')
                $("#exit").html("退出");
            }
        }, "json")
    //退出功能
    $("#exit").click(function () {
        $.post("exit.do", function (json) {
            layer.msg(json)
            location.reload();
        })
    })
});