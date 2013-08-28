<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
<html>
	<head>
		<title>操作成功页面</title>

	</head>
	<body>
		<center>
			<table width="100%" height="100%" border="0">
				<tr>
					<td align="center" valign="middle">
						<font color="red" style="font-size: 40"> <%
							ActionContext act = ActionContext.getContext();

							String opt = (String) act.get("SuccessOpt");
							if ("ModifyPassword".equals(opt)) {
						%> 恭喜您，修改密码成功！<br> <br> <a
							href="<%=request.getContextPath()%>/pages/updatePassword.jsp">返回</a>
							<%
							} else if ("updateState".equals(opt)) {
							%> 恭喜您，删除成功！<br> <br> <a
							href="<%=request.getContextPath()%>/le.action">返回</a>
							<%
							} else if ("CardSave".equals(opt)) {
							%> 恭喜您，注册成功！<br> <br> <a
							href="<%=request.getContextPath()%>/pages/addEmploye.jsp">返回</a>

							<%
							} else if ("add".equals(opt)) {
							%> 添加成功！<br> <br> <a
							href="<%=request.getContextPath()%>/pages/addUser.jsp">返回</a> 
							
							<%
							} else if ("updata".equals(opt)) {
							%> 修改成功！<br> <br> <a
							href="<%=request.getContextPath()%>/pages/business.jsp">返回</a> 
							
								<%
							} else if ("delete".equals(opt)) {
							%> 删除成功！<br> <br> <a
							href="<%=request.getContextPath()%>/pages/business.jsp">返回</a> 
									<%
							} else if ("AddSave".equals(opt)) {
							%> 考评原因添加成功！<br> <br> <a
							href="<%=request.getContextPath()%>/pages/Assmetter.jsp">返回</a> 
							
							<%
							} else if ("Addbecase".equals(opt)) {
							%> 培训原因添加成功！<br> <br> <a
							href="<%=request.getContextPath()%>/pages/Trainmetter.jsp">返回</a> 

							
							<%
                              }
                              %> 
 </font>
					</td>

				</tr>

			</table>
		</center>
	</body>
</html>
