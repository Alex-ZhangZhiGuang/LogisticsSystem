package com.sec.ssh.group3.biz;
import com.sec.ssh.group3.entity.*;

import java.util.*;
/*
 * �������������Interface��
 */
public interface IDeliverdispatcherBizManager 
{
	Deliverdispatcher findDeliverDispatcherById(int drid);	//����drid��ѯ�������
	ArrayList<Deliverdispatcher> findAllDeliverDispatcher();	//��ѯ�����������
	void addDeliverDispatchers(List<Deliverdispatcher> dr);	//������������Ϣ
	Senddispatcher findOneSenddispatcher(int sdid);	//����sdid��ѯ���͵���
	void updSenddispatcherById(List<Senddispatcher> sd);	//�޸����͵�������״̬
	void updOrderById(List<Orders> o);	//�޸Ķ������״̬
	Orders findOneOrder(int oid);	//����oid��ѯ������Ϣ
}
