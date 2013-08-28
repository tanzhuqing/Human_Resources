package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.bean.Employess_prize_noteBean;
import db.sqlDao.Employess_prize_noteDao;

public class DeleteJangCheng extends ActionSupport {
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String execute() throws Exception {
		ActionContext act = ActionContext.getContext();
		String id = this.getId();
		Employess_prize_noteBean bean = new Employess_prize_noteBean();
		Employess_prize_noteDao JCdao = new Employess_prize_noteDao();
		boolean flag = JCdao.deleteJC(Integer.parseInt(id));
		if (flag) {
			act.put("Error", "删除成功");
			return SUCCESS;
		}
		act.put("Error", "删除成功");
		return ERROR;
	}

}
