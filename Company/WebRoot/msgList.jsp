<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>	��ҵ�ճ��������ϵͳ-��Ϣ�б�</title>
<body>
<link href="css.css" type="text/css" rel="stylesheet" media="all" />
<link href="css/channel.css" type="text/css" rel="stylesheet" media="all" />
<script src="menu.js" type="text/javascript"></script>
<style type="text/css">
<!--
.STYLE2 {	color: #CCCCCC;
	font-size: 14px;
}
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
<div id="place">��ǰλ�ã�[<a href="index.jsp">��ҳ</a>] - [��Ϣ�б�]</div>
<div id="channelcont">
<div id="channelleft">
<div class="channelinleft">
<div class="channeltit"></div>
<dl>
<c:forEach items="${requestScope.messageList}" var="message">
	<dt>>><a href="GetMessage?messageID=${message.messageID}">${message.messageTitle}</a></dt>
	<dd>
	  <div align="right">������ID��${message.employeeID} 
	  		����ʱ�䣺${message.publishTime}</div>
	</dd>
</c:forEach>
</dl>
<div>
  <div align="center">
	<c:choose>
		<c:when test="${page.hasPrePage}">
			<a href="GetMessageList?currentPage=1">��ҳ</a> | 
	<a href="GetMessageList?currentPage=${page.currentPage -1 }">��һҳ</a>
		</c:when>
		<c:otherwise>
			��ҳ | ��һҳ
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${page.hasNextPage}">
			<a href="GetMessageList?currentPage=${page.currentPage + 1 }">��һҳ</a> | 
	<a href="GetMessageList?currentPage=${page.totalPage }">βҳ</a>
		</c:when>
		<c:otherwise>
			��һҳ | βҳ
		</c:otherwise>
	</c:choose>
	��ǰΪ��${page.currentPage}ҳ,��${page.totalPage}ҳ
  </div>
</div>

</div>
</div>
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