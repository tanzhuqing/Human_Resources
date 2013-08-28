<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@page import="db.bean.VRenShiBean"%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>

<%@page import="java.util.ArrayList"%>

<%@page import="db.sqlDao.VRenShiDao"%>
<%@page import="db.bean.BuMenBean"%>
<%@page import="db.sqlDao.BuMenDao"%>
<%@page import="db.bean.Employess_zhiwuBean"%>
<%@page import="db.sqlDao.ZhiwuDao"%>
<html>
	<head>


		<title>员工查询</title>


		<link rel="stylesheet" type="text/css" href="css/style.css">
		<link rel="stylesheet" type="text/css" href="../css/style.css">

	</head>

	<body bgcolor="#9A9AFE">
		<br>
	<body>
		<%
			ArrayList<BuMenBean> alClass = new ArrayList<BuMenBean>();
			BuMenDao cDao = new BuMenDao();
			alClass = cDao.getAllClass();

			ArrayList<Employess_zhiwuBean> alClasszw = new ArrayList<Employess_zhiwuBean>();
			ZhiwuDao Dao = new ZhiwuDao();
			alClasszw = Dao.getAllClasszw();
		%>
		<form action="chaxu.action" method="post">
			<table width="100%" height="100%">
				<tr>
					<td valign="middle">
						<div align="center">
							<font color="red" style="font-size: 15"><b>*如果不输入员工编号将查询出所有的员工*</b>
								<br> </font>
						</div>
						<div>
							<font color="red"> <b>${Error}</b> </font>
						</div>
						<fieldset style="width: 500; height: 250" align="center">
							<legend>
								员工信息的模糊查询查询操作
							</legend>
							<table align="center">
								<tr>
									<td align="right">
										员工ID：
									</td>
									<td style="text-align: left;">
										<input type="text" name="employess_id" style="width: 120">
									</td>

									<td align="right">
										根据姓查找：
									</td>
									<td style="text-align: left;">
										<input type="text" name="name" style="width: 120"
											maxlength="1">
									</td>
								</tr>
								<tr>
									<td align="right">
										根据性别查找：
									</td>
									<td style="text-align: left;">
										<select name="sex" style="width: 120">
											<option value="">

											</option>
											<option value="男">
												男
											</option>
											<option value="女">
												女
											</option>

										</select>
									</td>


									<td align="right">
										根据学历查找：
									</td>
									<td>
										<select name="study" style="width: 120">
											<option value="">

											</option>
											<option value="小学">
												小学
											</option>
											<option value="中学">
												中学
											</option>
											<option value="高中">
												高中
											</option>
											<option value="大学">
												大学
											</option>
											<option value="硕士">
												硕士
											</option>
											<option value="博士">
												博士
											</option>
										</select>
									</td>
								</tr>
								<tr>
									<td align="right">
										根据政治面貌查找：
									</td>
									<td>
										<select name="politically" style="width: 120">
											<option value="">

											</option>
											<option value="团员">
												团员
											</option>
											<option value="党员">
												党员
											</option>
											<option value="其他">
												其他
											</option>
										</select>
									</td>
								</tr>
								<tr>
									<td align="right">
										部门：
									</td>
									<td>
										<select name="professional" style="width: 120">

											<option value="">
												==请选择==
											</option>
											<%
												String professional = (String) request.getAttribute("professional");
											%>
											<%
												for (int j = 0; j < alClass.size(); j++) {
											%>
											<option
												value="<%=alClass.get(j).getEmployees_professional()%>"
												<%if(alClass.get(j).getEmployees_professional().equals(professional)){ %>
												selected="selected" <%} %>>

												<%=alClass.get(j).getEmployees_professional()%>
											</option>

											<%
												}
											%>
										</select>

									</td>
								</tr>
								<tr>
									<td align="right">
										职位：
									</td>
									<td>
										<select name="job" style="width: 120">
											<option value="">
												==请选择==
											</option>
											<%
												String section = (String) request.getAttribute("section");
											%>
											<%
												for (int i = 0; i < alClasszw.size(); i++) {
											%>
											<option value="<%=alClasszw.get(i).getEmployess_job()%>"
												<%if(alClasszw.get(i).getEmployess_job().equals(section)){ %>
												selected="selected" <%} %>>

												<%=alClasszw.get(i).getEmployess_job()%>
											</option>

											<%
												}
											%>
										</select>
									</td>
								</tr>
								<td colspan="4" align="center">
									<input type="submit" value="查询" class="btn_2k3">
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="reset" value="重置" class="btn_2k3">
								</td>

							</table>
						</fieldset>
					</td>
				</tr>
			</table>

		</form>
</html>
