package action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.bean.Employees_InformationBean;
import db.bean.Employess_Wage_NoteBean;
import db.bean.Employess_Zhiwu_NoteBean;
import db.sqlDao.Employees_InformationDao;
import db.sqlDao.Employess_Wage_NoteDao;
import db.sqlDao.Employess_Zhiwu_NoteDao;

/**
 * 查询员工
 * 
 * @author lp
 * 
 */
public class BusinessAction extends ActionSupport {
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

		Employees_InformationDao eiDao = new Employees_InformationDao();
		Employees_InformationBean eiBean = eiDao.getUserBeanById(id);

		if (eiBean == null) {

			act.put("Error", "员工编号不存在！");
			return "success";
		}
		if ("0".equals(eiBean.getEmployees_status())) {
			act.put("Error", "该员工已被删除！");
			return "success";
		} else {
			// 职务
			Employess_Zhiwu_NoteDao eznDao = new Employess_Zhiwu_NoteDao();
			Employess_Zhiwu_NoteBean ezBean = eznDao.getEmployessById(id);
			Employess_Wage_NoteDao ewDao = new Employess_Wage_NoteDao();
			Employess_Wage_NoteBean ewnBean = ewDao.getEmployessById(id);

			String sql = "";
			if (!"".equals(id)) {
				sql = " where employess_id='" + id + "'";
			}
			ArrayList emoloyList = eiDao.getEmployeesByWhere(sql);

			if (emoloyList.size() == 0) {
				act.put("Error", "没有查询到记录！");
				return "success";
			}
			act.put("id", eiBean.getEmployess_id());
			act.put("userName", eiBean.getEmployees_name());
			act.put("sex", eiBean.getEmployees_sex());
			act.put("marriage", eiBean.getEmployees_marriage());
			act.put("city", eiBean.getEmployees_city());
			act.put("study", eiBean.getEmployees_study());
			act.put("politically", eiBean.getEmployees_politically());
			act.put("identity", eiBean.getEmployees_identity());
			act.put("mobile", eiBean.getEmployees_mobile());
			act.put("tel", eiBean.getEmployees_tel());
			act.put("lashup_tel", eiBean.getEmployees_lashup_tel());
			act.put("email", eiBean.getEmployees_email());
			act.put("professional", eiBean.getEmployees_professional());
			act.put("jointime", eiBean.getEmployess_jointime());
			act.put("engtime", eiBean.getElmployess_engtime());
			act.put("photo", eiBean.getEmployees_photo());
			act.put("money", ewnBean.getMoney());

			if (ezBean == null) {
				act.put("section", eiBean.getEmployess_job());
			} else {
				act.put("section", ezBean.getEmployess_job());
			}
			act.put("Array", emoloyList);

			return "success";
		}
	}
}
