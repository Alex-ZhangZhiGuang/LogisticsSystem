package com.sec.ssh.group3.biz;

import java.util.List;

import com.sec.ssh.group3.dao.IUserDao;

import com.sec.ssh.group3.entity.User;
/*
 * 罗萍（用户管理Biz）
 */
public class UserBiz<User> implements IUserBiz<User> 
{

	private IUserDao<User> userdao;

	public IUserDao getDao() 
	{
		return userdao;
	}


	public void setDao(IUserDao userdao)
	{
		this.userdao = userdao;
	}

	/**
	 * 添加user
	 */
	public void add(User user) 
	{
		userdao.add(user);
	}

	/**
	 * 修改user数据
	 */
	public void update(User user) 
	{
		userdao.update(user);
	}
	
	/**
	 * 查询全部user数据  
	 */
	public List<User> findall() 
	{
		String sql="from User";
		return userdao.find(sql);
	}

	/**
	 * 根据id查询user数据
	 */
	public User findByid(int userid) 
	{
		return (User) userdao.findByid(com.sec.ssh.group3.entity.User.class,userid);
	}

	public List<User> login(String username, String userpwd) 
	{
		return userdao.login(username, userpwd);
	}


	public List<User> findname(String username)
	{
		return (List<User>) userdao.find("select username from User where username='"+username+"'");
	}

}
