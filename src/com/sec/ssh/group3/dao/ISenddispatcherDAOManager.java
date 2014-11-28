package com.sec.ssh.group3.dao;
import com.sec.ssh.group3.entity.*;

import  java.util.*;
/*
 * ���������͵���DAO�ӿڣ�
 */
public interface ISenddispatcherDAOManager 
{
	Senddispatcher findSendDispatcherById(int sdid);	//����sdid��ѯ���͵�����Ϣ
	ArrayList<Senddispatcher> findAllSendDispatcher();	//��ѯ�������͵���
	ArrayList<Senddispatcher> findAllSenddispatcherByisdeal();	//��������״̬��ѯ���͵�����Ϣ
	void addSendDispatcher(Senddispatcher sd);	//������͵���
	void updSenddispatcher(int sdid,Senddispatcher sd);	//����sdid�޸����͵���
	ArrayList<Send> findAllSend();	//��ѯ��������֪ͨ
	Send findOneSend(int sid);	//����sid��ѯ����֪ͨ��Ϣ
	void updSendById(Send s);	//�޸�����֪ͨ������״̬
	void updOrderById(Orders o);	//�޸Ķ������״̬
	Orders findOneOrder(int oid);	//����oid��ѯ������Ϣ
	Senddispatcher findOneSenddispatcher(int sdid);	//����sdid��ѯ���͵���
}
