package com.sec.ssh.group3.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lowagie.text.pdf.hyphenation.TernaryTree.Iterator;

public class SearchTool extends HibernateDaoSupport
{
	public List<Object> search(Map<String,String> contidions,String entityName)
	{
		List<Object> l=new ArrayList<Object>();
		String hql="from "+entityName;
		boolean isFirst = true;
		for(Map.Entry<String, String> entry:contidions.entrySet())
		{
			if (entry.getValue()==null||entry.getValue().trim().length()==0)
				continue;
			if (isFirst)
			{
				hql += " u where ";
				isFirst = false;
			}
			else
				hql+=" and ";
			hql+=entry.getKey()+" like '%"+entry.getValue()+"%' ";			 
			System.out.println(hql);
		} 
	
		System.out.println(hql);
		l=this.getHibernateTemplate().find(hql);
		//l=this.getHibernateTemplate().find(hql);
		System.out.println(l.size());
		return l;
	}
}
