package action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.bean.Employees_InformationBean;
import db.bean.Employess_Wage_NoteBean;
import db.sqlDao.Employees_InformationDao;
import db.sqlDao.Employess_wage_noteSqlDao;

/**
 * 修改工资
 * 
 * @author Administrator
 * 
 */
public class UpdateWageAction extends ActionSupport {

	private String employess_id;

	private String money;
	private String state;

	public String getEmployess_id() {
		return employess_id;
	}

	public void setEmployess_id(String employess_id) {
		this.employess_id = employess_id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}



	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String execute() throws Exception {
		DateFormat f1 = new SimpleDateFormat("yyyy-MM-dd");
		ActionContext actionContext = ActionContext.getContext();
		String employess_id = this.getEmployess_id();
	
		String money = this.getMoney();
		String state = this.getState();

		actionContext.put("employess_id", employess_id);
		actionContext.put("money", money);
		actionContext.put("state", state);


		Employess_wage_noteSqlDao wDao = new Employess_wage_noteSqlDao();
		Employess_Wage_NoteBean wBean = new Employess_Wage_NoteBean();
		Employees_InformationDao eiDao=new Employees_InformationDao();
		Employees_InformationBean eiBean=eiDao.getUserBeanById(employess_id);
	
		if(eiBean==null){

				actionContext.put("Error", "员工编号不存在！");
				return SUCCESS;
			}
		// （3）将信息保存到数据库中
		wBean.setEmployess_id(employess_id);
		wBean.setTime(new Date());
		wBean.setMoney(money);

		boolean flag = wDao.addEmployee(wBean);
		// （4）添加成功，返回成功，否则显示错误
		if (flag) {// 成功
			actionContext.put("Error", "操作成功！");
			return SUCCESS;
		} else {// 失败
			actionContext.put("Error", "【添加】有误！");
			return ERROR;
		}
	}
}
