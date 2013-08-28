<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>登陆界面</title>
		<script type="text/javascript">
		function checkForm(form){
			if(form.LoginName.value==""){
				alert("【登录名】不能为空！");
				form.LoginName.focus();//设置焦点
				return false;
			}
			if(form.Password.value==""){
				alert("【密码】不能为空！");
				form.Password.focus();//设置焦点
				return false;
			}		
			if(form.yanZhengMa.value==""){
				alert("【验证码】不能为空！");
				form.yanZhengMa.focus();//设置焦点
				return false;
			}
		}
		
	
	</script>
		<script type="text/javascript" src="../js/function.js"></script>
		<script type="text/javascript" src="../js/show_title.js"></script>
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<link rel="stylesheet" type="text/css" href="../css/style.css">

	</head>
	<body bgcolor="#9A9AFE">
		<center>
			<form action="loginAdminister.action" method="post" name="loginForm">

				<table width="100%" height="90%" align="center">

					<tr>
						<td align="center" valign="middle">

							<table width="494" align="center" height="50%">


								<tr>
									<td colspan="2" valign="top">
										<jsp:include page="top.jsp"></jsp:include>
									</td>


								</tr>
							</table>
							<font style="font-size: 20"> 请输入管理员的用户名和密码 </font>
							<br>
							<font color="red" style="font-size: 20">${Error}</font>
							<table>
								<tr>

									<td align="right">
										用户名:
									</td>
									<td align="left">

										<input type="text" name="LoginName" style="width: 150">
									</td>
								</tr>
								<tr>

									<td align="right">
										密码:
									</td>
									<td align="left">

										<input type="password" name="Password" style="width: 150">
									</td>
								</tr>
								<tr>

									<td align="right">
										验证码：
									</td>

									<td align="left">

										<input type="text" name="yanZhengMa" style="width: 75" maxlength="5">
										<img src="<%=request.getContextPath()%>/yanZhengMa.action"
											align="middle">
									</td>
								</tr>
								<tr>
									<td align="left" colspan="4">
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<input type="submit" class="btn_2k3" value="提交"
											class="btn_2K3" onclick="return checkForm(loginForm);">
										&nbsp;&nbsp;
										<input type="reset" class="btn_2k3" value="清空 ">
									</td>
								</tr>
							</table>
							
						</td>
					</tr>
				</table>
<jsp:include page="below.jsp"></jsp:include>

			</form>
		</center>
	</body>
</html>
