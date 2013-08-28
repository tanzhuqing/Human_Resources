package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.bean.Employess_zhiwuBean;
import db.sqlDao.ZhiwuDao;

public class AddzhiwuKong extends ActionSupport{
private String optzhiwu;
private String zhiwuKong;


public String getZhiwuKong() {
	return zhiwuKong;
}

public void setZhiwuKong(String zhiwuKong) {
	this.zhiwuKong = zhiwuKong;
}

public String getOptzhiwu() {
	return optzhiwu;
}

public void setOptzhiwu(String optzhiwu) {
	this.optzhiwu = optzhiwu;
}

@Override
public String execute() throws Exception {
	ActionContext act = ActionContext.getContext();
	String zhiwuKong=this.getZhiwuKong();
	ZhiwuDao zhiwuDao = new ZhiwuDao();
	Employess_zhiwuBean bean=new Employess_zhiwuBean();
	bean=zhiwuDao.getzhiwuUserBeanById(zhiwuKong);
	if(bean!=null){
		act.put("Error", "该职务已存在");
		return ERROR;
	}else{
		Employess_zhiwuBean bean1=new Employess_zhiwuBean();
		bean1.setEmployess_job(zhiwuKong);
		bean1.setBumenid(Integer.parseInt(optzhiwu));
		boolean flag=zhiwuDao.addEmployee(bean1);
		if(flag){
			act.put("Error", "添加成功");
			return SUCCESS;
		}else{
			act.put("Error", "添加失败");
			return ERROR;
		}
	}
}

}
