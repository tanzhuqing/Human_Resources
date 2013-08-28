<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page import="db.bean.employessTrainBean"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>

<html>
	<head>


		<title>培训管理</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<link rel="stylesheet" type="text/css" href="../css/style.css">
		<script type="text/javascript" src="../js/function.js"></script>
		<script type="text/javascript" src="../js/show_title.js"></script>
	</head>
	<script type="text/javascript">  
			function resetClick(form){
			form.employess_id.value = "";

	}	
	function selectClick(form){
				document.loginForm.action="exit.action";
				document.loginForm.submit();
			}
				
			</script>



	<script type="text/javascript">
			
				function add(form){
			   
				document.loginForm.action="Trainmetter.action";
				document.loginForm.submit();
			}
			</script>
	<body bgcolor="#9A9AFE">
		<table width="100%" height="100%" border="0" cellpadding="0"
			cellspacing="0">
			<tr>
				<td align="center" valign="top">
					<div>
						<br>
						<font color="red" style="font-size: 20">${Error}</font>
					</div>
					<form action="assesschaxun1.action" method="post" name="loginForm">
						<fieldset style="width: 800">
							<legend>
								员工培训管理
							</legend>
							<table width="100%" align="center" height="100%">
								<tr>
									<td align="center">
										请输入员工的编号：
										<input type="text" maxlength="4" name="employess_id"
											onkeyup="keyPressClick(employess_id)" title="只能输入数字">
									</td>

									<td align="center">
										请输入姓名：
										<input type="text" name="name" value="${name }">
									</td>
									<td valign="bottom">
										<input type="submit" class="btn_2k3" value="查 询"
											onclick="return checkForm(loginForm)">
									</td>
									<td valign="bottom">
										<input type="button" value="添加" class="btn_2k3"
											onclick="add(loginForm)">
									</td>
									<td valign="bottom">
										<input type="button" value="返回" class="btn_2k3"
											onclick="selectClick(loginForm)">
									</td>

								</tr>
							</table>
						</fieldset>
					</form>
					<br>
					<table border="1" cellspacing="0" width="800" bgcolor="#FFFFFF"
						align="center" class="text">
						<tr class="top_tr">
							<td align="center" width="100">
								序 号
							</td>
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
								培训 时 间
							</td>
							<td align="center" width="120">
								培 训状 态
							</td>
							<td align="center" width="120">
								培 训 原 因
							</td>
						</tr>
						<%
									ArrayList<employessTrainBean> al = (ArrayList<employessTrainBean>) request
									.getAttribute("ArrayList_Card");
									DateFormat f1 =new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
							if (al != null && al.size() > 0) {
								for (int i = 0; i < al.size(); i++) {
									employessTrainBean bean = al.get(i);
						%>
						<tr>
							<td align="center">
								<%=(i + 1)%>
							</td>
							<td align="center">
								<%=bean.getEmployess_id()%>
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
								<%=bean.getMonth()%>
							</td>
							<td align="center">

								<%
								if (bean.getStatus().equals("1")) {
								%>
								培训
								<%
								} else {
								%>

								不培训
								<%
								}
								%>

							</td>
							<td align="center">
								<%=bean.getMatter()%>
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
				</td>
			</tr>
		</table>
	</body>

</html>

