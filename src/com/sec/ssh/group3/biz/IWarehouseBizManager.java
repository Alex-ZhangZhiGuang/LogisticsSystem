package com.sec.ssh.group3.biz;
import java.util.ArrayList;
import java.util.List;

import com.sec.ssh.group3.entity.*;
/*
 * �ٻԣ��ֿ����Interface��
 */
public interface IWarehouseBizManager
{
    public   Warehouse findId(int id);//��ѯ����
    public Orders findOrderId(int oid);//��ѯ����������¼
    public   void  addWhs(List<Warehouse> ws);//������
    public   ArrayList<Warehouse> findWareAll();//��ѯ����¼
    public  ArrayList<Orders> findOrderAllNotRk();//��ѯδ���ȫ��
    public ArrayList<Orders> findOrderAll();
    public   ArrayList<Warehouse> findWareAllNotCk();//��ѯδ����ȫ��
    public  void  wupdate(List<Warehouse> ws);//�޸��Ƿ����״̬
    public  void  update(List<Orders> os);//�޸�������״̬
}
