package com.sec.ssh.group3.action;
import java.util.*;
import com.sec.ssh.group3.biz.ISenddispatcherBizManager;
import com.sec.ssh.group3.biz.IWarehouseBizManager;
import com.sec.ssh.group3.entity.*;
import com.sec.ssh.group3.utils.Page;
import com.sec.ssh.group3.utils.SearchTool;
/*
 * 荣辉（仓库管理Action）
 */
public class WarehouseAction 
{
	private Warehouse w;
	private IWarehouseBizManager biz;
	private ArrayList<Warehouse> wdList;
	private ArrayList<Orders> olist;
	private int oid;
	private String checkAllCk;
	private int whid;
	private String onumber;
	private int statuswarehouse;
	private String warehousenum;
	private int paidinnumber;
	private String whnumber;
	private String whweight;
	private int issendinfo;
	private int issign;
	private int issort;
	private Date entrydate;
	private Date outdate;
	private String oids;
	private String chkAll;
	private Orders os;
	private String wid;
	private String iswh;
	private String city;
	private String issorting;
	private SearchTool stool;
	private Page page;
	private int  pageFirst;//首页
	private int  backPage;// 
	private int  nextPage;//
	private int  nowPage=0;
	private int selecti;
	
	public String findWareAllByTools()
	{	
		List<Object> ol = new ArrayList<Object>();
		try
		{
			HashMap<String, String> contidions = new HashMap<String, String>();
			contidions.put("u.warehousenum", wid);
			contidions.put("u.orders.transporttype", city);
			contidions.put("u.issort", issorting);
			contidions.put("u.orders.statuswarehouse", iswh);
			ol=stool.search(contidions,"Warehouse");
			ArrayList<Warehouse>  oslist= new ArrayList<Warehouse>();
			for (Object o : ol) 
			{
				Warehouse os = new Warehouse();
				os = (Warehouse) o;
				oslist.add(os);
			}
			wdList=oslist;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "findAll_success";
	}
	//查看入库记录
	public String findWareAll()
	{
		List<Object> ol = new ArrayList<Object>();
		try
		{
			wdList=biz.findWareAll();
			page.setListsize(wdList.size());
			ArrayList<Warehouse>  oslist= new ArrayList<Warehouse>();
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
			ol=page.search(selecti,"Warehouse");
			for (Object o : ol) 
			{
				Warehouse os = new Warehouse();
				os = (Warehouse) o;
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
			wdList=oslist;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "findAll_success";
	}
/*	public String findWareAll()
	{
		try
		{
			wdList=biz.findWareAll();
			if(wdList.size()>0)
				return "findAll_success";
			return "error";
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return "error";
		}
	}
*/
	public String findAllOrderNotRk()
	{
		try
		{
			olist=biz.findOrderAllNotRk();
			if(olist.size()>0)
				return "findOrderAll_success";
			return "error";
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return "error";
		}
	}
	
	//查询仓库待出库全部
	public String findAllWOrderNotCk()
	{
		try 
		{
			wdList=biz.findWareAllNotCk();
			if(wdList.size()>0)
				return "findWOrderAll_success";
			return "error";
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return "error";
		}

	 
	}
	//仓库出库
	public String update()
	{
		try
		{
			String[] ss=this.checkAllCk.split(", ");
			List<Warehouse> wlist=new ArrayList<Warehouse>();
			for(String s:ss)
			{
				Warehouse w=biz.findId(Integer.valueOf(s));
				w.setOutdate(new Date());
				wlist.add(w);
			}
			biz.wupdate(wlist);
			return "update_success";
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return "error";
		}
	}

	public String add()
	{
		try 
		{
			String[] ss=this.chkAll.split(", ");
			List<Warehouse> wlist=new ArrayList<Warehouse>();
			List<Orders> olist=new ArrayList<Orders>();
			for(String s:ss)
			{		
				Warehouse w=new Warehouse();
				os=biz.findOrderId(Integer.valueOf(s));
				String ro=this.randomChar();
				w.setWhnumber(ro);
				w.setOrders(os);
				w.setEntrydate(new Date());
				w.setWhweight(whweight);
				w.setWarehousenum(warehousenum);
				w.setPaidinnumber(paidinnumber);
				os.setStatuswarehouse(1);
				olist.add(os);
				wlist.add(w);
			}
		    biz.addWhs(wlist);
		    biz.update(olist);
		    return "success_add";
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return "error";
		}
	}

	public static String randomChar()
	{
		String s="";
		String str="ABCDEFGHIJKLMNOPQISTUVWXYZ";
		for(int i=0;i<4;i++)
		{
			int ii=(int)(Math.random()*26);
			s+=str.charAt(ii);
		}
	    int sint=0;
		String ss="";
	    for (int i = 0; i < 6; i++) 
	    {
		   Random rd=new Random();
		   sint=rd.nextInt(10);
		   ss+=sint;
		 }  
		return s+ss;
	}
	
	
	public Orders getOs() {
		return os;
	}
	public void setOs(Orders os)
	{
		this.os = os;
	}
	public String getChkAll() {
		return chkAll;
	}
	public void setChkAll(String chkAll) {
		this.chkAll = chkAll;
	}


	public String getCheckAllCk() {
		return checkAllCk;
	}
	public void setCheckAllCk(String checkAllCk) {
		this.checkAllCk = checkAllCk;
	}
	public String getOids() {
		return oids;
	}
	public void setOids(String oids) {
		this.oids = oids;
	}
	public String getOnumber() {
		return onumber;
	}
	public void setOnumber(String onumber) {
		this.onumber = onumber;
	}
	public String getWhnumber() {
		return whnumber;
	}
	public void setWhnumber(String whnumber) {
		this.whnumber = whnumber;
	}
	public int getIssendinfo() {
		return issendinfo;
	}
	public void setIssendinfo(int issendinfo) {
		this.issendinfo = issendinfo;
	}
	public int getIssign() {
		return issign;
	}
	public void setIssign(int issign) {
		this.issign = issign;
	}
	public int getIssort() {
		return issort;
	}
	public void setIssort(int issort) {
		this.issort = issort;
	}
	public Date getEntrydate() {
		return entrydate;
	}
	public void setEntrydate(Date entrydate) {
		this.entrydate = entrydate;
	}
	public Date getOutdate() {
		return outdate;
	}
	public void setOutdate(Date outdate) {
		this.outdate = outdate;
	}
	public String getWarehousenum() {
		return warehousenum;
	}
	public void setWarehousenum(String warehousenum) {
		this.warehousenum = warehousenum;
	}
	public int getPaidinnumber() {
		return paidinnumber;
	}
	public void setPaidinnumber(int paidinnumber) {
		this.paidinnumber = paidinnumber;
	}
	public String getWhweight() {
		return whweight;
	}
	public void setWhweight(String whweight) {
		this.whweight = whweight;
	}

	
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	

	public int getWhid() {
		return whid;
	}
	public void setWhid(int whid) {
		this.whid = whid;
	}
	public int getStatuswarehouse() {
		return statuswarehouse;
	}
	public void setStatuswarehouse(int statuswarehouse) {
		this.statuswarehouse = statuswarehouse;
	}
	public ArrayList<Orders> getOlist() {
		return olist;
	}
	public void setOlist(ArrayList<Orders> list) {
		olist = list;
	}
	public Warehouse getW() {
		return w;
	}
	public void setW(Warehouse w) {
		this.w = w;
	}
	public IWarehouseBizManager getBiz() {
		return biz;
	}
	public void setBiz(IWarehouseBizManager biz) {
		this.biz = biz;
	}
	public ArrayList<Warehouse> getWdList() {
		return wdList;
	}
	public void setWdList(ArrayList<Warehouse> wdList) {
		this.wdList = wdList;
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

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
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
	public String getWid() {
		return wid;
	}
	public void setWid(String wid) {
		this.wid = wid;
	}
	public String getIswh() {
		return iswh;
	}
	public void setIswh(String iswh) {
		this.iswh = iswh;
	}
	public String getIssorting() {
		return issorting;
	}
	public void setIssorting(String issorting) {
		this.issorting = issorting;
	}
}
