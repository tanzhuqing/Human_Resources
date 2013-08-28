<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="db.bean.Employess_prize_noteBean"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>查询员工的奖惩管理</title>
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<script type="text/javascript" src="../js/function.js"></script>
		<script type="text/javascript" src="../js/show_title.js"></script>
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<link rel="stylesheet" type="text/css" href="../css/style.css">
		<script type="text/javascript">
		function selectClick(form){
				document.jiangcheng.action="jiangcheng.action";
				document.jiangcheng.submit();
			}
			</script>
	</head>

	<body bgcolor="#9A9AFE">
		<form action="SelectPayAction.action" method="post" name="jiangcheng">
			<center>
				<div>
					<font color="red" style="font-size: 20"> <b>${Error}</b> </font>
				</div>
				<br>
				ID:<input type="text" name="workID" maxlength="6">&nbsp;&nbsp;&nbsp;
				姓名:<input type="text" name="name" maxlength="6">
				<input type="submit" class="btn_2k3" value="查询">
				&nbsp;
				<input type="button" class="btn_2k3" value="添加奖惩"
					onclick="selectClick(jiangcheng)">
			</center>
		</form>
		<%
			List<Employess_prize_noteBean> pBeanList = (List<Employess_prize_noteBean>) request
					.getAttribute("pBeanList");
			if (pBeanList != null && pBeanList.size() > 0) {
		%>
		<table width="800" border="1" align="center">
			<tr class="top_tr">
				<td align="center">
					编号
				</td>
				<td align="center">
					员工ID
				</td>
				<td align="center">
					姓名
				</td>
				<td align="center">
					原因
				</td>
				<td align="center">
					时间
				</td>
				<td align="center">
					奖金
				</td>
				<td align="center">
					罚款
				</td>
				<td align="center">
					操作
				</td>
				<td>
				操作人员
				</td>
			</tr>
			<tr>
				<%
					if (!pBeanList.isEmpty()) {
							for (int i = 0; i < pBeanList.size(); i++) {
				%>
				<td align="center" width="10%">
					<%=pBeanList.get(i).getId() %>
				</td>
				<td align="center" width="10%">
					<%=pBeanList.get(i).getEmployess_id()%>
				</td>
				<td align="center" width="10%">
					<%=pBeanList.get(i).getEmployees_name()%>
				</td>
				<td  width="20">
					<%=pBeanList.get(i).getMatter()%>
				</td>
				<td align="center" width="10%">
					<%=pBeanList.get(i).getTime()%>
				</td>
				<td align="center" width="10%">
					<%=pBeanList.get(i).getJiangjin()%>元
				</td>
				<td align="center" width="10%">
					<%=pBeanList.get(i).getFakuan()%>元
				</td>
				<td align="center" width="10%">
					<a href="updateJiangCheng.action?id=<%=pBeanList.get(i).getId()%>">修改</a>
					<a href="addJiangChengKong.action?id=<%=pBeanList.get(i).getId()%>">添加</a>
					<a href="deleteJiangChengKong.action?id=<%=pBeanList.get(i).getId()%>">删除</a>
				</td>
				<td align="center" width="10%">
				<%=pBeanList.get(i).getUser() %>
				</td>
			</tr>
			<%
				}
					}
			%>
			<tr>
				<td align="center" colspan="9">
					<a href="pages/administerMan.jsp">返回</a>
				</td>
			</tr>
		</table>
		<%
			}
		%>
	</body>
</html>
