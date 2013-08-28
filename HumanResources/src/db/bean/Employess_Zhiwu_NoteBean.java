package db.bean;

import java.util.Date;
/**
 * 职务表
 * @author lp
 *
 */
public class Employess_Zhiwu_NoteBean {
	private int id;
	private String employess_id;
	private Date time;// 入职时间
	private String employess_job;// 职务

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

}
