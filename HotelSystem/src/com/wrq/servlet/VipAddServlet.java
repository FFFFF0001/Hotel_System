package com.wrq.servlet;


import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wrq.utils.JdbcUtils;

public class VipAddServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

	String vip_name = request.getParameter("vip_name");
	String vip_tel = request.getParameter("vip_tel");
	String vip_address = request.getParameter("vip_address");
	String vip_sex = request.getParameter("vip_sex");
	String vip_card = request.getParameter("vip_card");
	String vip_grade = request.getParameter("vip_grade");
	String sql="insert into vip (vip_name,vip_tel,vip_address,vip_sex,vip_card,vip_grade) values (?,?,?,?,?,?)";
	JdbcUtils jd = new JdbcUtils();
	int result = jd.update(sql, new Object[]{vip_name,vip_tel,vip_address,vip_sex,vip_card,vip_grade});
	if(result>0){
		request.setAttribute("message", "��ӳɹ�");
	}else{
		request.setAttribute("message", "���ʧ��");
	}
	request.setAttribute("url", "VipListServlet");
	request.getRequestDispatcher("message.jsp").forward(request, response);
}
}
