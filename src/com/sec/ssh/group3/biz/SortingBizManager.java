package com.sec.ssh.group3.biz;

import java.util.ArrayList;
import java.util.List;

import com.sec.ssh.group3.dao.ISortingDao;
import com.sec.ssh.group3.entity.Orders;
import com.sec.ssh.group3.entity.*;
import com.sec.ssh.group3.entity.User;
import com.sec.ssh.group3.entity.Warehouse;
/*
 * ���䣨�ּ����Biz��
 */
public class SortingBizManager implements ISortingBizManager
{
	private ISortingDao sdao;

	public void addSorting(List<Sorting> s) 
	{
		for(Sorting st:s)
			sdao.addSorting(st);
		
	}

	public ArrayList<Sorting> findAllRecord() 
	{
		
		return sdao.findAllRecord();
	}

	public Sorting findSortingById(int sid) 
	{

	return 	sdao.findSortingById(sid);
		
	}

	public void updateSorting(Sorting s) 
	{
		sdao.updateSorting(s);
		
	}

	public ISortingDao getSdao() 
	{
		return sdao;
	}

	public void setSdao(ISortingDao sdao)
	{
		this.sdao = sdao;
	}

	public ArrayList<Warehouse> findSortingDo()
	{
	  return sdao.findSortingDo();
	}

	public void updWarehouse(List<Warehouse> w) 
	{
		for(Warehouse wh:w)
			sdao.updWarehouse(wh);
		
	}

	public Warehouse findWarehouseById(int whid) 
	{
		return sdao.findWarehouseById(whid);
	}

	public User findUserById(String uid) 
	{
		return sdao.findUserById(uid);
	}




}
	