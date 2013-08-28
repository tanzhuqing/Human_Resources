package action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.bean.Super_employeesBean;
import db.sqlDao.Super_employeesDao;

public class DeleteUserAction extends ActionSupport {
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String execute() throws Exception {
		String id = this.getId();
		Super_employeesDao Sdao = new Super_employeesDao();
		ArrayList<Super_employeesBean> bean = Sdao.getOperByWhereSql("2");
		if (bean != null) {
			ActionContext.getContext().put("user", bean);
		} else {
			ActionContext.getContext().put("Error", "没有查询到普通操作员，无法进行删除操作");
			return ERROR;
		}
		boolean flag = Sdao.deleteUser(Integer.parseInt(id));
		if (flag) {
			ActionContext.getContext().put("SuccessOpt", "updateState");
			return SUCCESS;
		} else {
			ActionContext.getContext().put("Error", "数据库操作失败，请稍后重试");
			return ERROR;
		}
	}

}
