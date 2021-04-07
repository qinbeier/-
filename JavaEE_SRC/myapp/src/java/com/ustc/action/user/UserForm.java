package com.ustc.action.user;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.*;

import com.ustc.vo.UserVO;

//Form，包含一个user属性。//为测试写的类

public class UserForm extends ActionForm
{
	private UserVO user=new UserVO();
	public void setUserName(String userName)
	{
		user.setUserName(userName);
	}
	public String getUserName()
	{
		return user.getUserName();
	}
	public void setUser(UserVO user)
	{
		this.user=user;
	}
	public UserVO getUser()
	{
		return this.user;
	}
	//重新设置form
	public void reset(ActionMapping mapping, HttpServletRequest request)
    {
                    this.user = new UserVO();
    }
    //form有效性判断，这里做简化处理。
     public ActionErrors validate(ActionMapping mapping,
                    HttpServletRequest request)
     {
        ActionErrors errors = new ActionErrors();
        if ((user.getUserName() == null) || (user.getPassword().length() < 3))
        { 
            errors.add("password", new ActionError("error.user.password"));
        }
        return errors;
     }
}
                
    