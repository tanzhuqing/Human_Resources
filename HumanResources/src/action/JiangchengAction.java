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

public class JiangchengAction extends ActionSupport {
	private String employess_id;
	private String matter;
	private String time;
	private String jiangjin;
	private String fakuan;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
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
		DateFormat f1 = new SimpleDateFormat("yyyy-mm-dd");
		ActionContext actionContext = ActionContext.getContext();
		String employess_id = this.getEmployess_id();
		String matter = this.getMatter();
		String time = this.getTime();
		String jiangjin = this.getJiangjin();
		String fakuan = this.getFakuan();
		String name = this.getName();
		actionContext.put("employess_id", employess_id);
		actionContext.put("matter", matter);
		actionContext.put("time", time);
		actionContext.put("jiangjin", jiangjin);
		actionContext.put("fakuan", fakuan);
		actionContext.put("name", name);
		Employess_prize_noteDao pDao = new Employess_prize_noteDao();
		Employess_prize_noteBean pBean = new Employess_prize_noteBean();
		Employees_InformationDao eiDao = new Employees_InformationDao();
		Employees_InformationBean eiBean = eiDao.getUserBeanById(employess_id);
		if("0".equals(eiBean.getEmployees_status())){
			actionContext.put("Error", "该员工已被删除！");
			return ERROR;
		}
		if (eiBean == null) {
			actionContext.put("Error", "员工编号不存在！");
			return ERROR;
		}  
		if (!name.equals(eiBean.getEmployees_name())) {
			actionContext.put("Error", "该员工与该姓名不一至！");
			return ERROR;
		}
		Super_employeesBean super_employeesBean = (Super_employeesBean) actionContext
				.getContext().getSession().get("user");
		// （3）将信息保存到数据库中
		pBean.setEmployess_id(employess_id);
		pBean.setMatter(matter);
		pBean.setTime(new Date());
		pBean.setJiangjin(jiangjin);
		pBean.setFakuan(fakuan);
		pBean.setUserid(super_employeesBean.getId());
		pBean.setEmployees_name(name);

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
