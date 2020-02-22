//表格一

    var shishixinwen = document.getElementById('shishixinwen').innerText;
    $.post(
        "HomeNewsDisplay.do",
        {"type": shishixinwen},
        function (data) {
            for (var i = 0; i < data.length; i++) {
                var tr = '<tr>' +
                    '<td>' + data[i].time + '</td>' +
                    '<td>' + data[i].title + '</td>' +
                    '<td  style="white-space:nowrap;overflow:hidden;text-overflow: ellipsis;">' + data[i].content + '</td>' +
                    '</tr>';
                $(".shishixinwen").append(tr);
            }
        }, "json")

    var shehui = document.getElementById('shehui').innerText;
    $.post(
        "HomeNewsDisplay.do",
        {"type": shehui},
        function (data) {
            for (var i = 0; i < data.length; i++) {
                var tr = '<tr>' +
                    '<td>' + data[i].time + '</td>' +
                    '<td>' + data[i].title + '</td>' +
                    '<td style="white-space:nowrap;overflow:hidden;text-overflow: ellipsis;">' + data[i].content + '</td>' +
                    '</tr>';
                $(".shehui").append(tr);
            }
        }, "json")

    var jingji = document.getElementById('jingji').innerText;
    $.post(
        "HomeNewsDisplay.do",
        {"type": jingji},
        function (data) {
            for (var i = 0; i < data.length; i++) {
                var tr = '<tr>' +
                    '<td>' + data[i].time + '</td>' +
                    '<td>' + data[i].title + '</td>' +
                    '<td  style="white-space:nowrap;overflow:hidden;text-overflow: ellipsis;">' + data[i].content + '</td>' +
                    '</tr>';
                $(".jingji").append(tr);
            }
        }, "json")

    var keji = document.getElementById('keji').innerText;
    $.post(
        "HomeNewsDisplay.do",
        {"type": keji},
        function (data) {
            for (var i = 0; i < data.length; i++) {
                var tr = '<tr>' +
                    '<td>' + data[i].time + '</td>' +
                    '<td>' + data[i].title + '</td>' +
                    '<td  style="white-space:nowrap;overflow:hidden;text-overflow: ellipsis;">' + data[i].content + '</td>' +
                    '</tr>';
                $(".keji").append(tr);
            }
        }, "json")

    var gonggao = document.getElementById('gonggao').innerText;
    $.post(
        "HomeNewsDisplay.do",
        {"type": gonggao},
        function (data) {
            for (var i = 0; i < data.length; i++) {
                var tr = '<tr>' +
                    '<td>' + data[i].time + '</td>' +
                    '<td>' + data[i].title + '</td>' +
                    '<td  style="white-space:nowrap;overflow:hidden;text-overflow: ellipsis;">' + data[i].content + '</td>' +
                    '</tr>';
                $(".gonggao").append(tr);
            }
        }, "json")






