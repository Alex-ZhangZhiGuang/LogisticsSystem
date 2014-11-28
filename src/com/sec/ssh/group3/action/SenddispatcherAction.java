package com.sec.ssh.group3.action;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.opensymphony.xwork2.ActionContext;
import com.sec.ssh.group3.biz.ISenddispatcherBizManager;
import com.sec.ssh.group3.entity.*;
/*
 * 巧丽（派送调度Action）
 */
import com.sec.ssh.group3.utils.Page;
import com.sec.ssh.group3.utils.SearchTool;
public class SenddispatcherAction implements ServletRequestAware
{
	private ISenddispatcherBizManager sdBiz;
	private ArrayList<Senddispatcher> sdList;
	private ArrayList<Send> sList;
	private Senddispatcher sd;
	private Send send;
	private HttpServletRequest req;
	private Date senddate;
	private Date arrivedate;
	private String remark;
	private String freightstation;
	private String chkAll;
	private String arrdate;
	private String transporttype;
	private String onumber;
	private SearchTool stool;
	private Page page;
	private int  pageFirst;//首页
	private int  backPage;// 
	private int  nextPage;//
	private int  nowPage=0;
	private int selecti;
	
	//查看所有派送调度（分页）
	public String findAllSenddispatcher()
	{
		List<Object> ol = new ArrayList<Object>();
		try
		{
			sdList=sdBiz.findAllSendDispatcher();
			page.setListsize(sdList.size());
			ArrayList<Senddispatcher>  oslist= new ArrayList<Senddispatcher>();
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
			ol=page.search(selecti,"Senddispatcher");
			for (Object o : ol) 
			{
				Senddispatcher os = new Senddispatcher();
				os = (Senddispatcher) o;
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
			sdList=oslist;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "allSenddispatcher_success";
	}
	//查看所有派送调度（模糊查询）
	public String findAllByTools()
	{	
		List<Object> ol = new ArrayList<Object>();
		try
		{
			HashMap<String, String> contidions = new HashMap<String, String>();
			contidions.put("u.orders.onumber", onumber);
			contidions.put("u.arrivedate", arrdate);
			contidions.put("u.orders.transporttype", transporttype);
			ol=stool.search(contidions,"Senddispatcher");
			ArrayList<Senddispatcher>  sList= new ArrayList<Senddispatcher>();
			for (Object o : ol) {
				Senddispatcher s = new Senddispatcher();
				s = (Senddispatcher) o;
				sList.add(s);
			}
			sdList=sList;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "error";
		}
		return "allSenddispatcher_success";
	}
	/*
	 * 添加派送调度
	 */
	public String addSenddispatcher()
	{
		try 
		{
			String[] arr=chkAll.split(", ");
			sdList=new ArrayList<Senddispatcher>();
			List<Send> sList=new ArrayList<Send>();
			List<Orders> oList=new ArrayList<Orders>();
			for(String s:arr)
			{
				sd=new Senddispatcher();
				send=sdBiz.findOneSend(Integer.valueOf(s));
				Orders o=sdBiz.findOneOrder(send.getOrders().getOid());
				sd.setOrders(o);
				sd.setArrivedate(arrivedate);
				sd.setSenddate(senddate);
				sd.setRemark(remark);
				sd.setFreightstation(freightstation);
				send.setIsdeal(1);
				sdBiz.addSendDispatcher(sd);
				sdBiz.updSendById(send);
				sd=sdBiz.findOneSenddispatcher(sd.getSdid());
				if(sd.getFreightstation()!=null)
					o.setStatuswarehouse(0);
				sdBiz.updOrderById(o);
				//oList.add(o);
				//sdList.add(sd);
				//sList.add(send);
			}
			//sdBiz.addSendDispatcher(sdList);
			//sdBiz.updSendById(sList);
			//sdBiz.updOrderById(oList);
			return "addSenddispatcher_success";
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return "error";
		}
	}
	/*
	 * 查询所有派送通知
	 */
	public String findAllSend()
	{
		try
		{
			sList=sdBiz.findAllSend();
			if(sList.size()>0)
				return "allSend_success";
			return "error";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "error";
		}
	}
	/*
	 * 查询派送调度
	 */
/*	public String findAllSenddispatcher()
	{
		try
		{
			sdList=sdBiz.findAllSendDispatcher();
			if(sdList.size()>0)
				return "allSenddispatcher_success";
			return "error";
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return "error";
		}
	}*/
	/*
	 * 查询所有未处理的派送调度信息
	 */
	public String findAllSenddispatcherByisdeal()
	{
		try
		{
			sdList=sdBiz.findAllSenddispatcherByisdeal();
			if(sdList.size()>0)
				return "allSenddispatcherByisdeal_success";
			return "error";
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return "error";
		}
	}
	
	public SearchTool getStool() {
		return stool;
	}
	public void setStool(SearchTool stool) {
		this.stool = stool;
	}
	/*
	 * get/set……
	 */
	public ISenddispatcherBizManager getSdBiz() 
	{
		return sdBiz;
	}
	public void setSdBiz(ISenddispatcherBizManager sdBiz) 
	{
		this.sdBiz = sdBiz;
	}
	public ArrayList<Senddispatcher> getSdList() 
	{
		return sdList;
	}
	public void setSdList(ArrayList<Senddispatcher> sdList) 
	{
		this.sdList = sdList;
	}
	public Senddispatcher getSd() 
	{
		return sd;
	}
	public void setSd(Senddispatcher sd) 
	{
		this.sd = sd;
	}
	public void setServletRequest(HttpServletRequest req) 
	{
		this.req=req;
	}

	public HttpServletRequest getReq() {
		return req;
	}

	public void setReq(HttpServletRequest req) {
		this.req = req;
	}

	public Date getSenddate() {
		return senddate;
	}

	public void setSenddate(Date senddate) {
		this.senddate = senddate;
	}

	public Date getArrivedate() {
		return arrivedate;
	}

	public void setArrivedate(Date arrivedate) {
		this.arrivedate = arrivedate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getFreightstation() {
		return freightstation;
	}

	public void setFreightstation(String freightstation) {
		this.freightstation = freightstation;
	}

	public ArrayList<Send> getSList() {
		return sList;
	}

	public void setSList(ArrayList<Send> list) {
		sList = list;
	}
	public Send getSend() {
		return send;
	}

	public void setSend(Send send) {
		this.send = send;
	}

	public String getChkAll() {
		return chkAll;
	}

	public void setChkAll(String chkAll) {
		this.chkAll = chkAll;
	}
	public String getArrdate() {
		return arrdate;
	}
	public void setArrdate(String arrdate) {
		this.arrdate = arrdate;
	}
	public String getTransporttype() {
		return transporttype;
	}
	public void setTransporttype(String transporttype) {
		this.transporttype = transporttype;
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
