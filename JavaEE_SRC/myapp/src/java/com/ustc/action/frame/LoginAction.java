package com.ustc.action.frame;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ustc.util.CommonUtil;
import com.ustc.util.LogUtil;
import com.ustc.util.SecurityUtil;

public class LoginAction extends Action {
	public ActionForward perform(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		LoginForm loginForm = (LoginForm) form;
		String userName = "";
		String passWord = "";
		
		String isCorrectUserTicket =(String)request.getSession().getAttribute("isCorrectUserTicket");
		if ("1".equals(isCorrectUserTicket))
			return mapping.findForward("success");
		if (loginForm != null) {// form为Null或其内容无值，都代表用户没有输入，此时userTicket为空
			userName = CommonUtil.fixNull(loginForm.getUserName());
			passWord = CommonUtil.fixNull(loginForm.getPassWord());
			if ("".equals(userName) || "".equals(passWord)) {
				return mapping.findForward("login");
			} else {
				if (userName.equals(SecurityUtil.SCH_USERNAME) && passWord.equals(SecurityUtil.SCH_PSW))
				{
					request.getSession().setAttribute("isCorrectUserTicket", "1");
					return mapping.findForward("success");
				}
				else
				{
					request.setAttribute("loginError", "1");
					return mapping.findForward("login");
				}
			}
		}
		
		return mapping.findForward("login");
	}	
}