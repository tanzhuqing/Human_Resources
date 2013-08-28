package action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.bean.BuMenBean;
import db.bean.Employess_zhiwuBean;
import db.sqlDao.BuMenDao;
import db.sqlDao.ZhiwuDao;

public class SelectzhiwuKong extends ActionSupport {
	private int optzhiwu;

	public int getOptzhiwu() {
		return optzhiwu;
	}

	public void setOptzhiwu(int optzhiwu) {
		this.optzhiwu = optzhiwu;
	}

	@Override
	public String execute() throws Exception {
		ActionContext act = ActionContext.getContext();
		ZhiwuDao zhiwuDao = new ZhiwuDao();
		BuMenBean bubean=new BuMenBean();
		BuMenDao budao=new BuMenDao();
		ArrayList<Employess_zhiwuBean> al = new ArrayList<Employess_zhiwuBean>();
		al = zhiwuDao.getAllzhiwuByoptbumen(optzhiwu);
		act.put("al", al);
		bubean=budao.getcaUserBeanByIdKong(optzhiwu);
		if(bubean==null){
			act.put("Error", "请选择部门后再进行查询");
			return ERROR;
		}
		act.put("optzhiwu11", bubean.getEmployees_professional());
		return SUCCESS;
	}
}
