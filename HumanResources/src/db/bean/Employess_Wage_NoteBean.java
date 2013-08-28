package db.bean;

import java.util.Date;

/**
 * 工资表
 * 
 * @author Administrator
 * 
 */
public class Employess_Wage_NoteBean {
	private int id;
	private String employess_id;
	private Date time;
	private String money;// 基本工资
	private int userid;
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

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

}
