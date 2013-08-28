package action;

import java.util.Date;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import commonjava.CommonFunction;

import db.bean.Employess_Wage_NoteBean;
import db.bean.Super_employeesBean;
import db.sqlDao.Employess_Wage_NoteDao;
import db.sqlDao.Super_employeesDao;

public class UpdateGongZiAction extends ActionSupport {
	private String employess_id;
	private String money;
	private Date time;
	private int userid;
	private int id;
	private String pass;

	public String getEmployess_id() {
		return employess_id;
	}

	public void setEmployess_id(String employess_id) {
		this.employess_id = employess_id;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String execute() throws Exception {
		ActionContext actionContext = ActionContext.getContext();
		String employess_id = this.getEmployess_id();
		String money = this.getMoney();
		Date time = this.getTime();
		int userid = this.getUserid();
		int id = this.getId();
		String pass=this.getPass();
		actionContext.put("id", id);
		actionContext.put("employess_id", employess_id);
		actionContext.put("money", money);
		actionContext.put("time", time);
		actionContext.put("userid", userid);
		Employess_Wage_NoteDao ewnDao = new Employess_Wage_NoteDao();
		Employess_Wage_NoteBean ewnBean = new Employess_Wage_NoteBean();
		Super_employeesDao sDao = new Super_employeesDao();
		Super_employeesBean sbean = sDao.getUserBeanById(userid);
		pass = CommonFunction.returnXORString(pass);
		if (sbean == null) {
			actionContext.put("Error", "没有此操作员！");
			return SUCCESS;
		}
		if("".equals(pass)){
			actionContext.put("Error", "密码不能为空！");
			return SUCCESS;
		}if(!pass.equals(sbean.getPass())){
			actionContext.put("Error", "密码不正确！");
			return SUCCESS;
		}

		ewnBean.setId(id);
		ewnBean.setEmployess_id(employess_id);
		ewnBean.setMoney(money);
		ewnBean.setTime(new Date());
		ewnBean.setUserid(userid);

		boolean flag = ewnDao.updateJiangCheng(ewnBean);
		if (flag) {// 成功
			actionContext.put("Error", "修改成功！");
			return SUCCESS;
		} else {// 失败
			actionContext.put("Error", "【修改】有误！");
			return SUCCESS;
		}
	}

}
