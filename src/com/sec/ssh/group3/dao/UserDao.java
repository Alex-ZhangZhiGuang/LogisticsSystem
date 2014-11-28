package com.sec.ssh.group3.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sec.ssh.group3.entity.*;
/*
 * 罗萍（用户管理DAO）
 */
public class UserDao<T> extends HibernateDaoSupport implements IUserDao<T> 
{
	public boolean checkOrderPhone(String userPhone) 
	{
		ArrayList<Orders> list=(ArrayList<Orders>)this.getHibernateTemplate().find("from Orders c where userphone='"+userPhone+"'");
		if(list.isEmpty()||list==null)
			return false;
		return true;
	}
	/**
	 * 添加数据
	 */
	public void add(T entity) 
	{
		this.getHibernateTemplate().save(entity);
	}	
    /**
     * 修改数据
     */
	public void update(T entity)
	{
		this.getHibernateTemplate().update(entity);
	}
	
	/**
	 * 根据id查询 返回单行数据
	 */
	public T findByid(Class clz, Serializable id)
	{
		return (T) this.getHibernateTemplate().get(clz, id);
	}

	/**
	 * 条件查询
	 */
	public List<T> find(String sql) 
	{
		return this.getHibernateTemplate().find(sql);
	}
	public List<T> login(String username, String userpwd)
	{
		return  this.getHibernateTemplate().find("from  User  where username='"+username+"' and to_char(userpwd)='"+userpwd+"'");
	}

}
