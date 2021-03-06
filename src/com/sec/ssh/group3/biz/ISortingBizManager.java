package com.sec.ssh.group3.biz;
import java.util.ArrayList;
import java.util.List;

import com.sec.ssh.group3.entity.*;
/*
 * ���䣨�ּ����Interface��
 */
public interface ISortingBizManager 
{
	   ArrayList<Sorting> findAllRecord();
	   void addSorting(List<Sorting> s);
	   void updateSorting(Sorting s);
	   Sorting findSortingById(int sid);
       ArrayList<Warehouse> findSortingDo();
       void updWarehouse(List<Warehouse> w);
       Warehouse findWarehouseById(int whid);
       User findUserById(String uid);
}
