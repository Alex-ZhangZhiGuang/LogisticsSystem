package com.sec.ssh.group3.action;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.SimpleFormatter;

import com.opensymphony.xwork2.ActionContext;
import com.sec.ssh.group3.biz.IUserBiz;
import com.sec.ssh.group3.entity.User;
import com.sec.ssh.group3.utils.MD5util;
/*
 * ��Ƽ���û�����Action��
 */
public class UserAction 
{
	private IUserBiz<User> userbiz;
	private ArrayList<User> list;
	private User user;
	private String massger;
	private int userid;
	private String usernumber;
	private String username;
	private String userpwd;
	private String userpwdnew;
	private String userphone;
	private int isservice;
	private int roleid;
	private String cityname;
	private Date createdate;
	/**
	 * ����user����  
	 * @return SUCCESS
	 * �û��������ظ�..
	 * ��Ų����ظ�
	 * �绰�����ظ�
	 * ����ϵͳʱ��
	 * �û���ɫĬ��Ϊ0
	 */
	public String adduser()
	{
		try 
		{
			user=new User();
			user.setUsernumber(usernumber);//����
			user.setUsername(username);//�û���
			user.setUserpwd(userpwd);
			user.setCreatedate(new Date());	//�õ�Ĭ��ʱ��
			user.setRoleid(roleid);//�û���ɫ
			user.setCityname(cityname);//����
			user.setUserphone(userphone);//�绰
			userbiz.add(user);
			return "add_success";
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return "ERROR";
		}
	}
	
	// ����ʱ���ӵ���ϵͳĬ��ʱ�䣬�ж��û����Ƿ���ڣ��ж���ϵ��ʽ�Ƿ��ظ� 
	
	/**
	 * ����id��ѯ�û���Ϣ
	 * @return finByidSUCCESS
	 */
	public String finByid()
	{
		user=new User();
		try 
		{
			 user=userbiz.findByid(userid);
			 if(user!=null)
				 return "finByidSUCCESS";
			 return "ERROR";
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return "ERROR";
		}
	}
	/**
	 * �޸�user����  
	 * @return  �޸ĳɹ����� updateSUCCESS
	 */
	public String updateuser()
	{
		try
		{	
			user.setUsername(username);
			user.setUserphone(userphone);
			user.setCreatedate(createdate);
			user.setIsservice(isservice);
			user.setCreatedate(new Date());
			userbiz.update(user);
			return "updateSUCCESS";
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return"ERROR";
		}
	}

	/**
	 * �޸��û�����
	 * @return  updatenameSUCESS;
	 */
	public String updatepwd()
	{
		//����id
		//Ҫ�ж�ԭ����
		try 
		{
			list=(ArrayList<User>) userbiz.login(username, userpwd);
			if(!list.isEmpty()||list.size()!=0)
			{

				User u = (User) ActionContext.getContext().getSession().get("user");//������session��
				userid = u.getUserid();
				user=new User();
				user=userbiz.findByid(userid);
				user.setUsername(username);
				user.setUserpwd(userpwdnew);
				userbiz.update(user);
				return "updatepwdSUCCESS";
			}
			else
			{
				massger="�����������������";
				return "updatenameERROR";
			}
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return "ERROR";
		}
	}
	/**
	 * ��ѯȫ��user����
	 * @return SUCCESS
	 */
	public String findall()
	{
		try
		{
			list=(ArrayList<User>) userbiz.findall();
			if(list.size()>0)
				return "findallSUCCESS";
			return "ERROR";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "ERROR";
		}
	}


	/**
	 * �����û�����ѯ�û���
	 * @return   findnameSUCCESS
	 */
	public String findname()
	{
		try
		{
			System.out.println(username+"loginUsername");
			list=(ArrayList<User>) userbiz.findname(username);
			if(!list.isEmpty())
				return "findnameSUCCESS";
			return "ERROR";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "ERROR";
		}
			
	}
	
	/**
	 * �û���¼
	 * @return
	 */
	public String login()
	{
		try 
		{
			list=(ArrayList<User>)userbiz.login(username, userpwd);
	        if(!list.isEmpty()||list.size()!=0)
	        { 	
	        	ActionContext ac=ActionContext.getContext();
	           	ac.getSession().put("user",list.get(0));//������session��
	            return "loginSUCCESS";
	        }
	        else
	        {
            	massger="�û����������������������";
 	            return "loginERROR";
	        }
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			massger="�û����������������������";
			return "loginERROR";
		}
	}
	
	/**
	 * �˳�ʱ���session�е�����
	 * @return SUCCESS
	 */
	public String session()
	{
		ActionContext ac=ActionContext.getContext();
		ac.getSession().put("userinfo",null);
		return "SUCCESS";
	}

	/**
	 * ��ʾ�����û�ҳ��
	 * @return showadduser
	 */
	public String showAdduser()
	{
		return "showadduser";
	}
	
	/**
	 * ��ת���޺�����ҳ��
	 * @return
	 */
	public String showUpdatepwd(){
		return "showupdatepwd";
	}
	
	
	public IUserBiz<User> getBiz() {
		return userbiz;
	}

	public void setBiz(IUserBiz<User> userbiz) {
		this.userbiz = userbiz;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMassger() {
		return massger;
	}

	public void setMassger(String massger) {
		this.massger = massger;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsernumber() {
		return usernumber;
	}

	public void setUsernumber(String usernumber) {
		this.usernumber = usernumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	public String getUserphone() {
		return userphone;
	}

	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}

	public int getIsservice() {
		return isservice;
	}

	public void setIsservice(int isservice) {
		this.isservice = isservice;
	}

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public ArrayList<User> getList() {
		return list;
	}

	public void setList(ArrayList<User> list) {
		this.list = list;
	}

	public IUserBiz<User> getUserbiz() {
		return userbiz;
	}

	public void setUserbiz(IUserBiz<User> userbiz) {
		this.userbiz = userbiz;
	}

	public String getUserpwdnew() {
		return userpwdnew;
	}

	public void setUserpwdnew(String userpwdnew) {
		this.userpwdnew = userpwdnew;
	}

	

}