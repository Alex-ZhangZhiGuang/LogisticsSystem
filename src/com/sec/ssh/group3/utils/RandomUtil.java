package com.sec.ssh.group3.utils;

import java.util.Random;

import com.opensymphony.xwork2.ActionContext;

public class RandomUtil 
{
    /*
     * 随机生成工号
     */
	public   static String  randomChar(){
		String s="";
		String str="ABCDEFGHIJKLMNOPQISTUVWXYZ";
		for(int i=0;i<2;i++){
			int ii=(int)(Math.random()*26);
			s+=str.charAt(ii);
		}
	    int sint=0;
		String ss="";
	    for (int i = 0; i < 6; i++) {
		   Random rd=new Random();
		   sint=rd.nextInt(10);
		   ss+=sint;
		 } 
	    return s+ss;
		
	}
}
