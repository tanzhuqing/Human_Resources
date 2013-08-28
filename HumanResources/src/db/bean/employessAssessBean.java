package db.bean;

import java.util.Date;

public class employessAssessBean {
	private int id;
	private String employees_name;
	private String employees_sex;
	private String employess_id;

	private Date time;
	private String matter;// 原因
	private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getMatter() {
		return matter;
	}

	public void setMatter(String matter) {
		this.matter = matter;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
