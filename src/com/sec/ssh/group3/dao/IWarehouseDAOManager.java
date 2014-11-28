package com.sec.ssh.group3.dao;

import java.util.ArrayList;

import com.sec.ssh.group3.entity.Orders;
import com.sec.ssh.group3.entity.Warehouse;
/*
 * 荣辉（仓库管理DAO接口）
 */
public interface IWarehouseDAOManager
{
    public   Warehouse findId(int id);//查询单个
    public Orders findOrderId(int oid);//查询订单表单个记录
    public   void  add(Warehouse w);//添加入仓
    public   ArrayList<Warehouse> findWareAll();//查询入库记录
  
    public  ArrayList<Orders> findOrderAll();//查询全部
    public  ArrayList<Orders> findOrderAllNotRk();//查询未入库全部
  public   ArrayList<Warehouse> findWareAllNotCk();//查询未出库全部
 //   public  ArrayList<Orders> findWOAll(); //查询仓库出库全部
    public  void  update(Warehouse w);//修改是否入库状态
    public  void  update(Orders o);//修改入库完的状态
}
