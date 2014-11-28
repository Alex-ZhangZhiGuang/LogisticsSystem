package com.sec.ssh.group3.dao;
import com.sec.ssh.group3.entity.*;

import  java.util.*;
/*
 * 巧丽（派送调度DAO接口）
 */
public interface ISenddispatcherDAOManager 
{
	Senddispatcher findSendDispatcherById(int sdid);	//根据sdid查询派送调度信息
	ArrayList<Senddispatcher> findAllSendDispatcher();	//查询所有派送调度
	ArrayList<Senddispatcher> findAllSenddispatcherByisdeal();	//根据派送状态查询派送调度信息
	void addSendDispatcher(Senddispatcher sd);	//添加派送调度
	void updSenddispatcher(int sdid,Senddispatcher sd);	//根据sdid修改派送调度
	ArrayList<Send> findAllSend();	//查询所有派送通知
	Send findOneSend(int sid);	//根据sid查询派送通知信息
	void updSendById(Send s);	//修改派送通知的派送状态
	void updOrderById(Orders o);	//修改订单入库状态
	Orders findOneOrder(int oid);	//根据oid查询订单信息
	Senddispatcher findOneSenddispatcher(int sdid);	//根据sdid查询派送调度
}
