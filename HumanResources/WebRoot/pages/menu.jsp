<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>

<html>
	<head>


		<title>管理员登入后的界面</title>


		<link rel="stylesheet" type="text/css" href="css/style.css">
		<link rel="stylesheet" type="text/css" href="../css/style.css">

		<style type="text/css">
.menutitle {
	cursor: pointer;
	margin-bottom: 5px;
	background-color: #eeeeee;
	width: 188px;
	padding: 2px;
	text-align: center;
	font-weight: bold;
}

.submenu {
	margin-bottom: 0.5em;
}
</style>
		<script type="text/javascript">
if (document.getElementById){ ///
document.write('<style type="text/css">\n')
document.write('.submenu{display: none;}\n')
document.write('</style>\n')
}

function SwitchMenu(obj){
if(document.getElementById){
var el = document.getElementById(obj);
var ar = document.getElementById("masterdiv").getElementsByTagName("span"); //DynamicDrive.com change
	if(el.style.display != "block"){ //DynamicDrive.com change
		for (var i=0; i<ar.length; i++){
	if (ar[i].className=="submenu") //DynamicDrive.com change
			ar[i].style.display = "none";
		}
		el.style.display = "block";
	}else{
	el.style.display = "none";
	}
	}
}
</script>
	<body bgcolor="#9A9AFE">

		<form action="zhujie.action" method="post" name="addForm">
		</form>

		<table align="center" height="100%" width="100%">
			<tr>
				<td>
					<%
								String stauts = (String) ActionContext.getContext().getSession()
								.get("stauts");
						if (stauts.equals("1")) {
					%>
					<div id="masterdiv">

						<div class="menutitle" onclick="SwitchMenu('sub1')">
							管理员管理
						</div>
						<span class="submenu" id="sub1"> <a
							href="updatePassword.action" target="body">修改密码</a> <br> <a
							href="addEmploye.action" target="body"> 注册管理员</a> <br> <a
							href="deleteEmployess.action" target="body">删除管理员</a> <br> <a
							href="bumeng.action" target="body">部门管理</a> <br> <a
							href="zhiwug.action" target="body">职务管理</a> </span>


						<div class="menutitle" onclick="SwitchMenu('sub2')">
							人事档案管理
						</div>
						<span class="submenu" id="sub2"> <a href="business.action"
							target="body">事务管理</a> <br> <a href="RenShiDemand.action"
							target="body"> 人事调动查询</a> </span>
						<div class="menutitle" onclick="SwitchMenu('sub3')">
							考勤资料管理
						</div>
						<span class="submenu" id="sub3"> <a href="assessmanage.action"
							target="body">考勤管理</a> <br> <a href="toTrainmetter.action"
							target="body">培训管理</a> </span>


						<div class="menutitle" onclick="SwitchMenu('sub4')">
							工资管理
						</div>
						<span class="submenu" id="sub4"> <a
							href="wagemanageOnly.action" target="body">工资管理</a> <br> <a
							href="paychaxun.action" target="body">奖惩管理</a> </span>

						<div class="menutitle" onclick="SwitchMenu('sub5')">
							模糊信息管理
						</div>
						<span class="submenu" id="sub5"> <a href="mohu.action"
							target="body">模糊查询</a> </span>
						<div class="menutitle" onclick="SwitchMenu('sub6')">
							退出系统
						</div>
						<span class="submenu" id="sub6"> <a href="exitchu.action">退出系统</a>
						</span>
					</div>
					<%
					} else {
					%>
					<div id="masterdiv">

						<div class="menutitle" onclick="SwitchMenu('sub1')">
							管理员管理
						</div>
						<span class="submenu" id="sub1"> <a
							href="updatePassword.action" target="body">修改密码</a> <br> </span>


						<div class="menutitle" onclick="SwitchMenu('sub2')">
							人事档案管理
						</div>
						<span class="submenu" id="sub2"> <a href="business.action"
							target="body">事务管理</a> <br> <a href="RenShiDemand.action"
							target="body"> 人事调动查询</a> </span>
						<div class="menutitle" onclick="SwitchMenu('sub3')">
							考勤资料管理
						</div>
						<span class="submenu" id="sub3"> <a
							href="assessmanage.action" target="body">考勤管理</a> <br> <a
							href="toTrainmetter.action" target="body">培训管理</a> </span>


						<div class="menutitle" onclick="SwitchMenu('sub4')">
							工资管理
						</div>
						<span class="submenu" id="sub4"> <a
							href="wagemanageOnly.action" target="body">工资管理</a> <br> <a
							href="paychaxun.action" target="body">奖惩查询</a> </span>

						<div class="menutitle" onclick="SwitchMenu('sub5')">
							模糊信息管理
						</div>
						<span class="submenu" id="sub5"> <a href="mohu.action"
							target="body">模糊查询</a> </span>
						<div class="menutitle" onclick="SwitchMenu('sub6')">
							退出系统
						</div>
						<span class="submenu" id="sub6"> <a href="exitchu.action">退出系统</a>
						</span>
					</div>
					<%
					}
					%>
				</td>
			</tr>
		</table>


	</body>
</html>
