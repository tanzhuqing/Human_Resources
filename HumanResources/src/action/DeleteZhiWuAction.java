package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.bean.Employess_zhiwuBean;
import db.sqlDao.ZhiwuDao;

public class DeleteZhiWuAction extends ActionSupport {
	private String zhiwu;
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getZhiwu() {
		return zhiwu;
	}

	public void setZhiwu(String zhiwu) {
		this.zhiwu = zhiwu;
	}

	public String execute() throws Exception {
		String zhiwu = this.getZhiwu();
		String id = this.getId();
		Employess_zhiwuBean bean = new Employess_zhiwuBean();
		ZhiwuDao dao = new ZhiwuDao();
		boolean flag = dao.deleteUser(Integer.parseInt(id));

		if (flag) {
			ActionContext.getContext().put("Error", "【职务】删除成功！");

			return SUCCESS;
		} else {
			return ERROR;
		}
	}
}
