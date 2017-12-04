package com.wrq.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.sun.java_cup.internal.internal_error;
import com.wrq.model.User;
import com.wrq.utils.JdbcUtils;
import com.wrq.dao.UserDao;

public class UserService {
	UserDao userDao = new UserDao();
	//��½
	public Map<String, Object> login(String account,String password){
		Map<String, Object> userMap = userDao.login(account, password);
		if(userMap.size()>0)
		{
			return userMap;
		}else {
			throw new RuntimeException("�û������������");
		}
		
	}
	//��ѯlist
	public List<Map<String, Object>> userList(HttpServletRequest request,User user,int pages,int records){
		List<Map<String, Object>> userList = userDao.userList(request, user, pages, records);
		if(userList.size()>0)
		{
			return userList;
		}else {
			throw new RuntimeException("û��Ҫ��ʾ������");
		}
		
	}
	//���
	public int add(User user){
		int result = userDao.add(user);
		if(result>0){
			return result;
		}
		else {
			throw new RuntimeException("���ʧ��");
		}
	}
	//ͨ��id��ѯ
	public Map<String, Object> load(int user_id){
		Map<String, Object> userMap = userDao.load(user_id);  
		return userMap;
	}
	//�޸�
	public int mdi(User user){
		int result = userDao.mdi(user);
		if(result>0){
			return result;
		}
		else {
			throw new RuntimeException("�޸�ʧ��");
		}
	}
	//ɾ��
	
	public int del(User user){
		int result = userDao.del(user);
		if(result>0){
			return result;
		}
		else {
			throw new RuntimeException("ɾ��ʧ��");
		}
	}
}
