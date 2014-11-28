package com.sec.ssh.group3.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sec.ssh.group3.biz.ISendSignBizManager;

import com.sec.ssh.group3.entity.Deliver;
import com.sec.ssh.group3.entity.Orders;
import com.sec.ssh.group3.entity.Sendsign;
import com.sec.ssh.group3.entity.User;
/*
 * “´¿§£®≈…ÀÕ«© ’Action£©
 */
public class SendSignAction 
{
	private Sendsign ss;
	private ISendSignBizManager sbbiz;
	private ArrayList<Deliver> list;
	private int oid;
	private int uid;
	private String unumber;
	private User user;
	private String chkAll;
	private int status;
	private Deliver del;
	private String receiptName;
	private Date receiptDate;
	private String remark;
	
	public String findall()
	{
		try 
		{
			list=sbbiz.findYAll();
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
	
	public String add()
	{
		try
		{
			String[] s=this.chkAll.split(", ");
			List<Deliver> dlist=new ArrayList<Deliver>();
			List<Sendsign> slist=new ArrayList<Sendsign>();
			for(String ds:s)
			{
				Sendsign ss=new Sendsign();
				Orders or=new Orders();
				del=sbbiz.findDeliverId(Integer.valueOf(ds));
				or.setOid(del.getOrders().getOid());
				ss.setOrders(or);
				User us=sbbiz.findId(unumber);
				ss.setUser(us);
				ss.setStatus(status);
				ss.setReceiptname(receiptName);
				ss.setReceiptdate(receiptDate);
				ss.setRemark(remark);
				del.setIssendsigninfo(1);
				dlist.add(del);
				slist.add(ss);
			}
			sbbiz.add(slist);
			sbbiz.update(dlist);
			return "success_add";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "error";
		}
	}

	public String getUnumber() {
		return unumber;
	}

	public void setUnumber(String unumber) {
		this.unumber = unumber;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getChkAll() {
		return chkAll;
	}

	public void setChkAll(String chkAll) {
		this.chkAll = chkAll;
	}

	public Deliver getDel() {
		return del;
	}

	public void setDel(Deliver del) {
		this.del = del;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getReceiptName() {
		return receiptName;
	}

	public void setReceiptName(String receiptName) {
		this.receiptName = receiptName;
	}

	public Date getReceiptDate() {
		return receiptDate;
	}

	public void setReceiptDate(Date receiptDate) {
		this.receiptDate = receiptDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Sendsign getSs() {
		return ss;
	}

	public void setSs(Sendsign ss) {
		this.ss = ss;
	}

	
	public ISendSignBizManager getSbbiz() {
		return sbbiz;
	}

	public void setSbbiz(ISendSignBizManager sbbiz) {
		this.sbbiz = sbbiz;
	}

	public ArrayList<Deliver> getList() {
		return list;
	}

	public void setList(ArrayList<Deliver> list) {
		this.list = list;
	}

}
