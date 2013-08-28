package action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.bean.Employess_Wage_NoteBean;
import db.sqlDao.Employess_wage_noteSqlDao;

/**
 * 调薪查询
 * 
 * @author 李石丰
 * 
 */
public class PayChaXunAction extends ActionSupport {
	private String employess_id;
	private String time;
	private String money;

	public String getEmployess_id() {
		return employess_id;
	}

	public void setEmployess_id(String employess_id) {
		this.employess_id = employess_id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String execute() throws Exception {
		ActionContext actionContext = ActionContext.getContext();
		String employess_id = this.getEmployess_id();
		String time = this.getTime();
		String money = this.getMoney();

		actionContext.put("employess_id", employess_id);
		actionContext.put("time", time);
		actionContext.put("money", money);

		Employess_wage_noteSqlDao wDao = new Employess_wage_noteSqlDao();
		ArrayList<Employess_Wage_NoteBean> wBean = wDao
				.getPrizeByemployee_id(employess_id);
		if ("".equals(employess_id)) {
			actionContext.put("Error", "员工的id不能为空！");
			return ERROR;
		}
		if (wBean.size() <= 0) {
			actionContext.put("Error", "没有该员工或该员没有调薪记录...");
			return ERROR;
		}
		actionContext.put("emoloyList", wBean);
		return SUCCESS;
	}

}
