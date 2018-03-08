<!doctype html>
<html>
<head>
<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=utf-8">
<META HTTP-EQUIV="CACHE-CONTROL" CONTENT="NO-CACHE">
<#include "common/common.ftl">
<#include "common/head.ftl">

	<link href="${styles}/left_tree.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${scripts}/main/main.js"></script>
    <script type="text/javascript" src="${scripts}/main/mainModel.js"></script>
    <script type="text/javascript" src="${scripts}/main/mainView.js"></script>

</head>
<script type="text/javascript">
function logout(){
	var successFun = function(json) {
		window.location = 'login';
	};
	var failureFun = function(json) {
		if (Ext.isEmpty(json)) {
			//Caiwei.showErrorMes('连接超时'); // 请求超时
			document.getElementById("msg").style.display = "block";
			document.getElementById("error").innerText = "连接超时!";
		} else {
			var message = json.respMsg;
			//Caiwei.showErrorMes(message); // 提示失败原因
			document.getElementById("msg").style.display = "block";
			document.getElementById("error").innerText = message+"!";
		}
	};
    Caiwei.requestJsonAjax('logout', null, successFun,
			failureFun);
}
</script>
<body>
	<div id="logoImageDiv" style="width: 200px;"><img  src="${images}/logo.jpg"></div>
	<div id="loginoutDiv" onclick="logout();"><img  src="${images}/quit.jpg"></div>
</body>
</html>
