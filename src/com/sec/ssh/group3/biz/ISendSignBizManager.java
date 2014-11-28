package com.sec.ssh.group3.biz;
import java.util.ArrayList;
import java.util.List;

import com.sec.ssh.group3.entity.*;
/*
 * Ò«À¤£¨ÅÉËÍÇ©ÊÕInterface£©
 */
public interface ISendSignBizManager 
{
	Deliver  findDeliverId(int did);
	void add(List<Sendsign> ss);//ÅÉËÍÇ©ÊÕ
	void update(List<Deliver> der);
	User findId(String unumber);
	ArrayList<Deliver> findYAll();//²éÑ¯ÅÉËÍÎ´Ç©ÊÕµÄ
}
