package action;

import java.util.Date;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.bean.AssmetterBean;
import db.bean.employessAssessBean;
import db.sqlDao.employessAssessSqlDao;

public class UpdateKaoQin extends ActionSupport {
	private String kong;

	private String matter;
	private String status;



	public String getKong() {
		return kong;
	}

	public void setKong(String kong) {
		this.kong = kong;
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

	public String execute() throws Exception {
		ActionContext ctx = ActionContext.getContext();
		String matter = this.getMatter();
		String status = this.getStatus();
		employessAssessBean abean = new employessAssessBean();

		employessAssessSqlDao adao = new employessAssessSqlDao();
		abean.setId(Integer.parseInt(kong));
		abean.setMatter(matter);
		abean.setStatus(status);
		boolean flag = adao.updateKaoQinbyID(abean);
		if (flag) {
			ctx.put("SuccessOpt", "AddSave");
		}
		return "success";

	}
}
