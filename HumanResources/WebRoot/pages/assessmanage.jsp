<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="db.bean.employessAssessBean"%>
<%@page import="db.bean.Employees_InformationBean"%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>

<html>
	<head>


		<title>考评管理</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<link rel="stylesheet" type="text/css" href="../css/style.css">
	</head>
	<script type="text/javascript">
		function checkForm(form){   
			function resetClick(form){
			form.employess_id.value = "";
		
		}
	}	
		function aa(){
				var f = window.confirm("确认要删除吗？");
				if(!f){
					return false;
				}
			}
	function selectClick(form){
			   
				document.loginForm.action="result1.action";
				document.loginForm.submit();
			}
			</script>
	<body bgcolor="#9A9AFE">
		<table width="100%" border="0" cellpadding="0">

			<tr>
				<td align="center" valign="top">
					<form action="assessmanage.action" method="post" name="loginForm">
						<fieldset style="width: 800">
							<legend>
								员工考勤管理
							</legend>
							<table width="100%" align="center" height="100%">
								<tr>
									<td align="center" colspan="5">

									</td>
								</tr>

								<tr valign="top">
									<td align="center">
										请输入员工的编号：
										<input type="text" maxlength="6" name="employess_id"
											onkeyup="keyPressClick(employess_id)" title="只能输入数字">
									</td>
									<td>
										姓名:
										<input type="text" name="employees_name">

									</td>
									<td>
										性别：
										<select name="employees_sex" style="width: 150">
											<option>
												=====请选择====
											</option>

											<option>
												男
											</option>

											<option>
												女
											</option>

										</select>

									</td>

									<td valign="bottom">
										<input type="submit" class="btn_2k3" value="查询"
											onclick="return checkForm(loginForm)">
									</td>
									<td valign="bottom">
										<input type="button" value="添加" class="btn_2k3"
											onclick="selectClick(loginForm)">
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
					员 工 ID
				</td>
				<td align="center" width="100">
					姓名
				</td>
				<td align="center" width="100">
					性别
				</td>

				<td align="center" width="120">
					考 评 时 间
				</td>
				<td align="center" width="120">
					考 勤 状 态

				</td>
				<td align="center" width="120">
					考 勤 原 因
				</td>
				<td align="center" width="120">
					操作：
				</td>
			</tr>
			<%
						ArrayList<employessAssessBean> al = (ArrayList<employessAssessBean>) request
						.getAttribute("ArrayList");

				if (al != null && al.size() > 0) {
					for (int i = 0; i < al.size(); i++) {
						employessAssessBean bean = al.get(i);
			%>
			<tr>

				<td align="center">
					<%=bean.getEmployess_id() == null ? "" : bean
							.getEmployess_id()%>
				</td>

				<td align="center">
					<%=bean.getEmployees_name() == null ? "" : bean
							.getEmployees_name()%>
				</td>

				<td align="center">
					<%=bean.getEmployees_sex() == null ? "" : bean
							.getEmployees_sex()%>
				</td>

				<td align="center">
					<%=bean.getTime() == null ? "" : bean
									.getTime()%>
				</td>
				<td align="center">
					<%
					if ("旷工".equals(bean.getStatus())) {
					%>
					旷工
					<%
					} else {
					%>
					出勤
					<%
					}
					%>

				</td>
				<td align="center">
					<%=bean.getMatter() == null ? "" : bean
							.getMatter()%>
				</td>
				<td align="center">
					<a href="delets.action?employess_id=<%=bean.getId()%>"
						onclick="return aa();">删除</a>

					<a href="updatex.action?employess_id=<%=bean.getId()%>"
						onclick="return bb();">修改</a>
				</td>
			</tr>


			<%
				}

				} else {
			%>
			<tr>
				<td colspan="7" align="center">
					<font color="red">暂无信息</font>
				</td>
			</tr>
			<%
			}
			%>
		</table>

	</body>

</html>

