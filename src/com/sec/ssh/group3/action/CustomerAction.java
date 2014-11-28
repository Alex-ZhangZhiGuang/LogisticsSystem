package com.sec.ssh.group3.action;

import java.util.*;

import com.opensymphony.xwork2.Action;
import com.sec.ssh.group3.biz.ICustomerBizManager;
import com.sec.ssh.group3.entity.Customer;
import com.sec.ssh.group3.utils.Page;
import com.sec.ssh.group3.utils.RandomUtil;
import com.sec.ssh.group3.utils.SearchTool;
/*
 * 宏红（客户管理Action）
 */
public class CustomerAction
{
	private ICustomerBizManager cbiz;
	private ArrayList<Customer> clist;
	private SearchTool stool;
	private Customer c;
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
	private String msg;
	private String id;
	private Integer result;
	private String fieldValue;
	private String fieldId;
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
			contidions.put("u.cname", cname);
			contidions.put("u.cityname", cityname);
			contidions.put("u.cphone", cphone);
			contidions.put("u.receiptcode", receiptcode);
			ol=stool.search(contidions,"Customer");
			ArrayList<Customer>  chlist= new ArrayList<Customer>();
			for (Object o : ol) 
			{
				Customer c = new Customer();
				c = (Customer) o;
				chlist.add(c);
			}
			clist=chlist;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "suc_list";
	}
	public String checkPhone()
	{
		try
		{
			setResult(cbiz.checkCustomerPhone(fieldValue));
			//result = 24;
			return Action.SUCCESS;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "error";
		}
	}
	public String findCustomerCnumber()
	{
		 cnumber=RandomUtil.randomChar();
		 return "suc_findCnumber";
	}
	public String add()
	{
		try
		{
			c=new Customer();
			cnumber=RandomUtil.randomChar();
			c.setCnumber(cnumber);
		    c.setCid(cid);
			c.setCname(cname);
			c.setCphone(cphone);
			c.setReceiptcode(receiptcode);
			c.setCityname(cityname);
			c.setCfax(cfax);
			c.setCemail(cemail);
			c.setContactperson(contactperson);
			c.setCaddress(caddress);
			cbiz.addCustomer(c);
			return findall();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			 return "error";
		}
	}
	public String findall()
	{
		List<Object> ol = new ArrayList<Object>();
		try
		{
			clist=cbiz.findAllCustomer();
			page.setListsize(clist.size());
			ArrayList<Customer>  chlist= new ArrayList<Customer>();
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
			ol=page.search(selecti,"Customer");
			for (Object o : ol) 
			{
				Customer c = new Customer();
				c = (Customer) o;
				chlist.add(c);
			}
			if(nowPage<0)
			{
				nowPage=0;
			}
			if(nowPage>page.getPageye())
			{
				nowPage=page.getPageye();
			}
			clist=chlist;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "suc_list";
	}
/*	public String findall()
	{
		try
		{
			clist=cbiz.findAllCustomer();	
			if(clist.size()>0)
				return "suc_list";
			return "error";
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return "error";
		}
	}*/
	public String updAllcustomer()
	{
		try
		{
			Customer c= cbiz.findCustomerById(cid);
			c.setCname(cname);
			c.setCphone(cphone);
			c.setReceiptcode(receiptcode);
			c.setCityname(cityname);
			c.setCfax(cfax);
			c.setCemail(cemail);
			c.setContactperson(contactperson);
			c.setCaddress(caddress);
			cbiz.updateCustomer(c);
			return findall();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "error";
		}
	}
	public String updCustomer()
	{
		try
		{
			System.out.println(cid);
			Customer c= cbiz.findCustomerById(cid);
			cname=c.getCname();
			cphone=c.getCphone();
			receiptcode=c.getReceiptcode();
			cityname=c.getCityname();
			cfax=c.getCfax();
			cemail=c.getCemail();
			contactperson=c.getContactperson();
			caddress=c.getCaddress();
			return "suc_updcustomer";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "error";
		}
	}
	
	
	public String getCnumber() {
		return cnumber;
	}
	public void setCnumber(String cnumber) {
		this.cnumber = cnumber;
	}

	public String getCaddress() {
		return caddress;
	}
	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}
	public String getCemail() {
		return cemail;
	}
	public void setCemail(String cemail) {
		this.cemail = cemail;
	}
	public String getCfax() {
		return cfax;
	}
	public void setCfax(String cfax) {
		this.cfax = cfax;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getContactperson() {
		return contactperson;
	}
	public void setContactperson(String contactperson) {
		this.contactperson = contactperson;
	}
	public String getCphone() {
		return cphone;
	}
	public void setCphone(String cphone) {
		this.cphone = cphone;
	}
	public String getReceiptcode() {
		return receiptcode;
	}
	public void setReceiptcode(String receiptcode) {
		this.receiptcode = receiptcode;
	}
	public Customer getC() {
		return c;
	}
	public void setC(Customer c) {
		this.c = c;
	}
	public ICustomerBizManager getCbiz() {
		return cbiz;
	}
	public void setCbiz(ICustomerBizManager cbiz) {
		this.cbiz = cbiz;
	}
	public ArrayList<Customer> getClist() {
		return clist;
	}
	public void setClist(ArrayList<Customer> clist) {
		this.clist = clist;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public SearchTool getStool() {
		return stool;
	}
	public void setStool(SearchTool stool) {
		this.stool = stool;
	}

	public String getFieldValue() {
		return fieldValue;
	}
	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}
	public String getFieldId() {
		return fieldId;
	}
	public void setFieldId(String fieldId) {
		this.fieldId = fieldId;
	}
	public Integer getResult() {
		return result;
	}
	public void setResult(Integer result) {
		this.result = result;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
}
