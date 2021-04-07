<%@ include file="../frame/head.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/struts-bean" prefix="bean" %> 

<table width="778" border="0" align="center" cellpadding="0" cellspacing="0" style="border-right:1px solid #cccccc;border-left:1px solid #cccccc;">
  <tr> 
    <td height="400" valign="top">

<table width="100%" border="0" cellpadding="0" cellspacing="2" bgcolor="#FFFFFF">
  <tr bgcolor="#efefef"> 
    <td valign="top" align="center" height="448" style="padding-top:2px ">
		<p>
		    <br>
      <span align="center" style="color:#666666;font-size:14px;font-weight:600">添加新学生</span></p>
		<p><font color="#FF3300">新入学的学生或在数据库中不存在的学生，需要添加到此数据库中。</font>
          </p>
 


<script language="JavaScript">
function CheckForm()
{
	if (AtTrim(document.studentForm.stuID.value) == "") {
		alert("请输入学号.");
		document.studentForm.stuID.focus();
		return false;
	}
	if (AtTrim(document.studentForm.username.value) == "") {
		alert("请输入学生姓名.");
		document.studentForm.username.focus();
		return false;
	}
	if (AtTrim(document.studentForm.city.value) == "") {
		alert("请输入学生籍贯.");
		document.studentForm.city.focus();
		return false;
	}
	if (AtTrim(document.studentForm.gender.value) == "") {
		alert("请输入学生性别.");
		document.studentForm.gender.focus();
		return false;
	}
	if ((AtTrim(document.studentForm.identityID.value) != "") && !isValidPID(document.studentForm.identityID.value)) {
		alert("身份证号码输入错，注意要在英文状态下输入15或18位数字.");
		document.studentForm.pID.focus();
		return false;
	}
	if ((AtTrim(document.studentForm.phone.value) != "") && !isValidNumber(document.studentForm.phone.value)) {
		alert("电话号码错，只能输入数字，区号中间可用-分隔，不能少于７位，也可以用手机号码.");
		document.studentForm.phone.focus();
		return false;
	}
		if ((AtTrim(document.studentForm.postID.value) != "") && !isValidpostID(document.studentForm.postID.value)) {
		alert("邮政编码错，只能是六位数字.");
		document.studentForm.postID.focus();
		return false;
	}
	if ((AtTrim(document.studentForm.email.value) != "") && !document.studentForm.email.value.match( /^.+@.+$/ ) ) {
		alert("Email 错误！请重新输入");
		document.studentForm.email.focus();
		return false;
	}
	return true;
}


</script>

<table width="90%"  border="0" cellpadding="4" cellspacing="1" bgcolor="#56B205">
<form name="studentForm" method="POST" action="<%=request.getContextPath()%>/addStudent.do" onsubmit="return CheckForm();">
	<input type="hidden" name="flag" value="update">
	 <tr bgcolor="#ffffff"> 
	      <td width="21%" height="22" align="right" style="padding-right:10px"><font color="#ff0000">*</font>学　　号：</td>
	      <td align="left" width="79%" height="22">
	      <bean:define id="stuid" name="stuID"  type="String"/>
			 <input type="text" name="stuID" maxlength="20" size="30" value="<%=stuid%>" class="bbsInput_short">
	      </td>
	  </tr>  
	   <tr bgcolor="#ffffff"> 
	      <td width="21%" height="22" align="right" style="padding-right:10px"><font color="#ff0000">*</font>学生姓名：</td>
	      <td align="left" width="79%" height="22">
			 <input type="text" name="username" maxlength="20" size="30" value="" class="bbsInput_short">
	      </td>
	  </tr>       
	
	  <tr bgcolor="#f7f7f7"> 
	      <td height="22" align="right" style="padding-right:10px "><font color="#ff0000">*</font>性　　别：</td>
	      <td align="left" height="22"> <select name="gender"><option value="男">男</option>
	          <option value="女">女</option></select> 
	      </td>
	  　　　　　　　　      </tr>
	  <tr bgcolor="#ffffff"> 
          <td height="22" align="right" style="padding-right:10px "><font color="#ff0000">*</font>籍　　贯：</td>
          <td align="left" height="22"> <input type="text" name="city" maxlength="14" size="14" value="" class="bbsInput_short"><span style="color:#666666">&nbsp;&nbsp;市(如：北京市)</span></td>
      </tr>
        <tr bgcolor="#f7f7f7"> 
          <td height="22" align="right" style="padding-right:10px "><font color="#ff0000"></font>身份证号：</td>
          <td align="left" height="22"> <input type="text" name="identityID" maxlength="18" size="30" value="" class="bbsInput_short"><span style="color:#666666">&nbsp;&nbsp;</span></td>
      </tr>
        <tr bgcolor="#ffffff">                   
		  <td height="22" align="right" style="padding-right:10px ">联系电话：</td>
          <td align="left" height="22"> <input type="text" name="phone" maxlength="18" size="30" value="" class="bbsInput_short"><span style="color:#666666">&nbsp;&nbsp;</span></td>
      </tr>
        <tr bgcolor="#f7f7f7"> 
          <td height="22" align="right" style="padding-right:10px ">邮政编码：</td>
          <td align="left" height="22"> <input type="text" name="postID" maxlength="6" size="30" value="" class="bbsInput_short">&nbsp;&nbsp; 
          </td>
      </tr>
      <tr bgcolor="#ffffff"> 
          <td height="22" align="right" style="padding-right:10px ">电子邮件：</td>
          <td align="left" height="22"> <input type="text" name="email" maxlength="50" size="30" value="" class="bbsInput_short">&nbsp;&nbsp; 
          </td>
      </tr>
        <tr bgcolor="#f7f7f7"> 
          <td height="22" align="right" valign="middle" style="padding-right:10px ">通讯地址：</td>
          <td align="left" height="22"> <b> 
            <input type="text" name="address" maxlength="200" size="30" value="" class="bbsInput_short">
            </b> </td>
      </tr>
        <tr bgcolor="#ffffff"> 
          <td height="22" colspan="4"> <div align="center">
              <input type="submit" value="新 建" class="bbsbutton">
              &nbsp;&nbsp; 
              <input type="reset" value="清 除" class="bbsbutton">
              &nbsp;&nbsp; 
			  <input type="reset" value="返 回" onclick="history.back(-1);" class="bbsbutton">
          </div></td>
      </tr>
                <tr bgcolor="#ffffff"> 
                  <td height="45" colspan="4"> <table border="0" cellpadding="0" cellspacing="0" align="center" style="text-align:left">
                      <tr> 
                        <td height="24"><font color="#CC3300">注　意　事　项　： </font></td>
                      </tr>
                      <tr> 
                        <td height="24">1. 请仔细核对学生的信息，确认所输入的信息是正确的，如果本次输入错了，添加成功后，还可以继续修改；</td>
                      </tr>
                      <tr> 
                        <td height="24">2.<font color="#ff0000">*</font> 为必填项，如果全部正确输入后,按“新 建”按钮进行创建。</td>
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