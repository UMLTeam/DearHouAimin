function Preview() {
    var file_list = document.getElementsByClassName("ny-right-content").item(0);
    var file_preview = document.getElementsByClassName("ny-right-file").item(0);
    var file_embed = document.getElementsByTagName("embed").item(0);
    if(file_list.style.display == "none"){
    	file_preview.style.display = "none";
    	file_list.style.display = "block";
    }else{
    	file_list.style.display = "none";
    	file_preview.style.display = "block";
    }
    
}
