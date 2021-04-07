package com.ustc.action.grade;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ustc.biz.GradeMgr;
import com.ustc.common.SchAdminHelper;
import com.ustc.util.SecurityUtil;

public class GradeListAction extends Action {
	public ActionForward perform(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		if (!SecurityUtil.isCorrectUserTicket(request)) {
			return SchAdminHelper.requireLogin();// Security handle if no
													// this role goes to login
		}
		
		List gradelist = new ArrayList();

		try {
			GradeMgr gradeMgr = new GradeMgr();
			gradelist = gradeMgr.getAllStudentsGrade();
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("gradelist", gradelist);

		return mapping.findForward("list");
	}
}