package db.bean;

import java.util.Date;

public class TrainmetterBean {

	private int id;

	private String employess_id;//员工ID
	private Date month;//培训时间
	private String status;//状态
	private String matter;//培训原因
	public String getEmployess_id() {
		return employess_id;
	}
	public void setEmployess_id(String employess_id) {
		this.employess_id = employess_id;
	}
	public Date getMonth() {
		return month;
	}
	public void setMonth(Date month) {
		this.month = month;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMatter() {
		return matter;
	}
	public void setMatter(String matter) {
		this.matter = matter;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
}
