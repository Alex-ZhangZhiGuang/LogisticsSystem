package com.sec.ssh.group3.action;

import java.util.*;

import com.opensymphony.xwork2.ActionContext;
import com.sec.ssh.group3.utils.*;

import com.sec.ssh.group3.biz.ICustomerServerBizManager;


import com.sec.ssh.group3.entity.*;
/*
 * 勇强（客服服务Action）
 */
public class CustomerServerAction 
{
   //所有显示的list
   private ArrayList<Orders> olist;
   private ArrayList<Customer> clist;
   private ArrayList<Ordercustomer> oclist;
   private ArrayList<Send> slist;
   private ArrayList<Sendsign> sglist;
   private ArrayList<Deliver> dlist;
   private ArrayList<Warehouse> wlist;
   private ICustomerServerBizManager biz;
  //订单表的属性 
   private int cid;
   private String cnumber;
   private int uid;
   private String transport;
   private String cname;
   private String phone;
   private String zipCode;
   private String address;
   private int productNum;
   private String productType;
   private String arrivalTime;
   private String trustId;
   private Date trustDate;
   private String orderRemark;
  //派送表的属性
   private String chkAll;
   private Date arriveDate;
   private String unumber;
   private String transitCity;
   private String transportNumber;
   //提货表的属性
   //unumber
   //chkAll
    private Date deliveryDate;
    private String remark;
    //模糊查询属性
    private String onum;
    private String cusid;
    private String cusname;
    private String cuscode;
    private String cusphone;
    private String cuscity;
	private SearchTool stool;
	private Page page;
	private int  pageFirst;//首页
	private int  backPage;// 
	private int  nextPage;//
	private int  nowPage=0;
	private int selecti;
	public String findAllByTools()
	{	
		List<Object> ol = new ArrayList<Object>();
		try
		{
			HashMap<String, String> contidions = new HashMap<String, String>();
			contidions.put("u.onumber", onum);
			contidions.put("u.ordercustomers.ocname", cusname);
			contidions.put("u.customer.cnumber ", cusid);
			contidions.put("u.zipcode ", cuscode);
			contidions.put("u.customer.cphone", cusphone);
			contidions.put("u.ordercustomers.ocaddress", cuscity);
			ol=stool.search(contidions,"Orders");
			ArrayList<Orders>  oslist= new ArrayList<Orders>();
			for (Object o : ol) 
			{
				Orders os = new Orders();
				os = (Orders) o;
				oslist.add(os);
			}
			olist=oslist;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "suc_EnterWarehouse";
	}
	public String findAlldetailOrder()
	{
		//detailOrder查看入库操作的信息>入库详情
		return "suc_detailOrder";
	}
	
	public String addDeliver()
	{
		try
		{
		   String[] str=chkAll.split(", ");
		   slist=new ArrayList<Send>();
		   dlist=new ArrayList<Deliver>();
		   for(String s:str)
		   {
			   Send send=biz.findSendinfoByOid(s);
			   Deliverdispatcher dl=biz.findDeliverdispatcher(send.getOrders().getOid());
			   Orders o=new Orders();
			   o.setOid(send.getOrders().getOid());
			   Deliver d=new Deliver();
			   d.setDeliverydate(deliveryDate);
			   d.setRemark(remark);
			   d.setOrders(o);
			   User u=biz.findByUserId(unumber);
			   d.setUser(u);
			   d.setIssendsigninfo(0);
			   send.setIsdeal(1);
			   if(dl!=null)
			   {
				   dl.setIsdeliver(1);
				   biz.updDeliverdispatcher(dl);
			   }
			   slist.add(send);
			   dlist.add(d);
		   }
		   biz.addDeliver(dlist);
		   biz.updSend(slist);
		   return "suc_addDeliver";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "error";
		}
	}
    public String addSendCall()
    {
		try
		{
		   String[] str=chkAll.split(", ");
		   slist=new ArrayList<Send>();
		   wlist=new ArrayList<Warehouse>();
		   for(String s:str)
		   {
			   Send send=new Send();
			   Warehouse w= biz.findWarehouserInfoByOid(Integer.valueOf(s));
			   send.setArrivedate(arriveDate);
			   send.setIsdeal(0);
			   Orders o=new Orders();
			   o.setOid(w.getOrders().getOid());
			   send.setOrders(o);
			   if(transitCity.equals("")||transitCity==null)
		       {
		    	   
		       }
		       else
		       {
		    	   send.setTransitcity(transitCity);
		       }
		    	User u= biz.findByUserId(unumber);
		    	send.setUser(u);
		    	send.setTransportnumber(transportNumber);
		        w.setIssendinfo(1);
		        wlist.add(w);
		        slist.add(send);
		   }
		   biz.addSend(slist);
	       biz.updWarehouseState(wlist);
	       return "suc_addSend";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "error";
		}
   }
   public String addOrder()
   {
	   try
	   {
		    Orders o= new Orders();
		    o.setArrivaldate(arrivalTime);
		    o.setOnumber(makeOrderNum.makeOrderNum());
		    o.setTransporttype(transport);
		    o.setZipcode(zipCode);
		    o.setProductname(productNum);
		    o.setProducttype(productType);
		    o.setTrustid(trustId);
		    o.setTrustdate(trustDate);
		    o.setRemark(orderRemark);
		    o.setCreatedate(new Date());
		    o.setStatuswarehouse(0);
		    Customer c=biz.findCustomerById(cnumber);
		    User  u= biz.findByUserId(uid);
		    o.setUser(u);
		    o.setCustomer(c);
		    biz.addOrder(o);
		    Ordercustomer oc= new Ordercustomer();
		    oc.setOcaddress(address);
		    oc.setOcname(cname);
		    oc.setOrders(o);
		    oc.setOcphone(phone);
		    oc.setRefceiptcode(c.getReceiptcode());
		    biz.addOrderCustomer(oc);
		    return "suc_add";
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
		   return "error";
	   }
   }
   public String findAllCustoermerNo()
   {
	   try
	   {
		   
		   User u = (User) ActionContext.getContext().getSession().get("user");
		   uid=u.getUserid();
		   System.out.println("查询客户编号列表");
		   clist=biz.findAllCustomer();
		   if(clist.size()>0)
			   return "suc_CustoermerNo";
		   return "error";
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
		   return "error";
	   }
   }

   public String findAllNoSend()
   {   
	   try
	   {
		   System.out.println("派送通知列表");
		   wlist=biz.findOrderNoSend();
		   if(wlist.size()>0)
			   return "suc_NoSend";
		   return "error";
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
		   return "error";
	   }
   }
   //查看入库信息（分页）
	public String findOrderEnterWarehouse()
	{
		List<Object> ol = new ArrayList<Object>();
		try
		{
			olist=biz.findOrderEnterWarehouse();
			page.setListsize(olist.size());
			ArrayList<Orders>  oslist= new ArrayList<Orders>();
			if(selecti==2)
			{
			    nextPage=nowPage+1;
			    nowPage=nextPage;
			    page.setNextPage(nextPage);
			    nowPage=nextPage;
			}
			if(selecti==1)
			{
				backPage=nowPage-1;
				page.setBackPage(backPage);
				nowPage=backPage;
			}
			if(selecti==3)
			{
				nowPage=page.getPageye();
			}
			ol=page.search(selecti,"Orders");
			for (Object o : ol) 
			{
				Orders os = new Orders();
				os = (Orders) o;
				oslist.add(os);
			}
			if(nowPage<0)
			{
				nowPage=0;
			}
			if(nowPage>page.getPageye())
			{
				nowPage=page.getPageye();
			}
			olist=oslist;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "suc_EnterWarehouse";
	}
   /*public String findOrderEnterWarehouse()
   {
	   try
	   {
		   System.out.println("查看入库信息");
		   olist=biz.findOrderEnterWarehouse();
		   if(olist.size()>0)
			   return "suc_EnterWarehouse";
		   return "error";
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
		   return "error";
	   }
   }*/
	//到货查看模糊查询
	public String findOrderArriveByTools()
	{	
		List<Object> ol = new ArrayList<Object>();
		try
		{
			HashMap<String, String> contidions = new HashMap<String, String>();
			contidions.put("u.orders.onumber", onum);
			contidions.put("u.orders.ordercustomers.ocname", cusname);
			contidions.put("u.orders.customer.cnumber ", cusid);
			contidions.put("u.orders.customer.caddress", cuscity);
			ol=stool.search(contidions,"Sendsign");
			ArrayList<Sendsign>  oslist= new ArrayList<Sendsign>();
			for (Object o : ol) 
			{
				Sendsign os = new Sendsign();
				os = (Sendsign) o;
				oslist.add(os);
			}
			sglist=oslist;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "suc_Arrive";
	}
	//到货查看（分页）
	public String findOrderArrive()
	{
		List<Object> ol = new ArrayList<Object>();
		try
		{
			sglist=biz.findOrderArrive();
			page.setListsize(sglist.size());
			ArrayList<Sendsign>  oslist= new ArrayList<Sendsign>();
			if(selecti==2)
			{
			    nextPage=nowPage+1;
			    nowPage=nextPage;
			    page.setNextPage(nextPage);
			    nowPage=nextPage;
			}
			if(selecti==1)
			{
				backPage=nowPage-1;
				page.setBackPage(backPage);
				nowPage=backPage;
			}
			if(selecti==3)
			{
				nowPage=page.getPageye();
			}
			ol=page.search(selecti,"Sendsign");
			for (Object o : ol) 
			{
				Sendsign os = new Sendsign();
				os = (Sendsign) o;
				oslist.add(os);
			}
			if(nowPage<0)
			{
				nowPage=0;
			}
			if(nowPage>page.getPageye())
			{
				nowPage=page.getPageye();
			}
			sglist=oslist;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "suc_Arrive";
	}
/*   public String findOrderArrive()
   {
	   try
	   {
		   sglist=biz.findOrderArrive();
		   System.out.println("到货查看");
		   if(sglist.size()>0)
			   return "suc_Arrive";
		   return "error";
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
		   return "error";
	   }
	   
   }*/
	
	//查看派送通知(模糊查询)
	public String findOrderOkSendByTools()
	{	
		List<Object> ol = new ArrayList<Object>();
		try
		{
			HashMap<String, String> contidions = new HashMap<String, String>();
			contidions.put("u.orders.onumber", onum);
			contidions.put("u.transportnumber  ", cusid);
			contidions.put("u.orders.ordercustomers.ocaddress", cuscity);
			ol=stool.search(contidions,"Send");
			ArrayList<Send>  oslist= new ArrayList<Send>();
			for (Object o : ol) 
			{
				Send os = new Send();
				os = (Send) o;
				oslist.add(os);
			}
			slist=oslist;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "suc_OkSend";
	}
	//查看派送通知（分页）
	public String findOrderOkSend()
	{
		List<Object> ol = new ArrayList<Object>();
		try
		{
			slist=biz.findOrderOkSend();
			page.setListsize(slist.size());
			ArrayList<Send>  oslist= new ArrayList<Send>();
			if(selecti==2)
			{
			    nextPage=nowPage+1;
			    nowPage=nextPage;
			    page.setNextPage(nextPage);
			    nowPage=nextPage;
			}
			if(selecti==1)
			{
				backPage=nowPage-1;
				page.setBackPage(backPage);
				nowPage=backPage;
			}
			if(selecti==3)
			{
				nowPage=page.getPageye();
			}
			ol=page.search(selecti,"Send");
			for (Object o : ol) 
			{
				Send os = new Send();
				os = (Send) o;
				oslist.add(os);
			}
			if(nowPage<0)
			{
				nowPage=0;
			}
			if(nowPage>page.getPageye())
			{
				nowPage=page.getPageye();
			}
			slist=oslist;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "suc_OkSend";
	}
   /*public String findOrderOkSend()
   {
	   try
	   {
		   System.out.println("查看派送通知"); 
		   slist=biz.findOrderOkSend();
		   if(slist.size()>0)
			   return "suc_OkSend";
		   return "error";
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
		   return "error";
	   }
   }*/
   
	//查看提货通知（分页）
	public String findOrderOkDeliver()
	{
		List<Object> ol = new ArrayList<Object>();
		try
		{
			dlist=biz.findOrderOkDeliver();
			page.setListsize(dlist.size());
			ArrayList<Deliver>  oslist= new ArrayList<Deliver>();
			if(selecti==2)
			{
			    nextPage=nowPage+1;
			    nowPage=nextPage;
			    page.setNextPage(nextPage);
			    nowPage=nextPage;
			}
			if(selecti==1)
			{
				backPage=nowPage-1;
				page.setBackPage(backPage);
				nowPage=backPage;
			}
			if(selecti==3)
			{
				nowPage=page.getPageye();
			}
			ol=page.search(selecti,"Deliver");
			for (Object o : ol) 
			{
				Deliver os = new Deliver();
				os = (Deliver) o;
				oslist.add(os);
			}
			if(nowPage<0)
			{
				nowPage=0;
			}
			if(nowPage>page.getPageye())
			{
				nowPage=page.getPageye();
			}
			dlist=oslist;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "suc_OkDeliver";
	}
/*   public String findOrderOkDeliver()
   {
	   try
	   {
		   System.out.println("查看提货通知"); 
		   dlist=biz.findOrderOkDeliver();
		   if(dlist.size()>0)
			   return "suc_OkDeliver";
		   return "error";
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
		   return "error";
	   }
   }*/
   public String findOrderNoDeliver()
   {
	   System.out.println("提货通知列表");
	   try
	   {
		   slist=biz.findOrderNoDeliver();
		   if(slist.size()>0) 
			   return "suc_NoDeliver";
		   return "error";
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
		   return "error";
	   }
   }

	
	public ICustomerServerBizManager getBiz() {
		return biz;
	}
	
	public void setBiz(ICustomerServerBizManager biz) {
		this.biz = biz;
	}
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getTransport() {
		return transport;
	}
	public void setTransport(String transport) {
		this.transport = transport;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getProductNum() {
		return productNum;
	}
	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	
	public String getTrustId() {
		return trustId;
	}
	public void setTrustId(String trustId) {
		this.trustId = trustId;
	}
	public Date getTrustDate() {
		return trustDate;
	}
	public void setTrustDate(Date trustDate) {
		this.trustDate = trustDate;
	}
	public String getOrderRemark() {
		return orderRemark;
	}
	public void setOrderRemark(String orderRemark) {
		this.orderRemark = orderRemark;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	public String getCnumber() {
		return cnumber;
	}
	public void setCnumber(String cnumber) {
		this.cnumber = cnumber;
	}
	public String getChkAll() {
		return chkAll;
	}
	public void setChkAll(String chkAll) {
		this.chkAll = chkAll;
	}
	public Date getArriveDate() {
		return arriveDate;
	}
	public void setArriveDate(Date arriveDate) {
		this.arriveDate = arriveDate;
	}
	public String getUnumber() {
		return unumber;
	}
	public void setUnumber(String unumber) {
		this.unumber = unumber;
	}
	public String getTransitCity() {
		return transitCity;
	}
	public void setTransitCity(String transitCity) {
		this.transitCity = transitCity;
	}
	public String getTransportNumber() {
		return transportNumber;
	}
	public void setTransportNumber(String transportNumber) {
		this.transportNumber = transportNumber;
	}
	
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public ArrayList<Orders> getOlist() {
		return olist;
	}
	
	public void setOlist(ArrayList<Orders> olist) {
		this.olist = olist;
	}
	
	public ArrayList<Customer> getClist() {
		return clist;
	}
	
	public void setClist(ArrayList<Customer> clist) {
		this.clist = clist;
	}
	
	public ArrayList<Ordercustomer> getOclist() {
		return oclist;
	}
	
	public void setOclist(ArrayList<Ordercustomer> oclist) {
		this.oclist = oclist;
	}
	
	public ArrayList<Send> getSlist() {
		return slist;
	}
	
	public void setSlist(ArrayList<Send> slist) {
		this.slist = slist;
	}
	
	public ArrayList<Sendsign> getSglist() {
		return sglist;
	}
	
	public void setSglist(ArrayList<Sendsign> sglist) {
		this.sglist = sglist;
	}
	
	public ArrayList<Deliver> getDlist() {
		return dlist;
	}
	
	public void setDlist(ArrayList<Deliver> dlist) {
		this.dlist = dlist;
	}
	
	public ArrayList<Warehouse> getWlist() {
		return wlist;
	}
	
	public void setWlist(ArrayList<Warehouse> wlist) {
		this.wlist = wlist;
	}
	
	public String getArrivalTime() {
		return arrivalTime;
	}
	
	public SearchTool getStool() {
		return stool;
	}
	public void setStool(SearchTool stool) {
		this.stool = stool;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public int getPageFirst() {
		return pageFirst;
	}
	public void setPageFirst(int pageFirst) {
		this.pageFirst = pageFirst;
	}
	public int getBackPage() {
		return backPage;
	}
	public void setBackPage(int backPage) {
		this.backPage = backPage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	public int getSelecti() {
		return selecti;
	}
	public void setSelecti(int selecti) {
		this.selecti = selecti;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public String getOnum() {
		return onum;
	}
	public void setOnum(String onum) {
		this.onum = onum;
	}
	public String getCusid() {
		return cusid;
	}
	public void setCusid(String cusid) {
		this.cusid = cusid;
	}
	public String getCusname() {
		return cusname;
	}
	public void setCusname(String cusname) {
		this.cusname = cusname;
	}
	public String getCuscode() {
		return cuscode;
	}
	public void setCuscode(String cuscode) {
		this.cuscode = cuscode;
	}
	public String getCusphone() {
		return cusphone;
	}
	public void setCusphone(String cusphone) {
		this.cusphone = cusphone;
	}
	public String getCuscity() {
		return cuscity;
	}
	public void setCuscity(String cuscity) {
		this.cuscity = cuscity;
	}
}
