package com.sec.ssh.group3.biz;
import java.util.List;
/*
 * 罗萍（用户管理Interface）
 */
public interface IUserBiz<User> {
	public void update(User user);
	public void add(User user);
	public List<User> findall();
	public List<User> login(String username,String userpwd);
	public List<User> findname(String username);
	public User findByid(int userid);
}
