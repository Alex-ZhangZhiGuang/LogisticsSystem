package com.sec.ssh.group3.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	public static String getDate(){
		Date d=new Date();
		SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");	
		System.out.println(sdf1.format(d));
		return sdf1.format(d);
	}
}
