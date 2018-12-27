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
    document.getElementById("resource").innerHTML="<a href=\"teachResDetail-3.jsp\"><img src=\"../images/teachResource/返回.png\">返回</a>\n" +"<br>"+
        "<b style=\"font-size: 25px;\">"+fileName+"</b>\n" +
        "<div class=\"embed\\\">\n" +
        "<embed src=\""+src+"\" width=\"800\" height=\"800\">\n" +
        "</div>";
}
