package action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.bean.Employess_Wage_NoteBean;
import db.sqlDao.Employess_Wage_NoteDao;
import db.sqlDao.Employess_wage_noteSqlDao;

public class DeleteGongZiAction extends ActionSupport {
	private int id;
	private String employess_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmployess_id() {
		return employess_id;
	}

	public void setEmployess_id(String employess_id) {
		this.employess_id = employess_id;
	}

	public String execute() throws Exception {
		ActionContext act = ActionContext.getContext();
		
		int id = this.getId();

		String employess_id = this.getEmployess_id();
		Employess_Wage_NoteDao eznDao = new Employess_Wage_NoteDao();
		Employess_wage_noteSqlDao EDao = new Employess_wage_noteSqlDao();
//		ArrayList<Employess_Wage_NoteBean> al = EDao
//				.getPrizeByemployee_id(employess_id);
//
//		ArrayList<Employess_Wage_NoteBean> al1 = eznDao.getEmployees();
//
//		for (int i = 0; i < al1.size(); i++) {
//
//			if (al1.size() == 0) {
//				act.put("Error", "此信息不能删除");
//				return ERROR;
//			} else {
				boolean falg = eznDao.deleteGZ(id);
				if (falg) {
					act.put("Error", "删除成功");
					return "success";
				}
			//}

		//}
		act.put("Error", "删除失败");
		return "success";
	}
}
