package com.sec.ssh.group3.dao;

import java.util.ArrayList;

import com.sec.ssh.group3.entity.Orders;
import com.sec.ssh.group3.entity.Ordersign;
import com.sec.ssh.group3.entity.User;
import com.sec.ssh.group3.entity.Warehouse;
/*
 * ҫ�������ǩ��DAO�ӿڣ�
 */
public interface IOrderSignDAOManager 
{
	   Warehouse  findWarehouseById(int wid);
	   void add(Ordersign s);//���ǩ��
	   User findId(String roleid);
	   Orders findId(int oid);
	   void update(Warehouse wh);
	   void update_sign(Ordersign sign);
	   ArrayList<Warehouse> findAll();
}
