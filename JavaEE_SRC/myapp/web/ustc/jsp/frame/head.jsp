<html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.ustc.util.SecurityUtil" %>

<HEAD>
	<TITLE>
	××大学学籍管理系统
	</TITLE>
<LINK href="<%=request.getContextPath()%>/ustc/html/css/style.css" type=text/css rel="stylesheet">
<LINK href="<%=request.getContextPath()%>/ustc/html/css/main.css" type=text/css rel="stylesheet">
<SCRIPT language=JavaScript src="<%=request.getContextPath()%>/ustc/html/js/common.js"></SCRIPT>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
</HEAD>
<body>
<%
String isCorrectUserTicket = (String)request.getSession().getAttribute("isCorrectUserTicket");
		
%>
<TABLE cellSpacing=0 cellPadding=0 width=778 align=center border=0>
  <TBODY>
  <TR>
    <TD colSpan=2 height=1 color=white></TD></TR>
  <TR>
  <TR>
    <TD colSpan=2 height=85><IMG width=778 src="<%=request.getContextPath()%>/ustc/html/pic/header.jpg"></TD></TR>
  <TR>
  <TR>
    <TD colSpan=2 height=1></TD></TR>
  <TR>
    <TD align=right background='<%=request.getContextPath()%>/ustc/html/pic/line.jpg'>&nbsp;&nbsp;<font color=green>欢迎<% if("1".equals(isCorrectUserTicket)) {%><font color=red><b>admin</b></font><%}%>使用大学学籍管理系统</font></TD>
  </TR>
  <TR>
    <TD align=left background='<%=request.getContextPath()%>/ustc/html/pic/line.jpg' height=26>&nbsp;&nbsp;
    	<A style="COLOR: #333333" href="javascript:home();">学籍管理首页</A>&nbsp;|&nbsp;  
    	<A style="COLOR: #333333" href="javascript:createUser();">新建学生</A>&nbsp;|&nbsp;
 	 <A style="COLOR: #333333" href="javascript:studentmanager();">学生基本信息管理</A>&nbsp;|&nbsp;      
      <A style="COLOR: #333333" href="javascript:studentList();">学生一览表</A>&nbsp;|&nbsp;
      	<A style="COLOR: #333333" href="javascript:studentQuery();">学生基本信息查询</A>&nbsp;|&nbsp;  
      <A style="COLOR: #333333" href="javascript:scoreAdmin();">学生成绩管理</A> &nbsp;|&nbsp;   
        <A style="COLOR: #333333" href="javascript:gradeList();">学生成绩一览表</A>&nbsp;|&nbsp;
          	<A style="COLOR: #333333" href="javascript:queryGrade();">学生成绩查询</A>     
      <% if("1".equals(isCorrectUserTicket)) {%>&nbsp;|&nbsp;<A style="COLOR: #333333" href="javascript:exit();">退出系统</A>&nbsp;&nbsp;&nbsp;&nbsp;  
      <%}else{%> 
      &nbsp;|&nbsp;<A style="COLOR: #333333" href="javascript:login();">登录系统</A>&nbsp;&nbsp;&nbsp;&nbsp; 
      <%}%>
		</TD>
	</TR>
  <TR>
    <TD colSpan=2 height=1></TD></TR>
  <TR>
</TBODY></TABLE>

<script language="javascript">
	function home(){
		location.href="<%=request.getContextPath()%>/login.do?rnd=<%=Math.random()%>";
	}
	
	function studentQuery(){
		location.href="<%=request.getContextPath()%>/studentSearch.do?rnd=<%=Math.random()%>";
	}
	function gradeList(){
		location.href="<%=request.getContextPath()%>/gradeList.do?rnd=<%=Math.random()%>";
	}
	function studentmanager(){
		location.href="<%=request.getContextPath()%>/studentAdmin.do?rnd=<%=Math.random()%>";
	}
	
	function studentList(){
		location.href="<%=request.getContextPath()%>/studentList.do?rnd=<%=Math.random()%>";
	}
	function createUser()
	{
		location.href="<%=request.getContextPath()%>/addStudent.do?rnd=<%=Math.random()%>";
	}
	function queryGrade()
	{
		location.href="<%=request.getContextPath()%>/gradeSearch.do?rnd=<%=Math.random()%>";
	}
	function scoreAdmin(){
		location.href="<%=request.getContextPath()%>/gradeAdmin.do?rnd=<%=Math.random()%>";
	}
	function login(){
		location.href="<%=request.getContextPath()%>/login.do?rnd=<%=Math.random()%>";
	}
	
	function exit(){
		alert("欢迎你下次继续登录本网站！");
		location.href="<%=request.getContextPath()%>/logout.do?rnd=<%=Math.random()%>";
	}
</SCRIPT>	
