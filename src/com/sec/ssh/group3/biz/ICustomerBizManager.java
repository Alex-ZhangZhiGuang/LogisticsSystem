package com.sec.ssh.group3.biz;
import java.util.ArrayList;
import com.sec.ssh.group3.entity.*;
/*
 * ��죨�ͻ�����Interface��
 */
public interface ICustomerBizManager 
{
	 void addCustomer(Customer c);
     void   updateCustomer(Customer c);
     ArrayList<Customer> findAllCustomer();
     Customer findCustomerById(int cid);
     Integer checkCustomerPhone(String cphone);//���绰�Ƿ����
}
