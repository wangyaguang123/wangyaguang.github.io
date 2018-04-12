<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@page import="com.wyg.bean.MessageDAO"%>
<%@page import="com.wyg.bean.MessageDAOFactory"%>
<%@page import="com.wyg.bean.Page"%>
<%@page import="com.wyg.bean.PageUtil"%>
<%@page import="com.wyg.bean.Message"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>企业日常事务管理系统-首页</title>
</head>
<body>
<link href="css.css" type="text/css" rel="stylesheet" media="all" />
<script src="menu.js" type="text/javascript"></script>
<style type="text/css">
<!--
.STYLE1 {font-size: 16px}
.STYLE2 {
	color: #CCCCCC;
	font-size: 14px;
}
.STYLE3 {font-size: 14px}
-->
</style>
</head>

<body>
<div id="topexplain">企业日常事务管理系统，为企业内部通信提供最简便的服务！</div>
<div id="topmenu"><img src="images/banner.jpg" width="970" height="147" /></div>
<div id="bookmunu">
<input type="button" onclick="javascript:window.location='index.jsp';"value="首页"/>
<input type="button" onclick="javascript:window.location='msgList.jsp';" value="消息列表"/>
<input type="button" onclick="javascript:window.location='publishNewMsg.jsp';" value="发布新消息"/>
<input type="button" onclick="javascript:window.location='statusRecognise.jsp';" value="身份识别"/>
<div id="conmenu"></div>

</div>
<div id="indexfirst">
<div id="thenew">
<div class="tit">
  <h1>最新消息</h1>
</div>
<div class="STYLE1" id="therecom">
	<%
		MessageDAO messageDAO = MessageDAOFactory.getMessageAOInstance();
		Page pageX = PageUtil.createPage(6, messageDAO.findAllCount(), 1);
		List<Message> messages = messageDAO.findAllMessagee(pageX);
		for(Message message : messages) {
	%>
		<p><a href="GetMessage?messageID=<%=message.getMessageID()%>"><%=message.getMessageTitle()%></a>
		<span class="STYLE2"><%=message.getPublishTime() %></span></p>
 		<p>&nbsp;</p>
	<%	
		}
	 %>
</div>
</div>
<div id="menunav">
<div class="tit">
  <h1>员工信息</h1>
</div>
<div id="employee">
	<c:choose>
		<c:when test="${empty sessionScope.employee}">
			没有进行身份识别，请先进行身份识别!
		</c:when>
		<c:otherwise>
			<ul>
			  <li>员工编号：${employee.employeeID}</li>
			  <li>员工姓名：${employee.employeeName}</li>
			  <li>员工性别：${employee.employeeSex ? "男" : "女"}</li>
			  <li>出生日期：${employee.employeeBirth }</li>
			  <li>办公室电话：${employee.employeePhone }</li>
			  <li>住址：${employee.employeePlace }</li>
			  <li>管理层领导：${employee.lead ? '是' : '否'}</li>
			</ul>
		</c:otherwise>
	</c:choose>
</div>
</div>
</div>
<div id="indexsec"></div>
<div class="copyright"><ul><li></li>
<li>企业日常事务管理系统 &nbsp;&copy;2017-2018</li>
</ul>
</div>
<div class="end"></div>
<script type=text/javascript>
startajaxtabs("jsmenu");
var iTab=GetCookie("nets_jsmenu");
	iTab = iTab ? parseInt(iTab):parseInt(Math.random()*5);
	if(iTab!=0) getElement("jsmenu").getElementsByTagName("h1")[iTab].LoadTab();
	iTab++;
	if(iTab>4) iTab=0;
	SetCookie("nets_jsmenu",iTab,365);
function getElement(aID)
{
  return (document.getElementById) ? document.getElementById(aID)
                                   : document.all[aID];
}
</script>
</body>
</html>