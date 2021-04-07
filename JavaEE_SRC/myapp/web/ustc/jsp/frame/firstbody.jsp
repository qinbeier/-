<%@ page contentType="text/html; charset=UTF-8" %>
<SCRIPT language="javascript">
  function checkname(){
	  if (document.form1.userName.value.length == 0) {
			alert("请输入您的用户名.");
			document.form1.userName.focus();
		}else if((document.form1.userName.value.length) <5 || (document.form1.userName.value.length) >20){
			window.alert("用户名长度不合适，应在5-20位之间");
			document.form1.userName.focus();
		}else if((document.form1.passWord.value.length) == 0 || (document.form1.passWord.value.length) <6){
			window.alert("密码不能为空,并至少是六位！");
		}else{
			form1.submit();
		}
	}
</script>
<%
String loginError =(String)request.getAttribute("loginError");
String errorMsg="";
request.setAttribute("loginError", "0");
if("1".equals(loginError)){
//用户输入了错误的UserName或Password
errorMsg = "用户名或密码输入有误，请检查确认后，再重新登录！注意字符大小写要正确！！";
}
%>
<table width="778" border="0" align="center" cellspacing="0" cellpadding="0" style="border-left:1px solid #cccccc;border-right:1px solid #cccccc" >

<!-- login页面-->
<%if(!"1".equals(isCorrectUserTicket)){%>

<FORM name=form1 action="<%=request.getContextPath()%>/login.do" method="POST">
 <input type="hidden" name="rnd" value="<%=Math.random()%>">
<BODY>
<DIV id=main_login>
<UL>
<%if("1".equals(loginError)){%>
	<LI id=list>&nbsp;&nbsp;&nbsp;<font color=red><br><%=errorMsg%></font></LI>
	<%}%>
  <LI id=list><b>&nbsp;&nbsp;&nbsp;用&nbsp;户&nbsp;登&nbsp;录：</b></LI>
  <LI id=list>用户名：<INPUT class=input_login maxLength=20 align=middle size=20 
  name=userName> </LI>
  <LI id=list>密&nbsp;&nbsp;&nbsp;&nbsp;码：<INPUT class=input_login type=password maxLength=20 
  align=middle size=20 name=passWord> </LI>
  <LI id=jiange>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<A style="CURSOR: hand" href="javascript:checkname()">
  <IMG alt=现在登录 src="<%=request.getContextPath()%>/ustc/html/pic/reg2.gif" width=75 border=0></A>&nbsp;&nbsp;&nbsp</LI></UL></DIV></FORM>
  <%} else {%>
  <!-- 不显示login页面-->
  <TBODY>
  <TR>
    <TD colSpan=2 height=1 color=white></TD></TR>
  <TR>
  <TR>
    <TD colSpan=2 height=85><IMG src="<%=request.getContextPath()%>/ustc/html/pic/welcome.gif"></TD></TR>
     <TR>
    <TD colSpan=2 height=20 color=white></TD></TR>
  <TR>
    </TBODY>
  <%}%>
  </table>

  
  <TABLE style="BORDER-RIGHT: #cccccc 1px solid; BORDER-LEFT: #cccccc 1px solid" height=160 cellSpacing=0 cellPadding=0 width=778 align=center bgColor=#ffffff border=0>
  <TBODY>
  <TR>
    <TD vAlign=top align=middle background="" colSpan=2 height=150>
      <P>&nbsp;</P>
      <TABLE cellSpacing=0 borderColorDark=white cellPadding=6 width="90%" borderColorLight=#999999 border=1>
        <TBODY>
        <TR>
          <TD align=left bgColor=#f2f2f2>注意事顼：</TD></TR>
        <TR>
          <TD style="LINE-HEIGHT: 25px" 
            align=left>1、使用IE5以上版本的浏览器,推荐用IE6,其它的浏览器可能不能正常使用本系统；<BR><SPAN 
            style="FONT-WEIGHT: 600; COLOR: #ee0000">2、请关闭或去掉3721等有窗口拦截功能的软件,另windows 
            XP sp2的用户请关闭“弹出窗口阻止程序”。</SPAN>(关闭方法：打开Internet 
            Explorer，在“工具”菜单中，指向“弹出窗口阻止程序”，然后单击“关闭弹出窗口阻止程序”即可)；<BR>3、使用过程遇到问题请<a class="a2" href="mailto:roy.wang123@gmail.com">联系我们</a>。 
          </TD></TR></TBODY></TABLE><BR></TD></TR></TBODY></TABLE>
<STYLE type=text/css>#center {
	TEXT-ALIGN: center
}
</STYLE>