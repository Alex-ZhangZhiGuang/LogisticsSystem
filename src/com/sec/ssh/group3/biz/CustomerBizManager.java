package com.sec.ssh.group3.biz;

import java.util.ArrayList;

import com.sec.ssh.group3.dao.ICustomerDAO;
import com.sec.ssh.group3.entity.Customer;
/*
 * 宏红（客户管理Biz）
 */
public class CustomerBizManager implements ICustomerBizManager 
{
	private ICustomerDAO cdao;

	public void addCustomer(Customer c) 
	{
		cdao.addCustomer(c);
	}
	public ArrayList<Customer> findAllCustomer()
	{
		return cdao.findAllCustomer();
	}

	public void updateCustomer(Customer c)
	{
		cdao.updateCustomer(c);
	}

	public ICustomerDAO getDao() 
	{
		return cdao;
	}

	public void setDao(ICustomerDAO dao)
	{
		this.cdao = dao;
	}

	public Customer findCustomerById(int cid) 
	{
		return cdao.findCustomerById(cid);
	}
	public Integer checkCustomerPhone(String cphone) 
	{
		return cdao.checkCustomerPhone(cphone);
	}
	
}
