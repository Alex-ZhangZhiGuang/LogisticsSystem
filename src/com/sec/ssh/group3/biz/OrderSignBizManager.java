package com.sec.ssh.group3.biz;

import java.util.ArrayList;
import java.util.List;

import com.sec.ssh.group3.dao.IOrderSignDAOManager;
import com.sec.ssh.group3.entity.Orders;
import com.sec.ssh.group3.entity.Ordersign;
import com.sec.ssh.group3.entity.User;
import com.sec.ssh.group3.entity.Warehouse;
/*
 * Ò«À¤£¨Èë¿âÇ©ÊÕBiz£©
 */
public class OrderSignBizManager implements IOrderSignBizManager
{
	private IOrderSignDAOManager dao;
	public IOrderSignDAOManager getDao() 
	{
		return dao;
	}

	public void setDao(IOrderSignDAOManager dao) 
	{
		this.dao = dao;
	}

	public ArrayList<Warehouse> findAll() 
	{
		return this.dao.findAll();
	}

	public void add(Ordersign s) 
	{
		this.dao.add(s);
	}

	public User findId(String roleid) 
	{
		return this.dao.findId(roleid);
	}


	public Warehouse findWarehouseById(int wid) 
	{
		return this.dao.findWarehouseById(wid);
	}

	public Orders findId(int oid) 
	{
		return this.dao.findId(oid);
	}

	public void add(List<Ordersign> s)
	{
		for(Ordersign or:s)
		{
			this.dao.add(or);
		}
	}

	public void update(List<Warehouse> wh) 
	{
		for(Warehouse ws:wh)
		{
			dao.update(ws);
		}
	}
	public void update_sign(List<Ordersign> sign)
	{
		for(Ordersign osign:sign)
		{
			dao.update_sign(osign);
		}
	}

	

}
