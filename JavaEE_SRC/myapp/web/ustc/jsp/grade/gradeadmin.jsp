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
function deletegrade(form)
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
	     	alert("你没有选中输入删除的学生成绩，请重选！");
	     	return;
	}
	 
	location.href="<%=request.getContextPath()%>/deleteGrade.do?stuids="+stuids+"&rnd=<%=Math.random()%>";
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
	
	location.href="<%=request.getContextPath()%>/addGrade.do?stuid="+studid+"&from="+form.from.value+"&rnd=<%=Math.random()%>";
}
</script>

<table width=778 cellspacing="4" width="100%" border="0">
 <tr>
  <td class="page-title" bordercolor="#000000" align="left" nowrap>
   <font>学生成绩管理</font>
  </td>
 </tr>
</table>
<br>
<form name="gradeForm" method="POST">
<table width=778 width="90%"  border="0" cellpadding="4" cellspacing="1" bgcolor="#56B205">
	   <tr bgcolor="#ffffff"> 
	   	 <td height="22" width=6% class="header-center"></td>
	      <td height="22" width=10% class="header-center">学号</td>
	      <td height="22" width=10% class="header-center">姓名</td>
	      <td height="22" width=8% class="header-center">电子技术</td>
	      <td height="22" width=8% class="header-center">软件工程</td>
	      <td height="22" width=8% class="header-center">计算机网络与信息安全</td>
	      <td height="22" width=8% class="header-center">Java程序设计</td>
	      <td height="22" width=8% class="header-center">高级数据库</td>
	      <td height="22" width=8% class="header-center">图形图像处理技术</td>
	      <td height="22" width=8% class="header-center">分布计算与互联网技术</td>
	      <td height="22" width=8% class="header-center">软件测试与自演化技术</td>
	      <td height="22" width=10% class="header-center">总  分</td>

	  <logic:notEmpty name="gradelist" scope="request"> 
	  <logic:iterate id="grade" name="gradelist" type="com.ustc.vo.GradeVO" scope="request"> 
	   <bean:define id="stuid"  name="grade" property="stuID" type="String"/>
	    <bean:define id="numElectron"  name="grade" property="numElectron" type="Integer"/>
	    <bean:define id="numSoftware"  name="grade" property="numSoftware" type="Integer"/>
	    <bean:define id="numSecurity"  name="grade" property="numSecurity" type="Integer"/>
	    <bean:define id="numJava"  name="grade" property="numJava" type="Integer"/>
	    <bean:define id="numDB"  name="grade" property="numDB" type="Integer"/>
	    <bean:define id="numImage"  name="grade" property="numImage" type="Integer"/>
	    <bean:define id="numDistributed"  name="grade" property="numDistributed" type="Integer"/>
	    <bean:define id="numTest"  name="grade" property="numTest" type="Integer"/>
	  </tr>    
      <tr bgcolor="#ffffff"> 
     	  <td height="22" align="center"><input type=checkbox id="<%=stuid%>" value="<%=stuid%>"> </td>
	      <td height="22" align="center"><%=stuid%></td>
	      <td height="22" align="center" ><bean:write name="grade" property="userName" scope="page"/></td>
	      <td height="22" align="right"><%=numElectron%></td>
	      <td height="22" align="right"><%=numSoftware%></td>
	      <td height="22" align="right"><%=numSecurity%></td>
	      <td height="22" align="right"><%=numJava%></td>
	      <td height="22" align="right"><%=numDB%></td>
	      <td height="22" align="right"><%=numImage%></td>
	      <td height="22" align="right"><%=numDistributed%></td>
	      <td height="22" align="right"><%=numTest%></td>
	      <td height="22" align="right"><%=(numElectron+numSoftware+numSecurity+numJava+numImage+numDB+numDistributed+numTest)%></td>
	  </tr>
	  </logic:iterate> 
	  </logic:notEmpty> 
	  
	  <logic:empty  name="gradelist" scope="request"> 
	    <tr bgcolor="#ffffff"> 
	      <td height="22" align="center" colspan=12>所有学生都没有成绩，请返回<a class="a2" href="<%=request.getContextPath()%>/studentAdmin.do?rnd=<%=Math.random()%>">学生基本信息管理</a>先添加成绩!</td>	      
	  </tr>
	  </logic:empty> 
	  
</table>

<input type=hidden name="studentids" value="">
<input type="hidden" name="from" value="gradeadmin">
 <table>
 <tr>
 <td height="22" align="center" height=8>
 </td>
 </tr>
   	<tr> 
	      <td height="22" align="center" colspan=8>
	      	<input type=button name="allcheck" value="全选" onclick="javascript:checkall(gradeForm)">
	      	<input type=button name="allnotcheck" value="全不选"  onclick="javascript:uncheckall(gradeForm)">
			<input type=button name="delete" value="删除"  onclick="javascript:deletegrade(gradeForm)">
			<input type=button name="addgrade" value="维护学生成绩" onclick="javascript:modifygrade(gradeForm)">
		</td>
	</tr>
</table>
</form>
 <table>
   	<tr> 
	      <td height="22" align="center" colspan=8>&nbsp;</td>
	</tr>
</table>
<%@ include file="../frame/foot.jsp" %>