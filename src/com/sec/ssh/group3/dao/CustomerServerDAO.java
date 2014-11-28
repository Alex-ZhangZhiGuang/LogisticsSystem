package com.sec.ssh.group3.dao;

import java.util.ArrayList;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sec.ssh.group3.entity.*;
/*
 * 勇强（客服服务DAO）
 */
public class CustomerServerDAO extends HibernateDaoSupport implements ICustomerServerDAO
{

	public void addDeliver(Deliver d)
	{
		  this.getHibernateTemplate().save(d);
	}

	public void addOrder(Orders s) 
	{
	      this.getHibernateTemplate().save(s);
	}

	public void addSend(Send s)
	{
		this.getHibernateTemplate().save(s);
	}

	public ArrayList<Sendsign> findOrderArrive() 
	{
		return (ArrayList<Sendsign>) this.getHibernateTemplate().find("from Sendsign");
	}

	public Orders findOrderById(String oid) 
	{
		ArrayList<Orders>list=(ArrayList<Orders>) this.getHibernateTemplate().find("from Orders where  oid='"+oid+"'");
		return list.get(0);
	}

	public ArrayList<Orders> findOrderEnterWarehouse() 
	{
		return (ArrayList<Orders>) this.getHibernateTemplate().find("from Orders");
	}

	public ArrayList<Send> findOrderNoDeliver() 
	{
		ArrayList<Send> list1=(ArrayList<Send>) this.getHibernateTemplate().find("from Send s where s.orders.deliverdispatchers.isdeliver=0");
		ArrayList<Send> list2=(ArrayList<Send>) this.getHibernateTemplate().find("from Send s where s.isdeal=0 and s.transitcity is null");
		ArrayList<Send> allList=new ArrayList<Send>();
		allList.addAll(list1);
		
		allList.addAll(list2);
		return allList ;
	}

	public ArrayList<Warehouse> findOrderNoSend()
	{
		return  (ArrayList<Warehouse>) this.getHibernateTemplate().find("from Warehouse wh where wh.issendinfo=0 and wh.outdate is not null");
	}

	public ArrayList<Deliver> findOrderOkDeliver() 
	{
		return (ArrayList<Deliver>)this.getHibernateTemplate().find("from Deliver") ;
	}

	public ArrayList<Send> findOrderOkSend()
	{
		return  (ArrayList<Send>) this.getHibernateTemplate().find("from Send");
	}

	public Send findSendinfoByOid(String oid)
	{
		ArrayList<Send> list=(ArrayList<Send>) this.getHibernateTemplate().find("from  Send s where s.sid='"+oid+"'");
		return list.get(0);
	}

	public void updSend(Send s) 
	{
		this.getHibernateTemplate().update(s);
		
	}

	public User findByUserId(String unumber)
	{
		  ArrayList<User> list=(ArrayList<User>) this.getHibernateTemplate().find("from User where usernumber='"+unumber+"'");
		  System.out.println(list.size());
		return list.get(0);
	}

	public Warehouse findWarehouserInfoByOid(int oid)
	{
		ArrayList<Warehouse> list=(ArrayList<Warehouse>) this.getHibernateTemplate().find("from  Warehouse  w where  w.whid="+oid+")");
		   return list.get(0);
	}

	public void updWarehouseState(Warehouse w) 
	{
		this.getHibernateTemplate().saveOrUpdate(w);
		
	}

	public Customer findCustomerById(String cnum)
	{
		ArrayList<Customer>list= (ArrayList<Customer>) this.getHibernateTemplate().find("from Customer  where cnumber='"+cnum+"'");
		return list.get(0);
	}

	public User findByUserId(int uid) 
	{
		return (User) this.getHibernateTemplate().get(User.class, uid);
	}

	public void addOrderCustomer(Ordercustomer oc) 
	{
		this.getHibernateTemplate().save(oc);
		
	}

	public ArrayList<Customer> findAllCustomer() 
	{
		return (ArrayList<Customer>) this.getHibernateTemplate().find("from Customer");
	}

	public Deliverdispatcher findDeliverdispatcher(int oid) 
	{
		ArrayList<Deliverdispatcher> drlist= (ArrayList<Deliverdispatcher>) this.getHibernateTemplate().find("from Deliverdispatcher d where d.orders.oid="+oid);
		if(drlist.size()>0)
			return drlist.get(0);
		return null;
	}

	public void updDeliverdispatcher(Deliverdispatcher d) 
	{
		this.getHibernateTemplate().saveOrUpdate(d);
	}
}
