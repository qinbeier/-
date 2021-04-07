package com.ustc.action.frame;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class LoginForm extends ActionForm
{
    private String userName;
    private String passWord;    

	/**
	 * @return Returns the passWord.
	 */
	public String getPassWord() {
		return passWord;
	}
	/**
	 * @param passWord The passWord to set.
	 */
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	/**
	 * @return Returns the userName.
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName The userName to set.
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
    public void reset(ActionMapping actionMapping,
            HttpServletRequest httpServletRequest) {    	
    	userName = "";
    	passWord = "";   
    }
}
                
    