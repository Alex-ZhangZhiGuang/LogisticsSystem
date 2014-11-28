package com.sec.ssh.group3.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sec.ssh.group3.entity.Customer;

public class Page extends HibernateDaoSupport 
{
	private int pageFirst = 0;// 首页
	private int backPage = 0;// 下一页
	private int nextPage = 0;// 上一页
	private int maxShowPage = 5;
	private int listsize;
	private int pageye = 0;

	public int getPageye() {
		return pageye;
	}

	public void setPageye(int pageye) {
		this.pageye = pageye;
	}

	public List<Object> search(int i, String entityname) 
	{
		pageye = listsize / 5;
		Query q = this.getSession().createQuery("from " + entityname);
		if (i == 0)
		{
			// 首页
			q.setFirstResult(maxShowPage * 0);
		}
		else if (i == 1) 
		{
			// 上一页
			if (backPage >= 0)
				q.setFirstResult(maxShowPage * backPage);
			else
				q.setFirstResult(maxShowPage * 0);
		}
		else if (i == 2) 
		{
			if (nextPage > pageye)
				q.setFirstResult(maxShowPage * pageye);
			else
				q.setFirstResult(maxShowPage * nextPage);
		}
		else 
		{
			q.setFirstResult(pageye * maxShowPage);
		}
		q.setMaxResults(maxShowPage);
		List list = q.list();
		return list;
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

	public int getMaxShowPage() {
		return maxShowPage;
	}

	public void setMaxShowPage(int maxShowPage) {
		this.maxShowPage = maxShowPage;
	}

	public int getListsize() {
		return listsize;
	}

	public void setListsize(int listsize) {
		this.listsize = listsize;
	}

}
