package action;

/**
 * 田
 * 考勤培训
 */
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.bean.Employees_InformationBean;
import db.bean.employessTrainBean;
import db.sqlDao.Employees_InformationDao;
import db.sqlDao.employessTrainSqlDao;

public class employessTrainAction extends ActionSupport {
	private String employess_id;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmployess_id() {
		return employess_id;
	}

	public void setEmployess_id(String employess_id) {
		this.employess_id = employess_id;
	}

	public String execute() throws Exception {
		String name = this.getName();
		ActionContext actionContext = ActionContext.getContext();
		String employess_id = this.getEmployess_id();
		employessTrainSqlDao cDao = new employessTrainSqlDao();
		
		ArrayList<employessTrainBean> al = new ArrayList<employessTrainBean>();

		String sql = "";
		if (!"".equals(employess_id)) {
			sql = "where employess_id='" + employess_id + "'";
		}
		if (!"".equals(employess_id)) {
			sql = "where employess_id='" + employess_id + "'";
		}
		al = cDao.getMobileCardByWhereSql(sql);
		if (al.size() == 0) {
			actionContext.put("Error", "此员工没有培训记录");

			return ERROR;
		}
		actionContext.put("ArrayList_Card", al);

		return SUCCESS;

	}
}
