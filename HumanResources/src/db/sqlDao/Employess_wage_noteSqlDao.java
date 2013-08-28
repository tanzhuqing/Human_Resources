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

public class Employess_wage_noteSqlDao {
	/**
	 * 添加工资
	 * 
	 * @param employess_wage_noteBean
	 * @return
	 */
	public boolean addEmployee(Employess_Wage_NoteBean employess_wage_noteBean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO employess_wage_note (employess_id,time,money,state)"
				+ " values (?,?,?,?)";
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			con.setAutoCommit(false);
			// pstmt.setInt(1, employess_wage_noteBean.getId());
			pstmt.setString(1, employess_wage_noteBean.getEmployess_id());
			pstmt.setDate(2, new java.sql.Date(employess_wage_noteBean
					.getTime().getTime()));
			pstmt.setString(3, employess_wage_noteBean.getMoney());

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
	 * 查询工资，全查
	 * 
	 * @param whereSQL
	 *            sql条件语句
	 * @return
	 */
	public ArrayList<Employess_Wage_NoteBean> getOperByWhereSql(String whereSQL) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Employess_Wage_NoteBean> al = new ArrayList<Employess_Wage_NoteBean>();
		Employess_Wage_NoteBean employeeBean = null;
		String sql = "select * from employess_wage_note as A where id=(select max(id) from employess_wage_note "
				+ "where employess_wage_note.employess_id=A.employess_id)"
				+ whereSQL;
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				employeeBean = new Employess_Wage_NoteBean();

				employeeBean.setEmployess_id(rs.getString("employess_id"));

				employeeBean.setMoney(rs.getString("money"));
				;
				al.add(employeeBean);
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
	 * 查询工资根据ID
	 * 
	 * @param employess_id
	 * 
	 * @return
	 */
	public Employess_Wage_NoteBean getEmployeeByemployeeName(String employess_id) {
		Employess_Wage_NoteBean employeeBean = null;
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		String sql = "select * from employess_wage_note where employess_id= ?";
		try {
			conn = DBManager.getConnection();
			stm = conn.prepareStatement(sql);
			stm.setString(1, employess_id);
			rs = stm.executeQuery();
			while (rs.next()) {
				employeeBean = new Employess_Wage_NoteBean();
				employeeBean.setId(rs.getInt("id"));
				employeeBean.setEmployess_id(rs.getString("employess_id"));
				employeeBean.setTime(rs.getDate("time"));
				employeeBean.setMoney(rs.getString("money"));

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
		return employeeBean;
	}

	/**
	 * 查询调薪记录
	 * 
	 * @param employess_id
	 * @return
	 */
	public ArrayList<Employess_Wage_NoteBean> getPrizeByemployee_id(
			String employess_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Employess_Wage_NoteBean> al = new ArrayList<Employess_Wage_NoteBean>();
		Employess_Wage_NoteBean wBean = null;
		String sql = "select * from employess_wage_note where employess_id=?";
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, employess_id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				wBean = new Employess_Wage_NoteBean();
				wBean.setEmployess_id(rs.getString("employess_id"));
				al.add(wBean);
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
	 * 查询工资，全查
	 * 
	 * @param whereSQL
	 *            sql条件语句
	 * @return
	 */
	public ArrayList<Employess_Wage_NoteBean> getMoneyByWhereSql(String whereSQL) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<Employess_Wage_NoteBean> al = new ArrayList<Employess_Wage_NoteBean>();
		Employess_Wage_NoteBean employeeBean = null;

		String sql = "select * from employess_wage_note as A where id=(select max(id) from employess_wage_note where employess_wage_note.employess_id=A.employess_id)"
				+ whereSQL;
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				employeeBean = new Employess_Wage_NoteBean();
				employeeBean.setEmployess_id(rs.getString("employess_id"));
				employeeBean.setMoney(rs.getString("money"));
				employeeBean.setTime(rs.getDate("time"));
				al.add(employeeBean);
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

				bean.setEmployees_name(rs.getString("employees_name"));

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
	 * 根据指定的条件，业务员查询记录
	 * 
	 * @param whereSQL
	 * @return
	 */
	public ArrayList<VZhiWuBean> getOperWhereSql(String whereSQL) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<VZhiWuBean> al = new ArrayList<VZhiWuBean>();
		VZhiWuBean kBean = null;
		String sql = "select * from vzhiwu " + whereSQL;
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				kBean = new VZhiWuBean();
				kBean.setId(rs.getInt("id"));
				kBean.setEmployess_id(rs.getString("employess_id"));
				kBean.setTime(rs.getDate("time"));

				kBean.setEmployees_name(rs.getString("employees_name"));
				kBean.setMoney(rs.getString("money"));
				kBean.setUser(rs.getString("user"));
				kBean.setUserid(rs.getInt("userid"));
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
	 * 根据操作员序列号查询信息
	 * 
	 * @param employeeOID
	 * @return
	 */
	public VZhiWuBean getEmployessById(String employess_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		VZhiWuBean kBean = null;

		String sql = "select money from vzhiwu where id = (select max(id) from employess_zhiwu_note where employess_id=? )";
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, employess_id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				kBean = new VZhiWuBean();
				// kBean.setId(rs.getInt("id"));
				// kBean.setEmployess_id(rs.getString("employess_id"));
				// kBean.setTime(rs.getDate("time"));
				kBean.setMoney(rs.getString("money"));

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
}
