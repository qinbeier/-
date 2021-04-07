package com.ustc.action.student;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ustc.biz.StudentMgr;
import com.ustc.common.SchAdminHelper;
import com.ustc.util.LogUtil;
import com.ustc.util.SecurityUtil;

public class StudentAdminAction extends Action {
	public ActionForward perform(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		if (!SecurityUtil.isCorrectUserTicket(request)) {
			return SchAdminHelper.requireLogin();// Security handle if no
													// this role goes to login
		}
		List studentlist = new ArrayList();

		try {
			StudentMgr stumgr = new StudentMgr();
			studentlist = stumgr.getAllStudents();
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("studentlist", studentlist);

		return mapping.findForward("list");
	}
}