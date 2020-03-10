//定义全局变量
var announcement = document.getElementById('announcement').innerText;
var information = document.getElementById('information').innerText;
var business = document.getElementById('business').innerText;
var society = document.getElementById('society').innerText;
//功能实现JS
layui.use(['jquery','carousel','element', 'table'], function () {
    var $ = layui.jquery;
    var carousel = layui.carousel;
    var table = layui.table;
    //用户名展示
    $.post(
        "showUsername.do",
        function (data) {
            if (data == "未登录") {
                return
            }
            $("#user").html(data);
        },
        "text"
    )
    //图片轮播
    carousel.render({
        elem: '#lunbo',
        width: '100%',
        height: '500px',
        interval: 5000
    });
    //新闻展示
    table.render({
        elem: '#socialNotice'
        , limit: 4
        , skin: 'nob'
        , url: 'homeNewsDisplay.do?type=' + announcement //数据接口
        , page: true //开启分页
        , cols: [[ //表头
            {field: 'time', title: '时间', width: 100}
            , {field: 'title', title: '标题', width: 150}
            , {field: 'content', title: '内容',}
            , {fixed: 'right', title: '详情', toolbar: '#detailBar', width: 150, align: 'center'}
        ]]
    });
    //监听工具行事件
    table.on('tool(socialNotice)', function (obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
        if (layEvent === 'detail') {
            var value = obj.data.id;
            window.location.href="newsDetail.html?id="+value;
            return
        }
        { //编辑
            //do something
            layer.msg("修改")
        }
    });
    //热门资讯
    table.render({
        elem: '#popularInformation'
        , limit: 4
        , skin: 'nob'
        , url: 'homeNewsDisplay.do?type=' + information //数据接口
        , page: true //开启分页
        , cols: [[ //表头
            {field: 'time', title: '时间', width: 100, fixed: 'left'}
            , {field: 'title', title: '标题', width: 150}
            , {field: 'content', title: '内容',}
            , {fixed: 'right', title: '详情', toolbar: '#detailBar', width: 150, align: 'center'}
        ]]
    });
    table.on('tool(popularInformation)', function (obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
        if (layEvent === 'detail') {
            var value = obj.data.id;
            window.location.href="newsDetail.html?id="+value;
            return
        }
        { //编辑
            //do something
            layer.msg("修改")
        }
    });
    //创业资讯
    table.render({
        elem: '#businessInformation'
        , limit: 4
        , skin: 'nob'
        , url: 'homeNewsDisplay.do?type=' + business //数据接口
        , page: true //开启分页
        , cols: [[ //表头
            {field: 'time', title: '时间', width: 100, fixed: 'left'}
            , {field: 'title', title: '标题', width: 150}
            , {field: 'content', title: '内容',}
            , {fixed: 'right', title: '详情', toolbar: '#detailBar', width: 150, align: 'center'}
        ]]
    });
    table.on('tool(businessInformation)', function (obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
        if (layEvent === 'detail') {
            var value = obj.data.id;
            window.location.href="newsDetail.html?id="+value;
            return
        }
        { //编辑
            //do something
            layer.msg("修改")
        }
    });
    //社会百态
    table.render({
        elem: '#socialNews'
        , limit: 4
        , skin: 'nob'
        , url: 'homeNewsDisplay.do?type=' + society //数据接口
        , page: true //开启分页
        , cols: [[ //表头
            {field: 'time', title: '时间', width: 100, fixed: 'left'}
            , {field: 'title', title: '标题', width: 150}
            , {field: 'content', title: '内容',}
            , {fixed: 'right', title: '详情', toolbar: '#detailBar', width: 150, align: 'center'}
        ]]
    });
    table.on('tool(socialNews)', function (obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
        if (layEvent === 'detail') {
            var value = obj.data.id;
            window.location.href="newsDetail.html?id="+value;
            return
        }
        { //编辑
            //do something
            layer.msg("修改")
        }
    });
    //===========引入footer和footer=============================
    $(".header").load("header.html");
    $(".footer").load("footer.html");
    //===================end==============================


});
//====jsEnd======================================================

