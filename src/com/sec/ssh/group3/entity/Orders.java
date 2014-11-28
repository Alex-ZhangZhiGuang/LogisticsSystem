package com.sec.ssh.group3.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Orders entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Orders implements java.io.Serializable {

	// Fields

	private int oid;
	private User user;
	private Customer customer;
	private String onumber;
	private String zipcode;
	private Date trustdate;
	private String trustid;
	private String transporttype;
	private String producttype;
	private int productname;
	private Date createdate;
	private String arrivaldate;
	private int statuswarehouse;
	private String remark;
	private Set warehouses = new HashSet(0);
	private Set ordercustomers = new HashSet(0);
	private Set sendsigns = new HashSet(0);
	private Set sortings = new HashSet(0);
	private Set deliverdispatchers = new HashSet(0);
	private Set ordersigns = new HashSet(0);
	private Set delivers = new HashSet(0);
	private Set sends = new HashSet(0);
	private Set senddispatchers = new HashSet(0);
	private String firstadress;
	private String customerphone;
	private String customername;
	private String whsNumbeId;
	
	
	
	public String getWhsNumbeId() {
		if (warehouses==null||warehouses.isEmpty())
			return "Пе";
		return ((Warehouse) warehouses.iterator().next()).getWhnumber();
	}

	public void setWhsNumbeId(String whsNumbeId) {
		this.whsNumbeId = whsNumbeId;
	}

	public String getCustomerphone() {
		if (ordercustomers==null||ordercustomers.isEmpty())
			return "Пе";
		return ((Ordercustomer) ordercustomers.iterator().next()).getOcphone();
	}

	public void setCustomerphone(String customerphone) {
		this.customerphone = customerphone;
	}

	public String getCustomername() {
		if (ordercustomers==null||ordercustomers.isEmpty())
			return "Пе";
		return ((Ordercustomer) ordercustomers.iterator().next()).getOcname();
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getFirstadress() {
		if (ordercustomers==null||ordercustomers.isEmpty())
			return "Пе";
		return ((Ordercustomer) ordercustomers.iterator().next()).getOcaddress();
	}

	public void setFirstadress(String firstadress) {
		this.firstadress = firstadress;
	}



	// Constructors

	/** default constructor */
	public Orders() {
	}

	/** minimal constructor */
	public Orders(int oid, User user, Customer customer, String onumber,
			String zipcode, Date trustdate, String transporttype,
			String producttype, int productname, Date createdate,
			String arrivaldate, int statuswarehouse) {
		this.oid = oid;
		this.user = user;
		this.customer = customer;
		this.onumber = onumber;
		this.zipcode = zipcode;
		this.trustdate = trustdate;
		this.transporttype = transporttype;
		this.producttype = producttype;
		this.productname = productname;
		this.createdate = createdate;
		this.arrivaldate = arrivaldate;
		this.statuswarehouse = statuswarehouse;
	}

	/** full constructor */
	public Orders(int oid, User user, Customer customer, String onumber,
			String zipcode, Date trustdate, String trustid,
			String transporttype, String producttype, int productname,
			Date createdate, String arrivaldate, int statuswarehouse,
			String remark, Set warehouses, Set ordercustomers, Set sendsigns,
			Set sortings, Set deliverdispatchers, Set ordersigns, Set delivers,
			Set sends, Set senddispatchers) {
		this.oid = oid;
		this.user = user;
		this.customer = customer;
		this.onumber = onumber;
		this.zipcode = zipcode;
		this.trustdate = trustdate;
		this.trustid = trustid;
		this.transporttype = transporttype;
		this.producttype = producttype;
		this.productname = productname;
		this.createdate = createdate;
		this.arrivaldate = arrivaldate;
		this.statuswarehouse = statuswarehouse;
		this.remark = remark;
		this.warehouses = warehouses;
		this.ordercustomers = ordercustomers;
		this.sendsigns = sendsigns;
		this.sortings = sortings;
		this.deliverdispatchers = deliverdispatchers;
		this.ordersigns = ordersigns;
		this.delivers = delivers;
		this.sends = sends;
		this.senddispatchers = senddispatchers;
	}

	// Property accessors

	public int getOid() {
		return this.oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getOnumber() {
		return this.onumber;
	}

	public void setOnumber(String onumber) {
		this.onumber = onumber;
	}

	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public Date getTrustdate() {
		return this.trustdate;
	}

	public void setTrustdate(Date trustdate) {
		this.trustdate = trustdate;
	}

	public String getTrustid() {
		return this.trustid;
	}

	public void setTrustid(String trustid) {
		this.trustid = trustid;
	}

	public String getTransporttype() {
		return this.transporttype;
	}

	public void setTransporttype(String transporttype) {
		this.transporttype = transporttype;
	}

	public String getProducttype() {
		return this.producttype;
	}

	public void setProducttype(String producttype) {
		this.producttype = producttype;
	}

	public int getProductname() {
		return this.productname;
	}

	public void setProductname(int productname) {
		this.productname = productname;
	}

	public Date getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public String getArrivaldate() {
		return this.arrivaldate;
	}

	public void setArrivaldate(String arrivaldate) {
		this.arrivaldate = arrivaldate;
	}

	public int getStatuswarehouse() {
		return this.statuswarehouse;
	}

	public void setStatuswarehouse(int statuswarehouse) {
		this.statuswarehouse = statuswarehouse;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Set getWarehouses() {
		return this.warehouses;
	}

	public void setWarehouses(Set warehouses) {
		this.warehouses = warehouses;
	}

	public Set getOrdercustomers() {
		return this.ordercustomers;
	}

	public void setOrdercustomers(Set ordercustomers) {
		this.ordercustomers = ordercustomers;
	}

	public Set getSendsigns() {
		return this.sendsigns;
	}

	public void setSendsigns(Set sendsigns) {
		this.sendsigns = sendsigns;
	}

	public Set getSortings() {
		return this.sortings;
	}

	public void setSortings(Set sortings) {
		this.sortings = sortings;
	}

	public Set getDeliverdispatchers() {
		return this.deliverdispatchers;
	}

	public void setDeliverdispatchers(Set deliverdispatchers) {
		this.deliverdispatchers = deliverdispatchers;
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

	public Set getSenddispatchers() {
		return this.senddispatchers;
	}

	public void setSenddispatchers(Set senddispatchers) {
		this.senddispatchers = senddispatchers;
	}

}