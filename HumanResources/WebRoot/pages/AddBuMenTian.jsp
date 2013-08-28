<%@ page language="java" contentType="text/html; charset=utf-8"%>
<html>
	<head>
		<title>部门</title>
			<link rel="stylesheet" type="text/css" href="css/style.css">
	</head>
	<script type="text/javascript">
	function checkForm(form){
			if(form.bumen.value==""){
				alert("【部门】不能为空！");
				form.bumen.focus();//设置焦点
				return false;
		}		
			}
			</script>
	<body bgcolor="#9A9AFE">
		<center>
			<form method="post" action="BUmen.action" name="bumen">
				<table width="300" border="0" align="center">
					<tr>
						<td align="center">
							<font color="red">${Error}</font>
						</td>
					</tr>
					<tbody>
						<tr>
							<td>
								部门：
								<input type="text" name="bumen" value="${bumen }">
							
								<input type="submit" value="添加" name="button1"
									onclick="return checkForm(bumen)" class="btn_2k3">
							</td>
						</tr>
					</tbody>
				</table>

			</form>
		</center>
	</body>
</html>
