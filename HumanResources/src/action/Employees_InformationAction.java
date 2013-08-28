package action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import commonjava.CommonFunction;

import db.bean.Employees_InformationBean;
import db.bean.Employess_Wage_NoteBean;
import db.bean.Employess_Zhiwu_NoteBean;
import db.bean.Super_employeesBean;
import db.sqlDao.Employees_InformationDao;
import db.sqlDao.Employess_Wage_NoteDao;
import db.sqlDao.Employess_Zhiwu_NoteDao;

/**
 * 添加员工基本信息
 * 
 * @author Administrator
 * 
 */
public class Employees_InformationAction extends ActionSupport {
	static DateFormat f3 = new SimpleDateFormat("yyyy-MM-dd HHmmss");
	static DateFormat f1 = new SimpleDateFormat("yyyy-MM-dd");
	static DateFormat f2 = new SimpleDateFormat("yyyy-MM-dd");
	private String id;
	private String userName;
	private String sex;
	private String marriage;
	private String city;
	private String study;// 最高学历
	private String politically;// 政治面貌
	private String identity;// 身份证号
	private String money;
	private String mobile;
	private String tel;
	private String lashup_tel;
	private String email;
	private String jointime;
	private String professional;// 专业
	private String engtime;
	private String section;// 职务
	// 封装上传文件域的属性
	private File upload;
	// 封装上传文件类型的属性
	private String uploadContentType;
	// 封装上传文件名的属性
	private String uploadFileName;
	// 直接在struts.xml中配置的属性
	private String savePath;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getMarriage() {
		return marriage;
	}

	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStudy() {
		return study;
	}

	public void setStudy(String study) {
		this.study = study;
	}

	public String getPolitically() {
		return politically;
	}

	public void setPolitically(String politically) {
		this.politically = politically;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getLashup_tel() {
		return lashup_tel;
	}

	public void setLashup_tel(String lashup_tel) {
		this.lashup_tel = lashup_tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJointime() {
		return jointime;
	}

	public void setJointime(String jointime) {
		this.jointime = jointime;
	}

	public String getProfessional() {
		return professional;
	}

	public void setProfessional(String professional) {
		this.professional = professional;
	}

	public String getEngtime() {
		return engtime;
	}

	public void setEngtime(String engtime) {
		this.engtime = engtime;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getSavePath() {
		return ServletActionContext.getRequest().getRealPath(savePath);
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String execute() throws Exception {
		ActionContext actionContext = ActionContext.getContext();
		
		String id = this.getId();
		String userName = this.getUserName();
		String sex = this.getSex();
		String marriage = this.getMarriage();
		String city = this.getCity();
		String study = this.getStudy();
		String politically = this.getPolitically();
		String identity = this.getIdentity();
		String money = this.getMoney();
		String mobile = this.getMobile();
		String tel = this.getTel();
		String lashup_tel = this.getLashup_tel();
		String email = this.getEmail();
		String jointime = this.getJointime();
		String professional = this.getProfessional();
		String engtime = this.getEngtime();
		String section = this.getSection();
		actionContext.put("id", id);
		actionContext.put("userName", userName);
		actionContext.put("sex", sex);
		actionContext.put("marriage", marriage);
		actionContext.put("city", city);
		actionContext.put("study", study);
		actionContext.put("politically", politically);
		actionContext.put("identity", identity);
		actionContext.put("money", money);
		actionContext.put("mobile", mobile);
		actionContext.put("tel", tel);
		actionContext.put("lashup_tel", lashup_tel);
		actionContext.put("email", email);
		actionContext.put("professional", professional);
		actionContext.put("jointime", jointime);
		actionContext.put("engtime", engtime);
		actionContext.put("section", section);

		if ("".equals(id)) {
			actionContext.put("Error", "员工ID不能为空");
			return "error";
		}
		if ("".equals(userName)) {
			actionContext.put("Error", "员工姓名不能为空");
			return "error";
		}
		if ("".equals(sex)) {
			actionContext.put("Error", "性别不能为空");
			return "error";
		}
		if ("".equals(marriage)) {
			actionContext.put("Error", "婚姻状况不能为空");
			return "error";
		}
		
		if ("".equals(study)) {
			actionContext.put("Error", "最高学历不能为空");
			return "error";
		}
		
		if ("".equals(identity)) {
			actionContext.put("Error", "身份证号不能为空");
			return "error";
		}
		if ("".equals(money)) {
			actionContext.put("Error", "基本工资不能为空");
			return "error";
		} else {
			// 判断身份证号是否正确
			int flag = CommonFunction.checkCardID(identity);
			// 返回：＝0表示 正确
			// ＝1表示 身份证号码不是15位或18位
			// ＝2表示 身份证除最后一位外，必须为数字！
			// ＝3表示 身份证的出生日期不正确
			// ＝4表示 身份证号码输入错误
			if (flag != 0) {
				String str = "";
				if (flag == 1) {
					str = "【身份证号】不是15位或18位!";
				} else if (flag == 2) {
					str = "【身份证号】除最后一位外，必须为数字！";
				} else if (flag == 3) {
					str = "【身份证号】出生日期不正确！";
				} else if (flag == 4) {
					str = "【身份证号】输入有误！";
				}
				actionContext.put("Error", str);
				return "error";
			}
		}
		if ("".equals(professional)) {
			actionContext.put("Error", "专业不能为空");
			return "error";
		}
		if ("".equals(jointime)) {
			actionContext.put("Error", "入职时间不能为空");
			return "error";
		}
		if ("".equals(engtime)) {
			actionContext.put("Error", "截止时间不能为空");
			return "error";
		}
		if ("".equals(section)) {
			actionContext.put("Error", "职务不能为空");
			return "error";
		}

		// 使用字符串获取时间中年月日
		Date d1 = null;
		try {
			d1 = f1.parse(jointime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Date d2 = null;
		try {
			d2 = f1.parse(engtime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Employees_InformationBean eiBean = new Employees_InformationBean();
		Employess_Wage_NoteBean ewBean = new Employess_Wage_NoteBean();
		Employess_Zhiwu_NoteBean eznBean = new Employess_Zhiwu_NoteBean();
		Employees_InformationDao eiDao = new Employees_InformationDao();
		Employess_Wage_NoteDao ewnDao = new Employess_Wage_NoteDao();
		Employess_Zhiwu_NoteDao eznDao = new Employess_Zhiwu_NoteDao();

		ArrayList<Employees_InformationBean> al = eiDao
				.getEmployeesByWhere(" where employess_id='" + id + "'");
		if (al.size() > 0) {
			actionContext.put("Error", "员工编号已存在");

			return "error";
		}
		if (d1.getTime() > d2.getTime()) {
			actionContext.put("Error", "日期选择不正确");
			return "error";
		} else {
			eiBean.setEmployess_id(id);
			eiBean.setEmployees_name(userName);
			eiBean.setEmployees_sex(sex);
			eiBean.setEmployees_marriage(marriage);
			eiBean.setEmployees_city(city);
			eiBean.setEmployees_study(study);
			eiBean.setEmployees_politically(politically);
			eiBean.setEmployees_identity(identity);
			eiBean.setEmployees_mobile(mobile);
			eiBean.setEmployees_tel(tel);
			eiBean.setEmployees_lashup_tel(lashup_tel);
			eiBean.setEmployees_email(email);
			eiBean.setEmployees_professional(professional);
			eiBean.setEmployess_jointime(d1);
			eiBean.setElmployess_engtime(d2);
			eiBean.setEmployess_job(section);
			if (this.getUpload() != null) {
				File in = new File(getSavePath());
				if (!in.exists()) {
					in.mkdirs();
				}

				String uploadFileName = this.getUploadFileName();

				String s = uploadFileName.substring(uploadFileName
						.lastIndexOf(".") + 1);
				// 以服务器的文件保存地址和原文件名建立上传文件输出流
				String lujing = f3.format(new Date()) + "." + s;

				FileOutputStream fos = new FileOutputStream(getSavePath()
						+ "\\" + lujing);

				FileInputStream fis = new FileInputStream(getUpload());
				byte[] buffer = new byte[1024];
				int len = 0;
				while ((len = fis.read(buffer)) > 0) {// 输入流读取文件放到数组里,从左往右看
					fos.write(buffer, 0, len);// 从数组中的第一位写到输出流，从右往左看

				}

				eiBean.setEmployees_photo(lujing);

			}
			Super_employeesBean super_employeesBean=(Super_employeesBean)actionContext.getContext().getSession().get("user");
			eiBean.setEmployees_status("3");
			// 工资表
			ewBean.setEmployess_id(id);
			ewBean.setTime(new Date());
			ewBean.setMoney(money);
			ewBean.setUserid(super_employeesBean.getId());
			// 职务表
			eznBean.setEmployess_id(id);
			eznBean.setTime(new Date());
			eznBean.setEmployess_job(section);
			eiDao.addEI(eiBean);
			ewnDao.addWage(ewBean);
			eznDao.addZhiwu(eznBean);
			actionContext.put("SuccessOpt", "add");
		}

		actionContext.put("Error", "添加成功");
		return "success";
	}

}
