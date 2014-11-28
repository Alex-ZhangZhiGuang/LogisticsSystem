package com.sec.ssh.group3.action;

import java.util.*;

import com.opensymphony.xwork2.ActionContext;
import com.sec.ssh.group3.biz.IDeliverdispatcherBizManager;
import com.sec.ssh.group3.entity.*;
import com.sec.ssh.group3.utils.Page;
import com.sec.ssh.group3.utils.SearchTool;
/*
 * 巧丽（提货调度Action）
 */
public class DeliverdispatcherAction 
{
	private IDeliverdispatcherBizManager drBiz;
	private Deliverdispatcher dr;
	private ArrayList<Deliverdispatcher> drList;
	private Senddispatcher sd;
	private String arrdate;
	private String transitcity;
	private String onumber;
	private Date senddate;
	private Date arrivedate;
	private String remark;
	private String chkAll;
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
			contidions.put("u.orders.onumber", onumber);
			contidions.put("u.arrivedate", arrdate);
			contidions.put("u.orders.transporttype", transitcity);
			ol=stool.search(contidions,"Deliverdispatcher");
			ArrayList<Deliverdispatcher>  ddList= new ArrayList<Deliverdispatcher>();
			for (Object o : ol) {
				Deliverdispatcher d = new Deliverdispatcher();
				d = (Deliverdispatcher) o;
				ddList.add(d);
			}
			drList=ddList;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "error";
		}
		return "allDeliverdispatcher_success";
	}
	/*
	 * 添加提货调度
	 */
	public String addDeliverdispatcher()
	{
		try 
		{
			String[] arr=chkAll.split(", ");
			drList=new ArrayList<Deliverdispatcher>();
			List<Senddispatcher> sdList=new ArrayList<Senddispatcher>();
			//List<Orders> oList=new ArrayList<Orders>();
			for(String s:arr)
			{
				dr=new Deliverdispatcher();
				sd=drBiz.findOneSenddispatcher(Integer.valueOf(s));
				//Orders o=drBiz.findOneOrder(sd.getOrders().getOid());
				Orders o=new Orders();
				o.setOid(sd.getOrders().getOid());
				dr.setOrders(o);
				dr.setArrivedate(arrivedate);
				dr.setSenddate(senddate);
				dr.setRemark(remark);
				sd.setIsdeal(1);
				//if(sd.getFreightstation()!=null)
					//o.setStatuswarehouse(0);
				//oList.add(o);
				drList.add(dr);
				sdList.add(sd);
			}
			drBiz.addDeliverDispatchers(drList);
			drBiz.updSenddispatcherById(sdList);
			//drBiz.updOrderById(oList);
			return "addDeliverdispatcher_success";
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return "error";
		}
	}
	//查看所有提货调度（分页）
	public String findAllDeliverdispatcher()
	{
		List<Object> ol = new ArrayList<Object>();
		try
		{
			drList=drBiz.findAllDeliverDispatcher();
			page.setListsize(drList.size());
			ArrayList<Deliverdispatcher>  oslist= new ArrayList<Deliverdispatcher>();
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
			ol=page.search(selecti,"Deliverdispatcher");
			for (Object o : ol) 
			{
				Deliverdispatcher os = new Deliverdispatcher();
				os = (Deliverdispatcher) o;
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
			drList=oslist;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "allDeliverdispatcher_success";
	}
	/*
	 * 查询所有提货调度
	 */
/*	public String findAllDeliverdispatcher()
	{
		try 
		{
			drList=drBiz.findAllDeliverDispatcher();
			if(drList.size()>0)
			{
				return "allDeliverdispatcher_success";
			}
			return "error";
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return "error";
		}
	}*/
	/*
	 * get/set……
	 */
	public IDeliverdispatcherBizManager getDrBiz() 
	{
		return drBiz;
	}
	public void setDrBiz(IDeliverdispatcherBizManager drBiz) 
	{
		this.drBiz = drBiz;
	}
	public Deliverdispatcher getDr() 
	{
		return dr;
	}
	public void setDr(Deliverdispatcher dr) 
	{
		this.dr = dr;
	}
	public ArrayList<Deliverdispatcher> getDrList() 
	{
		return drList;
	}

	public void setDrList(ArrayList<Deliverdispatcher> drList) 
	{
		this.drList = drList;
	}

	public Date getSenddate() 
	{
		return senddate;
	}

	public void setSenddate(Date senddate) 
	{
		this.senddate = senddate;
	}

	public Date getArrivedate() 
	{
		return arrivedate;
	}

	public void setArrivedate(Date arrivedate)
	{
		this.arrivedate = arrivedate;
	}

	public String getRemark() 
	{
		return remark;
	}

	public void setRemark(String remark)
	{
		this.remark = remark;
	}

	public String getChkAll() 
	{
		return chkAll;
	}

	public void setChkAll(String chkAll)
	{
		this.chkAll = chkAll;
	}

	public Senddispatcher getSd()
	{
		return sd;
	}

	public void setSd(Senddispatcher sd)
	{
		this.sd = sd;
	}
	public SearchTool getStool() {
		return stool;
	}
	public void setStool(SearchTool stool) {
		this.stool = stool;
	}
	public String getArrdate() {
		return arrdate;
	}
	public void setArrdate(String arrdate) {
		this.arrdate = arrdate;
	}
	public String getTransitcity() {
		return transitcity;
	}
	public void setTransitcity(String transitcity) {
		this.transitcity = transitcity;
	}
	public String getOnumber() {
		return onumber;
	}
	public void setOnumber(String onumber) {
		this.onumber = onumber;
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