<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	response.setContentType("text/html;charset=utf-8");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	List<Map<String, Object>> userList = (List<Map<String, Object>>) request.getAttribute("userList");
	
	
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>无标题文档</title>
		<link href="css/style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="js/jquery.js"></script>

		


	</head>


	<body>

		<div class="place">
			<span>位置：</span>
			<ul class="placeul">
				<li>
					<a href="#">首页</a>
				</li>
				<li>
					<a href="#">数据表</a>
				</li>
				<li>
					<a href="#">基本内容</a>
				</li>
			</ul>
		</div>

		<div class="rightinfo">

			<div class="tools">

				<ul class="toolbar">
					<li class="click">
						<a href="userAdd.jsp"><span><img src="images/t01.png" />
						</span>添加</a>
					</li>

				</ul>

				<form action="UserListServlet" method="post">
				<ul class="toolbar1">
					<li>
						姓名：<input value="${user_name }" type="text" name="user_name">
						账号：<input value="${account }" type="text" name="account">
						<input type="submit" value="查询">
					</li>
				</ul>
				</form>
			</div>


			<table class="tablelist">
				<thead>
					<tr>
						<th>
							<input name="" type="checkbox" value="" checked="checked" />
						</th>
						<th>
							姓名
							<i class="sort"><img src="images/px.gif" />
							</i>
						</th>
						<th>
							账号
						</th>
						<th>
							电话
						</th>
						<th>
							身份证
						</th>
						<th>
							权限
						</th>
						<th>
							年龄
						</th>
						<th>
							性别
						</th>
						<th>
							状态
						</th>
						<th>
							操作
						</th>
					</tr> 
				</thead>
				<tbody>
					<%if(userList.size()>0&& userList!=null){
						for(Map<String,Object> userMap : userList){
					 %>
					
					<tr>
						<td>
							<input name="user_id" type="checkbox" value="<%=userMap.get("user_id") %>" />
						</td>
						<td>
							<%=userMap.get("user_name") %>
						</td>
						<td>
							<%=userMap.get("account") %>
						</td>
						<td>
							<%=userMap.get("tel") %>
						</td>
						<td>
							<%=userMap.get("card") %>
						</td>
						<td>
							<%=userMap.get("power").equals(1)?"总经理":userMap.get("power").equals(2)?"人事部经理":userMap.get("power").equals(3)?"客户经理":"前台" %>
						</td>
						<td>
							<%=userMap.get("age") %>
						</td>
						<td> 
							<%=userMap.get("sex").equals(1)?"男":"女"%>
						</td>
						<td> 
							<%=userMap.get("status").equals(1)?"在职":"离职"%>
						</td>
						<td>
							<a href="UserMdiQueryServlet?user_id=<%=userMap.get("user_id") %>" class="tablelink">修改</a>
							<a href="userDel.jsp?user_id=<%=userMap.get("user_id") %>" class="tablelink"> 删除</a>
						</td>
					</tr>
					<%} }else{%>
						<td colspan="10" align="center">
							<font color="red" >${message }</font>
						</td>
					<%} %>

				</tbody>
			</table>

			<jsp:include page="pages.jsp"></jsp:include>
			




		</div>

		<script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>

	</body>

</html>
