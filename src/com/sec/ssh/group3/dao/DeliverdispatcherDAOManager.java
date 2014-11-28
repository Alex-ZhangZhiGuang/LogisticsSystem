package com.sec.ssh.group3.dao;
import com.sec.ssh.group3.entity.*;

import java.util.*;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
/*
 * 巧丽（提货调度DAO）
 */
public class DeliverdispatcherDAOManager extends HibernateDaoSupport implements IDeliverdispatcherDAOManager
{
	//添加提货调度信息
	public void addDeliverDispatcher(Deliverdispatcher dr) 
	{
		this.getHibernateTemplate().save(dr);
	}
	//查询所有提货调度
	public ArrayList<Deliverdispatcher> findAllDeliverDispatcher() 
	{
		return (ArrayList<Deliverdispatcher>)this.getHibernateTemplate().find("from Deliverdispatcher d where d.orders.sends.transitcity is not null and d.isdeliver=1");	
	}
	//根据drid查询提货调度
	public Deliverdispatcher findDeliverDispatcherById(int drid) 
	{
		return (Deliverdispatcher)this.getHibernateTemplate().get(Deliverdispatcher.class, drid);
	}
	//根据sdid查询派送调度
	public Senddispatcher findOneSenddispatcher(int sdid)
	{
		return (Senddispatcher)this.getHibernateTemplate().get(Senddispatcher.class, sdid);
	}
	//修改派送调度派送状态
	public void updSenddispatcherById(Senddispatcher sd) 
	{
		this.getHibernateTemplate().update(sd);
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
