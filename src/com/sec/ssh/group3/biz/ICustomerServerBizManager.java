package com.sec.ssh.group3.biz;
import java.util.*;

import com.sec.ssh.group3.entity.*;
/*
 * ��ǿ���ͷ�����Interface��
 */
public interface ICustomerServerBizManager
{
	ArrayList<Warehouse> findOrderNoSend();//����֪ͨ ���������б�
	ArrayList<Send> findOrderOkSend();// �鿴����֪ͨ ,,ֱ�� �ղ�Ҫ�κ�id  ��ѯsend ����
	ArrayList<Send>findOrderNoDeliver();//���֪ͨ���� �����б�
	ArrayList<Deliver>findOrderOkDeliver();//�鿴���֪ͨ �������Ѿ�����б�
	ArrayList<Orders>findOrderEnterWarehouse();//�����Ϣ ��ѯ�б�
	ArrayList<Sendsign>findOrderArrive();//�����鿴 �б�
	void  addOrder(Orders s);//���붩���� ����ע��ҲҪ�����ջ�����
	void  addDeliver(List<Deliver> d);//���֪ͨ����
	void  addSend(List<Send> s); //����֪ͨ����
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
