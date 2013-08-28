package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.bean.employessAssessBean;

import db.sqlDao.employessAssessSqlDao;

public class ToupdateKaoQin extends ActionSupport {
	private String employess_id;

	public String getEmployess_id() {
		return employess_id;
	}

	public void setEmployess_id(String employess_id) {
		this.employess_id = employess_id;
	}

	@Override
	public String execute() throws Exception {
		ActionContext act=ActionContext.getContext();
		employessAssessBean bean = new employessAssessBean();
		employessAssessSqlDao uDao = new employessAssessSqlDao();
		bean = uDao.getEmployeeByEmployeeOID(Integer.parseInt(employess_id));
		ActionContext.getContext().put("bean", bean);
		act.put("status", bean.getStatus());
		return SUCCESS;
	}

}
