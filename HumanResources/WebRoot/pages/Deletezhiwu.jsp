<%@ page language="java" contentType="text/html; charset=utf-8"%>
<html>
	<head>
		<title>职务</title>
	</head>
	<body bgcolor="#9A9AFE">
		<center>
			<form method="post" action="shanzhiwu.action" name="bumen">
				<table width="200" border="1" align="center">
					<tr>
						<td align="center" colspan="2">
							<font color="red">${Error}</font>
						</td>
					</tr>
					<tbody>
						<tr>
							<td>
								职务：
							</td>
							<td>
								<input type="text" name="zhiwu">
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
