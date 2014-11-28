package com.sec.ssh.group3.dao;
import com.sec.ssh.group3.entity.*;

import  java.util.*;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
/*
 * ���������͵���DAO��
 */
public class SenddispatcherDAOManager extends HibernateDaoSupport implements ISenddispatcherDAOManager
{
	//������͵���
	public void addSendDispatcher(Senddispatcher sd) 
	{
		this.getHibernateTemplate().save(sd);
	}
	//����sdid��ѯ���͵���
	public Senddispatcher findOneSenddispatcher(int sdid)
	{
		return (Senddispatcher)this.getHibernateTemplate().get(Senddispatcher.class, sdid);
	}
	//��ѯ�������͵���
	public ArrayList<Senddispatcher> findAllSendDispatcher() 
	{
		return (ArrayList<Senddispatcher>)this.getHibernateTemplate().find("from Senddispatcher s where s.isdeal=1");
	}
	//����sdid��ѯ���͵�����Ϣ
	public Senddispatcher findSendDispatcherById(int sdid) 
	{
		return (Senddispatcher)this.getHibernateTemplate().get(Senddispatcher.class, sdid);
	}
	//����sdid�޸����͵���
	public void updSenddispatcher(int sdid, Senddispatcher sd) 
	{
		sd.setSdid(sdid);
		this.getHibernateTemplate().update(sd);
	}
	//��������״̬��ѯ���͵�����Ϣ
	public ArrayList<Senddispatcher> findAllSenddispatcherByisdeal() 
	{
		return (ArrayList<Senddispatcher>)this.getHibernateTemplate().find("from Senddispatcher s where s.isdeal=0 and s.freightstation is null");
	}
	//��ѯ��������֪ͨ
	public ArrayList<Send> findAllSend() 
	{
		return (ArrayList<Send>)this.getHibernateTemplate().find("from Send s where s.transitcity is not null and s.isdeal=0");
	}
	//����sid��ѯ����֪ͨ��Ϣ
	public Send findOneSend(int sid) 
	{
		return (Send)this.getHibernateTemplate().get(Send.class, sid);
	}
	//�޸�����֪ͨ������״̬
	public void updSendById(Send s) 
	{
		this.getHibernateTemplate().update(s);
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
