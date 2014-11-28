package com.sec.ssh.group3.dao;

import java.util.ArrayList;

import com.sec.ssh.group3.entity.*;
/*
 * ��ǿ���ͷ�����DAO�ӿڣ�
 */
public interface ICustomerServerDAO
{
	ArrayList<Warehouse> findOrderNoSend();//����֪ͨ ���������б�
	ArrayList<Send> findOrderOkSend();// �鿴����֪ͨ ,,ֱ�� �ղ�Ҫ�κ�id  ��ѯsend ������
	ArrayList<Send>findOrderNoDeliver();//���֪ͨ���� �����б�
	ArrayList<Deliver>findOrderOkDeliver();//�鿴���֪ͨ �������Ѿ�����б�
	ArrayList<Orders>findOrderEnterWarehouse();//�����Ϣ ��ѯ�б�
	ArrayList<Sendsign>findOrderArrive();//�����鿴 �б�
	void  addOrder(Orders s);//���붩���� ����ע��ҲҪ�����ջ�������
	void  addDeliver(Deliver d);//���֪ͨ����
	void  addSend(Send s); //����֪ͨ����
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