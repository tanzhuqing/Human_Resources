<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>


		<title>奖惩管理</title>

		<link rel="stylesheet" type="text/css" href="../css/style.css">
		<script type="text/javascript" src="../js/function.js"></script>
		<script type="text/javascript" src="../js/show_title.js"></script>



		<script type="text/javascript">
			function checkForm(form){
			if(form.id.value==""){
					alert("【员工id】不能为空！");
					form.id.focus();
					return false;
				}else if(form.status.value==""){
					alert("【状态】不能为空！");
					form.status.focus();
					return false;
				}else if(form.matter.value==""){
					alert("【考勤原因】不能为空！");
					form.matter.focus();
					return false;
				}
				return true;
				}
			</script>
	</head>

	<body bgcolor="#9A9AFE">
		<table width="100%" height="100%" border="0" cellpadding="0"
			cellspacing="0">
			<tr>
				<td align="center" valign="middle">

					<form action="UpdateKao.action" method="post" name="Form">
					<input type="hidden" name="kong" value="${bean.id}">
						<table align="center" border="0">
						
							<tr>
								<div>
									<font color="red" style="font-size: 20"> <b>${Error}</b>
									</font>
								</div>
							</tr>
							<tr>
								<td colspan="2">
									员工id:${bean.employess_id}
								</td>
							<tr>
							<tr>
								<td>
									考勤状态：
								</td>
								<td>
							<select name="status" style="width: 155">
							<option value="">
								==请选择==
							</option>
							<%
								String status = (String) request.getAttribute("status");
							%>
							<option value="	出勤" <%if("出勤".equals(status)){ %> selected="selected"
								<%}%>>
								出勤
							</option>
							<option value="旷工" <%if("旷工".equals(status)){ %> selected="selected"
								<%}%>>
								旷工
							</option>
						</select>
								</td>
							<tr>
								<td>
									考勤原因：
								</td>
								<td>
									<input type="text" name="matter" value="${bean.matter}">
								</td>
							</tr>
							<tr>
								<td>
									<input type="submit" value="修改"
										onclick="return checkForm(Form);">
								</td>

							</tr>




						</table>
					</form>
				</td>
			</tr>
		</table>

	</body>

</html>
