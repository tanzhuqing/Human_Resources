package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.bean.Employees_InformationBean;
import db.bean.Employess_zhiwuBean;
import db.sqlDao.ZhiwuDao;

public class AddZhiWuAction extends ActionSupport {
	private String zhiwu;

	public String getZhiwu() {
		return zhiwu;
	}

	public void setZhiwu(String zhiwu) {
		this.zhiwu = zhiwu;
	}

	@Override
	public String execute() throws Exception {
		// 获取操作员信息
		String zhiwu = this.getZhiwu();
		if ("".equals(zhiwu)) {
			ActionContext.getContext().put("Error", "【职务】不能为空！");
			return ERROR;
		}

		Employees_InformationBean b = new Employees_InformationBean();

		Employess_zhiwuBean bean = new Employess_zhiwuBean();

		ZhiwuDao dao = new ZhiwuDao();
		bean = dao.getzhiwuUserBeanById(zhiwu);
		if (bean != null) {
			ActionContext.getContext().put("Error", "【职务】已存在！");
			return ERROR;
		}
		Employess_zhiwuBean bean1 = new Employess_zhiwuBean();

		bean1.setEmployess_job(zhiwu);
		boolean flag = dao.addEmployee(bean1);
		if (flag) {
			ActionContext.getContext().put("Error", "【职务】成功！");
			return SUCCESS;
		} else {

			return ERROR;
		}

	}
}
