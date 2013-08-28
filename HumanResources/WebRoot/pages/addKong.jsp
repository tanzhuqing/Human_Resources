<%@ page language="java" contentType="text/html; charset=utf-8"%>
<html>
	<head>
		<title>部门</title>
			<link rel="stylesheet" type="text/css" href="css/style.css">
	</head>
	<script type="text/javascript">
	function checkForm(form){
			if(form.zhiwuKong.value==""){
				alert("【职务】不能为空！");
				form.bumen.focus();//设置焦点
				return false;
		}		
			}
			</script>
	<body bgcolor="#9A9AFE" >
		<center>
			<form method="post" action="addKong.action" name="bumen">
				<table width="350" border="0" align="center" >
					<tr>
						<td align="center" colspan="2">
							<font color="red">${Error}</font>
						</td>
					</tr>
					<tbody>
						<tr valign="middle">
							<td align="center">
						要添加的职务
								<input type="text" name="zhiwuKong" value="${zhiwuKong}">
						
								<input type="submit" value="添加" name="button1"
									onclick="return checkForm(bumen)" class="btn_2k3">
							</td>
						</tr>
					</tbody>
				</table>
<input type="hidden" name="optzhiwu" value="<%=request.getParameter("optzhiwu")%>">
			</form>
		</center>
	</body>
</html>
