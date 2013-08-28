package action;

/**
 * 考勤考评管理
 * 田
 */
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.bean.Employees_InformationBean;
import db.bean.employessAssessBean;
import db.sqlDao.Employees_InformationDao;
import db.sqlDao.employessAssessSqlDao;

public class employessAssessAction extends ActionSupport {
	private String employess_id;
	private String employees_name;
	private String employees_sex;

	public String getEmployees_name() {
		return employees_name;
	}

	public void setEmployees_name(String employees_name) {
		this.employees_name = employees_name;
	}

	public String getEmployees_sex() {
		return employees_sex;
	}

	public void setEmployees_sex(String employees_sex) {
		this.employees_sex = employees_sex;
	}

	public String getEmployess_id() {
		return employess_id;
	}

	public void setEmployess_id(String employess_id) {
		this.employess_id = employess_id;
	}

	public String execute() throws Exception {
		String employess_id = this.getEmployess_id();
		String employees_name = this.getEmployees_name();
		String employees_sex = this.getEmployees_sex();
		ActionContext ctx = ActionContext.getContext();
		Employees_InformationDao dao = new Employees_InformationDao();
		ArrayList<Employees_InformationBean> employees_InformationList = dao
				.getEmployeesByWhereName();
		ctx.put("employees_InformationList", employees_InformationList);
		employessAssessSqlDao eznDao = new employessAssessSqlDao();
		ArrayList<employessAssessBean> al = new ArrayList<employessAssessBean>();
		String sql="";
		if(!"".equals(employess_id)){
			sql="where employess_id='"+employess_id+"'";
		}
		
		if(!"".equals(employees_name)){
			if("".equals(sql)){
				sql="where employees_name like '"+employees_name+"%'";
			}else{
				sql=sql+" and employees_name like '"+employees_name+"%'";
			}
		}
		if(!"=====请选择====".equals(employees_sex)){
			if("".equals(sql)){
				sql="where employees_sex='"+employees_sex+"'";
			}else{
				sql=sql+" and employees_sex='"+employees_sex+"'";
			}
		}
		if ("".equals(employees_name) && "".equals(employees_sex)) {
			sql = "order by id";
		}
		al = eznDao.getOperByWhereSql(sql);

		ctx.put("ArrayList", al);

		return SUCCESS;

	}
}
