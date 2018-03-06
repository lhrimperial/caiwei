<!doctype html>
<html>
<head>
<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=utf-8">
<META HTTP-EQUIV="CACHE-CONTROL" CONTENT="NO-CACHE">
<#include "common/common.ftl">
<#include "common/head.ftl">
<link href="${styles}/left_tree.css" rel="stylesheet" type="text/css" />
</head>
<script type="text/javascript">
function logout(){
	var successFun = function(json) {
		window.location = '../login/index.action';
	};
	var failureFun = function(json) {
		if (Ext.isEmpty(json)) {
			//Butterfly.showErrorMes('连接超时'); // 请求超时
			document.getElementById("msg").style.display = "block";
			document.getElementById("error").innerText = "连接超时!";
		} else {
			var message = json.message;
			//Butterfly.showErrorMes(message); // 提示失败原因
			document.getElementById("msg").style.display = "block";
			document.getElementById("error").innerText = message+"!";
		}
	};
	wechat.requestJsonAjax('logoutAction!logout.action', null, successFun,
			failureFun);
}
</script>
<body>
	<div id="logoImageDiv" style="width: 200px;"><img  src="${images}/logo.jpg"></div>
	<div id="loginoutDiv" onclick="logout();"><img  src="${images}/quit.jpg"></div>
</body>
</html>
