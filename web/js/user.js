$(function () {

    //注册用户名检查
    $("#username").blur(function () {
        var username = $(this).val();
        //异步请求服务器 验证用户名是否被占用
        // param  :  json
        $.post("check.do",
            {
                "username": username
            },
            function(data) {
                if(data.success) {
                    $(".username-check").html("用户名被被占用！")
                } else {
                    $(".username-check").html("用户名有效！")
                }
            }, "json");
    })
    //电话号码的格式
    $("#phone").blur(function () {
        var phone = $(this).val();
        if (!(/^1[3456789]\d{9}$/.test(phone))) {
            $(".phone-check").html("电话号码格式不对！")
        } else {
            $(".phone-check").html("格式正确请继续！")
        }
    })
})