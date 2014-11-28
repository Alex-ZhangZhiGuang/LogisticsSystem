package com.sec.ssh.group3.utils;

import java.util.*;

import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sec.ssh.group3.entity.*;

public class MapLikeUtil extends HibernateDaoSupport
{
	public List findMapLike(String hql,Map<String,String> map)
	{
		Query query=this.getSession().createQuery(hql);
		if(map!=null)
		{
			Iterator iter=map.keySet().iterator();
			while(iter.hasNext())
			{
				String next=(String)iter.next();
				query.setParameter(next, map.get(next));
			}
		}
		return query.list();
	}
	
	public List getAll(Map<String, String> map,String str) 
	{
        String hql = "from "+str+" s where s.isdeal=1";
        if (null !=map && map.size() > 0) 
        {
            if (null != map.get("onumber") && !"".equals(map.get("onumber")))
                hql+=" and s.orders.onumber like '"+map.get("onumber")+"'";
            if(null != map.get("transporttype") && !"".equals(map.get("transporttype")))
                hql+=" and s.orders.transporttype like '"+"'"+map.get("transporttype")+"'";
            if(null !=map.get("arrivedate") && !"".equals("arrivedate"))
                hql+=" and s.arrivedate like '"+"'"+map.get("logpass")+"'";
        }
        Query query=this.getSession().createQuery(hql);
        return query.list();
    }
}
