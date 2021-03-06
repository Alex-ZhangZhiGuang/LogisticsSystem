package com.sec.ssh.group3.dao;

import java.util.ArrayList;

import com.sec.ssh.group3.entity.*;
/*
 * 勇强（客服服务DAO接口）
 */
public interface ICustomerServerDAO
{
	ArrayList<Warehouse> findOrderNoSend();//派送通知 ，，派送列表
	ArrayList<Send> findOrderOkSend();// 查看派送通知 ,,直接 收不要任何id  查询send 表。。
	ArrayList<Send>findOrderNoDeliver();//提货通知。。 派送列表
	ArrayList<Deliver>findOrderOkDeliver();//查看提货通知 ，，，已经提货列表
	ArrayList<Orders>findOrderEnterWarehouse();//入库信息 查询列表
	ArrayList<Sendsign>findOrderArrive();//到货查看 列表
	void  addOrder(Orders s);//插入订单表 ，，注意也要插入收货表。。
	void  addDeliver(Deliver d);//提货通知插入
	void  addSend(Send s); //派送通知插入
    Orders findOrderById(String  oid);
	void updSend(Send s);
	Send  findSendinfoByOid(String oid);
	//user
	User findByUserId(String unumber);
	User  findByUserId(int uid);
	//whose
	void   updWarehouseState(Warehouse w);	
	Warehouse  findWarehouserInfoByOid(int oid);
   //cnum
	  Customer findCustomerById(String  cnum);
	  ArrayList <Customer> findAllCustomer();
	  //oc
	  void addOrderCustomer(Ordercustomer oc);
	  //Deliverdispatcher
	  Deliverdispatcher findDeliverdispatcher(int oid);
	  void updDeliverdispatcher(Deliverdispatcher d);
}
