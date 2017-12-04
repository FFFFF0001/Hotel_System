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

public class UserMdiQueryServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int user_id = Integer.parseInt(request.getParameter("user_id"));
		String sql = "select * from user where user_id=?";
		JdbcUtils jd = new JdbcUtils();
		Map<String, Object> userMap = jd.queryById(sql, user_id);
		request.setAttribute("userMap", userMap);
		request.setAttribute("user_id", user_id);
		request.getRequestDispatcher("userMdi.jsp").forward(request,response);

}
}

