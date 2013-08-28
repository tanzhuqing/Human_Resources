package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.bean.employessAssessBean;
import db.sqlDao.employessAssessSqlDao;

public class DeleteKaoQin extends ActionSupport {
	private String employess_id;

	public String getEmployess_id() {
		return employess_id;
	}

	public void setEmployess_id(String employess_id) {
		this.employess_id = employess_id;
	}

	@Override
	public String execute() throws Exception {
		String employess_id = this.getEmployess_id();
		employessAssessBean bean = new employessAssessBean();
		employessAssessSqlDao dao = new employessAssessSqlDao();
		boolean flag = dao.deleteUser(employess_id);

		if (flag) {
			ActionContext.getContext().put("Error", "【个人信息】删除成功！");
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

}
