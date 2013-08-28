<%@ page language="java" contentType="text/html; charset=utf-8"%>

<html>
	<head>
		<title>人员培训</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<link rel="stylesheet" type="text/css" href="../css/style.css">
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/js/function.js"></script>
		<script type="text/javascript" src="../js/show_title.js"></script>
		<script type="text/javascript">
			function checkForm(form){
				if(form.employess_id.value==""){
					alert("【员工编号】不能为空！");
					form.employess_id.focus();
					return false;
				}
			}
			function selectClick(form){
				document.operForm.action="administerMan.action";
				document.operForm.submit();
			}
		
		</script>
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<link rel="stylesheet" type="text/css" href="../css/style.css">
	</head>
	<body bgcolor="#9A9AFE">
		<table width="100%" height="100%" border="0" cellpadding="0"
			cellspacing="0">
			<tr>
				<td align="center" valign="middle">
					<fieldset style="width: 400; height: 300">
						<legend>
							人员培训
						</legend>
						<div>
							<font color="red"> <b>${Error}</b> </font>
						</div>
						<form action="addSave.action" method="post" name="operForm">
							<table align="center" border="0">

								<tr>
									<td align="right" width="100">
										员工编号：
									</td>
									<td align="left" width="200">
										<input type="text" name="employess_id" maxlength="4"
											style="width: 180" onkeyup="keyPressClick(employess_id)"
											title="只能输入数字">

									</td>
								</tr>

								<tr>
									<td align="right">
										状 态 ：
									</td>
									<td align="left">
										<select name="status" style="width: 181">
											<option value="==请选择==">
												==请选择==
											</option>

											<option value="培训">
												培训
											</option>
											<option value="不培训">
												不培训
											</option>
										</select>
									</td>
								</tr>
								<tr>
									<td align="right" valign="top">
										培训原因：
									</td>
									<td align="left">
										<input type="text" name="matter"
											style="width: 180; height: 100">

									</td>
								</tr>

								<tr align="center">
									<td colspan="2" align="center">
										<input type="submit" value="确定" class="btn_2k3"
											onclick="return checkForm(operForm)">

										&nbsp; &nbsp;
										<input type="button" value="查询" class="btn_2k3"
											onclick="selectClick(operForm)">
									</td>


								</tr>
							</table>

						</form>
					</fieldset>
				</td>

			</tr>
		</table>

	</body>
</html>
