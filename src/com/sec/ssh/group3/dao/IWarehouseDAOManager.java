package com.sec.ssh.group3.dao;

import java.util.ArrayList;

import com.sec.ssh.group3.entity.Orders;
import com.sec.ssh.group3.entity.Warehouse;
/*
 * �ٻԣ��ֿ����DAO�ӿڣ�
 */
public interface IWarehouseDAOManager
{
    public   Warehouse findId(int id);//��ѯ����
    public Orders findOrderId(int oid);//��ѯ����������¼
    public   void  add(Warehouse w);//������
    public   ArrayList<Warehouse> findWareAll();//��ѯ����¼
  
    public  ArrayList<Orders> findOrderAll();//��ѯȫ��
    public  ArrayList<Orders> findOrderAllNotRk();//��ѯδ���ȫ��
  public   ArrayList<Warehouse> findWareAllNotCk();//��ѯδ����ȫ��
 //   public  ArrayList<Orders> findWOAll(); //��ѯ�ֿ����ȫ��
    public  void  update(Warehouse w);//�޸��Ƿ����״̬
    public  void  update(Orders o);//�޸�������״̬
}
