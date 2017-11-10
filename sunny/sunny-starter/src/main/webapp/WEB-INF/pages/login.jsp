<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%--<%@taglib uri="/ext" prefix="ext" %>--%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<META HTTP-EQUIV="CACHE-CONTROL" CONTENT="NO-CACHE">
<%@include file="common.jsp"%>
<%@include file="head.jsp"%>
<%--<ext:module groups="login" subModule="login"/>--%>
	<script type="text/javascript" src="${scripts}/login.js"></script>
<link href="${styles}/login.css" rel="stylesheet" type="text/css" />
<style type="text/css">
	body td input{
		font-family:"微软雅黑";
	}
</style>
<script type="text/javascript">
	if (top.location != self.location){
		top.location = self.location;
	}
	function onkeydown(){ 
		  if(event.keyCode==13) 
		  { 
		    document.getElementById("login_login_input").click(); 
		  } 
		}
	document.onkeypress=onkeydown;  
</script>
</head>
<body>
	<table id="top_table_back" cellpadding=0 cellspacing=0 border=0 >
		<tr>
			<td>&nbsp;</td>
			<td style="height:360px;width:438px;"><div id="top_logo_div_back">&nbsp;</div></td>
			<td>&nbsp;</td>
		</tr>
	</table>
	<table style="width:410px;margin-top:20px;" align=center border="0" cellpadding=0 cellspacing=0>
		<tr>
			<td id="login_form_div" align="align" style="padding-left:15px;">
			</td>
		</tr>
		<tr>
			<td align="align" style="color:#8A8A8A;text-align:left;padding-left:15px;">
				<div id = "msg"><p id="error"></p></div>
			</td>
		</tr>
		<%--<tr>
			<td style="color:#8A8A8A;text-align:left;padding-left:15px;">
				<input type="checkbox" class="login_checkbox">
				<label>记住我的选择</label> 
			</td>
		</tr>--%>
	</table>
	<table style="width:202px;margin-top:15px;" align=center border="0" cellpadding=0 cellspacing=0>
		<tr>
			<td align="left">
				<input type="button" value="登&nbsp;录" id= "login_login_input" class="login_login_input" onclick="login();"/>
			</td>
		</tr>
		<tr>
			<td align="center">
				<div id ="msg"></div>
			</td>
		</tr>
		<%--<tr>
			<td align=left style="color:#8A8A8A;padding-top:5px;">忘记密码？</td>
		</tr>--%>
	</table>
</body>