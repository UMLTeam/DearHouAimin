/*var FILE =
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
*/
function Preview(e) {
    var clicked=e.target;
    var target=clicked.parentElement.nextElementSibling;
    var fileName=target.getAttribute("download");
    var patternFileExtension = /\.([0-9a-z]+)(?:[\?#]|$)/i;
    var extension=(fileName).match(patternFileExtension);
    //除了pdf的src:../resoure/XXX.pdf
    //pdf使用这个src格式
    //'https://view.officeapps.live.com/op/view.aspx?src=http://storage.xuetangx.com/public_assets/xuetangx/PDF/1.xls'
    if(extension[1]=="pdf"){
        var src="../resource/"+fileName;
    }
    else{
        var src="https://view.officeapps.live.com/op/view.aspx?src=http://www.niracler.com/resource/"+fileName;
    }
    document.getElementById("resource").innerHTML="<a href=\"teachResDetail-4.html\"><img src=\"../images/teachResource/返回.png\">返回</a>\n" +"<br>"+
        "<b style=\"font-size: 25px;\">"+fileName+"</b>\n" +
        "<div class=\"embed\\\">\n" +
        "<embed src=\""+src+"\" width=\"800\" height=\"800\">\n" +
        "</div>";
}

