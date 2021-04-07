package com.ustc.biz;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ustc.util.LogUtil;
import com.ustc.vo.GradeVO;

/**
 * 学生成绩管理
 * @author whb
 *
 */
public class GradeMgr {
    private Connection conn;

    public GradeMgr() throws Exception {
        this.conn = DatabaseConn.getConnection();
    }

    public void addGrade(GradeVO gradeVO) throws Exception {
        Statement stmt = conn.createStatement();
        String addGrade = "insert into stu_grade(STUID,g_electron,g_software,g_security,g_java,g_db,g_image,g_distributed,g_test) values ('";
        addGrade += (gradeVO.getStuID() + "'," + gradeVO.getNumElectron()
        + "," + gradeVO.getNumSoftware() + "," + gradeVO.getNumSecurity() + ","
        + gradeVO.getNumJava() + ",");
        addGrade += (gradeVO.getNumDB() + "," + gradeVO.getNumImage()
        + "," + gradeVO.getNumDistributed() + "," + gradeVO.getNumTest() + ");");

        try {
            stmt.executeUpdate(addGrade);
        } catch (SQLException e) {
            throw e;
        }
    }
    
    //修改已维护的学生成绩
    public void updateGrade(GradeVO gradeVO) throws Exception {
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
        String addStudent = "update stu_grade set STUID='" + gradeVO.getStuID()
            + "'" + ",g_electron=" + gradeVO.getNumElectron() + ",g_software="
            + gradeVO.getNumSoftware() + ",g_security=" + gradeVO.getNumSecurity()
            + ",g_java=" + gradeVO.getNumJava() + ",g_db="
            + gradeVO.getNumDB() + ",g_image=" + gradeVO.getNumImage()
            + ",g_distributed=" + gradeVO.getNumDistributed() + ",g_test="
            + gradeVO.getNumTest() + " where STUID='" + gradeVO.getStuID()
            + "';";

        try {
            stmt.executeUpdate(addStudent);
        } catch (SQLException e) {
            throw e;
        }
    }
    
   //根据学生列表删除学生成绩 
	public void deleteGradeList(String STUID)throws Exception
	{
	     Statement stmt=conn.createStatement();
	     try{

	    	 String deleteGrade = "delete from stu_grade where STUID in ("+STUID+");";
	     	stmt.executeUpdate(deleteGrade);
	     	
		 } catch (SQLException e) {
		 	throw e;
		 }
	}
	

    //得到所有的 学生成绩列表
    public ArrayList getAllStudentsGrade() throws Exception {
        Statement stmt = conn.createStatement();
        ResultSet rst = null;
        ArrayList ret = new ArrayList();

        try {
            rst = stmt.executeQuery(
                    "select a.STUID, b.username, a.g_electron,a.g_software,a.g_security,a.g_java,a.g_db,a.g_image,a.g_distributed,a.g_test from stu_grade a, student b where a.STUID=b.STUID;");

            while (rst.next()) {
            	GradeVO grade = new GradeVO();
            	grade.setStuID(rst.getString("STUID"));
            	grade.setUserName(rst.getString("username"));
            	grade.setNumElectron(rst.getInt("g_electron"));
            	grade.setNumSoftware(rst.getInt("g_software"));
            	grade.setNumSecurity(rst.getInt("g_security"));
            	grade.setNumJava(rst.getInt("g_java"));
            	grade.setNumDB(rst.getInt("g_db"));
            	grade.setNumImage(rst.getInt("g_image"));
            	grade.setNumDistributed(rst.getInt("g_distributed"));
            	grade.setNumTest(rst.getInt("g_test"));
                ret.add(grade);
            }
        } catch (SQLException e) {
            throw e;
        }

        return ret;
    }

    //根据学号得到学生成绩
    public GradeVO getGradeByStudentID(String stuid) throws Exception {
        Statement stmt = conn.createStatement();
        ResultSet rst = null;
      	GradeVO grade = new GradeVO();
        try {
            rst = stmt.executeQuery(
                    "select STUID, g_electron,g_software,g_security,g_java,g_db,g_image,g_distributed,g_test from stu_grade a where STUID="+stuid+";");
              while (rst.next()) {
            	grade.setStuID(rst.getString("STUID"));
            	grade.setNumElectron(rst.getInt("g_electron"));
            	grade.setNumSoftware(rst.getInt("g_software"));
            	grade.setNumSecurity(rst.getInt("g_security"));
            	grade.setNumJava(rst.getInt("g_java"));
            	grade.setNumDB(rst.getInt("g_db"));
            	grade.setNumImage(rst.getInt("g_image"));
            	grade.setNumDistributed(rst.getInt("g_distributed"));
            	grade.setNumTest(rst.getInt("g_test"));
            }
        } catch (SQLException e) {
            throw e;
        }

        return grade;
    }
    
    //按指定的条件搜索学生成绩列表（小于多少分 ）
    public ArrayList getSearchStudentsGrade(int searchkey)
        throws Exception {
        Statement stmt = conn.createStatement();
        ResultSet rst = null;
        ArrayList ret = new ArrayList();

        try {
            String searchSQL =
                "select a.STUID,b.username,a.g_electron,a.g_software,a.g_security,a.g_java,a.g_db,a.g_image,a.g_distributed,a.g_test from stu_grade a, student b where a.STUID=b.STUID and (a.g_electron < "
                + searchkey + "";
            searchSQL += " or a.g_software < " + searchkey
            + " or a.g_security < " + searchkey
            + " or a.g_java < " + searchkey
            + " or a.g_db < " + searchkey
            + " or a.g_image < " + searchkey
            + " or a.g_distributed < " + searchkey
            + " or a.g_test < " + searchkey
            + ");";
            
            LogUtil.logDebug(searchSQL);
            rst = stmt.executeQuery(searchSQL);

            while (rst.next()) {
            	GradeVO grade = new GradeVO();
            	grade.setStuID(rst.getString("STUID"));
            	grade.setUserName(rst.getString("username"));
            	grade.setNumElectron(rst.getInt("g_electron"));
            	grade.setNumSoftware(rst.getInt("g_software"));
            	grade.setNumSecurity(rst.getInt("g_security"));
            	grade.setNumJava(rst.getInt("g_java"));
            	grade.setNumDB(rst.getInt("g_db"));
            	grade.setNumImage(rst.getInt("g_image"));
            	grade.setNumDistributed(rst.getInt("g_distributed"));
            	grade.setNumTest(rst.getInt("g_test"));
                ret.add(grade);
            }
        } catch (SQLException e) {
            throw e;
        }

        return ret;
    }

    //按指定的条件搜索前几名的学生成绩列表
    public ArrayList getFirstStudentsGrade(int searchkey)
        throws Exception {
        Statement stmt = conn.createStatement();
        ResultSet rst = null;
        ArrayList ret = new ArrayList();

        try {
            String searchSQL =
            	"select a.STUID,b.username,a.g_electron,a.g_software,a.g_security,a.g_java,a.g_db,a.g_image,a.g_distributed,a.g_test,"
            	+"(a.g_electron+a.g_software+a.g_security+a.g_java+a.g_db+a.g_image+a.g_distributed+a.g_test)"
            	+"as sum from stu_grade a, student b where a.STUID=b.STUID order by sum desc  limit 0,"+searchkey+";";
            
            LogUtil.logDebug(searchSQL);
            rst = stmt.executeQuery(searchSQL);

            while (rst.next()) {
            	GradeVO grade = new GradeVO();
            	grade.setStuID(rst.getString("STUID"));
            	grade.setUserName(rst.getString("username"));
            	grade.setNumElectron(rst.getInt("g_electron"));
            	grade.setNumSoftware(rst.getInt("g_software"));
            	grade.setNumSecurity(rst.getInt("g_security"));
            	grade.setNumJava(rst.getInt("g_java"));
            	grade.setNumDB(rst.getInt("g_db"));
            	grade.setNumImage(rst.getInt("g_image"));
            	grade.setNumDistributed(rst.getInt("g_distributed"));
            	grade.setNumTest(rst.getInt("g_test"));
                ret.add(grade);
            }
        } catch (SQLException e) {
            throw e;
        }

        return ret;
    }
    
    //按学号或姓名搜索学生成绩列表
    public ArrayList getSearchStudentsGradebyID(String searchkey)
        throws Exception {
        Statement stmt = conn.createStatement();
        ResultSet rst = null;
        ArrayList ret = new ArrayList();

        try {
            rst = stmt.executeQuery(
                    "select a.STUID, b.username, a.g_electron,a.g_software,a.g_security,a.g_java,a.g_db,a.g_image,a.g_distributed,a.g_test from stu_grade a, student b where (a.STUID like '"
            		+searchkey +"' or b.username like '%"+searchkey+"%') and a.STUID=b.STUID;");

            while (rst.next()) {
            	GradeVO grade = new GradeVO();
            	grade.setStuID(rst.getString("STUID"));
            	grade.setUserName(rst.getString("username"));
            	grade.setNumElectron(rst.getInt("g_electron"));
            	grade.setNumSoftware(rst.getInt("g_software"));
            	grade.setNumSecurity(rst.getInt("g_security"));
            	grade.setNumJava(rst.getInt("g_java"));
            	grade.setNumDB(rst.getInt("g_db"));
            	grade.setNumImage(rst.getInt("g_image"));
            	grade.setNumDistributed(rst.getInt("g_distributed"));
            	grade.setNumTest(rst.getInt("g_test"));
                ret.add(grade);
            }
        } catch (SQLException e) {
            throw e;
        }

        return ret;
    }
    //删除某个学生的成绩 
    public void deleteGrade(String STUID) throws Exception {
        Statement stmt = conn.createStatement();

        try {
            String deleteStu = "delete from stu_grade where STUID='" + STUID
                + "';";
            stmt.executeUpdate(deleteStu);
        } catch (SQLException e) {
            throw e;
        }
    }

    
    //删除所有学生的成绩 
    public void deleteAllGrade() throws Exception {
        Statement stmt = conn.createStatement();

        try {
            String deleteStu = "delete from stu_grade;";
            stmt.executeUpdate(deleteStu);
        } catch (SQLException e) {
            throw e;
        }
    }
    
    public boolean isExistSTUIDGrade(String stuID) throws Exception {
        Statement stmt = conn.createStatement();
        ResultSet rst = null;

        try {
            rst = stmt.executeQuery("select * from stu_grade where STUID='"
                    + stuID + "';");

            while (rst.next()) {
                if (stuID.equals(rst.getString("STUID"))) {
                    return true;
                }
            }
        } catch (SQLException e) {
            throw e;
        }

        return false;
    }
    
    public static void main(String[] args)
    {
    	try {
			GradeMgr gradeMgr = new GradeMgr();
			LogUtil.logDebug("test GradeMgr");
			gradeMgr.getAllStudentsGrade();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
}
