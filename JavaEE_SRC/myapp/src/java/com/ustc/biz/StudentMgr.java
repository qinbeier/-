package com.ustc.biz;
import com.ustc.vo.StudentVO;

import java.sql.*;
import java.util.*;

/**
 * Student Manager
 * @author whb
 *
 */
public class StudentMgr
{
	private Connection conn ;
	
	public  StudentMgr()throws Exception
	{
		this.conn=DatabaseConn.getConnection();
	}
	
	//新加一条记录Student
	public void addStudent(StudentVO studentVO)throws Exception
	{
	     Statement stmt=conn.createStatement();
	     String addStudent = "insert into student(STUID,username,gender,city,PID,phone,email,postID,address) values ('";
	     addStudent += studentVO.getStuID()+"','"+studentVO.getUsername()+"','"+studentVO.getGender()+"','"+studentVO.getCity()+"','"+studentVO.getIdentityID()+"','";
	     addStudent += studentVO.getPhone()+"','"+studentVO.getEmail()+"','"+studentVO.getPostID()+"','"+studentVO.getAddress()+"');";
		 try{
		 	stmt.executeUpdate(addStudent);
		 } catch (SQLException e) {
		 	throw e;
		 } 
	     
	}
	//修改已建立的记录
	public void updateStudent(StudentVO studentVO)throws Exception
	{
	     Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	     String addStudent = "update student set STUID='"+ studentVO.getStuID()+ "'" + ",username='"+studentVO.getUsername()+"'" +
	     ",gender='"+ studentVO.getGender()+ "'" + ",city='"+studentVO.getCity()+"'" + ",PID='"+studentVO.getIdentityID()+"'"+
	     ",phone='"+ studentVO.getPhone()+ "'" + ",email='"+studentVO.getEmail()+"'" + ",postID='"+studentVO.getPostID()+"'"+
	     ",address='"+ studentVO.getAddress()+ "' where STUID='" + studentVO.getStuID() +"';";
		 try{
		 	stmt.executeUpdate(addStudent);
		 } catch (SQLException e) {
		 	throw e;
		 }
	     
	}
	//得到所有的Student列表
	public ArrayList getAllStudents()throws Exception
	{
		 Statement stmt=conn.createStatement();
		 ResultSet rst = null;
		 ArrayList ret=new ArrayList();
		 try{
		 	rst=stmt.executeQuery("select STUID,username,gender,city,PID,phone,email,postID,address from student;");		     
		     while(rst.next())
		     {
		     	StudentVO student=new StudentVO();
		     	student.setStuID(rst.getString("STUID"));
		     	student.setUsername(rst.getString("username"));
		     	student.setGender(rst.getString("gender"));
		     	student.setCity(rst.getString("city"));
		     	student.setIdentityID(rst.getString("PID"));
		     	student.setPhone(rst.getString("phone"));
		     	student.setEmail(rst.getString("email"));
		     	student.setPostID(rst.getString("postID"));
		     	student.setAddress(rst.getString("address"));
		        ret.add(student);
		     }
		 } catch (SQLException e){
		 	throw e;
		 } 

	     return ret;
	  }
	
	//根据学号得到学生姓名
	public String getUserNameByID(String stuid)throws Exception
	{
		 Statement stmt=conn.createStatement();
		 ResultSet rst = null;
		 String userName = "";
		 try{
		 	rst=stmt.executeQuery("select STUID,username,gender,city,PID,phone,email,postID,address from student where stuid="+stuid+";");		     
		     while(rst.next())
		     {
		    	 userName = rst.getString("username");
		     }
		 } catch (SQLException e){
		 	throw e;
		 } 

	     return userName;
	  }
	
	//按指定的条件搜索Student列表
	public ArrayList getSearchStudents(String searchkey)throws Exception
	{
		 Statement stmt=conn.createStatement();
		 ResultSet rst = null;
		 ArrayList ret=new ArrayList();
		 try{
		 	String searchSQL = "select STUID,username,gender,city,PID,phone,email,postID,address from student where STUID like '%" +searchkey+ "%'";
		 	searchSQL += " or username like '%" +searchkey+ "%' or city like '%" +searchkey+ "%' or PID like '%" +searchkey+ "%';";
		 	rst=stmt.executeQuery(searchSQL);		     
		     while(rst.next())
		     {
		     	StudentVO student=new StudentVO();
		     	student.setStuID(rst.getString("STUID"));
		     	student.setUsername(rst.getString("username"));
		     	student.setGender(rst.getString("gender"));
		     	student.setCity(rst.getString("city"));
		     	student.setIdentityID(rst.getString("PID"));
		     	student.setPhone(rst.getString("phone"));
		     	student.setEmail(rst.getString("email"));
		     	student.setPostID(rst.getString("postID"));
		     	student.setAddress(rst.getString("address"));
		        ret.add(student);
		     }
		 } catch (SQLException e){
		 	throw e;
		 }

	     return ret;
	  }
	
	//按学号取到学生信息
	public StudentVO getStudentByID(String stuid)throws Exception
	{
		 Statement stmt=conn.createStatement();
		 ResultSet rst = null;
	     StudentVO student=null;
	     	
		 try{
		 	String searchSQL = "select STUID,username,gender,city,PID,phone,email,postID,address from student where STUID = '" +stuid+ "';";
		 	rst=stmt.executeQuery(searchSQL);		     
		     while(rst.next())
		     {
		    	student=new StudentVO();	
		     	student.setStuID(rst.getString("STUID"));
		     	student.setUsername(rst.getString("username"));
		     	student.setGender(rst.getString("gender"));
		     	student.setCity(rst.getString("city"));
		     	student.setIdentityID(rst.getString("PID"));
		     	student.setPhone(rst.getString("phone"));
		     	student.setEmail(rst.getString("email"));
		     	student.setPostID(rst.getString("postID"));
		     	student.setAddress(rst.getString("address"));
		     }
		 } catch (SQLException e){
		 	throw e;
		 }

	     return student;
	  }
	
//删除Student 
	public void deleteStudent(String STUID)throws Exception
	{
	     Statement stmt=conn.createStatement();
	     try{
	     	String deleteStu = "delete from student where STUID in ("+STUID+");";
	     	stmt.executeUpdate(deleteStu);
	     	
	     	String deleteGrade = "delete from stu_grade where STUID in ("+STUID+");";
	     	stmt.executeUpdate(deleteGrade);
	     	
		 } catch (SQLException e) {
		 	throw e;
		 }
	}
	
	//生成STUID，前四位是年份，后六位是随机数
	public String generateSTUID() throws Exception{
		Calendar calendar = Calendar.getInstance();
		String strstuID="";	
		int done = 1;
		while(done ==1){
			strstuID="";
			strstuID += calendar.get(Calendar.YEAR);
			double rand = Math.random() * 900000;
			long stuID = (long) (rand) + 100000;
			strstuID += stuID;
			 
			 if(!isExistSTUID(strstuID)){
			 	done = 0;
			 }
		}
		return strstuID;
		
	}
	
	private boolean isExistSTUID(String stuID) throws Exception {
	        Statement stmt=conn.createStatement();
			 ResultSet rst = null;
			 try{
			 	rst=stmt.executeQuery("select * from student where STUID='" + stuID+ "';");
				 while(rst.next())
			     {
				 	if(stuID.equals(rst.getString("STUID"))){
				 	return true;			 		
				 	}
			     }
			 } catch (SQLException e){
			 	throw e;
			 } finally {
			 	if(conn != null) {
			 		conn.close();
			 	}
			 }
	        return false;
	    }
	
    public static void main(String[] args)
    {
    	System.out.println("test StudentMgr");
    	try {
    		StudentMgr stuMgr = new StudentMgr();
    		StudentVO test = new StudentVO();
    		test.setIdentityID("354352334");
    		test.setStuID("35435");
    		test.setUsername("中国");
    		stuMgr.addStudent(test);
    		stuMgr.getSearchStudents("35435");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
}
