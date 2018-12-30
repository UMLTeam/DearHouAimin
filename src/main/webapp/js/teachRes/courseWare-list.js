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
    document.getElementById('courseWare').submit();
}