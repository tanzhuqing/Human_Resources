<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
	<head>
		<title>添加工资</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<link rel="stylesheet" type="text/css" href="../css/style.css">
	</head>
<script type="text/javascript">
		function checkForm(form){
			
			if(form.money.value==""){
				alert("【工资】不能为空！");
				form.money.focus();//设置焦点
				return false;
			}		
			
		}
		
	
	</script>
	<body bgcolor="#9A9AFE">
		<center>
			<form action="addgongZi.action" method="post" name="AddGZForm">
				<table align="center">
					<tr>
						<td align="center">
							<font color="red">${Error}</font>
						</td>
					</tr>
					<tr>
						<td align="left">
							员&nbsp;&nbsp;工&nbsp;id：
							<input type="text" value="${employess_id}" name="employess_id"
								readonly="readonly">
						</td>
					</tr>
					<tr>
						<td align="left">
							员工姓名：
							<input type="text" value="${employess_name}"
								name="employess_name" readonly="readonly">
						</td>
					</tr>
					<tr>
						<td align="left">
							工&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;资：
							<input type="text" name="money" value="${money}">
						</td>
					</tr>
					<tr>
						<td>
							<input type="submit" value="提交" class="btn_2k3"
								onclick="return checkForm(AddGZForm);">
							&nbsp;
							<input type="reset" value="重置" class="btn_2k3">


						</td>
					</tr>
				</table>
			</form>
		</center>
	</body>
</html>

