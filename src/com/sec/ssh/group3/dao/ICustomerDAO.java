package com.sec.ssh.group3.dao;

import java.util.ArrayList;

import com.sec.ssh.group3.entity.Customer;
/*
 * 宏红（客户管理DAO接口）
 */
public interface ICustomerDAO
{
	void addCustomer(Customer c);
    void   updateCustomer(Customer c);
    ArrayList<Customer> findAllCustomer();
    Customer findCustomerById(int cid);
    Integer checkCustomerPhone(String cphone);//检查电话是否存在
}
