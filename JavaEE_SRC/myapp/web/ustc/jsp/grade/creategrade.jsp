<%@ include file="../frame/head.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/struts-html" prefix="html" %> 
<%@ taglib uri="/struts-bean" prefix="bean" %> 
<%@ taglib uri="/struts-logic" prefix="logic" %> 

<%
String userName =(String)request.getAttribute("userName");			
%>

<bean:define id="gradeForm"  name="gradeForm" type="com.ustc.action.grade.GradeForm"/>
	   <bean:define id="stuid"  name="gradeForm" property="stuID" type="String"/>
        <bean:define id="numElectron"  name="gradeForm" property="numElectron" type="Integer"/>
	    <bean:define id="numSoftware"  name="gradeForm" property="numSoftware" type="Integer"/>
	    <bean:define id="numSecurity"  name="gradeForm" property="numSecurity" type="Integer"/>
	    <bean:define id="numJava"  name="gradeForm" property="numJava" type="Integer"/>
	    <bean:define id="numDB"  name="gradeForm" property="numDB" type="Integer"/>
	    <bean:define id="numImage"  name="gradeForm" property="numImage" type="Integer"/>
	    <bean:define id="numDistributed"  name="gradeForm" property="numDistributed" type="Integer"/>
	    <bean:define id="numTest"  name="gradeForm" property="numTest" type="Integer"/>
<table width="778" border="0" align="center" cellpadding="0" cellspacing="0" style="border-right:1px solid #cccccc;border-left:1px solid #cccccc;">
  <tr> 
    <td height="400" valign="top">

<table width="100%" border="0" cellpadding="0" cellspacing="2" bgcolor="#FFFFFF">
  <tr bgcolor="#efefef"> 
    <td valign="top" align="center" height="448" style="padding-top:2px ">
		<p>
		    <br>
      <span align="center" style="color:#666666;font-size:14px;font-weight:600">维护学生成绩</span></p>


<script language="JavaScript">
function CheckForm()
{
	if ((AtTrim(document.form.numElectron.value) != "") && !isValidNumber(document.form.numElectron.value)) {
		alert("学生的成绩应为数字，请重新输入!");
		document.form.numElectron.focus();
		return false;
	}
	if ((AtTrim(document.form.numSoftware.value) != "") && !isValidNumber(document.form.numSoftware.value)) {
		alert("学生的成绩应为数字，请重新输入!");
		document.form.numSoftware.focus();
		return false;
	}
		if ((AtTrim(document.form.numSecurity.value) != "") && !isValidNumber(document.form.numSecurity.value)) {
		alert("学生的成绩应为数字，请重新输入!");
		document.form.numSecurity.focus();
		return false;
	}
		if ((AtTrim(document.form.numJava.value) != "") && !isValidNumber(document.form.numJava.value)) {
		alert("学生的成绩应为数字，请重新输入!");
		document.form.numJava.focus();
		return false;
	}
		if ((AtTrim(document.form.numDB.value) != "") && !isValidNumber(document.form.numDB.value)) {
		alert("学生的成绩应为数字，请重新输入!");
		document.form.numDB.focus();
		return false;
	}
		if ((AtTrim(document.form.numImage.value) != "") && !isValidNumber(document.form.numImage.value)) {
		alert("学生的成绩应为数字，请重新输入!");
		document.form.numImage.focus();
		return false;
	}
		if ((AtTrim(document.form.numDistributed.value) != "") && !isValidNumber(document.form.numDistributed.value)) {
		alert("学生的成绩应为数字，请重新输入!");
		document.form.numDistributed.focus();
		return false;
	}
	if ((AtTrim(document.form.numTest.value) != "") && !isValidNumber(document.form.numTest.value)) {
		alert("学生的成绩应为数字，请重新输入!");
		document.form.numTest.focus();
		return false;
	}
	return true;
}


</script>

<table width="90%"  border="0" cellpadding="4" cellspacing="1" bgcolor="#56B205">
<form name="form" method="POST" action="<%=request.getContextPath()%>/addGrade.do" onsubmit="return CheckForm();">
	<input type="hidden" name="stuID" value="<%=stuid%>">
	<input type="hidden" name="flag" value="update">
		<tr bgcolor="#ffffff"> 
	      <td width="38%" height="22" align="right" style="padding-right:10px"><font color="#ff0000"></font>学    号：</td>
	      <td align="left" width="79%" height="22">
			 <input type="text" name="studentID" maxlength="20" size="30" value="<%=stuid%>" class="bbsInput_short" disabled>
	      </td>
	  </tr>  
	   <tr bgcolor="#ffffff"> 
	      <td width="38%" height="22" align="right" style="padding-right:10px"><font color="#ff0000"></font>学生姓名：</td>
	      <td align="left" width="72%" height="22">
			 <input type="text" name="userName" maxlength="20" size="30" value="<%=userName%>" class="bbsInput_short" disabled>
	      </td>
	  </tr>       
	
	  <tr bgcolor="#f7f7f7"> 
	      <td height="22" align="right" style="padding-right:10px "><font color="#ff0000"></font>电子技术：</td>
	      <td align="left" width="72%" height="22">
			 <input type="text" name="numElectron" maxlength="20" size="30" value="<%=numElectron%>" class="bbsInput_short">
	      </td>
	  </tr>
	    <tr bgcolor="#f7f7f7"> 
	      <td height="22" align="right" style="padding-right:10px "><font color="#ff0000"></font>软件工程：</td>
	      <td align="left" width="72%" height="22">
			 <input type="text" name="numSoftware" maxlength="20" size="30" value="<%=numSoftware%>" class="bbsInput_short">
	      </td>
	  </tr>
	    <tr bgcolor="#f7f7f7"> 
	      <td height="22" align="right" style="padding-right:10px "><font color="#ff0000"></font>计算机网络与信息安全：</td>
	      <td align="left" width="72%" height="22">
			 <input type="text" name="numSecurity" maxlength="20" size="30" value="<%=numSecurity%>" class="bbsInput_short">
	      </td>
	  </tr>
	    <tr bgcolor="#f7f7f7"> 
	      <td height="22" align="right" style="padding-right:10px "><font color="#ff0000"></font>Java程序设计：</td>
	      <td align="left" width="72%" height="22">
			 <input type="text" name="numJava" maxlength="20" size="30" value="<%=numJava%>" class="bbsInput_short">
	      </td>
	  </tr>
	    <tr bgcolor="#f7f7f7"> 
	      <td height="22" align="right" style="padding-right:10px "><font color="#ff0000"></font>高级数据库：</td>
	      <td align="left" width="72%" height="22">
			 <input type="text" name="numDB" maxlength="20" size="30" value="<%=numDB%>" class="bbsInput_short">
	      </td>
	  </tr>
	    <tr bgcolor="#f7f7f7"> 
	      <td height="22" align="right" style="padding-right:10px "><font color="#ff0000"></font>图形图像处理技术：</td>
	      <td align="left" width="72%" height="22">
			 <input type="text" name="numImage" maxlength="20" size="30" value="<%=numImage%>" class="bbsInput_short">
	      </td>
	  </tr>
	    <tr bgcolor="#f7f7f7"> 
	      <td height="22" align="right" style="padding-right:10px "><font color="#ff0000"></font>分布计算与互联网技术：</td>
	      <td align="left" width="72%" height="22">
			 <input type="text" name="numDistributed" maxlength="20" size="30" value="<%=numDistributed%>" class="bbsInput_short">
	      </td>
	  </tr>
	    <tr bgcolor="#f7f7f7"> 
	      <td height="22" align="right" style="padding-right:10px "><font color="#ff0000"></font>软件测试与自演化技术：</td>
	      <td align="left" width="72%" height="22">
			 <input type="text" name="numTest" maxlength="20" size="30" value="<%=numTest%>" class="bbsInput_short">
	      </td>
	  </tr>
        <tr bgcolor="#ffffff"> 
          <td height="22" colspan="4"> <div align="center">
              <input type="submit" value="保 存" class="bbsbutton">
              &nbsp;&nbsp; 
              <input type="reset" value="清 除" class="bbsbutton">
              &nbsp;&nbsp; 
			  <input type="reset" value="返 回" onclick="history.back(-1);" class="bbsbutton">
          </div></td>
          
          <input type="hidden" name="from" value="<%=request.getParameter("from") %>">
      </tr>
                <tr bgcolor="#ffffff"> 
                  <td height="45" colspan="4"> <table border="0" cellpadding="0" cellspacing="0" align="center" style="text-align:left">
                      <tr> 
                        <td height="24"><font color="#CC3300">注　意　事　项　： </font></td>
                      </tr>
                      <tr> 
                        <td height="24">1. 请仔细核对学生的成绩，确认所输入的信息是正确的，如果本次输入错了，保存成功后，还可以继续修改；</td>
                      </tr>
                      <tr> 
                        <td height="24">2.<font color="#ff0000">*</font> 为必填项，如果全部正确输入后,按“保 存”按钮进行保存。</td>
                      </tr>
                  </table>
				  </td>
                </tr>

              </form></table>

	<br></td>
  </tr>
</table></td>
  </tr>
</table>

<%@ include file="../frame/foot.jsp" %>