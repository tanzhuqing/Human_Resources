<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="db.bean.Employees_InformationBean"%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page import="db.bean.BuMenBean"%>
<%@page import="db.sqlDao.BuMenDao"%>
<%@page import="db.bean.Employess_zhiwuBean"%>
<%@page import="db.sqlDao.ZhiwuDao"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
	<head>
		<title>查询界面</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<link rel="stylesheet" type="text/css" href="../css/style.css">
		<script type="text/javascript">
		function Click(form){
			if(form.id.value==""){
				alert("修改前【需要根据员工编号查询】！");
				form.id.focus();//设置焦点
				return false;
			}
				document.addForm.action="update.action";
				document.addForm.submit();
			}
		function add(form){
				document.addForm.action="addUser.action";
				document.addForm.submit();
			}
			function checkForm(form){
			if(form.id.value==""){
				alert("删除前【需要根据员工编号查询】！");
				form.id.focus();//设置焦点
				return false;
			}
		document.addForm.action="deleteok.action";
		document.addForm.submit();
		}
		function bb(form){
		if(form.id.value==""){
				alert("需要根据员工编号查询！");
				form.id.focus();//设置焦点
				return false;
		}
	}
	</script>

		<!-- calendar stylesheet -->
		<link rel="stylesheet" type="text/css" media="all"
			href="<%=request.getContextPath()%>/css/calendar-win2k-cold-1.css"
			title="win2k-cold-1" />
		<!-- main calendar program -->
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/js/Calendar.js"></script>
		<!-- language for the calendar -->
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/js/Calendar-zh.js"></script>
		<!-- the following script defines the Calendar.setup helper function, which makes
       adding a calendar a matter of 1 or 2 lines of code. -->
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/js/Calendar-Setup.js"></script>


	</head>

	<body bgcolor="#9A9AFE">
		<%
			ActionContext act = ActionContext.getContext();
			ArrayList<Employees_InformationBean> al = (ArrayList<Employees_InformationBean>) act
					.get("Array");
		%>

		<%
			ArrayList<BuMenBean> alClass = new ArrayList<BuMenBean>();
			BuMenDao cDao = new BuMenDao();
			alClass = cDao.getAllClass();

			ArrayList<Employess_zhiwuBean> alClasszw = new ArrayList<Employess_zhiwuBean>();
			ZhiwuDao Dao = new ZhiwuDao();
			alClasszw = Dao.getAllClasszw();
		%>
		<form action="business1.action" method="post" name="addForm"
			enctype="multipart/form-data">

			<table width="600" align="center" border="1">
				<tr>
					<td align="center" colspan="2">
						<font color="red">${Error}</font>
						<font color="red"><s:fielderror></s:fielderror>
						</font>
					</td>
				</tr>
				<tr>
					<td align="center" colspan="2">
						<font color="red">带※号为必选项</font>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="left">
						员工编号:
						<input type="text" name="id" value="${id}" maxlength="6">
						<font color="red">※</font> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="submit" value="查询" class="btn_2K3"
							onclick="return bb(addForm)">
						<input type="button" value="修改" onclick="return Click(addForm)"
							class="btn_2K3">
						<input type="button" value="删除" class="btn_2K3"
							onclick="checkForm(addForm)">
						<input type="button" value="添加" onclick="add(addForm)"
							class="btn_2K3">


					</td>
				</tr>
				<tr>
					<td align="left">
						员工姓名:
						<input type="text" name="userName" width="100" value="${userName}">
						<font color="red">※</font>
					</td>
					<td width="323" rowspan="6">

						请选择个人头像:
						<input type="file" style="width: 180" class="btn_2k3"
							name="upload" height="50" />
						<br>
						<br>
						<input type="hidden" name="tupian" value="${photo}">
						<%
							if (al != null && al.size() > 0) {
								for (int i = 0; i < al.size(); i++) {
						%>
						<%
							if (al.get(i).getEmployees_photo() != null) {
						%>
						<img src="<%=request.getContextPath()%>/upload/${photo}"
							height="100" width="100">

						<%
							} else {
						%>
						个
						<br>
						人
						<br>
						头
						<br>
						像
						<%
							}
								}
							}
						%>
					</td>
				</tr>

				<tr>
					<td align="left">

						员工性别:
						<select name="sex" style="width: 155">
							<option value="">
								==请选择==
							</option>
							<%
								String sex = (String) request.getAttribute("sex");
							%>
							<option value="男" <%if("男".equals(sex)){ %> selected="selected"
								<%}%>>
								男
							</option>
							<option value="女" <%if("女".equals(sex)){ %> selected="selected"
								<%}%>>
								女
							</option>
						</select>
						<font color="red">※</font>
					</td>

				</tr>
				<tr>
					<td align="left">
						婚姻状况:
						<select name="marriage" style="width: 155">
							<option value="">
								==请选择==
							</option>
							<%
								String marriage = (String) request.getAttribute("marriage");
							%>
							<option value="已婚" <%if("已婚".equals(marriage)){ %>
								selected="selected" <%} %>>
								已婚
							</option>
							<option value="未婚" <%if("未婚".equals(marriage)){ %>
								selected="selected" <%} %>>
								未婚
							</option>
						</select>
						<font color="red">※</font>
					</td>
				</tr>
				<tr>
					<td align="left">
						基本工资:
						<input type="text" name="money" width="100" value="${money }" readonly="readonly">
					</td>
				</tr>
				<tr>
					<td align="left">
						最高学历:
						<select name="study" style="width: 155">
							<option value="">
								==请选择==
							</option>
							<%
								String study = (String) request.getAttribute("study");
							%>
							<option value="小学" <%if("小学".equals(study)){ %>
								selected="selected" <%} %>>
								小学
							</option>
							<option value="初中" <%if("初中".equals(study)){ %>
								selected="selected" <%} %>>
								初中
							</option>
							<option value="高中" <%if("高中".equals(study)){ %>
								selected="selected" <%} %>>
								高中
							</option>
							<option value="大学" <%if("大学".equals(study)){ %>
								selected="selected" <%} %>>
								大学
							</option>
							<option value="硕士" <%if("硕士".equals(study)){ %>
								selected="selected" <%} %>>
								硕士
							</option>
							<option value="博士" <%if("博士".equals(study)){ %>
								selected="selected" <%} %>>
								博士
							</option>

						</select>
						<font color="red">※</font>
					</td>
				</tr>
				<tr>
					<td align="left">
						政治面貌:
						<select name="politically" style="width: 155">
							<option value="">
								==请选择==
							</option>
							<%
								String politically = (String) request.getAttribute("politically");
							%>
							<option value="党员" <%if("党员".equals(politically)){ %>
								selected="selected" <%} %>>
								党员
							</option>
							<option value="团员" <%if("团员".equals(politically)){ %>
								selected="selected" <%} %>>
								团员
							</option>
							<option value="其它" <%if("其它".equals(politically)){ %>
								selected="selected" <%} %>>
								其它
							</option>
						</select>
					</td>
				</tr>
				<tr>
					<td align="left">
						身份证号:
						<input type="text" name="identity" width="100" value="${identity}"
							onkeyup="CheckShenFenZheng(identity)" maxlength="18">
						<font color="red">※</font>
					</td>
						<td align="center">
						所在城市:
						<input type="text" name="city" width="100" value="${city }">

				</tr>
				<tr>
					<td align="left">
						部&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;门:
						<select name="professional" style="width: 155">

							<option value="">
								==请选择==
							</option>
							<%
								String professional = (String) request.getAttribute("professional");
							%>
							<%
								for (int j = 0; j < alClass.size(); j++) {
							%>
							<option value="<%=alClass.get(j).getEmployees_professional()%>" <%if(alClass.get(j).getEmployees_professional().equals(professional)){ %>
								selected="selected" <%} %>>

								<%=alClass.get(j).getEmployees_professional()%>
							</option>

							<%
								}
							%>
						</select>
						<font color="red">※</font>



					</td>
					<td align="center">
						宅&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;电:
						<input type="text" name="tel" width="100" value="${tel}">
					</td>
				</tr>
				<tr>
					<td align="left">

						职&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;务:
						<select name="section" style="width: 155">
							<option value="">
								==请选择==
							</option>
							<%
								String section = (String) request.getAttribute("section");
							%>
							<%
										for (int i = 0; i < alClasszw.size(); i++) {
									%>
									<option value="<%=alClasszw.get(i).getEmployess_job()%>" <%if(alClasszw.get(i).getEmployess_job().equals(section)){ %>
								selected="selected" <%} %>>

										<%=alClasszw.get(i).getEmployess_job()%>
									</option>

									<%
										}
									%>
						</select>
						<font color="red">※</font>
					</td>
					<td align="center">
						邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱:
						<input type="text" name="email" width="100" value="${email}">
					</td>
				</tr>
				<tr>
					<td align="left">
						入职时间:

						<input type="text" name="jointime" style="width: 128"
							readonly="readonly" title="点击右边的图片，入职日期！" value="${jointime}">
						<img src="<%=request.getContextPath()%>/images/img.gif"
							id="f_trigger_c" style="cursor: pointer; border: 1px solid red;"
							title="选择入职日期" onmouseover="this.style.background='red';"
							onmouseout="this.style.background=''">
						<font color="red">※</font>
					</td>
					<td align="center">
						手 机 号:
						<input type="text" name="mobile" width="100" value="${mobile}"
							maxlength="11" onkeyup="keyPressClick(mobile)">

					</td>
				</tr>
				<tr>
					<td align="left">
						截止时间:
						<input type="text" name="engtime" style="width: 128"
							readonly="readonly" title="点击右边的图片，选择截止日期！" value="${engtime}">
						<img src="<%=request.getContextPath()%>/images/img.gif"
							id="f_trigger_c1" style="cursor: pointer; border: 1px solid red;"
							title="选择截止日期" onmouseover="this.style.background='red';"
							onmouseout="this.style.background=''">
						<font color="red">※</font>
					</td>
					<td align="center">

						应急电话:
						<input type="text" name="lashup_tel" width="100"
							value="${lashup_tel}">


					</td>
				</tr>

			</table>
		</form>
		<script type="text/javascript">
    Calendar.setup({
        inputField     :    "jointime",     // id of the input field
        ifFormat       :    "%Y-%m-%d",      // format of the input field
        button         :    "f_trigger_c",  // trigger for the calendar (button ID)
        align          :    "Br",           // alignment (defaults to "Bl")
        singleClick    :    true
    });
    Calendar.setup({
        inputField     :    "engtime",     // id of the input field
        ifFormat       :    "%Y-%m-%d",      // format of the input field
        button         :    "f_trigger_c1",  // trigger for the calendar (button ID)
        align          :    "Br",           // alignment (defaults to "Bl")
        singleClick    :    true
    });
</script>
	</body>

</html>

