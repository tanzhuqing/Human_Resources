<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page import="db.bean.Employess_Zhiwu_NoteBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="db.bean.Employees_InformationBean"%>
<%@page import="db.bean.VRenShiBean"%>
<%@page import="db.sqlDao.Employees_InformationDao"%>
<%@page import="db.sqlDao.VRenShiDao"%>
<html>
	<head>
		<title>人事调动查询界面</title>

		<link rel="stylesheet" type="text/css" href="css/style.css">
		<link rel="stylesheet" type="text/css" href="../css/style.css">
		<script type="text/javascript">
			function back(form){
				document.fanhuiForm.action="fanhui.action";
				document.fanhuiForm.submit();
			}	
			function aa(){
				var f = window.confirm("此信息为职务调动信息，您确认要删除吗？");
				if(!f){
					return false;
				}
			}
		</script>
	</head>

	<body bgcolor="#9A9AFE">

		<%
			ActionContext act = ActionContext.getContext();
			ArrayList<VRenShiBean> al = (ArrayList<VRenShiBean>) act
					.get("ArrayList");

			ArrayList<Employees_InformationBean> alClass = new ArrayList<Employees_InformationBean>();
			VRenShiDao cDao = new VRenShiDao();
			alClass = cDao.getAllClass();
		%>
		<form action="demand.action" method="post" name="fanhuiForm">


			<table align="center" height="100%">
				<tr>
					<td align="center">
						<font color="red">${Error }</font>
					</td>
				<tr>
					<td>
						编号：
						<input type="text" name="id" style="width: 100">
						姓名：
						<input type="text" name="name" style="width: 100">
						<input type="submit" value="查询">
						&nbsp;&nbsp;
						<input type="button" value="返回" onclick="back(fanhuiForm)">
						<table width="100%" height="100%">
							<tr>
								<td align="center" valign="top">
									<table border="1" width="500">
										<tr>
											<td align="center">
												序号
											</td>
											<td align="center">
												员工ID
											</td>
											<td align="center">
												员工姓名
											</td>
											<td align="center">
												调动时间
											</td>
											<td align="center">
												职位
											</td>

											<td align="center">
												操作
											</td>
										</tr>

										<tr>
											<%
												if (al != null && al.size() > 0) {
													for (int i = 0; i < al.size(); i++) {
											%>

											<td width="10%" align="center">
												<%=i + 1%>
											</td>
											<td width="10%" align="center">
												<%=al.get(i).getEmployess_id()%>
											</td>

											<td width="15%" align="center">
												<%=al.get(i).getEmployees_name()%>
											</td>

											<td width="20%" align="center">
												<%=al.get(i).getTime()%>
											</td>
											<td width="15%" align="center">
												<%=al.get(i).getEmployess_job()%>
											</td>

											<td width="15%" align="center">
												<a href="deleteRenShi.action?id=<%=al.get(i).getId()%>"
													onclick="return aa();">删除</a>
											</td>
										</tr>

										<%
											}
											}
										%>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>