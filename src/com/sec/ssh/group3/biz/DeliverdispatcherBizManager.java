package com.sec.ssh.group3.biz;
import com.sec.ssh.group3.dao.IDeliverdispatcherDAOManager;
import com.sec.ssh.group3.entity.*;
import java.util.*;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
/*
 * �������������Biz��
 */
public class DeliverdispatcherBizManager implements IDeliverdispatcherBizManager
{
	private IDeliverdispatcherDAOManager drDao;
	//������������Ϣ
	public void addDeliverDispatchers(List<Deliverdispatcher> dr) 
	{
		for(Deliverdispatcher list:dr)
			drDao.addDeliverDispatcher(list);
	}
	//��ѯ�����������
	public ArrayList<Deliverdispatcher> findAllDeliverDispatcher() 
	{
		return drDao.findAllDeliverDispatcher();
	}
	//����drid��ѯ�������
	public Deliverdispatcher findDeliverDispatcherById(int drid) 
	{
		return drDao.findDeliverDispatcherById(drid);
	}
	//����sdid��ѯ���͵���
	public Senddispatcher findOneSenddispatcher(int sdid) 
	{
		return drDao.findOneSenddispatcher(sdid);
	}
	//�޸����͵�������״̬
	public void updSenddispatcherById(List<Senddispatcher> sd) 
	{
		for(Senddispatcher list:sd)
			drDao.updSenddispatcherById(list);
	}
	//�޸Ķ������״̬
	public void updOrderById(List<Orders> o) 
	{
		for(Orders os:o)
			drDao.updOrderById(os);
	}
	//����oid��ѯ������Ϣ
	public Orders findOneOrder(int oid)
	{
		return drDao.findOneOrder(oid);
	}
	
	public IDeliverdispatcherDAOManager getDrDao() 
	{
		return drDao;
	}
	public void setDrDao(IDeliverdispatcherDAOManager drDao) 
	{
		this.drDao = drDao;
	}
}

