package action;

import java.util.Date;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.bean.Employees_InformationBean;
import db.bean.Employess_Wage_NoteBean;
import db.bean.Super_employeesBean;
import db.sqlDao.Employees_InformationDao;
import db.sqlDao.Employess_Wage_NoteDao;

public class AddGongZiAction extends ActionSupport {
	private String employess_id;
	private String employess_name;
	private String money;

	public String getEmployess_id() {
		return employess_id;
	}

	public void setEmployess_id(String employess_id) {
		this.employess_id = employess_id;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getEmployess_name() {
		return employess_name;
	}

	public void setEmployess_name(String employess_name) {
		this.employess_name = employess_name;
	}

	public String execute() throws Exception {
		ActionContext actionContext = ActionContext.getContext();
		String employess_id = this.getEmployess_id();
		String money = this.getMoney();
		String employess_name=this.getEmployess_name();
		actionContext.put("employess_id", employess_id);
		actionContext.put("employess_name", employess_name);
		actionContext.put("money", money);
		if ("".equals(money)) {
			actionContext.put("Error", "基本工资不能为空");
			return "error";
		}

		Employess_Wage_NoteBean ewBean = new Employess_Wage_NoteBean();
		Employess_Wage_NoteDao ewnDao = new Employess_Wage_NoteDao();
		Super_employeesBean super_employeesBean = (Super_employeesBean) actionContext
				.getContext().getSession().get("user");
		Employees_InformationDao eiDao = new Employees_InformationDao();
		Employees_InformationBean eiBean = eiDao.getUserBeanById(employess_id);
		if("0".equals(eiBean.getEmployees_status())){
			actionContext.put("Error", "该员工已被删除！");
			return ERROR;
		}
		ewBean.setEmployess_id(employess_id);
		ewBean.setTime(new Date());
		ewBean.setMoney(money);
		ewBean.setUserid(super_employeesBean.getId());
		ewnDao.addWage(ewBean);
		actionContext.put("Error", "添加成功");
		return "success";
	}

}
