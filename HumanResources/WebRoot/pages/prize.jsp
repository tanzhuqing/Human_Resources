<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page import="db.bean.Employess_Wage_NoteBean"%>
<html>
	<head>
		<title>调薪查询</title>
		<script type="text/javascript" src="../js/function.js"></script>
		<script type="text/javascript" src="../js/show_title.js"></script>
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<link rel="stylesheet" type="text/css" href="../css/style.css">

	</head>
	<body>
		<table width="100%" border="0" cellpadding="0">
			<tr>
				<td>
					<div>
						<font color="red" style="font-size: 20"> <b>${Error}</b> </font>
					</div>
				</td>
			</tr>
			<tr>
				<td align="center" valign="top">
					<form action="paychaxuna.action" method="post" name="operForm">
						<fieldset style="width: 800">
							<legend>
								调薪查询
							</legend>

							<table width="100%" border="1" align="center" height="100%">
								<tr>
									<td>
										请输入员工的编号：
										<input type="text" maxlength="6" name="employess_id"
											onkeyup="keyPressClick(employess_id)" title="只能输入数字"
											value="${workerID }">
										<input type="submit" value="查询" class="btn_2K3">
										<input type="reset" value="重置" class="btn_2K3">

									</td>
								</tr>
							</table>
						</fieldset>
					</form>
				</td>
			</tr>
		</table>
		<table width="800" border="1" align="center">
			<tr class="top_tr">
				<td align="center" width="100">
					序号
				</td>
				<td align="center" width="100">
					员工ID
				</td>
				<td align="center" width="150">
					工资
				</td>
				<td align="center" width="200">
					时间
				</td>
			</tr>

			<%
				ActionContext act = ActionContext.getContext();

				ArrayList<Employess_Wage_NoteBean> al = (ArrayList<Employess_Wage_NoteBean>) act
						.get("emoloyList");
				if (al != null) {
					for (int i = 0; i < al.size(); i++) {
						//for (Employess_wage_noteBean bean : al) {
			%>
			<tr>
				<td align="center">
					<%=i + 1%>
				</td>
				<td align="center">
					<%=al.get(i).getEmployess_id()%>
				</td>
				<td align="center">
					<%=al.get(i).getMoney()%>元
				</td>
				<td align="center">
					<%=al.get(i).getTime()%>
				</td>
			</tr>
			<%
				}
				}
			%>
			<tr>
				<td align="center" colspan="4">
					<a href="pages/administerMan.jsp">返回</a>
				</td>
			</tr>
		</table>

	</body>
</html>

