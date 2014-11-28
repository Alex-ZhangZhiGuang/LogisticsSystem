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
			System.out.println("����Ա");
			return invocation.invoke();
		 }
		 if(user.getRoleid()==1)
		 {
			 System.out.println("�ͷ���Ա");
			if(action instanceof CustomerAction||action instanceof CustomerServerAction)
				return invocation.invoke();
			else
			{
				return "err";//result Ȩ�޲���ҳ��
			}
		 }
		 if(user.getRoleid()==3)
		 {
			 System.out.println("������Ա");
			 return "err";//û���κ�Ȩ��
		 }
		 if(user.getRoleid()==2)
		 {
			 System.out.println("������Ա");
			 if(action instanceof DeliverdispatcherAction||action instanceof OrderSignAction||action instanceof SenddispatcherAction||action instanceof SendSignAction||action instanceof SortingAction||action instanceof WarehouseAction)
				 return invocation.invoke();
			
		 }
		 return "err";
	
	}



}
