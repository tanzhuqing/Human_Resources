package db.bean;

import java.util.Date;

/**
 * 奖惩管理
 * 
 * @author 李石丰
 * 
 */
public class Employess_prize_noteBean {

	private int id;// id
	private String employess_id;// 员工编号
	private String matter;// 奖惩原因
	private Date time;// 奖惩时间
	private String jiangjin;// 奖励金额0
	private String fakuan;// 罚款金额
	private String employees_name;
	private int userid;
	private String user;
	

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
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

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
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

	public String getEmployees_name() {
		return employees_name;
	}

	public void setEmployees_name(String employees_name) {
		this.employees_name = employees_name;
	}

}
