package db.bean;

import java.util.Date;

public class VRenShiBean {
	private int id;
	private String employess_id;
	private Date time;// 入职时间
	private String employess_job;// 职务
	private String employees_name;// 员工姓名
	private String employees_status;
	private String employees_professional;
	private Date employess_jointime;// 入职时间
	private Date elmployess_engtime;// 终止时间
	private String employees_sex;// 工员性别
	private String employees_study;// 最高的学历
	private String employees_politically;// 政治面貌

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmployess_id() {
		return employess_id;
	}

	public void setEmployess_id(String employess_id) {
		this.employess_id = employess_id;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getEmployess_job() {
		return employess_job;
	}

	public void setEmployess_job(String employess_job) {
		this.employess_job = employess_job;
	}

	public String getEmployees_name() {
		return employees_name;
	}

	public void setEmployees_name(String employees_name) {
		this.employees_name = employees_name;
	}

	public String getEmployees_status() {
		return employees_status;
	}

	public void setEmployees_status(String employees_status) {
		this.employees_status = employees_status;
	}

	public String getEmployees_professional() {
		return employees_professional;
	}

	public void setEmployees_professional(String employees_professional) {
		this.employees_professional = employees_professional;
	}

	public Date getEmployess_jointime() {
		return employess_jointime;
	}

	public void setEmployess_jointime(Date employess_jointime) {
		this.employess_jointime = employess_jointime;
	}

	public Date getElmployess_engtime() {
		return elmployess_engtime;
	}

	public void setElmployess_engtime(Date elmployess_engtime) {
		this.elmployess_engtime = elmployess_engtime;
	}

	public String getEmployees_sex() {
		return employees_sex;
	}

	public void setEmployees_sex(String employees_sex) {
		this.employees_sex = employees_sex;
	}

	public String getEmployees_study() {
		return employees_study;
	}

	public void setEmployees_study(String employees_study) {
		this.employees_study = employees_study;
	}

	public String getEmployees_politically() {
		return employees_politically;
	}

	public void setEmployees_politically(String employees_politically) {
		this.employees_politically = employees_politically;
	}

}
