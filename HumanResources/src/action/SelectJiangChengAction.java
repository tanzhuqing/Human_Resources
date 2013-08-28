package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.bean.Employess_prize_noteBean;
import db.sqlDao.Employess_prize_noteDao;

public class SelectJiangChengAction extends ActionSupport {
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
		Employess_prize_noteDao pDao = new Employess_prize_noteDao();
		Employess_prize_noteBean bean = pDao.getInformationByemployee_id(id);
		act.put("id", bean.getId());
		act.put("employess_id", bean.getEmployess_id());
		act.put("matter", bean.getMatter());
		act.put("fakuan", bean.getFakuan());
		act.put("jiangjin", bean.getJiangjin());
		return SUCCESS;

	}
}
