//只允许输入整数数字
function keyPressClick(obj) {
	obj.value = obj.value.replace(/[^0-9]/g, "");
}
		
function isnumber(str) {
	var digits = "1234567890-";
	var i = 0;
	var ii = 0;
	var strlen = str.length;
	while ((i < strlen)) {
		var ch = str.charAt(i);
		if (ch == ".") {
			ii++;
		}
		if (ii > 1) {
			return false;
		}
		if (digits.indexOf(ch) == -1) {
			return false;
		}
		i++;
	}
	return true;
}

function isnumber1(str) {
	var digits = "1234567890";
	var i = 0;
	var ii = 0;
	var strlen = str.length;
	while ((i < strlen)) {
		var ch = str.charAt(i);
		if (ch == ".") {
			ii++;
		}
		if (ii > 1) {
			return false;
		}
		if (digits.indexOf(ch) == -1) {
			return false;
		}
		i++;
	}
	return true;
}
function isnumber2(str) {
	var digits = "1234567890.";
	var i = 0;
	var ii = 0;
	var strlen = str.length;
	while ((i < strlen)) {
		var ch = str.charAt(i);
		if (ch == ".") {
			ii++;
		}
		if (ii > 1) {
			return false;
		}
		if (digits.indexOf(ch) == -1) {
			return false;
		}
		i++;
	}
	return true;
}

function isnumber3(str) {
	var digits = "1234567890:";
	var i = 0;
	var ii = 0;
	var strlen = str.length;
	while ((i < strlen)) {
		var ch = str.charAt(i);
		if (ch == ":") {
			ii++;
		}
		if (ii > 1) {
			return false;
		}
		if (digits.indexOf(ch) == -1) {
			return false;
		}
		i++;
	}
	return true;
}



//验证E-mail地址
function checkemail(str) {
	var Expression = /\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/;
	var objExp = new RegExp(Expression);
	if (objExp.test(str) == true) {
		return true;
	} else {
		return false;
	}
}

//关闭系统
function myclose() {
	if (confirm("\u786e\u8ba4\u8981\u5173\u95ed\u5f53\u524d\u7a97\u53e3\u5417?")) {
		window.close();
	}
}

//退出系统
function quit() {
	if (confirm("\u786e\u8ba4\u8981\u9000\u51fa\u7cfb\u7edf\u5417?")) {
		window.location.href = "returnLogon.do";
	}
}

