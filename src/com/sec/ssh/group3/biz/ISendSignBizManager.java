package com.sec.ssh.group3.biz;
import java.util.ArrayList;
import java.util.List;

import com.sec.ssh.group3.entity.*;
/*
 * ҫ��������ǩ��Interface��
 */
public interface ISendSignBizManager 
{
	Deliver  findDeliverId(int did);
	void add(List<Sendsign> ss);//����ǩ��
	void update(List<Deliver> der);
	User findId(String unumber);
	ArrayList<Deliver> findYAll();//��ѯ����δǩ�յ�
}
