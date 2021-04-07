package com.ustc.biz;

import java.util.ArrayList;

import com.ustc.vo.GradeVO;
import com.ustc.vo.StudentVO;

//为测试写的类
/**
 * DOCUMENT ME!
 *
 * @author $author$
 * @version $Revision$
 */
public class Test {
	public static String JMA_MD5="MD5";
    /**
     * DOCUMENT ME!
     *
     * @param args DOCUMENT ME!
     */
    public static void main(String[] args) {
    
	new Test().testStudent();

    }
    
    
    public static void testGrade()
    {
    	GradeVO achiveVO = new GradeVO();
    	achiveVO.setStuID("2007123456");
    	achiveVO.setNumDB(90);
    	addGrade(achiveVO);
    }
    
    public void testStudent()
    {
    	StudentVO studentVO = new StudentVO();
    	studentVO.setStuID("2007123456");
    	studentVO.setGender("男");
    	studentVO.setUsername("张玉林");
    	studentVO.setAddress("安徽合肥长江西路669号");
    	studentVO.setCity("淮北");
    	studentVO.setEmail("zjl1985@163.net");
    	studentVO.setPhone("1234567");
    	studentVO.setIdentityID("340123198508080815");
    	studentVO.setPostID("230008");
    	addStudent(studentVO);
    }
    
    public static void addGrade(GradeVO achiveVO) {
    	try {
    		GradeMgr stumgr = new GradeMgr();
			stumgr.addGrade(achiveVO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    public static void addStudent(StudentVO studentVO) {
    	try {
			StudentMgr stumgr = new StudentMgr();
			stumgr.addStudent(studentVO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    public static void getSearchStudents(String serachkey) {
    	try {
			StudentMgr stumgr = new StudentMgr();
			ArrayList ret = stumgr.getSearchStudents(serachkey);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    public static void updateStudent(StudentVO studentVO) {
    	try {
			StudentMgr stumgr = new StudentMgr();
			stumgr.updateStudent(studentVO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    public static void generateSTUID() {
    	try {
			StudentMgr stumgr = new StudentMgr();
			String studID = stumgr.generateSTUID();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    public static void getAllStudents() {
    	try {
			StudentMgr stumgr = new StudentMgr();
			ArrayList ret = stumgr.getAllStudents();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }


}
