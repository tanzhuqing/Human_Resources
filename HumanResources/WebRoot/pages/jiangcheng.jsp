<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>


		<title>奖惩管理</title>
				<link rel="stylesheet" type="text/css" href="css/style.css">
		<link rel="stylesheet" type="text/css" href="../css/style.css">
		<script type="text/javascript" src="../js/function.js"></script>
		<script type="text/javascript" src="../js/show_title.js"></script>

		

		<script type="text/javascript">
			function checkForm(form){
			if(form.employess_id.value==""){
					alert("【员工id】不能为空！");
					form.employess_id.focus();
					return false;
				}else if(form.name.value==""){
					alert("【姓名】不能为空！");
					form.name.focus();
					return false;
				}else if(form.matter.value==""){
					alert("【奖惩原因】不能为空！");
					form.matter.focus();
					return false;
				}else if(form.time.value==""){
					alert("【奖惩时间】不能为空！");
					form.time.focus();
					return false;
				}else if(form.jiangjin.value==""){
					alert("【奖惩金额】不能为空！如没有奖金输入0");
					form.jiangjin.focus();
					return false;
				}else if(form.fakuan.value==""){
					alert("【罚款金额】不能为空！如没有罚款输入0");
					form.fakuan.focus();
					return false;
				}
				return true;
				}
			</script>
	</head>

	<body bgcolor="#9A9AFE">
		<table width="100%" height="100%" border="0" cellpadding="0"
			cellspacing="0">
			<tr>
				<td align="center" valign="middle">

					<form action="JiangchengAction.action" method="post"
						name="mobileForm">
						<table align="center" border="0">
							<tr>
								<div>
									<font color="red" style="font-size: 20"> <b>${Error}</b>
									</font>
								</div>
							</tr>
							<tr>
								<td>
									员工id:
								</td>
								<td>
									<input type="text" maxlength="6" name="employess_id"
									 value="${employess_id}">
								</td>
								<tr>
								<td>
								姓名：
								</td>
								<td>
									<input type="text" name="name" maxlength="12" 
									value="${name}">
							</tr>
							<tr>
								<td>
									奖惩原因：
								</td>
								<td>
									<input type="text" name="matter" maxlength="255" value="${matter}">
							</tr>
							<tr>
								
							<tr>
								<td>
									奖励金额：
								</td>
								<td>
									<input type="text" name="jiangjin" value="${jiangjin}">
								</td>
							</tr>
							<tr>
								<td>
									罚款金额：
								</td>
								<td>
									<input type="text" name="fakuan" value="${fakuan}">
								</td>
							</tr>
							<tr>
								<td align="center" colspan="2">
									<input type="submit" value="提交" class="btn_2k3"
										onclick="return checkForm(mobileForm);">
							
									<a href="pages/administerMan.jsp">返回</a>
								</td>
							</tr>




						</table>
					</form>
				</td>
			</tr>
		</table>
		
	</body>
  
</html>
