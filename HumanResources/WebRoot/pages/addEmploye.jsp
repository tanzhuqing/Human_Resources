<%@ page language="java" contentType="text/html; charset=utf-8"%>
<html>
	<head>
		<title>添加操作员</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
		<link rel="stylesheet" type="text/css" href="../css/style.css">
		<script type="text/javascript" src="js/function.js"></script>
		<script type="text/javascript" src="js/show_title.js"></script>
		<script type="text/javascript">
			function checkForm(form){
				if(form.employee_Name.value==""){
					alert("【姓名】不能为空！");
					form.employee_Name.focus();
					return false;
				}
				
				if(form.pass.value==""){
					alert("【密码】不能为空！");
					form.employee_Role.focus();
					return false;
				}			
			}
		
		</script>
	</head>
	<body bgcolor="#9A9AFE">${Error }
		<table width="100%" height="100%" border="0" cellpadding="0"
			cellspacing="0">
			<tr>
				<td align="center" valign="middle">
				
				
					
					<form action="addSaveElployess.action" method="post" name="operForm">
						<table align="center" border="0">
						
							<tr>
								<td align="right" width="100">
									用户名：
								</td>
								<td align="left" width="200">
									<input type="text" name="employee_Name" maxlength="32"
										 style="width: 150">
									
								</td>
							</tr>
							<tr>
								<td align="right">
									新密码：
								</td>
								<td align="left">
									<input type="password" name="pass" maxlength="32"
									 style="width: 150">
									
								</td>
							</tr>
							<tr>
								<td align="right">
									确&nbsp;&nbsp; 认：
								</td>
								<td align="left">
									<input type="password" name="sure" maxlength="32"
									 style="width: 150">
									
								</td>
							</tr>
							<tr>
								<td colspan="2" align="center"> 
									&nbsp;<input type="submit" value="提交" class="btn_2k3"
										onclick="return checkForm(operForm);">
									&nbsp;&nbsp;
									<input type="reset" value="清空" class="btn_2k3">
									<br>
								</td>
							</tr>
						</table>
					</form>
					
				</td>
			</tr>
		</table>
	</body>
</html>
