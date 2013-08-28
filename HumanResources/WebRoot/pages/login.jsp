<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>



<html>
	<head>
		<title>登入界面</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<link rel="stylesheet" type="text/css" href="../css/style.css">
		<script type="text/javascript">
	function selectClick(form){
				document.operForm.action="login1.action";
				document.operForm.submit();
			}
			</script>
	</head>

	<body>

		<form action="pages/login.action" method="post" name="operForm">
			<table align="center" height="100%" width="100%">
				<tr>
				
					<td>
						<table align="center" height="100%"  >
						<tr>
						<td valign="top">
					<jsp:include page="top.jsp"></jsp:include>
					<br>
					<br>
						<br>
					<br>	<br>
					<br>
					<input type="submit" class="btn_2k3" value="管理员登入">
									<input type="button" value="员工登入" class="btn_2k3"
										onclick="selectClick(operForm)">
						</td>
						</tr>
							<tr>
								<td valign="top">
	<jsp:include page="below.jsp"></jsp:include>
									

								</td>
							</tr>

						</table>
					</td>
				</tr>


			</table>
		</form>

	</body>
</html>
