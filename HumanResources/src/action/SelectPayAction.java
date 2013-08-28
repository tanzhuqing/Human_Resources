package action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.bean.Employess_prize_noteBean;
import db.sqlDao.Employess_prize_noteDao;

/**
 * 奖惩记录
 * 
 * @author 李石丰
 * 
 */
public class SelectPayAction extends ActionSupport {
	private String workID;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWorkID() {
		return workID;
	}

	public void setWorkID(String workID) {
		this.workID = workID;
	}

	public String execute() throws Exception {
		ActionContext ctx = ActionContext.getContext();
		String employess_id = this.getWorkID();
		Employess_prize_noteDao pDao = new Employess_prize_noteDao();
		String sql = "";
		if (employess_id != null && !employess_id.equals("")) {
			sql = "where employess_id='" + employess_id + "'";
		}
		if (name != null && !name.equals("")) {
			if ("".equals(sql)) {
				sql = "where employees_name='" + name + "'";
			} else {
				sql = sql + " and where employees_name='" + name + "'";
			}
		}
		if (sql.equals("")) {
			ctx.put("Error", "请输入信息后在进行查询");
			return ERROR;
		}
		ArrayList<Employess_prize_noteBean> pBean = pDao
				.getPrizeByemployee_id(sql);
		if (pBean.size() <= 0) {
			ctx.put("Error", "没有该员工或该员奖惩没有记录...");
			return ERROR;
		}

		ctx.put("pBeanList", pBean);
		return SUCCESS;
	}
}
