package com.sec.ssh.group3.biz;
import java.util.ArrayList;
import java.util.List;

import com.sec.ssh.group3.entity.*;
/*
 * 荣辉（仓库管理Interface）
 */
public interface IWarehouseBizManager
{
    public   Warehouse findId(int id);//查询单个
    public Orders findOrderId(int oid);//查询订单表单个记录
    public   void  addWhs(List<Warehouse> ws);//添加入仓
    public   ArrayList<Warehouse> findWareAll();//查询入库记录
    public  ArrayList<Orders> findOrderAllNotRk();//查询未入库全部
    public ArrayList<Orders> findOrderAll();
    public   ArrayList<Warehouse> findWareAllNotCk();//查询未出库全部
    public  void  wupdate(List<Warehouse> ws);//修改是否入库状态
    public  void  update(List<Orders> os);//修改入库完的状态
}
