package com.sec.ssh.group3.biz;

import java.util.ArrayList;
import java.util.List;

import com.sec.ssh.group3.dao.ICustomerServerDAO;
import com.sec.ssh.group3.entity.Customer;
import com.sec.ssh.group3.entity.Deliver;
import com.sec.ssh.group3.entity.Deliverdispatcher;
import com.sec.ssh.group3.entity.Ordercustomer;
import com.sec.ssh.group3.entity.Orders;
import com.sec.ssh.group3.entity.Send;
import com.sec.ssh.group3.entity.Sendsign;
import com.sec.ssh.group3.entity.User;
import com.sec.ssh.group3.entity.Warehouse;
/*
 * 勇强（客服服务Biz）
 */
public class CustomerServerBizManager implements ICustomerServerBizManager 
{
	private ICustomerServerDAO dao;
	public ICustomerServerDAO getDao() 
	{
		return dao;
	}

	public void setDao(ICustomerServerDAO dao) 
	{
		this.dao = dao;
	}

	public void addDeliver(List<Deliver> d) 
	{
		for(Deliver dr:d)
			dao.addDeliver(dr);

	}

	public void addOrder(Orders s) 
	{
		dao.addOrder(s);
	}

	public void addSend(List<Send> s)
	{
		for(Send send:s)
			dao.addSend(send);
	}

	public ArrayList<Sendsign> findOrderArrive() 
	{
		return dao.findOrderArrive();
	}

	public Orders findOrderById(String oid) 
	{
		return dao.findOrderById(oid);
	}

	public ArrayList<Orders> findOrderEnterWarehouse()
	{
		return dao.findOrderEnterWarehouse();
	}

	public ArrayList<Send> findOrderNoDeliver() 
	{
		return dao.findOrderNoDeliver();
	}

	public ArrayList<Warehouse> findOrderNoSend() 
	{
		return dao.findOrderNoSend();
	}

	public ArrayList<Deliver> findOrderOkDeliver() 
	{
		return dao.findOrderOkDeliver();
	}

	public ArrayList<Send> findOrderOkSend()
	{
		return dao.findOrderOkSend();
	}

	public Send findSendinfoByOid(String oid)
	{
		return dao.findSendinfoByOid(oid);
	}

	public void updSend(List<Send> s) 
	{
		for(Send send:s)
			dao.updSend(send);
	}

	public User findByUserId(String unumber) 
	{
		return  dao.findByUserId(unumber);
	}

	public Warehouse findWarehouserInfoByOid(int oid)
	{
		return dao.findWarehouserInfoByOid(oid);
	}

	public void updWarehouseState(List<Warehouse> w) 
	{
		for(Warehouse wh:w)
			dao.updWarehouseState(wh);
	}

	public Customer findCustomerById(String cnum) 
	{
		return dao.findCustomerById(cnum);
	}

	public User findByUserId(int uid) 
	{
		return  dao.findByUserId(uid);
	}

	public void addOrderCustomer(Ordercustomer oc) 
	{
		dao.addOrderCustomer(oc);
	}

	public ArrayList<Customer> findAllCustomer()
	{
		return dao.findAllCustomer();
	}

	public Deliverdispatcher findDeliverdispatcher(int did) 
	{
		return dao.findDeliverdispatcher(did);
	}

	public void updDeliverdispatcher(Deliverdispatcher d) 
	{
		dao.updDeliverdispatcher(d);
	}
}
