<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>��ҵ�ճ��������ϵͳ-���ʶ��</title>
<link href="css.css" type="text/css" rel="stylesheet" media="all" />
<script src="menu.js" type="text/javascript"></script>
</head>

<body>
<div id="topexplain">��ҵ�ճ��������ϵͳ��Ϊ��ҵ�ڲ�ͨ���ṩ����ķ���</div>
<div id="topmenu"><img src="images/banner.jpg" width="970" height="147" /></div>
<div id="bookmunu">
<div class="jsmenu" id="jsmenu">
<input type="button" onclick="javascript:window.location='index.jsp';"value="��ҳ"/>
<input type="button" onclick="javascript:window.location='msgList.jsp';" value="��Ϣ�б�"/>
<input type="button" onclick="javascript:window.location='publishNewMsg.jsp';" value="��������Ϣ"/>
<input type="button" onclick="javascript:window.location='statusRecognise.jsp';" value="���ʶ��"/>
<div id="conmenu"></div>

</div>

<div id="indexfirst">
	<div id="place">��ǰλ�ã�[<a href="index.jsp">��ҳ</a>] - [Ա�����ʶ��]</div>
  <div id="menunav2">
		<div class="tit">
 		 <h1>Ա�����ʶ��</h1>
		</div>
		<div id="shenfenshibie">
			<font color="red">${requestScope.error }</font>
			<form action="StatusRecogniseAction" method="post">
		  	<p>Ա����ţ�<input type="text" name="employeeID" value="${param.employeeID}"/></p>
		  	<p>&nbsp;</p>
		  	<p>ϵͳ���<input type="password" name="password" /></p>
		  	<p>&nbsp;</p>
		  	<p><input type="submit" value="�ύ" />
		    <input type="reset" value="����" /></p>
		    </form>
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

