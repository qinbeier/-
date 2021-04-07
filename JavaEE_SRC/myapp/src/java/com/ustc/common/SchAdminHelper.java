package com.ustc.common;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.*;

/**
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public final class SchAdminHelper {
    private SchAdminHelper() {
    }

    public static ActionForward requireLogin(){    
		ActionForward loginForward = new ActionForward();
		String loginURL = "/login.do?rnd=" + Math.random();
		loginForward.setPath(loginURL);
		loginForward.setRedirect(true);
		return loginForward;    	
    }
    public static ActionForward studentListPage(String userTicket){    
		ActionForward studentListForward = new ActionForward();
		String studentListPage = "/studentList.do?UT="+userTicket+"&rnd=" + Math.random();
		studentListForward.setPath(studentListPage);
		studentListForward.setRedirect(true);
		return studentListForward;    	
    }
    public static ActionForward gradeListPage(String userTicket){    
	ActionForward studentListForward = new ActionForward();
	String studentListPage = "/gradeList.do?UT="+userTicket+"&rnd=" + Math.random();
	studentListForward.setPath(studentListPage);
	studentListForward.setRedirect(true);
	return studentListForward;    	
}
}