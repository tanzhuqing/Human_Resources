<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="db.bean.AssmetterBean"%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page import="db.bean.Employees_InformationBean"%>

<html>
	<head>
		<title>原因</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<link rel="stylesheet" type="text/css" href="../css/style.css">
		<script type="text/javascript">
		function checkForm(form){
			if(form.employess_id.value==""){
				alert("【员工ID】不能为空！");
				form.employess_id.focus();//设置焦点
				return false;
		}		
			
			if(form.status.value=="==请选择=="){
					alert("请选择【状 态】！");
					form.status.focus();
					return false;		
		}
		
		}
		function selectClick(form){
			document.operForm.action="result.action";
			document.operForm.submit();
	}
	function updeteClick(form){
	document.operForm.action="assessmanage.action";
	document.operForm.submit();
}
			</script>
	</head>
	<body>
		<form action="Assmetter1.action" method="post" name="operForm">
			<table align="center" width="30%" height="90%">
				<tr>
					<td align="center" colspan="2">
						<font color="red">${Error }</font>
					</td>
				</tr>
				<tr>
					<td align="center" colspan="2">
						<font color="red">★如没有出勤，请添加原因</font>
					</td>
				</tr>
				<tr>
					<td align="right">
						员工ID ：

					</td>

					<td align="left">
						<input type="text" maxlength="6" name="employess_id"
							value="${employess_id }">
					</td>
				</tr>

				<tr>
					<td align="right">
						状 态 ：
					</td>
					<td align="left">
						<select name="status" style="width: 158">
							<option value="==请选择==">
								==请选择==
							</option>

							<option value="出勤">
								出勤
							</option>
							<option value="旷工">
								旷工
							</option>
						</select>
					</td>
				</tr>
				<tr>
					<td align="right">
						原 因 ：

					</td>

					<td align="left">
						<input type="text" name="matter" value=""
							style="width: 150; height: 100" value="${matter }">

					</td>
				</tr>
				<tr align="right">
					<td colspan="2" align="center">
						<input type="submit" value="添加"
							onclick="return checkForm(operForm)">
						&nbsp;&nbsp;
						<input type="button" value="查询" onclick="updeteClick(operForm)">
						&nbsp;&nbsp;
						<input type="button" value="返回" onclick="selectClick(operForm)">
						&nbsp;&nbsp;
					</td>
				</tr>
			</table>
		</form>
	</body>

</html>
