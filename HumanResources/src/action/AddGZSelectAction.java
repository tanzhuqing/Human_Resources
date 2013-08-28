package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.bean.Employees_InformationBean;
import db.bean.Employess_Wage_NoteBean;
import db.sqlDao.Employees_InformationDao;
import db.sqlDao.Employess_Wage_NoteDao;

public class AddGZSelectAction extends ActionSupport {
	private String employess_id;

	public String getEmployess_id() {
		return employess_id;
	}

	public void setEmployess_id(String employess_id) {
		this.employess_id = employess_id;
	}

	public String execute() throws Exception {

		ActionContext act = ActionContext.getContext();
		String employess_id = this.getEmployess_id();
		Employees_InformationDao eiDao = new Employees_InformationDao();
		Employees_InformationBean eibean = eiDao.getUserBeanById(employess_id);
		Employess_Wage_NoteDao ewnDao = new Employess_Wage_NoteDao();
		Employess_Wage_NoteBean bean = ewnDao.getGz(employess_id);

		act.put("employess_id", bean.getEmployess_id());
		act.put("employess_name", eibean.getEmployees_name());
		return "success";
	}

}
