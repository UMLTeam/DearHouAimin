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
        var src="/DearHouAimin/resource/"+fileName;
    }
    else{
        var src="https://view.officeapps.live.com/op/view.aspx?src=http://www.niracler.com/resource/"+fileName;
    }
    document.getElementById("resource").innerHTML="<a href=\"/DearHouAimin/courseWareServlet?type=show&page=1&pageSize=3\"><img src=\"/DearHouAimin/images/teachResource/返回.png\">返回</a>\n" +"<br>"+
        "<b style=\"font-size: 25px;\">"+fileName+"</b>\n" +
        "<div class=\"embed\\\">\n" +
        "<embed src=\""+src+"\" width=\"800\" height=\"800\">\n" +
        "</div>";
}

function getOnePage(type,orderFieldName){
    var url1;
    var page=document.getElementById("page");
    var pageSize=document.getElementById("pageSize");
    var totalPageCount=document.getElementById("totalPageCount");

    var order=document.getElementById("order");
    var orderField=document.getElementById("orderField");

    if(orderFieldName!=""){//切换排序
        orderField.value=orderFieldName;//设置排序字段名
        if(order.value == "asc")//切换排序
            order.value="desc";
        else
            order.value="asc";

        page.value=1;//排序后从第一页开始显示
    }

    pageValue=parseInt(page.value);
    if(type=="first")
        page.value="1";
    else if(type=="pre"){
        pageValue-=1;
        page.value=pageValue.toString();
    }else if(type=="next"){
        pageValue+=1;
        page.value=pageValue.toString();
    }else if(type=="last"){
        page.value=totalPageCount.value;
    }
    //提交
    document.getElementById('myform').submit();
}

function upPage_hover(e) {
    var target=e.target;
    target.setAttribute("src","..\\images\\teachResource\\up_hover.png");
}
function upPage_out(e) {
    var target=e.target;
    target.setAttribute("src","..\\images\\teachResource\\up.png");
}
function downPage_hover(e) {
    var target=e.target;
    target.setAttribute("src","..\\images\\teachResource\\down_hover.png");
}
function downPage_out(e) {
    var target=e.target;
    target.setAttribute("src","..\\images\\teachResource\\down.png");
}