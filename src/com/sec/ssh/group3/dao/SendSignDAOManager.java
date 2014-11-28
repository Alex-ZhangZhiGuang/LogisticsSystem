package com.sec.ssh.group3.dao;

import java.util.ArrayList;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sec.ssh.group3.entity.Deliver;
import com.sec.ssh.group3.entity.Ordersign;
import com.sec.ssh.group3.entity.Sendsign;
import com.sec.ssh.group3.entity.User;
/*
 * “´¿§£®≈…ÀÕ«© ’DAO£©
 */
public class SendSignDAOManager extends HibernateDaoSupport implements ISendSignDAOManager
{
	public ArrayList<Deliver> findYAll() 
	{
		ArrayList<Deliver> list=(ArrayList<Deliver>) this.getHibernateTemplate().find("from Deliver where issendsigninfo=0");
		return list;
	}
	public User findId(String roleid) 
	{
		ArrayList<User> list=null;
		list=(ArrayList<User>) this.getHibernateTemplate().find("from User where usernumber='"+roleid+"'");
		return list.get(0); 
	}
	public void add(Sendsign ss)
	{
		this.getHibernateTemplate().save(ss);
	}

	public void update(Deliver dlr)
	{
		this.getHibernateTemplate().saveOrUpdate(dlr);
	}

	public Deliver findDeliverId(int did)
	{
		return (Deliver) this.getHibernateTemplate().get(Deliver.class, did);
	}

}
