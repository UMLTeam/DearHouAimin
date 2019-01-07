function changeCss(num) {
    document.getElementsByClassName("article_li page_li page_active")[0].className = "article_li page_li";
    document.getElementById("change" + num).className = "article_li page_li page_active";
}