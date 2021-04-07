package com.ustc.action.frame;
import org.apache.struts.action.*;
import javax.servlet.http.*;

public class LogoutAction extends Action
{
	public ActionForward perform(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response)
	{		
		ActionForward newforward = new ActionForward();
		String path = "/index.jsp?UT=&rand=" + Math.random();
		request.getSession().setAttribute("isCorrectUserTicket", "0");
		newforward.setPath(path);
		newforward.setRedirect(true);
		return newforward;
	}
}