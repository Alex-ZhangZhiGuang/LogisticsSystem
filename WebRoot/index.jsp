<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@page import="java.text.SimpleDateFormat"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>�����������ϵϵͳ</title>
<link href="css/css.css" rel="stylesheet" type="text/css"/>
<script src="js/bootNo.js" type="text/javascript"></script>
</head>
<body>
	
<div id="top">
	<div id="top1"><img src="images/top2_wenzi.jpg"/></div><div id="top_1"></div>
</div>

<div class="mini-toolbar" style="padding:2px;border:0; padding-left:26px;" id="time"><span>��ӭ�� ${username }��¼&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;���ڣ�<%=new SimpleDateFormat("yyyy-MM-dd").format(new Date()) %></span>
            <a class="mini-button" iconCls="icon-find" plain="true" target="main" href="service!findOrderEnterWarehouse.action" style="margin-left:370px">�鿴�����Ϣ</a>
			<span class="separator"></span> 
            <a class="mini-button" iconCls="icon-date" plain="true" target="main" href="service!findOrderOkSend.action">�鿴����֪ͨ</a>     
            <span class="separator"></span>             
            <a class="mini-button" iconCls="icon-node" plain="true" target="main" href="service!findOrderOkDeliver.action">�鿴���֪ͨ</a>  
			<span class="separator"></span>  
			<a class="mini-button" iconCls="icon-filter" plain="true" target="main" href="page/updatePwd.jsp">�޸��û�����</a>

			<a class="mini-button" iconCls="icon-filter" plain="true" target="main" href="user!showUpdatepwd.action">�޸��û�����</a>

			<span class="separator"></span>  
			<a class="mini-button" iconCls="icon-cancel" plain="true" href="javascript:if(confirm('��ȷ��Ҫ�˳���ϵͳ����')){window.location.href='login.jsp'}">�˳���¼</a>                
  </div>
<div id="left">
	  <div class="mini-outlookmenu" url="js/menu.txt" onitemselect="onItemSelect"
            idField="id" parentField="pid" textField="text" style="height:99%;width:93%;">
  </div>
</div>
<div id="main">
	<iframe id="mainframe" frameborder="0" name="main" style="width:100%;height:100%;" border="0" scrolling="no" src="welcome.jsp"></iframe>  
</div>
<script type="text/javascript">
		mini.parse();
        //init iframe src
        var iframe = document.getElementById("mainframe");

        function onItemSelect(e) {
            var item = e.item;
            iframe.src = item.url;
        }
    </script>
</body>
</html>
