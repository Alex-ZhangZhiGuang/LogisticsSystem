package com.sec.ssh.group3.biz;
import com.sec.ssh.group3.entity.*;

import java.util.*;
/*
 * 巧丽（提货调度Interface）
 */
public interface IDeliverdispatcherBizManager 
{
	Deliverdispatcher findDeliverDispatcherById(int drid);	//根据drid查询提货调度
	ArrayList<Deliverdispatcher> findAllDeliverDispatcher();	//查询所有提货调度
	void addDeliverDispatchers(List<Deliverdispatcher> dr);	//添加提货调度信息
	Senddispatcher findOneSenddispatcher(int sdid);	//根据sdid查询派送调度
	void updSenddispatcherById(List<Senddispatcher> sd);	//修改派送调度派送状态
	void updOrderById(List<Orders> o);	//修改订单入库状态
	Orders findOneOrder(int oid);	//根据oid查询订单信息
}
