package com.sec.ssh.group3.test;

import junit.framework.TestCase;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sec.ssh.group3.action.SenddispatcherAction;
/*
 * Senddispatcher≤‚ ‘¿‡£®«…¿ˆ£©
 */
public class SenddispatcherTest extends TestCase
{
	private BeanFactory bf;
	private SenddispatcherAction sdAction;
	public void setUp()
	{
		bf=new ClassPathXmlApplicationContext("applicationContext.xml");
		sdAction=(SenddispatcherAction)bf.getBean("sdAction");
	}
	public void testadd()
	{
		String result=sdAction.addSenddispatcher();
		System.out.println(result);
	}
	
	 void testfind()
	{
		String result=sdAction.findAllSenddispatcher();
		System.out.println(result);
	}
}
