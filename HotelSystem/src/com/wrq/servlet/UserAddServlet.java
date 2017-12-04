package com.wrq.servlet;


import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.wrq.utils.JdbcUtils;

public class UserAddServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String user_name = request.getParameter("user_name");
		String account = request.getParameter("account");
		String tel = request.getParameter("tel");
		String sex = request.getParameter("sex");
		String age = request.getParameter("age");
		String power = request.getParameter("power");
		String card = request.getParameter("card");
		String password="123456";
		int status = 1;
		String sql="insert into user (user_name,account,tel,sex,age,power,card,password,status) values (?,?,?,?,?,?,?,?,?)";
		JdbcUtils jd = new JdbcUtils();
		int result = jd.update(sql, new Object[]{user_name,account,tel,sex,age,power,card,password,status});
		if(result>0){
			request.setAttribute("message", "添加成功");
		}else{
			request.setAttribute("message", "添加失败");
		}
		request.getRequestDispatcher("message.jsp").forward(request, response);
	}

}
