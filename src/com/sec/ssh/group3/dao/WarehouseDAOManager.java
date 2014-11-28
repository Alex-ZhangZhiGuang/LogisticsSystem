package com.sec.ssh.group3.dao;

import java.util.ArrayList;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sec.ssh.group3.entity.Orders;
import com.sec.ssh.group3.entity.Warehouse;
/*
 * »Ÿª‘£®≤÷ø‚π‹¿ÌDAO£©
 */
public class WarehouseDAOManager extends HibernateDaoSupport implements IWarehouseDAOManager 
{
	public void add(Warehouse w) 
	{
		this.getHibernateTemplate().save(w);
	}

	public Warehouse findId(int id) 
	{
		return (Warehouse) this.getHibernateTemplate().get(Warehouse.class, id);
	}

	public ArrayList<Orders> findOrderAll()
	{
		return (ArrayList<Orders>) this.getHibernateTemplate().find("from Orders ");
	}

	public ArrayList<Warehouse> findWareAll() 
	{
		return (ArrayList<Warehouse>) this.getHibernateTemplate().find("from Warehouse ");
	}

	public void update(Warehouse w) 
	{
		this.getHibernateTemplate().update(w);
		
	}

	public Orders findOrderId(int oid) 
	{
		return (Orders) this.getHibernateTemplate().get(Orders.class, oid);
	}

	public ArrayList<Orders> findOrderAllNotRk() 
	{
		return (ArrayList<Orders>) this.getHibernateTemplate().find("from Orders where statuswarehouse=0");
	}

	public ArrayList<Warehouse> findWareAllNotCk() 
	{
		return (ArrayList<Warehouse>) this.getHibernateTemplate().find("from Warehouse where issign='1'and issort='1' and outdate is null ");
	}

	public void update(Orders o) 
	{
		this.getHibernateTemplate().update(o);
	}
}
