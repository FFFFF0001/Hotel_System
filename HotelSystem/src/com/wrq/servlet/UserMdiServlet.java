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

public class UserMdiServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int user_id = Integer.parseInt(request.getParameter("user_id"));
		String user_name = request.getParameter("user_name");
		String account = request.getParameter("account");
		String tel = request.getParameter("tel");
		String sex = request.getParameter("sex");
		String age = request.getParameter("age");
		String power = request.getParameter("power");
		String card = request.getParameter("card");
		String sql="update user set user_name=?,account=?,tel=?,sex=?,age=?,power=?,card=? where user_id=?";
		JdbcUtils jd = new JdbcUtils();
		int result = jd.update(sql, new Object[]{user_name,account,tel,sex,age,power,card,user_id});
		if(result>0){
			request.setAttribute("message", "修改成功");
		}else{
			request.setAttribute("message", "修改失败");
		}
		request.getRequestDispatcher("message.jsp").forward(request, response);

}
}

