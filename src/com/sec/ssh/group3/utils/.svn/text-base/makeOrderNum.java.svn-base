package com.sec.ssh.group3.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class makeOrderNum 
{
	public  static String makeOrderNum()
	{
	   Date date = new Date();
	   char c='A';
	   char ch='A';
	   c=(char)(c+(int)(Math.random()*26));
	   ch=(char)(ch+(int)(Math.random()*26));
	   SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
	   String d = sdf.format(date);
       System.out.println(c+""+ch+""+d);
       return (c+""+ch+""+d);
	}

}
