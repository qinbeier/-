<%@ include file="../frame/head.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/struts-html" prefix="html" %> 
<%@ taglib uri="/struts-bean" prefix="bean" %> 
<%@ taglib uri="/struts-logic" prefix="logic" %> 

<table width=778 cellspacing="4" width="100%" border="0">
 <tr>
  <td class="page-title" bordercolor="#000000" align="left" nowrap>
   <font>学生成绩一览表</font>
  </td>
 </tr>
</table>
<br>
<table width=778 width="90%"  border="0" cellpadding="4" cellspacing="1" bgcolor="#56B205">
	   <tr bgcolor="#ffffff"> 
	      <td height="22" width=14% class="header-center">学号</td>
	      <td height="22" width=12% class="header-center">姓名</td>
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
	      <td height="22" align="center"><bean:write name="grade" property="stuID" scope="page"/></td>
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
	      <td height="22" align="center" colspan=11>所有学生都没有成绩，请添加成绩!</td>	      
	  </tr>
	  </logic:empty> 
	  
</table>

 <table>
   	<tr> 
	      <td height="22" align="center" colspan=8>&nbsp;</td>
	</tr>
</table>
<%@ include file="../frame/foot.jsp" %>