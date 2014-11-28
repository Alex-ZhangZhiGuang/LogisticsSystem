package com.sec.ssh.group3.entity;

import java.util.Date;

/**
 * Sorting entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Sorting implements java.io.Serializable {

	// Fields

	private int sortid;
	private User user;
	private Orders orders;
	private String weight;
	private String paidweight;
	private int productnumber;
	private Date sortingdate;
	private Date sortingtime;
	private String remark;

	// Constructors

	/** default constructor */
	public Sorting() {
	}

	/** minimal constructor */
	public Sorting(int sortid, User user, Orders orders, String weight,
			String paidweight, int productnumber, Date sortingdate,
			Date sortingtime) {
		this.sortid = sortid;
		this.user = user;
		this.orders = orders;
		this.weight = weight;
		this.paidweight = paidweight;
		this.productnumber = productnumber;
		this.sortingdate = sortingdate;
		this.sortingtime = sortingtime;
	}

	/** full constructor */
	public Sorting(int sortid, User user, Orders orders, String weight,
			String paidweight, int productnumber, Date sortingdate,
			Date sortingtime, String remark) {
		this.sortid = sortid;
		this.user = user;
		this.orders = orders;
		this.weight = weight;
		this.paidweight = paidweight;
		this.productnumber = productnumber;
		this.sortingdate = sortingdate;
		this.sortingtime = sortingtime;
		this.remark = remark;
	}

	// Property accessors

	public int getSortid() {
		return this.sortid;
	}

	public void setSortid(int sortid) {
		this.sortid = sortid;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Orders getOrders() {
		return this.orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public String getWeight() {
		return this.weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getPaidweight() {
		return this.paidweight;
	}

	public void setPaidweight(String paidweight) {
		this.paidweight = paidweight;
	}

	public int getProductnumber() {
		return this.productnumber;
	}

	public void setProductnumber(int productnumber) {
		this.productnumber = productnumber;
	}

	public Date getSortingdate() {
		return this.sortingdate;
	}

	public void setSortingdate(Date sortingdate) {
		this.sortingdate = sortingdate;
	}

	public Date getSortingtime() {
		return this.sortingtime;
	}

	public void setSortingtime(Date sortingtime) {
		this.sortingtime = sortingtime;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}