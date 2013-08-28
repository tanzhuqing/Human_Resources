package db.bean;

import java.util.Date;

public class Employees_InformationBean {
	private int id;
	private String employess_id;// 员工ID
	private String employees_name;// 员工姓名
	private String employees_sex;// 工员性别
	private String employees_marriage;// 婚姻状况
	private String employees_city;// 所在的城市
	private String employees_study;// 最高的学历
	private String employees_politically;// 政治面貌
	private String employees_identity;// 员工的身份证号
	private String employees_mobile;// 员工的手机号
	private String employees_tel;// 员工家的电话
	private String employees_lashup_tel;// 员工的应急电话
	private String employees_email;// 邮箱
	private String employees_professional;// 部门
	private String employess_job;// 部门
	private Date employess_jointime;// 入职时间
	private Date elmployess_engtime;// 终止时间
	private String employees_photo;// 照片
	private String employees_status;// 1:超管理员2:普通管理员3:员工

	
	public String getEmployess_job() {
		return employess_job;
	}

	public void setEmployess_job(String employess_job) {
		this.employess_job = employess_job;
	}

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

	public String getEmployees_name() {
		return employees_name;
	}

	public void setEmployees_name(String employees_name) {
		this.employees_name = employees_name;
	}

	public String getEmployees_sex() {
		return employees_sex;
	}

	public void setEmployees_sex(String employees_sex) {
		this.employees_sex = employees_sex;
	}

	public String getEmployees_marriage() {
		return employees_marriage;
	}

	public void setEmployees_marriage(String employees_marriage) {
		this.employees_marriage = employees_marriage;
	}

	public String getEmployees_city() {
		return employees_city;
	}

	public void setEmployees_city(String employees_city) {
		this.employees_city = employees_city;
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

	public String getEmployees_identity() {
		return employees_identity;
	}

	public void setEmployees_identity(String employees_identity) {
		this.employees_identity = employees_identity;
	}

	public String getEmployees_mobile() {
		return employees_mobile;
	}

	public void setEmployees_mobile(String employees_mobile) {
		this.employees_mobile = employees_mobile;
	}

	public String getEmployees_tel() {
		return employees_tel;
	}

	public void setEmployees_tel(String employees_tel) {
		this.employees_tel = employees_tel;
	}

	public String getEmployees_lashup_tel() {
		return employees_lashup_tel;
	}

	public void setEmployees_lashup_tel(String employees_lashup_tel) {
		this.employees_lashup_tel = employees_lashup_tel;
	}

	public String getEmployees_email() {
		return employees_email;
	}

	public void setEmployees_email(String employees_email) {
		this.employees_email = employees_email;
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

	public String getEmployees_photo() {
		return employees_photo;
	}

	public void setEmployees_photo(String employees_photo) {
		this.employees_photo = employees_photo;
	}

	public String getEmployees_status() {
		return employees_status;
	}

	public void setEmployees_status(String employees_status) {
		this.employees_status = employees_status;
	}

}
