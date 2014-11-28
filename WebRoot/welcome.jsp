<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
	<title>无标题文档</title>
	<link href="css/page.css" rel="stylesheet" type="text/css"/>
	</head>

<body>
<div id="div_top">
	<div id="titleBar">当前位置：<span id="position">欢迎页面</span></div>
</div>
 <div id="div_middle"><div style="margin:90px auto 0px 300px;"><img src="images/wellcom.jpg"/></div></div>
</body>
</html>
