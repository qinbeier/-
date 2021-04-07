<%@ include file="../frame/head.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/struts-html" prefix="html" %> 
<%@ taglib uri="/struts-bean" prefix="bean" %> 
<%@ taglib uri="/struts-logic" prefix="logic" %> 

<script language="javascript">
function checkall(form)
{
   var cbxoption;   
   cbxoption  =  form.all;   
   for(i=0;i<cbxoption.length;i++)   
   {   
	   if((cbxoption(i).tagName.toLowerCase() ==  "input")  && (cbxoption(i).type) &&  (cbxoption(i).type.toLowerCase()      ==    "checkbox")    )   
	   {   
	     cbxoption(i).checked = true;   
	   } 
   }    
}
function uncheckall(form)
{
   var cbxoption;   
   cbxoption  =  form.all;   
   for(i=0;i<cbxoption.length;i++)   
   {   
	   if((cbxoption(i).tagName.toLowerCase() ==  "input")  && (cbxoption(i).type) &&  (cbxoption(i).type.toLowerCase()      ==    "checkbox")    )   
	   {   
	     cbxoption(i).checked = false;   
	   } 
   }  
}
function deletestudent(form)
{
   var stuids;
   var cbxoption;
   var m = 0;   
   cbxoption  =  form.all;   
   for(i=0;i<cbxoption.length;i++)   
   {   
	   if((cbxoption(i).tagName.toLowerCase() ==  "input")  && (cbxoption(i).type) &&  (cbxoption(i).type.toLowerCase()  == "checkbox")    )   
	   {   
	   	 if (cbxoption(i).checked)
	   	 {
	   	 	m ++;
	   	 	if (m == 1)
	   	 		stuids = cbxoption[i].id;
	   	 	else
	   	 		stuids +=  "," + cbxoption[i].id;
		  }
	   } 
	   
	   form.studentids.value = stuids;
   }
    if (m == 0)
	{
	     	alert("你没有选中需要删除的学生，请重选！");
	     	return;
	}
	 
	location.href="<%=request.getContextPath()%>/deleteStudent.do?stuids="+stuids+"&rnd=<%=Math.random()%>";
}

function editstudent(form)
{
   var cbxoption,studid,username;   
   cbxoption  =  form.all; 
   var m = 0;  
   for(i=0;i<cbxoption.length;i++)   
   {   
	   if((cbxoption(i).tagName.toLowerCase() ==  "input")  && (cbxoption(i).type) &&  (cbxoption(i).type.toLowerCase()== "checkbox")    )   
	   {   
	   	if (cbxoption(i).checked)
	   	 {
		     m++;
		     if (m > 1)
		     {
		     	alert("一次只能修改一个学生的信息，请重选！");
		     	return;
		     }  
		     studid = cbxoption[i].id;
		  }
	   } 
   }
   
    if (m == 0)
	{
	     	alert("你没有选中需要修改的学生，请重选！");
	     	return;
	} 
	
	location.href="<%=request.getContextPath()%>/editStudent.do?stuid="+studid+"&rnd=<%=Math.random()%>";
}

function modifygrade(form)
{
   var cbxoption,studid,username;   
   cbxoption  =  form.all; 
   var m = 0;  
   for(i=0;i<cbxoption.length;i++)   
   {   
	   if((cbxoption(i).tagName.toLowerCase() ==  "input")  && (cbxoption(i).type) &&  (cbxoption(i).type.toLowerCase()== "checkbox")    )   
	   {   
	   	if (cbxoption(i).checked)
	   	 {
		     m++;
		     if (m > 1)
		     {
		     	alert("一次只能维护一个学生的成绩，请重选！");
		     	return;
		     }  
		     studid = cbxoption[i].id;
		  }
	   } 
   }
   
    if (m == 0)
	{
	     	alert("你没有选中需要维护成绩的学生，请重选！");
	     	return;
	} 
	
	location.href="<%=request.getContextPath()%>/addGrade.do?stuid="+studid+"&rnd=<%=Math.random()%>";
}
</script>

<table width=778 cellspacing="4" width="100%" border="0">
 <tr>
  <td class="page-title" bordercolor="#000000" align="left" nowrap>
   <font>学生信息管理</font>
  </td>
 </tr>
</table>
<br>
<form name="studentForm" method="POST">
<table width=778 width="90%"  border="0" cellpadding="4" cellspacing="1" bgcolor="#56B205">
	   <tr bgcolor="#ffffff"> 
	   	  <td height="22" class="header-center"></td>
	      <td height="22" class="header-center">学号</td>
	      <td height="22" class="header-center">姓名</td>
	      <td height="22" class="header-center">性别</td>
	      <td height="22" class="header-center">籍贯</td>
	      <td height="22" class="header-center">身份证号</td>
	      <td height="22" class="header-center">邮政编码</td>
	      <td height="22" class="header-center">电子邮件</td>
	      <td height="22" class="header-center">通讯地址</td>
	  </tr>
	  <logic:notEmpty name="studentlist" scope="request"> 
	  <logic:iterate id="student" name="studentlist" type="com.ustc.vo.StudentVO" scope="request"> 
      <tr bgcolor="#ffffff"> 
      	  <bean:define id="stuid"  name="student" property="stuID" type="String"/>
      	  <td height="22" align="center"><input type=checkbox id="<%=stuid%>" value="<%=stuid%>"> </td>
	      <td height="22" align="center"><bean:write name="student" property="stuID" scope="page"/></td>
	      <td height="22" align="center" ><bean:write name="student" property="username" scope="page"/></td>
	      <td height="22" align="center"><bean:write name="student" property="gender" scope="page"/></td>
	      <td height="22" align="center"><bean:write name="student" property="city" scope="page"/></td>
	      <!-- <td height="22" align="center">33</td> -->
	      <td height="22" align="center"><bean:write name="student" property="identityID" scope="page"/>
	      <td height="22" align="center"><bean:write name="student" property="email" scope="page"/></td>
	      <td height="22" align="center"><bean:write name="student" property="postID" scope="page"/></td>
	      <td height="22" align="center"><bean:write name="student" property="address" scope="page"/></td>
	  </tr>
	  </logic:iterate> 
	  </logic:notEmpty> 
	  
	   <logic:empty  name="studentlist" scope="request"> 
	    <tr bgcolor="#ffffff"> 
	      <td height="22" align="center" colspan=9>没有任何学生信息，请先添加!</td>	      
	  </tr>
	  </logic:empty> 
</table>
<input type=hidden name="studentids" value="">

 <table>
 <tr>
 <td height="22" align="center" height=8>
 </td>
 </tr>
   	<tr> 
	      <td height="22" align="center" colspan=8>
	      	<input type=button name="allcheck" value="全选" onclick="javascript:checkall(studentForm)">
	      	<input type=button name="allnotcheck" value="全不选"  onclick="javascript:uncheckall(studentForm)">
			<input type=button name="delete" value="删除"  onclick="javascript:deletestudent(studentForm)">
			<input type=button name="edit" value="修改学生信息"  onclick="javascript:editstudent(studentForm)">
			<input type=button name="addgrade" value="维护学生成绩" onclick="javascript:modifygrade(studentForm)">
			<!--<input type=button name="addgrade" value="维护学生成绩" onclick="javascript:addgrade(studentForm)">-->
		</td>
	</tr>
</table>
</form>


<%@ include file="../frame/foot.jsp" %>