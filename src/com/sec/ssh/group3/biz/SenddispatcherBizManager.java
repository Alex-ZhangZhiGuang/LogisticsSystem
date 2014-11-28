package com.sec.ssh.group3.biz;
import com.sec.ssh.group3.dao.ISenddispatcherDAOManager;
import com.sec.ssh.group3.entity.*;

import  java.util.*;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
/*
 * ���������͵���Biz��
 */
public class SenddispatcherBizManager implements ISenddispatcherBizManager
{
	private ISenddispatcherDAOManager sdDao;
	//������͵���
	public void addSendDispatcher(Senddispatcher sd) 
	{
		//for(Senddispatcher list:sd)
			sdDao.addSendDispatcher(sd);
	}
	//��ѯ�������͵���
	public ArrayList<Senddispatcher> findAllSendDispatcher() 
	{
		return sdDao.findAllSendDispatcher();
	}
	//����sdid��ѯ���͵�����Ϣ
	public Senddispatcher findSendDispatcherById(int sdid) 
	{
		return sdDao.findSendDispatcherById(sdid);
	}
	//����sdid�޸����͵���
	public void updSenddispatcher(int sdid, Senddispatcher sd)
	{
		sdDao.updSenddispatcher(sdid, sd);
	}
	//��������״̬��ѯ���͵�����Ϣ
	public ArrayList<Senddispatcher> findAllSenddispatcherByisdeal() 
	{
		return sdDao.findAllSenddispatcherByisdeal();
	}
	//����sdid��ѯ���͵���
	public Senddispatcher findOneSenddispatcher(int sdid) 
	{
		return sdDao.findOneSenddispatcher(sdid);
	}
	//��ѯ��������֪ͨ
	public ArrayList<Send> findAllSend()
	{
		return sdDao.findAllSend();
	}
	//����sid��ѯ����֪ͨ��Ϣ
	public Send findOneSend(int sid) 
	{
		return sdDao.findOneSend(sid);
	}
	//�޸�����֪ͨ������״̬
	public void updSendById(Send s)
	{
		//for(Send list:s)
			sdDao.updSendById(s);	
	}
	//�޸Ķ������״̬
	public void updOrderById(Orders o) 
	{
		//for(Orders os:o)
			sdDao.updOrderById(o);
	}
	//����oid��ѯ������Ϣ
	public Orders findOneOrder(int oid)
	{
		return sdDao.findOneOrder(oid);
	}
	public ISenddispatcherDAOManager getSdDao()
	{
		return sdDao;
	}
	public void setSdDao(ISenddispatcherDAOManager sdDao) 
	{
		this.sdDao = sdDao;
	}
}
