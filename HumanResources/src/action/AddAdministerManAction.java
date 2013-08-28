package action;

/**
 * 添加考评原因
 * 田
 */

import java.util.Date;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.bean.Employees_InformationBean;
import db.bean.employessTrainBean;
import db.sqlDao.Employees_InformationDao;
import db.sqlDao.employessTrainSqlDao;


public class AddAdministerManAction extends ActionSupport {

	private String employess_id;
	private String matter;

	public String getEmployess_id() {
		return employess_id;
	}

	public void setEmployess_id(String employess_id) {
		this.employess_id = employess_id;
	}

	public String getMatter() {
		return matter;
	}

	public void setMatter(String matter) {
		this.matter = matter;
	}

	@Override
	public String execute() throws Exception {
		String employess_id = this.getEmployess_id();
		String matter = this.getMatter();
		ActionContext actionContext = ActionContext.getContext();
		employessTrainBean bean = new employessTrainBean();
		Employees_InformationDao eiDao = new Employees_InformationDao();
		Employees_InformationBean eiBean = eiDao.getUserBeanById(employess_id);
		if("0".equals(eiBean.getEmployees_status())){
			actionContext.put("Error", "该员工已被删除！");
			return ERROR;
		}
		if (eiBean == null) {

			actionContext.put("Error", "员工编号不存在！");
			return ERROR;
		}
		bean.setEmployess_id(employess_id);
		bean.setStatus("1");
		bean.setMatter(matter);
		bean.setMonth(new Date());

		employessTrainSqlDao sqlDao = new employessTrainSqlDao();

		boolean f = sqlDao.addPeiXun(bean);
		if (f) {
			actionContext.put("SuccessOpt", "Addbecase");
			return SUCCESS;
		} else {// 失败
			actionContext.put("Error", "【添加】失败！");
			return ERROR;
		}

	}
}
