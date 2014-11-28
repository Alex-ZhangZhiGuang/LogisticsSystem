package com.sec.ssh.group3.dao;
import com.sec.ssh.group3.entity.*;

import java.util.*;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
/*
 * �������������DAO��
 */
public class DeliverdispatcherDAOManager extends HibernateDaoSupport implements IDeliverdispatcherDAOManager
{
	//������������Ϣ
	public void addDeliverDispatcher(Deliverdispatcher dr) 
	{
		this.getHibernateTemplate().save(dr);
	}
	//��ѯ�����������
	public ArrayList<Deliverdispatcher> findAllDeliverDispatcher() 
	{
		return (ArrayList<Deliverdispatcher>)this.getHibernateTemplate().find("from Deliverdispatcher d where d.orders.sends.transitcity is not null and d.isdeliver=1");	
	}
	//����drid��ѯ�������
	public Deliverdispatcher findDeliverDispatcherById(int drid) 
	{
		return (Deliverdispatcher)this.getHibernateTemplate().get(Deliverdispatcher.class, drid);
	}
	//����sdid��ѯ���͵���
	public Senddispatcher findOneSenddispatcher(int sdid)
	{
		return (Senddispatcher)this.getHibernateTemplate().get(Senddispatcher.class, sdid);
	}
	//�޸����͵�������״̬
	public void updSenddispatcherById(Senddispatcher sd) 
	{
		this.getHibernateTemplate().update(sd);
	}
	//�޸Ķ������״̬
	public void updOrderById(Orders o) 
	{
		this.getHibernateTemplate().update(o);	
	}
	//����oid��ѯ������Ϣ
	public Orders findOneOrder(int oid) 
	{
		return (Orders)this.getHibernateTemplate().get(Orders.class, oid);
	}
}
