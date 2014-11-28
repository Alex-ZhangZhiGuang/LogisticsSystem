package com.sec.ssh.group3.dao;

import java.util.ArrayList;

import com.sec.ssh.group3.entity.Customer;
/*
 * ��죨�ͻ�����DAO�ӿڣ�
 */
public interface ICustomerDAO
{
	void addCustomer(Customer c);
    void   updateCustomer(Customer c);
    ArrayList<Customer> findAllCustomer();
    Customer findCustomerById(int cid);
    Integer checkCustomerPhone(String cphone);//���绰�Ƿ����
}
