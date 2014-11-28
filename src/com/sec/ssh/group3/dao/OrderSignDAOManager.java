package com.sec.ssh.group3.dao;

import java.util.ArrayList;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sec.ssh.group3.entity.Orders;
import com.sec.ssh.group3.entity.Ordersign;
import com.sec.ssh.group3.entity.User;
import com.sec.ssh.group3.entity.Warehouse;
/*
 * ҫ�������ǩ��DAO��
 */
public class OrderSignDAOManager extends HibernateDaoSupport implements IOrderSignDAOManager
{

	public ArrayList<Warehouse> findAll() 
	{
		ArrayList<Warehouse> list =(ArrayList<Warehouse>) this.getHibernateTemplate().find("from Warehouse where issign=0");
		return list;
	}

	public User findId(String roleid) 
	{
		ArrayList<User> list=null;
		list=(ArrayList<User>) this.getHibernateTemplate().find("from User where usernumber='"+roleid+"'");
		System.out.println("�๤���:"+list.size());
		return list.get(0); 
	}

	public void add(Ordersign s) 
	{
		this.getHibernateTemplate().save(s);
	}
	public void update(Warehouse wh)
	{
		this.getHibernateTemplate().saveOrUpdate(wh);
	}

	public Warehouse findWarehouseById(int wid) 
	{
	return	(Warehouse) this.getHibernateTemplate().get(Warehouse.class, wid);
	}

	public Orders findId(int oid) 
	{
		return (Orders) this.getHibernateTemplate().get(Orders.class, oid);
	}

	public void update_sign(Ordersign sign) 
	{
		this.getHibernateTemplate().saveOrUpdate(sign);
	}

	
}
