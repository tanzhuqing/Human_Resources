package action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.bean.Employess_Wage_NoteBean;
import db.sqlDao.Employees_InformationDao;

public class DeleteTiaoXin extends ActionSupport {

	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String execute() throws Exception {
		String id = this.getId();
		ActionContext act = ActionContext.getContext();
		Employees_InformationDao EDao = new Employees_InformationDao();
		ArrayList<Employess_Wage_NoteBean> eBean = EDao
				.getMobileCardByWhereSqltiaoxin(id);

		if ("".equals(id)) {
			act.put("Error", "员工编号不能为空！");
			return "error";
		}

		if (eBean == null) {
			act.put("Error", "没有此操作员！");

			return "error";
		}

		boolean flag = EDao.deleteEmplotess(id);
		if (flag) {// 成功
			act.put("SuccessOpt", "delete");
			return "success";

		} else {// 失败
			act.put("Error", "【删除操作员】有误！");
			return "error";
		}
	}

}
