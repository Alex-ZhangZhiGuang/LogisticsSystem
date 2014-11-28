package com.sec.ssh.group3.biz;
import java.util.ArrayList;
import java.util.List;

import com.sec.ssh.group3.entity.*;
/*
 * 耀坤（入库签收Interface）
 */
public interface IOrderSignBizManager 
{
	 Warehouse  findWarehouseById(int wid);
	 void add(List<Ordersign> s);//入库签收
	 void update(List<Warehouse> wh);
	 void update_sign(List<Ordersign> sign);
	 Orders findId(int oid);
	 User findId(String roleid);
	 ArrayList<Warehouse> findAll();
}
