package com.sec.ssh.group3.biz;

import java.util.List;

import com.sec.ssh.group3.dao.IUserDao;

import com.sec.ssh.group3.entity.User;
/*
 * ��Ƽ���û�����Biz��
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
	 * ����user
	 */
	public void add(User user) 
	{
		userdao.add(user);
	}

	/**
	 * �޸�user����
	 */
	public void update(User user) 
	{
		userdao.update(user);
	}
	
	/**
	 * ��ѯȫ��user����  
	 */
	public List<User> findall() 
	{
		String sql="from User";
		return userdao.find(sql);
	}

	/**
	 * ����id��ѯuser����
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