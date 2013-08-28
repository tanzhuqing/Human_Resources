package action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.bean.BuMenBean;
import db.sqlDao.BuMenDao;

public class ToAddzhiwuKong extends ActionSupport{
	@Override
	public String execute() throws Exception {
		BuMenDao dao = new BuMenDao();

		ArrayList<BuMenBean> bean = dao.getAllBuMenByWhere();

		ActionContext.getContext().put("all", bean);
		return SUCCESS;
	}

}
