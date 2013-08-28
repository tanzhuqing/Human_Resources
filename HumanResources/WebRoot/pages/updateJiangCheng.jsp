<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
	<head>
		<title>修改奖惩</title>
			<link rel="stylesheet" type="text/css" href="css/style.css">
		<link rel="stylesheet" type="text/css" href="../css/style.css">
	</head>
	
	<body bgcolor="#9A9AFE">

		<form action="UpdateJiangCheng.action" method="post"
			name="updateJiangCheng">
			<table align="center">
				<tr>
					<td align="center" colspan="2">
						<font color="red">${Error}</font>
					</td>
				</tr>
				<tr>
					<td>
						
						<input type="hidden" value="${id}" name="id" readonly="readonly" >
					</td>
				</tr>
				<tr>
					<td>
						员工id：
						<input type="text" value="${employess_id}" name="employess_id" readonly="readonly">
					</td>
				</tr>
				<tr>
					<td>
						原因：
						<input type="text" value="${matter}" name="matter">
					</td>
				</tr>
				<tr>
					<td>
						奖金：
						<input type="text" value="${jiangjin}" name="jiangjin">
					</td>
				</tr>
				<tr>
					<td>
						罚款：
						<input type="text" value="${fakuan}" name="fakuan">
					</td>
				</tr>
				<tr>
					<td>
						<input type="submit" value="提交" class="btn_2k3">
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
