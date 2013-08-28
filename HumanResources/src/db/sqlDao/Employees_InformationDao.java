package db.sqlDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBManager;
import db.bean.Employees_InformationBean;
import db.bean.Employess_Wage_NoteBean;
import db.bean.VZhiWuBean;

public class Employees_InformationDao {
	/**
	 * 添加员工信息
	 * 
	 * @param userBean
	 * @return
	 */
	public boolean addEI(Employees_InformationBean eiBean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO employees_information (id,employess_id,employees_name,employees_sex,employees_marriage,employees_city"
				+ ",employees_study,employees_politically,employees_identity,employees_mobile,employees_tel,employees_lashup_tel,employees_email"
				+ ",employees_professional,employess_jointime,elmployess_engtime,employees_photo,employees_status,employess_job) "
				+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			con.setAutoCommit(false);
			pstmt.setInt(1, eiBean.getId());// 操作员ID
			pstmt.setString(2, eiBean.getEmployess_id());// 操作员登录名
			pstmt.setString(3, eiBean.getEmployees_name());// 操作员姓名
			pstmt.setString(4, eiBean.getEmployees_sex());// 操作员密码
			pstmt.setString(5, eiBean.getEmployees_marriage());
			pstmt.setString(6, eiBean.getEmployees_city());
			pstmt.setString(7, eiBean.getEmployees_study());
			pstmt.setString(8, eiBean.getEmployees_politically());
			pstmt.setString(9, eiBean.getEmployees_identity());
			pstmt.setString(10, eiBean.getEmployees_mobile());
			pstmt.setString(11, eiBean.getEmployees_tel());
			pstmt.setString(12, eiBean.getEmployees_lashup_tel());
			pstmt.setString(13, eiBean.getEmployees_email());
			pstmt.setString(14, eiBean.getEmployees_professional());
			pstmt.setTimestamp(15, new java.sql.Timestamp(eiBean
					.getEmployess_jointime().getTime()));
			pstmt.setTimestamp(16, new java.sql.Timestamp(eiBean
					.getElmployess_engtime().getTime()));

			pstmt.setString(17, eiBean.getEmployees_photo());
			pstmt.setString(18, eiBean.getEmployees_status());
			pstmt.setString(19, eiBean.getEmployess_job());
			pstmt.execute();// 开始向数据库中插入数据
			con.commit();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 查询用户基本信息（根据自定义条件）
	 * 
	 * @param whereSql
	 * @return
	 */
	// 查询用户基本信息（根据自定义条件）
	public ArrayList<Employees_InformationBean> getEmployeesByWhere(
			String whereSql) {
		Employees_InformationBean bean = null;
		ArrayList<Employees_InformationBean> al = new ArrayList<Employees_InformationBean>();
		Connection conn = null;// 数据库连接对象
		// sql语句的装载器（可以带有参数）
		PreparedStatement stm = null;
		// 定义结果集对象
		ResultSet rs = null;
		String sql = "select * from employees_information " + whereSql;
		try {
			// （1）获取java与mysql数据库连接对象
			conn = DBManager.getConnection();
			// （2）将sql语句放入装载器中
			stm = conn.prepareStatement(sql);
			// （3）执行SQL语句
			rs = stm.executeQuery();
			// （4）从结果集中取出数据，放到javaBean中
			while (rs.next()) {
				bean = new Employees_InformationBean();
				bean.setEmployess_id(rs.getString("employess_id"));
				bean.setEmployees_name(rs.getString("employees_name"));
				bean.setEmployees_sex(rs.getString("employees_sex"));
				bean.setEmployees_marriage(rs.getString("employees_marriage"));
				bean.setEmployees_city(rs.getString("employees_city"));
				bean.setEmployees_study(rs.getString("employees_study"));
				bean.setEmployees_politically(rs
						.getString("employees_politically"));
				bean.setEmployees_identity(rs.getString("employees_identity"));
				bean.setEmployees_mobile(rs.getString("employees_mobile"));
				bean.setEmployees_tel(rs.getString("employees_tel"));
				bean.setEmployees_lashup_tel(rs
						.getString("employees_lashup_tel"));
				bean.setEmployees_email(rs.getString("employees_email"));
				bean.setEmployees_professional(rs
						.getString("employees_professional"));
				bean.setEmployess_jointime(rs.getDate("employess_jointime"));
				bean.setElmployess_engtime(rs.getDate("elmployess_engtime"));
				bean.setEmployees_photo(rs.getString("employees_photo"));
				bean.setEmployees_status(rs.getString("employees_status"));
				bean.setEmployess_job(rs.getString("employess_job"));
				al.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 最后必须进行关闭操作
			try {
				rs.close();
				stm.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return al;
	}

	/**
	 * 根据操作员序列号查询信息
	 * 
	 * @param employeeOID
	 * @return
	 */
	public Employees_InformationBean getUserBeanById(String employess_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Employees_InformationBean kBean = null;
		String sql = "select * from employees_information where employess_id=? ";
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, employess_id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				kBean = new Employees_InformationBean();
				kBean.setEmployess_id(rs.getString("employess_id"));
				kBean.setEmployees_name(rs.getString("employees_name"));
				kBean.setEmployees_sex(rs.getString("employees_sex"));
				kBean.setEmployees_marriage(rs.getString("employees_marriage"));
				kBean.setEmployees_city(rs.getString("employees_city"));
				kBean.setEmployees_study(rs.getString("employees_study"));
				kBean.setEmployees_politically(rs
						.getString("employees_politically"));
				kBean.setEmployees_identity(rs.getString("employees_identity"));
				kBean.setEmployees_mobile(rs.getString("employees_mobile"));
				kBean.setEmployees_tel(rs.getString("employees_tel"));
				kBean.setEmployees_lashup_tel(rs
						.getString("employees_lashup_tel"));
				kBean.setEmployees_email(rs.getString("employees_email"));
				kBean.setEmployees_professional(rs
						.getString("employees_professional"));
				kBean.setEmployess_jointime(rs.getDate("employess_jointime"));
				kBean.setElmployess_engtime(rs.getDate("elmployess_engtime"));
				kBean.setEmployees_photo(rs.getString("employees_photo"));
				kBean.setEmployees_status(rs.getString("employees_status"));
				kBean.setEmployess_job(rs.getString("employess_job"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return kBean;
	}

	public VZhiWuBean getUserBeanById1(String employess_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		VZhiWuBean kBean = null;
		String sql = "select * from vzhiwu where employess_id=? ";
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, employess_id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				kBean = new VZhiWuBean();
				kBean.setEmployess_id(rs.getString("employess_id"));
				kBean.setEmployees_name(rs.getString("employees_name"));
				kBean.setMoney(rs.getString("money"));
				kBean.setTime(rs.getDate("time"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return kBean;
	}

	// 修改操作员
	public boolean updateoper_PRIVById(Employees_InformationBean bean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE employees_information set employees_name=?, employees_sex=?, employees_marriage=?, employees_city=?, employees_study=?,"
				+ " employees_politically=?, employees_identity=?,"
				+ " employees_mobile=?, employees_tel=?, employees_lashup_tel=?, employees_email=?,"
				+ " employees_professional=?, employess_jointime=?,elmployess_engtime=?, employees_photo=?,employess_job=?  WHERE employess_id=?";
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			con.setAutoCommit(false);
			pstmt.setString(17, bean.getEmployess_id());// 用户ID
			pstmt.setString(1, bean.getEmployees_name());
			pstmt.setString(2, bean.getEmployees_sex());
			pstmt.setString(3, bean.getEmployees_marriage());
			pstmt.setString(4, bean.getEmployees_city());
			pstmt.setString(5, bean.getEmployees_study());
			pstmt.setString(6, bean.getEmployees_politically());
			pstmt.setString(7, bean.getEmployees_identity());
			pstmt.setString(8, bean.getEmployees_mobile());
			pstmt.setString(9, bean.getEmployees_tel());
			pstmt.setString(10, bean.getEmployees_lashup_tel());
			pstmt.setString(11, bean.getEmployees_email());
			pstmt.setString(12, bean.getEmployees_professional());
			pstmt.setTimestamp(13, new java.sql.Timestamp(bean
					.getEmployess_jointime().getTime()));
			pstmt.setTimestamp(14, new java.sql.Timestamp(bean
					.getElmployess_engtime().getTime()));
			pstmt.setString(15, bean.getEmployees_photo());
			pstmt.setString(16, bean.getEmployess_job());
			pstmt.executeUpdate();// 开始向数据库中更新数据
			con.commit();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 根据操作员ID修改操作员的状态
	 * 
	 * @param employeeState
	 *            操作员状态
	 * @param employeeOID
	 *            操作员ID
	 * @return
	 */
	public boolean updateEmployeeStateByNumber(String employees_status,
			String employess_id) {
		Connection conn = null;// 数据库连接对象
		// sql语句的装载器（可以带有参数）
		PreparedStatement stm = null;
		String sql = "update employees_information set employees_status=? where employess_id=?";
		try {
			// （1）获取数据库的连接
			conn = DBManager.getConnection();
			// （2）将sql语句放到装载器中
			stm = conn.prepareStatement(sql);
			// （3）使用数据库的事务：不自动提交
			conn.setAutoCommit(false);
			// （4）给参数进行赋值
			stm.setString(1, employees_status);
			stm.setString(2, employess_id);

			// （5）执行SQL语句
			// 开始向数据库中更新数据
			stm.executeUpdate();
			// （6）提交事务
			conn.commit();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			// 事务回滚
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return false;
		} finally {// 最后必须关闭操作
			try {
				stm.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 查询员工的模糊信息
	 * 
	 * @author 韩晶
	 * 
	 */
	/**
	 * 根据ID查询
	 * 
	 * @param employess_id
	 * @return
	 */

	/**
	 * 根据ID查询
	 * 
	 * @param employess_id
	 * @return
	 */
	public ArrayList<Employees_InformationBean> getMobileCardByWhereSql(
			String employess_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<Employees_InformationBean> al = new ArrayList<Employees_InformationBean>();
		Employees_InformationBean kBean = null;

		String sql = "select * from employees_information  where employess_id =?";
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, employess_id);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				kBean = new Employees_InformationBean();
				kBean.setId(rs.getInt("id"));
				kBean.setEmployess_id(rs.getString("employess_id"));
				kBean.setEmployees_name(rs.getString("employees_name"));
				kBean.setEmployees_sex(rs.getString("employees_sex"));
				kBean.setEmployees_marriage(rs.getString("employees_marriage"));
				kBean.setEmployees_city(rs.getString("employees_city"));
				kBean.setEmployees_study(rs.getString("employees_study"));
				kBean.setEmployees_politically(rs
						.getString("employees_politically"));
				kBean.setEmployees_identity(rs.getString("employees_identity"));
				kBean.setEmployees_mobile(rs.getString("employees_mobile"));
				kBean.setEmployees_tel(rs.getString("employees_tel"));
				kBean.setEmployees_lashup_tel(rs
						.getString("employees_lashup_tel"));
				kBean.setEmployees_email(rs.getString("employees_email"));
				kBean.setEmployees_professional(rs
						.getString("employees_professional"));
				kBean.setEmployess_jointime(rs.getDate("employess_jointime"));
				kBean.setElmployess_engtime(rs.getDate("elmployess_engtime"));
				kBean.setEmployees_photo(rs.getString("employees_photo"));
				kBean.setEmployees_status(rs.getString("employees_status"));
				al.add(kBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return al;
	}

	/**
	 * 查询语句
	 * 
	 * @param strSQL
	 * @return
	 */

	public ArrayList<Employees_InformationBean> getEmployees(String strSQL) {
		Employees_InformationBean kBean = null;
		ArrayList<Employees_InformationBean> al = new ArrayList<Employees_InformationBean>();
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		String sql = "select * from employees_information " + strSQL;
		try {
			conn = DBManager.getConnection();
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			while (rs.next()) {
				kBean = new Employees_InformationBean();
				kBean.setId(rs.getInt("id"));
				kBean.setEmployess_id(rs.getString("employess_id"));
				kBean.setEmployees_name(rs.getString("employees_name"));
				kBean.setEmployees_sex(rs.getString("employees_sex"));
				kBean.setEmployees_marriage(rs.getString("employees_marriage"));
				kBean.setEmployees_city(rs.getString("employees_city"));
				kBean.setEmployees_study(rs.getString("employees_study"));
				kBean.setEmployees_politically(rs
						.getString("employees_politically"));
				kBean.setEmployees_identity(rs.getString("employees_identity"));
				kBean.setEmployees_mobile(rs.getString("employees_mobile"));
				kBean.setEmployees_tel(rs.getString("employees_tel"));
				kBean.setEmployees_lashup_tel(rs
						.getString("employees_lashup_tel"));
				kBean.setEmployees_email(rs.getString("employees_email"));
				kBean.setEmployees_professional(rs
						.getString("employees_professional"));
				kBean.setEmployess_jointime(rs.getDate("employess_jointime"));
				kBean.setElmployess_engtime(rs.getDate("elmployess_engtime"));
				kBean.setEmployees_photo(rs.getString("employees_photo"));
				kBean.setEmployees_status(rs.getString("employees_status"));
				kBean.setEmployess_job(rs.getString("employess_job"));
				al.add(kBean);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stm.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return al;
	}

	/**
	 * 根据姓名查询
	 * 
	 * @param employees_name
	 * @return
	 */

	public ArrayList<Employees_InformationBean> getLikeBy(String employees_name) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<Employees_InformationBean> al = new ArrayList<Employees_InformationBean>();
		Employees_InformationBean kBean = null;

		String sql = "select * from employees_information  where  binary employees_name like  '%"
				+ employees_name + "%'";
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				kBean = new Employees_InformationBean();
				kBean.setId(rs.getInt("id"));
				kBean.setEmployess_id(rs.getString("employess_id"));
				kBean.setEmployees_name(rs.getString("employees_name"));
				kBean.setEmployees_sex(rs.getString("employees_sex"));
				kBean.setEmployees_marriage(rs.getString("employees_marriage"));
				kBean.setEmployees_city(rs.getString("employees_city"));
				kBean.setEmployees_study(rs.getString("employees_study"));
				kBean.setEmployees_politically(rs
						.getString("employees_politically"));
				kBean.setEmployees_identity(rs.getString("employees_identity"));
				kBean.setEmployees_mobile(rs.getString("employees_mobile"));
				kBean.setEmployees_tel(rs.getString("employees_tel"));
				kBean.setEmployees_lashup_tel(rs
						.getString("employees_lashup_tel"));
				kBean.setEmployees_email(rs.getString("employees_email"));
				kBean.setEmployees_professional(rs
						.getString("employees_professional"));
				kBean.setEmployess_jointime(rs.getDate("employess_jointime"));
				kBean.setElmployess_engtime(rs.getDate("elmployess_engtime"));
				kBean.setEmployees_photo(rs.getString("employees_photo"));
				kBean.setEmployees_status(rs.getString("employees_status"));
				al.add(kBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return al;
	}

	/**
	 * 根据性别查询
	 * 
	 * @param employees_sex
	 * @return
	 */
	public ArrayList<Employees_InformationBean> getLike(String employees_sex) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<Employees_InformationBean> al = new ArrayList<Employees_InformationBean>();
		Employees_InformationBean kBean = null;
		System.out.println("ss=" + employees_sex);
		String sql = "select * from employees_information  where  binary employees_sex like  '%"
				+ employees_sex + "%'";
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				kBean = new Employees_InformationBean();
				kBean.setId(rs.getInt("id"));
				kBean.setEmployess_id(rs.getString("employess_id"));
				kBean.setEmployees_name(rs.getString("employees_name"));
				kBean.setEmployees_sex(rs.getString("employees_sex"));
				kBean.setEmployees_marriage(rs.getString("employees_marriage"));
				kBean.setEmployees_city(rs.getString("employees_city"));
				kBean.setEmployees_study(rs.getString("employees_study"));
				kBean.setEmployees_politically(rs
						.getString("employees_politically"));
				kBean.setEmployees_identity(rs.getString("employees_identity"));
				kBean.setEmployees_mobile(rs.getString("employees_mobile"));
				kBean.setEmployees_tel(rs.getString("employees_tel"));
				kBean.setEmployees_lashup_tel(rs
						.getString("employees_lashup_tel"));
				kBean.setEmployees_email(rs.getString("employees_email"));
				kBean.setEmployees_professional(rs
						.getString("employees_professional"));
				kBean.setEmployess_jointime(rs.getDate("employess_jointime"));
				kBean.setElmployess_engtime(rs.getDate("elmployess_engtime"));
				kBean.setEmployees_photo(rs.getString("employees_photo"));
				kBean.setEmployees_status(rs.getString("employees_status"));
				al.add(kBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return al;
	}

	/**
	 * 根据学历查询
	 * 
	 * @param employees_study
	 * @return
	 */
	public ArrayList<Employees_InformationBean> getLiked(String employees_study) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<Employees_InformationBean> al = new ArrayList<Employees_InformationBean>();
		Employees_InformationBean kBean = null;
		System.out.println("ss=" + employees_study);
		String sql = "select * from employees_information  where  binary employees_study like  '%"
				+ employees_study + "%'";
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				kBean = new Employees_InformationBean();
				kBean.setId(rs.getInt("id"));
				kBean.setEmployess_id(rs.getString("employess_id"));
				kBean.setEmployees_name(rs.getString("employees_name"));
				kBean.setEmployees_sex(rs.getString("employees_sex"));
				kBean.setEmployees_marriage(rs.getString("employees_marriage"));
				kBean.setEmployees_city(rs.getString("employees_city"));
				kBean.setEmployees_study(rs.getString("employees_study"));
				kBean.setEmployees_politically(rs
						.getString("employees_politically"));
				kBean.setEmployees_identity(rs.getString("employees_identity"));
				kBean.setEmployees_mobile(rs.getString("employees_mobile"));
				kBean.setEmployees_tel(rs.getString("employees_tel"));
				kBean.setEmployees_lashup_tel(rs
						.getString("employees_lashup_tel"));
				kBean.setEmployees_email(rs.getString("employees_email"));
				kBean.setEmployees_professional(rs
						.getString("employees_professional"));
				kBean.setEmployess_jointime(rs.getDate("employess_jointime"));
				kBean.setElmployess_engtime(rs.getDate("elmployess_engtime"));
				kBean.setEmployees_photo(rs.getString("employees_photo"));
				kBean.setEmployees_status(rs.getString("employees_status"));
				al.add(kBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return al;
	}

	/**
	 * 根据政治面貌查询
	 * 
	 * @param employees_politically
	 * @return
	 */
	public ArrayList<Employees_InformationBean> getLikedd(
			String employees_politically) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<Employees_InformationBean> al = new ArrayList<Employees_InformationBean>();
		Employees_InformationBean kBean = null;
		System.out.println("ss=" + employees_politically);
		String sql = "select * from employees_information  where  binary employees_politically like  '%"
				+ employees_politically + "%'";
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				kBean = new Employees_InformationBean();
				kBean.setId(rs.getInt("id"));
				kBean.setEmployess_id(rs.getString("employess_id"));
				kBean.setEmployees_name(rs.getString("employees_name"));
				kBean.setEmployees_sex(rs.getString("employees_sex"));
				kBean.setEmployees_marriage(rs.getString("employees_marriage"));
				kBean.setEmployees_city(rs.getString("employees_city"));
				kBean.setEmployees_study(rs.getString("employees_study"));
				kBean.setEmployees_politically(rs
						.getString("employees_politically"));
				kBean.setEmployees_identity(rs.getString("employees_identity"));
				kBean.setEmployees_mobile(rs.getString("employees_mobile"));
				kBean.setEmployees_tel(rs.getString("employees_tel"));
				kBean.setEmployees_lashup_tel(rs
						.getString("employees_lashup_tel"));
				kBean.setEmployees_email(rs.getString("employees_email"));
				kBean.setEmployees_professional(rs
						.getString("employees_professional"));
				kBean.setEmployess_jointime(rs.getDate("employess_jointime"));
				kBean.setElmployess_engtime(rs.getDate("elmployess_engtime"));
				kBean.setEmployees_photo(rs.getString("employees_photo"));
				kBean.setEmployees_status(rs.getString("employees_status"));
				al.add(kBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return al;
	}

	/**
	 * 查询全部用户基本信息
	 * 
	 * @param whereSql
	 * @return
	 */
	// 查询用户基本信息（根据自定义条件）
	public ArrayList<Employees_InformationBean> getEmployeesByWhereName() {
		Employees_InformationBean bean = null;
		ArrayList<Employees_InformationBean> al = new ArrayList<Employees_InformationBean>();
		Connection conn = null;// 数据库连接对象
		// sql语句的装载器（可以带有参数）
		PreparedStatement stm = null;
		// 定义结果集对象
		ResultSet rs = null;
		String sql = "select * from employees_information ";
		try {
			// （1）获取java与mysql数据库连接对象
			conn = DBManager.getConnection();
			// （2）将sql语句放入装载器中
			stm = conn.prepareStatement(sql);
			// （3）执行SQL语句
			rs = stm.executeQuery();
			// （4）从结果集中取出数据，放到javaBean中
			while (rs.next()) {
				bean = new Employees_InformationBean();
				bean.setEmployess_id(rs.getString("employess_id"));
				bean.setEmployees_name(rs.getString("employees_name"));
				bean.setEmployees_sex(rs.getString("employees_sex"));
				bean.setEmployees_marriage(rs.getString("employees_marriage"));
				bean.setEmployees_city(rs.getString("employees_city"));
				bean.setEmployees_study(rs.getString("employees_study"));
				bean.setEmployees_politically(rs
						.getString("employees_politically"));
				bean.setEmployees_identity(rs.getString("employees_identity"));
				bean.setEmployees_mobile(rs.getString("employees_mobile"));
				bean.setEmployees_tel(rs.getString("employees_tel"));
				bean.setEmployees_lashup_tel(rs
						.getString("employees_lashup_tel"));
				bean.setEmployees_email(rs.getString("employees_email"));
				bean.setEmployees_professional(rs
						.getString("employees_professional"));
				bean.setEmployess_jointime(rs.getDate("employess_jointime"));
				bean.setElmployess_engtime(rs.getDate("elmployess_engtime"));
				bean.setEmployees_photo(rs.getString("employees_photo"));
				bean.setEmployees_status(rs.getString("employees_status"));

				al.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 最后必须进行关闭操作
			try {
				rs.close();
				stm.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return al;
	}

	/**
	 * 删除的那个是调薪的
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleteEmplotess(String id) {
		Connection conn = null;// 数据库连接对象��ݿ�l�Ӷ���
		// 执行sql语句的装载器（可以带有参数）�����Դ��в���
		PreparedStatement stm = null;
		String sql = "delete from employees_information where id=?";
		try {
			// 1获取java与mysql数据库接连对象��ȡjava��mysql��ݿ��l����
			conn = DBManager.getConnection();
			// 2开始装载sql语句��sql���
			stm = conn.prepareStatement(sql);
			// 3设置数据库的事务：不自动提交
			conn.setAutoCommit(false);
			// 4对sql语句中的参数进行设置��sql����еĲ����������
			stm.setString(1, id);
			// 5执行sql语句
			stm.execute();
			// 6提交事务����
			conn.commit();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			// 事务进行回滚
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			// 关闭操作��
			try {
				stm.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;

	}

	public ArrayList<Employess_Wage_NoteBean> getMobileCardByWhereSqltiaoxin(
			String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Employess_Wage_NoteBean> al = new ArrayList<Employess_Wage_NoteBean>();
		Employess_Wage_NoteBean tempBean = null;
		String sql = "select * from vzhiwu where id=?";
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				tempBean = new Employess_Wage_NoteBean();
				tempBean.setId(rs.getInt("id"));
				tempBean.setEmployess_id(rs.getString("employess_id"));
				tempBean.setMoney(rs.getString("money"));
				tempBean.setTime(rs.getDate("time"));

				al.add(tempBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return al;
	}

}
