package com.sec.ssh.group3.dao;

import java.util.ArrayList;

import com.sec.ssh.group3.entity.Deliver;
import com.sec.ssh.group3.entity.Ordersign;
import com.sec.ssh.group3.entity.Sendsign;
import com.sec.ssh.group3.entity.User;
import com.sec.ssh.group3.entity.Warehouse;
/*
 * 耀坤（派送签收DAO接口）
 */
public interface ISendSignDAOManager
{
	Deliver  findDeliverId(int did);
	  void add(Sendsign ss);
	  User findId(String roleid);
	  void update(Deliver dlr);
	   ArrayList<Deliver> findYAll();//查询派送未签收的
}
