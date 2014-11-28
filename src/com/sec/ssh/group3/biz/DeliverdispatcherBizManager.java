package com.sec.ssh.group3.biz;
import com.sec.ssh.group3.dao.IDeliverdispatcherDAOManager;
import com.sec.ssh.group3.entity.*;
import java.util.*;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
/*
 * 巧丽（提货调度Biz）
 */
public class DeliverdispatcherBizManager implements IDeliverdispatcherBizManager
{
	private IDeliverdispatcherDAOManager drDao;
	//添加提货调度信息
	public void addDeliverDispatchers(List<Deliverdispatcher> dr) 
	{
		for(Deliverdispatcher list:dr)
			drDao.addDeliverDispatcher(list);
	}
	//查询所有提货调度
	public ArrayList<Deliverdispatcher> findAllDeliverDispatcher() 
	{
		return drDao.findAllDeliverDispatcher();
	}
	//根据drid查询提货调度
	public Deliverdispatcher findDeliverDispatcherById(int drid) 
	{
		return drDao.findDeliverDispatcherById(drid);
	}
	//根据sdid查询派送调度
	public Senddispatcher findOneSenddispatcher(int sdid) 
	{
		return drDao.findOneSenddispatcher(sdid);
	}
	//修改派送调度派送状态
	public void updSenddispatcherById(List<Senddispatcher> sd) 
	{
		for(Senddispatcher list:sd)
			drDao.updSenddispatcherById(list);
	}
	//修改订单入库状态
	public void updOrderById(List<Orders> o) 
	{
		for(Orders os:o)
			drDao.updOrderById(os);
	}
	//根据oid查询订单信息
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

