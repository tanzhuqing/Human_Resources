<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@page import="db.bean.Super_employeesBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>

<html>
	<head>
		<title>删除</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<script type="text/javascript" src="js/function.js"></script>
	
	</head>
	<body bgcolor="#9A9AFE">
		<table width="100%" height="100%" border="0" cellpadding="0"
			cellspacing="0">
			<tr>
				<td align="center" valign="top">
					<div>
						<form action="" method="post"
							name="employessForm">
							<br>
								<font color="red" style="font-size: 20"> <b>${Error}</b>
								</font>
						</form>
					</div>
					<br>
					<%
								ArrayList<Super_employeesBean> al = (ArrayList<Super_employeesBean>) ActionContext
								.getContext().get("user");
						if (al != null && al.size() > 0) {
							for (int i = 0; i < al.size(); i++) {
								Super_employeesBean ub = al.get(i);
					%>
					<div>
						<table border="1" cellspacing="0" width="800" bgcolor="#FFFFFF"
							align="center" class="text">
							<tr class="top_tr">
								<td width="25%" align="center">
									编号
								</td>

								<td width="25%" align="center">
									用户名：
								</td>

							
								<td width="25%" align="center">
									操作功能
								</td>
							</tr>

							<tr>
								<td align="center">
									<%=ub.getId()%>
								</td>
								<td align="center">
									<%=ub.getUser()%>
								</td>
								
								<td align="center">
									<a
										href="toDeleteEmployee.action?id=
										<%=ub.getId()%>">删除</a>
								</td>
							</tr>

						</table>
					</div>
					<%
						}
						}else{
					%>
					<font color="red" style="font-size: 20"> <b>没有可删除的操作员！</b>
								</font>
					<%} %>
				</td>
			</tr>
		</table>
	</body>
</html>

