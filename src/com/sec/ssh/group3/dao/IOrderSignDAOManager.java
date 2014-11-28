package com.sec.ssh.group3.dao;

import java.util.ArrayList;

import com.sec.ssh.group3.entity.Orders;
import com.sec.ssh.group3.entity.Ordersign;
import com.sec.ssh.group3.entity.User;
import com.sec.ssh.group3.entity.Warehouse;
/*
 * 耀坤（入库签收DAO接口）
 */
public interface IOrderSignDAOManager 
{
	   Warehouse  findWarehouseById(int wid);
	   void add(Ordersign s);//入库签收
	   User findId(String roleid);
	   Orders findId(int oid);
	   void update(Warehouse wh);
	   void update_sign(Ordersign sign);
	   ArrayList<Warehouse> findAll();
}
