package com.sec.ssh.group3.entity;

import java.util.Date;

/**
 * Deliverdispatcher entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Deliverdispatcher implements java.io.Serializable {

	// Fields

	private int drid;
	private Orders orders;
	private Date senddate;
	private Date arrivedate;
	private int isdeliver;
	private String remark;

	// Constructors

	/** default constructor */
	public Deliverdispatcher() {
	}

	/** minimal constructor */
	public Deliverdispatcher(int drid, Orders orders, Date senddate,
			Date arrivedate, int isdeliver) {
		this.drid = drid;
		this.orders = orders;
		this.senddate = senddate;
		this.arrivedate = arrivedate;
		this.isdeliver = isdeliver;
	}

	/** full constructor */
	public Deliverdispatcher(int drid, Orders orders, Date senddate,
			Date arrivedate, int isdeliver, String remark) {
		this.drid = drid;
		this.orders = orders;
		this.senddate = senddate;
		this.arrivedate = arrivedate;
		this.isdeliver = isdeliver;
		this.remark = remark;
	}

	// Property accessors

	public int getDrid() {
		return this.drid;
	}

	public void setDrid(int drid) {
		this.drid = drid;
	}

	public Orders getOrders() {
		return this.orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public Date getSenddate() {
		return this.senddate;
	}

	public void setSenddate(Date senddate) {
		this.senddate = senddate;
	}

	public Date getArrivedate() {
		return this.arrivedate;
	}

	public void setArrivedate(Date arrivedate) {
		this.arrivedate = arrivedate;
	}

	public int getIsdeliver() {
		return this.isdeliver;
	}

	public void setIsdeliver(int isdeliver) {
		this.isdeliver = isdeliver;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}