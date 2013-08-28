<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="db.bean.BuMenBean"%>
<html>
	<head>
		<title>部门</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
	</head>

	<script type="text/javascript">
	function checkForm(form){
			if(form.zhiwu.value==""){
				alert("【职务】不能为空！");
				form.zhiwu.focus();//设置焦点
				return false;
		}		
			}
	function delet(form){
			   
				document.zhiwu.action="delett.action";
				document.zhiwu.submit();
			}
			</script>
	<body bgcolor="#9A9AFE">

		<form action="selectbumenkong.action" method="post">
			<table align="center">
				<tr>
					<td align="left">
						<font color="red">${Error}</font>
					</td>
				</tr>
				<tr>
					<td align="center">
						<select name="optzhiwu" style="width: 155">
							<option value="0">
								==请选择==
							</option>
							<%
								ArrayList<BuMenBean> al = (ArrayList<BuMenBean>) request
										.getAttribute("all");
								if (al != null && al.size() > 0) {
									for (int i = 0; i < al.size(); i++) {
							%>
							<option value="<%=al.get(i).getId()%>">
								<%=al.get(i).getEmployees_professional()%>
							</option>
							<%
								}
							%>
						</select>
						<input type="submit" name="submit" value="点击查询" class="btn_2k3">
						<%
							} else {
						%>
						当前还没有添加部门
						<%
							}
						%>
					</td>
				</tr>

			</table>
		</form>
	</body>
</html>
