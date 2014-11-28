package com.sec.ssh.group3.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sec.ssh.group3.action.CustomerAction;

import junit.framework.TestCase;

public class CustomerTest extends TestCase{
	private BeanFactory fac;
	public void setUp()
	{
		fac=new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	public void testCustomer()
	{
		CustomerAction ca=(CustomerAction)fac.getBean("customeraction");
		System.out.println(ca.findall());
	}
	public void testadd()
	{
		 CustomerAction sa=(CustomerAction)fac.getBean("customeraction");
		 sa.setCid(2);
		 sa.setCname("zhangsan");
		 sa.setCphone("2234545");
		 sa.setReceiptcode("123456");
		 sa.setCityname("¸£ÖÝ");
		 sa.setCfax(null);
		 sa.setCemail("192.168@11.com");
		 sa.setContactperson("lisi");
		 sa.setCaddress("±±¾©");
	       String result=sa.add();
	       System.out.println(result);
	}

}
