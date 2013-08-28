package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.bean.BuMenBean;
import db.bean.Employees_InformationBean;
import db.sqlDao.BuMenDao;

public class DeleteBuMen extends ActionSupport {
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	@Override
	public String execute() throws Exception {
		String id = this.getId();
		BuMenBean bean = new BuMenBean();
		BuMenDao dao = new BuMenDao();
//		Employees_InformationBean b = new Employees_InformationBean();
//		b = dao.getchaUserBeanById(id);
//		if (b != null) {
//			ActionContext.getContext().put("Error", "【改部门还有员工】不能进行删除");
//			return ERROR;
//		}
//		if (bean == null) {
//			ActionContext.getContext().put("Error", "【没有改部门】不能进行删除");
//			return ERROR;
//		}
		boolean flag = dao.deleteUser(Integer.parseInt(id));
		if (flag) {
			ActionContext.getContext().put("Error", "【部门】删除成功！");
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
}
