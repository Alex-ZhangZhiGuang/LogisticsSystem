package com.sec.ssh.group3.dao;

import java.util.ArrayList;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sec.ssh.group3.entity.Customer;
/*
 * 宏红（客户管理DAO）
 */
public class CustomerDAO  extends HibernateDaoSupport  implements ICustomerDAO
{

	public void addCustomer(Customer c) 
	{
		this.getHibernateTemplate().save(c);
	}

	public ArrayList<Customer> findAllCustomer() 
	{
		return (ArrayList<Customer>)this.getHibernateTemplate().find("from Customer");
		
	}

	public void updateCustomer(Customer c) 
	{
		this.getHibernateTemplate().saveOrUpdate(c);
	}

	public Customer findCustomerById(int cid)
	{
		return (Customer) this.getHibernateTemplate().get(Customer.class, cid);
	}

	public Integer checkCustomerPhone(String cphone) 
	{
		ArrayList<Customer> list=(ArrayList<Customer>)this.getHibernateTemplate().find("from Customer c where cphone='"+cphone+"'");
		if(list.size()>0)
			return 1;
		return 0;
	}

}
