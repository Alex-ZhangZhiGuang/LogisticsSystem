package com.sec.ssh.group3.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sec.ssh.group3.action.DeliverdispatcherAction;

import junit.framework.TestCase;
/*
 * Deliverdispatcher≤‚ ‘¿‡£®«…¿ˆ£©
 */
public class DeliverdispatcherTest extends TestCase
{
	private BeanFactory bf;
	private DeliverdispatcherAction drAction;
	public void setUp()
	{
		bf=new ClassPathXmlApplicationContext("applicationContext.xml");
		drAction=(DeliverdispatcherAction)bf.getBean("drAction");
	}
	 void testadd()
	{
		String result=drAction.addDeliverdispatcher();
		System.out.println(result);
	}
	
	 void testfind()
	{
		String result=drAction.findAllDeliverdispatcher();
		System.out.println(result);
	}
}
