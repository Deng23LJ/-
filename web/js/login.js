//登录
$("#UserLogin").click(function () {
    //获取到用户输入的数据
    var username = $("#username").val();
    var password = $("#password").val();
    //通过post提交方式进行提交
    $.post(
        "login.do",
        {
            "username": username,
            "password": password,
        },
        function (data) {

            if (data == 1) {
                window.location.href = "home.html";
            } else {
                alert("登录失败，请从新登录！")
                window.location.href = "login.html"
            }
        }, "json");
});