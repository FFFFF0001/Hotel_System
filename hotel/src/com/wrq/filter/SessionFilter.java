package com.wrq.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class Session
 */

public class SessionFilter implements Filter {
	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		//��requestת�������ǳ��õ�request
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		HttpSession session = request.getSession();
		//��ȡ����·��
		String path = request.getServletPath();
		//��֤session�ų���¼ҳ��ʹ�sessionҳ��
		if(session.getAttribute("userMap")==null&&!path.endsWith("login.jsp")&&!path.endsWith("LoginServlet.do")){
			//��ѭhtml���԰�ҳ������ΪUTF-8
			response.setContentType("text/html;charset=UTF-8");
			//��ȡout����
			PrintWriter out = response.getWriter();
			//ͨ��js��ʾ�û�����תҳ��
			out.write("<script>alert('���¼!');window.top.location.href='login.jsp'</script>");
		}else {
			chain.doFilter(req, res);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
