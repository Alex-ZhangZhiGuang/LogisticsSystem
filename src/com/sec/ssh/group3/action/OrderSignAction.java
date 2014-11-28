package com.sec.ssh.group3.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import com.sec.ssh.group3.biz.IOrderSignBizManager;
import com.sec.ssh.group3.entity.Orders;
import com.sec.ssh.group3.entity.Ordersign;
import com.sec.ssh.group3.entity.User;
import com.sec.ssh.group3.entity.Warehouse;
/*
 * Ò«À¤£¨Èë¿âÇ©ÊÕAction£©
 */
public class OrderSignAction 
{
	private Warehouse wh;
	private IOrderSignBizManager biz;
	private ArrayList<Warehouse> list;
	private ArrayList<Ordersign> silist;
	private int oid;
	private int uid;
	private String unumber;
	private int osid;
	private User user;
	private Orders orders;
	private Date signdate;
	private String chkAll;
	private Warehouse whe;
	
	public String findall()
	{
		try
		{
			list=biz.findAll();
			if(list.size()>0)
				return "findAll_success";
			return "error";
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return "error";
		}
	}
	public String addo()
	{
		try
		{
			String[] ss=this.chkAll.split(", ");
			List<Warehouse> wlist=new ArrayList<Warehouse>();
			List<Ordersign> olist=new ArrayList<Ordersign>();
			List<User> ulist=new ArrayList<User>();
			for(String s:ss)
			{
				System.out.println(s);
				Ordersign osn=new Ordersign();
				whe=biz.findWarehouseById(Integer.valueOf(s));
				Orders os=new Orders();
				os.setOid(whe.getOrders().getOid());
				osn.setOrders(os);
				User u=new User();
				 user=biz.findId(unumber);
				osn.setUser(user);
				osn.setSigndate(signdate);
				whe.setIssign(1);
				wlist.add(whe);
				olist.add(osn);
				wlist.add(whe);
				olist.add(osn);
			}
			biz.add(olist);
			biz.update(wlist);
			return "success_add";
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return "error";
		}
	}
	public Warehouse getWh() {
		return wh;
	}

	public void setWh(Warehouse wh) {
		this.wh = wh;
	}

	public IOrderSignBizManager getBiz() {
		return biz;
	}

	public void setBiz(IOrderSignBizManager biz) {
		this.biz = biz;
	}

	public ArrayList<Warehouse> getList() {
		return list;
	}

	public void setList(ArrayList<Warehouse> list) {
		this.list = list;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public Warehouse getWhe() {
		return whe;
	}
	public void setWhe(Warehouse whe) {
		this.whe = whe;
	}
	public String getUnumber() {
		return unumber;
	}
	public void setUnumber(String unumber) {
		this.unumber = unumber;
	}
	public ArrayList<Ordersign> getSilist() 
	{
		return silist;
	}
	public void setSilist(ArrayList<Ordersign> silist) 
	{
		this.silist = silist;
	}
	public String getChkAll() {
		return chkAll;
	}
	public void setChkAll(String chkAll) {
		this.chkAll = chkAll;
	}
	public int getOsid() {
		return osid;
	}
	public void setOsid(int osid) {
		this.osid = osid;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	public Date getSigndate() {
		return signdate;
	}
	public void setSigndate(Date signdate) {
		this.signdate = signdate;
	}
}
