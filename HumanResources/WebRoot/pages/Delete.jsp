<%@ page language="java" contentType="text/html; charset=utf-8"%>
<html>
	<head>
		<title>部门</title>
	</head>
	<body bgcolor="#9A9AFE">
		<center>
			<form method="post" action="shanchu.action" name="bumen">
				<table width="200" border="1" align="center">
				<tr>
						<td align="center" colspan="2">
							<font color="red">${Error}</font>
						</td>
					</tr>
					<tbody>
						<tr>
							<td>
								部门：
							</td>
							<td>
								<input type="text" name="bumen">
							</td>
						</tr>
						<tr>
							<td colspan="2" align="center">

								<input type="submit" value="删除" name="button2">
							</td>
						</tr>
					</tbody>
				</table>

			</form>
		</center>
		</body>
</html>
