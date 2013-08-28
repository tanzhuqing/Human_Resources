package action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.bean.Employess_prize_noteBean;
import db.sqlDao.Employess_prize_noteDao;

public class UpdateJiangChengAction extends ActionSupport {
	private String employess_id;
	private String matter;
	private String jiangjin;
	private String fakuan;
	private int id;

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String execute() throws Exception {
		DateFormat f1 = new SimpleDateFormat("yyyy-MM-dd");
		ActionContext actionContext = ActionContext.getContext();
		String employess_id = this.getEmployess_id();
		String matter = this.getMatter();
		String jiangjin = this.getJiangjin();
		String fakuan = this.getFakuan();
		int id=this.getId();
		actionContext.put("id", id);
		actionContext.put("employess_id", employess_id);
		actionContext.put("matter", matter);
		actionContext.put("jiangjin", jiangjin);
		actionContext.put("fakuan", fakuan);

		Employess_prize_noteDao pDao = new Employess_prize_noteDao();
		Employess_prize_noteBean pBean = new Employess_prize_noteBean();

		if (pBean == null) {
			actionContext.put("Error", "员工编号不存在！");
			return SUCCESS;
		}
		// （3）将信息保存到数据库中
		pBean.setId(id);
		pBean.setEmployess_id(employess_id);
		pBean.setMatter(matter);
		pBean.setJiangjin(jiangjin);
		pBean.setFakuan(fakuan);

		boolean flag = pDao.updateJiangCheng(pBean);
		// （4）添加成功，返回成功，否则显示错误
		if (flag) {// 成功
			actionContext.put("Error", "操作成功！");
			return SUCCESS;
		} else {// 失败
			actionContext.put("Error", "【添加】有误！");
			return ERROR;
		}
	}

}
