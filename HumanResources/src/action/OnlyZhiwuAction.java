package action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.bean.VZhiWuBean;
import db.sqlDao.Employess_wage_noteSqlDao;

public class OnlyZhiwuAction extends ActionSupport {
	private String workerID;
	private String name;

	public String getWorkerID() {
		return workerID;
	}

	public void setWorkerID(String workerID) {
		this.workerID = workerID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String execute() throws Exception {

		ActionContext ctx = ActionContext.getContext();
		String workerID = this.getWorkerID();
		Employess_wage_noteSqlDao ewDao = new Employess_wage_noteSqlDao();

		String sql = "";
		if (!"".equals(workerID)) {
			sql = " where employess_id='" + workerID + "'";
		}
		if (!"".equals(name)) {
			if (!"".equals(sql)) {
				sql = sql + " and binary employees_name like  '%" + name + "%'";
			} else {
				sql = "where binary employees_name like  '%" + name + "%'";
			}
		}
		if ("".equals(workerID) && "".equals(name)) {
			sql = "order by id";
		}
		ArrayList<VZhiWuBean> al = ewDao.getOperWhereSql(sql);
		
		if (al.size() == 0) {
			ctx.put("Error", "没有查询到记录！");
			return ERROR;
		}

		ctx.put("ArrayList", al);
		return SUCCESS;
	}

}
