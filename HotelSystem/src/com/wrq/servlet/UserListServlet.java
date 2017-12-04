package com.wrq.servlet;


import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wrq.utils.JdbcUtils;
import com.wrq.utils.PageBean;

public class UserListServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int pages = 1;
		String account = request.getParameter("account");
		String user_name = request.getParameter("user_name");
		if (request.getParameter("pages")!=null) 
		{
			pages = Integer.parseInt(request.getParameter("pages"));
		}
		StringBuilder sq = new StringBuilder("select * from user where 1=1 ");
		if(account!=null&&account!=""){
			sq.append(" and account like '%"+account+"%'");
			request.setAttribute("account", account);
		}
		if(user_name!=null&&user_name!=""){
			sq.append(" and user_name like '%"+user_name+"%'");
			request.setAttribute("user_name", user_name);
		}
		String sql = sq.toString();
		JdbcUtils jd = new JdbcUtils();
		List<Map<String, Object>> userList = jd.listForPage(sql,pages,5,null);
		PageBean.setPage(sql, jd, request, pages);
		request.setAttribute("userList", userList);
		request.setAttribute("url", "UserListServlet");
		if(userList.size()==0 || userList==null){
			request.setAttribute("message", "没有要显示的数据");
		}
		request.getRequestDispatcher("userList.jsp").forward(request, response);
	}

}
