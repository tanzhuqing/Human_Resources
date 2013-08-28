package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.bean.Employees_InformationBean;
import db.sqlDao.Employees_InformationDao;

public class DeleteBusiness extends ActionSupport {
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String execute() throws Exception {
		ActionContext act = ActionContext.getContext();
		String id = this.getId();

		Employees_InformationDao EDao = new Employees_InformationDao();
		Employees_InformationBean eBean = EDao.getUserBeanById(id);
		if ("".equals(id)) {
			act.put("Error", "员工编号不能为空！");
			return "error";
		}
		
		if (eBean==null) {
			act.put("Error", "没有此操作员！");

			return "error";
		}
		
		if (Integer.parseInt(eBean.getEmployees_status()) == 0) {
			act.put("Error", "该用操作员已被删除不能重复删除！");

			return "error";
		}
		boolean flag = EDao.updateEmployeeStateByNumber("0", id);
		if (flag) {// 成功
			act.put("SuccessOpt", "delete");
			return "success";

		} else {// 失败
			act.put("Error", "【删除操作员】有误！");
			return "error";
		}
	}

}
