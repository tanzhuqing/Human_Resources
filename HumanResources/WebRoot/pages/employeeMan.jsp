<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html>
	<head>


		<title>员工登入后的界面</title>

	
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
		<script type="text/javascript">
	function Click(form){
				document.addForm.action="addEmploye.action";
				document.addForm.submit();
			}
			</script>
	<body bgcolor="#9A9AFE">

		<form action="zhujie.action" method="post" name="addForm">

			<p align="center">
				<input type="submit" value="主界面" class="btn_2K3">
				<input type="button" value="修改密码" class="btn_2K3">
				<input type="button" value="系统维护" class="btn_2K3">

			</p>
		</form>

		<table align="center" height="100%"width="100%">
<tr>
<td>
		<div id="masterdiv">
			<div class="menutitle" onclick="SwitchMenu('sub1')">
				人事档案管理
			</div>
			<span class="submenu" id="sub1" > <a href="business.action" >事务管理</a> </span>
			<div class="menutitle" onclick="SwitchMenu('sub2')">
				考勤资料查询
			</div>
			<span class="submenu" id="sub2"> <a href="/">考勤查询</a> </span>
			
			<div class="menutitle" onclick="SwitchMenu('sub3')">
				模糊信息管理
			</div>
			<span class="submenu" id="sub3"> <a
				href="mohu.action">模糊查询</a> </span>
		</div>
		</td>
		</tr>
		</table>


	</body>
</html>
