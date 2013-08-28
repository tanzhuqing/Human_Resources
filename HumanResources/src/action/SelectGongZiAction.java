package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.bean.Employess_Wage_NoteBean;
import db.sqlDao.Employess_Wage_NoteDao;

public class SelectGongZiAction extends ActionSupport {
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String execute() throws Exception {
		ActionContext act = ActionContext.getContext();
		int id = this.getId();
		Employess_Wage_NoteDao ewnDao = new Employess_Wage_NoteDao();
		Employess_Wage_NoteBean bean = ewnDao.getInformationByemployee_id(id);
		act.put("id", bean.getId());
		act.put("employess_id", bean.getEmployess_id());
		act.put("money", bean.getMoney());
		act.put("time", bean.getTime());
		act.put("userid", bean.getUserid());
		return "success";
	}

}
