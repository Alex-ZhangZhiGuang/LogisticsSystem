package com.sec.ssh.group3.dao;

import java.util.List;
/*
 * 罗萍（用户管理DAO接口）
 */
public interface IUserDao<T>
{
	public void update(T entity);
	public void add(T entity);
	public List<T> login(String username,String userpwd);
	public List<T> find(String sql);
	public T findByid(Class clz,java.io.Serializable id);
	boolean checkOrderPhone(String userPhone);
}
