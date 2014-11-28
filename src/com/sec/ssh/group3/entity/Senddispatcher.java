package com.sec.ssh.group3.entity;

import java.util.Date;

/**
 * Senddispatcher entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Senddispatcher implements java.io.Serializable {

	// Fields

	private int sdid;
	private Orders orders;
	private Date senddate;
	private Date arrivedate;
	private String freightstation;
	private int isdeal;
	private String remark;

	// Constructors

	/** default constructor */
	public Senddispatcher() {
	}

	/** minimal constructor */
	public Senddispatcher(int sdid, Orders orders, Date senddate,
			Date arrivedate, int isdeal) {
		this.sdid = sdid;
		this.orders = orders;
		this.senddate = senddate;
		this.arrivedate = arrivedate;
		this.isdeal = isdeal;
	}

	/** full constructor */
	public Senddispatcher(int sdid, Orders orders, Date senddate,
			Date arrivedate, String freightstation, int isdeal, String remark) {
		this.sdid = sdid;
		this.orders = orders;
		this.senddate = senddate;
		this.arrivedate = arrivedate;
		this.freightstation = freightstation;
		this.isdeal = isdeal;
		this.remark = remark;
	}

	// Property accessors

	public int getSdid() {
		return this.sdid;
	}

	public void setSdid(int sdid) {
		this.sdid = sdid;
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

	public String getFreightstation() {
		return this.freightstation;
	}

	public void setFreightstation(String freightstation) {
		this.freightstation = freightstation;
	}

	public int getIsdeal() {
		return this.isdeal;
	}

	public void setIsdeal(int isdeal) {
		this.isdeal = isdeal;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}