package com.sec.ssh.group3.biz;

import java.util.ArrayList;
import java.util.List;

import com.sec.ssh.group3.dao.WarehouseDAOManager;
import com.sec.ssh.group3.entity.Orders;
import com.sec.ssh.group3.entity.Warehouse;
/*
 * »Ÿª‘£®≤÷ø‚π‹¿ÌBiz£©
 */
public class WarehouseBizManager implements IWarehouseBizManager
{
	private WarehouseDAOManager dao;
	public WarehouseDAOManager getDao() 
	{
		return dao;
	}

	public void setDao(WarehouseDAOManager dao) 
	{
		this.dao = dao;
	}

	public Warehouse findId(int id) 
	{
		return dao.findId(id);
	}

	public ArrayList<Orders> findOrderAllNotRk() 
	{
		return dao.findOrderAllNotRk();
	}

	public ArrayList<Warehouse> findWareAll() 
	{
		return dao.findWareAll();
	}

	public Orders findOrderId(int oid) 
	{
		return dao.findOrderId(oid);
	}

	public ArrayList<Orders> findOrderAll()
	{
		return dao.findOrderAll();
	}

	public void addWhs(List<Warehouse> ws)
	{
		for(Warehouse wlist:ws)
		{
			dao.add(wlist);
		}
	}

	public ArrayList<Warehouse> findWareAllNotCk() 
	{
		return dao.findWareAllNotCk();
	}

	public void update(List<Orders> os) 
	{
		for(Orders olist:os)
		{
			dao.update(olist);
		}
	}

	public void wupdate(List<Warehouse> ws)
	{
		for(Warehouse wdlist:ws)
		{
			dao.update(wdlist);
		}
		
	}

}
