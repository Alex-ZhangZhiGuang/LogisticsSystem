package com.sec.ssh.group3.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Customer entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Customer implements java.io.Serializable {

	// Fields

	private int cid;
	private String cnumber;
	private String cname;
	private String cityname;
	private String cphone;
	private String cemail;
	private String cfax;
	private String caddress;
	private String receiptcode;
	private String contactperson;
	private Set orderses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Customer() {
	}

	/** minimal constructor */
	public Customer(int cid, String cnumber, String cname, String cityname,
			String cphone, String caddress, String receiptcode) {
		this.cid = cid;
		this.cnumber = cnumber;
		this.cname = cname;
		this.cityname = cityname;
		this.cphone = cphone;
		this.caddress = caddress;
		this.receiptcode = receiptcode;
	}

	/** full constructor */
	public Customer(int cid, String cnumber, String cname, String cityname,
			String cphone, String cemail, String cfax, String caddress,
			String receiptcode, String contactperson, Set orderses) {
		this.cid = cid;
		this.cnumber = cnumber;
		this.cname = cname;
		this.cityname = cityname;
		this.cphone = cphone;
		this.cemail = cemail;
		this.cfax = cfax;
		this.caddress = caddress;
		this.receiptcode = receiptcode;
		this.contactperson = contactperson;
		this.orderses = orderses;
	}

	// Property accessors

	public int getCid() {
		return this.cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCnumber() {
		return this.cnumber;
	}

	public void setCnumber(String cnumber) {
		this.cnumber = cnumber;
	}

	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCityname() {
		return this.cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public String getCphone() {
		return this.cphone;
	}

	public void setCphone(String cphone) {
		this.cphone = cphone;
	}

	public String getCemail() {
		return this.cemail;
	}

	public void setCemail(String cemail) {
		this.cemail = cemail;
	}

	public String getCfax() {
		return this.cfax;
	}

	public void setCfax(String cfax) {
		this.cfax = cfax;
	}

	public String getCaddress() {
		return this.caddress;
	}

	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}

	public String getReceiptcode() {
		return this.receiptcode;
	}

	public void setReceiptcode(String receiptcode) {
		this.receiptcode = receiptcode;
	}

	public String getContactperson() {
		return this.contactperson;
	}

	public void setContactperson(String contactperson) {
		this.contactperson = contactperson;
	}

	public Set getOrderses() {
		return this.orderses;
	}

	public void setOrderses(Set orderses) {
		this.orderses = orderses;
	}

}