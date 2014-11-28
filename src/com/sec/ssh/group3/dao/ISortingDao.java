package com.sec.ssh.group3.dao;

import java.util.ArrayList;

import com.sec.ssh.group3.entity.*;
/*
 * ���䣨�ּ����DAO�ӿڣ�
 */
public interface ISortingDao 
{
	   ArrayList<Sorting> findAllRecord();
	   void addSorting(Sorting s);
	   void updateSorting(Sorting s);
	   Sorting findSortingById(int sid);
	   ArrayList<Warehouse> findSortingDo();
	   void updWarehouse(Warehouse w);
	   Warehouse findWarehouseById(int whid);
	   User findUserById(String uid);
}
