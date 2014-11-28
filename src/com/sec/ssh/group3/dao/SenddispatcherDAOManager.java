package com.sec.ssh.group3.dao;
import com.sec.ssh.group3.entity.*;

import  java.util.*;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
/*
 * 巧丽（派送调度DAO）
 */
public class SenddispatcherDAOManager extends HibernateDaoSupport implements ISenddispatcherDAOManager
{
	//添加派送调度
	public void addSendDispatcher(Senddispatcher sd) 
	{
		this.getHibernateTemplate().save(sd);
	}
	//根据sdid查询派送调度
	public Senddispatcher findOneSenddispatcher(int sdid)
	{
		return (Senddispatcher)this.getHibernateTemplate().get(Senddispatcher.class, sdid);
	}
	//查询所有派送调度
	public ArrayList<Senddispatcher> findAllSendDispatcher() 
	{
		return (ArrayList<Senddispatcher>)this.getHibernateTemplate().find("from Senddispatcher s where s.isdeal=1");
	}
	//根据sdid查询派送调度信息
	public Senddispatcher findSendDispatcherById(int sdid) 
	{
		return (Senddispatcher)this.getHibernateTemplate().get(Senddispatcher.class, sdid);
	}
	//根据sdid修改派送调度
	public void updSenddispatcher(int sdid, Senddispatcher sd) 
	{
		sd.setSdid(sdid);
		this.getHibernateTemplate().update(sd);
	}
	//根据派送状态查询派送调度信息
	public ArrayList<Senddispatcher> findAllSenddispatcherByisdeal() 
	{
		return (ArrayList<Senddispatcher>)this.getHibernateTemplate().find("from Senddispatcher s where s.isdeal=0 and s.freightstation is null");
	}
	//查询所有派送通知
	public ArrayList<Send> findAllSend() 
	{
		return (ArrayList<Send>)this.getHibernateTemplate().find("from Send s where s.transitcity is not null and s.isdeal=0");
	}
	//根据sid查询派送通知信息
	public Send findOneSend(int sid) 
	{
		return (Send)this.getHibernateTemplate().get(Send.class, sid);
	}
	//修改派送通知的派送状态
	public void updSendById(Send s) 
	{
		this.getHibernateTemplate().update(s);
	}
	//修改订单入库状态
	public void updOrderById(Orders o) 
	{
		this.getHibernateTemplate().update(o);	
	}
	//根据oid查询订单信息
	public Orders findOneOrder(int oid) 
	{
		return (Orders)this.getHibernateTemplate().get(Orders.class, oid);
	}
}
