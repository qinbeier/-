package com.ustc.vo;
/**
 *表示用户信息,它是一个值对象，被From使用
 *这个对象必须提供对应的getter和setter方法
 */
//为测试写的类
public class UserVO
{
	public String userName;
	public String password;
	public int age; 
	
	public void setUserName(String name)
	{
		this.userName=name;
	}
	public void setPassword(String password)
	
	{
		this.password=password;
	}
	public String  getUserName()
	{
		return this.userName;
	}
	public String getPassword()
	{
		return password;
	}
	public int getAge()
	{
		return this.age;
	}
	public void setAge(int age)
	{
		this.age=age;
	}
}

	
	