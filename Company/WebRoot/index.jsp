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
<title>��ҵ�ճ��������ϵͳ-��ҳ</title>
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
<div id="topexplain">��ҵ�ճ��������ϵͳ��Ϊ��ҵ�ڲ�ͨ���ṩ����ķ���</div>
<div id="topmenu"><img src="images/banner.jpg" width="970" height="147" /></div>
<div id="bookmunu">
<input type="button" onclick="javascript:window.location='index.jsp';"value="��ҳ"/>
<input type="button" onclick="javascript:window.location='msgList.jsp';" value="��Ϣ�б�"/>
<input type="button" onclick="javascript:window.location='publishNewMsg.jsp';" value="��������Ϣ"/>
<input type="button" onclick="javascript:window.location='statusRecognise.jsp';" value="���ʶ��"/>
<div id="conmenu"></div>

</div>
<div id="indexfirst">
<div id="thenew">
<div class="tit">
  <h1>������Ϣ</h1>
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
  <h1>Ա����Ϣ</h1>
</div>
<div id="employee">
	<c:choose>
		<c:when test="${empty sessionScope.employee}">
			û�н������ʶ�����Ƚ������ʶ��!
		</c:when>
		<c:otherwise>
			<ul>
			  <li>Ա����ţ�${employee.employeeID}</li>
			  <li>Ա��������${employee.employeeName}</li>
			  <li>Ա���Ա�${employee.employeeSex ? "��" : "Ů"}</li>
			  <li>�������ڣ�${employee.employeeBirth }</li>
			  <li>�칫�ҵ绰��${employee.employeePhone }</li>
			  <li>סַ��${employee.employeePlace }</li>
			  <li>������쵼��${employee.lead ? '��' : '��'}</li>
			</ul>
		</c:otherwise>
	</c:choose>
</div>
</div>
</div>
<div id="indexsec"></div>
<div class="copyright"><ul><li></li>
<li>��ҵ�ճ��������ϵͳ &nbsp;&copy;2017-2018</li>
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