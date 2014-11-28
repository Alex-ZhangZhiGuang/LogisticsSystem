package com.sec.ssh.group3.biz;
import com.sec.ssh.group3.dao.ISenddispatcherDAOManager;
import com.sec.ssh.group3.entity.*;

import  java.util.*;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
/*
 * 巧丽（派送调度Biz）
 */
public class SenddispatcherBizManager implements ISenddispatcherBizManager
{
	private ISenddispatcherDAOManager sdDao;
	//添加派送调度
	public void addSendDispatcher(Senddispatcher sd) 
	{
		//for(Senddispatcher list:sd)
			sdDao.addSendDispatcher(sd);
	}
	//查询所有派送调度
	public ArrayList<Senddispatcher> findAllSendDispatcher() 
	{
		return sdDao.findAllSendDispatcher();
	}
	//根据sdid查询派送调度信息
	public Senddispatcher findSendDispatcherById(int sdid) 
	{
		return sdDao.findSendDispatcherById(sdid);
	}
	//根据sdid修改派送调度
	public void updSenddispatcher(int sdid, Senddispatcher sd)
	{
		sdDao.updSenddispatcher(sdid, sd);
	}
	//根据派送状态查询派送调度信息
	public ArrayList<Senddispatcher> findAllSenddispatcherByisdeal() 
	{
		return sdDao.findAllSenddispatcherByisdeal();
	}
	//根据sdid查询派送调度
	public Senddispatcher findOneSenddispatcher(int sdid) 
	{
		return sdDao.findOneSenddispatcher(sdid);
	}
	//查询所有派送通知
	public ArrayList<Send> findAllSend()
	{
		return sdDao.findAllSend();
	}
	//根据sid查询派送通知信息
	public Send findOneSend(int sid) 
	{
		return sdDao.findOneSend(sid);
	}
	//修改派送通知的派送状态
	public void updSendById(Send s)
	{
		//for(Send list:s)
			sdDao.updSendById(s);	
	}
	//修改订单入库状态
	public void updOrderById(Orders o) 
	{
		//for(Orders os:o)
			sdDao.updOrderById(o);
	}
	//根据oid查询订单信息
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
