<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>

<%@page import="java.util.ArrayList"%>
<%@page import="db.bean.VRenShiBean"%>
<%@page import="db.bean.Employees_InformationBean"%>


<html>
	<head>


		<title>查询结果</title>


		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<script type="text/javascript" src="../js/function.js"></script>
		<script type="text/javascript" src="../js/show_title.js"></script>
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<link rel="stylesheet" type="text/css" href="../css/style.css">

	</head>

	<body bgcolor="#9A9AFE">
	<body>
		<table width="100%" height="100%">
			<tr>
				<td valign="top">
					<table align="center" border="1" width="100%">
						<tr class="top_tr">
							<td width="10%">

								序号
							</td>
							<td width="10%" align="center">
								员工编号
							</td>
							<td width="10%" align="center">
								员工姓名
							</td>
							<td width="10%" align="center">
								员工姓别
							</td>
							<td width="10%" align="center">
								员工学历
							</td>
							<td width="10%" align="center">
								政治面貌
							</td>
							<td width="10%" align="center">
								合同起始时间
							</td>
							<td width="10%" align="center">
								合同终止时间
							</td>
							<td width="10%" align="center">
								部门
							</td>
							<td width="0%" align="center">
								职务
							</td>
						</tr>
						<%
							ArrayList<Employees_InformationBean> al = (ArrayList<Employees_InformationBean>) request
									.getAttribute("ArrayList");

							if (al != null) {
								for (int i = 0; i < al.size(); i++) {
						%>
						<tr>
							<td width="10%" align="center">
								<%=al.get(i).getId()%>
							</td>
							<td width="10%" align="center">
								<%=al.get(i).getEmployess_id()%>
							<td width="10%" align="center">
								<%=al.get(i).getEmployees_name()%>
							</td>
							<td width="10" align="center">
								<%=al.get(i).getEmployees_sex()%>
							</td>

							<td width="10" align="center">
								<%=al.get(i).getEmployees_study()%>
							</td>
							<td width="10%" align="center">
								<%=al.get(i).getEmployees_politically()%>
							</td>


							<td width="10%" align="center">
								<%=al.get(i).getEmployess_jointime()%>
							</td>
							<td width="10%" align="center">
								<%=al.get(i).getElmployess_engtime()%>
							</td>
							<td width="10%" align="center">
								<%=al.get(i).getEmployees_professional()%>
							</td>
							<td width="10%" align="center">
								<%=al.get(i).getEmployess_job()%>
							</td>
						</tr>
						<%
							}
							} else {
						%>
						<tr>
							<td colspan="8">
								没有符合条件的相关信息
							</td>
						</tr>
						<%
							}
						%>

					</table>
				</td>
			</tr>
			
		</table>
	</body>
</html>


