package com.ustc.action.student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ustc.biz.StudentMgr;
import com.ustc.common.SchAdminHelper;
import com.ustc.util.CommonUtil;
import com.ustc.util.LogUtil;
import com.ustc.util.SecurityUtil;
import com.ustc.vo.StudentVO;

public class AddStudentAction extends Action
{
	public ActionForward perform(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response)
	{
        if(!SecurityUtil.isCorrectUserTicket(request)){
			return SchAdminHelper.requireLogin();//Security handle if no this role goes to login
		}
        
		String actionFlag = (String)request.getParameter("flag");
		
		if ("update".equals(actionFlag))
		{
		    StudentForm studentForm = (StudentForm) form;
		    if(studentForm != null){//数据准备
			StudentVO studentvo = new StudentVO();			
			studentvo.setUsername(CommonUtil.getLocalString(studentForm.getUsername()));
			System.out.println("studentvo.setUsername"+studentvo.getUsername());
			studentvo.setGender(CommonUtil.getLocalString(studentForm.getGender()));
			studentvo.setCity(CommonUtil.getLocalString(studentForm.getCity()));
			studentvo.setIdentityID(CommonUtil.getLocalString(studentForm.getIdentityID()));
			studentvo.setPhone(CommonUtil.getLocalString(studentForm.getPhone()));
			studentvo.setEmail(CommonUtil.getLocalString(studentForm.getEmail()));
			studentvo.setPostID(CommonUtil.getLocalString(studentForm.getPostID()));
			studentvo.setAddress(CommonUtil.getLocalString(studentForm.getAddress()));
			studentvo.setStuID(CommonUtil.getLocalString(studentForm.getStuID()));
			try {
				LogUtil.logDebug("success1");
				StudentMgr stumgr = new StudentMgr();
				stumgr.addStudent(studentvo);//写DB
			} catch (Exception e) {
				System.out.println("error");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
        	    String ticket = request.getParameter("UT");
        	    //新加成功后返回StudentList页面
        	    return SchAdminHelper.studentListPage(ticket);
		}
		else
		{
			String stuid = "";
			try {
				StudentMgr stumgr = new StudentMgr();
				stuid = stumgr.generateSTUID();//写DB
			} catch (Exception e) {
				System.out.println("error");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute("stuID", stuid);
			return mapping.findForward("addstudent");
		}
			
	}
}