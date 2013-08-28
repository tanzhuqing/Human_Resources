<%@ page language="java" contentType="text/html; charset=utf-8"%>
<html>
 <head>
		<title>修改密码页面</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<link rel="stylesheet" type="text/css" href="../css/style.css">
		<script type="text/javascript">
			function checkForm(form){
				if(form.old_password.value==""){
					alert("【旧密码】不能为空！");
					form.old_password.focus();
					return false;
				}
				if(form.new_password.value==""){
					alert("【新密码】不能为空！");
					form.new_password.focus();
					return false;
				}
				if(form.confirm_password.value==""){
					alert("【确认密码】不能为空！");
					form.confirm_password.focus();
					return false;
				}
				if(form.new_password.value 
				             !=form.confirm_password.value){
					alert("【新密码】和【确认密码】不一致！");	
					form.new_password.value="";
				form.confirm_password.value="";	
				form.new_password.focus();			
					return false;
				}			
			}
			
			function resetClick(form){
				form.old_password.value="";
				form.new_password.value="";
				form.confirm_password.value="";
				form.old_password.focus();
			}
		</script>
	</head>
	<body>
		<center>		
			<form action="DoupdatePassword.action" method="post" name="passwordForm">
				<table width="100%" height="100%" border="0">
					<tr>
						<td align="center" valign="middle">
						 <div　align="center">
						 <font color="red"><b>带＊号的是必须填写的选项</b></font>
						 </div>
							<div>
								<font color="red" style="font-size: 20"><b>${Error}</b></font>
							</div>
							<fieldset style="width: 300;height: 150">
						<legend>
						修改密码的操作
						</legend>
							<table width="300" border="0">
								<tr>
									<td align="right" width="100">
										旧密码：
									</td>
									<td align="left" width="200">
										<input type="password" name="old_password" maxlength="32">
									<font color="red"><b>*</b></font>
									</td>
								</tr>
								<tr>
									<td align="right">
										新密码：
									</td>
									<td align="left">
										<input type="password" name="new_password" maxlength="32">
										<font color="red"><b>*</b></font>
									</td>
								</tr>
								<tr>
									<td align="right">
										确认密码：
									</td>
									<td align="left">
										<input type="password" name="confirm_password" maxlength="32">
										<font color="red"><b>*</b></font>
									</td>
								</tr>
								<tr>
									<td colspan="2" align="center">
										<input type="submit" value="修改密码" style="width: 70" 
											class="btn_2k3" onclick="return checkForm(passwordForm);">
										&nbsp;&nbsp;&nbsp;&nbsp;
										<input type="button" value="重置" style="width: 70"
										class="btn_2k3" onclick="resetClick(passwordForm)">
									</td>
								</tr>
							</table>
							</fieldset>
						</td>
					</tr>
				</table>
			</form>
		</center>
	</body>
</html>
