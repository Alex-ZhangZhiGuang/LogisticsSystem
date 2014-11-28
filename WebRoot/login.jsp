<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>登录</title>
<link href="css/css.css" rel="stylesheet" type="text/css">
</head>
<body style="background-image: url(images/login_bj.jpg);">
<div id="login">
   <form name="form1" method="post" action="user!login.action">
	  <div id="login_top1">
		<table width="257" height="80" border="0" style="font-size:14px">
		  <tr>
		    &nbsp;<font color="red">${massger }</font>
		   <font color="red"> ${massger}</font>
			<td width="100" align="right"><span class="STYLE1">用户名：</span></td>
			<td width="150" height="40">
			  <input class="common_input shadow" type="text" name="username" />
			</td>
		  </tr>
		  <tr>
			<td align="right"><span class="STYLE1">密&nbsp;&nbsp;码：</span></td>
			<td width="150" height="33">
			  <input class="common_input shadow" type="password" name="userpwd" />
			</td>
		  </tr>
		</table>
	 </div>
	<div id="login_top2">
		<input name="Submit" type="submit" value="" class="btn_login">
	</div>
  </form>
</div>
</body>
</html>
