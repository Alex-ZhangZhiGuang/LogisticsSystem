package com.sec.ssh.group3.biz;
import java.util.ArrayList;
import java.util.List;

import com.sec.ssh.group3.entity.*;
/*
 * ҫ�������ǩ��Interface��
 */
public interface IOrderSignBizManager 
{
	 Warehouse  findWarehouseById(int wid);
	 void add(List<Ordersign> s);//���ǩ��
	 void update(List<Warehouse> wh);
	 void update_sign(List<Ordersign> sign);
	 Orders findId(int oid);
	 User findId(String roleid);
	 ArrayList<Warehouse> findAll();
}
