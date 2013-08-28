<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page import="db.bean.BuMenBean"%>
<%@page import="db.sqlDao.ZhiwuDao"%>
<%@page import="db.sqlDao.BuMenDao"%>
<%@page import="db.bean.Employess_zhiwuBean"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>


		<title>添加界面</title>

		<link rel="stylesheet" type="text/css" href="css/style.css">

		<link rel="stylesheet" type="text/css" href="../css/style.css">

		<script type="text/javascript" src="../js/show_title.js"></script>
		<script type="text/javascript" src="../js/function.js"></script>
		<script type="text/javascript">
		function back(form){
				document.backForm.action="back.action";
				document.backForm.submit();
			}	

		function checkForm(form){
			if(form.id.value==""){
				alert("【员工编号】不能为空！");
				form.id.focus();//设置焦点
				return false;
			}
			if(form.userName.value==""){
				alert("【员工姓名】不能为空！");
				form.userName.focus();//设置焦点
				return false;
			}	
			if(form.marriage.value==""){
				alert("【婚姻状况】不能为空！");
				form.marriage.focus();//设置焦点
				return false;
			}
			
			if(form.study.value==""){
				alert("【最高学历】不能为空！");
				form.study.focus();//设置焦点
				return false;
			}
			
			if(form.identity.value==""){
				alert("【身份证号】不能为空！");
				form.identity.focus();//设置焦点
				return false;
			}
			if(form.money.value==""){
				alert("【基本工资】不能为空！");
				form.money.focus();//设置焦点
				return false;
			}
			
			if(form.jointime.value==""){
				alert("【入职时间】不能为空！");
				form.jointime.focus();//设置焦点
				return false;
			}
				if(form.professional.value==""){
				alert("【部门】不能为空！");
				form.professional.focus();//设置焦点
				return false;
			}
				if(form.engtime.value==""){
				alert("【截止时间】不能为空！");
				form.engtime.focus();//设置焦点
				return false;
			}
				if(form.section.value==""){
				alert("【职务】不能为空！");
				form.section.focus();//设置焦点
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
			ArrayList<BuMenBean> alClass = new ArrayList<BuMenBean>();
			BuMenDao cDao = new BuMenDao();
			alClass = cDao.getAllClass();

			ArrayList<Employess_zhiwuBean> alClasszw = new ArrayList<Employess_zhiwuBean>();
			ZhiwuDao Dao = new ZhiwuDao();
			alClasszw = Dao.getAllClasszw();
		%>
		<form action="addYuanGong.action" method="post" name="backForm"
			enctype="multipart/form-data">

			<table align="center">
				<tr>

					<table width="600" border="1" align="center">
						<tr>
							<td align="center" colspan="2">
								<font color="red">${Error}</font>
								<font color="red"><s:fielderror></s:fielderror> </font>
							</td>
						</tr>
						<tr>
							<td align="center" colspan="2">
								<font color="red">带※号为必填项</font>
							</td>
						</tr>
						<tr>
							<td align="left">
								员工编号:
								<input type="text" name="id" width="100" value="${id}"
									maxlength="6">
								<font color="red">※</font>
							</td>

							<!-- <input type="submit" value="查询" class="btn_2k3">
						<input type="button" value="修改" class="btn_2k3">
						<input type="button" value="添加" class="btn_2k3"> -->
							<td>
								<input type="submit" value="提交" class="btn_2k3"
									onclick="return checkForm(backForm)">
								<input type="button" value="返回" class="btn_2k3"
									onclick="back(backForm)">


							</td>
						</tr>
						<tr>
							<td align="left">

								员工姓名:
								<input type="text" name="userName" width="100"
									value="${userName }">
								<font color="red">※</font>
							</td>
							<td width="323" rowspan="6">
								请选择个人头像:
								<input type="file" style="width: 180" class="btn_2k3"
									name="upload" height="50" />



							</td>
						</tr>

						<tr>
							<td align="left">
								员工性别:
								<select name="sex" style="width: 155">
									<option value="">
										==请选择==
									</option>
									<option value="男">
										男
									</option>
									<option value="女">
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
									<option value="已婚">
										已婚
									</option>
									<option value="未婚">
										未婚
									</option>
								</select>
								<font color="red">※</font>


							</td>
						</tr>
						<tr>
							<td align="left">
								基本工资:
								<input type="text" name="money" width="100" value="${money }">
								<font color="red">※</font>
							</td>
						</tr>
						<tr>
							<td align="left">
								最高学历:
								<select name="study" style="width: 155">
									<option value="">
										==请选择==
									</option>
									<option value="小学">
										小学
									</option>
									<option value="初中">
										初中
									</option>
									<option value="高中">
										高中
									</option>
									<option value="大学">
										大学
									</option>
									<option value="硕士">
										硕士
									</option>
									<option value="博士">
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
									<option value="党员">
										党员
									</option>
									<option value="团员">
										团员
									</option>
									<option value="其它">
										其它
									</option>
								</select>
							</td>
						</tr>
						<tr>
							<td align="left">
								身份证号:
								<input type="text" name="identity" width="100"
									value="${identity}" maxlength="18">
								<font color="red">※</font>
							</td>
							<td align="center">

								所在城市:
								<input type="text" name="city" width="100" value="${city }">
							</td>
						</tr>
						<tr>
							<td align="left">
								部&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;门:
								<select name="professional" style="width: 155">
									<option value="">
										==请选择==
									</option>
									<%
										for (int j = 0; j < alClass.size(); j++) {
									%>
									<option value="<%=alClass.get(j).getEmployees_professional()%>">

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
								<input type="text" name="tel" width="100" value="${tel}"
									maxlength="16">
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
										for (int i = 0; i < alClasszw.size(); i++) {
									%>
									<option value="<%=alClasszw.get(i).getEmployess_job()%>">

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
									id="f_trigger_c"
									style="cursor: pointer; border: 1px solid red;" title="选择入职日期"
									onmouseover="this.style.background='red';"
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
									id="f_trigger_c1"
									style="cursor: pointer; border: 1px solid red;" title="选择截止日期"
									onmouseover="this.style.background='red';"
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

