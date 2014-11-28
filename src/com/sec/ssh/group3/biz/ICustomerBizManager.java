package com.sec.ssh.group3.biz;
import java.util.ArrayList;
import com.sec.ssh.group3.entity.*;
/*
 * 宏红（客户管理Interface）
 */
public interface ICustomerBizManager 
{
	 void addCustomer(Customer c);
     void   updateCustomer(Customer c);
     ArrayList<Customer> findAllCustomer();
     Customer findCustomerById(int cid);
     Integer checkCustomerPhone(String cphone);//检查电话是否存在
}
