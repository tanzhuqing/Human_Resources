package action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import commonjava.CommonFunction;

import db.bean.Super_employeesBean;
import db.sqlDao.Super_employeesDao;

public class LoginAdministerAction extends ActionSupport {

	private String LoginName;
	private String Password;
	private String yanZhengMa;
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getYanZhengMa() {
		return yanZhengMa;
	}

	public void setYanZhengMa(String yanZhengMa) {
		this.yanZhengMa = yanZhengMa;
	}

	public String getLoginName() {
		return LoginName;
	}

	public void setLoginName(String loginName) {
		LoginName = loginName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String execute() throws Exception {
		String loginName = this.getLoginName();
		String password = this.getPassword();
		String yanZhengMa = this.getYanZhengMa();
		String code = (String) ActionContext.getContext().getSession().get(
				"Code");
		if ("".equals(loginName)) {
			ActionContext.getContext().put("Error", "【登录名】不能为空！");
			return ERROR;
		}
		if ("".equals(password)) {
			ActionContext.getContext().put("Error", "【密码】不能为空！");
			return ERROR;
		}
		if ("".equals(code)) {
			ActionContext.getContext().put("Error", "【验证码】不能为空！");
			return ERROR;
		}

		// 验证码是否正确
		if (!code.equals(yanZhengMa)) {
			ActionContext.getContext().put("Error", "【验证码】有误！");
			return ERROR;
		}
		// 开始判断登录名是否正确
		Super_employeesDao uDao = new Super_employeesDao();
		Super_employeesBean super_employeesBean = uDao
				.getEmployeeByemployeeName(loginName);
		// if ("2".equals(super_employeesBean.getStatus())) {
		// ActionContext.getContext().put("Error", "【对不起！】您没有此权限进入该系统！");
		// return ERROR;
		// }
		if (super_employeesBean == null) {
			ActionContext.getContext().put("Error", "【登录名】不正确！");
			return ERROR;
		}

		// 判断密码是否正确
		// 给密码加密
		password = CommonFunction.returnXORString(password);
		if (!password.equals(super_employeesBean.getPass())) {
			ActionContext.getContext().put("Error", "【密码】不正确！");
			return ERROR;
		}

		// 将登录信息临时保存在request中
		ActionContext actionContext = ActionContext.getContext();

		actionContext.getSession().put("user", super_employeesBean);
		actionContext.getSession().put("nameID", super_employeesBean.getId());
		actionContext.getSession().put("stauts",
				super_employeesBean.getStatus());
		return SUCCESS;

	}
}
