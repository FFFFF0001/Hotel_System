package com.wrq.service;

import java.util.Map;

import com.wrq.utils.JdbcUtils;
import com.wrq.dao.UserDao;

public class UserService {
	UserDao userDao = new UserDao();
	public Map<String, Object> login(String account,String password){
		Map<String, Object> userMap = userDao.login(account, password);
		if(userMap.size()>0)
		{
			return userMap;
		}else {
			throw new RuntimeException("用户名或密码错误");
		}
		
	}
}
