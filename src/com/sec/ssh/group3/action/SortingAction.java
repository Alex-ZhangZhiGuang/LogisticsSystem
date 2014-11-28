package com.sec.ssh.group3.action;

import java.util.*;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.sec.ssh.group3.biz.ISortingBizManager;
import com.sec.ssh.group3.entity.*;
import com.sec.ssh.group3.utils.Page;
import com.sec.ssh.group3.utils.SearchTool;
/*
 * 晓珍（分拣管理Action）
 */
public class SortingAction
{
	private ISortingBizManager sbiz;
	private ArrayList<Sorting> list;
	private ArrayList<Warehouse> whlist;
	private ArrayList<Ordersign> osList;
	private Warehouse wh;
    private Sorting s;
    private String chkAll;
    private int sortid;
	private User user;
	private Orders orders;
	private int oid;
	private String weight;
	private String paidweight;
	private int productnumber;
	private Date sortingdate;
	private Date time;
	private String remark;
	private String userid;
	private String onum;
	private String uname;
	private String sortdate;
	private SearchTool stool;
	private Page page;
	private int  pageFirst;//首页
	private int  backPage;// 
	private int  nextPage;//
	private int  nowPage=0;
	private int selecti;
	
	public String findallByTools()
	{	
		List<Object> ol = new ArrayList<Object>();
		try
		{
			HashMap<String, String> contidions = new HashMap<String, String>();
			contidions.put("u.orders.onumber", onum);
			contidions.put("u.user.username", uname);
			contidions.put("u.sortingtime ", sortdate);
			ol=stool.search(contidions,"Sorting");
			ArrayList<Sorting>  oslist= new ArrayList<Sorting>();
			for (Object o : ol) 
			{
				Sorting os = new Sorting();
				os = (Sorting) o;
				oslist.add(os);
			}
			list=oslist;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "suc_list";
	}
	//分拣记录（分页）
	public String findall()
	{
		List<Object> ol = new ArrayList<Object>();
		try
		{
			list=sbiz.findAllRecord();
			page.setListsize(list.size());
			ArrayList<Sorting>  oslist= new ArrayList<Sorting>();
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
			ol=page.search(selecti,"Sorting");
			for (Object o : ol) 
			{
				Sorting os = new Sorting();
				os = (Sorting) o;
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
			list=oslist;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "suc_list";
	}
	public String add()
	{
		try
		{
			List<Sorting> sList=new ArrayList<Sorting>();
			List<Warehouse> wList=new ArrayList<Warehouse>();
			String[] str=chkAll.split(", ");
			for(String s:str)
			{
				Sorting sort=new Sorting();
				wh=sbiz.findWarehouseById(Integer.valueOf(s));
				Orders os=new Orders();
				os.setOid(wh.getOrders().getOid());
				sort.setOrders(os);
				User u=sbiz.findUserById(userid);
				sort.setUser(u);
				sort.setWeight(weight);
				sort.setPaidweight(paidweight);
				sort.setProductnumber(productnumber);
				sort.setSortingdate(sortingdate);
				sort.setSortingtime(sortingdate);
				sort.setRemark(remark);
				wh.setIssort(1);
				wList.add(wh);
				sList.add(sort);
			}
			sbiz.addSorting(sList);
			sbiz.updWarehouse(wList);
			return "add_success";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "error";
		}
	}
/*	public String findall()
	{
		try
		{
			list=sbiz.findAllRecord();
			if(list.size()>0)
				return "suc_list";
			return "error";
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return "error";
		}
	}*/
	public String findSortingDo()
	{
		try
		{
			whlist=sbiz.findSortingDo();
			if(whlist.size()>0)
				return "success";
			return "error";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "error";
		}
	}
	 public String findSortingById()
	 {
		 try
		 {
			 s=sbiz.findSortingById(s.getSortid());
		     if(s!=null)
		    	 return "success";
		     return "error";
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
			 return "error";
		 }
	 }
	public String updSorting()
	{
		try
		{
			s=sbiz.findSortingById(s.getSortid());
		    if(s!=null)
		    	return "update_success";
			return "update_error";
		}
		catch(Exception e)
        {
	        e.printStackTrace();
	        return "error";
        }
	}
	
	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	public String getPaidweight() {
		return paidweight;
	}
	public void setPaidweight(String paidweight) {
		this.paidweight = paidweight;
	}
	public int getProductnumber() {
		return productnumber;
	}
	public void setProductnumber(int productnumber) {
		this.productnumber = productnumber;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public ISortingBizManager getSbiz() {
		return sbiz;
	}
	public void setSbiz(ISortingBizManager sbiz) {
		this.sbiz = sbiz;
	}
	public int getSortid() {
		return sortid;
	}
	public void setSortid(int sortid) {
		this.sortid = sortid;
	}
	public Date getSortingdate() {
		return sortingdate;
	}
	public void setSortingdate(Date sortingdate) {
		this.sortingdate = sortingdate;
	}

	public User getUser() {
		return user;
	}

	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}

	public ArrayList<Warehouse> getWhlist() {
		return whlist;
	}
	public void setWhlist(ArrayList<Warehouse> whlist) {
		this.whlist = whlist;
	}
	public String getChkAll() {
		return chkAll;
	}
	public void setChkAll(String chkAll) {
		this.chkAll = chkAll;
	}
	public Warehouse getWh() {
		return wh;
	}
	public void setWh(Warehouse wh) {
		this.wh = wh;
	}
	public ArrayList<Ordersign> getOsList() {
		return osList;
	}
	public void setOsList(ArrayList<Ordersign> osList) {
		this.osList = osList;
	}
	
	public String getOnum() {
		return onum;
	}
	public void setOnum(String onum) {
		this.onum = onum;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getSortdate() {
		return sortdate;
	}
	public void setSortdate(String sortdate) {
		this.sortdate = sortdate;
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
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public ISortingBizManager getBiz() {
		return sbiz;
	}
	public void setBiz(ISortingBizManager sbiz) {
		this.sbiz = sbiz;
	}
	public ArrayList<Sorting> getList() {
		return list;
	}
	public void setList(ArrayList<Sorting> list) {
		this.list = list;
	}
	public Sorting getS() {
		return s;
	}
	public void setS(Sorting s) {
		this.s = s;
	}
}
