package com.wrq.dao;

import java.util.Map;

import com.wrq.utils.JdbcUtils;

public class UserDao {
	JdbcUtils jd = new JdbcUtils();
	public Map<String, Object> login(String account,String password){
		String sql = "select * from user where account=? and password=? ";
		Map<String, Object> userMap = jd.login(sql, account, password);
		return userMap;
	}
}
