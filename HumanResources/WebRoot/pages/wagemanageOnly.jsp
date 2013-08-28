<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList"%>

<%@page import="com.opensymphony.xwork2.ActionContext"%>

<%@page import="db.bean.VZhiWuBean"%>
<%@page import="db.bean.Employess_Wage_NoteBean"%>

<html>
	<head>
		<title>工资管理</title>
		<script type="text/javascript" src="../js/function.js"></script>
		<script type="text/javascript" src="../js/show_title.js"></script>
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<link rel="stylesheet" type="text/css" href="../css/style.css">

	</head>
	<script type="text/javascript">
			
			function aa(){
				var f = window.confirm("此信息为工资信息，您确认要删除吗？");
				if(!f){
					return false;
				}
			}
		</script>
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
					<form action="selectOnly.action" method="post" name="operForm">
						<fieldset style="width: 800">
							<legend>
								查询工资
							</legend>
							<table width="100%" border="1" align="center" height="100%">
								<tr>
									<td>
										员工编号：
										<input type="text" maxlength="6" name="workerID"
											title="只能输入数字！">
										员工姓名：
										<input type="text" name="name">

										<input type="submit" value="查询" class="btn_2K3"
											onclick="back(operForm)">

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
				<td align="center" width="10%">
					序号
				</td>
				<td align="center" width="10%">
					员工ID
				</td>
				<td align="center" width="15%">
					员工姓名
				</td>
				<td align="center" width="20%">
					时间
				</td>
				<td align="center" width="15%">
					工资
				</td>

				<td align="center" width="15%">
					操作
				</td>
				<td align="center" width="15%">
					操作员工
				</td>

			</tr>

			<%
				ActionContext act = ActionContext.getContext();

				ArrayList<VZhiWuBean> aVbean = (ArrayList<VZhiWuBean>) act
						.get("ArrayList");
			
			%>
			<tr>
				<%
					if (aVbean != null && aVbean.size() > 0) {
						if (!aVbean.isEmpty()) {
							for (int i = 0; i < aVbean.size(); i++) {
				%>
				<td align="center">
					<%=i + 1%>
				</td>
				<td align="center">
					<%=aVbean.get(i).getEmployess_id()%>
				</td>
				<td align="center">

					<%=aVbean.get(i).getEmployees_name()%>

				</td>
				<td align="center">
					<%=aVbean.get(i).getTime()%>
				</td>
				<td align="center">
					<%=aVbean.get(i).getMoney()%>元
				</td>
				<td align="center">
					<a href="updateGongzhi.action?id=<%=aVbean.get(i).getId()%>">修改</a>
					<a href="deleteGongzhi.action?id=<%=aVbean.get(i).getId()%>& employess_id<%=aVbean.get(i).getEmployess_id() %>"
						onclick="return aa();">删除</a>
					<a
						href="addGongziSelect.action?employess_id=<%=aVbean.get(i).getEmployess_id()%>">添加</a>
				</td>
				<td align="center">
					<%=aVbean.get(i).getUser()%>
				</td>
			</tr>
			<tr>
				<%
					}
						}
				%>
			
			<tr>
				<td align="center" colspan="7">
					<a href="pages/administerMan.jsp">返回</a>
				</td>
			</tr>
			<%
				}
			%>
		</table>
	</body>
</html>
