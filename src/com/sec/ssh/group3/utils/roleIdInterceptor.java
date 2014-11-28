package com.sec.ssh.group3.utils;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.sec.ssh.group3.action.*;
import com.sec.ssh.group3.entity.User;

public class roleIdInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		Object action = invocation.getAction(); 
		ActionContext ctx = invocation.getInvocationContext();
		User user = (User)ctx.getSession().get("user");
		System.out.println(user);
	   if(action instanceof UserAction)
	   {
		   return invocation.invoke();
	   }
		 if(user.getRoleid()==0)
		 {
			System.out.println("管理员");
			return invocation.invoke();
		 }
		 if(user.getRoleid()==1)
		 {
			 System.out.println("客服人员");
			if(action instanceof CustomerAction||action instanceof CustomerServerAction)
				return invocation.invoke();
			else
			{
				return "err";//result 权限不足页面
			}
		 }
		 if(user.getRoleid()==3)
		 {
			 System.out.println("工作人员");
			 return "err";//没有任何权限
		 }
		 if(user.getRoleid()==2)
		 {
			 System.out.println("操作人员");
			 if(action instanceof DeliverdispatcherAction||action instanceof OrderSignAction||action instanceof SenddispatcherAction||action instanceof SendSignAction||action instanceof SortingAction||action instanceof WarehouseAction)
				 return invocation.invoke();
			
		 }
		 return "err";
	
	}



}
