package com.sec.ssh.group3.biz;

import java.util.ArrayList;
import java.util.List;

import com.sec.ssh.group3.dao.ISendSignDAOManager;
import com.sec.ssh.group3.entity.Deliver;
import com.sec.ssh.group3.entity.Ordersign;
import com.sec.ssh.group3.entity.Sendsign;
import com.sec.ssh.group3.entity.User;
/*
 * “´¿§£®≈…ÀÕ«© ’Biz£©
 */
public class SendSignBizManager implements ISendSignBizManager 
{

	private ISendSignDAOManager dao;

	public ISendSignDAOManager getDao() 
	{
		return dao;
	}

	public void setDao(ISendSignDAOManager dao) 
	{
		this.dao = dao;
	}

	public ArrayList<Deliver> findYAll() 
	{
		return this.dao.findYAll();
	}
	public User findId(String unumber)
	{
		return this.dao.findId(unumber);
	}

	public void add(List<Sendsign> ss) 
	{
		for(Sendsign sdn:ss)
		{
			this.dao.add(sdn);
		}
	}

	public void update(List<Deliver> der) 
	{
		for(Deliver dl:der)
		{
			this.dao.update(dl);
		}
	}

	public Deliver findDeliverId(int did) 
	{
		return this.dao.findDeliverId(did);
	}

}
