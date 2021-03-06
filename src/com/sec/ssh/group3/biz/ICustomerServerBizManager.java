package com.sec.ssh.group3.biz;
import java.util.*;

import com.sec.ssh.group3.entity.*;
/*
 * 勇强（客服服务Interface）
 */
public interface ICustomerServerBizManager
{
	ArrayList<Warehouse> findOrderNoSend();//派送通知 ，，派送列表
	ArrayList<Send> findOrderOkSend();// 查看派送通知 ,,直接 收不要任何id  查询send 表。。
	ArrayList<Send>findOrderNoDeliver();//提货通知。。 派送列表
	ArrayList<Deliver>findOrderOkDeliver();//查看提货通知 ，，，已经提货列表
	ArrayList<Orders>findOrderEnterWarehouse();//入库信息 查询列表
	ArrayList<Sendsign>findOrderArrive();//到货查看 列表
	void  addOrder(Orders s);//插入订单表 ，，注意也要插入收货表。。
	void  addDeliver(List<Deliver> d);//提货通知插入
	void  addSend(List<Send> s); //派送通知插入
	Orders findOrderById(String  string);
	void updSend(List<Send> s);
	Send  findSendinfoByOid(String oid);
	//userbiz
	User findByUserId(String unumber);
	User  findByUserId(int uid);
	//whouse
	void   updWarehouseState(List<Warehouse> w);	
	Warehouse  findWarehouserInfoByOid(int oid);
	//cnum
	  Customer findCustomerById(String  cnum);
	  ArrayList <Customer> findAllCustomer();
	//oc
	  void addOrderCustomer(Ordercustomer oc);
	 //devliver
	  Deliverdispatcher findDeliverdispatcher(int oid);
	  void updDeliverdispatcher(Deliverdispatcher d);
	  
}
