package action;

/**
 * 田
 */
import java.util.Date;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.bean.AssmetterBean;
import db.bean.Employees_InformationBean;
import db.sqlDao.AssmetterDao;
import db.sqlDao.Employees_InformationDao;

public class AssmetterAction extends ActionSupport {
	private String employess_id;

	private String matter;
	private String status;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String execute() throws Exception {
		ActionContext ctx = ActionContext.getContext();
		String employess_id = this.getEmployess_id();

		String matter = this.getMatter();
		String status = this.getStatus();
		AssmetterBean abean = new AssmetterBean();
		AssmetterDao adao = new AssmetterDao();
		Employees_InformationDao eiDao = new Employees_InformationDao();
		Employees_InformationBean eiBean = eiDao.getUserBeanById(employess_id);
		if("0".equals(eiBean.getEmployees_status())){
			ctx.put("Error", "该员工已被删除！");
			return ERROR;
		}
		if (eiBean == null) {

			ctx.put("Error", "员工编号不存在！");
			return "error";
		}
		abean.setEmployess_id(employess_id);
		abean.setMatter(matter);
		abean.setTime(new Date());
		abean.setStatus(status);
		adao.addKaoP(abean);
		ctx.put("SuccessOpt", "AddSave");
		return "success";

	}
}
