package action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.bean.Super_employeesBean;
import db.sqlDao.Super_employeesDao;

public class SelectEmployess extends ActionSupport {

	public String execute() throws Exception {

		Super_employeesDao Sdao = new Super_employeesDao();
		ArrayList<Super_employeesBean> bean = Sdao.getOperByWhereSql("2");
		if (bean == null) {
			ActionContext.getContext().put("Error", "目前没有普通操作员，无法执行删除操作");
			return ERROR;
		}
		ActionContext.getContext().put("user", bean);
		return SUCCESS;
		
	}

}
