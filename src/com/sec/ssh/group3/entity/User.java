package com.sec.ssh.group3.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * User entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private int userid;
	private String usernumber;
	private String username;
	private String userpwd;
	private String userphone;
	private int isservice;
	private int roleid;
	private String cityname;
	private Date createdate;
	private Set orderses = new HashSet(0);
	private Set sortings = new HashSet(0);
	private Set sendsigns = new HashSet(0);
	private Set ordersigns = new HashSet(0);
	private Set delivers = new HashSet(0);
	private Set sends = new HashSet(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(int userid, String usernumber, String username,
			String userphone, int isservice, int roleid, String cityname,
			Date createdate) {
		this.userid = userid;
		this.usernumber = usernumber;
		this.username = username;
		this.userphone = userphone;
		this.isservice = isservice;
		this.roleid = roleid;
		this.cityname = cityname;
		this.createdate = createdate;
	}

	/** full constructor */
	public User(int userid, String usernumber, String username,
			String userpwd, String userphone, int isservice, int roleid,
			String cityname, Date createdate, Set orderses, Set sortings,
			Set sendsigns, Set ordersigns, Set delivers, Set sends) {
		this.userid = userid;
		this.usernumber = usernumber;
		this.username = username;
		this.userpwd = userpwd;
		this.userphone = userphone;
		this.isservice = isservice;
		this.roleid = roleid;
		this.cityname = cityname;
		this.createdate = createdate;
		this.orderses = orderses;
		this.sortings = sortings;
		this.sendsigns = sendsigns;
		this.ordersigns = ordersigns;
		this.delivers = delivers;
		this.sends = sends;
	}

	// Property accessors

	public int getUserid() {
		return this.userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsernumber() {
		return this.usernumber;
	}

	public void setUsernumber(String usernumber) {
		this.usernumber = usernumber;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpwd() {
		return this.userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	public String getUserphone() {
		return this.userphone;
	}

	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}

	public int getIsservice() {
		return this.isservice;
	}

	public void setIsservice(int isservice) {
		this.isservice = isservice;
	}

	public int getRoleid() {
		return this.roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public String getCityname() {
		return this.cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public Date getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public Set getOrderses() {
		return this.orderses;
	}

	public void setOrderses(Set orderses) {
		this.orderses = orderses;
	}

	public Set getSortings() {
		return this.sortings;
	}

	public void setSortings(Set sortings) {
		this.sortings = sortings;
	}

	public Set getSendsigns() {
		return this.sendsigns;
	}

	public void setSendsigns(Set sendsigns) {
		this.sendsigns = sendsigns;
	}

	public Set getOrdersigns() {
		return this.ordersigns;
	}

	public void setOrdersigns(Set ordersigns) {
		this.ordersigns = ordersigns;
	}

	public Set getDelivers() {
		return this.delivers;
	}

	public void setDelivers(Set delivers) {
		this.delivers = delivers;
	}

	public Set getSends() {
		return this.sends;
	}

	public void setSends(Set sends) {
		this.sends = sends;
	}

}