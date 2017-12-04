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

public class VipDelServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		int vip_id = Integer.parseInt(request.getParameter("vip_id")); 
		String sql = " delete from vip where vip_id =?";
		JdbcUtils jd = new JdbcUtils();
		int result = jd.update(sql, new Object[]{vip_id});
		if(result>0){
			request.setAttribute("message", "ɾ���ɹ�");
		}else{
			request.setAttribute("message", "ɾ��ʧ��");
		}
		request.setAttribute("url", "VipListServlet");
		request.getRequestDispatcher("message.jsp").forward(request, response);
}
}
