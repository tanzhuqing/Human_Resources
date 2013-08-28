package action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.bean.VRenShiBean;
import db.sqlDao.VRenShiDao;

/**
 * 查询人事调动
 * 
 * @author Administrator
 * 
 */
public class RenShiDemandAction extends ActionSupport {
	private String id;
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String execute() throws Exception {
		ActionContext act = ActionContext.getContext();
		String id = this.getId();
		String name=this.getName();
		VRenShiDao vDao = new VRenShiDao();
		VRenShiBean eznBean = vDao.getUserBeanById(id);

		String sql = "";
		if (!"".equals(id)) {
			sql = " where employess_id='" + id + "'";
		}

		if (!"".equals(name)) {
			if (!"".equals(sql)) {
				sql = sql + " and binary employees_name like  '%" + name + "%'";
			} else {
				sql = "where binary employees_name like  '%" + name + "%'";
			}
		}
		if ("".equals(id) && "".equals(name)) {
			sql = "order by id";
		}
		ArrayList emoloyList = vDao.getOperByWhereSql(sql);
		if (emoloyList.size() == 0) {
			act.put("Error", "没有查询到记录！");
			return ERROR;
		}
		act.put("Array", eznBean);
		act.put("ArrayList", emoloyList);
		return SUCCESS;

	}
}
