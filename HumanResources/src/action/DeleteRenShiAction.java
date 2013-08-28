package action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.bean.VRenShiBean;
import db.sqlDao.Employess_Zhiwu_NoteDao;
import db.sqlDao.VRenShiDao;

public class DeleteRenShiAction extends ActionSupport {
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String execute() throws Exception {
		ActionContext act = ActionContext.getContext();
		int id = this.getId();
		Employess_Zhiwu_NoteDao eznDao = new Employess_Zhiwu_NoteDao();
		
		boolean falg = eznDao.deleteRenShi(id);
		if (falg) {
			act.put("Error", "删除成功");
			return "success";
		}
		act.put("Error", "删除失败");
		return "success";
	}

}
