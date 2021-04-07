package com.ustc.action.grade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ustc.biz.GradeMgr;
import com.ustc.biz.StudentMgr;
import com.ustc.common.SchAdminHelper;
import com.ustc.util.LogUtil;
import com.ustc.util.SecurityUtil;
import com.ustc.vo.GradeVO;

public class AddGradeAction extends Action {
	public ActionForward perform(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		if (!SecurityUtil.isCorrectUserTicket(request)) {
			return SchAdminHelper.requireLogin();// Security handle if no
													// this role goes to login
		}
		
		String actionFlag = (String) request.getParameter("flag");

		if ("update".equals(actionFlag)) {
			GradeForm gradeForm = (GradeForm) form;
			if (gradeForm != null) {// 数据准备
				GradeVO gradevo = new GradeVO();
				gradevo.setStuID(gradeForm.getStuID());
				gradevo.setNumElectron(gradeForm.getNumElectron());
				gradevo.setNumSoftware(gradeForm.getNumSoftware());
				gradevo.setNumSecurity(gradeForm.getNumSecurity());
				gradevo.setNumJava(gradeForm.getNumJava());
				gradevo.setNumDB(gradeForm.getNumDB());
				gradevo.setNumImage(gradeForm.getNumImage());
				gradevo.setNumDistributed(gradeForm.getNumDistributed());
				gradevo.setNumTest(gradeForm.getNumTest());
				try {
					LogUtil.logDebug("AddGradeAction success");
					GradeMgr grademgr = new GradeMgr();
					if (grademgr.isExistSTUIDGrade(gradeForm.getStuID()))
						grademgr.updateGrade(gradevo);
					else
						grademgr.addGrade(gradevo);// 写DB
				} catch (Exception e) {
					System.out.println("error");
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			String ticket = request.getParameter("UT");

			String from = (String) request.getParameter("from");

			if ("gradeadmin".equals(from)) // 从成绩管理页面进行修改学生成绩
				return mapping.findForward("gradeadmin");
			else
				return SchAdminHelper.gradeListPage(ticket); // 新加成功后返回StudentList页面
		} else {
			String stuid = (String) request.getParameter("stuid");
			String userName = "";
			GradeVO gradevo = null;
			try {
				LogUtil.logDebug("AddGradeAction success");
				StudentMgr stumgr = new StudentMgr();
				userName = stumgr.getUserNameByID(stuid);
				GradeMgr grademgr = new GradeMgr();
				gradevo = grademgr.getGradeByStudentID(stuid);
			} catch (Exception e) {
				LogUtil.logDebug("error");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("userName", userName);
			if (gradevo == null || gradevo.getStuID() == null
					|| "".equals(gradevo.getStuID())) {
				gradevo = new GradeVO();
				gradevo.setStuID(stuid);
			}
			request.setAttribute("gradeForm", getFormbyVO(gradevo));
			return mapping.findForward("addgrade");
		}

	}

	private GradeForm getFormbyVO(GradeVO gradevo) {
		if (gradevo == null)
			return null;

		GradeForm gradeForm = new GradeForm();
		gradeForm.setStuID(gradevo.getStuID());
		gradeForm.setNumElectron(gradevo.getNumElectron());
		gradeForm.setNumSoftware(gradevo.getNumSoftware());
		gradeForm.setNumSecurity(gradevo.getNumSecurity());
		gradeForm.setNumJava(gradevo.getNumJava());
		gradeForm.setNumDB(gradevo.getNumDB());
		gradeForm.setNumImage(gradevo.getNumImage());
		gradeForm.setNumDistributed(gradevo.getNumDistributed());
		gradeForm.setNumTest(gradevo.getNumTest());

		return gradeForm;
	}

}
