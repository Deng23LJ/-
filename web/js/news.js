
    //热点新闻
   var hotNews1 = document.getElementById('hotNews').innerText;
    $.post(
        "hotNews.do",
    {
        "type":hotNews1
    },
        function (data) {
            alert(data)
            for (var i=0;i<data.length;i++) {
                var tr = '<tr>' +
                    '<td>' + data[i].time + '</td>' +
                    '<td>' + data[i].title + '</td>' +
                    '<td>' + data[i].content + '</td>' +
                    '</tr>';
                $(".hotNews").append(tr);
            }},"json");
    //创业资讯
    var businessNews = document.getElementById('businessNews').innerText;
    $.post(
        "businessNews.do",
        {
            "type":businessNews
        },
        function (data) {
            for (var i=0;i<data.length;i++) {
                var tr = '<tr>' +
                    '<td>' + data[i].time + '</td>' +
                    '<td>' + data[i].title + '</td>' +
                    '<td>' + data[i].content + '</td>' +
                    '</tr>';
                $(".businessNews").append(tr);
            }},"json");
    //社会百态
    var socialNews = document.getElementById('socialNews').innerText;
    $.post(
        "socialNews.do",
        {
            "type":socialNews
        },
        function (data) {
            for (var i=0;i<data.length;i++) {
                var tr = '<tr>' +
                    '<td>' + data[i].time + '</td>' +
                    '<td>' + data[i].title + '</td>' +
                    '<td>' + data[i].content + '</td>' +
                    '</tr>';
                $(".socialNews").append(tr);
            }},"json");


