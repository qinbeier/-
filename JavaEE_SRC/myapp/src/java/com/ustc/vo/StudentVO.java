package com.ustc.vo;

public class StudentVO
{
	public String stuID;//学号
	public String username;//姓名
	public String gender;//性别
	public String city;//籍贯
	public String identityID;//身份证号
	public String phone;//联系电话
	public String email;//电子信箱
	public String postID;//邮政编码
	public String address;//通讯地址
	

	/**
	 * @return Returns the address.
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address The address to set.
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return Returns the city.
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city The city to set.
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return Returns the email.
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email The email to set.
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return Returns the gender.
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender The gender to set.
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return Returns the phone.
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone The phone to set.
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPostID() {
		return postID;
	}
	/**
	 * @param postID The postID to set.
	 */
	public void setPostID(String postID) {
		this.postID = postID;
	}
	/**
	 * @return Returns the stuID.
	 */
	public String getStuID() {
		return stuID;
	}
	/**
	 * @param stuID The stuID to set.
	 */
	public void setStuID(String stuID) {
		this.stuID = stuID;
	}
	/**
	 * @return Returns the username.
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username The username to set.
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	public String getIdentityID() {
	    return identityID;
	}
	public void setIdentityID(String identityID) {
	    this.identityID = identityID;
	}
}


