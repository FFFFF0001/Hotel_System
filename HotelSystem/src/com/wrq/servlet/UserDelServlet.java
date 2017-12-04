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

public class UserDelServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int user_id = Integer.parseInt(request.getParameter("user_id")); 
		String sql = "update user set status=-1 where user_id=?";
		JdbcUtils jd = new JdbcUtils();
		int result = jd.update(sql, new Object[]{user_id});
		if(result>0){
			request.setAttribute("message", "É¾³ý³É¹¦");
		}else{
			request.setAttribute("message", "É¾³ýÊ§°Ü");
		}
		request.getRequestDispatcher("message.jsp").forward(request, response);

}
}

