package com.sec.ssh.group3.dao;
import com.sec.ssh.group3.entity.*;

import java.util.*;
/*
 * �������������DAO�ӿڣ�
 */
public interface IDeliverdispatcherDAOManager 
{
	Deliverdispatcher findDeliverDispatcherById(int drid);	//����drid��ѯ�������
	ArrayList<Deliverdispatcher> findAllDeliverDispatcher();	//��ѯ�����������
	void addDeliverDispatcher(Deliverdispatcher dr);	//������������Ϣ
	Senddispatcher findOneSenddispatcher(int sdid);	//����sdid��ѯ���͵���
	void updSenddispatcherById(Senddispatcher sd);	//�޸����͵�������״̬
	void updOrderById(Orders o);	//�޸Ķ������״̬
	Orders findOneOrder(int oid);	//����oid��ѯ������Ϣ
}
