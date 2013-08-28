package action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.bean.Employees_InformationBean;
import db.bean.Employess_prize_noteBean;
import db.bean.Super_employeesBean;
import db.sqlDao.Employees_InformationDao;
import db.sqlDao.Employess_prize_noteDao;

/**
 * 添加奖惩
 * 
 * @author 李石丰
 * 
 */

public class AddHitoriJiangcheng extends ActionSupport {
	private String employess_id;
	private String matter;
	private String jiangjin;
	private String fakuan;

	public String getEmployess_id() {
		return employess_id;
	}

	public void setEmployess_id(String employess_id) {
		this.employess_id = employess_id;
	}

	public String getMatter() {
		return matter;
	}

	public void setMatter(String matter) {
		this.matter = matter;
	}

	public String getJiangjin() {
		return jiangjin;
	}

	public void setJiangjin(String jiangjin) {
		this.jiangjin = jiangjin;
	}

	public String getFakuan() {
		return fakuan;
	}

	public void setFakuan(String fakuan) {
		this.fakuan = fakuan;
	}

	public String execute() throws Exception {
		ActionContext actionContext = ActionContext.getContext();
		String employess_id = this.getEmployess_id();
		String matter = this.getMatter();
		String jiangjin = this.getJiangjin();
		String fakuan = this.getFakuan();
		actionContext.put("employess_id", employess_id);
		actionContext.put("matter", matter);
		actionContext.put("jiangjin", jiangjin);
		actionContext.put("fakuan", fakuan);

		Employess_prize_noteDao pDao = new Employess_prize_noteDao();
		Employess_prize_noteBean pBean = new Employess_prize_noteBean();
		Employees_InformationDao eiDao = new Employees_InformationDao();
		Employees_InformationBean eiBean = eiDao.getUserBeanById(employess_id);
		Super_employeesBean super_employeesBean = (Super_employeesBean) actionContext.getSession().get("user");
		// （3）将信息保存到数据库中
		pBean.setEmployess_id(employess_id);
		pBean.setMatter(matter);
		pBean.setTime(new Date());
		pBean.setJiangjin(jiangjin);
		pBean.setFakuan(fakuan);
		pBean.setUserid(super_employeesBean.getId());

		boolean flag = pDao.addJiangCheng(pBean);
		// （4）添加成功，返回成功，否则显示错误
		if (flag) {// 成功
			actionContext.put("Error", "添加成功！");
			return SUCCESS;
		} else {// 失败
			actionContext.put("Error", "【添加】有误！");
			return ERROR;
		}
	}
}
