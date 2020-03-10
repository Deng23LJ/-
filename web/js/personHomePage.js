layui.use(['laydate','upload','jquery','table'], function() {
    var $ = layui.jquery;
    var table = layui.table;
    var laydate = layui.laydate;
    var upload = layui.upload;
    //日期组件
    laydate.render({
        elem: '#test1',
        theme: 'blue'
    });
    //我的办件
    table.render({
        elem:"#banjian",
        url:"findMyAffair.do",
        limit:8,
        page:true,
        cols:[[
            {field:'transactionDate',title:'办理日期'},
            {field:'type',title:'办理项目'},
            {field:'sectionA',title:'A部门'},
            {field:'sectionB',title:'B部门'}
        ]]
    })
    //我的上传材料
    table.render({
        elem:"#uploadfile",
        url:"findMyUploadFile.do",
        page:true,
        limit:8,
        cols:[[
            {field:'u_id',title:'编号'},
            {field:'affair',title:'办理事项'},
            {field:'uploadfilename',title:'文件名'},
            {field:'other',title:'备注'}
        ]]
    })
    //普通图片上传
    var uploadInst = upload.render({
        elem: '#uploadPicture'
        ,url: 'file/upload.do'
        ,accept:'images'
        ,acceptMime:'image/*'
        ,auto:true//是否选择文件之后自动上传
        ,field:'mf' //表单的name值
        ,before: function(obj){
            //预读本地文件示例，不支持ie8
            obj.preview(function(index, file, result){
                $('#demo1').attr('src', result); //图片链接（base64）
            });
        }
        ,done: function(res){
            //如果上传失败
            if(res.code > 0){
                return layer.msg('上传失败');
            }
            //上传成功
            layer.msg("上传成功");
        }
        ,error: function(){
            //演示失败状态，并实现重传
            var demoText = $('#demoText');
            demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
            demoText.find('.demo-reload').on('click', function(){
                uploadInst.upload();
            });
        }
    });

    //个人信息展示
    $.post(
        "updateResume.do",
        function(data) {
            $("#username").val(data.username)
            $("#password").val(data.password)
            $("#sex").val(data.sex)
            $("#age").val(data.age)
            $("#phone").val(data.phone)
            $("#address").val(data.address)
            $("#email").val(data.email)
            $("#grade").val(data.grade)
        }
    )
    //修改资料
    $("#update").click(function() {
        var username = $("#username").val()
        var password = $("#password").val();
        var phone = $("#phone").val();
        var address = $("#address").val();
        var email = $("#email").val()
        if (username == "") {
            alert("请登录！")
            window.location.href = "login.html";
        } else {
            $.post(
                "update.do",
                {
                    "username":username,
                    "password": password,
                    "phone": phone,
                    "address": address,
                    "email": email

                },
                function(data) {
                    if (data == 1) {
                        alert("修改成功")
                        location.reload();
                    } else {
                        alert("修改失败，请重试！")
                        location.reload();
                    }
                }, "json")
        }
    })
    //===========================================
    $(".header").load("header.html");
    $(".footer").load("footer.html");
});