package action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import commonjava.CommonFunction;

import db.bean.Super_employeesBean;
import db.sqlDao.Super_employeesDao;

public class AddElployessAction extends ActionSupport {
	private String employee_Name;
	private String pass;
	private String sure;

	public String getEmployee_Name() {
		return employee_Name;
	}

	public void setEmployee_Name(String employee_Name) {
		this.employee_Name = employee_Name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getSure() {
		return sure;
	}

	public void setSure(String sure) {
		this.sure = sure;
	}

	@Override
	public String execute() throws Exception {
		// 获取操作员信息
		String employee_Name = this.getEmployee_Name();
		String pass = this.getPass();
		String sure = this.getSure();

		if ("".equals(employee_Name)) {
			ActionContext.getContext().put("Error", "【操作员姓名】不能为空！");
			return ERROR;
		}
		if ("".equals(pass)) {
			ActionContext.getContext().put("Error", "【密码】不能为空！");
			return ERROR;
		}
		if ("".equals(sure)) {
			ActionContext.getContext().put("Error", "【确认密码】不能为空！");
			return ERROR;
		}
		if (!pass.equals(sure)) {
			ActionContext.getContext().put("Error", "【密码和确认密码】不一致！");
			return ERROR;
		}
		Super_employeesBean super_employeesBean = new Super_employeesBean();
		Super_employeesDao sDao = new Super_employeesDao();
		ArrayList<Super_employeesBean> al = sDao.getOperByWhereSql("2");
		Super_employeesBean bean = sDao
				.getEmployeeByemployeeName(employee_Name);
		if (bean != null) {
			ActionContext.getContext().put("Error", "【添加操作员】已存在！");
			return ERROR;
		}
		if (al.size() > 3) {
			ActionContext.getContext().put("Error",
					"【对不起，普通管理员只能注册四位】！");
			return ERROR;
		}

		super_employeesBean.setUser(employee_Name);
		super_employeesBean.setPass(CommonFunction.returnXORString(pass));
		super_employeesBean.setSure(sure);
		super_employeesBean.setStatus("2");
		boolean flag = sDao.addEmployee(super_employeesBean);

		if (flag) {
			ActionContext.getContext().put("Error", "【添加操作员】成功！");
			ActionContext.getContext().put("SuccessOpt", "CardSave");
			return SUCCESS;
		} else {

			return ERROR;
		}

	}
}
