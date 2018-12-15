var FILE =
[
    "uml实例.docx", "UML建模案例——我的一位朋友结婚了.docx", "UML建模案例——超市进销存管理系统.doc", "UML综合案例.doc"
]

var nowPage = 1;
var totalPage = 1;
var num = 10;

$(function () {
    totalPage = parseInt(FILE.length / num);
    if (totalPage%2!=0 || totalPage == 0) {
        totalPage += 1;
    }
    $("#num").html("共" + totalPage + "页");
    var max = FILE.length;
    var n = max >= 8 ? 8 : max;
    var i;
    var li = $("li.resource");
    for (i = 0; i < n; i++) {
        var li_child = li.get(i);
        li_child.style.display = "block";
        var childs = li_child.childNodes;
        childs[1].setAttribute("href", "../resource/案例资源/" + FILE[i]);
        childs[1].setAttribute("download", FILE[i]);
        childs[1].innerHTML = FILE[i];
    }
    for(;i < 10;i++) {
        var li_child = li.get(i)
        li_child.style.display = "none";
    }
})
