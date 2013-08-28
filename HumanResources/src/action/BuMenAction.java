package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.bean.BuMenBean;
import db.sqlDao.BuMenDao;

public class BuMenAction extends ActionSupport {

	private String bumen;

	public String getBumen() {
		return bumen;
	}

	public void setBumen(String bumen) {
		this.bumen = bumen;
	}

	@Override
	public String execute() throws Exception {
		// 获取操作员信息
		String bumen = this.getBumen();

		if ("".equals(bumen)) {
			ActionContext.getContext().put("Error", "【部门】不能为空！");
			return ERROR;
		}
		BuMenBean bean = new BuMenBean();
		BuMenDao dao = new BuMenDao();
		bean=null;
		bean = dao.getcaUserBeanById(bumen);

		if (bean != null) {
			ActionContext.getContext().put("Error", "【部门】已存在！");
			return ERROR;
		}
		BuMenBean bean1 = new BuMenBean();
		bean1.setEmployees_professional(bumen);
		System.out.println(bean1.getEmployees_professional());

		boolean flag = dao.addEmployee(bean1);
		if (flag) {
			ActionContext.getContext().put("Error", "【部门】成功！");
			return SUCCESS;
		} else {

			return ERROR;
		}

	}
}
