package db.sqlDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBManager;
import db.bean.BuMenBean;
import db.bean.Employees_InformationBean;

public class BuMenDao {
	/**
	 * 添加方法
	 */

	public boolean addEmployee(BuMenBean buMenBean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO bumen (employees_professional)"
				+ " VALUES (?)";
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			con.setAutoCommit(false);
			// pstmt.setInt(1, super_employeesBean.getId());
			pstmt.setString(1, buMenBean.getEmployees_professional());// 操作员姓名
			pstmt.execute();// 开始向数据库中插入数据
			con.commit();

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
		return true;
	}

	/**
	 * 删除方法
	 */

	public boolean deleteUser(int id) {
		Connection conn = null;// 数据库连接对象��ݿ�l�Ӷ���
		// 执行sql语句的装载器（可以带有参数）�����Դ��в���
		PreparedStatement stm = null;
		String sql = "delete from bumen where id=?";
		try {
			// 1获取java与mysql数据库接连对象��ȡjava��mysql��ݿ��l����
			conn = DBManager.getConnection();
			// 2开始装载sql语句��sql���
			stm = conn.prepareStatement(sql);
			// 3设置数据库的事务：不自动提交
			conn.setAutoCommit(false);
			// 4对sql语句中的参数进行设置��sql����еĲ����������
			stm.setInt(1, id);
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

	public Employees_InformationBean getchaUserBeanById(
			int id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Employees_InformationBean kBean = null;
		String sql = "select * from employees_information where employees_professional=? ";
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
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
				kBean.setEmployess_job(rs.getString("employess_job"));
				kBean.setEmployess_jointime(rs.getDate("employess_jointime"));
				kBean.setElmployess_engtime(rs.getDate("elmployess_engtime"));
				kBean.setEmployees_photo(rs.getString("employees_photo"));
				kBean.setEmployees_status(rs.getString("employees_status"));

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

	public BuMenBean getcaUserBeanById(String employees_professional) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BuMenBean kBean = null;
		String sql = "select * from bumen where employees_professional=? ";
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, employees_professional);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				kBean = new BuMenBean();
				kBean.setEmployees_professional(rs
						.getString("employees_professional"));
				kBean.setId(rs.getInt("id"));
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
	public BuMenBean getcaUserBeanByIdKong(int id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BuMenBean kBean = null;
		String sql = "select * from bumen where id=? ";
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				kBean = new BuMenBean();
				kBean.setEmployees_professional(rs
						.getString("employees_professional"));
				kBean.setId(rs.getInt("id"));
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
	public ArrayList<BuMenBean> getAllBuMenByWhere() {
		BuMenBean bean = null;
		ArrayList<BuMenBean> al = new ArrayList<BuMenBean>();
		Connection conn = null;// 数据库连接对象
		// sql语句的装载器（可以带有参数）
		PreparedStatement stm = null;
		// 定义结果集对象
		ResultSet rs = null;
		String sql = "select * from bumen";
		try {
			// （1）获取java与mysql数据库连接对象
			conn = DBManager.getConnection();
			// （2）将sql语句放入装载器中
			stm = conn.prepareStatement(sql);
			// （3）执行SQL语句
			rs = stm.executeQuery();
			// （4）从结果集中取出数据，放到javaBean中
			while (rs.next()) {
				bean = new BuMenBean();
				bean.setId(rs.getInt("id"));
				bean.setEmployees_professional(rs
						.getString("employees_professional"));

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
	 * 获取部门
	 * @return
	 */
	public ArrayList<BuMenBean> getAllClass() {
		BuMenBean kBean = null;
		ArrayList<BuMenBean> al = new ArrayList<BuMenBean>();
		Connection conn = null;// 数据库连接对象
		// sql语句的装载器（可以带有参数）
		PreparedStatement stm = null;
		// 定义 结果集 对象
		ResultSet rs = null;
		String sql = "select * from bumen order by id";// order by
																	// 是排序
		try {
			// (1) 获取java与mysql数据库连接对象
			conn = DBManager.getConnection();
			// (2)将sql语句放入装载器中
			stm = conn.prepareStatement(sql);
			// (3)执行sql语句 的查询结果
			rs = stm.executeQuery();
			// 4.从结果集中取出数据放到Javabean 中
			// .next() 数据库打开是第一条记录 下一条
			while (rs.next()) {
				kBean = new BuMenBean();
				kBean.setId(rs.getInt("id"));
				kBean.setEmployees_professional(rs.getString("employees_professional"));
				
				al.add(kBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 最后必须进行关闭操作
			try {
				rs.close();
				stm.close();// 关闭装载器
				conn.close();// 关闭连接
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return al;
	}
}
