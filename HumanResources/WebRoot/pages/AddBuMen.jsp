<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="db.bean.BuMenBean"%>

<html>
	<head>
		<title>操作员管理页面</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<script type="text/javascript">
			function aa(){
				var f = window.confirm("确认要删除吗？");
				if(!f){
					return false;
				}
			}
		</script>
	</head>
	<body>
		<table width="100%" height="100%" border="0" cellpadding="0"
			cellspacing="0">
			<tr>
				<td align="center" valign="top">
					<div>
						<br>
						<font color="red" style="font-size: 20">${Error}</font>
					</div>
					<form action="tosave.action" method="post" name="OperForm">
						<fieldset style="width: 800">
							<legend>
								添加操作员操作
							</legend>
							<div align="center">
								<input type="submit" value="添加部门" class="btn_2k3"
									style="width: 140">
								&nbsp;

							</div>

						</fieldset>
					</form>
					<br>
					<table border="1" cellspacing="0" width="800" bgcolor="#FFFFFF"
						align="center" class="text">
						<tr class="top_tr">

							<td width="11%" align="center">
								id
							</td>
							<td width="10%" align="center">
								部门
							</td>
							<td width="10%" align="center">
								操作：
							</td>
						</tr>
						<%
									ArrayList<BuMenBean> al = (ArrayList<BuMenBean>) request
									.getAttribute("all");
							if (al != null && al.size() > 0) {
								for (int i = 0; i < al.size(); i++) {
									BuMenBean ub = al.get(i);
						%>
						<tr>

							<td align="center">
								<%=ub.getId()%>
							</td>
							<td align="center">
								<%=ub.getEmployees_professional()%>
							</td>

							<td align="center">
								<a href="delet.action?id=<%=ub.getId()%>" onclick="return aa();">删除</a>
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
	</body>
</html>
