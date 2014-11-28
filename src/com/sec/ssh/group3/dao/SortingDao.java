package com.sec.ssh.group3.dao;

import java.util.ArrayList;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.sec.ssh.group3.entity.*;
/*
 * 晓珍（分拣管理DAO）
 */
public class SortingDao extends HibernateDaoSupport implements ISortingDao{

	public void addSorting(Sorting s) 
	{
		this.getHibernateTemplate().save(s);
	}

	public ArrayList<Sorting> findAllRecord()
	{
		return 	(ArrayList<Sorting>)this.getHibernateTemplate().find("from Sorting");
		
	}

	public Sorting findSortingById(int sid)
	{
		return(Sorting)this.getHibernateTemplate().get(Sorting.class, sid);
	}

	public void updateSorting(Sorting s) 
	{
		this.getHibernateTemplate().saveOrUpdate(s);
	}

	public ArrayList<Warehouse> findSortingDo()
	{
		//改下 issort
		ArrayList<Warehouse>list =(ArrayList<Warehouse>)this.getHibernateTemplate().find("from Warehouse wh where wh.issign=1 and wh.issort=0 and wh.outdate is null");
		return list;
	}

	public void updWarehouse(Warehouse w)
	{
		this.getHibernateTemplate().saveOrUpdate(w);
		
	}

	public Warehouse findWarehouseById(int whid) 
	{
		return (Warehouse)this.getHibernateTemplate().get(Warehouse.class, whid);
	}

	public User findUserById(String uid) 
	{
		ArrayList<User> list=(ArrayList<User>)this.getHibernateTemplate().find("from User where usernumber='"+uid+"'");
		return list.get(0);
	}

	
}
