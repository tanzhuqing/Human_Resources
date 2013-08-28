package action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.bean.Employees_InformationBean;
import db.sqlDao.Employees_InformationDao;

public class TOSelectEmployees_InformationAction extends ActionSupport {

	/**
	 * 
	 */
	private String employess_id;// 员工ID
	private String name;
	private String sex;
	private String study;
	private String politically;
	private String professional;
	private String job;

	public String getProfessional() {
		return professional;
	}

	public void setProfessional(String professional) {
		this.professional = professional;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getStudy() {
		return study;
	}

	public void setStudy(String study) {
		this.study = study;
	}

	public String getPolitically() {
		return politically;
	}

	public void setPolitically(String politically) {
		this.politically = politically;
	}

	public String execute() throws Exception {

		ActionContext act = ActionContext.getContext();
		String employess_id = this.getEmployess_id();

		String name = this.getName();
		String sex = this.getSex();
		String study = this.getStudy();
		String politically = this.getPolitically();
		String professional = this.getProfessional();
		String job = this.getJob();

		String str = "";
		if (!"".equals(employess_id)) {
			str = " where employess_id = " + employess_id;
		}
		if (!"".equals(name)) {
			if (!"".equals(str)) {
				str = str + " and binary employees_name like  '%" + name + "%'";
			} else {
				str = "where binary employees_name like  '%" + name + "%'";
			}
		}
		if (!"".equals(sex)) {
			if (!"".equals(str)) {
				str = str + " and binary employees_sex like  '%" + sex + "%'";
			} else {
				str = " where  binary employees_sex like  '%" + sex + "%'";
			}
		}
		if (!"".equals(study)) {
			if (!"".equals(str)) {
				str = str + " and binary employees_study like  '%" + study
						+ "%'";
			} else {
				str = " where binary employees_study like  '%" + study + "%'";
			}
		}
		if (!"".equals(politically)) {
			if (!"".equals(str)) {
				str = str + " and binary employees_politically like  '%"
						+ politically + "%'";
			} else {
				str = " where  binary employees_politically like  '%"
						+ politically + "%'";
			}
		}
		if (!"".equals(professional)) {
			if (!"".equals(str)) {
				str = str + " and binary employees_professional like  '%"
						+ professional + "%'";
			} else {
				str = " where  binary employees_professional like  '%"
						+ professional + "%'";
			}
		}
		if (!"".equals(job)) {
			if (!"".equals(str)) {
				str = str + " and binary employess_job like  '%" + job + "%'";
			} else {
				str = " where  binary employess_job like  '%" + job + "%'";
			}
		}
		if ("".equals(employess_id) && "".equals(name) && "".equals(sex)
				&& "".equals(study) && "".equals(politically)
				&& "".equals(professional) && "".equals(job)) {
			str = "order by id";
		}
		Employees_InformationDao mDao = new Employees_InformationDao();
		ArrayList<Employees_InformationBean> al = mDao.getEmployees(str);
		act.put("ArrayList", al);

		return SUCCESS;
	}

}
