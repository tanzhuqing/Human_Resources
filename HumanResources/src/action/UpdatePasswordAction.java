package action;

import java.io.IOException;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import commonjava.CommonFunction;

import db.bean.Super_employeesBean;
import db.sqlDao.Super_employeesDao;

public class UpdatePasswordAction extends ActionSupport {
	private String old_password;
	private String new_password;
	private String confirm_password;


	public String getOld_password() {
		return old_password;
	}


	public void setOld_password(String old_password) {
		this.old_password = old_password;
	}


	public String getNew_password() {
		return new_password;
	}


	public void setNew_password(String new_password) {
		this.new_password = new_password;
	}


	public String getConfirm_password() {
		return confirm_password;
	}


	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}


	public String execute() throws IOException {
		// 获取修改密码的信息
		String old_password = this.getOld_password();
		String new_password = this.getNew_password();
		String confirm_password = this.getConfirm_password();	
		// （1）判断密码是否为空
		if ("".equals(old_password)) {
			ActionContext.getContext().put("Error", "【旧密码】不能为空！");
			return ERROR;
		}
		if ("".equals(new_password)) {
			ActionContext.getContext().put("Error", "【新密码】不能为空！");
			return ERROR;
		}
		if ("".equals(confirm_password)) {
			ActionContext.getContext().put("Error", "【确认密码】不能为空！");
			return ERROR;
		}
		if (!confirm_password.equals(new_password)) {
			ActionContext.getContext().put("Error", "【新密码】和【确认密码】不一致！");
			return ERROR;
		
		}

		Super_employeesBean bean = (Super_employeesBean) ActionContext
				.getContext().getSession().get("user");
		old_password = CommonFunction.returnXORString(old_password);
		if (!bean.getPass().equals(old_password)) {
			ActionContext.getContext().put("Error", "【旧密码】输入有误！");
			return ERROR;
		}

		Super_employeesDao sDao = new Super_employeesDao();
		new_password = CommonFunction.returnXORString(new_password);
		boolean flag = sDao.updatePasswordById(bean.getUser(), new_password);
		if (flag) {
			bean.setPass(new_password);
			ActionContext.getContext().getSession().put("user", bean);
			ActionContext.getContext().put("SuccessOpt", "ModifyPassword");
			return SUCCESS;
		} else {
			ActionContext.getContext().put("Error", "【修改密码】失败！");
			return ERROR;
		}
	}
}
