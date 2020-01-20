
jQuery.prototype.serializeObject=function(){
	var obj=new Object();  
	$.each(this.serializeArray(),function(index,param){  
		if(!(param.name in obj)){  
			obj[param.name]=param.value;  
		}  
	});  
	return obj;  
}; 
function getQueryString(name) { 
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
	var r = window.location.search.substr(1).match(reg); 
	if (r != null) return unescape(r[2]); return null; 
}
function getResources(resources) {

    var urlList ;
    $.ajax({
        url:url+"/system/resources/findResourcesEMUByResources",
        type:'get',
        async:false,
        success:function(data){
            urlList =data.data;
        }
    });
    for(var i=0;i<urlList.length;i++){
        if(null==urlList[i]){
            continue;
        }
        if(resources==urlList[i].url){
            return true
         }
    }
    return false;
}

$.ajaxSetup({
    headers:{//默认添加请求头部
        "Authorization":$.cookie('token')
    },
	complete: function (xhr, status) {
		try{
			if(xhr.responseJSON.result=="index"){
				if(window.parent!=window){
					parent.location.href=htmlURL+"/login.html";
				}else{
					location.href=htmlURL+"/login.html";
				}
				
			}
		}catch (e) {
			// TODO: handle exception
		}
	}
});