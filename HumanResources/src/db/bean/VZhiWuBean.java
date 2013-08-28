package db.bean;

import java.util.Date;

public class VZhiWuBean {
	private int id;
	private String employess_id;// 员工ID
	private String employees_name;// 员工姓名
	private Date time;// 时间
	private String money;// 基本工资
	private int userid;
	private String user;

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

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}
