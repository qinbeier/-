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
import com.ustc.util.CommonUtil;
import com.ustc.util.SecurityUtil;

public class GradeSearchAction extends Action {
	public ActionForward perform(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		if (!SecurityUtil.isCorrectUserTicket(request)) {
			return SchAdminHelper.requireLogin();// Security handle if no
													// this role goes to login
		}

		String queryoption = (String) request.getParameter("queryoption");
		String querystr = "";

		if ("1".equals(queryoption))// score query
			querystr = (String) request.getParameter("querystring1");
		else if ("2".equals(queryoption))
			querystr = (String) request.getParameter("querystring2");
		else
			querystr = (String) request.getParameter("querystring");

		List gradelist = new ArrayList();
		if (querystr != null && !"".equals(querystr)) {
			try {
				GradeMgr grademgr = new GradeMgr();
				if ("1".equals(queryoption))// score query
					gradelist = grademgr.getSearchStudentsGrade(Integer
							.parseInt(querystr));
				else if ("2".equals(queryoption))
					gradelist = grademgr.getFirstStudentsGrade(Integer
							.parseInt(querystr));
				else
					gradelist = grademgr.getSearchStudentsGradebyID(CommonUtil
							.getLocalString(querystr));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		request.setAttribute("gradelist", gradelist);

		return mapping.findForward("list");
	}
}