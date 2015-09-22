 function ajaxFileUpload() {
	 $.ajaxFileUpload({
		 url: '/restaurants/update?res={name:namei; id:2}', //用于文件上传的服务器端请求地址
		 secureuri: false, //是否需要安全协议，一般设置为false
		 fileElementId: 'apkFile',//文件上传域的ID
		 data: {"id":2,"name":"name1","logo":"str1","description":"str2","type":"str3","phone":"str4","email":"str5","openTimeMorning":"str6","openTimeMorning":"str7"},
		 dataType: 'text', //返回值类型 一般设置为json
		 success: function (data, status){  //服务器成功响应处理函数
			 			console.log("Yes!!!!!!");
			 			console.log(data);
                      },
        error: function (data, status, e){
        		  alert(e);}
    })
    return false;
}