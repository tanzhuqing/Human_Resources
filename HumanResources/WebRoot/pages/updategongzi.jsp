<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
	<head>
		<title>修改工资</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<link rel="stylesheet" type="text/css" href="../css/style.css">
	</head>
	<script type="text/javascript">
		function checkForm(form){
			
			if(form.pass.value==""){
				alert("【密码】不能为空！");
				form.pass.focus();//设置焦点
				return false;
			}		
			
		}
		
	
	</script>
	<body bgcolor="#9A9AFE">

		<form action="updateGZ.action" method="post" name="xiugaiForm">
			<table align="center">
				<tr>
					<td align="center" colspan="2">
						<font color="red">${Error}</font>
					</td>
				</tr>
				<tr>
					<td>

						<input type="hidden" value="${id}" name="id" readonly="readonly">
					</td>
				</tr>
				<tr>
					<td align="left">
						员&nbsp;&nbsp;工&nbsp;&nbsp;id：
						<input type="text" value="${employess_id}" name="employess_id"
							readonly="readonly">
					</td>
				</tr>
			
				<tr>
					<td align="left">
						工&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;资：
						<input type="text" value="${money}" name="money">
					</td>
				</tr>
				<tr>
				</tr>
				<tr>
					<td align="left">
						修改人&nbsp;id：
						<input type="text" value="${nameID}" name="userid" readonly="readonly">
						
					</td>
				</tr>
				<tr>
					<td align="left">
						修改人密码：
						<input type="password" value="${pass}" name="pass">
					</td>
				</tr>
				<tr>
					<td>
						<input type="submit" value="提交" class="btn_2k3" onclick="return checkForm(xiugaiForm);">
						&nbsp;
						<input type="reset" value="重置" class="btn_2k3">
						&nbsp;
						<a href="pages/administerMan.jsp">返回</a>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>

